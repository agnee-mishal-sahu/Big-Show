package com.big.show.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.big.show.entity.Venue;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Integer>{

}
