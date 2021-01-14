package com.saran;

class ABC{
	int x=12;
	
	void test() {
		System.out.println("calling from abc");
	}
	
	
}

public class TestEmp extends ABC {
  int x=20;
  void test() {
		System.out.println("calling from TestEmp");
	}
	
	public static void main(String[] args) {
		 ABC a1=new TestEmp();
		 System.out.println(a1.x);//12  correct
		 a1.test();//calling from abc  wrong
		}
	}

