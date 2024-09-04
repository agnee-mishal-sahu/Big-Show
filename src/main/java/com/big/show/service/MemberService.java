package com.big.show.service;

import com.big.show.dto.MemberDto;
import com.big.show.dto.MemberResponseDto;
import com.big.show.entity.Member;
import com.big.show.exception.MemberException;

public interface MemberService {
	
	MemberResponseDto signUpUser(Member memberDto) throws MemberException;
	String updateProfile(MemberDto memberDto,Integer userId) throws MemberException;
	MemberDto getMemberById(Integer userId) throws MemberException;
	String deleteMember(Integer userId) throws MemberException;
}
