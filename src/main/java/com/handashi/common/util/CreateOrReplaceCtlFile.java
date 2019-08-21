package com.handashi.common.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class CreateOrReplaceCtlFile {
	
	// 파일위치
	private static String SFTP_WORKINGDIR = "";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void createOrReplaceCtlFile(String fileName) {

		try {
			
			System.out.println("CTL FILE WRITTER START");

			File ctlFile = new File(SFTP_WORKINGDIR + fileName + ".ctl");

			FileWriter fw = new FileWriter(ctlFile, false);

			BufferedWriter bw = new BufferedWriter(fw);

			String ctlFileContent = "LOAD DATA" + "\r\n"

					+ "    INFILE '" + SFTP_WORKINGDIR + fileName + ".log'\r\n"

					+ "    BADFILE '" + SFTP_WORKINGDIR + fileName + ".bad'\r\n"

					+ "    DISCARDFILE '" + SFTP_WORKINGDIR + fileName + ".dcs'\r\n"

					+ "    APPEND\r\n"

					+ "    INTO TABLE BEACON.BEACON_LOG\r\n"

					+ "    FIELDS TERMINATED BY '|'\r\n"

					+ "(\r\n"

					+ "     GUID                   CHAR(36)\r\n"

					+ "    ,EMAIL                  CHAR(50)\r\n"

					+ "    ,TIME_ZONE              CHAR(100)\r\n"

					+ "    ,PUSH_TOKEN             CHAR(200)\r\n"

					+ "    ,PLATFORM_TYPE          CHAR(30)\r\n"

					+ "    ,OS_VERSION             CHAR(100)\r\n"

					+ "    ,APP_VERSION            CHAR(100)\r\n"

					+ "    ,TIME_STAMP             DATE \"YYYY-MM-DD HH24:MI:SS\"\r\n"

					+ "    ,PARSE_TIME_STAMP       DATE \"YYYY-MM-DD HH24:MI:SS\"\r\n"

					+ "    ,BEACON_UUID            CHAR(100)\r\n"

					+ "    ,BEACON_MAJOR_VERSION   CHAR(100)\r\n"

					+ "    ,BEACON_MINOR_VERSION   CHAR(100)\r\n"

					+ "    ,SIGNAL_STRENGTH        INTEGER EXTERNAL\r\n"

					+ "    ,CREATE_BY              CHAR(24)\r\n"

					+ "    ,MODIFY_BY              CHAR(24)\r\n"

					+ "    ,CREATE_DATE            DATE \"YYYY-MM-DD HH24:MI:SS\"\r\n"

					+ "    ,MODIFY_DATE            DATE \"YYYY-MM-DD HH24:MI:SS\"\r\n"

					+ "    ,APP_NAME               CHAR(100)\r\n"

					+ "    ,ACCOUNT_ID             CHAR(24)\r\n"

					+ "    ,MODEL_NO               CHAR(50)\r\n"

					+ "    ,BATTERY                INTEGER EXTERNAL\r\n"

					+ ")";

			bw.write(ctlFileContent);

			bw.close();

			fw.close();

			System.out.println("CTL FILE WRITTER END");

		} catch (Exception e) {

			e.printStackTrace();

		}

	}




}
