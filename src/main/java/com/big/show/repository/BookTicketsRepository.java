package com.big.show.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.big.show.entity.BookTickets;

@Repository
public interface BookTicketsRepository extends JpaRepository<BookTickets, Integer>{

}
