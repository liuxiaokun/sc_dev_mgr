package com.lxk.mgr.config;

import com.alibaba.fastjson.JSONObject;
import com.lxk.mgr.controller.base.CodeEnum;
import com.lxk.mgr.controller.base.RO;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author liuxiaokun
 * @since 2022-09-28 09:43:56
 */
public class ShiroFormAuthenticationFilter extends FormAuthenticationFilter {

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletResponse resp = (HttpServletResponse) response;
		resp.setContentType("application/json; charset=utf-8");
		PrintWriter out = resp.getWriter();

		out.write(JSONObject.toJSONString(RO.fail(CodeEnum.UNAUTHORIZED.getCode(),
				CodeEnum.UNAUTHORIZED.getDesc())));
		out.flush();
		out.close();
		return false;
	}
}