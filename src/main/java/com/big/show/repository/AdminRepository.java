package com.big.show.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.big.show.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
