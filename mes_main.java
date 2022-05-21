package org.FactorySolutions.FactoryManager;

import java.util.ArrayList;
import java.util.Arrays;

public class mes_main {
	
	static ArrayList<Boolean> list = new ArrayList<Boolean>(Arrays.asList(new Boolean[10]));

	
	//*******************CRIAR MÁQUINAS************************
	static machine M1 = new machine(1,1,1);
	static machine M2 = new machine(2,1,1);
	static machine M3 = new machine(3,2,2);
	static machine M4 = new machine(4,3,1);
	static machine M5 = new machine(5,3,2);
	static machine M6 = new machine(6,4,2);
	
	//*******************CRIAR TAPETES************************
	static conveyor_belt TP1 = new conveyor_belt(1,0,0);
	static conveyor_belt TP2 = new conveyor_belt(2,0,0);
	static conveyor_belt TP3 = new conveyor_belt(3,0,0);
	static conveyor_belt TP4 = new conveyor_belt(4,0,0);
	static conveyor_belt TP5 = new conveyor_belt(5,0,0);
	static conveyor_belt TP6 = new conveyor_belt(6,1,0);
	static conveyor_belt TP7 = new conveyor_belt(7,1,2);
	static conveyor_belt TP8 = new conveyor_belt(8,3,3);
	static conveyor_belt TP9 = new conveyor_belt(9,4,0);
	static conveyor_belt TP10 = new conveyor_belt(10,0,0);
	static conveyor_belt TP11 = new conveyor_belt(11,0,0);
	static conveyor_belt TP12 = new conveyor_belt(12,0,0);
	static conveyor_belt TP13 = new conveyor_belt(13,0,0);
	static conveyor_belt TP14 = new conveyor_belt(14,0,0);
	static conveyor_belt TP15 = new conveyor_belt(15,0,0);
	static conveyor_belt TP16 = new conveyor_belt(16,0,0);
	static conveyor_belt TP17 = new conveyor_belt(17,0,0);
	static conveyor_belt TP18 = new conveyor_belt(18,0,0);
	static conveyor_belt TP19 = new conveyor_belt(19,0,0);
	static conveyor_belt TP20 = new conveyor_belt(20,0,0);
	
	//rollers
	static conveyor_belt TP21 = new conveyor_belt(21,0,0);
	static conveyor_belt TP22 = new conveyor_belt(22,0,0);
	static conveyor_belt TP23 = new conveyor_belt(23,0,0);
	
	static conveyor_belt TP211 = new conveyor_belt(211,0,0);
	static conveyor_belt TP212 = new conveyor_belt(212,0,0);
	static conveyor_belt TP213 = new conveyor_belt(213,0,0);
	
	static conveyor_belt TP221 = new conveyor_belt(221,0,0);
	static conveyor_belt TP222 = new conveyor_belt(222,0,0);
	static conveyor_belt TP223 = new conveyor_belt(223,0,0);
	
	static conveyor_belt TP231 = new conveyor_belt(231,0,0);
	static conveyor_belt TP232 = new conveyor_belt(23,0,0);
	static conveyor_belt TP233 = new conveyor_belt(233,0,0);
	
	public static int localizacao_peca(int tapete, ArrayList<piece> pieces_vector) {
		
		int id=-1;
		
		for(int i=0; i<pieces_vector.size();i++) {
			if(pieces_vector.get(i).position==tapete) {
				id = i;
			}
		}
		
		return id;
	}

	public static void atualiza_inputs() throws Exception {
	
	//*******************LER INPUTS************************
	
	ReadNode example = new ReadNode();
	System.out.println("NOVA LEITURA");
	new ClientRunner(example).run();
	list = example.get_list();
	
	for(int i=0;i<list.size();i++) {
		System.out.println(list.get(i));
	}
	
	M6.set_presence(list.get(0));
	TP12.set_presence(list.get(1));
	TP19.set_presence(list.get(2));
	TP8.set_presence(list.get(3));
	M2.set_sensorZminus(list.get(4));
	TP232.set_presence(list.get(5));
	TP5.set_presence(list.get(6));
	TP7.set_sensorRminus(list.get(7));
	TP6.set_presence(list.get(8));
	M3.set_sensorXplus(list.get(9));
	TP3.set_presence(list.get(10));
	M5.set_sensorXplus(list.get(11));
	TP213.set_presence(list.get(12));
	TP12.set_sensorRplus(list.get(13));
	TP18.set_presence(list.get(14));
	M4.set_sensorTool(list.get(15));
	M6.set_sensorTool(list.get(16));
	TP17.set_presence(list.get(17));
	M3.set_presence(list.get(18));
	M6.set_sensorXplus(list.get(19));
	TP13.set_presence(list.get(20));
	M5.set_sensorXminus(list.get(21));
	TP211.set_presence(list.get(22));
	M5.set_sensorTool(list.get(23));
	TP21.set_presence(list.get(24));
	TP2.set_sensorRminus(list.get(25));
	TP21.set_sensorRminus(list.get(26)); //corrigir pra Pminus
	TP222.set_presence(list.get(27));
	TP22.set_sensorRminus(list.get(28)); //corrigir pra Pminus
	TP23.set_presence(list.get(29));
	TP1.set_presence(list.get(30));
	M4.set_sensorZplus(list.get(31));
	M6.set_sensorZplus(list.get(32));
	M2.set_sensorZplus(list.get(33));
	M1.set_sensorZplus(list.get(34));
	M3.set_sensorZplus(list.get(35));
	M5.set_sensorZplus(list.get(36));
	M2.set_presence(list.get(37));
	M3.set_sensorTool(list.get(38));
	M2.set_sensorXminus(list.get(39));
	M1.set_sensorXminus(list.get(40));
	TP10.set_presence(list.get(41));
	TP2.set_sensorRplus(list.get(42));
	M2.set_sensorTool(list.get(43));
	TP22.set_sensorRplus(list.get(44)); //corrigir pra Pplus
	M4.set_sensorXminus(list.get(45));
	TP16.set_presence(list.get(46));
	TP23.set_sensorRplus(list.get(47)); //corrigir para Pplus
	TP231.set_presence(list.get(48));
	TP9.set_presence(list.get(49));
	TP21.set_sensorRplus(list.get(50)); //corrigir para Pplus
	TP20.set_sensorRminus(list.get(51));
	M4.set_sensorZminus(list.get(52));
	TP11.set_presence(list.get(53));
	TP8.set_sensorRminus(list.get(54));
	TP7.set_presence(list.get(55));
	M1.set_sensorTool(list.get(56));
	M1.set_sensorZminus(list.get(57));
	TP4.set_presence(list.get(58));
	TP6.set_sensorRminus(list.get(59));
	TP212.set_presence(list.get(60));
	M1.set_sensorXplus(list.get(61));
	M6.set_sensorXminus(list.get(62));
	TP20.set_sensorRplus(list.get(63));
	TP23.set_sensorRminus(list.get(64)); //corrigir para Pminus
	TP14.set_presence(list.get(65));
	TP15.set_sensorRplus(list.get(66));
	M4.set_sensorXplus(list.get(67));
	TP20.set_presence(list.get(68));
	M2.set_sensorXplus(list.get(69));
	M3.set_sensorXminus(list.get(70));
	M5.set_presence(list.get(71));
	M3.set_sensorZminus(list.get(72));
	TP7.set_sensorRplus(list.get(73));
	M6.set_sensorZminus(list.get(74));
	TP12.set_sensorRminus(list.get(75));
	M5.set_sensorZminus(list.get(76));
	TP8.set_sensorRplus(list.get(77));
	TP223.set_presence(list.get(78));
	TP22.set_presence(list.get(79));
	TP6.set_sensorRplus(list.get(80));
	M1.set_presence(list.get(81));
	TP2.set_presence(list.get(82));
	TP15.set_sensorRminus(list.get(83));
	TP221.set_presence(list.get(84));
	TP9.set_sensorRminus(list.get(85));
	TP15.set_presence(list.get(86));
	TP9.set_sensorRplus(list.get(87));
	TP233.set_presence(list.get(88));
	M4.set_presence(list.get(89));
	
}

