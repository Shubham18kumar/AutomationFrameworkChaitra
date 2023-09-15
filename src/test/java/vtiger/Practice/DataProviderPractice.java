package vtiger.Practice;



	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

	public class DataProviderPractice {

		@Test(dataProvider = "getData")
		public void addProductToCart(String name, String model, int price) {
			System.out.println(+price + " - " + model + " - " + price);
		}

		@DataProvider
		public Object[][] getData() {

			Object[][] data = new Object[4][3];

			data[0][0] = "Samsung";
			data[0][1] = "A80";
			data[0][2] = 13000;

			data[1][0] = "vivo";
			data[1][1] = "Y21";
			data[1][2] = 15000;

			data[2][0] = "Iphone";
			data[2][1] = "S13";
			data[2][2] = 15000;

			data[3][0] = "Oppo";
			data[3][1] = "A12";
			data[3][2] = 8000;
			return data;
		}

	}
}
