package com.handashi.blog.presentation.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import com.handashi.blog.presentation.service.ExcelDownService;

@Service
public class ExcelPoiDownServiceImpl implements ExcelDownService {

	@Override
	public void excelDown(HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		List<Map<String,String>> list = makeTestList();
		
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet("탭이름");
		Row row = null;
		Cell cell = null;
		
		int rowNo = 0;
		
		// 테이블 헤더용 스타일
		CellStyle headStyle = wb.createCellStyle();
		// 가는 경계선
		headStyle.setBorderTop(BorderStyle.THIN);
		headStyle.setBorderBottom(BorderStyle.THIN);
		headStyle.setBorderLeft(BorderStyle.THIN);
		headStyle.setBorderRight(BorderStyle.THIN);
		
		// 배경색은 노랑
		headStyle.setFillForegroundColor(HSSFColorPredefined.YELLOW.getIndex());
		headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		// 데이터 가운데 정렬
		headStyle.setAlignment(HorizontalAlignment.CENTER);
		
		// 데이터용 경계 스타일 테두리만 지정
		CellStyle bodyStyle = wb.createCellStyle();
		bodyStyle.setBorderTop(BorderStyle.THIN);
		bodyStyle.setBorderBottom(BorderStyle.THIN);
		bodyStyle.setBorderLeft(BorderStyle.THIN);
		bodyStyle.setBorderRight(BorderStyle.THIN);
		
		// 헤더 생성
		row = sheet.createRow(rowNo++);
		cell = row.createCell(0);
		cell.setCellStyle(headStyle);
		cell.setCellValue("번호");
		
		cell = row.createCell(1);
		cell.setCellStyle(headStyle);
		cell.setCellValue("이름");
		
		cell = row.createCell(2);
		cell.setCellStyle(headStyle);
		cell.setCellValue("제목");
		
		// 데이터 부분 생성
		for(Map<String, String> map : list) {
			row = sheet.createRow(rowNo++);
			cell = row.createCell(0);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(map.get("no"));
			
			cell = row.createCell(1);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(map.get("name"));
			
			cell = row.createCell(2);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(map.get("title"));
		}
		
		// 컨텐츠 타입과 파일명 지정
		response.setContentType("ms-vnd/excel");
		response.setHeader("Content-Disposition", "attachment;filename=test.xls");
		
		// 엑셀출력
		wb.write(response.getOutputStream());
		wb.close();
		
	}
	
	public List<Map<String, String>> makeTestList(){
		
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("no", "1");
		map1.put("name", "aaa");
		map1.put("title", "t1");
		list.add(map1);
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("no", "2");
		map2.put("name", "bbb");
		map2.put("title", "t2");
		list.add(map2);
		Map<String, String> map3 = new HashMap<String, String>();
		map3.put("no", "3");
		map3.put("name", "ccc");
		map3.put("title", "t3");
		list.add(map3);
				
		return list;
	}

}
