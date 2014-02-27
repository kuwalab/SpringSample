package com.example.blob;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class IOUtil {
	public static void binaryCopy(InputStream is, OutputStream os)
			throws IOException {
		byte[] block = new byte[1024 * 8];
		int len;
		while ((len = is.read(block)) != -1) {
			os.write(block, 0, len);
		}

	}
}
