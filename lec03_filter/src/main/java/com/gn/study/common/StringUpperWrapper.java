package com.gn.study.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class StringUpperWrapper extends HttpServletRequestWrapper{

	public StringUpperWrapper(HttpServletRequest request) {
		super(request);
	}

}
