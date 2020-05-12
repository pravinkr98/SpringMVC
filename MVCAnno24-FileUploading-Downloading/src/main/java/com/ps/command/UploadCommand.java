package com.ps.command;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UploadCommand {
	private String ename;
	private String eaddrs;
	private MultipartFile ephoto;
	private MultipartFile eresume;

}
