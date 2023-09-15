package vtiger.Practice;



	public class GenericMethodPractice {

		public static void main(String[] args) { // caller function

			add(209, 400);

		}

		public static void add(int a, int b) { // not run unless caller call it
												// called function
			int c = a + b;
			System.out.println(c);

		}

	}


