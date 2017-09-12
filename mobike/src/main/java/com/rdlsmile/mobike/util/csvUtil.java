package com.rdlsmile.mobike.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class csvUtil {

	/** 
	* 读取CSV文件返回列表集合
	*/  
	public static ArrayList<String[]> readeCsv(String path){  
	    try {      
	        ArrayList<String[]> csvList = new ArrayList<String[]>(); //用来保存数据 
	      
	        CsvReader reader = new CsvReader(path,',',Charset.forName("SJIS"));    //一般用这编码读就可以了      
	           
	         reader.readHeaders(); // 跳过表头   如果需要表头的话，不要写这句。  
	           
	         while(reader.readRecord()){ //逐行读入除表头的数据      
	             csvList.add(reader.getValues());  
	         } 
	         System.out.println("read down");
	         reader.close();  
	         return csvList;
	    }catch(Exception ex){  
	        System.out.println(ex);
	        return null;
	    }  
	}  
	  
	/** 
	 * 写入CSV文件 
	 */  
	public static void writeCsv(String path, List<String> StrList){  
	    try {  
	        String csvFilePath = path;  
	         CsvWriter wr =new CsvWriter(csvFilePath,',',Charset.forName("SJIS"));
	         //str的格式为  "aaaaa","bbbbb","cccccc","ddddddddd"
	         for(String str :StrList){
	        	String[] contents = {str};  
	        	//System.out.println(str);
		        wr.writeRecord(contents);  
	         }
	         wr.close();  
	     } catch (IOException e) {  
	        e.printStackTrace();  
	     }  
	}  
	
	
}
