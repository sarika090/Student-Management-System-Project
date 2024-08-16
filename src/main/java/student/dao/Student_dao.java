package student.dao;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import student.bo.AddStudentInfo_bo;
import student.bo.StudentSignup_bo;

public class Student_dao {
	
	public static Connection getConnection() {
		
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management","root","sarika");
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return con;
		
	}
	
	public static boolean userLogin(String email, String pass) {
		boolean status = false;
		
		try {
			
			Connection con =Student_dao.getConnection();
			String sql="select * from signup where email=? And password=?";
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			status=rs.next();
		} catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	
	public static int signup(StudentSignup_bo ss) {
		int status = 0;
		
		try {
			Connection con = Student_dao.getConnection();
			String sql = "insert into signup(name,email,phone,password) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ss.getName());
			ps.setString(2, ss.getEmail());
			ps.setString(3, ss.getPhone());
			ps.setString(4, ss.getPass());
			
			status = ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return status;
		
	}
	
	
	
	
	public static int AddStudentInfo(AddStudentInfo_bo si) {
		int status =0;
		
		try {
			
			Connection con =Student_dao.getConnection();
			String query = "insert into studentinfo(name, email,age,city,gender) values(?,?,?,?,?)";
			PreparedStatement ps =con.prepareStatement(query);
			
			ps.setString(1, si.getName());
			ps.setString(2, si.getEmail());
			ps.setString(3, si.getAge());
			ps.setString(4, si.getCity());
			ps.setString(5, si.getGender());
			
			status = ps.executeUpdate();
			 
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}

	
	

	public static List<AddStudentInfo_bo> getAllStudentInfo() {
		
		List list= new ArrayList();
		
		try {
			
			Connection con =Student_dao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from studentinfo");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				AddStudentInfo_bo si= new AddStudentInfo_bo();
				
				si.setId(rs.getInt(1));
				si.setName(rs.getString(2));
				si.setEmail(rs.getString(3));
				si.setAge(rs.getString(4));
				si.setCity(rs.getString(5));
				si.setGender(rs.getString(6));
				
				list.add(si);
			}
			
		} catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	
	
	
	public static AddStudentInfo_bo getMemberById(int id) {
		AddStudentInfo_bo si= new AddStudentInfo_bo();
		try {
			 Connection con = Student_dao.getConnection();
			   String query="select * from studentinfo where id=?";
			   
			   PreparedStatement ps=con.prepareStatement(query);
			   ps.setInt(1, id);
			   
			   ResultSet rs=ps.executeQuery();
			   
			   if(rs.next()) {
				   si.setId(rs.getInt(1));
				   si.setName(rs.getString(2));
				   si.setEmail(rs.getString(3));
				   si.setAge(rs.getString(4));
				   si.setCity(rs.getString(5));
				   si.setGender(rs.getString(6));  
			   }
			  
			   
		} catch(Exception e) {
			System.out.println(e);
		}
		return si;
	}
	

	
	
	public static int Update(AddStudentInfo_bo si) {
            int status = 0;
		
		try {
			
			Connection con=Student_dao.getConnection();
			
			String query="update studentinfo set name=?, email=?,age=?,city=?,gender=? where id=?";
			PreparedStatement ps=con.prepareStatement(query);
			
		     ps.setString(1, si.getName());
		     ps.setString(2, si.getEmail());
		     ps.setString(3, si.getAge());
		     ps.setString(4, si.getCity());
		     ps.setString(5, si.getGender());
		     ps.setInt(6, si.getId());
		     
			status = ps.executeUpdate();
			
		} catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}


	public static int Delete(int id) {
		int status=0;
		
		try {
			
			Connection con= Student_dao.getConnection();
			String query="Delete from studentinfo where id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, id);
			status=ps.executeUpdate();
			
		} catch (Exception e) {
		System.out.println(e);
		}
		return status;
		
	}

	
}


