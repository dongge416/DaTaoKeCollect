package com.dongge416.collect;

import java.io.File;

public class FileUtil {

	public static boolean creatDir() {
		boolean result = false;
		File dir = new File(Constant.FILE_PATH);
		if(!dir.exists()) {
			dir.mkdirs();
			result = true;
		}
		return result;
	}
	
}
