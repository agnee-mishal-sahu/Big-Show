package com.big.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.big.show.entity.Address;
import com.big.show.repository.AddressRepository;
import com.big.show.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addressRepository;

	@Override
	public void saveAddress(Address address) {

		addressRepository.save(address);

	}

	@Override
	public Address getAddress(Integer addressId) {

		return addressRepository.findById(addressId).get();
	}

	@Override
	public void deleteAddress(Address address) {

		addressRepository.delete(address);
	}

}
