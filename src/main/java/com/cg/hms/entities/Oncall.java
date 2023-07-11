package com.cg.hms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
@Table(name="on_call")
public class Oncall {
@Id
@Column(name="Nurse")
@NotNull(message="Nurse cannot be Empty")
private int nurse;
@ManyToOne
@JoinColumns ({
    @JoinColumn(name="BlockFloor", referencedColumnName = "BlockFloor"),
    @JoinColumn(name="BlockCode", referencedColumnName = "BlockCode"),
})
private Block block;

@Column(name="OnCallStart",columnDefinition = "DATETIME")
@NotNull(message="OnCallStart cannot be Empty")
private String oncallstart;
@Column(name="OnCallEnd",columnDefinition = "DATETIME")
@NotNull(message="OnCallEnd cannot be Empty")
private String oncallend;

}
