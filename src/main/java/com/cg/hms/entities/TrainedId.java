package com.cg.hms.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Embeddable

public class TrainedId implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Column(name="Physician")
@NotNull(message="Physician cannot be Empty")
private Integer physician;
@Column(name="Treatment")
@NotNull(message="Treatment cannot be Empty")
private Integer treatment;
public TrainedId() {
	super();
	// TODO Auto-generated constructor stub
}
public Integer getPhysician() {
	return physician;
}
public void setPhysician(Integer physician) {
	this.physician = physician;
}
public Integer getTreatment() {
	return treatment;
}
public void setTreatment(Integer treatment) {
	this.treatment = treatment;
}

}
