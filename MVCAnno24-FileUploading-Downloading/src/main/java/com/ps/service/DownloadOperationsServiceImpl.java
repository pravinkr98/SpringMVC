package com.ps.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DownloadOperationsServiceImpl implements DownloadOperationsService {

	@Override
	public List<String> fetchFiles(String uploadDir) {
		System.out.println("DownloadOperationsServiceImpl::after calling...");
		File uplDir=null;
		File files[]=null;
		List<String> listFiles=null;
		
		//get all files names from upladed folder store
		uplDir=new File(uploadDir);
		System.out.println("DownloadOperationsServiceImpl:: Location :-> "+uploadDir);
		files=uplDir.listFiles();
		if(files==null)
			System.out.println("File does not exits.");
		listFiles=new ArrayList<String>();
		for(File file:files) {
			if(!file.isDirectory())
				listFiles.add(file.getName());
		}
		return listFiles;
	}

}
