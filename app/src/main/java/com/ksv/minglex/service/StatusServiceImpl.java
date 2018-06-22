package com.ksv.minglex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksv.minglex.model.Status;
import com.ksv.minglex.repository.StatusRepository;

@Service("statusService")
public class StatusServiceImpl implements StatusService {
	
	@Autowired
	private StatusRepository statusRepository;

	@Override
	public List<Status> findAll() {
		return statusRepository.findAll();
	}

}