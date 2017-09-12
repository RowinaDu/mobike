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
 * ����֤����Ľ���ܲ� ��������÷�Ϊ  1.26477203815351e-05  1.44783114893889e-05
 * ������������
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
		//��ȡ�ļ�
		ArrayList<String[]> testCsvList =  csvUtil.readeCsv(inputPath1);
		//����λ�÷��뼯��
		List<String> locList = new ArrayList<String>(8000000);
		List<String> testOrderId = new ArrayList<String>(2500000);
		int pre0 = 0;
		for(String str[] : testCsvList){
			locList.add(str[5]);
			testOrderId.add(str[0]);
			pre0 +=1;
			if(pre0%10000 == 0){
				String p = new DecimalFormat(".00").format(pre0/20029.0);//������λС��
				System.out.println(p+"%   �ۼƺ�ʱ��"+(System.currentTimeMillis()-start));
			}
		
		}
		
		System.out.println("test add ok "+locList.size()+"=="+testOrderId.size());


		//��ȡ�ļ�
		ArrayList<String[]> trainCsvList =  csvUtil.readeCsv(inputPath2);
		//����λ�÷��뼯��
		int pre = 0;
		for(String str[] : trainCsvList){
			//��ʼλ��
			locList.add(str[5]);
			//����λ��
			locList.add(str[6]);
			if(pre%10000 == 0){
				String p = new DecimalFormat(".00").format(pre0/32029.0);//������λС��
				System.out.println(p+"%   �ۼƺ�ʱ��"+(System.currentTimeMillis()-start));
			}
			pre +=1;
		}
		System.out.println("train add ok "+locList.size());
		
		//ȥ��
		locList = removeDuplicateWithOrder(locList);
		
		//��������ĵ�ַ��������
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
		
		//�����д��csv
		csvUtil.writeCsv(outputPath, resultCsv);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
	
	//����ȥ�أ���contains̫����ʱ�䣩
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
