package com.gn.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.board.service.BoardService;

@WebServlet("/filePath")
public class FilePathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FilePathServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 파일명 비어있는지 확인
        int attachNo = Integer.parseInt(request.getParameter("attach_no"));  // 읽어올 파일 번호
        String filePath = new BoardService().selectAttachPath(attachNo);
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
 
        
        // 3. MIME 타입 감지
        String mimeType = getServletContext().getMimeType(filePath);
        if (mimeType == null) {
            mimeType = "application/octet-stream"; // 기본값 (모든 파일 다운로드 가능)
        }
        response.setContentType(mimeType);
 

        // 4. 파일 읽어서 클라이언트에 전송
        try (FileInputStream fis = new FileInputStream(file);
             OutputStream out = response.getOutputStream()) {
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}