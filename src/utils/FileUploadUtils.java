package utils;

import java.util.UUID;

public class FileUploadUtils {

	// �õ��ϴ��ļ���ʵ���� c:\a.txt a.txt
	public static String getRealName(String filename) {
		int index = filename.lastIndexOf("\\")+1;
		return filename.substring(index);
	}
	
	// ��ȡ������� a.txt
	public static String getUUIDFileName(String filename) {
		int index = filename.lastIndexOf(".");
		if(index!=-1)
			return UUID.randomUUID() + filename.substring(index);
		else
			return UUID.randomUUID().toString();
	}
	
	// Ŀ¼�����㷨
	public static String getRandomDirectory(String filename) {
		int hashcode = filename.hashCode();
		int a = hashcode & 0xf;
		hashcode = hashcode>>>4;
		int b = hashcode & 0xf;
		return "/" + a + "/" + b;
	}
}
