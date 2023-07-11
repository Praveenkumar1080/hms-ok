package com.cg.hms.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Physician {
@Id
@Column(name="EmployeeID")
@JsonProperty("employeeID")
private Integer employeeId;
@Column(name="Name",columnDefinition = "VARCHAR(30)")
@NotNull(message="Name cannot be Empty")
@Size(min = 1,max = 30)
private String name;
@Column(name="Position",columnDefinition = "VARCHAR(30)")
@NotNull(message="Position cannot be Empty")
@Size(min = 1,max = 30)
private String position;
@Column(name="SSN")
@NotNull(message="SSN cannot be Empty")
private int ssn;

}
