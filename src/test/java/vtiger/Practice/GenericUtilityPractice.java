package vtiger.Practice;


	import vtiger.GenericUtilities.ExcelFileUtility;
	import vtiger.GenericUtilities.JavaUtility;
	import vtiger.GenericUtilities.PropertyFileUtility;

	public class GenericUtilityPractice {
		public static void main(String[] args) throws Throwable {

			PropertyFileUtility putil = new PropertyFileUtility();
			String value = putil.readDataFromPropertyFile("browser");
			System.out.println(value);

			String un = putil.readDataFromPropertyFile("username");
			System.out.println(un);

			ExcelFileUtility eutil = new ExcelFileUtility();
			String data = eutil.readDataFromExcel("Contacts", 1, 2);
			System.out.println(data);

			eutil.WriteDataIntoExcel("trailNow", 5, 3, "HarryPorter");
			System.out.println("Data added");

			JavaUtility jutil = new JavaUtility();
			System.out.println(jutil.getRandomNumber());

			System.out.println(jutil.getSystemDate());
		}

	}
}
