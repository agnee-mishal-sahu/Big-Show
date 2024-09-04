package com.big.show.service;

import com.big.show.dto.HostDto;
import com.big.show.dto.HostResponseDto;
import com.big.show.dto.MemberDto;
import com.big.show.entity.Host;
import com.big.show.exception.HostException;

public interface HostService {

	HostResponseDto signUpHost(Host host) throws HostException;

	String updateProfile(HostDto hostDto, Integer userId) throws HostException;

	MemberDto getHostById(Integer userId) throws HostException;

	String deleteHost(Integer userId) throws HostException;
}
