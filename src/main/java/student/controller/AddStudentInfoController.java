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
 * Servlet implementation class AddStudentInfoController
 */
@WebServlet("/AddStudentInfoController")
public class AddStudentInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddStudentInfoController() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
	
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String age = request.getParameter("age");
		String city = request.getParameter("city");
        String gender = request.getParameter("gender");
       // pw.print(name+" "+email+" "+age+" "+city+" "+gender);
        AddStudentInfo_bo si=new AddStudentInfo_bo(name, email,age,city, gender );
        int status = Student_dao.AddStudentInfo(si);
     
        
        if(status>0) {
       	pw.print("Your data has been successfully added");
        	 RequestDispatcher rd = request.getRequestDispatcher("home.html");
        	 rd.forward(request, response);
          }
         else {
        	RequestDispatcher rd = request.getRequestDispatcher("AddStudentInfoController");
        	rd.include(request, response);
        	pw.print("Something went wrong");
         }

	}

}
