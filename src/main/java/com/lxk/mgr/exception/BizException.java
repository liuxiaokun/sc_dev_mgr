package com.lxk.mgr.exception;

/**
 * @author liuxiaokun
 * @version 0.0.1
 * @since 2022年9月24日 14点21分
 */
public class BizException extends Exception {

    public BizException(){
    }

    public BizException(String message){
        super(message);
    }
}