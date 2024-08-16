package student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.bo.AddStudentInfo_bo;
import student.dao.Student_dao;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw= response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String age = request.getParameter("age");
		String city = request.getParameter("city");
		String gender = request.getParameter("gender");
		
		AddStudentInfo_bo si = new AddStudentInfo_bo();
		si.setId(id);
		si.setName(name);
		si.setEmail(email);
		si.setAge(age);
		si.setCity(city);
		si.setGender(gender);
		
		int status = Student_dao.Update(si);
		
		if(status>0) {
			RequestDispatcher rd = request.getRequestDispatcher("AllStudentInfoController");
			rd.forward(request, response);
		}
		
	}

}
