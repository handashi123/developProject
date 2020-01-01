package com.handashi.blog.presentation.service;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;

public interface ExcelDownService {
	public void excelDown(HttpServletResponse response)throws Exception;
}
