package com.gn.study.common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter(servletNames = "receiveDataServlet")
public class DataFilter extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = 1L;

	public DataFilter() {
        super();
        System.out.println("[DataFilter]생성자 호출됨");
    }

    public void init(FilterConfig fConfig) throws ServletException {
    	System.out.println("[DataFilter]필터 초기화");
    }
    

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("[DataFilter]요청 가로챔");
		chain.doFilter(request, response);
		System.out.println("[DataFilter]응답 가로챔");
	}

	public void destroy() {
		System.out.println("[DataFilter]필터 종료");
	}

}
