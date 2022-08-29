package Test.groupby;

 
	import org.apache.xmlbeans.impl.xb.xsdschema.Group;
import org.testng.annotations.Test;

	public class Class1 {
		@Test(groups="sanity")
		private void method1() {
			System.out.println("123");
		}
	@Test(groups="reg")
		private void method2() {
			System.out.println("456");
		
				}
		@Test(groups="e2e")
	private void method3() {
		System.out.println("789");
		
	}

}
