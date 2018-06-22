package com.ksv.minglex.repository;

import com.ksv.minglex.model.Status;

public interface StatusRepositoryCustom {
	Status findByUserIdCustom(String user_id);

	Status findByIdCustom(String status_id);
}