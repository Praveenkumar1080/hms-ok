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
public class UndergoesId implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Column(name="Patient")
@NotNull(message="Patient cannot be Empty")
private Integer patient;
@Column(name="Procedures")
@NotNull(message="Procedures cannot be Empty")
private Integer Procedures;
@Column(name="Stay")
@NotNull(message="Stay cannot be Empty")
private Integer stay;
@Column(name="Dateundergoes")
@NotNull(message="DateUndergoes cannot be Empty")
private Timestamp date;
}
