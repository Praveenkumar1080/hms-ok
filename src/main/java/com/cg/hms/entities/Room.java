package com.cg.hms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
public class Room {
	@Id
	@Column(name="RoomNumber")
	@NotNull(message="RoomNumber cannot be Empty")
	private int roomNumber;
	@Column(name="RoomType",columnDefinition = "VARCHAR(30)")
	@NotNull(message="RoomType cannot be Empty")
    private String roomType;
	@ManyToOne
    @JoinColumns({
        @JoinColumn(name="BlockFloor", referencedColumnName = "BlockFloor"),
        @JoinColumn(name="BlockCode", referencedColumnName = "BlockCode"),
    })
    private Block block;
	@Column(name="Unavailable",columnDefinition = "BIT")
	@NotNull(message="Unavailable cannot be Empty")
    private boolean unavailable;

}
