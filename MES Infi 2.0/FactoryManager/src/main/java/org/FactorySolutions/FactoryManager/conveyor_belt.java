package org.FactorySolutions.FactoryManager;

public class conveyor_belt {
	
	int id;
	int maq_cima; //tool da maquina a cima do tapete
	int maq_baixo; //tool da maquina a baixo do tapete
	int estado = 0;
	int orientacao = 0; //0 se esta horizontal 1 se esta vertical
	int envia_peca = 0; //informa se o tapete quer enviar uma peça pro segunte
	int envia_peca_maq = 0; //informa se o tapete quer enviar peça para a maquina de cima(1) ou de baixo(2)
	boolean presenca; //informa se esta alguma peça presente no tapete(1) ou se o tapete esta vazio(0)
	boolean sensorRminus, sensorRplus;
	
	
	conveyor_belt(int id, int maq_baixo, int maq_cima){
		this.id = id;
		this.maq_cima = maq_cima;
		this.maq_baixo = maq_baixo;
	}
	void move_left() {
		
	}
	void move_right() {
		
	}
	void rotate_clock() {
		
	}
	void rotate_anticlock() {
		
	}
	int orientacao() {
		if(sensorRplus==true) 
			orientacao=1;
		else if(sensorRminus==true)
			orientacao=0;
		else orientacao=-1;
		return orientacao;
	}
	int envia_peca() {
		return envia_peca;
	}
	boolean presenca() {
		return presenca;
	}
	int envia_peca_maq() {
		return envia_peca_maq;
	}
	int maq_cima() {
		return maq_cima;
	}
	int maq_baixo() {
		return maq_baixo;
	}
	void set_presence(boolean presenca) {
		this.presenca = presenca;
	}
	void set_sensorRminus(boolean sensor) {
		this.sensorRminus = sensor;
	}
	void set_sensorRplus(boolean sensor) {
		this.sensorRplus = sensor;
	}
}