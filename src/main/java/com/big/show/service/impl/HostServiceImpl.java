package com.big.show.service.impl;

import org.springframework.stereotype.Service;

import com.big.show.dto.HostDto;
import com.big.show.dto.HostResponseDto;
import com.big.show.dto.MemberDto;
import com.big.show.entity.Host;
import com.big.show.exception.HostException;
import com.big.show.service.HostService;

@Service
public class HostServiceImpl implements HostService{

	@Override
	public HostResponseDto signUpHost(Host host) throws HostException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateProfile(HostDto hostDto, Integer userId) throws HostException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDto getHostById(Integer userId) throws HostException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteHost(Integer userId) throws HostException {
		// TODO Auto-generated method stub
		return null;
	}

}
