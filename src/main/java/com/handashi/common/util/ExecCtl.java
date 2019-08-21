package com.handashi.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecCtl {
	
	// 파일위치
	private static String SFTP_WORKINGDIR = "";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// Window 실행시

	public static void execWindowCtl(String fileName) {

		String concatFileInfo = SFTP_WORKINGDIR + fileName;

		try {

			String sqlldr = "sqlldr control=" + concatFileInfo + ".ctl userid=userid=id/pw@TNS log=" + concatFileInfo
					+ ".logger";

			Process p = Runtime.getRuntime().exec(sqlldr);

			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = null;

			while ((line = br.readLine()) != null) {

				System.out.println(line);

			}

			p.waitFor();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

	}

	// 리눅시 일때

	public static void execLinuxCtl(String fileName) {

		String concatFileInfo = SFTP_WORKINGDIR + fileName;

		try {

			String sqlldr = "sqlldr control=" + concatFileInfo + ".ctl userid=id/pw@TNS log=" + concatFileInfo
					+ ".logger";

			Process p = Runtime.getRuntime().exec(sqlldr);

			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = null;

			while ((line = br.readLine()) != null) {

				System.out.println(line);

			}

			p.waitFor();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

	}

}
