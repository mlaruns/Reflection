package com.ciber.ajax;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ciber.beans.User;
import com.ciber.dao.DaoFactory;
import com.google.gson.Gson;

public class SearchController extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json");
		try {
			String query = request.getParameter("term");
			System.out.println("Data from ajax call " + query);
			List<User> names=DaoFactory.getUpdateManagerInfoDAO().getManagerName(query);
			System.out.println(names);
			String searchList = new Gson().toJson(names);
			System.out.println(searchList);
			response.getWriter().write(searchList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
