package com.auctionspace.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.auctionspace.controller.ManageUsersController;

public class SessionUtil extends HandlerInterceptorAdapter{
	
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
            HttpSession session = request.getSession();
        //if (!(((HandlerMethod)handler).getBean() instanceof ManageUsersController)) {
            if (session == null || session.getAttribute("userId") == null) {
                throw new Exception("Invalid session please login");
                //response.sendRedirect("Users/login");
            }
        //}
        return true;
    }

}