	public static void main(String[] args) throws Exception {
		
		int id_peca_TP5=0, id_peca_TP6=0, id_peca_TP7=0, id_peca_TP8=0, id_peca_TP9=0, id_peca_TP10=0, id_peca_TP11=0, id_peca_TP12=0, id_peca_TP13=0, id_peca_TP14=0, id_peca_TP15=0, id_peca_TP16=0;
		int TP5_tem_peca=0, TP6_tem_peca=0, TP7_tem_peca=0, TP8_tem_peca=0, TP9_tem_peca=0, TP10_tem_peca=0, TP11_tem_peca=0, TP12_tem_peca=0, TP13_tem_peca=0, TP14_tem_peca=0, TP15_tem_peca=0, TP16_tem_peca=0;
		ArrayList<piece> pieces_vector = new ArrayList<piece>(); //vetor com as peças que estão na floor plant
		
		pieces_vector.add(new piece());
		
		
		while (true) {
			
			//*******************LER INPUTS************************
			
			atualiza_inputs();
			
			//*******************ATUALIZAR POSICAO PEÇAS************************
			///*
			if(localizacao_peca(1,pieces_vector)!=-1) {
				id_peca_TP1 = localizacao_peca(1,pieces_vector);
				TP1_tem_peca=1;
			}
			else TP1_tem_peca=0;

			if(localizacao_peca(2,pieces_vector)!=-1) {
				id_peca_TP2 = localizacao_peca(2,pieces_vector);
				TP2_tem_peca=1;
			}
			else TP2_tem_peca=0;

			if(localizacao_peca(3,pieces_vector)!=-1) {
				id_peca_TP3 = localizacao_peca(3,pieces_vector);
				TP3_tem_peca=1;
			}
			else TP3_tem_peca=0;

			if(localizacao_peca(4,pieces_vector)!=-1) {
				id_peca_TP4 = localizacao_peca(4,pieces_vector);
				TP4_tem_peca=1;
			}
			else TP4_tem_peca=0;
			if(localizacao_peca(5,pieces_vector)!=-1) {
				id_peca_TP5 = localizacao_peca(5,pieces_vector);
				TP5_tem_peca=1;
			}
			else TP5_tem_peca=0;
			
			if(localizacao_peca(6,pieces_vector)!=-1) {
				id_peca_TP6 = localizacao_peca(6,pieces_vector);
				TP6_tem_peca=1;
			}
			else TP6_tem_peca=0;
			
			if(localizacao_peca(7,pieces_vector)!=-1) {
				id_peca_TP7 = localizacao_peca(7,pieces_vector);
				TP7_tem_peca=1;
			}
			else TP7_tem_peca=0;
			
			if(localizacao_peca(8,pieces_vector)!=-1) {
				id_peca_TP8 = localizacao_peca(8,pieces_vector);
				TP8_tem_peca=1;
			}
			else TP8_tem_peca=0;
			
			if(localizacao_peca(9,pieces_vector)!=-1) {
				id_peca_TP9 = localizacao_peca(9,pieces_vector);
				TP9_tem_peca=1;
			}
			else TP9_tem_peca=0;
			
			if(localizacao_peca(10,pieces_vector)!=-1) {
				id_peca_TP10 = localizacao_peca(10,pieces_vector);
				TP10_tem_peca=1;
			}
			else TP10_tem_peca=0;
			
			if(localizacao_peca(11,pieces_vector)!=-1) {
				id_peca_TP11 = localizacao_peca(11,pieces_vector);
				TP11_tem_peca=1;
			}
			else TP11_tem_peca=0;
			
			if(localizacao_peca(12,pieces_vector)!=-1) {
				id_peca_TP12 = localizacao_peca(12,pieces_vector);
				TP12_tem_peca=1;
			}
			else TP12_tem_peca=0;
			
			if(localizacao_peca(13,pieces_vector)!=-1) {
				id_peca_TP13 = localizacao_peca(13,pieces_vector);
				TP13_tem_peca=1;
			}
			else TP13_tem_peca=0;
			
			if(localizacao_peca(14,pieces_vector)!=-1) {
				id_peca_TP14 = localizacao_peca(14,pieces_vector);
				TP14_tem_peca=1;
			}
			else TP14_tem_peca=0;
			
			if(localizacao_peca(15,pieces_vector)!=-1) {
				id_peca_TP15 = localizacao_peca(15,pieces_vector);
				TP15_tem_peca=1;
			}
			else TP15_tem_peca=0;
			
			if(localizacao_peca(16,pieces_vector)!=-1) {
				id_peca_TP16 = localizacao_peca(16,pieces_vector);
				TP16_tem_peca=1;
			}
			else TP16_tem_peca=0;
			if(localizacao_peca(19,pieces_vector)!=-1) {
				id_peca_TP19 = localizacao_peca(19,pieces_vector);
				TP19_tem_peca=1;
			}
			else TP19_tem_peca=0;

			if(localizacao_peca(20,pieces_vector)!=-1) {
				id_peca_TP20 = localizacao_peca(20,pieces_vector);
				TP20_tem_peca=1;
			}
			else TP20_tem_peca=0;

			if(localizacao_peca(21,pieces_vector)!=-1) {
				id_peca_TP21 = localizacao_peca(21,pieces_vector);
				TP21_tem_peca=1;
			}
			else TP21_tem_peca=0;
			if(localizacao_peca(22,pieces_vector)!=-1) {
				id_peca_TP22 = localizacao_peca(22,pieces_vector);
				TP22_tem_peca=1;
			}
			else TP22_tem_peca=0;
			if(localizacao_peca(23,pieces_vector)!=-1) {
				id_peca_TP23 = localizacao_peca(23,pieces_vector);
				TP23_tem_peca=1;
			}
			else TP23_tem_peca=0;
				
			//*******************DISPARAR TRANSIÇÕES************************
			
			//TRANSIÇÕES TAPETE 1
			if (TP1.estado == 0 && TP1.presenca() == true && TP3.presenca() == true) TP1.estado = 1;
			else if (TP1.estado == 0 && TP1.presenca() == true && TP3.presenca() == false) TP1.estado = 2;
			else if (TP1.estado == 1 && TP3.presenca() == false) TP1.estado = 2;
			else if (TP1.estado == 2 && TP2.estado() == 1) TP1.estado = 3;
			else if (TP1.estado == 3 && TP2.estado() == 4) TP1.estado = 0; 

			//TRANSIÇÕES TAPETE 2
			if (TP2.estado == 0 && TP2.orientacao == 1) TP2.estado == 1;
			else if (TP2.estado == 1 && TP1.estado == 2 && TP3.estado != 2) TP2.estado == 2;
			else if (TP2.estado == 1 && TP1.estado != 2 && TP3.estado == 2) TP2.estado == 3;
			else if (TP2.estado == 2 && TP2.presenca == true) TP2.estado == 4;
			else if (TP2.estado == 3 && TP2.presenca == true) TP2.estado == 4;
			else if (TP2.estado == 4 && TP2.orientacao == 0) TP2.estado == 5;
			else if (TP2.estado == 5 && TP4.estado == 2) TP2.estado == 0;

			//TRANSIÇÕES TAPETE 3
			if (TP3.estado == 0 && TP3.presenca() == true && TP1.presenca() == true) TP3.estado = 1;
			else if (TP3.estado == 0 && TP3.presenca() == true && TP1.presenca() == false) TP3.estado = 2;
			else if (TP3.estado == 1 && TP1.presenca() == false) TP3.estado = 2;
			else if (TP3.estado == 2 && TP2.estado() == 1) TP3.estado = 3;
			else if (TP3.estado == 3 && TP2.estado() == 4) TP3.estado = 0; 

			//TRANSIÇÕES TAPETE 4
			if (TP4.estado == 0 && TP2.estado == 5) TP4.estado = 1;
			else if (TP4.estado == 1 && TP4.presenca() == true) TP4.estado = 2;
			else if (TP4.estado == 2) { TP4.estado = 3; //&& condicao armazem não esta cheio
			else if (TP4.estado == 3 &&  TP4.push_sensor = 1) TP4.estado = 0;//TP4.estado = 3;//isto ficaria sem efeito && pusher acaba extensão (TP4.fe == true)
			//else if (TP4.estado == 3 &&  ) TP4.estado = 0;//isto ficaria sem efeito && pusher acaba recolha (TP4.fr == true)

			//TRANSIÇÕES TAPETE 5
			if (TP5.estado == 0 && TP5.pop_sensor = 1) {
				TP5.estado = 1;
			}
			if (TP5.estado == 1 && TP6.estado == 0) {
				TP5.estado = 2; //TP5.envia_peca()=1
			}
			if (TP5.estado == 2 && TP6.presenca() == true) {
				TP5.estado = 0;
			}
			//TRANSIÇÕES TAPETE 6
			if (TP6.estado == 0 && TP5.envia_peca == 1) {
				TP6.estado = 1;
			}
			if (TP6.estado == 1 && TP6.presenca() == true) {
				TP6.estado = 2;
			}
			if (TP6.estado == 2 && pieces_vector.get(id_peca_TP6).operations[0]==M1.tool) {
				TP6.estado = 3;
			}
			if (TP6.estado == 3 && M1.presenca() == false) {
				TP6.estado = 4;
			}
			if (TP6.estado == 4 && TP6.orientacao == 1) {
				TP6.estado = 5;
			}
			if (TP6.estado == 5 && M1.presenca() == true) {
				TP6.estado = 6;
			}
			if (TP6.estado == 6 && TP6.orientacao == 0) {
				TP6.estado = 0;
			}
			if (TP6.estado == 2 && (M1.presenca()!=false || pieces_vector.get(id_peca_TP6).operations[0]!=M1.tool)) {
				TP6.estado = 7;
			}
			if (TP6.estado == 7 && TP7.presenca() == false) {
				TP6.estado = 8;
			}
			if (TP6.estado == 8 && TP7.presenca() == true) {
				TP6.estado = 0;
			}
			if (TP6.estado == 0 && TP16.envia_peca == 1) {
				TP6.estado = 9;
			}
			if (TP6.estado == 9 && TP6.orientacao == 1) {
				TP6.estado = 10;
			}
			if (TP6.estado == 10 && TP6.presenca() == true) {
				TP6.estado = 11;
			}
			if (TP6.estado == 11 && TP6.orientacao == 0) {
				TP6.estado = 2;
			}
			if (TP6.estado == 0 && M1.envia_peca == 1) { //Maquina de cima envia peça
				TP6.estado = 12;
			}
			if (TP6.estado == 12 && TP6.orientacao == 1) {
				TP6.estado = 13;
			}
			if (TP6.estado == 13 && TP6.presenca() == true) {
				TP6.estado = 14;
			}
			if (TP6.estado == 14 && TP6.orientacao == 0) {
				TP6.estado = 7;
			}
			//TRANSIÇÕES TAPETE 7
			if (TP7.estado == 0 && TP6.envia_peca == 1) {
				TP7.estado = 1;
			}
			if (TP7.estado == 1 && TP7.presenca() == true) {
				TP7.estado = 2;
			}
			if (TP7.estado == 2 && pieces_vector.get(id_peca_TP7).operations[0]==M2.tool) {
				TP7.estado = 3;
			}
			if (TP7.estado == 3 && M2.presenca() == false) {
				TP7.estado = 4;
			}
			if (TP7.estado == 4 && TP7.orientacao == 1) {
				TP7.estado = 5;
			}
			if (TP7.estado == 5 && M2.presenca() == true) {
				TP7.estado = 6;
			}
			if (TP7.estado == 6 && TP7.orientacao == 0) {
				TP7.estado = 0;
			}
			if (TP7.estado == 2 && pieces_vector.get(id_peca_TP7).operations[0]==M3.tool) {
				TP7.estado = 7;
			}
			if (TP7.estado == 7 && M3.presenca() == false) {
				TP7.estado = 8;
			}
			if (TP7.estado == 8 && TP7.orientacao == 1) {
				TP7.estado = 9;
			}
			if (TP7.estado == 9 && M3.presenca() == true) {
				TP7.estado = 10;
			}
			if (TP7.estado == 10 && TP7.orientacao == 0) {
				TP7.estado = 0;
			}
			if (TP7.estado == 3 && M2.presenca() == true) {
				TP7.estado = 11;
			}
			if (TP7.estado == 7 && M3.presenca() == true) {
				TP7.estado = 11;
			}
			if (TP7.estado == 2 && pieces_vector.get(id_peca_TP7).operations[0]!=TP7.maq_baixo() && pieces_vector.get(id_peca_TP7).operations[0]!=M2.tool) {
				TP7.estado = 11;
			}
			if (TP7.estado == 11 && TP8.presenca() == false) {
				TP7.estado = 12;
			}
			if (TP7.estado == 12 && TP8.presenca() == true){
				TP7.estado = 0;
			}
			if (TP7.estado == 0 && M2.envia_peca == 1) { //Maquina de cima envia peça
				TP7.estado = 13;
			}
			if (TP7.estado == 13 && TP7.orientacao == 1) {
				TP7.estado = 14;
			}
			if (TP7.estado == 14 && TP7.presenca() == true) {
				TP7.estado = 15;
			}
			if (TP7.estado == 15 && TP7.orientacao == 0) {
				TP7.estado = 11;
			}
			if (TP7.estado == 0 && M3.envia_peca == 1) { //Maquina de baixo envia peça
				TP7.estado = 16;
			}
			if (TP7.estado == 16 && TP7.orientacao == 1) {
				TP7.estado = 17;
			}
			if (TP7.estado == 17 && TP7.presenca() == true) {
				TP7.estado = 18;
			}
			if (TP7.estado == 18 && TP7.orientacao == 0) {
				TP7.estado = 11;
			}
			//TRANSIÇÕES TAPETE 8
			if (TP8.estado == 0 && TP7.envia_peca == 1) {
				TP8.estado = 1;
			}
			if (TP8.estado == 1 && TP8.presenca() == true) {
				TP8.estado = 2;
			}
			if (TP8.estado == 2 && pieces_vector.get(id_peca_TP8).operations[0]==M4.tool) {
				TP8.estado = 3;
			}
			if (TP8.estado == 3 && M4.presenca() == false) {
				TP8.estado = 4;
			}
			if (TP8.estado == 4 && TP8.orientacao == 1) {
				TP8.estado = 5;
			}
			if (TP8.estado == 5 && M4.presenca() == true) {
				TP8.estado = 6;
			}
			if (TP8.estado == 6 && TP8.orientacao == 0) {
				TP8.estado = 0;
			}
			if (TP8.estado == 2 && pieces_vector.get(id_peca_TP8).operations[0]==M5.tool) {
				TP8.estado = 7;
			}
			if (TP8.estado == 7 && M5.presenca() == false) {
				TP8.estado = 8;
			}
			if (TP8.estado == 8 && TP8.orientacao == 1) {
				TP8.estado = 9;
			}
			if (TP8.estado == 9 && M5.presenca() == true) {
				TP8.estado = 10;
			}
			if (TP8.estado == 10 && TP8.orientacao == 0) {
				TP8.estado = 0;
			}
			if (TP8.estado == 3 && M4.presenca() == true) {
				TP8.estado = 11;
			}
			if (TP8.estado == 7 && M4.presenca() == true) {
				TP8.estado = 11;
			}
			if (TP8.estado == 2 && pieces_vector.get(id_peca_TP8).operations[0]!=TP8.maq_baixo() && pieces_vector.get(id_peca_TP8).operations[0]==M4.tool) {
				TP8.estado = 11;
			}
			if (TP8.estado == 11 && TP8.presenca() == false) {
				TP8.estado = 12;
			}
			if (TP8.estado == 12 && TP9.presenca() == true) {
				TP8.estado = 0;
			}
			if (TP8.estado == 0 && M4.envia_peca == 1) { //Maquina de cima envia peça
				TP8.estado = 13;
			}
			if (TP8.estado == 13 && TP8.orientacao == 1) {
				TP8.estado = 14;
			}
			if (TP8.estado == 14 && TP8.presenca() == true) {
				TP8.estado = 15;
			}
			if (TP8.estado == 15 && TP8.orientacao == 0) {
				TP8.estado = 11;
			}
			if (TP8.estado == 0 && M5.envia_peca == 1) { //Maquina de baixo envia peça
				TP8.estado = 16;
			}
			if (TP8.estado == 16 && TP8.orientacao == 1) {
				TP8.estado = 17;
			}
			if (TP8.estado == 17 && TP8.presenca() == true) {
				TP8.estado = 18;
			}
			if (TP8.estado == 18 && TP8.orientacao == 0) {
				TP8.estado = 11;
			}
			//TRANSIÇÕES TAPETE 9
			if (TP9.estado == 0 && TP8.envia_peca == 1) {
				TP9.estado = 1;
			}
			if (TP9.estado == 1 && TP9.presenca() == true) {
				TP9.estado = 2;
			}
			if (TP9.estado == 2 && pieces_vector.get(id_peca_TP9).operations[0]==TP9.maq_cima()) {
				TP9.estado = 3;
			}
			if (TP9.estado == 3 && M6.presenca() == false) {
				TP9.estado = 5;
			}
			if (TP9.estado == 5 && TP9.orientacao == 1) {
				TP9.estado = 6;
			}
			if (TP9.estado == 6 && M6.presenca() == true) {
				TP9.estado = 7;
			}
			if (TP9.estado == 7 && TP9.orientacao == 0) {
				TP9.estado = 0;
			}
			if (TP9.estado == 2 && (pieces_vector.get(id_peca_TP9).operations[0]!=TP9.maq_cima() || M6.presenca()==true)) {
				TP9.estado = 8;
			}
			if (TP9.estado == 8 && pieces_vector.get(id_peca_TP9).operations[0]==0) {
				TP9.estado = 9;
			}
			if (TP9.estado == 9 && TP10.presenca() == false) {
				TP9.estado = 10;
			}
			if (TP9.estado == 10 && TP10.presenca() == true) {
				TP9.estado = 0;
			}
			if (TP9.estado == 8 && pieces_vector.get(id_peca_TP9).operations[0]!=0) {
				TP9.estado = 11;
			}
			if (TP9.estado == 11 && TP11.presenca() == false) {
				TP9.estado = 12;
			}
			if (TP9.estado == 12 && TP9.orientacao == 1) {
				TP9.estado = 13;
			}
			if (TP9.estado == 13 && TP11.presenca() == true) {
				TP9.estado = 14;
			}
			if (TP9.estado == 14 && TP9.orientacao == 0) {
				TP9.estado = 0;
			}
			if (TP9.estado == 0 && M6.envia_peca == 1) { //Maquina de cima envia peça
				TP9.estado = 15;
			}
			if (TP9.estado == 15 && TP9.orientacao == 1) {
				TP9.estado = 16;
			}
			if (TP9.estado == 16 && TP9.presenca() == true) {
				TP9.estado = 17;
			}
			if (TP9.estado == 17 && TP9.orientacao == 0) {
				TP9.estado = 8;
			}
			//TRANSIÇÕES TAPETE 10
			if (TP10.estado == 0 && TP9.envia_peca == 1) {
				TP10.estado = 1;
			}
			if (TP10.estado == 1) { //&& armazem não esta cheio
				TP10.estado = 2;
			}
			if (TP10.estado == 2 && TP10.push_sensor == 1) {
				TP10.estado = 0;
			}
			//TRANSIÇÕES TAPETE 11
			if (TP11.estado == 0 && TP9.envia_peca == 1) {
				TP11.estado = 1;
			}
			if (TP11.estado == 1 && TP11.presenca() == true) {
				TP11.estado = 2;
			}
			if (TP11.estado == 2 && TP12.presenca() == false) {
				TP11.estado = 3;
			}
			if (TP11.estado == 3 && TP12.presenca() == true) {
				TP11.estado = 0;
			}
			//TRANSIÇÕES TAPETE 12
			if (TP12.estado == 0 && TP11.envia_peca == 1) {
				TP12.estado = 1;
			}
			if (TP12.estado == 1 && TP12.presenca() == true) {
				TP12.estado = 2;
			}
			if (TP12.estado == 2 && TP13.presenca() == false) {
				TP12.estado = 3;
			}
			if (TP12.estado == 3 && TP12.orientacao == 0) {
				TP12.estado = 4;
			}
			if (TP12.estado == 4 && TP13.presenca() == true) {
				TP12.estado = 5;
			}
			if (TP12.estado == 15 && TP12.orientacao == 1) {
				TP12.estado = 0;
			}
			//TRANSIÇÕES TAPETE 13
			if (TP13.estado == 0 && TP12.envia_peca == 1) {
				TP13.estado = 1;
			}
			if (TP13.estado == 1 && TP13.presenca() == true) {
				TP13.estado = 2;
			}
			if (TP13.estado == 2 && TP14.presenca() == false) {
				TP13.estado = 3;
			}
			if (TP13.estado == 3 && TP14.presenca() == true) {
				TP13.estado = 0;
			}
			//TRANSIÇÕES TAPETE 14
			if (TP14.estado == 0 && TP13.envia_peca == 1) {
				TP14.estado = 1;
			}
			if (TP14.estado == 1 && TP14.presenca() == true) {
				TP14.estado = 2;
			}
			if (TP14.estado == 2 && TP15.presenca() == false) {
				TP14.estado = 3;
			}
			if (TP14.estado == 3 && TP15.presenca() == true) {
				TP14.estado = 0;
			}
			//TRANSIÇÕES TAPETE 15
			if (TP15.estado == 0 && TP14.envia_peca == 1) {
				TP15.estado = 1;
			}
			if (TP15.estado == 1 && TP15.presenca() == true) {
				TP15.estado = 2;
			}
			if (TP15.estado == 2 && TP16.presenca() == false) {
				TP15.estado = 3;
			}
			if (TP15.estado == 3 && TP15.orientacao == 1) {
				TP15.estado = 4;
			}
			if (TP15.estado == 4 && TP16.presenca() == true) {
				TP15.estado = 5;
			}
			if (TP15.estado == 5 && TP15.orientacao == 0) {
				TP15.estado = 0;
			}
			//TRANSIÇÕES TAPETE 16
			if (TP16.estado == 0 && TP15.envia_peca == 1) {
				TP16.estado = 1;
			}
			if (TP16.estado == 1 && TP16.presenca() == true) {
				TP16.estado = 2;
			}
			if (TP16.estado == 2 && TP6.presenca() == false) {
				TP16.estado = 3;
			}
			if (TP16.estado == 3 && TP6.orientacao == 1) {
				TP16.estado = 4;
			}
			if (TP16.estado == 4 && TP6.presenca() == true) {
				TP16.estado = 0;
			}
			
			//TRANSIÇÕES TAPETE 19
			if (TP19.estado == 0 && TP19.pop_sensor = 1) {
				TP19.estado = 1;
			}
			if (TP19.estado == 1 && TP20.estado == 0) {
				TP19.estado = 2; //TP19.envia_peca()=1
			}
			if (TP19.estado == 2 && TP20.presenca() == true) {
				TP19.estado = 0;
			}

			//TRANSIÇÕES TAPETE 20
			if (TP20.estado == 0 && TP19.envia_peca == 1) {
				TP20.estado = 1;
			}
			if (TP20.estado == 1 && TP20.presenca() == true) {
				TP20.estado = 2;
			}
			if (TP20.estado == 2 && TP21.presenca() == false) {
				TP20.estado = 3;
			}
			if (TP20.estado == 3 && TP20.orientacao == 1) {
				TP20.estado = 4;
			}
			if (TP20.estado == 4 && TP21.presenca() == true) {
				TP20.estado = 5;
			}
			if (TP20.estado == 5 && TP20.orientacao == 0) {
				TP20.estado = 0;
			}

			//TRANSIÇÕES TAPETE 21
			if (TP21.estado == 0 && TP21.presenca() == true && TP22.presenca() == true && TP211.presenca() == false) TP21.estado = 1;
			else if (TP21.estado == 1 && TP21.Fe() == true) TP21.estado = 2;
			else if (TP21.estado == 2 && TP21.Fr() == false) TP1.estado = 0;

			//TRANSIÇÕES TAPETE 22
			if (TP22.estado == 0 && TP22.presenca() == false && TP21.presenca() == true) TP22.estado = 1;
			else if (TP22.estado == 1 && TP22.presenca() == true) TP22.estado = 2;
			else if (TP22.estado == 2 && TP23.presenca() == false && TP221.presenca() == false) TP22.estado = 3;
			else if (TP22.estado == 3 && TP22.Fe() == true) TP22.estado = 4;
			else if (TP22.estado == 4 && TP22.Fr() == false) TP22.estado = 0;

			//TRANSIÇÕES TAPETE 23
			if (TP23.estado == 0 && TP23.presenca() == false && TP22.presenca() == true) TP23.estado = 1;
			else if (TP23.estado == 1 && TP23.presenca() == true) TP23.estado = 2;
			else if (TP23.estado == 2 && TP231.presenca() == false) TP23.estado = 3;
			else if (TP23.estado == 3 && TP23.Fe() == true) TP23.estado = 4;
			else if (TP23.estado == 4 && TP23.Fr() == false) TP23.estado = 0;
			//TRANSIÇÕES MÁQUINA 1
			if (M1.estado == 0 && TP6.envia_peca_maq == 1) {
				M1.estado = 1;
			}
			if (M1.estado == 1 && M1.presenca() == true) {
				M1.estado = 2;
			}
			if (M1.estado == 2 ) { //&& passou tempo de operação
				M1.estado = 3;
			}
			if (M1.estado == 3 && TP6.presenca() == false) {
				M1.estado = 4;
			}
			if (M1.estado == 4 && TP6.orientacao == 1) {
				M1.estado = 5;
			}
			if (M1.estado == 5 && TP6.presenca() == true) {
				M1.estado = 0;
			}
			//TRANSIÇÕES MÁQUINA 2
			if (M2.estado == 0 && TP7.envia_peca_maq == 1) {
				M2.estado = 1;
			}
			if (M2.estado == 1 && M2.presenca() == true) {
				M2.estado = 2;
			}
			if (M2.estado == 2 ) { //&& passou tempo de operação
				M2.estado = 3;
			}
			if (M2.estado == 3 && TP7.presenca() == false) {
				M2.estado = 4;
			}
			if (M2.estado == 4 && TP7.orientacao == 1) {
				M2.estado = 5;
			}
			if (M2.estado == 5 && TP7.presenca() == true) {
				M2.estado = 0;
			}
			//TRANSIÇÕES MÁQUINA 3
			if (M3.estado == 0 && TP7.envia_peca_maq == 2) {
				M3.estado = 1;
			}
			if (M3.estado == 1 && M3.presenca() == true) {
				M3.estado = 2;
			}
			if (M3.estado == 2 ) { //&& passou tempo de operação
				M3.estado = 3;
			}
			if (M3.estado == 3 && TP7.presenca() == false) {
				M3.estado = 4;
			}
			if (M3.estado == 4 && TP7.orientacao == 1) {
				M3.estado = 5;
			}
			if (M3.estado == 5 && TP7.presenca() == true) {
				M3.estado = 0;
			}
			//TRANSIÇÕES MÁQUINA 4
			if (M4.estado == 0 && TP8.envia_peca_maq == 1) {
				M4.estado = 1;
			}
			if (M4.estado == 1 && M4.presenca() == true) {
				M4.estado = 2;
			}
			if (M4.estado == 2 ) { //&& passou tempo de operação
				M4.estado = 3;
			}
			if (M4.estado == 3 && TP8.presenca() == false) {
				M4.estado = 4;
			}
			if (M4.estado == 4 && TP8.orientacao == 1) {
				M4.estado = 5;
			}
			if (M4.estado == 5 && TP8.presenca() == true) {
				M4.estado = 0;
			}
			//TRANSIÇÕES MÁQUINA 5
			if (M5.estado == 0 && TP8.envia_peca_maq == 2) {
				M5.estado = 1;
			}
			if (M5.estado == 1 && M5.presenca() == true) {
				M5.estado = 2;
			}
			if (M5.estado == 2 ) { //&& passou tempo de operação
				M5.estado = 3;
			}
			if (M5.estado == 3 && TP8.estado == 0) {
				M5.estado = 4;
			}
			if (M5.estado == 4 && TP8.orientacao == 1) {
				M5.estado = 5;
			}
			if (M5.estado == 5 && TP8.presenca() == true) {
				M5.estado = 0;
			}
			//TRANSIÇÕES MÁQUINA 6
			if (M6.estado == 0 && TP9.envia_peca_maq == 1) {
				M6.estado = 1;
			}
			if (M6.estado == 1 && M6.presenca() == true) {
				M6.estado = 2;
			}
			if (M6.estado == 2) { //&& passou tempo de operação
				M6.estado = 3;
			}
			if (M6.estado == 3 && TP9.presenca() == false) {
				M6.estado = 4;
			}
			if (M6.estado == 4 && TP9.orientacao == 1) {
				M6.estado = 5;
			}
			if (M6.estado == 5 && TP9.presenca() == true) {
				M6.estado = 0;
			}
			//*******************ATUALIZAR OUTPUTS************************
			
			//OUTPUTS TAPETE 1
			if (TP1.estado == 3) TP1.move_left();

			//OUTPUTS TAPETE 2
			switch(TP2.estado){
				case 0: TP2.rotate_clock(); break;
				case 2: TP2.move_left(); break;
				case 3: TP2.move_right(); break;
				case 4: TP2.rotate_anticlock(); break;
				case 5: TP2.move_right(); break;
				default: break;
			}

			//OUTPUTS TAPETE 3
			if (TP1.estado == 3) TP1.move_right();

			//OUTPUTS TAPETE 4
			switch(TP4.estado){
				case 1: TP4.move_right(); break;
				case 2: //TP4.pe == true; break;
				case 3: //TP4.re == true; break;
				default: break;
			}
			
			//OUTPUTS TAPETE 5
			if (TP5.estado == 1) {
				TP5.move_right();
			}
			if (TP5.estado == 3) {
				TP5.move_right();
			} 
			//OUTPUTS TAPETE 6 (LEFT=BAIXO; RIGHT=CIMA)
			if (TP6.estado == 1) {
				TP6.move_right();
			}
			if (TP6.estado == 4) {
				TP6.rotate_clock();
			}
			if (TP6.estado == 5) {
				TP6.move_left(); 
			}
			if (TP6.estado == 6) {
				TP6.rotate_anticlock();
			}
			if (TP6.estado == 8) {
				TP6.move_right();
			}
			if (TP6.estado == 9) {
				TP6.rotate_clock();
			}
			if (TP6.estado == 10) {
				TP6.move_right();
			}
			if (TP6.estado == 11){
				TP6.rotate_anticlock();
			}
			if (TP6.estado == 12) {
				TP6.rotate_clock();
			}
			if (TP6.estado == 13) {
				TP6.move_left();
			}
			if (TP6.estado == 14) {
				TP6.rotate_anticlock();
			}
			//OUTPUTS TAPETE 7 (LEFT=BAIXO; RIGHT=CIMA)
			if (TP7.estado == 1) {
				TP7.move_right();
			}
			if (TP7.estado == 4) {
				TP7.rotate_clock();
			}
			if (TP7.estado == 5) {
				TP7.move_right();
			}
			if (TP7.estado == 6) {
				TP7.rotate_anticlock();
			}
			if (TP7.estado == 8) {
				TP7.rotate_clock();
			}
			if (TP7.estado == 9) {
				TP7.move_left();
			}
			if (TP7.estado == 10) {
				TP7.rotate_anticlock();
			}
			if (TP7.estado == 12) {
				TP7.move_right();
			}
			if (TP7.estado == 13) {
				TP7.rotate_clock();
			}
			if (TP7.estado == 14) {
				TP7.move_left();
			}
			if (TP7.estado == 15) {
				TP7.rotate_anticlock();
			}
			if (TP7.estado == 16) {
				TP7.rotate_clock();
			}
			if (TP7.estado == 17) {
				TP7.move_right();
			}
			if (TP7.estado == 18) {
				TP7.rotate_anticlock();
			}
			//OUTPUTS TAPETE 8 (LEFT=BAIXO; RIGHT=CIMA)
			if (TP8.estado == 1) {
				TP8.move_right();
			}
			if (TP8.estado == 4) {
				TP8.rotate_clock();
			}
			if (TP8.estado == 5) {
				TP8.move_right();
			}
			if (TP8.estado == 6) {
				TP8.rotate_anticlock();
			}
			if (TP8.estado == 8) {
				TP8.rotate_clock();
			}
			if (TP8.estado == 9) {
				TP8.move_left();
			}
			if (TP8.estado == 10) {
				TP8.rotate_anticlock();
			}
			if (TP8.estado == 12) {
				TP8.move_right();
			}
			if (TP8.estado == 13) {
				TP8.rotate_clock();
			}
			if (TP8.estado == 14) {
				TP8.move_left();
			}
			if (TP8.estado == 15) {
				TP8.rotate_anticlock();
			}
			if (TP8.estado == 16) {
				TP8.rotate_clock();
			}
			if (TP8.estado == 17) {
				TP8.move_right();
			}
			if (TP8.estado == 18) {
				TP8.rotate_anticlock();
			}
			//OUTPUTS TAPETE 9 (LEFT=BAIXO; RIGHT=CIMA)
			if (TP9.estado == 1) {
				TP9.move_right();
			}
			if (TP9.estado == 4) {
				TP9.rotate_clock();
			}
			if (TP9.estado == 6) {
				TP9.move_right();
			}
			if (TP9.estado == 7) {
				TP9.rotate_anticlock();
			}
			if (TP9.estado == 10) {
				TP9.move_right();
			}
			if (TP9.estado == 12) {
				TP9.rotate_clock();
			}
			if (TP9.estado == 13) {
				TP9.move_left();
			}
			if (TP9.estado == 14) {
				TP9.rotate_anticlock();
			}
			if (TP9.estado == 15) {
				TP9.rotate_clock();
			}
			if (TP9.estado == 16) {
				TP9.move_left();
			}
			if (TP9.estado == 17) {
				TP9.rotate_anticlock();
			}
			//OUTPUTS TAPETE 10
			if (TP10.estado == 1) {
				TP10.move_right();
			}
			if (TP10.estado == 2) {
				TP9.rotate_anticlock();
			}
			//OUTPUTS TAPETE 11 (LEFT=BAIXO; RIGHT=CIMA)
			if (TP11.estado == 1) {
				TP11.move_left();
			}
			if (TP11.estado == 3) {
				TP11.move_left();
			}
			//OUTPUTS TAPETE 12 (LEFT=BAIXO; RIGHT=CIMA)
			if (TP12.estado == 1) {
				TP12.move_left();
			}
			if (TP12.estado == 3) {
				TP12.rotate_anticlock();
			}
			if (TP12.estado == 4) {
				TP12.move_left();
			}
			if (TP12.estado == 5) {
				TP12.rotate_clock();
			}
			//OUTPUTS TAPETE 13
			if (TP13.estado == 1) {
				TP13.move_left();
			}
			if (TP13.estado == 3) {
				TP13.move_left();
			}
			//OUTPUTS TAPETE 14
			if (TP14.estado == 1) {
				TP14.move_left();
			}
			if (TP14.estado == 3) {
				TP14.move_left();
			}
			//OUTPUTS TAPETE 15 (LEFT=BAIXO; RIGHT=CIMA)
			if (TP15.estado == 1) {
				TP15.move_left();
			}
			if (TP15.estado == 3) {
				TP15.rotate_anticlock();
			}
			if (TP15.estado == 4) {
				TP15.move_right();
			}
			if (TP15.estado == 5) {
				TP15.rotate_clock();
			}
			//OUTPUTS TAPETE 16 (LEFT=BAIXO; RIGHT=CIMA)
			if (TP16.estado == 1) {
				TP16.move_right();
			}
			if (TP16.estado == 4) {
				TP16.move_right();
			}
			
			//OUTPUTS TAPETE 19
			switch(TP19.estado){
				case 1: TP19.move_right(); break;
				case 3: TP19.move_right(); break;
				default: break;
			}

			//OUTPUTS TAPETE 20
			switch(TP20.estado){
				case 1: TP20.move_right(); break;
				case 3: TP20.rotate_clock(); break;
				case 4: TP20.move_right(); break;
				case 5: TP20.rotate_anticlock(); break;
				default: break;
			}

			//OUTPUTS TAPETE 21
			switch(TP21.estado){
				case 1: TP21.pe == true; break;
				case 2: TP21.pr == true; break;
				default: break;
			}
			//OUTPUTS TAPETE 22
			switch(TP22.estado){
				case 1: TP21.move_right();
						TP22.move_right();
						break;
				case 3: TP22.pe == true; break;
				case 4: TP22.pr == true; break;
				default: break;
			}
			//OUTPUTS TAPETE 23
			switch(TP23.estado){
				case 1: TP22.move_right();
						TP23.move_right();
						break;
				case 3: TP23.pe == true; break;
				case 4: TP23.pr == true; break;
				default: break;
			}
			
			//OUTPUTS MÁQUINA 1 (LEFT=BAIXO; RIGHT=CIMA)
			if (M1.estado == 1) {
				M1.move_right();
			}
			if (M1.estado == 2) {
				M1.work();
			}
			if (M1.estado == 5) {
				M1.move_left();
			}
			//OUTPUTS MÁQUINA 2 (LEFT=BAIXO; RIGHT=CIMA)
			if (M2.estado == 1) {
				M2.move_right();
			}
			if (M2.estado == 2) {
				M2.work();
			}
			if (M2.estado == 5) {
				M2.move_left();
			}
			//OUTPUTS MÁQUINA 3 (LEFT=BAIXO; RIGHT=CIMA)
			if (M3.estado == 1) {
				M3.move_left();
			}
			if (M3.estado == 2) {
				M3.work();
			}
			if (M3.estado == 5) {
				M3.move_right();
			}
			//OUTPUTS MÁQUINA 4 (LEFT=BAIXO; RIGHT=CIMA)
			if (M4.estado == 1) {
				M4.move_right();
			}
			if (M4.estado == 2) {
				M4.work();
			}
			if (M4.estado == 5) {
				M4.move_left();
			}
			//OUTPUTS MÁQUINA 5 (LEFT=BAIXO; RIGHT=CIMA)
			if (M5.estado == 1) {
				M5.move_left();
			}
			if (M5.estado == 2) {
				M5.work();
			}
			if (M5.estado == 5) {
				M5.move_right();
			}
			//OUTPUTS MÁQUINA 6 (LEFT=BAIXO; RIGHT=CIMA)
			if (M6.estado == 1) {
				M6.move_right();
			}
			if (M6.estado == 2) {
				M6.work();
			}
			if (M6.estado == 5) {
				M6.move_left();
			}
		//*/
		}
		
		
	}
	
}