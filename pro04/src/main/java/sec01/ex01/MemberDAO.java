package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
 private static final String driver ="org.mariadb.jdbc.Driver";
 private static final String url ="jdbc:mariadb://localhost:3306/servletex";
 private static final String user ="root";
 private static final String pwd ="1234";
 private Connection con;
 private Statement stmt;
 //preparedStatement pstmt; 미리 만들어놓고 추가된 값만 연결 훨씬 속도가 빠름 
 
 public List<MemberVO> listMembers() {
	 List<MemberVO> list = new ArrayList<MemberVO>();
	 try {
		  connDB();
		  String query = "select * from t_member";
		  System.out.println(query);
		  ResultSet rs = stmt.executeQuery(query);
		  while (rs.next()) {
			  String id = rs.getString("id");
			  String pwd = rs.getString("pwd");
			  String name = rs.getString("name");
			  String email = rs.getString("email");
			  Date joinDate = rs.getDate("joinDate");
			  MemberVO vo = new MemberVO();
			  vo.setId(id);
			  vo.setPwd(pwd);
			  vo.setName(name);
			  vo.setEmail(email);
			  vo.setJoinDate(joinDate);
			  list.add(vo);
		  }
		  rs.close();
		  stmt.close();
		  con.close();
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	 return list;	 
 }
 private void connDB() {
	 try {
		 Class.forName(driver);
		 System.out.println("mariadb 드라이버 로딩 성공");
		 con = DriverManager.getConnection(url,user,pwd);
		 System.out.println("connection 생성 성공");
		 stmt = con.createStatement();
		 System.out.println("Statement 생성 성공");
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
 }
}
