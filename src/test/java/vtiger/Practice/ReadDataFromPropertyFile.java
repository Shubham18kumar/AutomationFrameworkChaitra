package vtiger.Practice;



	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;

	public class ReadDataFromPropertyFile {
		public static void main(String[] args) throws IOException {

			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
			Properties p = new Properties();
			p.load(fis);
			String value = p.getProperty("url");
			System.out.println(value);
			fis.close();
		}
	}

