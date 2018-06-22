package com.ksv.minglex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ksv.minglex.model.Status;

@Repository("statusRepository")
public interface StatusRepository extends JpaRepository<Status, Long>, StatusRepositoryCustom {

	Status findByUserIdCustom(String user_id);

	Status findByIdCustom(String status_id);
}