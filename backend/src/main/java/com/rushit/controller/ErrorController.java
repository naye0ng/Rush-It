package com.rushit.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

@Component
public class ErrorController extends DefaultErrorAttributes {
	
	@Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
		Map<String, Object> result = super.getErrorAttributes(webRequest, includeStackTrace);
        Map<String, Object> Container = new HashMap<>();
        
        Container.put("error", result.get("error"));
        Container.put("path", result.get("path"));        
        
        if((result.get("trace") + "").contains("MissingServletRequestParameterException")) {
        	Container.put("code", 401);
        	Container.put("message", result.get("message") + "(파라미터 부족)");
        }
        else if((result.get("trace") + "").contains("SQLIntegrityConstraintViolationException")) {
        	Container.put("code", 402);
        	Container.put("message", result.get("message") + "(무결성 제약조건 위배)");
        }
        else if((result.get("trace") + "").contains("PersistenceException")) {
        	Container.put("code", 500);
        	Container.put("message", result.get("message") + "(DB 설정 문제)");
        }
        else if((result.get("trace") + "").contains("ReflectionException")) {
        	Container.put("code", 500);
        	Container.put("message", result.get("message") + "(MyBatis 문제)");
        }
        else {
        	Container.put("message", result.get("message"));
        	Container.put("code", result.get("status"));
        }
        return Container;
        //return result;
    }
}
