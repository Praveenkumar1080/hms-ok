package com.cg.hms.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Prescribes {
    @EmbeddedId
    private PrescribesId id;
    @ManyToOne
    @MapsId("physician")
    @JoinColumn(name="physician")
	private Physician physician;
    
    @ManyToOne
    @MapsId("patient")
    @JoinColumn(name="Patient")
    @NotNull(message="Patient cannot be Empty")
	private Patient patient;
    
    @ManyToOne
    @MapsId("medication")
    @JoinColumn(name="Medication")
    @NotNull(message="Medication cannot be Empty")
	private Medication medication;
    
    @Column(name="Dose",columnDefinition = "VARCHAR(30)")
    @NotNull(message="Dose cannot be Empty")
    @Size(min = 1,max = 30)
	private String Dose;
    
    @ManyToOne
    @MapsId("appointment")
    @JoinColumn(name="Appointment")
    @NotNull(message="Appointment cannot be Empty")
	private Appointment appointment;
	
}
