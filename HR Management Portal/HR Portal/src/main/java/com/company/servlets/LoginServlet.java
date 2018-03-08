package com.company.servlets;

import java.io.IOException;

import javax.naming.NamingEnumeration;
import javax.naming.directory.SearchResult;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.ldap.LDAPConnection;
import com.company.ldap.UserDetails;
import com.company.model.AuthentcationModel;
import com.company.model.Employee;
import com.company.service.EmployeeService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor. 
	 */
	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*System.out.println("2^^^^666login nservelt");
		PrintWriter pw=response.getWriter();
		pw.write("here servlet");*/
		throw new ServletException("Get is not allowed");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(request.getParameter("userId")+","+ request.getParameter("passwd"));
		JsonParser parser=new JsonParser();
		JsonObject obj = (JsonObject) parser.parse(request.getReader());
		System.out.println("obj is::"+obj.get("username").toString()+obj.get("password").toString());
		UserDetails user=new UserDetails(obj.get("username").toString().replaceAll("\"", ""),obj.get("password").toString().replaceAll("\"", ""));
		boolean loginResult=LDAPConnection.authenticate(user);
		if(!loginResult){
			System.out.println("Authentcation Failure");
			response.setContentType("application/json");
			AuthentcationModel exce=new AuthentcationModel("Authentication Failure");
			String json=new Gson().toJson(exce);
			response.getWriter().write(json);
			response.getWriter().flush();
		}else{
			//pw.write("Success");
			NamingEnumeration<SearchResult> employeeDetails=LDAPConnection.searchResult(user);
			Employee employee=EmployeeService.getEmployeeDetails(employeeDetails);
			response.setContentType("application/json");
			String json=new Gson().toJson(employee);
			response.getWriter().write(json);
			response.getWriter().flush();			
		}
		LDAPConnection.close();
	}

}
