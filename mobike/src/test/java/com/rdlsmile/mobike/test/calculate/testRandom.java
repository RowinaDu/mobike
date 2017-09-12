package com.rdlsmile.mobike.test.calculate;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.rdlsmile.mobike.calculate.base.init;
import com.rdlsmile.mobike.util.csvUtil;
/**
 * 
 * 经验证随机的结果很差 两次随机得分为  1.26477203815351e-05  1.44783114893889e-05
 * 无限趋近于零
 * @author Administrator
 *
 */
public class testRandom {

	public static void main(String[] args) {
		URL path = init.class.getClassLoader().getResource("");
		String inputPath1 = (path+"file/test.csv").replace("file:/", "");
		String inputPath2 = (path+"file/train.csv").replace("file:/", "");
		String outputPath = (path+"file/out.csv").replace("file:/", "");
		
		long start = System.currentTimeMillis();
		//读取文件
		ArrayList<String[]> testCsvList =  csvUtil.readeCsv(inputPath1);
		//读出位置放入集合
		List<String> locList = new ArrayList<String>(8000000);
		List<String> testOrderId = new ArrayList<String>(2500000);
		int pre0 = 0;
		for(String str[] : testCsvList){
			locList.add(str[5]);
			testOrderId.add(str[0]);
			pre0 +=1;
			if(pre0%10000 == 0){
				String p = new DecimalFormat(".00").format(pre0/20029.0);//保留两位小数
				System.out.println(p+"%   累计耗时："+(System.currentTimeMillis()-start));
			}
		
		}
		
		System.out.println("test add ok "+locList.size()+"=="+testOrderId.size());


		//读取文件
		ArrayList<String[]> trainCsvList =  csvUtil.readeCsv(inputPath2);
		//读出位置放入集合
		int pre = 0;
		for(String str[] : trainCsvList){
			//开始位置
			locList.add(str[5]);
			//结束位置
			locList.add(str[6]);
			if(pre%10000 == 0){
				String p = new DecimalFormat(".00").format(pre0/32029.0);//保留两位小数
				System.out.println(p+"%   累计耗时："+(System.currentTimeMillis()-start));
			}
			pre +=1;
		}
		System.out.println("train add ok "+locList.size());
		
		//去重
		locList = removeDuplicateWithOrder(locList);
		
		//产生随机的地址放入结果集
		List<String> resultCsv = new ArrayList<String>(2500000);
		int size = locList.size();
		for(String orderId : testOrderId){
			String result = orderId;
			for(int i=0;i<3;i++){
				int rand = new Random().nextInt(size);
				result +=","+locList.get(rand);
			}
			resultCsv.add(result);
			//System.out.println(result);
		}
		
		//将结果写入csv
		csvUtil.writeCsv(outputPath, resultCsv);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
	
	//集合去重（用contains太消耗时间）
	public static List removeDuplicateWithOrder(List list) {
        Set set = new HashSet(10000000);
        List newList = new ArrayList(8000000);
        for (Iterator iter = list.iterator(); iter.hasNext();) {
            Object element = iter.next();
            if (set.add(element))
                newList.add(element);
        }
        return newList;
    }
	
}
