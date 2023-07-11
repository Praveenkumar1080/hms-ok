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
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Medication {
	
@Id
@Column(name="Code")
@NotNull(message="Code cannot be Empty")
private Integer code;
@Column(name="Name")
@NotNull(message="Name cannot be Empty")
@Size(min = 1,max = 30)
private String name;
@Column(name="Brand")
@NotNull(message="Brand cannot be Empty")
@Size(min = 1,max = 30)
private String brand;
@Column(name="Description")
@NotNull(message="Description cannot be Empty")
@Size(min = 1,max = 30)
private String description;

}
