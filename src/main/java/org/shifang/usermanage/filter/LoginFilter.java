package org.shifang.usermanage.filter;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.util.StringUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.shifang.usermanage.pojo.Result;
import org.shifang.usermanage.util.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
//@WebFilter("/*")
public class LoginFilter implements jakarta.servlet.Filter {
    private static final Logger log = LoggerFactory.getLogger(LoginFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String url=request.getRequestURL().toString();
        log.info("请求的url:{}",url);
        if(url.contains("login")){
            filterChain.doFilter(request,response);
            return;
        }
        String jwt=request.getHeader("token");
        if(StringUtil.isEmpty(jwt)){
            Result result=Result.error("Login Error");
            String notLogin= JSONObject.toJSONString(result);
            response.getWriter().write(notLogin);
            log.info("token为空");
            return;

        }
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析失败");
            Result result=Result.error("Login Error");
            String notLogin= JSONObject.toJSONString(result);
            response.getWriter().write(notLogin);
            return;
        }
        filterChain.doFilter(request,response);
    }
}
