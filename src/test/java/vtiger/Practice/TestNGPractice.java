package vtiger.Practice;


	import org.testng.Assert;
	import org.testng.annotations.Test;

	public class TestNGPractice {

		@Test
		public void createCustomer() {
			Assert.fail();
			System.out.println("create");
		}

		@Test
		public void modifyCustomer() {
			System.out.println("modify");
		}

		@Test(dependsOnMethods = { "createCustomer", "modifyCustomer" })
		public void deleteCustomer() {
			System.out.println("delete");
		}
	}

	//@Test (invocationCount = 2,priority = -1)
	//public void createCustomer()
	//{
//		System.out.println("create");
	//}
	//
	//@Test
	//public void modifyCustomer()
	//{
//		System.out.println("modify");
	//}
	//
	//@Test
	//public void deleteCustomer()
	//{
//		System.out.println("delete");
	//}
	//}
}
