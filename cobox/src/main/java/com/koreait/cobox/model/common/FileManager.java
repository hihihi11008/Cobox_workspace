<<<<<<< HEAD
=======
/*
 * ���ϰ� ���õ� ������ ����� ��Ƴ��� Ŭ����
 * */
>>>>>>> e67746f7da3158b3653e25e65dea06fccdcd9523
package com.koreait.cobox.model.common;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

<<<<<<< HEAD

@Component /* component-scan�� ��� �� �ϳ���.. */
public class FileManager {
	private static final Logger logger = LoggerFactory.getLogger(FileManager.class);
	public String saveDir="/resources/data";

	public String getSaveDir() {
		return saveDir;
	}

	public void setSaveDir(String saveDir) {
		this.saveDir = saveDir;
	}

	public static String getExtend(String path) {
		int lastIndex = path.lastIndexOf(".");
		String ext = path.substring(lastIndex + 1, path.length());
		// System.out.println(ext);
		return ext;
	}

=======
import lombok.Data;

@Data
@Component
public class FileManager {
	private static final Logger logger = LoggerFactory.getLogger(FileManager.class);
	private String saveBasicDir="/resources/data/basic";
	private String saveAddonDir="/resources/data/addon";
	
	//Ȯ���ڸ� �����ϱ� 
	public static String getExtend(String path) {
		int lastIndex = path.lastIndexOf(".");
		String ext = path.substring(lastIndex+1, path.length());
		//System.out.println(ext);		
		return ext;
	}
	
	//���ϻ���  : ȣ���ڴ� �����ϰ���� ������ ��θ� �ѱ��
>>>>>>> e67746f7da3158b3653e25e65dea06fccdcd9523
	public static boolean deleteFile(String path) {
		File file = new File(path);
		return file.delete();
	}
<<<<<<< HEAD

	// ���� �����ϱ�
=======
	
	//���������ϱ� 
>>>>>>> e67746f7da3158b3653e25e65dea06fccdcd9523
	public void saveFile(String realDir, MultipartFile multi) {
		try {
			multi.transferTo(new File(realDir));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
<<<<<<< HEAD

}
=======
}




>>>>>>> e67746f7da3158b3653e25e65dea06fccdcd9523
