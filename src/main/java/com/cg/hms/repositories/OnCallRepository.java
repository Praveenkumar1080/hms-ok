package com.cg.hms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.hms.entities.Oncall;

@Repository
public interface OnCallRepository extends JpaRepository<Oncall, Integer>{

}
