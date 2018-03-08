package com.company.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.company.excel.ExcelHelper;
import com.company.ldap.UserDetails;
import com.company.model.Training;
import com.google.gson.Gson;

/**
 * Servlet implementation class TrainingServlet
 */
public class TrainingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrainingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Trainig srvlet get");
		JSONObject jsonObj=new JSONObject();
		ExcelHelper excelHelper=new ExcelHelper();
		String excelFilePath="D:/Trainings/Training Calendar 2017.xlsx";
		List<Training> trainingList=excelHelper.readBooksFromExcelFile(excelFilePath);
		response.setContentType("application/json");
		
		String json=new Gson().toJson(trainingList);
		System.out.println("json::"+json);
		response.getWriter().write(json.toString());
		response.getWriter().flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Trainig srvlet post");
	}

}
