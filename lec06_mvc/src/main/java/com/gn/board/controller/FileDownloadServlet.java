package com.gn.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.board.service.BoardService;
import com.gn.board.vo.Attach;

@WebServlet("/fileDownload")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FileDownloadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 파일명 비어있는지 확인
        int attachNo = Integer.parseInt(request.getParameter("attach_no"));  // 읽어올 파일 번호
        Attach a = new BoardService().selectAttachOne(attachNo);
        String filePath = a.getAttachPath();
        if(filePath == null || filePath.trim().equals("")) {
        	response.sendError(HttpServletResponse.SC_BAD_REQUEST); // 400 오류 반환
            return;
        }
        
        File file = new File(filePath);
        
        // 2. 파일 경로에 파일 존재 유무 확인
        if (!file.exists()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404 오류 반환
            return;
        }
        
        // 4. 파일 다운로드 응답 헤더 설정
        response.setContentType("application/octet-stream");
        response.setContentLength((int) file.length());

        // 5. 파일명 인코딩 (브라우저 호환성 고려)
        String encodedFileName = URLEncoder.encode(a.getOriName(), "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + encodedFileName + "\"");

        // 6. 파일 데이터를 클라이언트로 전송
        try (FileInputStream fis = new FileInputStream(file);
             OutputStream out = response.getOutputStream()) {
            // 파일 데이터를 1KB(1024byte)씩 읽어들임
            byte[] buffer = new byte[1024];
            int bytesRead;
            // buffer에 저장하면서 -1(더이상 읽을 내용이 없을 때까지) 읽어들임
            while ((bytesRead = fis.read(buffer)) != -1) {
                // 읽어온 데이터를 클라이언트(브라우저)에게 전송
            	out.write(buffer, 0, bytesRead);
            }
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
