package Testng;

import org.testng.annotations.Test;

public class Priority {
	@Test(priority=-1)
	private void test1() {
		System.out.println("test1");

	}
	@Test(priority=4)
private void test2() {
	System.out.println("test2");
}
	@Test(priority=-19)
	private void test3() {
		System.out.println("test3");

	}
	//ignorecase (default=0)
	@Test(enabled=true)
	private void test4() {
		System.out.println("test4");
			}
	
	
	
}
