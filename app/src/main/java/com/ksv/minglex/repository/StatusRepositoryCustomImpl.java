package com.ksv.minglex.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.ksv.minglex.model.Status;

@Transactional
public class StatusRepositoryCustomImpl implements StatusRepositoryCustom {
	
	@PersistenceContext
    private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Status> findByUserCustom(String userId) { 
		Query q = em.createNativeQuery("SELECT * from status INNER JOIN user ON status.user_id=user.user_id WHERE user.user_id='" + userId + "' ORDER BY updated_at DESC", Status.class);
		List<Status> statuses = (List<Status>) q.getResultList();
		return statuses;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Status> findAllOrderByUpdatedAt() {

		Query q = em.createNativeQuery("SELECT * FROM status ORDER BY updated_at DESC", Status.class);
		List<Status> statuses = (List<Status>) q.getResultList();
		System.out.println(statuses.toString());
		return statuses;

	}

}
