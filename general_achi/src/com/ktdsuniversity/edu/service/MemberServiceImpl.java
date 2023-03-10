package com.ktdsuniversity.edu.service;

import java.util.List;

import com.ktdsuniversity.edu.dao.MapMemberDAOImpl;
import com.ktdsuniversity.edu.dao.MemberDAO;
import com.ktdsuniversity.edu.vo.MemberVO;

public class MemberServiceImpl implements MemberService{

	private MemberDAO memberDAO;
	
	public MemberServiceImpl() {
		memberDAO = new MapMemberDAOImpl();
	}
	
	@Override
	public boolean create(MemberVO memberVO) {
		// TODO Auto-generated method stub
		System.out.println("SecondMemberServiceImpl.create");
		return memberDAO.create(memberVO)>0;
	}

	@Override
	public List<MemberVO> readAll() {
		// TODO Auto-generated method stub
		System.out.println("SecondMemberServiceImpl.readAll");
		return memberDAO.readAll();
	}

}
