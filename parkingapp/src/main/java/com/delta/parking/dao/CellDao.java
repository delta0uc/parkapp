package com.delta.parking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.delta.parking.model.Cell;

public interface CellDao extends JpaRepository<Cell, Integer> {

	@Query("Select cellId from Cell where latitudeStart < ?1 AND latitudeEnd > ?1 AND longitudeStart < ?2 AND longitudeEnd > ?2")
	public int getCell(double latitude, double longitude);

}
