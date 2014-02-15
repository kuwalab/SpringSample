package com.example.spring;

import java.util.List;

import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.StringSqlResource;
import jp.sf.amateras.mirage.session.Session;
import jp.sf.amateras.mirage.session.SessionFactory;

public class MirageConnect {
	public static void main(String[] args) {
		Session session = SessionFactory.getSession();
		SqlManager sqlManager = session.getSqlManager();
		session.begin();

		try {
			List<Emp> result = sqlManager.getResultList(Emp.class,
					new StringSqlResource("SELECT emp_no,name,age FROM emp"));
			for (Emp test : result) {
				System.out.println(test);
			}

			session.commit();
		} catch (Exception ex) {
			session.rollback();
		} finally {
			session.release();
		}
	}
}
