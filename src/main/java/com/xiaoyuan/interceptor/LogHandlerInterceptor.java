package com.xiaoyuan.interceptor;

import com.xiaoyuan.respository.TmOperationLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogHandlerInterceptor implements HandlerInterceptor {
    @Autowired
    private TmOperationLogRepository tmOperationLogRepository;
    /**
     * controller 执行之前调用
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String requestURI = null;
        requestURI = request.getRequestURI();
//        requestURI = request.getRequestURI().replaceAll("\\/\\/", "/");
        //过滤后缀,直接跳过
//        for (String suffix : m_suffixs) {
//            if (requestURI.endsWith("." + suffix)) {
//                return super.preHandle(httpServletRequest, httpServletResponse, handler);
//            }
//        }
        if(requestURI.indexOf("weixin")>=0){
            return true;
        }
//        if(requestURI.indexOf("wx")>=0){
//            return true;
//        }
        boolean flag = false;
        //不在登录页面
        if(requestURI.indexOf("login")<=0){
            //说明处在编辑的页面
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");
            session.setMaxInactiveInterval(30*60);//以秒为单位，即在没有活动30分钟后，session将失效
            if(username!=null||requestURI.indexOf("weixin")>0){
                //登陆成功的用户
//                TmOperationLog tmOperationLog = new TmOperationLog();
//                tmOperationLog.setLogindate(DateUtil.getNowDates());
//                tmOperationLog.setUsername(username);
//                tmOperationLogRepository.save(tmOperationLog);
                flag=true;



            }else{
                //没有登陆，转向登陆界面
                response.sendRedirect(request.getContextPath()+"/init/login");
                flag=false;
            }
        }else{
            flag=true;
        }
        return flag;
    }

    /**
     * controller 执行之后，且页面渲染之前调用
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
//        System.out.println("------postHandle-----");
    }

    /**
     * 页面渲染之后调用，一般用于资源清理操作
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
//        System.out.println("------afterCompletion-----");

    }

}