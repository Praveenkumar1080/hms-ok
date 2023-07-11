package com.cg.hms.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Undergoes {
@EmbeddedId
private UndergoesId id;
@ManyToOne
@MapsId("Patient")
@JoinColumn(name="Patient")
@NotNull(message="Patient cannot be Empty")
private Patient patient;

@ManyToOne
@MapsId("Procedures")
@JoinColumn(name="Procedures")
@NotNull(message="Procedures cannot be Empty")
private Procedures Procedures;

@ManyToOne
@MapsId("Stay")
@JoinColumn(name="Stay")
@NotNull(message="Stay cannot be Empty")
private Stay stay;

@ManyToOne
@MapsId("Physician")
@JoinColumn(name="Physician")
@NotNull(message="Physician cannot be Empty")
private Physician Physician;

@ManyToOne
@JoinColumn(name="AssistingNurse")
private Nurse assistingnurse;

}
