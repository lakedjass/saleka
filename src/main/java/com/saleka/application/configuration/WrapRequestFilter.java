//package com.saleka.application.configuration;
//
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class WrapRequestFilter extends OncePerRequestFilter {
//
//    private static final String[] PATHS = new String[] { "/admin", "/blog" };
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        ServletContextFacadeRequestWrapper wrapper = new ServletContextFacadeRequestWrapper(request);
//        String path = getMatchingContextPathForRequest(request);
//        if (path != null) {
//            String ContextnewPath = request.getContextPath();
//            String ServletnewPath = request.getServletPath();
//            String requestUri = request.getRequestURI();
//            wrapper.setServletPath(request.getServletPath().substring(path.length()));
////            System.out.println(newPath);
////            if (newPath.length() == 0) {
////                newPath = "/";
////            }
//
//            wrapper.setContextPath("/");
//        }
//        filterChain.doFilter(wrapper, response);
//    }
//
//    public String getMatchingContextPathForRequest(HttpServletRequest request) {
//        for (String path : PATHS) {
//            String servletPath = request.getServletPath();
//            if (request.getServletPath().startsWith(path)) {
//                return path;
//            }
//        }
//        return null;
//    }
//
//}
