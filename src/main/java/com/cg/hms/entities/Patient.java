package com.cg.hms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @Column(name="SSN")
    @NotNull(message="SSN cannot be Empty")
	private int ssn;
    @Column(name="Name",columnDefinition = "VARCHAR(30)")
    @NotNull(message="Name cannot be Empty")
    @Size(min = 1,max = 30)
	private String name;
    @Column(name="Address",columnDefinition = "VARCHAR(30)")
    @NotNull(message="Address cannot be Empty")
    @Size(min = 1,max = 30)
	private String address;
    @Column(name="Phone",columnDefinition = "VARCHAR(30)")
    @NotNull(message="Phone cannot be Empty")
    @Size(min = 1,max = 30)
	private String phone;
    @Column(name="InsuranceID")
    @NotNull(message="InsuranceID cannot be Empty")
	private int insuranceId;
    @ManyToOne
    @JoinColumn(name="PCP")
    @NotNull(message="PCP cannot be Empty")
	private Physician pcp;
	
	
}
