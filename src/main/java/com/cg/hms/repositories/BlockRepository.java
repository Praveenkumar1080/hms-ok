package com.cg.hms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hms.entities.Block;
import com.cg.hms.entities.BlockId;

@Repository
public interface BlockRepository extends JpaRepository<Block, BlockId>{

}
