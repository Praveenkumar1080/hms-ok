package com.cg.hms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class Procedures {
	@Id
	@Column(name="Code")
	@NotNull(message="Code cannot be Empty")
	private int code;
	@Column(name="Name",columnDefinition = "VARCHAR(30)")
	@NotNull(message="Name cannot be Empty")
    private String name;
	@Column(name="Cost",columnDefinition = "int(10)")
	@NotNull(message="Cost cannot be Empty")
    private Float cost;
}
