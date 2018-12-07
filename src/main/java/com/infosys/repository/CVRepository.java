package com.infosys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.db.CV;

@Repository
public interface CVRepository extends JpaRepository<CV, Long> {

	

}
