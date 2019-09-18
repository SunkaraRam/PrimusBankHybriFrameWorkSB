package com.primusbank.tests;

import java.util.Scanner;

public class FirstDemo {

	public static void main(String[] args) {
		
		System.out.print("Enter any String ; ");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		
		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);
			if (!(ch>=45 && ch<=51) && !(ch>=65&&ch<=90) && !(ch>=97 && ch<=122)) {
				System.out.print(name.indexOf(ch)+" ");
			}
		}
		
	}

}
