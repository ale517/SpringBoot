package com.alejandro.reservations.data.repository;


import org.springframework.data.repository.PagingAndSortingRepository;


import org.springframework.stereotype.Repository;

import com.alejandro.reservations.data.entity.Guest;

@Repository
public interface GuestRepository extends PagingAndSortingRepository<Guest, Long> {

}