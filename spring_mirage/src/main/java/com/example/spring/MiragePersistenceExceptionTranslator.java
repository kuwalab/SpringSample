package com.example.spring;

import java.sql.SQLException;

import jp.sf.amateras.mirage.exception.SQLRuntimeException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;

public class MiragePersistenceExceptionTranslator implements
		PersistenceExceptionTranslator {
	@Autowired
	private SQLErrorCodeSQLExceptionTranslator translator;

	@Override
	public DataAccessException translateExceptionIfPossible(RuntimeException ex) {
		if (ex instanceof SQLRuntimeException) {
			Throwable t;
			while ((t = ex.getCause()) != null) {
				if (t instanceof SQLException) {
					return translator.translate("", "", (SQLException) t);
				}
			}
		}
		return null;
	}

}
