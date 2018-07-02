package com.ksv.minglex.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ksv.minglex.model.Status;
import com.ksv.minglex.model.User;

@Repository("statusRepository")
public interface StatusRepository extends JpaRepository<Status, Long>, StatusRepositoryCustom {
	List<Status> findAll();
	Status findById(int id);
	List<Status> findByUser(User user);
}