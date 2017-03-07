package com.rakesh.milk.dairy;

public class Test {

	public static void main(String[] args) {
		String regex = "((?<=[a-zA-Z])(?=[0-9]))|((?<=[0-9])(?=[a-zA-Z]))";
		String str= "PA0100pwd";
		String[] split = str.split(regex);
		//System.out.println(split[0] +" === "+split[1]);
		
		for(String st:split) {
			System.out.println(st);
		}
	}
}
