package org.FactorySolutions.FactoryManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class state_machine {
	
	static int aux = 1;
	
	//*******************VARIÁVEIS MAQ ESTADOS************************
	static ArrayList<piece> pieces_vector = new ArrayList<piece>(); //vetor com as peças que estão na floor plant
	
	static int id_peca_TP5=0, id_peca_TP6=0, id_peca_TP7=0, id_peca_TP8=0, id_peca_TP9=0, id_peca_TP10=0, id_peca_TP11=0, id_peca_TP12=0, id_peca_TP13=0, id_peca_TP14=0, id_peca_TP15=0, id_peca_TP16=0;
	static int TP5_tem_peca=0, TP6_tem_peca=0, TP7_tem_peca=0, TP8_tem_peca=0, TP9_tem_peca=0, TP10_tem_peca=0, TP11_tem_peca=0, TP12_tem_peca=0, TP13_tem_peca=0, TP14_tem_peca=0, TP15_tem_peca=0, TP16_tem_peca=0;
	static int id_peca_M1=0, id_peca_M2=0, id_peca_M3=0, id_peca_M4=0, id_peca_M5=0, id_peca_M6=0;
	static int M1_tem_peca=0, M2_tem_peca=0, M3_tem_peca=0, M4_tem_peca=0, M5_tem_peca=0, M6_tem_peca=0;
	
	//*******************CRIAR MÁQUINAS************************
	static machine M1 = new machine(51,1,1);
	static machine M2 = new machine(52,1,1);
	static machine M3 = new machine(53,2,2);
	static machine M4 = new machine(54,3,1);
	static machine M5 = new machine(55,3,2);
	static machine M6 = new machine(56,4,2);
	
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
	
	//*******************AJUDA OUTPUTS************************
	static HashMap<String, Integer> updatedValues = new HashMap<String, Integer>();
	static int word1=0;

	static int word2=0;

	static int word3=0;

	static int word4=0;

	static int word5=0;

	static int word6=0;

	static int word7=0;
	
	private static boolean getInt(int n, int k){
        return ((n >> k) & 1) == 1;
    }
	
	public static int localizacao_peca(int tapete, ArrayList<piece> pieces_vector) {
		
		int id=-1;
		
		for(int i=0; i<pieces_vector.size();i++) {
			if(pieces_vector.get(i).position==tapete) {
				id = i;
			}
		}
		
		return id;
	}
	
	public static int writeInt(int n, boolean bool, int k){
        if(bool)
            return n | (1 << k);
        else return n;
    }
	
	public static void atualiza_inputs(ArrayList<Integer> list){
		
		TP4.set_presence(getInt(list.get(3),29));
		TP2.set_presence(getInt(list.get(3),30));
		TP2.set_sensorRminus(getInt(list.get(3),31));
		TP2.set_sensorRplus(getInt(list.get(4),0));
		TP1.set_presence(getInt(list.get(4),1));
		TP3.set_presence(getInt(list.get(4),2));
		TP5.set_presence(getInt(list.get(4),3));
		TP17.set_presence(getInt(list.get(4),4));
		TP6.set_presence(getInt(list.get(4),5));
		TP6.set_sensorRminus(getInt(list.get(4),6));
		TP6.set_sensorRplus(getInt(list.get(4),7));
		TP7.set_presence(getInt(list.get(4),8));
		TP7.set_sensorRminus(getInt(list.get(4),9));
		TP7.set_sensorRplus(getInt(list.get(4),10));
		TP8.set_presence(getInt(list.get(4),11));
		TP8.set_sensorRminus(getInt(list.get(4),12));
		TP8.set_sensorRplus(getInt(list.get(4),13));
		TP9.set_presence(getInt(list.get(4),14));
		TP9.set_sensorRminus(getInt(list.get(4),15));
		TP9.set_sensorRplus(getInt(list.get(4),16));
		M1.set_presence(getInt(list.get(4),17));
		M1.set_sensorTool(getInt(list.get(4),18));
		M1.set_sensorXplus(getInt(list.get(4),19));
		M1.set_sensorXminus(getInt(list.get(4),20));
		M1.set_sensorZplus(getInt(list.get(4),21));
		M1.set_sensorZminus(getInt(list.get(4),22));
		M2.set_presence(getInt(list.get(4),23));
		M2.set_sensorTool(getInt(list.get(4),24));
		M2.set_sensorXplus(getInt(list.get(4),25));
		M2.set_sensorXminus(getInt(list.get(4),26));
		M2.set_sensorZplus(getInt(list.get(4),27));
		M2.set_sensorZminus(getInt(list.get(4),28));
		M4.set_presence(getInt(list.get(4),29));
		M4.set_sensorTool(getInt(list.get(4),30));
		M4.set_sensorXplus(getInt(list.get(4),31));
		M4.set_sensorXminus(getInt(list.get(5),0));
		M4.set_sensorZplus(getInt(list.get(5),1));
		M4.set_sensorZminus(getInt(list.get(5),2));
		M6.set_presence(getInt(list.get(5),3));
		M6.set_sensorTool(getInt(list.get(5),4));
		M6.set_sensorXplus(getInt(list.get(5),5));
		M6.set_sensorXminus(getInt(list.get(5),6));
		M6.set_sensorZplus(getInt(list.get(5),7));
		M6.set_sensorZminus(getInt(list.get(5),8));
		M3.set_presence(getInt(list.get(5),9));
		M3.set_sensorTool(getInt(list.get(5),10));
		M3.set_sensorXplus(getInt(list.get(5),11));
		M3.set_sensorXminus(getInt(list.get(5),12));
		M3.set_sensorZplus(getInt(list.get(5),13));
		M3.set_sensorZminus(getInt(list.get(5),14));
		M5.set_presence(getInt(list.get(5),15));
		M5.set_sensorTool(getInt(list.get(5),16));
		M5.set_sensorXplus(getInt(list.get(5),17));
		M5.set_sensorXminus(getInt(list.get(5),18));
		M5.set_sensorZplus(getInt(list.get(5),19));
		M5.set_sensorZminus(getInt(list.get(5),20));
		TP11.set_presence(getInt(list.get(5),21));
		TP12.set_presence(getInt(list.get(5),22));
		TP12.set_sensorRminus(getInt(list.get(5),23));
		TP12.set_sensorRplus(getInt(list.get(5),24));
		TP14.set_presence(getInt(list.get(5),25));
		TP13.set_presence(getInt(list.get(5),26));
		TP16.set_presence(getInt(list.get(5),27));
		TP15.set_presence(getInt(list.get(5),28));
		TP15.set_sensorRminus(getInt(list.get(5),29));
		TP15.set_sensorRplus(getInt(list.get(5),30));
		TP10.set_presence(getInt(list.get(5),31));
		TP18.set_presence(getInt(list.get(6),0));
		TP19.set_presence(getInt(list.get(6),1));
		TP20.set_presence(getInt(list.get(6),2));
		TP20.set_sensorRminus(getInt(list.get(6),3));
		TP20.set_sensorRplus(getInt(list.get(6),4));
		TP21.set_presence(getInt(list.get(6),6));
		TP21.set_sensorRminus(getInt(list.get(6),6));
		TP21.set_sensorRplus(getInt(list.get(6),7));
		TP22.set_presence(getInt(list.get(6),8));
		TP22.set_sensorRminus(getInt(list.get(6),9));
		TP22.set_sensorRplus(getInt(list.get(6),10));
		TP23.set_presence(getInt(list.get(6),11));
		TP23.set_sensorRminus(getInt(list.get(6),12));
		TP23.set_sensorRplus(getInt(list.get(6),13));
		TP211.set_presence(getInt(list.get(6),14));
		TP212.set_presence(getInt(list.get(6),15));
		TP213.set_presence(getInt(list.get(6),16));
		TP221.set_presence(getInt(list.get(6),17));
		TP222.set_presence(getInt(list.get(6),18));
		TP223.set_presence(getInt(list.get(6),19));
		TP231.set_presence(getInt(list.get(6),20));
		TP232.set_presence(getInt(list.get(6),21));
		TP233.set_presence(getInt(list.get(6),22));
	}
	
	public static void atualiza_outputs() {
		
		word1 = writeInt(word1, TP4.get_motor_plus(),0);
		word1 = writeInt(word1, TP4.get_motor_minus(),1);
		word1 = writeInt(word1, TP4.get_warehouse_in(),2);
		word1 = writeInt(word1, TP2.get_motor_plus(),3);
		word1 = writeInt(word1, TP2.get_motor_minus(),4);
		word1 = writeInt(word1, TP2.get_rotate_plus(),5);
		word1 = writeInt(word1, TP2.get_rotate_minus(),6);
		word1 = writeInt(word1, TP1.get_motor_plus(),7);
		word1 = writeInt(word1, TP1.get_motor_minus(),8);
		word1 = writeInt(word1, TP3.get_motor_minus(),9);
		word1 = writeInt(word1, TP5.get_motor_plus(),10);
		word1 = writeInt(word1, TP5.get_motor_minus(),11);
		word1 = writeInt(word1, TP17.get_motor_plus(),12);
		word1 = writeInt(word1, TP11.get_motor_minus(),13);
		word1 = writeInt(word1, TP11.get_warehouse_in(),14);
		word1 = writeInt(word1, TP6.get_motor_plus(),15);
		word1 = writeInt(word1, TP6.get_motor_minus(),16);
		word1 = writeInt(word1, TP6.get_rotate_plus(),17);
		word1 = writeInt(word1, TP6.get_rotate_minus(),18);
		word1 = writeInt(word1, TP7.get_motor_plus(),19);
		word1 = writeInt(word1, TP7.get_motor_minus(),20);
		word1 = writeInt(word1, TP7.get_rotate_plus(),21);
		word1 = writeInt(word1, TP7.get_rotate_minus(),22);
		word1 = writeInt(word1, TP8.get_motor_plus(),23);
		word1 = writeInt(word1, TP8.get_motor_minus(),24);
		word1 = writeInt(word1, TP8.get_rotate_plus(),25);
		word1 = writeInt(word1, TP3.get_motor_plus(),26);
		word1 = writeInt(word1, TP8.get_rotate_minus(),27);
		word1 = writeInt(word1, TP9.get_motor_plus(),28);
		word1 = writeInt(word1, TP9.get_motor_minus(),29);
		word1 = writeInt(word1, TP9.get_rotate_plus(),30);
		word1 = writeInt(word1, TP9.get_rotate_minus(),31);
		
		word2 = writeInt(word2, M1.get_motor_plus(),0);
		word2 = writeInt(word2, M1.get_motor_minus(),1);
		word2 = writeInt(word2, M1.get_working(),4);
		word2 = writeInt(word2, M2.get_motor_plus(),9);
		word2 = writeInt(word2, M2.get_motor_minus(),10);
		word2 = writeInt(word2, M2.get_working(),13);
		word2 = writeInt(word2, M4.get_motor_plus(),18);
		word2 = writeInt(word2, M4.get_motor_minus(),19);
		word2 = writeInt(word2, M4.get_working(),22);
		word2 = writeInt(word2, M6.get_motor_plus(),27);
		word2 = writeInt(word2, M6.get_motor_minus(),28);
		word2 = writeInt(word2, M6.get_working(),31);
		
		word3 = writeInt(word3, M3.get_motor_plus(),4);
		word3 = writeInt(word3, M3.get_motor_minus(),5);
		word3 = writeInt(word3, M3.get_working(),8);
		word3 = writeInt(word3, M5.get_motor_plus(),13);
		word3 = writeInt(word3, M5.get_motor_minus(),14);
		word3 = writeInt(word3, M5.get_working(),17);
		word3 = writeInt(word3, TP11.get_motor_plus(),22);
		word3 = writeInt(word3, TP11.get_motor_minus(),23);
		word3 = writeInt(word3, TP12.get_motor_plus(),24);
		word3 = writeInt(word3, TP12.get_motor_minus(),25);
		word3 = writeInt(word3, TP12.get_rotate_plus(),26);
		word3 = writeInt(word3, TP12.get_rotate_minus(),27);
		word3 = writeInt(word3, TP14.get_motor_plus(),28);
		word3 = writeInt(word3, TP14.get_motor_minus(),29);
		word3 = writeInt(word3, TP13.get_motor_plus(),30);
		word3 = writeInt(word3, TP13.get_motor_minus(),31);
		
		word4 = writeInt(word4, TP16.get_motor_plus(),0);
		word4 = writeInt(word4, TP16.get_motor_minus(),1);
		word4 = writeInt(word4, TP15.get_motor_plus(),2);
		word4 = writeInt(word4, TP15.get_motor_minus(),3);
		word4 = writeInt(word4, TP15.get_rotate_plus(),4);
		word4 = writeInt(word4, TP15.get_rotate_minus(),5);
		word4 = writeInt(word4, TP10.get_motor_plus(),6);
		word4 = writeInt(word4, TP10.get_motor_minus(),7);
		word4 = writeInt(word4, TP10.get_warehouse_in(),8);
		word4 = writeInt(word4, TP18.get_motor_plus(),9);
		word4 = writeInt(word4, TP18.get_motor_minus(),10);
		word4 = writeInt(word4, TP19.get_motor_plus(),11);
		word4 = writeInt(word4, TP19.get_motor_minus(),12);
		word4 = writeInt(word4, TP20.get_motor_plus(),13);
		word4 = writeInt(word4, TP20.get_motor_minus(),14);
		word4 = writeInt(word4, TP20.get_rotate_plus(),15);
		word4 = writeInt(word4, TP20.get_rotate_minus(),16);
		word4 = writeInt(word4, TP21.get_motor_plus(),17);
		word4 = writeInt(word4, TP21.get_motor_minus(),18);
		word4 = writeInt(word4, TP21.get_rotate_plus(),19);
		word4 = writeInt(word4, TP21.get_rotate_minus(),20);
		word4 = writeInt(word4, TP22.get_motor_plus(),21);
		word4 = writeInt(word4, TP22.get_motor_minus(),22);
		word4 = writeInt(word4, TP22.get_rotate_plus(),23);
		word4 = writeInt(word4, TP22.get_rotate_minus(),24);
		word4 = writeInt(word4, TP23.get_motor_plus(),25);
		word4 = writeInt(word4, TP23.get_motor_minus(),26);
		word4 = writeInt(word4, TP23.get_rotate_plus(),27);
		word4 = writeInt(word4, TP23.get_rotate_minus(),28);
		
		
	}
	
	public static void create_hashmap(){
		
		updatedValues.put("|var|CODESYS Control Win V3 x64.Application.Words.Word1", word1);
		updatedValues.put("|var|CODESYS Control Win V3 x64.Application.Words.Word2", word2);
		updatedValues.put("|var|CODESYS Control Win V3 x64.Application.Words.Word3", word3);
		updatedValues.put("|var|CODESYS Control Win V3 x64.Application.Words.Word4", word4);
		
	}
	
	public static void maq_estados() {
		
		if(aux == 1) {
			int[] operations = new int[3];
			operations[0]=0;
			operations[1]=0;
			operations[2]=0;
			pieces_vector.add(new piece(1,5,operations,0, 0, 0));
			aux=2;
		}
		
		/*if(localizacao_peca(1,pieces_vector)!=-1) {
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
		else TP4_tem_peca=0;*/
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
		/*if(localizacao_peca(19,pieces_vector)!=-1) {
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
		else TP23_tem_peca=0;*/
		if(localizacao_peca(51,pieces_vector)!=-1) {
			id_peca_M1 = localizacao_peca(51,pieces_vector);
			M1_tem_peca=1;
		}
		else M1_tem_peca=0;
		if(localizacao_peca(52,pieces_vector)!=-1) {
			id_peca_M1 = localizacao_peca(52,pieces_vector);
			M2_tem_peca=1;
		}
		else M2_tem_peca=0;
		if(localizacao_peca(53,pieces_vector)!=-1) {
			id_peca_M3 = localizacao_peca(53,pieces_vector);
			M3_tem_peca=1;
		}
		else M3_tem_peca=0;
		if(localizacao_peca(54,pieces_vector)!=-1) {
			id_peca_M4 = localizacao_peca(54,pieces_vector);
			M4_tem_peca=1;
		}
		else M4_tem_peca=0;
		if(localizacao_peca(55,pieces_vector)!=-1) {
			id_peca_M1 = localizacao_peca(55,pieces_vector);
			M5_tem_peca=1;
		}
		else M5_tem_peca=0;
		if(localizacao_peca(56,pieces_vector)!=-1) {
			id_peca_M1 = localizacao_peca(56,pieces_vector);
			M6_tem_peca=1;
		}
		else M6_tem_peca=0;
			
		//*******************DISPARAR TRANSIÃ‡Ã•ES************************
		/*
		//TRANSIÃ‡Ã•ES TAPETE 1
		if (TP1.estado == 0 && TP1.presenca() == true && TP3.presenca() == true) TP1.estado = 1;
		else if (TP1.estado == 0 && TP1.presenca() == true && TP3.presenca() == false) TP1.estado = 2;
		else if (TP1.estado == 1 && TP3.presenca() == false) TP1.estado = 2;
		else if (TP1.estado == 2 && TP2.estado == 1) TP1.estado = 3;
		else if (TP1.estado == 3 && TP2.estado == 4) TP1.estado = 0; 

		//TRANSIÃ‡Ã•ES TAPETE 2
		if (TP2.estado == 0 && TP2.orientacao == 1) TP2.estado = 1;
		else if (TP2.estado == 1 && TP1.estado == 2 && TP3.estado != 2) TP2.estado = 2;
		else if (TP2.estado == 1 && TP1.estado != 2 && TP3.estado == 2) TP2.estado = 3;
		else if (TP2.estado == 2 && TP2.presenca == true) TP2.estado = 4;
		else if (TP2.estado == 3 && TP2.presenca == true) TP2.estado = 4;
		else if (TP2.estado == 4 && TP2.orientacao == 0) TP2.estado = 5;
		else if (TP2.estado == 5 && TP4.estado == 2) TP2.estado = 0;

		//TRANSIÃ‡Ã•ES TAPETE 3
		if (TP3.estado == 0 && TP3.presenca() == true && TP1.presenca() == true) TP3.estado = 1;
		else if (TP3.estado == 0 && TP3.presenca() == true && TP1.presenca() == false) TP3.estado = 2;
		else if (TP3.estado == 1 && TP1.presenca() == false) TP3.estado = 2;
		else if (TP3.estado == 2 && TP2.estado == 1) TP3.estado = 3;
		else if (TP3.estado == 3 && TP2.estado == 4) TP3.estado = 0; 

		//TRANSIÃ‡Ã•ES TAPETE 4
		if (TP4.estado == 0 && TP2.estado == 5) TP4.estado = 1;
		else if (TP4.estado == 1 && TP4.presenca() == true) TP4.estado = 2;
		else if (TP4.estado == 2 && /*condicao armazem não esta cheio*/) TP4.estado = 3;
		else if (TP4.estado == 3 && TP4.presenca() == false) TP4.estado = 0;
		*/
		//TRANSIÃ‡Ã•ES TAPETE 5
		if (TP5.estado == 0 && TP5.presenca() == true) {
			TP5.estado = 1;
		}
		if (TP5.estado == 1 && TP6.estado == 0) {
			TP5.estado = 2;
		}
		if (TP5.estado == 2 && TP6.presenca() == true) {
			TP5.estado = 0;
		}
		//TRANSIÃ‡Ã•ES TAPETE 6
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
		if (TP6.estado == 0 && M1.envia_peca == 1) { //Maquina de cima envia peÃ§a
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
		//TRANSIÃ‡Ã•ES TAPETE 7
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
		if (TP7.estado == 0 && M2.envia_peca == 1) { //Maquina de cima envia peÃ§a
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
		if (TP7.estado == 0 && M3.envia_peca == 1) { //Maquina de baixo envia peÃ§a
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
		//TRANSIÃ‡Ã•ES TAPETE 8
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
		if (TP8.estado == 0 && M4.envia_peca == 1) { //Maquina de cima envia peÃ§a
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
		if (TP8.estado == 0 && M5.envia_peca == 1) { //Maquina de baixo envia peÃ§a
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
		//TRANSIÃ‡Ã•ES TAPETE 9
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
		if (TP9.estado == 0 && M6.envia_peca == 1) { //Maquina de cima envia peÃ§a
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
		//TRANSIÃ‡Ã•ES TAPETE 10
		if (TP10.estado == 0 && TP9.envia_peca == 1) {
			TP10.estado = 1;
		}
		if (TP10.estado == 1 && TP10.presenca() == true) {
			TP10.estado = 2;
		}
		if (TP10.estado == 2 ){ //&& armazem não esta cheio  
			TP10.estado = 3;
		}
		if(TP10.estado == 3 && TP10.presenca() == false){
			TP10.estado = 0;
		}
		//TRANSIÃ‡Ã•ES TAPETE 11
		if (TP11.estado == 0 && TP9.envia_peca_maq == 2) {
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
		//TRANSIÃ‡Ã•ES TAPETE 12
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
		if (TP12.estado == 5 && TP12.orientacao == 1) {
			TP12.estado = 0;
		}
		//TRANSIÃ‡Ã•ES TAPETE 13
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
		//TRANSIÃ‡Ã•ES TAPETE 14
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
		//TRANSIÃ‡Ã•ES TAPETE 15
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
		//TRANSIÃ‡Ã•ES TAPETE 16
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
		/*
		//TRANSIÃ‡Ã•ES TAPETE 19
		if (TP19.estado == 0 && TP19.presenca() == true) {
			TP19.estado = 1;
		}
		else if (TP19.estado == 1 && TP20.estado == 0) {
			TP19.estado = 2;
		}
		else if (TP19.estado == 2 && TP20.presenca() == true) {
			TP19.estado = 0;
		}

		//TRANSIÃ‡Ã•ES TAPETE 20
		if (TP20.estado == 0 && TP19.envia_peca == 1) {
			TP20.estado = 1;
		}
		else if (TP20.estado == 1 && TP20.presenca() == true) {
			TP20.estado = 2;
		}
		else if (TP20.estado == 2 && TP21.presenca() == false) {
			TP20.estado = 3;
		}
		else if (TP20.estado == 3 && TP20.orientacao == 1) {
			TP20.estado = 4;
		}
		else if (TP20.estado == 4 && TP21.presenca() == true) {
			TP20.estado = 5;
		}
		else if (TP20.estado == 5 && TP20.orientacao == 0) {
			TP20.estado = 0;
		}

		//TRANSIÃ‡Ã•ES TAPETE 21
		if (TP21.estado == 0 && TP20.envia_peca == 1 && TP21.presenca() == false) TP21.estado = 1;
		else if (TP21.estado == 1 && TP21.presenca() == true) TP21.estado = 2;
		else if (TP21.estado == 2 && TP22.presenca() == false) TP21.estado = 5;
		else if (TP21.estado == 5 && TP22.presenca() == true) TP21.estado = 0;
		else if (TP21.estado == 2 && TP22.presenca() == true && TP211.presenca() == false) TP21.estado = 3;
		else if (TP21.estado == 3 && /*TP21.fe == true*/) TP21.estado = 4;
		else if (TP21.estado == 4 && /*TP21.fr == true*/) TP21.estado = 0;

		//TRANSIÃ‡Ã•ES TAPETE 22
		if (TP22.estado == 0 && TP21.envia_peca == 1 && TP22.presenca() == false) TP22.estado = 1;
		else if (TP22.estado == 1 && TP22.presenca() == true) TP22.estado = 2;
		else if (TP22.estado == 2 && TP23.presenca() == false) TP22.estado = 5;
		else if (TP22.estado == 5 && TP23.presenca() == true) TP22.estado = 0;
		else if (TP22.estado == 2 && TP23.presenca() == true && TP221.presenca() == false) TP22.estado = 3;
		else if (TP22.estado == 3 && /*TP22.fe == true*/) TP22.estado = 4;
		else if (TP22.estado == 4 && /*TP22.fr == true*/) TP22.estado = 0;

		//TRANSIÃ‡Ã•ES TAPETE 23
		if (TP23.estado == 0 && TP22.envia_peca == 1 && TP23.presenca() == false) TP23.estado = 1;
		else if (TP23.estado == 1 && TP23.presenca() == true) TP23.estado = 2;
		else if (TP23.estado == 2 && TP231.presenca() == false) TP22.estado = 3;
		else if (TP23.estado == 3 && /*TP23.fe == true*/) TP23.estado = 4;
		else if (TP23.estado == 4 && /*TP23.fr == true*/) TP23.estado = 0;

		//TRANSIÃ‡Ã•ES MÃ�QUINA 1
		if (M1.estado == 0 && TP6.envia_peca_maq == 1) {
			M1.estado = 1;
		}*/
		if (M1.estado == 1 && M1.presenca() == true) {
			M1.estado = 2;
		}
		if (M1.estado == 2 ) { //&& passou tempo de operaÃ§Ã£o
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
		//TRANSIÃ‡Ã•ES MÃ�QUINA 2
		if (M2.estado == 0 && TP7.envia_peca_maq == 1) {
			M2.estado = 1;
		}
		if (M2.estado == 1 && M2.presenca() == true) {
			M2.estado = 2;
		}
		if (M2.estado == 2 ) { //&& passou tempo de operaÃ§Ã£o
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
		//TRANSIÃ‡Ã•ES MÃ�QUINA 3
		if (M3.estado == 0 && TP7.envia_peca_maq == 2) {
			M3.estado = 1;
		}
		if (M3.estado == 1 && M3.presenca() == true) {
			M3.estado = 2;
		}
		if (M3.estado == 2 ) { //&& passou tempo de operaÃ§Ã£o
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
		//TRANSIÃ‡Ã•ES MÃ�QUINA 4
		if (M4.estado == 0 && TP8.envia_peca_maq == 1) {
			M4.estado = 1;
		}
		if (M4.estado == 1 && M4.presenca() == true) {
			M4.estado = 2;
		}
		if (M4.estado == 2 ) { //&& passou tempo de operaÃ§Ã£o
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
		//TRANSIÃ‡Ã•ES MÃ�QUINA 5
		if (M5.estado == 0 && TP8.envia_peca_maq == 2) {
			M5.estado = 1;
		}
		if (M5.estado == 1 && M5.presenca() == true) {
			M5.estado = 2;
		}
		if (M5.estado == 2 ) { //&& passou tempo de operaÃ§Ã£o
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
		//TRANSIÃ‡Ã•ES MÃ�QUINA 6
		if (M6.estado == 0 && TP9.envia_peca_maq == 1) {
			M6.estado = 1;
		}
		if (M6.estado == 1 && M6.presenca() == true) {
			M6.estado = 2;
		}
		if (M6.estado == 2) { //&& passou tempo de operaÃ§Ã£o
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
		/*
		//OUTPUTS TAPETE 1
		if (TP1.estado == 3) TP1.move_left(true);
		else TP1.move_left(false);

		//OUTPUTS TAPETE 2
		switch(TP2.estado){
			case 0: TP2.move_right(false); TP2.rotate_clock(true); break;
			case 1: TP2.rotate_clock(false); break;
			case 2: TP2.move_left(true); break;
			case 3: TP2.move_left(false); TP2.move_right(true); break;
			case 4: TP2.move_right(false); TP2.rotate_anticlock(true); break;
			case 5: TP2.rotate_anticlock(false); TP2.move_right(true); break;
			default: break;
		}

		//OUTPUTS TAPETE 3
		if (TP1.estado == 3) TP1.move_right(true);
		else TP1.move_right(false);

		//OUTPUTS TAPETE 4
		switch(TP4.estado){
			case 1: TP4.move_right(true); break;
			case 2: TP4.move_right(false); break;
			case 3: TP4.warehouseIn(true); break;
			default: TP4.warehouseIn(false); break;
		}
		*/
		//OUTPUTS TAPETE 5
		if(TP5.estado==0) {
			TP5.envia_peca = 0;
		}
		if (TP5.estado == 1) {
			TP5.envia_peca = 1;
			TP5.move_right(true);
		}
		if(TP5.estado == 2) {
			TP5.envia_peca = 0;
			TP5.move_right(false);
			pieces_vector.get(id_peca_TP5).set_position(6);
		}

		//OUTPUTS TAPETE 6 
		if(TP6.estado==0) {
			TP6.rotate_anticlock(false);
			TP6.move_right(false);
			TP6.envia_peca = 0;
		}
		if (TP6.estado == 1) {
			TP6.move_right(true);
		}
		if(TP6.estado==2) {
			TP6.rotate_anticlock(false);
			TP6.move_right(false);
		}
		if(TP6.estado==3) {
			
		}
		if (TP6.estado == 4) {
			TP6.rotate_clock(true);
			TP6.envia_peca_maq = 1;
		}
		if (TP6.estado == 5) {
			TP6.rotate_clock(false);
			TP6.move_left(true); 
		}
		if (TP6.estado == 6) {
			TP6.move_left(false);
			TP6.rotate_anticlock(true);
			TP6.envia_peca_maq = 0;
			pieces_vector.get(id_peca_TP6).set_position(51);
		}
		if(TP6.estado==7) {
			TP6.rotate_anticlock(false);
		}
		if (TP6.estado == 8) {
			TP6.envia_peca = 1;
			TP6.move_right(true);
			pieces_vector.get(id_peca_TP6).set_position(7);
		}
		if (TP6.estado == 9) {
			TP6.rotate_clock(true);
		}
		if (TP6.estado == 10) {
			TP6.rotate_clock(false);
			TP6.move_left(true);
		}
		if (TP6.estado == 11){
			TP6.move_left(false);
			TP6.rotate_anticlock(true);
		}
		if (TP6.estado == 12) {
			TP6.rotate_clock(true);
		}
		if (TP6.estado == 13) {
			TP6.rotate_clock(false);
			TP6.move_right(true);
		}
		if (TP6.estado == 14) {
			TP6.move_right(false);
			TP6.rotate_anticlock(true);
		}
		//OUTPUTS TAPETE 7 
		if(TP7.estado==0) {
			TP7.envia_peca = 0;
			TP7.rotate_anticlock(false);
		}
		if (TP7.estado == 1) {
			TP7.move_right(true);
		}
		if(TP7.estado == 2) {
			TP7.move_right(false);
		}
		if(TP7.estado == 3) {
			
		}
		if (TP7.estado == 4) {
			TP7.envia_peca_maq = 1;
			TP7.rotate_clock(true);
		}
		if (TP7.estado == 5) {
			TP7.rotate_clock(false);
			TP7.move_left(true);
		}
		if (TP7.estado == 6) {
			TP7.envia_peca_maq = 0;
			pieces_vector.get(id_peca_TP7).set_position(52);
			TP7.move_left(false);
			TP7.rotate_anticlock(true);
		}
		if (TP7.estado == 7) {
			TP7.rotate_anticlock(false);
		}
		if (TP7.estado == 8) {
			TP7.envia_peca_maq = 2;
			TP7.rotate_clock(true);
		}
		if (TP7.estado == 9) {
			TP7.rotate_clock(false);
			TP7.move_right(true);
		}
		if (TP7.estado == 10) {
			TP7.envia_peca_maq = 0;
			pieces_vector.get(id_peca_TP7).set_position(53);
			TP7.move_right(false);
			TP7.rotate_anticlock(true);
		}
		if(TP7.estado == 11) {
			TP7.rotate_anticlock(false);
			TP7.move_right(true);
		}
		if (TP7.estado == 12) {
			TP7.envia_peca = 1;
			pieces_vector.get(id_peca_TP7).set_position(8);
		}
		if (TP7.estado == 13) {
			TP7.rotate_clock(true);
		}
		if (TP7.estado == 14) {
			TP7.rotate_clock(false);
			TP7.move_right(true);
		}
		if (TP7.estado == 15) {
			TP7.move_right(false);
			TP7.rotate_anticlock(true);
		}
		if (TP7.estado == 16) {
			TP7.rotate_clock(true);
		}
		if (TP7.estado == 17) {
			TP7.rotate_clock(false);
			TP7.move_left(true);
		}
		if (TP7.estado == 18) {
			TP7.move_left(false);
			TP7.rotate_anticlock(true);
		}
		//OUTPUTS TAPETE 8 
		if (TP8.estado == 0) {
			TP8.envia_peca = 0;
			TP8.rotate_anticlock(false);
			TP8.move_right(false);
		}
		if (TP8.estado == 1) {
			TP8.move_right(true);
		}
		if (TP8.estado == 2) {
			TP8.move_right(false);
		}
		if (TP8.estado == 3) {
			
		}
		if (TP8.estado == 4) {
			TP8.envia_peca_maq = 1;
			TP8.rotate_clock(true);
		}
		if (TP8.estado == 5) {
			TP8.rotate_clock(false);
			TP8.move_left(true);
		}
		if (TP8.estado == 6) {
			TP8.envia_peca_maq = 0;
			pieces_vector.get(id_peca_TP8).set_position(54);
			TP8.move_left(false);
			TP8.rotate_anticlock(true);
		}
		if (TP8.estado == 7) {
			
		}
		if (TP8.estado == 8) {
			TP8.envia_peca_maq = 2;
			TP8.rotate_clock(true);
		}
		if (TP8.estado == 9) {
			TP8.rotate_clock(false);
			TP8.move_right(true);
		}
		if (TP8.estado == 10) {
			TP8.envia_peca_maq = 0;
			pieces_vector.get(id_peca_TP8).set_position(55);
			TP8.move_right(false);
			TP8.rotate_anticlock(true);
		}
		if (TP8.estado == 11) {
			TP8.rotate_anticlock(false);
		}
		if (TP8.estado == 12) {
			TP8.envia_peca = 1;
			pieces_vector.get(id_peca_TP8).set_position(9);
			TP8.move_right(true);
		}
		if (TP8.estado == 13) {
			TP8.rotate_clock(true);
		}
		if (TP8.estado == 14) {
			TP8.rotate_clock(false);
			TP8.move_right(true);
		}
		if (TP8.estado == 15) {
			TP8.move_right(false);
			TP8.rotate_anticlock(true);
		}
		if (TP8.estado == 16) {
			TP8.rotate_clock(true);
		}
		if (TP8.estado == 17) {
			TP8.rotate_clock(false);
			TP8.move_left(true);
		}
		if (TP8.estado == 18) {
			TP8.move_left(false);
			TP8.rotate_anticlock(true);
		}
		//OUTPUTS TAPETE 9 
		if (TP9.estado == 0) {
			TP9.envia_peca = 0;
			TP9.rotate_anticlock(false);
			TP9.move_right(false);
		}
		if (TP9.estado == 1) {
			TP9.move_right(true);
		}
		if (TP9.estado == 2) {
			TP9.move_right(false);
		}
		if (TP9.estado == 3) {
			
		}
		if (TP9.estado == 5) {
			TP9.envia_peca_maq = 1;
			TP9.rotate_clock(true);
		}
		if (TP9.estado == 6) {
			TP9.rotate_clock(false);
			TP9.move_left(true);
		}
		if (TP9.estado == 7) {
			TP9.envia_peca_maq = 0;
			pieces_vector.get(id_peca_TP9).set_position(56);
			TP9.rotate_anticlock(true);
		}
		if (TP9.estado == 10) {
			TP9.envia_peca = 1;
			pieces_vector.get(id_peca_TP9).set_position(10);
			TP9.move_right(true);
		}
		if (TP9.estado == 12) {
			TP9.envia_peca_maq = 2;
			TP9.rotate_clock(true);
		}
		if (TP9.estado == 13) {
			TP9.rotate_clock(false);
			TP9.move_right(true);
		}
		if (TP9.estado == 14) {
			TP9.envia_peca_maq = 0;
			pieces_vector.get(id_peca_TP9).set_position(11);
			TP9.move_right(false);
			TP9.rotate_anticlock(true);
		}
		if (TP9.estado == 15) {
			TP9.rotate_clock(true);
		}
		if (TP9.estado == 16) {
			TP9.rotate_clock(false);
			TP9.move_right(true);
		}
		if (TP9.estado == 17) {
			TP9.move_right(false);
			TP9.rotate_anticlock(true);
		}
		//OUTPUTS TAPETE 10
		if (TP10.estado == 0) {
			TP10.warehouseIn(false);
		}
		if (TP10.estado == 1) {
			TP10.move_right(true);
		}
		if (TP10.estado == 2) {
			TP10.move_right(false);
		}
		if (TP10.estado == 3) {
			TP10.warehouseIn(true);
			pieces_vector.remove(id_peca_TP10);
		}
		//OUTPUTS TAPETE 11 
		if (TP11.estado == 0) {
			TP11.envia_peca = 0;
			TP11.move_right(false);
		}
		if (TP11.estado == 1) {
			TP11.move_right(true);
		}
		if (TP11.estado == 2) {
			TP11.move_right(false);
		}
		if (TP11.estado == 3) {
			TP11.envia_peca = 1;
			pieces_vector.get(id_peca_TP11).set_position(12);
			TP11.move_right(true);
		}
		//OUTPUTS TAPETE 12 
		if (TP12.estado == 0) {
			TP12.rotate_anticlock(false);
		}
		if (TP12.estado == 1) {
			TP12.move_right(true);
		}
		if (TP12.estado == 2) {
			TP12.move_right(false);
		}
		if (TP12.estado == 3) {
			TP12.envia_peca = 1;
			TP12.rotate_clock(true);
		}
		if (TP12.estado == 4) {
			TP12.rotate_clock(false);
			TP12.move_left(true);
		}
		if (TP12.estado == 5) {
			pieces_vector.get(id_peca_TP12).set_position(13);
			TP12.envia_peca = 0;
			TP12.move_left(false);
			TP12.rotate_anticlock(true);
		}
		//OUTPUTS TAPETE 13
		if (TP13.estado == 0) {
			TP13.envia_peca = 0;
			TP13.move_left(false);
		}
		if (TP13.estado == 1) {
			TP13.move_left(true);
		}
		if (TP13.estado == 2) {
			TP13.move_left(false);
		}
		if (TP13.estado == 3) {
			pieces_vector.get(id_peca_TP13).set_position(14);
			TP13.envia_peca = 1;
			TP13.move_left(true);
		}
		//OUTPUTS TAPETE 14
		if (TP14.estado == 0) {
			TP14.envia_peca = 0;
			TP14.move_left(false);
		}
		if (TP14.estado == 1) {
			TP14.move_left(true);
		}
		if (TP14.estado == 2) {
			TP14.move_left(false);
		}
		if (TP14.estado == 3) {
			pieces_vector.get(id_peca_TP14).set_position(15);
			TP14.envia_peca = 1;
			TP14.move_left(true);
		}
		//OUTPUTS TAPETE 15 
		if (TP15.estado == 0) {
			TP15.rotate_clock(false);
		}
		if (TP15.estado == 1) {
			TP15.move_left(true);
		}
		if (TP15.estado == 2) {
			TP15.move_left(false);
		}
		if (TP15.estado == 3) {
			TP15.envia_peca = 1;
			TP15.rotate_anticlock(true);
		}
		if (TP15.estado == 4) {
			TP15.rotate_anticlock(false);
			TP15.move_left(true);
		}
		if (TP15.estado == 5) {
			pieces_vector.get(id_peca_TP15).set_position(16);
			TP15.envia_peca = 0;
			TP15.move_left(false);
			TP15.rotate_clock(true);
		}
		//OUTPUTS TAPETE 16 
		if (TP16.estado == 0) {
			TP16.move_left(false);
		}
		if (TP16.estado == 1) {
			TP16.move_left(true);
		}
		if (TP16.estado== 2) {
			TP16.move_left(false);
		}
		if (TP16.estado== 3) {
			TP16.envia_peca = 1;
		}
		if (TP16.estado == 4) {
			pieces_vector.get(id_peca_TP16).set_position(6);
			TP16.envia_peca = 0;
			TP16.move_left(true);
		}
		/*
		//OUTPUTS TAPETE 19
		switch(TP19.estado){
			case 2: TP19.move_right(true); TP19.envia_peca = 1; break;
			default: TP19.move_right(false); TP19.envia_peca = 0; break;
		}

		//OUTPUTS TAPETE 20
		switch(TP20.estado){
			case 0: TP20.rotate_anticlock(false);
			case 1: TP20.move_right(true); break;
			case 2: TP20.move_right(false); break;
			case 3: TP20.rotate_clock(true); break;
			case 4: TP20.rotate_clock(false); TP20.move_right(true); TP20.envia_peca = 1; break;
			case 5: TP20.move_right(false); TP20.envia_peca = 0; TP20.rotate_anticlock(true); break;
			default: break;
		}

		//OUTPUTS TAPETE 21
		switch (TP21.estado){
			case 0: /*TP21.pr = 0;*/ TP21.move_right(false); TP21.envia_peca = 0; break;
			case 1: TP21.move_right(true); break;
			case 2: TP21.move_right(false); break;
			case 3: /*TP21.pe = 1;*/ break;
			case 4: /*TP21.pe = 0; TP21.pr = 1;*/ break;
			case 5: TP21.move_right(true); TP21.envia_peca = 1; break;
			default: break;
		} 

		//OUTPUTS TAPETE 22
		switch(TP22.estado){
			case 0: /*TP22.pr = 0;*/ TP22.move_right(false); TP22.envia_peca = 0; break;
			case 1: TP22.move_right(true); break;
			case 2: TP22.move_right(false); break;
			case 3: /*TP22.pe = 1;*/ break;
			case 4: /*TP22.pe = 0; TP22.pr = 1;*/ break;
			case 5: TP22.move_right(true); TP22.envia_peca = 1; break;
			default: break;
		}

		//OUTPUTS TAPETE 23
		switch(TP23.estado){
			case 0: /*TP23.pr = 0;*/ break;
			case 1: TP23.move_right(true); break;
			case 2: TP23.move_right(false); break;
			case 3: /*TP23.pe = 1;*/ break;
			case 4: /*TP23.pe = 0; TP23.pr = 1;*/ break;
			default: break;
		}
		*/
		//OUTPUTS MÃ�QUINA 1 
		if (M1.estado == 0) {
			M1.envia_peca = 0;
			M1.move_right(false);
		}
		if (M1.estado == 1) {
			M1.move_left(true);
		}
		if (M1.estado == 2) {
			M1.move_left(false);
			M1.work(true);
		}
		if (M1.estado == 3) {
			M1.work(false);
			pieces_vector.get(id_peca_M1).atualiza_operacoes();
		}
		if (M1.estado == 4) {
			M1.envia_peca = 1;
		}
		if (M1.estado == 5) {
			pieces_vector.get(id_peca_M1).set_position(6);
			M1.move_right(true);
		}
		//OUTPUTS MÃ�QUINA 2 
		if (M2.estado == 0) {
			M2.envia_peca = 0;
			M2.move_right(false);
		}
		if (M2.estado == 1) {
			M2.move_left(true);
		}
		if (M2.estado == 2) {
			M2.move_left(false);
			M2.work(true);
		}
		if (M2.estado == 3) {
			M2.work(false);
			pieces_vector.get(id_peca_M2).atualiza_operacoes();
		}
		if (M2.estado == 4) {
			M2.envia_peca = 1;
		}
		if (M2.estado == 5) {
			pieces_vector.get(id_peca_M2).set_position(7);
			M2.move_right(true);
		}
		//OUTPUTS MÃ�QUINA 3 
		if (M3.estado == 0) {
			M3.envia_peca = 0;
			M3.move_left(false);
		}
		if (M3.estado == 1) {
			M3.move_right(true);
		}
		if (M3.estado == 2) {
			M3.move_right(false);
			M3.work(true);
		}
		if (M3.estado == 3) {
			M3.work(false);
			pieces_vector.get(id_peca_M3).atualiza_operacoes();
		}
		if (M3.estado == 4) {
			M3.envia_peca = 1;
		}
		if (M3.estado == 5) {
			pieces_vector.get(id_peca_M3).set_position(7);
			M3.move_left(true);
		}
		//OUTPUTS MÃ�QUINA 4 
		if (M4.estado == 0) {
			M4.envia_peca = 0;
			M4.move_right(false);
		}
		if (M4.estado == 1) {
			M4.move_left(true);
		}
		if (M4.estado == 2) {
			M4.move_left(false);
			M4.work(true);
		}
		if (M4.estado == 3) {
			M4.work(false);
			pieces_vector.get(id_peca_M4).atualiza_operacoes();
		}
		if (M4.estado == 4) {
			M4.envia_peca = 1;
		}
		if (M4.estado == 5) {
			pieces_vector.get(id_peca_M4).set_position(8);
			M4.move_right(true);
		}
		//OUTPUTS MÃ�QUINA 5 
		if (M5.estado == 0) {
			M5.envia_peca = 0;
			M5.move_left(false);
		}
		if (M5.estado == 1) {
			M5.move_right(true);
		}
		if (M5.estado == 2) {
			M5.move_right(false);
			M5.work(true);
		}
		if (M5.estado == 3) {
			M5.work(false);
			pieces_vector.get(id_peca_M5).atualiza_operacoes();
		}
		if (M5.estado == 4) {
			M5.envia_peca = 1;
		}
		if (M5.estado == 5) {
			pieces_vector.get(id_peca_M5).set_position(8);
			M5.move_left(true);
		}
		//OUTPUTS MÃ�QUINA 6
		if (M6.estado == 0) {
			M6.envia_peca = 0;
			M6.move_right(false);
		}
		if (M6.estado == 1) {
			M6.move_left(true);
		}
		if (M6.estado == 2) {
			M6.move_left(false);
			M6.work(true);
		}
		if (M6.estado == 3) {
			M6.work(false);
			pieces_vector.get(id_peca_M6).atualiza_operacoes();
		}
		if (M6.estado == 4) {
			M6.envia_peca = 1;
		}
		if (M6.estado == 5) {
			pieces_vector.get(id_peca_M6).set_position(9);
			M6.move_right(true);
		}
		
	}
	
	public static HashMap<String, Integer> run_main(ArrayList<Integer> list) { 
		
		atualiza_inputs(list);
		atualiza_outputs();
		maq_estados();
		create_hashmap();
		return updatedValues;
		
		}
	
}
