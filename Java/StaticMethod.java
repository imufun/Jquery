import java.util.*;
public class StaticMethod{

	static int a = 10; // instance variable
	//int b = 20;
	static String item = "imran"; // static variable 

	public static void main(String args[]){		
		int b = 20;

		System.out.println("Test");	
		StaticMethod staticMethod = new  StaticMethod();
		staticMethod.a = a;
		staticMethod.b = b;
		System.out.println("The Integer Number is =" + a);
		System.out.println("The Integer Number is =" + b);
	}
}