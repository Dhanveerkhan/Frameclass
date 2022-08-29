package Rerun;

import org.apache.commons.lang3.function.Failable;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Rerun {
	@Test
	private void method1() {
		System.out.println("123");
		
	}
	@Test(retryAnalyzer=Failedclass.class)
private void method2() {
	System.out.println("456");
	Assert.assertTrue(false);
	}
	@Test
	private void method3() {
		System.out.println("789");
	}
	
	
}
