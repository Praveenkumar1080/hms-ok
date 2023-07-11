package com.cg.hms.entities;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class BlockId implements Serializable {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Column(name="BlockFloor",nullable = false)
 private Integer BlockFloor;
 @Column(name="BlockCode",nullable = false)
 private Integer BlockCode;

public BlockId() {
	super();
	// TODO Auto-generated constructor stub
}
public BlockId(Integer blockFloor, Integer blockCode) {
	super();
	BlockFloor = blockFloor;
	BlockCode = blockCode;
}
public Integer getBlockFloor() {
	return BlockFloor;
}
public void setBlockFloor(Integer blockFloor) {
	BlockFloor = blockFloor;
}
public Integer getBlockCode() {
	return BlockCode;
}
public void setBlockCode(Integer blockCode) {
	BlockCode = blockCode;
}
 
 
}
