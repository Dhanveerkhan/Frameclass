package Test.groupby;

import org.testng.annotations.Test;

public class Class2 {
	@Test(groups="reg")
	private void method4() {
		System.out.println("123");
	}
@Test(groups="sanity")
	private void method5() {
		System.out.println("456");
	
			}
	@Test(groups="e2e")
private void method6() {
	System.out.println("789");
	
	}
}
