package switchDemo;

public class Main {

	public static void main(String[] args) {
		char grade = 'A';

		switch (grade) {
		case 'A':
			System.out.println("Perfect : Passed");
			break;
		case 'B':
			System.out.println("Very Good : Passed");
			break;
		case 'C':
			System.out.println("Good : Passed");
			break;
		case 'D':
			System.out.println("Not Bad : Passed");
			break;
		case 'F':
			System.out.println("Unfortunate : Failed");
			break;
		default:
			System.out.println("Inserted invalid grade");
		}

	}

}
