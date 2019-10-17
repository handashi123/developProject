package com.handashi.blog.presentation.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.handashi.blog.presentation.service.ExcelDownService;

import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.ScriptStyle;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

@Service
public class ExcelJxlDownServiceImpl implements ExcelDownService {

	@Override
	public void excelDown(HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		try {
			
		
		List<Map<String, String>> bodyList = makeTestList();
		
		String fileName = "newExcel.xls";
		
		response.setContentType("application/msexcel;charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment; filename=\""+ fileName + "\";");
		
		// 엑셀파일 생성
		WritableWorkbook workbook = Workbook.createWorkbook(new File(fileName));
		// 시트 생성
		WritableSheet sheet = workbook.createSheet("첫번째탭", 0);

		// font setting
		// title
		WritableFont wbTitleFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK, ScriptStyle.NORMAL_SCRIPT);
		// content
		WritableFont wbContentFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK, ScriptStyle.NORMAL_SCRIPT);
		
		// 서식
		WritableCellFormat formatC = new WritableCellFormat(wbContentFont); // center
		formatC.setAlignment(jxl.format.Alignment.CENTRE);
		formatC.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
		formatC.setBorder(Border.ALL, BorderLineStyle.THIN);

		WritableCellFormat formatCV = new WritableCellFormat(wbTitleFont); // center,																
		formatCV.setAlignment(jxl.format.Alignment.CENTRE);
		formatCV.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
		formatCV.setBorder(Border.ALL, BorderLineStyle.THIN);
		formatCV.setBackground(Colour.GRAY_25); // gray
		
		WritableCellFormat formatL = new WritableCellFormat(); // right
		formatL.setAlignment(jxl.format.Alignment.RIGHT);
		formatL.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
		formatL.setBorder(Border.ALL, BorderLineStyle.THIN);

		WritableCellFormat formatR = new WritableCellFormat(); // left
		formatL.setAlignment(jxl.format.Alignment.LEFT);
		formatL.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
		formatL.setBorder(Border.ALL, BorderLineStyle.THIN);
		
		// 제목 생성
		List<String[]> titleList = new ArrayList<String[]>();
		String[] title1 = {"넘버", "이름", "제목"};
		titleList.add(title1);
		
		int[] size = {5, 10, 30};
		makeExcelTitle(sheet, formatCV, titleList, size);
		
		// 내용컬럼명
		String[] bodyNames = {"no", "name", "title"};
		
		// 내용생성
		makeExcelBody(sheet, formatC, bodyList, bodyNames, titleList.size());
		
		workbook.write();
		workbook.close();
		
		File file = new File(fileName);
		FileInputStream fin = new FileInputStream(file);
		int fileSize = (int) file.length();
		byte b[] = new byte[fileSize];
		
		ServletOutputStream oout = response.getOutputStream();
		fin.read(b);
		oout.write(b, 0, fileSize);
		
		oout.close();
		fin.close();
		file.delete();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
	}
	/**
	 * 샘플 데이터
	 * @return
	 */
	public List<Map<String, String>> makeTestList() {

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

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
	
	/**
	 * 엑셀 title 생성
	 * @param sheet 엑셀 sheet
	 * @param format 엑셀 서식
	 * @param titleList List<String[]> 구조 excel 제목
	 * @param size int[] 구조 cell 크기
	 * @throws Exception
	 */
	public void makeExcelTitle(WritableSheet sheet, WritableCellFormat format, List<String[]> titleList, int[] size) throws Exception {
		
		for(int i = 0; i < titleList.size(); i++) {
			String[] title = titleList.get(i);
						
			for(int j = 0; j < title.length; j++) {
				// 셀 크기 설정
				sheet.setColumnView(j, size[j]);
				// title 세팅
				sheet.addCell(new Label(j,  i, title[j], format));
			}
		}
		
	}
	/**
	 * 엑셀 body 생성
	 * @param sheet 엑셀 sheet
	 * @param format 엑셀 서식
	 * @param bodyList List<Map> 구조 excel 내용
	 * @param bodyNames Map key
	 * @param titleSize 엑셀 제목 줄수
	 * @throws Exception
	 */
	public void makeExcelBody(WritableSheet sheet, WritableCellFormat format, List<Map<String, String>> bodyList, String[] bodyNames, int titleSize) throws Exception {
		
		for(int i = 0; i < bodyList.size(); i++) {			
			Map<String, String> map = bodyList.get(i);
			
			for(int j = 0; j < bodyNames.length; j++) {
				sheet.addCell(new Label(j, i+titleSize, map.get(bodyNames[j]), format));
			}
			
		}
		
	}

}
