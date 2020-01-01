package com.handashi.common.util;

public class StringBufferTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
//		sb.append("111");
		
//		System.out.println("sb length : " + sb.length());
		String creDttm = "20171212";
		
		sb.append("SELECT  A.LOG_DATE, A.SEQ, A.ITEM_ENM, A.ITEM_VAL		\n");	
		sb.append("FROM (	\n");	
		sb.append("SELECT LOG_DATE, SEQ, 'DAY_WEEK' AS ITEM_ENM, TO_CHAR(TO_DATE(LOG_DATE), 'DY') AS ITEM_VAL FROM AR_LOG_APP WHERE LOG_DATE = '" + creDttm + "'  \n");
		sb.append("UNION			\n");
		sb.append("SELECT LOG_DATE, SEQ, 'LOG_DATE' AS ITEM_ENM, LOG_DATE AS ITEM_VAL FROM AR_LOG_APP WHERE LOG_DATE = '" + creDttm + "'                    \n");
		sb.append("UNION                                                                                                                             \n");
		sb.append("SELECT LOG_DATE, SEQ, 'SEQ' AS ITEM_ENM, TO_CHAR(SEQ) AS ITEM_VAL FROM AR_LOG_APP WHERE LOG_DATE = '" + creDttm + "'                     \n");
		sb.append("UNION                                                                                                                             \n");
		sb.append("SELECT LOG_DATE, SEQ, 'APP_LOGIN_ID' AS ITEM_ENM, APP_LOGIN_ID AS ITEM_VAL FROM AR_LOG_APP WHERE LOG_DATE = '" + creDttm + "'            \n");
		sb.append("UNION                                                                                                                             \n");
		sb.append("SELECT LOG_DATE, SEQ, 'APP_SYS_ID' AS ITEM_ENM, APP_SYS_ID AS ITEM_VAL FROM AR_LOG_APP WHERE LOG_DATE = '" + creDttm + "'                \n");
		sb.append("UNION                                                                                                                             \n");
		sb.append("SELECT LOG_DATE, SEQ, 'APP_SYS_IP' AS ITEM_ENM, APP_SYS_IP AS ITEM_VAL FROM AR_LOG_APP WHERE LOG_DATE = '" + creDttm + "'                \n");
		sb.append("UNION                                                                                                                             \n");
		sb.append("SELECT LOG_DATE, SEQ, 'CLIENT_IP' AS ITEM_ENM, CLIENT_IP AS ITEM_VAL FROM AR_LOG_APP WHERE LOG_DATE = '" + creDttm + "'                  \n");
		sb.append("UNION                                                                                                                             \n");
		sb.append("SELECT LOG_DATE, SEQ, 'CUST_LIST_CNT' AS ITEM_ENM, TO_CHAR(CUST_LIST_CNT) AS ITEM_VAL FROM AR_LOG_APP WHERE LOG_DATE = '" + creDttm + "' \n");
		sb.append("UNION                                                                                                                             \n");
		sb.append("SELECT LOG_DATE, SEQ, 'CRE_HHMM' AS ITEM_ENM, SUBSTR(EFFECT_DTTM,9,4) AS ITEM_VAL FROM AR_LOG_APP WHERE LOG_DATE = '" + creDttm + "'     \n");
		sb.append("UNION                                                                                                                             \n");
		sb.append("SELECT LOG_DATE, SEQ, 'CUST_NM' AS ITEM_ENM, CUST_NM AS ITEM_VAL FROM AR_LOG_APP WHERE LOG_DATE = '" + creDttm + "'                      \n");
		sb.append("UNION                                                                                                                             \n");
		//---------- 20121016 PAGE_ID 항목 조회 추가 -시작
		sb.append("SELECT LOG_DATE, SEQ, 'PAGE_ID' AS ITEM_ENM, PAGE_ID AS ITEM_VAL FROM AR_LOG_APP WHERE LOG_DATE = '" + creDttm + "'                        \n");
		sb.append("UNION                                                                                                                             \n");
		//---------- 20121016 PAGE_ID 항목 조회 추가 -끝
		sb.append("SELECT LOG_DATE, SEQ, 'FUN_CD' AS ITEM_ENM, FUN_CD AS ITEM_VAL FROM AR_LOG_APP WHERE LOG_DATE = '" + creDttm + "'                        \n");
		sb.append("UNION                                                                                                                             \n");
		sb.append("SELECT LOG_DATE, SEQ, 'COMPANY' AS ITEM_ENM, U.COMPANY AS ITEM_VAL                                                                 \n");
		sb.append("FROM AR_LOG_APP L,                                                                                                                \n");
		sb.append("    (SELECT A.ITG_USER_ID, B.APP_SYS_ID, B.APP_LOGIN_ID, A.COMPANY, A.DEPT_NM, A.CMP_NB, A.USER_NM                                \n");
		sb.append("    FROM AR_INF_USR A, AR_INF_USR_SYS B                                                                                           \n");
		sb.append("    WHERE A.ITG_USER_ID = B.ITG_USER_ID) U                                                                                        \n");
		sb.append("WHERE L.LOG_DATE = '" + creDttm + "'                                                                                                     \n");
		sb.append("    AND L.APP_SYS_ID = U.APP_SYS_ID(+)                                                                                            \n");
		sb.append("    AND L.APP_LOGIN_ID = U.APP_LOGIN_ID(+)                                                                                        \n");
		sb.append("UNION                                                                                                                             \n");
		sb.append("SELECT LOG_DATE, SEQ, 'DEPT_NM' AS ITEM_ENM, U.DEPT_NM AS ITEM_VAL                                                                 \n");
		sb.append("FROM AR_LOG_APP L,                                                                                                                \n");
		sb.append("    (SELECT A.ITG_USER_ID, B.APP_SYS_ID, B.APP_LOGIN_ID, A.COMPANY, A.DEPT_NM, A.CMP_NB, A.USER_NM                                \n");
		sb.append("    FROM AR_INF_USR A, AR_INF_USR_SYS B                                                                                           \n");
		sb.append("    WHERE A.ITG_USER_ID = B.ITG_USER_ID) U                                                                                        \n");
		sb.append("WHERE L.LOG_DATE = '" + creDttm + "'                                                                                                     \n");
		sb.append("    AND L.APP_SYS_ID = U.APP_SYS_ID(+)                                                                                            \n");
		sb.append("    AND L.APP_LOGIN_ID = U.APP_LOGIN_ID(+)                                                                                        \n");
		sb.append("UNION                                                                                                                             \n");
		sb.append("SELECT LOG_DATE, SEQ, 'CMP_NB' AS ITEM_ENM, U.CMP_NB AS ITEM_VAL                                                                   \n");
		sb.append("FROM AR_LOG_APP L,                                                                                                                \n");
		sb.append("    (SELECT A.ITG_USER_ID, B.APP_SYS_ID, B.APP_LOGIN_ID, A.COMPANY, A.DEPT_NM, A.CMP_NB, A.USER_NM                                \n");
		sb.append("    FROM AR_INF_USR A, AR_INF_USR_SYS B                                                                                           \n");
		sb.append("    WHERE A.ITG_USER_ID = B.ITG_USER_ID) U                                                                                        \n");
		sb.append("WHERE L.LOG_DATE = '" + creDttm + "'                                                                                                     \n");
		sb.append("    AND L.APP_SYS_ID = U.APP_SYS_ID(+)                                                                                            \n");
		sb.append("    AND L.APP_LOGIN_ID = U.APP_LOGIN_ID(+)                                                                                        \n");
		sb.append("UNION                                                                                                                             \n");
		sb.append("SELECT LOG_DATE, SEQ, 'USER_NM' AS ITEM_ENM, U.USER_NM AS ITEM_VAL                                                                 \n");
		sb.append("FROM AR_LOG_APP L,                                                                                                                \n");
		sb.append("    (SELECT A.ITG_USER_ID, B.APP_SYS_ID, B.APP_LOGIN_ID, A.COMPANY, A.DEPT_NM, A.CMP_NB, A.USER_NM                                \n");
		sb.append("    FROM AR_INF_USR A, AR_INF_USR_SYS B                                                                                           \n");
		sb.append("    WHERE A.ITG_USER_ID = B.ITG_USER_ID) U                                                                                        \n");
		sb.append("WHERE L.LOG_DATE = '" + creDttm + "'                                                                                                     \n");
		sb.append("    AND L.APP_SYS_ID = U.APP_SYS_ID(+)                                                                                            \n");
		sb.append("    AND L.APP_LOGIN_ID = U.APP_LOGIN_ID(+)                                                                                        \n");
		sb.append("UNION                                                                                                                             \n");
		sb.append("SELECT LOG_DATE, SEQ, 'CUST_GRADE' AS ITEM_ENM, P.CUST_GRADE AS ITEM_VAL                                                           \n");
		sb.append("FROM AR_LOG_APP L,                                                                                                                \n");
		sb.append("    AR_APP_PID P                                                                                                                  \n");
		sb.append("WHERE L.LOG_DATE = '" + creDttm + "'                                                                                                     \n");
		sb.append("    AND L.PAGE_ID = P.APP_PAGE_ID                                                                                                 \n");
		sb.append("    AND L.APP_SYS_ID = P.APP_SYS_ID                                                                                               \n");
		sb.append("UNION                                                                                                                             \n");
		sb.append("SELECT LOG_DATE, SEQ, ITEM_ENM, ITEM_VAL FROM AR_ANL_RSK_INFO WHERE LOG_DATE = '" + creDttm + "'                                        \n");
		sb.append(") A,		\n");
		sb.append("AR_LOG_APP L 	\n");
		sb.append("WHERE L.LOG_DATE = A.LOG_DATE	\n");
		sb.append("AND L.SEQ = A.SEQ		\n");
		sb.append("AND L.FUN_CD <> '10009'	\n");
		
		System.out.println(sb.toString());
	}

}
