package sec01.ex03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CalculatorDAO {
	private static final String driver = "org.mariadb.jdbc.Driver";
	private static final String url ="jdbc:mariadb://localhost:3306/servletex";
	private static final String user = "root";
	private static final String pwd = "1234";
	private Connection con;
	private PreparedStatement pstmt;
	
	public List listNumbers() {
		List list = new ArrayList();
		try {
			connDB();
			String query = "select * from t_number";
			System.out.println("prepareStatement : " + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int num1 = rs.getInt("num1");
				String mark = rs.getString("mark");
				int num2 = rs.getInt("num2");
				int answer = rs.getInt("answer");
				CalculatorBean vo = new CalculatorBean();
				vo.setNum1(num1);
				vo.setMark(mark);
				vo.setNum2(num2);
				vo.setAnswer(answer);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void addNumber(CalculatorBean calculatorBean) {
		try {
			connDB();
			int num1 = calculatorBean.getNum1();
			String mark = calculatorBean.getMark();
			int num2 = calculatorBean.getNum2();
			int answer = calculatorBean.getAnswer();
			String query = "insert into t_number";
			query +=" (num1,mark,num2,answer)";
			query +=" values(?,?,?,?)";
			System.out.println("prepareStatement : " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num1);
			pstmt.setString(2, mark);
			pstmt.setInt(3, num2);
			pstmt.setInt(4, answer);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("마리아DB 드라이버 로딩 성공");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connetion 생성 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}