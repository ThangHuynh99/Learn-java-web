package com.laptrinhjavaweb.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.service.impl.NewService;
import com.laptrinhjavaweb1.utils.FormUtil;
import com.laptrinhjavaweb1.utils.SessionUtil;

@WebServlet(urlPatterns = { "/trang-chu", "/login", "/logout" })
public class HomeController extends HttpServlet {

	@Inject
	private ICategoryService categoryService;

	@Inject
	private INewService newService;

	@Inject
	private IUserService userService;
	private static final long serialVersionUID = 2686801510274002166L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String title = "Bai viet 6";
//		String content = "Bai viet 6";
//		Long categoryId = 1L;
//		NewModel newModel = new NewModel();
//		newModel.setTitle(title);
//		newModel.setContent(content);
//		newModel.setCategoryID(categoryId);
//		newService.Save(newModel);
//		request.setAttribute("news", newService.findByCategoryId(categoryId));
//		request.setAttribute("categories", categoryService.findAll());
//		UserModel userModel = new UserModel();
//		userModel.setFullName("xin chào Huỳnh Bá Thắng");
//		request.setAttribute("model", userModel);
		
		ResourceBundle mybundle = ResourceBundle.getBundle("message");
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			// lay tu get request.
			String message = request.getParameter("message");
			String alert = request.getParameter("alert");
			//gui thong bao toi client message = user_pass_invalid
			if(message != null && alert != null) {
				request.setAttribute("message", mybundle.getString(message));
				request.setAttribute("alert", alert);
			}
			RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
			rd.forward(request, response);
		} else if (action != null && action.equals("logout")) {
			SessionUtil.getInstance().deleteValue(request, "USERMODEL");
			response.sendRedirect(request.getContextPath() + "/trang-chu");
		} else {
			/*
			 * sitemesh decorator apply giao dien login o mot path bat dau bang /login nen
			 * khi access path /trang-chu?action=login se bi dinh header va footer cua web
			 */
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//check co ton tai post tu client ve controller k
		String action = request.getParameter("submit");
		if(action != null && action.equals("login")){
			//lay thong tin nguoi dung nhap vao tu trang login
			UserModel userModel = FormUtil.toModel(UserModel.class, request);
			//authentication (xac thuc nguoi dung co ton tai khong)
			userModel = userService.findByUserNameAndPassWordAndStatus(userModel.getUserName(), userModel.getPassWord(), 1);
			if(userModel != null) {
				SessionUtil.getInstance().pushValue(request, "USERMODEL", userModel);
				if(userModel.getRole().getCode().equals("USER")) {
					response.sendRedirect(request.getContextPath() + "/trang-chu");
				}else if(userModel.getRole().getCode().equals("ADMIN")) {
					response.sendRedirect(request.getContextPath() + "/admin-home");
				}
			} else {
				//gui get request de dua ra thong bao khi dang nhap that bai
				response.sendRedirect(request.getContextPath() + "/login?action=login&message=user_pass_invalid&alert=danger");
			}
		}
	}
}
