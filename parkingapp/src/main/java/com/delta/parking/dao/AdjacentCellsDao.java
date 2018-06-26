package com.delta.parking.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.delta.parking.model.AdjacentCells;

public interface AdjacentCellsDao extends JpaRepository<AdjacentCells, Integer> {
	
	@Query("Select adjacentCellId from AdjacentCells where cell_id = ?1")
	public List<Integer> findNeighbors(int cellId);
}
