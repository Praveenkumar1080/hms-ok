package com.cg.hms.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="trained_in")
public class TrainedIn {
	
	@EmbeddedId
	private TrainedId id;
	
	@ManyToOne
	@MapsId("physician")
	@JoinColumn(name="Physician")
	@NotNull(message="Physician cannot be Empty")
	private Physician physician;
	
	@ManyToOne
	@MapsId("treatment")
	@JoinColumn(name="Treatment")
	@NotNull(message="Treatment cannot be Empty")
    private Procedures treatment;
	@Column(name="CertificationDate",columnDefinition = "DATETIME")
	@NotNull(message="CertificationDate cannot be Empty")
    private String certificationDate;
	@Column(name="CertificationExpires",columnDefinition = "DATETIME")
	@NotNull(message="CertificationExpires cannot be Empty")
    private String certificationExpires;

}
