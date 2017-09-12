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
	* ��ȡCSV�ļ������б���
	*/  
	public static ArrayList<String[]> readeCsv(String path){  
	    try {      
	        ArrayList<String[]> csvList = new ArrayList<String[]>(); //������������ 
	      
	        CsvReader reader = new CsvReader(path,',',Charset.forName("SJIS"));    //һ�����������Ϳ�����      
	           
	         reader.readHeaders(); // ������ͷ   �����Ҫ��ͷ�Ļ�����Ҫд��䡣  
	           
	         while(reader.readRecord()){ //���ж������ͷ������      
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
	 * д��CSV�ļ� 
	 */  
	public static void writeCsv(String path, List<String> StrList){  
	    try {  
	        String csvFilePath = path;  
	         CsvWriter wr =new CsvWriter(csvFilePath,',',Charset.forName("SJIS"));
	         //str�ĸ�ʽΪ  "aaaaa","bbbbb","cccccc","ddddddddd"
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
