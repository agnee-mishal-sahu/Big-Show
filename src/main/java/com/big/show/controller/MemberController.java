package com.big.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.big.show.entity.Member;
import com.big.show.exception.MemberException;
import com.big.show.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService memberService;

	@PostMapping("/signup")
	ResponseEntity<?> signUpUser(@RequestBody Member member) throws MemberException {

		return new ResponseEntity<>(memberService.signUpUser(member), HttpStatus.CREATED);
	}
}
