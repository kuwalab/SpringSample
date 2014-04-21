package com.example.blob;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// http://www.postgresql.jp/document/8.4/html/

public class BlobTool {

	public static void main(String... args) {
		write(100);
	}

	public static void read(int key) {
		try {
			/* ユーザ名 */
			String user = "mirage";
			/* パスワード */
			String pass = "mirage";
			/* サーバ名 */
			String url = "jdbc:postgresql://127.0.0.1:5432/miragedb";

			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;

			try {
				/* ドライバクラスのロード */
				// Class.forName("org.postgresql.Driver");

				/* Connectionの作成 */
				conn = DriverManager.getConnection(url, user, pass);
				conn.setAutoCommit(false);

				/* Statementの作成 */
				stmt = conn
						.prepareStatement("select emp_pic from emp_pic where emp_no=?");
				stmt.setInt(1, key);

				rs = stmt.executeQuery();

				rs.next();
				/* 取得したデータを表示します。 */
				try (BufferedInputStream bis = new BufferedInputStream(
						rs.getBinaryStream(1));
						BufferedOutputStream bos = new BufferedOutputStream(
								new FileOutputStream("file/output/" + 1
										+ ".png"))) {
					byte[] block = new byte[8192];
					int len;
					while ((len = bis.read(block)) != -1) {
						bos.write(block, 0, len);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

				rs.close();
				stmt.close();
				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				/* クローズ処理 */
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

	public static void write(int key) {
		try {
			/* ユーザ名 */
			String user = "mirage";
			/* パスワード */
			String pass = "mirage";
			/* サーバ名 */
			String url = "jdbc:postgresql://127.0.0.1:5432/miragedb";

			Connection conn = null;
			PreparedStatement stmt = null;

			try {
				/* ドライバクラスのロード */
				// Class.forName("org.postgresql.Driver");

				/* Connectionの作成 */
				conn = DriverManager.getConnection(url, user, pass);
				conn.setAutoCommit(false);

				/* Statementの作成 */
				stmt = conn.prepareStatement("insert into emp_pic values(?,?)");
				stmt.setInt(1, key);
				File file = new File("file/input/299.jpg");

				try (FileInputStream fis = new FileInputStream(file)) {
					stmt.setBinaryStream(2, fis, (int) file.length());
					stmt.executeUpdate();
					conn.commit();
				} catch (IOException e) {
					e.printStackTrace();
				}
				stmt.close();
				stmt = null;
				conn.close();
				conn = null;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				/* クローズ処理 */
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
