package com.ksv.minglex.service;

import java.util.List;

import javax.validation.Valid;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
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
	
	@Autowired
	private XSSPreventionService xssService;

	@Override
	public List<Status> findAll() {
		return statusRepository.findAllOrderByUpdatedAt();
	}

	@Override
	public Status save(@Valid Status status) {
//		Store original text security setting for stored XSS prevention is false
		if (!securitySetting.getStoredXSS())
			return statusRepository.save(status);
//		else escape HTML before saving to database
		xssService = new HTMLEscapeImpl();
		String content = status.getDescription();
		status.setDescription(xssService.filter(content));
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
