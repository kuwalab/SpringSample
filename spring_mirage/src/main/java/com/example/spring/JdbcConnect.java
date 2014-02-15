package com.example.spring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcConnect {
	public static void main(String[] args) {
		try {
			// JDBCドライバのロード
			// Class.forName("org.postgresql.Driver");

			// データベース接続
			Connection conn = DriverManager.getConnection("jdbc:postgresql://" + // DBURL
					"127.0.0.1" + // IPアドレス（又はサーバー名）
					":" + "5432" + // ポート
					"/" + "miragedb", // DB名
					"mirage", // ユーザ名
					"mirage" // パスワード
			);

			PreparedStatement stmt = conn
					.prepareStatement("SELECT emp_no,name,age FROM emp");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(2));
			}

			// データベース切断
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}