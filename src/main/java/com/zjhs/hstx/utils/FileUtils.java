package com.zjhs.hstx.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


public class FileUtils {
	
	/**
	 * 
	 * @param file 文件
	 * @param path   文件存放路径
	 * @param fileName 原文件名
	 * @return
	 */
	 public static boolean upload(MultipartFile file, String path, String newFileName){
		 	
	        // 生成新的文件名
	        String realPath = path + "/" + newFileName;
	        //使用原文件名
	       // String realPath = path + "/" + fileName;

	        File dest = new File(realPath);

	        //判断文件父目录是否存在
	        if(!dest.getParentFile().exists()){
	            dest.getParentFile().mkdir();
	        }

	        try {
	            //保存文件
	            file.transferTo(dest);
	            return true;
	        } catch (IllegalStateException e) {	            
	            e.printStackTrace();
	            return false;
	        } catch (IOException e) {
	       	    e.printStackTrace();
	            return false;
	        }

	    }

	/**
	 * 获取文件后缀
	 * @param fileName
	 * @return
	 */
	public static String getSuffix(String fileName){
		return fileName.substring(fileName.lastIndexOf("."));
	}

	/**
	 * 生成新的文件名
	 * @param fileOriginName 源文件名
	 * @return
	 */
	public static String getFileName(String fileOriginName){
		return UUID.randomUUID() + getSuffix(fileOriginName);
	}
}
