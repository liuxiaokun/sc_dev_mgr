package com.lxk.mgr.controller.base;

import com.lxk.mgr.entity.base.BaseEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liuxiaokun
 * @version 1.0.0
 * @since 2022-09-23 15:59
 */
public class BaseController<T extends BaseEntity> {

    private static final Pattern SC_EXTRACTION = Pattern.compile("(?<field>[0-9a-zA-z]+)\\((?<sort>[0-9a-zA-z]+)\\)", 2);
    private static final int MAX_PAGE_SIZE = 1000;
    private static final String SEPARATOR = ",";

    protected T packAddBaseProps(T base, HttpServletRequest request) {
        Long currentLoginId = getUserId(request);
        base.setCreatedBy(currentLoginId);
        base.setCreatedByName("");
        base.setCreatedDate(LocalDateTime.now());
        base.setIp(getIp(request));
        byte status = 1;
        base.setStatus(status);

        return base;
    }

    protected T packModifyBaseProps(T base, HttpServletRequest request) {
        base.setModifiedBy(getUserId(request));
        base.setModifiedDate(LocalDateTime.now());
        base.setIp(getIp(request));
        return base;
    }

    public Long getUserId(HttpServletRequest request) {
        String jwt = request.getHeader("Authorization");

        Claims claims = Jwts.parser()
                .setSigningKey("mgr".getBytes())
                .parseClaimsJws(jwt.replace("Bearer ", ""))
                .getBody();
        return Long.parseLong(claims.getSubject());
    }

    protected int getIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ipToInt(ip);
    }

    private static int ipToInt(String ipStr) {
        String[] ip = ipStr.split("\\.");
        return (Integer.parseInt(ip[0]) << 24) + (Integer.parseInt(ip[1]) << 16) + (Integer.parseInt(ip[2]) << 8) + Integer.parseInt(ip[3]);
    }
}
