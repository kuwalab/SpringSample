package com.example.blob;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// http://www.postgresql.jp/document/8.4/html/

public class OidWrite {

	public static void main(String... args) {
		write(100);
	}

	public static void write(int key) {
		try {
			String user = "mirage";
			String pass = "mirage";
			String url = "jdbc:postgresql://127.0.0.1:5432/miragedb";

			Connection conn = null;
			PreparedStatement stmt = null;

			try {
				// Class.forName("org.postgresql.Driver");
				conn = DriverManager.getConnection(url, user, pass);
				conn.setAutoCommit(false);

				stmt = conn
						.prepareStatement("insert into emp_oid values(?,lo_create(0))");
				stmt.setInt(1, key);
				stmt.executeUpdate();
				stmt.close();

				stmt = conn
						.prepareStatement("select emp_pic from emp_oid where emp_no=?");
				stmt.setInt(1, key);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					Blob content = rs.getBlob(1);
					File file = new File("file/input/299.jpg");
					try (FileInputStream fis = new FileInputStream(file);
							OutputStream out = content.setBinaryStream(1)) {
						byte[] buffer = new byte[1024 * 8];
						int len;
						while ((len = fis.read(buffer)) != -1) {
							out.write(buffer, 0, len);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				conn.commit();
				rs.close();
				stmt.close();
				stmt = null;
				conn.close();
				conn = null;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
