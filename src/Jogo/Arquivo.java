package Jogo;

import java.io.*;
import java.util.*;

import Pe�as.*;

public class Arquivo {

	public void leituraArquivo(BancoImobiliario jogo) throws IOException
	{
		
		int qtdJogadores,numProp,qtdSede,dono,casaAtual = 0,i;
		double saldo;
		boolean isPreso=false,Comite=false;
		Scanner in = new Scanner(new File("entrada.txt"));
		qtdJogadores=in.nextInt();
		for(i=0; i<qtdJogadores ; i++) {
			
			saldo=in.nextDouble();
			jogo.jogadores[i].setSaldo(saldo);
			numProp=in.nextInt();
			jogo.jogadores[i].casaAtual=casaAtual;
			isPreso=in.nextBoolean();
			jogo.jogadores[i].isPreso = isPreso;
		}
		
		while(in.hasNext()) {
		numProp=in.nextInt();
		qtdSede=in.nextInt();
		Comite=in.nextBoolean();
		dono=in.nextInt();
		
		if(jogo.casas[numProp] instanceof Propriedade)
		{
			Propriedade prop = (Propriedade)jogo.casas[numProp];
			prop.setQtdSedes(qtdSede);
			prop.setComite(Comite);
			jogo.jogadores[dono].credita(prop.getValorCompra());
			jogo.jogadores[dono].comprarTerreno(prop);
		}
		else
		{	
			System.out.println("LIDO DO ARQUIVO NAO EH PROPRIEDADE!!");
		}
		}
	}
}//EOC