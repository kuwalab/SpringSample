package com.example.spring.blob;

import java.util.List;

import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.StringSqlResource;
import jp.sf.amateras.mirage.session.Session;
import jp.sf.amateras.mirage.session.SessionFactory;

import com.example.spring.Emp;

public class MirageBlobConnect {
	public static void main(String[] args) {
		Session session = SessionFactory.getSession();
		SqlManager sqlManager = session.getSqlManager();
		session.begin();

		try {
			List<Emp> result = sqlManager
					.getResultList(Emp.class, new StringSqlResource(
							"SELECT emp_no,emp_pic FROM emp_pic"));

			session.commit();
		} catch (Exception ex) {
			session.rollback();
		} finally {
			session.release();
		}
	}

}
