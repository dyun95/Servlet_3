package com.iu.member;

import com.iu.point.PointDAO;

public class MemberService {
	
	private MemberDAO memberDAO;

	public MemberService() {
		this.memberDAO = new MemberDAO();
	}
	
	//1. insert 회원가입
	public int memberJoin(MemberDTO memberDTO) throws Exception{
		
	int result = memberDAO.memberJoin(memberDTO);
		
	return result;
		
	}
	//2 로그인
	public MemberDTO memberLogin(MemberDTO memberDTO)throws Exception{
		return memberDAO.memberLogin(memberDTO);
		
	}
	//delete
	public int memberDelete(MemberDTO memberDTO) throws Exception{
		return memberDAO.memberDelete(memberDTO);
		
	}
	
	
	//update
	public int memberUpdate(MemberDTO memberDTO)throws Exception{
		return memberDAO.memberUpdate(memberDTO);
				
	}
	
	
	
	
}
