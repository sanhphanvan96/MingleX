package com.ksv.minglex.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksv.minglex.model.Status;
import com.ksv.minglex.model.User;
import com.ksv.minglex.repository.StatusRepository;

@Service("statusService")
public class StatusServiceImpl implements StatusService {

	@Autowired
	private StatusRepository statusRepository;

	@Override
	public List<Status> findAll() {
		return statusRepository.findAll();
	}

	@Override
	public Status save(@Valid Status status) {
		// TODO Auto-generated method stub
		return statusRepository.save(status);
	}

	public Status findById(int id) {
		return statusRepository.findById(id);
	}

	@Override
	public List<Status> findByUser(User user) {
		return statusRepository.findByUser(user);
	}

}
