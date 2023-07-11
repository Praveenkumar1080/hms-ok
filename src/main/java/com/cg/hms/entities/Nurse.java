package com.cg.hms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Nurse {
	@Id
	@Column(name="EmployeeID")
	@NotNull(message="EmployeeID cannot be Empty")
	private int employeeId;
	@Column(name="Name")
	@NotNull(message="Name cannot be Empty")
	@Size(min = 1,max = 30)
    private String name;
	@Column(name="Position")
	@Size(min = 1,max = 30)
	@NotNull(message="Position cannot be Empty")
    private String position;
	@Column(name="Registered",columnDefinition = "BIT")
	@NotNull(message="Registered cannot be Empty")
    private boolean registered;
	@Column(name="SSN")
	@NotNull(message="SSN cannot be Empty")
    private int ssn;

}
