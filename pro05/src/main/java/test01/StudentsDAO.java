
package test01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class StudentsDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public StudentsDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource)envContext.lookup("jdbc/servletex");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List liststudents() {
		List studentslist = new ArrayList();
		try {
			con = dataFactory.getConnection();
			String query = "select * from t_students";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String id = rs.getString("id");
				String username = rs.getString("username");
				String univ = rs.getString("univ");
	            String birth = rs.getString("birth");
	        	String email  = rs.getString("email");
				StudentsVO studentsVO = new StudentsVO(id,username,univ,email,birth);
				studentslist.add(studentsVO);
					
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return studentslist;
	}
	public void addstudents(StudentsVO m) {
		try {
			con = dataFactory.getConnection();
			String username =m.getUsername();
			String univ =m.getUniv();
			String email =m.getEmail();
			String birth = m.getBirth();
			String query ="INSERT INTO t_students(username,univ,email,birth)" + "VALUES(?,?,?,?)";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, univ);
			pstmt.setString(3, email);
			pstmt.setString(4, birth);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


}
