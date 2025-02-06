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
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class UpperCaseFilter extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = 1L;

	public UpperCaseFilter() {
        super();
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		StringUpperWrapper suw = new StringUpperWrapper((HttpServletRequest)request);
		chain.doFilter(suw, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
