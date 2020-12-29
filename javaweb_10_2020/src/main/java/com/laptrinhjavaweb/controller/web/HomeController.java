package com.laptrinhjavaweb.controller.web;

import java.io.IOException;

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
import com.laptrinhjavaweb.service.impl.NewService;

@WebServlet(urlPatterns = { "/trang-chu" })
public class HomeController extends HttpServlet {
	
	@Inject
	private ICategoryService categoryService;
	
	@Inject
	private INewService newService;
	
	
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
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
