package com.handashi.common.util;

import java.io.File;

public class GetPathTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = GetPathTest.class.getClassLoader().getResource("").getPath();
		
		path = path.substring(1).replaceAll("//", File.separator);
		
		System.out.println(path);
		
		System.out.println(File.pathSeparator);
	}

}
