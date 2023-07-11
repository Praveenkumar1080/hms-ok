package com.cg.hms.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Stay {
	
	@Id
	@Column(name="StayID")
	@NotNull(message="StayID cannot be Empty")
	private int stayId;
	@ManyToOne
	@JoinColumn(name="Patient")
	@NotNull(message="Patient cannot be Empty")
    private Patient patient;
	@ManyToOne
	@JoinColumn(name="Room")
	@NotNull(message="Room cannot be Empty")
    private Room room;
	@Column(name="StayStart",columnDefinition = "DATETIME")
	@NotNull(message="StayStart cannot be Empty")
    private Timestamp startTime;
	@Column(name="StayEnd",columnDefinition = "DATETIME")
	@NotNull(message="StayEndcannot be Empty")
    private Timestamp endTime;

}
