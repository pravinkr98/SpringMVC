package com.ps.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ps.command.UploadCommand;
import com.ps.service.DownloadOperationsService;

@Controller
public class FileUploadController {
	
	@Autowired
	private DownloadOperationsService service;
	
	@GetMapping("/upload.htm")
	public String showForm(@ModelAttribute("uplCmd")UploadCommand cmd) {
		return "form_upload";
	}
	
	@PostMapping("/upload.htm")
	public String processForm(Map<String,Object> map,@ModelAttribute("uplCmd")UploadCommand cmd,HttpServletRequest req,HttpServletResponse res,BindingResult errors) throws IOException {
		ServletContext sc=null;
		String location=null;
		String resumefile=null,photofile=null;
		File file=null;
		InputStream ris=null,pis=null;
		OutputStream ros=null,pos=null;
		
		//get access to ServletContext object
		sc=req.getServletContext();
		//read context param value
		location=sc.getInitParameter("uploadFolder");
		//check the folder availability, if not available create it
		file=new File(location);
		if(!file.exists())
			file.mkdir();
		//get the names of the uploaded files
		resumefile=cmd.getEresume().getOriginalFilename();
		photofile=cmd.getEphoto().getOriginalFilename();
		//get InputStreams representing uploaded files content
		ris=cmd.getEresume().getInputStream();
		pis=cmd.getEphoto().getInputStream();
		//create OutputStreams pointing empty destination files on the server machine file system
		ros=new FileOutputStream(location+"/"+resumefile);
		pos=new FileOutputStream(location+"/"+photofile);
		//complete file copy operation
		IOUtils.copy(ris, ros);
		IOUtils.copy(pis, pos);
		//close streams
		ris.close();
		ros.close();
		pis.close();
		pos.close();
		//keep the names of uploaded files as the model attributes
		map.put("filename1",resumefile);
		map.put("filename2", photofile);
		//return lvn
		return "success_upload";		
	}
	
	@RequestMapping("/listDown.htm")
	public String listUploadedFiles(Map<String,Object> map,HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		ServletContext sc=null;
		String uploadDir=null;
		List<String> filesList=null;
		PrintWriter pw=null;
		
		//get Access to servletContext object
		sc=req.getServletContext();
		uploadDir=sc.getInitParameter("uploadFolder");
		//use service
		filesList=service.fetchFiles(uploadDir);
		System.out.println(filesList);
		//model attribute
		map.put("filesList", filesList);
		//return "show_files";
		pw=res.getWriter();
		pw.println("File is coming...");
		
		return "show_files";
	}
	
	@RequestMapping("/download.htm")
	public String downloadFile(@RequestParam("fileName")String fname,HttpServletRequest req,HttpServletResponse res) throws IOException {
		ServletContext sc=null;
		File file=null;
		String fileDir=null;
		String mimeType=null;
		InputStream is=null;
		OutputStream os=null;
		
		//get ServletContext object
		sc=req.getServletContext();
		fileDir=sc.getInitParameter("uploadFolder");
		//create File object locating and holding the file to be downloaded
		file=new File(fileDir+"/"+fname);
		//get the length of the file and make it as response content length
		res.setContentLengthLong(file.length());
		//get MIME type of the file and make it as response MIME type
		mimeType=sc.getMimeType(fileDir+"/"+fname);
		res.setContentType(mimeType!=null?mimeType:"application/octet-stream");
		//get InputStream pointing to the file
		is=new FileInputStream(file);
		//create OutputStream pointing to response object
		os=res.getOutputStream();
		//Instruct browser to make received output as downloadable
		res.setHeader("content-disposition", "attachment;fileName="+fname);
		//copy File content to response object
		IOUtils.copy(is, os);
		//close streams
		is.close();
		os.close();
		
		return null;
		
	}
	

}
