package com.cg.hms.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="affiliated_with")
public class Affiliatedwith {

	@EmbeddedId
	private AffId id;
	@ManyToOne
	@MapsId("Physician")
	@JoinColumn(name="Physician")
	@NotNull(message="Physician cannot be Empty")
	private Physician physician;
	@ManyToOne
	@MapsId("Department")
	@JoinColumn(name="Department")
	@NotNull(message="Department cannot be Empty")
	private Department department;
	@Column(name="PrimaryAffiliation")
	@NotNull(message="PrimaryAffiliation cannot be empty")
	private Boolean primaryAffiliation;
	
}
