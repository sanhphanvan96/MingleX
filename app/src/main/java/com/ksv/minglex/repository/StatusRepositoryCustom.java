package com.ksv.minglex.repository;

import java.util.List;

import com.ksv.minglex.model.Status;

public interface StatusRepositoryCustom {
	List<Status> findAllOrderByUpdatedAt();
	List<Status> findByUserCustom(String userId);
}