package com.gul.test2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestStudent {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		for (int i = 1; i <=10; i++) {
			Student student = new Student();
			Class class1 = student.getClass();
			String chng = "setF"+i;
			Method m1 = class1.getMethod(chng, new Class[] { String.class });
			System.out.println("Calling setF1 method: ");
			m1.invoke(student, new Object[] { "Gulrez "+i});
			String chng2 = "getF"+i;
			Method gs1Method = class1.getMethod(chng2, new Class[] {});
			String str1 = (String) gs1Method.invoke(student, new Object[] {});
			System.out.println("getString1 returned: " + str1);
//		System.out.println("callling method: "+student.getF1());
		}
	}
}
