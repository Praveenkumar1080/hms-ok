package com.cg.hms.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="department")
public class Department {
@Id
@Column(name="DepartmentID")
@NotNull(message="DepartmentID cannot be Empty")
private int departmentId;
@Column(name="Name")
@NotNull(message="Name cannot be Empty")
@Size(min = 1,max = 30)
 private String name;
@ManyToOne
@JoinColumn(name="Head")
@NotNull(message="Head cannot be Empty")
private Physician head;
}
