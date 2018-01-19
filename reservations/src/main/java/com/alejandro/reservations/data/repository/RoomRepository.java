package com.alejandro.reservations.data.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alejandro.reservations.data.entity.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long>{
    List<Room> findByBedInfo(String bedInfo);
    
 
}
