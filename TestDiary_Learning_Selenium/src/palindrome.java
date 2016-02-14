import java.util.Scanner;

public class palindrome {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		System.out.println("insert start to start palindrome");
		String insert = new Scanner(System.in).nextLine();

		while (insert.equalsIgnoreCase("start")){
			String dew, reverse = "";

			System.out.println("insert your word");

			dew = new Scanner(System.in).nextLine();

			int size = dew.length();

			for (int i = size - 1; i >= 0; i--) {

				reverse = reverse + dew.charAt(i);
			}

			try {
				org.junit.Assert.assertEquals(reverse, dew);
				System.out.println(dew + " is a palindrome with " + reverse);
			} catch (AssertionError e) {
				System.out.println(dew + " is not a palindrome");
			}
			
			System.out.println("Please insert start to continue");
			System.out.println("insert stop to stop palindrome");
			insert = new Scanner(System.in).nextLine();
		}
	}
}
