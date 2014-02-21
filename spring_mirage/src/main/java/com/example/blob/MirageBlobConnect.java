package com.example.blob;

import java.util.List;

import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.StringSqlResource;
import jp.sf.amateras.mirage.session.Session;
import jp.sf.amateras.mirage.session.SessionFactory;

public class MirageBlobConnect {
	public static void main(String[] args) {
		Session session = SessionFactory.getSession();
		SqlManager sqlManager = session.getSqlManager();
		session.begin();

		try {
			List<EmpPic> empPicList = sqlManager
					.getResultList(EmpPic.class, new StringSqlResource(
							"SELECT emp_no,emp_pic FROM emp_pic"));
			for (EmpPic empPic : empPicList) {
				System.out.println("### " + empPic.getEmpNo() + ":"
						+ empPic.getEmpPic().length);
				// for (int i = 0; i < empPic.getEmpPic().length; i++) {
				// if ((i + 1) % 8192 == 0) {
				// System.out.println();
				// }
				// System.out.format("%02x", empPic.getEmpPic()[i]);
				// }
			}

			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.release();
		}
	}

}
