package com.big.show.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.big.show.entity.Host;

@Repository
public interface HostRepository extends JpaRepository<Host, Integer>{

	Optional<Host> findByUserName(String userName);

}
