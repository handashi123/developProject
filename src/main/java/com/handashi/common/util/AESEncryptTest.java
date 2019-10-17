package com.handashi.common.util;

import java.util.Base64;
import java.util.Base64.Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESEncryptTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(Encrypt("1001637", "keyvalue"));
	}
	
	
	public static String Encrypt(String text, String key) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		byte[] keyBytes= new byte[16];
		byte[] b= key.getBytes("UTF-8");
		int len= b.length;
		
		if (len > keyBytes.length) len = keyBytes.length;
		
		System.arraycopy(b, 0, keyBytes, 0, len);
		SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
		IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
		
		cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
		byte[] results = cipher.doFinal(text.getBytes("UTF-8"));
//		BASE64Encoder encoder = new BASE64Encoder();
		
		return Base64.getEncoder().encodeToString(results);
	} 

}
