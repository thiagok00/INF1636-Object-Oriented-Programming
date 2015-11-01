package Controlador;


import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;



public class SorteOuReves {
	
	double valor = 0.0;
	public Boolean passePrisao = false;
	public Boolean irPrisao = false;
	public Boolean recebeOutros = false;
	public Image imagem;
	
	public SorteOuReves(int i) {
		if(i==0)
			setPasse();
		else if(i==1)
			setIrPrisao();
	}
	public SorteOuReves(double valor, Boolean recebeOutros){
		this.valor = valor;
		if(recebeOutros)
			setRecebeOutros();
		
	}
	public void setRecebeOutros() {
		recebeOutros = true;
	}
	
	private void setPasse () {
		passePrisao = true;
	}
	
	private void setIrPrisao() {
		irPrisao = true;
	}
	
	public void setImagem (String path) {
		try {
			this.imagem = ImageIO.read(new File(path));
			   
			}
			catch(IOException e) {
			   System.out.println(e.getMessage());
			   System.exit(1);
			}
		}
	
	static public Queue<SorteOuReves> criarCartasBancoImobiliario() {
		
		LinkedList<SorteOuReves> list = new LinkedList<SorteOuReves>();
			
		list.add(new SorteOuReves(-25,false));
		list.add(new SorteOuReves(-45,false));
		list.add(new SorteOuReves(-45,false));
		list.add(new SorteOuReves(-30,false));
		list.add(new SorteOuReves(-40,false));
		list.add(new SorteOuReves(-50,false));
		list.add(new SorteOuReves(-100,false));
		list.add(new SorteOuReves(-50,false));
		list.add(new SorteOuReves(-30,false));
		list.add(new SorteOuReves(-30,false));
		list.add(new SorteOuReves(-25,false));
		list.add(new SorteOuReves(1));
		list.add(new SorteOuReves(-100,false));
		list.add(new SorteOuReves(-50,false));
		list.add(new SorteOuReves(-15,false));
		
		
		DecimalFormat df = new DecimalFormat("00");
		for(int i=1; i <16 ; i++) {
			list.get(i-1).setImagem("sorteReves/reves"+df.format(i)+".jpg");			
		}
		
		list.add(new SorteOuReves(150,false));
		list.add(new SorteOuReves(100,false));
		list.add(new SorteOuReves(0));
		list.add(new SorteOuReves(80,false));
		list.add(new SorteOuReves(100,false));
		list.add(new SorteOuReves(50,true));
		list.add(new SorteOuReves(50,false));
		list.add(new SorteOuReves(20,false));
		list.add(new SorteOuReves(25,false));
		list.add(new SorteOuReves(200,false));
		list.add(new SorteOuReves(100,false));
		list.add(new SorteOuReves(100,false));
		list.add(new SorteOuReves(45,false));
		list.add(new SorteOuReves(50,false));
		list.add(new SorteOuReves(200,false));
		for(int i=1; i <16 ; i++) {
			list.get(i+14).setImagem("sorteReves/sorte"+df.format(i)+".jpg");			
		}
		
		Collections.shuffle(list);
		return list;
		
	}
	
	
}