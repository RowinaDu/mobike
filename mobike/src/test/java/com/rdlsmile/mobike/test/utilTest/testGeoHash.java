package com.rdlsmile.mobike.test.utilTest;

import java.util.ArrayList;
import java.util.List;

import ch.hsr.geohash.GeoHash;
import ch.hsr.geohash.WGS84Point;

public class testGeoHash {

	public static void main(String[] args) {
		double lat = 30.541093;
        double lon = 114.360734;

        int precision = 6;
        GeoHash geoHash = GeoHash.withCharacterPrecision(lat, lon, precision);
        String hashCode = geoHash.toBase32();
        
        GeoHash.fromGeohashString("wx4dztn8");
        
        WGS84Point w = GeoHash.fromGeohashString("wx4dztn8").getBoundingBoxCenterPoint();
        
        System.out.println(w+"=="+w.getLatitude()+"--"+w.getLongitude());
        
        System.out.println( GeoHash.fromGeohashString("wx4dztn8").getBoundingBoxCenterPoint());
        
        
        
        
        
        System.out.print("GeoHash编码为：");
        System.out.println(hashCode);
        String binaryCode = geoHash.toBinaryString();
        System.out.print("对应的二进制编码为：");
        System.out.println(binaryCode);
        int length = binaryCode.length();

        System.out.print("对应的十进制编码为：");
        for(int i = 0; i < length; i+=5) {
            String code = binaryCode.substring(i, i + 5);
            int num = Integer.valueOf(code, 2);
            System.out.print(num);
            System.out.print(" ");
        }
        System.out.println();

        char[] binaryCodes = binaryCode.toCharArray();
        List<Character> latCodes = new ArrayList<Character>();
        List<Character> lonCodes = new ArrayList<Character>();
        for (int i = 0; i < binaryCodes.length; i++) {
            if (i % 2 == 0) {
                lonCodes.add(binaryCodes[i]);
            } else {
                latCodes.add(binaryCodes[i]);
            }
        }
        StringBuilder latCode = new StringBuilder();
        StringBuilder lonCode = new StringBuilder();
        for (Character ch : latCodes) {
            latCode.append(ch);
        }
        for (Character ch : lonCodes) {
            lonCode.append(ch);
        }

        System.out.print("维度编码为：");
        System.out.println(latCode.toString());
        System.out.print("经度编码为：");
        System.out.println(lonCode.toString());
    }
	
}
