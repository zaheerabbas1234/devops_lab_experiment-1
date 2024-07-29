package com.citizen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citizen.model.Citizen;

@Repository
public interface CitizenRepo extends JpaRepository<Citizen, String>{

}
