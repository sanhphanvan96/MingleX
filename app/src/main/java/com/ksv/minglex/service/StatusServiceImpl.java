package com.ksv.minglex.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksv.minglex.model.Status;
import com.ksv.minglex.model.User;
import com.ksv.minglex.repository.StatusRepository;
import com.ksv.minglex.setting.SecuritySetting;

@Service("statusService")
public class StatusServiceImpl implements StatusService {
	
	@Autowired
	SecuritySetting securitySetting;

	@Autowired
	private StatusRepository statusRepository;

	@Override
	public List<Status> findAll() {
		return statusRepository.findAllOrderByUpdatedAt();
	}

	@Override
	public Status save(@Valid Status status) {
		return statusRepository.save(status);
	}

	public Status findById(int id) {
		return statusRepository.findById(id);
	}

	@Override
	public List<Status> findByUser(String userId) {
		if (!securitySetting.getSqlInjection()) {
			return statusRepository.findByUserCustom(userId);
		}
		User user = new User();
		try {
			user.setId(Integer.parseInt(userId));
		} catch (Exception e) {
			return null;
		}
		return statusRepository.findByUser(user);
	}

}
