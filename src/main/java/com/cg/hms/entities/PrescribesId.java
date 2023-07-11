package com.cg.hms.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class PrescribesId implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Column(name="Physician")
@NotNull(message="Physician cannot be Empty")
private Integer physician;
@Column(name="Patient")
@NotNull(message="Patient cannot be Empty")
private Integer patient;
@Column(name="Medication")
@NotNull(message="Medication cannot be Empty")
private Integer Medication;
@Column(name="Date",columnDefinition = "DATETIME")
@NotNull(message="Date cannot be Empty")
private Timestamp date;
}
