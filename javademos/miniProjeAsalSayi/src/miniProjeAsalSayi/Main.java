package miniProjeAsalSayi;

public class Main {

	public static void main(String[] args) {
		int number = 1;
		int remainder = number % 2;
		System.out.println(remainder);
		
		boolean isPrime = true;
		
		if(number==1) {
			System.out.println("Sayi asal degildir!");
		}
		
		if(number<1) {
			System.out.println("Gecersiz sayi!");
		}
		
		for (int i=2; i<number;i++) {
			if(number % i == 0) {
				isPrime = false;
			}
		}
		
		if (isPrime) {
			System.out.println("Girilen Deger Asal Sayidir!");
			
		} else { System.out.println("Girilen Deger Asal Sayi degil!");

		}

	}

}
