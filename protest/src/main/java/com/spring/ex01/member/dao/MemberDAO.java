package com.spring.ex01.member.dao;

import com.spring.ex01.member.vo.MemberVO;
import java.util.List;
import org.springframework.dao.DataAccessException;

public interface MemberDAO {
	public List selectAllMemberList() throws DataAcessException;
	public int insertMember(MemberVO memberVO)throws DataAcessException;
	public int deleteMember(String id) throws DataAcessException;
	public MemberVO loginById(MemberVO memberVO) throws DataAcessException;
	

}
