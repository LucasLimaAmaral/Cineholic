package com.cineholic.spotlight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cineholic.spotlight.entities.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{
	
	@Query(value = """
			SELECT COUNT(*) > 0
			FROM room r
			WHERE r.number = :numberRoom
			""", nativeQuery = true)
	boolean existByNumber(@Param("numberRoom") String numberRoom);
}
