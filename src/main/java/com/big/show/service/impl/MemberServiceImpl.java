package com.big.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.big.show.constants.ValidationConstants;
import com.big.show.dto.MemberDto;
import com.big.show.dto.MemberResponseDto;
import com.big.show.entity.Member;
import com.big.show.enums.UserRole;
import com.big.show.exception.MemberException;
import com.big.show.repository.AddressRepository;
import com.big.show.repository.MemberRepository;
import com.big.show.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	AddressRepository addressRepository;

	@Override
	public MemberResponseDto signUpUser(Member member) throws MemberException {

		MemberResponseDto memberResponseDto = new MemberResponseDto();
		Member memberEntity = new Member();

		if (member != null) {
			if (validateMember(member)) {

				member.setRole(UserRole.Member);

				if (member.getAddress() != null) {
					addressRepository.save(member.getAddress());
				}
				memberEntity = memberRepository.save(member);

				memberResponseDto.setUserId(memberEntity.getUserId());
				memberResponseDto.setUserName(memberEntity.getUserName());
				memberResponseDto.setRole(memberEntity.getRole());
				memberResponseDto.setStatus("Success");
			}
		} else {
			memberResponseDto.setStatus("Failed");
		}

		return memberResponseDto;
	}

	@Override
	public String updateProfile(MemberDto memberDto, Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDto getMemberById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteMember(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	private boolean validateMember(Member member) throws MemberException {
		String emailRegex = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
		String phoneRegex = "^\\d{10}$";

		if (member.getUserName().isBlank() || member.getPassword().isBlank()) {
			throw new MemberException(ValidationConstants.INCOMPLETE_DATA);
		}
		if (!member.getEmail().matches(emailRegex)) {
			throw new MemberException(ValidationConstants.INVALID_EMAIL);
		}
		if (!member.getPhone().matches(phoneRegex)) {
			throw new MemberException(ValidationConstants.INVALID_PHONE);
		}
		if (memberRepository.findByUserName(member.getUserName()).isPresent()) {
			throw new MemberException(ValidationConstants.USERNAME_EXISTS);
		}
		return true;
	}

}
