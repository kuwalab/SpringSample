package com.example.spring;

import jp.sf.amateras.mirage.SqlManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TransactionSpringService {
	@Autowired
	private SqlManager sqlManager;

	@Transactional
	public void insert(Emp emp) {
		// キーの重複をわざと起こす
		sqlManager.insertEntity(emp);
		sqlManager.insertEntity(emp);
	}
}
