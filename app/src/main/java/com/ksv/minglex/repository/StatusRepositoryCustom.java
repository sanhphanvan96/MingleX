package com.ksv.minglex.repository;

import java.util.List;

import com.ksv.minglex.model.Status;
import com.ksv.minglex.model.User;

public interface StatusRepositoryCustom {
	List<Status> findByUserCustom(String userId);
}