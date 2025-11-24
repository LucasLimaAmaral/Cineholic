package com.cineholic.spotlight.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cineholic.spotlight.entities.Session;

public interface SessionRepository extends JpaRepository<Session, Long>{
	
	public List<Session> findByMovie_id(Long id);
	
	@Query(value = """
			SELECT COUNT(*) > 0
			FROM session s
			INNER JOIN movie m ON s.movie_id = m.id
			WHERE s.room_id = :roomId
			AND :newStart < DATEADD(MINUTE, (m.duration + 30), s.moment)
			AND :newEnd > s.moment
			""", nativeQuery = true)
	boolean hasConflict(@Param("roomId") Long roomId, 
			@Param("newStart") LocalDateTime newStart, 
			@Param("newEnd") LocalDateTime newEnd);
}
