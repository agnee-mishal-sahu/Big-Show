package com.big.show.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.big.show.entity.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer>{

}
