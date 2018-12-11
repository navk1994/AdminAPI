package com.infosys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.repository.CrudRepository;

import com.infosys.db.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {

}
