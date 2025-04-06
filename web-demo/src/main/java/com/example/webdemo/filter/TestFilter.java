/*
package com.example.webdemo.filter;

import cn.hutool.http.HttpUtil;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@Component
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        if (request.getMethod().equals("GET")) {
            Map<String, String> stringStringMap = HttpUtil.decodeParamMap(request.getQueryString(), Charset.forName(request.getCharacterEncoding()));
            System.out.println(stringStringMap);
        }
        if (((HttpServletRequest) servletRequest).getMethod().equals("POST")) {
            Map<String, String> ParameterMap = new HashMap<String, String>(); //map参数
            Map<String, String[]> map = request.getParameterMap(); //请求中的map数组
            for (String key : map.keySet()) { //遍历数组
                StringBuffer stringBuffer = new StringBuffer();
                for (String value : map.get(key)) {
                    stringBuffer.append(value);
                }
                ParameterMap.put(key, stringBuffer.toString()); //将值key，key对应的的value 赋值到map参数中
                System.out.println(ParameterMap);
            }
            System.out.println(ParameterMap);
        }

    }

    @Override
    public void destroy() {

    }
}
*/
