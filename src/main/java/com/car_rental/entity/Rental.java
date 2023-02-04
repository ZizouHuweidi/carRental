package com.car_rental.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rentals")
public class Rental {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "cstId")
	private Long cstId;

	@Column(name = "carId")
	private Long carId;

	@Column(name = "startDate")
	private Date startDate;

	@Column(name = "endDate")
	private Date finishDate;

	public Rental() {

	}

	public Rental(Long cstId, Long carId, Date startDate, Date finishDate) {
		this.cstId = cstId;
		this.carId = carId;
		this.startDate = startDate;
		this.finishDate = finishDate;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCstId() {
		return cstId;
	}

	public void setCstId(Long cstId) {
		this.cstId = cstId;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

}
