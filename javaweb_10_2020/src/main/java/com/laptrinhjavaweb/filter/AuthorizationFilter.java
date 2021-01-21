package com.laptrinhjavaweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.utils.SessionUtil;

public class AuthorizationFilter implements Filter {
	private ServletContext context;

	// set filter
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
	}

	//
	@Override
	public void doFilter(ServletRequest Srequest, ServletResponse Sresponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) Srequest;
		HttpServletResponse response = (HttpServletResponse) Sresponse;
		// lay duoc link hien hien dang truy cap vao.
		String url = request.getRequestURI();
		if (url.startsWith("/admin")) {
			UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
			if (userModel != null) {
				if (userModel.getRole().getCode().equals(SystemConstant.ADMIN)) {
					chain.doFilter(Srequest, Sresponse);
				} else if (userModel.getRole().getCode().equals(SystemConstant.USER)) {
					response.sendRedirect(
							request.getContextPath() + "/login?action=login&message=not_permission&alert=danger");
				}
			} else {
				response.sendRedirect(request.getContextPath() + "/login?action=login&message=not_login&alert=danger");
			}

		} else {
			// cho user thong qua thoai mai
			chain.doFilter(Srequest, Sresponse);
		}
	}
	
	 

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
