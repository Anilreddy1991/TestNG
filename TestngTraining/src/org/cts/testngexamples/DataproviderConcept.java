package org.cts.testngexamples;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderConcept {
@DataProvider
public Object[][] testdata(){
	Object[][] data=new Object[2][2];
	data[0][0]="test1";
	data[0][1]="test2";
	
	data[1][0]="test3";
	data[1][1]="test4";
	return data;
	}
@DataProvider
public Object[][] testdata1(){
	Object[][] data=new Object[3][3];
	data[0][0]=1;
	data[0][1]=2;
	data[0][2]=3;
	
	data[1][0]=4;
	data[1][1]=5;
	data[1][2]=6;
	
	data[2][0]=7;
	data[2][1]=8;
	data[2][2]=9;
	
	return data;
}
@Test(dataProvider="testdata")
public void test(String s1,String s2) {
	System.out.println("s1:"+s1+"s2:"+s2);
}
@Test(dataProvider="testdata1")
public void test1(int s1,int s2,int s3) {
	System.out.println("s1:"+s1+"s2:"+s2+"s3:"+s3);
}

	
}


