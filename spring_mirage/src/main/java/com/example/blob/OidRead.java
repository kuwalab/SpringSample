package com.example.blob;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// http://www.postgresql.jp/document/8.4/html/
// http://moyolab.blog57.fc2.com/blog-entry-36.html

public class OidRead {

	public static void main(String... args) {
		read(1);
	}

	public static void read(int key) {
		try {
			String user = "mirage";
			String pass = "mirage";
			String url = "jdbc:postgresql://127.0.0.1:5432/miragedb";

			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;

			try {
				// Class.forName("org.postgresql.Driver");
				conn = DriverManager.getConnection(url, user, pass);
				conn.setAutoCommit(false);
				stmt = conn
						.prepareStatement("select emp_pic from emp_oid where emp_no=?");
				stmt.setInt(1, key);

				rs = stmt.executeQuery();
				rs.next();
				Blob content = rs.getBlob(1);
				try (BufferedInputStream bis = new BufferedInputStream(
						content.getBinaryStream());
						BufferedOutputStream bos = new BufferedOutputStream(
								new FileOutputStream("file/output/" + key
										+ ".dat"))) {
					// rs.close();
					// stmt.close();
					byte[] block = new byte[1024 * 8];
					int len;
					while ((len = bis.read(block)) != -1) {
						bos.write(block, 0, len);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				rs.close();
				stmt.clearBatch();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (conn != null) {
					conn.close();
					conn = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (rs != null) {
					rs.close();
					rs = null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
