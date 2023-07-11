package com.cg.hms.entities;

import java.io.Serializable;

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
public class AffId implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
@Column(name="Physician")
@NotNull(message="Physician cannot be Empty")
private Integer Physician;
@Column(name="Department")
@NotNull(message="Department cannot be Empty")
private Integer Department;
}
