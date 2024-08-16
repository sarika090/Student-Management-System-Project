package student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.bo.AddStudentInfo_bo;
import student.dao.Student_dao;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		pw.print("<link rel='stylesheet' href='css/edit.css'>");
		
		String id = request.getParameter("id");
		int sid = Integer.parseInt(id);
		
		AddStudentInfo_bo si = Student_dao.getMemberById(sid);
		
		pw.print("<html>");
		
		pw.print("<body>");
		
		pw.print("<form action='UpdateController' method='Get'>");
		
		pw.print("<table>");
		
		pw.print("<tr><td><input type='hidden' name='id' value='"+si.getId()+"'/></td></tr>");
		pw.print("<tr><td>Name: </td> <td><input type='text' name='name' id='na' value='"+si.getName()+"'/></td></tr>");
		pw.print("<tr><td>Email: </td> <td><input type='text' name='email' id='na' value='"+si.getEmail()+"'/></td></tr>");
		pw.print("<tr><td>Age: </td> <td><input type='text' name='age' id='na' value='"+si.getAge()+"'/></td></tr>");
		pw.print("<tr><td>City: </td> <td><input type='text' name='city' id='na' value='"+si.getCity()+"'/></td></tr>");
		pw.print("<tr><td>Gender: </td> <td><input type='text' name='gender' id='na' value='"+si.getGender()+"'/></td></tr>");

        pw.print("<tr><td><input type='submit' id='btn' value='Update'/></td></tr>");
        
        pw.print("</table>");
        
        pw.print("</form>");
        
        pw.print("</body>");
        
        pw.print("</html>");
	}

}
