package org.shifang.usermanage.Interceptor;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.util.StringUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.shifang.usermanage.pojo.Result;
import org.shifang.usermanage.util.JwtUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url=request.getRequestURL().toString();
        log.info("请求的url:{}",url);
        if(url.contains("login")){
            return true;
        }
        String jwt=request.getHeader("token");
        if(StringUtil.isEmpty(jwt)){
            Result result=Result.error("NOT_LOGIN");
            String notLogin= JSONObject.toJSONString(result);
            response.getWriter().write(notLogin);
            log.info("token为空");
            return false;

        }
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            log.info("解析失败");
            Result result=Result.error("NOT_LOGIN");
            String notLogin= JSONObject.toJSONString(result);
            response.getWriter().write(notLogin);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
