package interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestInterceptor implements HandlerInterceptor {

    public boolean preHandler(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{

        User user=(User) request.getSession().getAttribute("USER_SESSION");
        String uri=request.getRequestURI();

        if(uri.indexOf("login")>=0||uri.indexOf("logout")>=0)
            return true;

        if(user!=null)
            return true;

        request.setAttribute("msg","您还没有登录，请先登录...");
        request.getRequestDispatcher("login").forward(request,response);
        return false;
    }
}
