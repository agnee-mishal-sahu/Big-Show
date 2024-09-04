package com.big.show.service;

import com.big.show.entity.Address;

public interface AddressService {

	void saveAddress(Address address);

	Address getAddress(Integer addressId);

	void deleteAddress(Address address);

}
