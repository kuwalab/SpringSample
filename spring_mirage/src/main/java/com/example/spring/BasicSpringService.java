package com.example.spring;

import java.util.List;

import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.StringSqlResource;
import jp.sf.amateras.mirage.integration.guice.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BasicSpringService {
	@Autowired
	private SqlManager sqlManager;

	@Transactional
	public void execute() {
		List<Emp> result = sqlManager.getResultList(Emp.class,
				new StringSqlResource("SELECT emp_no,name,age FROM emp"));
		for (Emp test : result) {
			System.out.println(test);
		}
	}
}
