package com.ssafy.mvc.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FileDownloadView extends AbstractView {

	private final ResourceLoader resourceLoader;

	@Autowired
	public FileDownloadView(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
		setContentType("application/download; charset=UTF-8");
	}

	// 컨트롤러에서 뷰로 데이터를 전달하는 메서드
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String fileName = (String) model.get("fileName");
		Resource resource = resourceLoader.getResource("resources/upload");
		File file = new File(resource.getFile(), fileName);
		///////////////////////////////////////////////////////////
		// 파일 다운로드 설정
		response.setContentType(getContentType());
		response.setContentLength((int) file.length());

		fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1"); // 한글 방식을 안전하게 처리할 수 있게 해줌
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");

		////////////////////////////////////////////////////////////

		try (FileInputStream fis = new FileInputStream(file); OutputStream os = response.getOutputStream()) {
			FileCopyUtils.copy(fis, os);
		}
	}
}
