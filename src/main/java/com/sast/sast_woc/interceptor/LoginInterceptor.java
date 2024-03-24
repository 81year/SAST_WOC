package com.sast.sast_woc.interceptor;
import com.alibaba.fastjson2.JSONObject;
import com.sast.sast_woc.pojo.response.Response;
import com.sast.sast_woc.util.LoginJwt;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String jwt = request.getHeader("Token");
        String url = request.getRequestURL().toString();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        boolean flag = false;
        if(!StringUtils.hasLength(jwt)){
            Response error = Response.error();
            String notlogin = JSONObject.toJSONString(error);
            response.getWriter().write(notlogin);
            return false;
        }

        try{
            LoginJwt.parseJwt(jwt);
        }catch (Exception e){
            Response error = Response.error();
            String notlogin = JSONObject.toJSONString(error);
            response.getWriter().write(notlogin);
            return false;
        }

        if("DELETE".equals(request.getMethod())) {
            if(LoginJwt.parseJwt(jwt).get("role",Integer.class)!=1){
                Response error = Response.error();
                String notlogin = JSONObject.toJSONString(error);
                response.getWriter().write(notlogin);
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
