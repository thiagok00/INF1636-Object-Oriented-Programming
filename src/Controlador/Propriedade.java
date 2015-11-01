package Controlador;

public class Propriedade extends Terreno {
	
	private int qtdSedes = 0;
	private Boolean temComite = false;
	private double valorSede = 0.0;
	private double valorComite = 0.0;
	private int vetorPrecos[] = null; 
	
	Propriedade(int posX,int posY,int preco,int valorSede, int valorComite,int vetorPrecos[]){
		super(posX,posY,preco);
		
		this.valorSede = valorSede;
		this.valorComite = valorComite;		
		this.vetorPrecos = vetorPrecos; 
	}

	@Override
	Boolean pagarTaxa(Jogador pagador, Dados dado) {
		if(dono != null) 
			if(temComite)
			{
				if(pagador.debita(vetorPrecos[5])) {
					dono.credita(vetorPrecos[5]);
				}
			}
			else
			if(pagador.debita(vetorPrecos[qtdSedes])) {
				dono.credita(vetorPrecos[qtdSedes]);
			}	
		return false;
	}
	
	Jogador getDono() {
		return dono;
	}
	
	int getQtdSedes() {
		return qtdSedes;
	}
	
	Boolean construirSede() {
		if (dono != null && !dono.isPreso) {
			if (qtdSedes<4) {
				if(dono.debita(valorSede)){
					qtdSedes++;
					return true;
				}
			}
		}
		return false;	
	}
	
	Boolean construirComite() {	
		if (dono != null && !dono.isPreso) {
			if (qtdSedes==4) {
				if(dono.debita(valorComite)){
					temComite = true;
					return true;
				}
			}
		}
		return false;	
	}
	
	Boolean venderConstrucao() {
		if (dono != null) {
			if (qtdSedes>0) {
				
				if (temComite) {
					dono.credita(valorComite/2);
					temComite = false;
				}
				else {
					dono.credita(valorSede/2);
					qtdSedes--;
				}
				return true;
			}
			
		}
		return false;
	}

	@Override
	Double getTaxa() {
		if(this.temComite)
			return vetorPrecos[5]*1.0;
		else
			return vetorPrecos[this.qtdSedes]*1.0;
	}
	
	
}//End of Class
