package sec03.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactroy;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactroy = (DataSource)envContext.lookup("jdbc/servletex");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MemberVo> listMember() {
		List<MemberVo> membersList = new ArrayList();
		try {
			con = dataFactroy.getConnection();
			String query = "select * from t_member order by joinDate desc";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVo memberVo = new MemberVo(id,pwd,name,email,joinDate);
				membersList.add(memberVo);
					
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return membersList;
	}
	public void addMember(MemberVo m) {
		try {
			con = dataFactroy.getConnection();
			String id =m.getId();
			String pwd =m.getPwd();
			String name =m.getName();
			String email =m.getEmail();
			String query ="INSERT INTO t_member(id,pwd,name,email)" + "VALUES(?,?,?,?)";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public MemberVo findMember(String _id) {
		MemberVo memInfo = null;
		try {
			con = dataFactroy.getConnection();
			String query = "select * from t_member where id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, _id);
			System.out.println(query);
			ResultSet rs =pstmt.executeQuery();
			rs.next();
			String id = rs.getString("id");
			String pwd = rs.getString("pwd");
			String name = rs.getString("name");
			String email = rs.getString("email");
			Date joinDate = rs.getDate("joinDate");
			memInfo = new MemberVo(id,pwd,name,email,joinDate);
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return memInfo;
	}
	public void modMember(MemberVo memberVo) {
		String id = memberVo.getId();
		String pwd = memberVo.getPwd();
		String name = memberVo.getName();
		String email = memberVo.getEmail();
		try {
			con = dataFactroy.getConnection();
			String query = "update t_member set pwd=?, name=?, email=? where id=?";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, pwd);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, id);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void delMember(String id) {
		try{
			con = dataFactroy.getConnection();
			String query = "delete from t_member where id=?";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	}


