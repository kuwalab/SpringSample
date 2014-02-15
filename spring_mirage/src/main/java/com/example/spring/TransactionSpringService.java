package com.example.spring;

import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.integration.guice.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionSpringService {
	@Autowired
	private SqlManager sqlManager;

	@Transactional
	public int insert(Emp emp) {
		return sqlManager.insertEntity(emp);
	}
}
