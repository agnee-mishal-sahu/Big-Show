package com.big.show.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.big.show.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>{

	Optional<Member> findByUserName(String userName);

}
