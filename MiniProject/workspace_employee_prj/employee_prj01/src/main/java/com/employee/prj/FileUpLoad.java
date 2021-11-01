package com.employee.prj;

import java.io.File;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileUpLoad {
	
	private MultipartFile multi;
	private String newFileName;
	
	public FileUpLoad(MultipartFile multi){
		this.multi = multi;
		// 만약 업로드된 파일이 있으면
		if(multi!=null && multi.isEmpty()==false) {
			// 업로드한 파일의 원래 파일명 얻기. 파일명에는 확장자가 포함한다.
			String oriFileName = multi.getOriginalFilename();
			// 업로드한 파일의 파일확장자 얻기
			String file_extension = oriFileName.substring(oriFileName.lastIndexOf(".")+1);
			
			this.newFileName = UUID.randomUUID() + "." + file_extension;
		
		}
	}
	
	
	
	public  String getNewFileName(){

		return newFileName;
	}
	public  String getNewFileName(boolean flag){

		return flag?newFileName:null;
	}	
	
	
	
	public void uploadFile(String upLoadDir) throws Exception{
		if(multi!=null && multi.isEmpty()==false && newFileName!=null && newFileName.length()>0) {
			// 새 파일을 생성하기. File 객체를 생성하면 새 파일을 생성할수있다.
			File file = new File( upLoadDir + newFileName);
			// 업로드한 파일을 새 파일에 전송하여 덮어쓰기
			multi.transferTo(file);
		}
	}

	
	
	
	public void delete(String filePath) {
			File file = new File(filePath);
			// 업로드한 파일을 새 파일에 전송하여 덮어쓰기
			file.delete();
	}
	
	public void delete(String filePath, boolean flag) {
		if(flag==true) {
			delete(filePath);
		}
}


}
	
/*
  사용방법
  
  FileUpLoad fileUpload = new FileUpLoad(multi);
  board.setPic(fileUpload.getNewFIleName());
  
  DB 연동 코드
  
  fileUpload.uploadFile()
 
 
 */
	
	

