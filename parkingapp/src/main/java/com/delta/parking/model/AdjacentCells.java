package com.delta.parking.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AdjacentCells {

	@Id
	@GeneratedValue
	private int id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cell_id", nullable = false)
	private Cell cell;
	
	private int adjacentCellId;
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getAdjacentCellId() {
		return adjacentCellId;
	}
	public void setAdjacentCellId(int adjacentCellId) {
		this.adjacentCellId = adjacentCellId;
	}
	public Cell getCell() {
		return cell;
	}
	public void setCell(Cell cell) {
		this.cell = cell;
	}

}
