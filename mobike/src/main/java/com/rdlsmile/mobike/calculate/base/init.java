package com.rdlsmile.mobike.calculate.base;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import com.rdlsmile.mobike.dao.TestDao;
import com.rdlsmile.mobike.dao.TrainDao;
import com.rdlsmile.mobike.entity.Test;
import com.rdlsmile.mobike.entity.Train;
/**
 * ��ʼ�����ݿ�
 * @author Administrator
 *
 */
public abstract class init {
	
	private static TestDao testDao;
	private static TrainDao trainDao;
	
	public static void main(String[] args) throws ParseException {
		
		ApplicationContext ac = getContext.getBean();
		testDao=ac.getBean("testDao", TestDao.class);
		trainDao=ac.getBean("trainDao", TrainDao.class);
		
		
		URL path = init.class.getClassLoader().getResource("");
	    String csvFilePath = (path+"file/test.csv").replace("file:/", "");
		
	   
	   ArrayList<String[]> csvList =  readeCsv(csvFilePath);
	    
	    long start = System.currentTimeMillis();
	    
	    
	    //List<Test> testList = new ArrayList<Test>();;
	    
	    System.out.println(csvList.size());
	    
	    for(int row=0;row<csvList.size();row++){ 
	    	Test test = new Test();
	    	//����id
	    	//String id = UUID.randomUUID().toString().replace("-", "");
	    	test.setOrderid(csvList.get(row)[0]);
	    	test.setUserid(csvList.get(row)[1]);
	    	test.setBikeid(csvList.get(row)[2]);
	    	test.setBiketype(csvList.get(row)[3]);
	    	test.setStarttime( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(csvList.get(row)[4]));
	    	test.setStartloc(csvList.get(row)[5]);
	    	
	    	//�������ݿ�
	    	testDao.save(test);
           // System.out.println("�ɹ����룺"+test);  
            //������ʱ�ļ���
            
           // testList.add(test);
        } 
	   
	   //writeCsv(testList);
	    //testDao.insertAll(testList);
	    
	    long end = System.currentTimeMillis();
		
	    System.out.println((end - start)/1000);
	    
	    /*
	    
	   // long start = System.currentTimeMillis();
	    
	    //List<Test> tlist = testDao.findList(new Test());
	    Train t3 = new Train();
	    //trainDao.get("123");
	    
	    List<Train> ttlist = trainDao.findList(t3);
	    
	    
	    
	    

	    
	    
	    long end1 = System.currentTimeMillis();
	    System.out.println((end1 - start)/1000);
	    
	    for(Train t : ttlist){
	    	
	    	//t.setTestid("1");
	    	
	    	//System.out.println(t);
	   	}
	    
	    
	    
	    
	    
	    long end2 = System.currentTimeMillis();
		System.out.println((end2 - start)/1000);
		
		*/
	}
	
	
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
	public static void writeCsv(List<Test> testList){  
	    try {  
	          
	        String csvFilePath = "C:\\Users\\Administrator\\Desktop\\�½��ļ���\\test_123456.csv";  
	         CsvWriter wr =new CsvWriter(csvFilePath,',',Charset.forName("SJIS"));
	         
	         
	         
	         
	         for(Test test :testList ){
	        	 
	        	 String str = "INSERT INTO `test` VALUES ("
		        			+ "'"+test.getOrderid()+"', "
		        			+ "'"+test.getUserid()+"', "
		        			+ "'"+test.getBikeid()+"', "
		        			+ "'"+test.getBiketype()+"', "
		        			+ "'"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(test.getStarttime())+"', "
		        			+ "'"+test.getStartloc()+"');"	;
	        	 
	        	String[] contents = {str};  
	        	System.out.println(str);
		        wr.writeRecord(contents);  
	         }
	         wr.close();  
	     } catch (IOException e) {  
	        e.printStackTrace();  
	     }  
	}  
	
	
	
	
	
	
	
}