package com.ksv.minglex.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.ksv.minglex.model.Status;
import com.ksv.minglex.model.User;

public interface StatusService {
	public List<Status> findAll();
	public Status save(@Valid Status status);
	public Status findById(int id);
	public List<Status> findByUser(String userId);
}
