package com.onlinegasbooking.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity

public class SurrenderCylinder {

	@Id
	@GeneratedValue
	private Integer surrenderId;

	@Column(name = "surrender_date")
	private LocalDate surrenderDate;

	public SurrenderCylinder() {
		super();
	}

	public SurrenderCylinder(Integer surrenderId, LocalDate surrenderDate) {
		super();
		this.surrenderId = surrenderId;
		this.surrenderDate = surrenderDate;

	}

	public Integer getSurrenderId() {
		return surrenderId;
	}

	public void setSurrenderId(Integer surrenderId) {
		this.surrenderId = surrenderId;
	}

	public LocalDate getSurrenderDate() {
		return surrenderDate;
	}

	public void setSurrenderDate(LocalDate surrenderDate) {
		this.surrenderDate = surrenderDate;
	}

}
