package com.gn.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/boardCreateEnd")
public class BoardCreateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardCreateEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String path = "C:\\upload";		
		File dir = new File(path);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(dir);
		factory.setSizeThreshold(1024*1024*10);
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List items = upload.parseRequest(request);
			for(int i = 0 ; i < items.size() ; i++) {
				FileItem fileItem = (FileItem)items.get(i);
				// 파일이 아닌 폼 내부 요소
				if(fileItem.isFormField()) {
					System.out.println(fileItem.getFieldName()+ "=" +fileItem.getString("utf-8"));
				// 파일형태의 폼 요소
				} else {
					if(fileItem.getSize() > 0) {
						String oriName = fileItem.getName();
						int idx = oriName.lastIndexOf(".");
						String ext = fileItem.getName().substring(idx);
						
						String uuid = UUID.randomUUID().toString();
						String newName = uuid+ext;
						File uploadFile = new File(dir,newName);
						fileItem.write(uploadFile);
					}
				}
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
					
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
