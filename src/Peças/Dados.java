package Pe�as;
import java.util.Random;

public class Dados {

	private int dado1;
	private int dado2;
	 

	public Dados() {
		Random gerador = new Random();
		
		int randomNumber = gerador.nextInt(7 - 1) + 1;
		int randomNumber2 = gerador.nextInt(7 - 1) + 1;
		
		this.dado1 = randomNumber;
		this.dado2 = randomNumber2;
	}
	public Dados(int dado1,int dado2) {
		this.dado1 = dado1;
		this.dado2 = dado2;
		
	}
	
	public int getDado1(){
		return this.dado1;
	}
	public int getDado2(){
		return this.dado2;
	}
	public int getSoma() {
		return this.dado1 + this.dado2;	
	}
}
