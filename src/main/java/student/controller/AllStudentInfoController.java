package student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.bo.AddStudentInfo_bo;
import student.dao.Student_dao;



/**
 * Servlet implementation class AllStudentInfoController
 */
@WebServlet("/AllStudentInfoController")
public class AllStudentInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllStudentInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();	
		
		pw.print("<link rel='stylesheet' href='css/allstudentinfo.css'>");

		
		String cssTag="<link rel='stylesheet' type='text/css' href='css/table.css'>";
		
		pw.print("<html>");
		
		pw.println("<head><title>Title Name</title>"+cssTag+"</head>");
		
		pw.print("<body>");
		
		pw.print("<a href='home.html'>Back</a>");
		
		pw.print("<table border='1px' width='100%'>");
		
		pw.print("<tr> <th>Id</th> <th>Name</th> <th>Email</th> <th>Age</th> <th>City</th> <th>Gender</th> <th>Actions</th><th>Delete</th></tr>");
		
		List<AddStudentInfo_bo> list=Student_dao.getAllStudentInfo();
		
		for(AddStudentInfo_bo st:list) {
		
		pw.print("<tr> <td>"+st.getId()+"</td> <td>"+st.getName()+"</td><td>"+st.getEmail()+"</td><td>"+st.getAge()+"</td><td>"+st.getCity()+"</td> <td>"+st.getGender()+"</td> <td>"+"<a href='EditServlet?id="+st.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+st.getId()+"'>delete</a></td></tr>");

           }
		pw.print("</table>");
	    pw.print("</body>");
			
		pw.print("</html>");
		
	}


	}

