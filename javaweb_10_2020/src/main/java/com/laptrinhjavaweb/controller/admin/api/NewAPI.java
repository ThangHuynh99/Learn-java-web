package com.laptrinhjavaweb.controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb1.utils.HttpUtil;
import com.laptrinhjavaweb1.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = { "/api-admin-new" })
public class NewAPI extends HttpServlet{
	@Inject
	private INewService newService;
	private static final long serialVersionUID = -8697814217340871651L;
	ObjectMapper mapper = new ObjectMapper();
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		//biding tu json request sang NewModel
//		NewModel newModel = HttpUtil.of(request.getReader()).toModel(NewModel.class); method 1
		NewModel newModel = mapper.readValue(HttpUtil.off(request.getReader()), NewModel.class);
		newModel.setCreatedBy(((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getUserName());
		newModel = newService.Save(newModel);			
		mapper.writeValue(response.getOutputStream(), newModel);
}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		//biding tu json request sang NewModel
		NewModel updateNew = HttpUtil.of(request.getReader()).toModel(NewModel.class);
		updateNew.setModifiedBy(((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getUserName());
		updateNew = newService.Update(updateNew);
		mapper.writeValue(response.getOutputStream(), updateNew);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		NewModel deleteNew = HttpUtil.of(request.getReader()).toModel(NewModel.class);
		newService.delete(deleteNew.getIds());
		mapper.writeValue(response.getOutputStream(), "{}");
	}
}