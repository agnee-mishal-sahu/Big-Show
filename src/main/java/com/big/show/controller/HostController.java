package com.big.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.big.show.dto.HostDto;
import com.big.show.entity.Host;
import com.big.show.exception.HostException;
import com.big.show.service.HostService;

@RestController
@RequestMapping("/host")
public class HostController {
	
	@Autowired
	HostService hostService;

	@PostMapping("/signup")
	ResponseEntity<?> signUpUser(@RequestBody Host host) throws HostException {
		return new ResponseEntity<>(hostService.signUpHost(host), HttpStatus.CREATED);
	}

	@PutMapping("/update/{userid}")
	ResponseEntity<?> updateProfile(@RequestBody HostDto hostDto, @PathVariable Integer userid) throws HostException {
		return new ResponseEntity<>(hostService.updateProfile(hostDto, userid), HttpStatus.OK);
	}

	@GetMapping("/{userid}")
	ResponseEntity<?> getHostById(@PathVariable Integer userid) throws HostException {
		return new ResponseEntity<>(hostService.getHostById(userid), HttpStatus.OK);
	}

	@DeleteMapping("/{userid}")
	ResponseEntity<?> deleteHost(@PathVariable Integer userid) throws HostException {
		return new ResponseEntity<>(hostService.deleteHost(userid), HttpStatus.OK);
	}
}
