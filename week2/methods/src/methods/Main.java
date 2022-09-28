package methods;

public class Main {

	public static void main(String[] args) {
		sayiBulmaca();
		sayiBulmaca();
		sayiBulmaca();
		sayiBulmaca();
	}
	
	public static void sayiBulmaca() {
		int[] sayilar = new int[] {1,2,5,6,9,0};
		int aranacak = 6;
		boolean varMi = false;
		
		for(int sayi : sayilar) {
			if(sayi==aranacak);
			varMi = true;
			break;
		}
		
		if(varMi) {
			mesajVer("Sayi mevcuttur: aranacak " + aranacak);
			System.out.println("Sayi mevcuttur: aranacak " + aranacak);
		}else {
			mesajVer("Sayi mevcut degildir: "+aranacak);
			System.out.println("Sayi mevcut degildir: " +aranacak);
		}
	}

	public static void mesajVer(String mesaj) {
		System.out.println(mesaj);
	}
}
