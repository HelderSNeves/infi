package MES;
import java.util.Arrays;
import java.util.ArrayList;


public class mes_main {
	
	public static int localizacao_peca(int tapete, ArrayList<piece> pieces_vector) {
		
		int id=-1;
		
		for(int i=0; i<pieces_vector.size();i++) {
			if(pieces_vector.get(i).position==tapete) {
				id = i;
			}
		}
		
		return id;
	}

	public static void main(String[] args) {
		int id_peca_TP5=0, id_peca_TP6=0, id_peca_TP7=0, id_peca_TP8=0, id_peca_TP9=0, id_peca_TP10=0, id_peca_TP11=0, id_peca_TP12=0, id_peca_TP13=0, id_peca_TP14=0, id_peca_TP15=0, id_peca_TP16=0;
		int TP5_tem_peca=0, TP6_tem_peca=0, TP7_tem_peca=0, TP8_tem_peca=0, TP9_tem_peca=0, TP10_tem_peca=0, TP11_tem_peca=0, TP12_tem_peca=0, TP13_tem_peca=0, TP14_tem_peca=0, TP15_tem_peca=0, TP16_tem_peca=0;
		ArrayList<piece> pieces_vector = new ArrayList<piece>(); //vetor com as peças que estão na floor plant
		//*******************CRIAR TAPETES************************
		conveyor_belt TP5 = new conveyor_belt(5,0,0);
		conveyor_belt TP6 = new conveyor_belt(6,1,0);
		conveyor_belt TP7 = new conveyor_belt(7,1,2);
		conveyor_belt TP8 = new conveyor_belt(8,3,3);
		conveyor_belt TP9 = new conveyor_belt(9,4,0);
		conveyor_belt TP10 = new conveyor_belt(10,0,0);
		conveyor_belt TP11 = new conveyor_belt(11,0,0);
		conveyor_belt TP12 = new conveyor_belt(12,0,0);
		conveyor_belt TP13 = new conveyor_belt(13,0,0);
		conveyor_belt TP14 = new conveyor_belt(14,0,0);
		conveyor_belt TP15 = new conveyor_belt(15,0,0);
		conveyor_belt TP16 = new conveyor_belt(16,0,0);
		//*******************CRIAR MÁQUINAS************************
		machine M1 = new machine(1,1,1);
		machine M2 = new machine(2,1,1);
		machine M3 = new machine(3,2,2);
		machine M4 = new machine(4,3,1);
		machine M5 = new machine(5,3,2);
		machine M6 = new machine(6,4,2);
		
		
		pieces_vector.add(new piece());
		
		
		while (true) {
			
			//*******************ATUALIZAR POSICAO PEÇAS************************
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
				
			//*******************DISPARAR TRANSIÇÕES************************
			//TRANSIÇÕES TAPETE 5
			
			if (TP5.estado == 0 /*&& armazem envia peça*/ ) {
				TP5.estado = 1;
			}
			if (TP5.estado == 1 && TP6.presenca() == 0) {
				TP5.estado = 2;
			}
			if (TP5.estado == 2 && TP6.presenca() == 1) {
				TP5.estado = 0;
			}
			//TRANSIÇÕES TAPETE 6
			if (TP6.estado == 0 && TP5.envia_peca == 1) {
				TP6.estado = 1;
			}
			if (TP6.estado == 1 && TP6.presenca() == 1) {
				TP6.estado = 2;
			}
			if (TP6.estado == 2 && pieces_vector.get(id_peca_TP6).operations[0]==TP6.maq_cima()) {
				TP6.estado = 3;
			}
			if (TP6.estado == 3 && M1.presenca() == 0) {
				TP6.estado = 4;
			}
			if (TP6.estado == 4 && TP6.orientacao == 1) {
				TP6.estado = 5;
			}
			if (TP6.estado == 5 && M1.presenca() == 1) {
				TP6.estado = 6;
			}
			if (TP6.estado == 6 && TP6.orientacao == 0) {
				TP6.estado = 0;
			}
			if (TP6.estado == 2 && (M1.presenca()!=0 || pieces_vector.get(id_peca_TP6).operations[0]!=TP6.maq_cima())) {
				TP6.estado = 7;
			}
			if (TP6.estado == 7 && TP7.presenca() == 0) {
				TP6.estado = 8;
			}
			if (TP6.estado == 8 && TP7.presenca() == 1) {
				TP6.estado = 0;
			}
			if (TP6.estado == 0 && TP16.envia_peca == 1) {
				TP6.estado = 9;
			}
			if (TP6.estado == 9 && TP6.orientacao == 1) {
				TP6.estado = 10;
			}
			if (TP6.estado == 10 && TP6.presenca() == 1) {
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
			if (TP6.estado == 13 && TP6.presenca() == 1) {
				TP6.estado = 14;
			}
			if (TP6.estado == 14 && TP6.orientacao == 0) {
				TP6.estado = 7;
			}
			//TRANSIÇÕES TAPETE 7
			if (TP7.estado == 0 && TP6.envia_peca == 1) {
				TP7.estado = 1;
			}
			if (TP7.estado == 1 && TP7.presenca() == 1) {
				TP7.estado = 2;
			}
			if (TP7.estado == 2 && pieces_vector.get(id_peca_TP7).operations[0]==TP7.maq_cima()) {
				TP7.estado = 3;
			}
			if (TP7.estado == 3 && M2.presenca() == 0) {
				TP7.estado = 4;
			}
			if (TP7.estado == 4 && TP7.orientacao == 1) {
				TP7.estado = 5;
			}
			if (TP7.estado == 5 && M2.presenca() == 1) {
				TP7.estado = 6;
			}
			if (TP7.estado == 6 && TP7.orientacao == 0) {
				TP7.estado = 0;
			}
			if (TP7.estado == 2 && pieces_vector.get(id_peca_TP7).operations[0]==TP7.maq_baixo()) {
				TP7.estado = 7;
			}
			if (TP7.estado == 7 && M3.presenca() == 0) {
				TP7.estado = 8;
			}
			if (TP7.estado == 8 && TP7.orientacao == 1) {
				TP7.estado = 9;
			}
			if (TP7.estado == 9 && M3.presenca() == 1) {
				TP7.estado = 10;
			}
			if (TP7.estado == 10 && TP7.orientacao == 0) {
				TP7.estado = 0;
			}
			if (TP7.estado == 3 && M2.presenca() == 1) {
				TP7.estado = 11;
			}
			if (TP7.estado == 7 && M3.presenca() == 1) {
				TP7.estado = 11;
			}
			if (TP7.estado == 2 && pieces_vector.get(id_peca_TP7).operations[0]!=TP7.maq_baixo() && pieces_vector.get(id_peca_TP7).operations[0]!=TP7.maq_cima()) {
				TP7.estado = 11;
			}
			if (TP7.estado == 11 && TP8.presenca() == 0) {
				TP7.estado = 12;
			}
			if (TP7.estado == 12 && TP8.presenca() == 1){
				TP7.estado = 0;
			}
			if (TP7.estado == 0 && M2.envia_peca == 1) { //Maquina de cima envia peça
				TP7.estado = 13;
			}
			if (TP7.estado == 13 && TP7.orientacao == 1) {
				TP7.estado = 14;
			}
			if (TP7.estado == 14 && TP7.presenca() == 1) {
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
			if (TP7.estado == 17 && TP7.presenca() == 1) {
				TP7.estado = 18;
			}
			if (TP7.estado == 18 && TP7.orientacao == 0) {
				TP7.estado = 11;
			}
			//TRANSIÇÕES TAPETE 8
			if (TP8.estado == 0 && TP7.envia_peca == 1) {
				TP8.estado = 1;
			}
			if (TP8.estado == 1 && TP8.presenca() == 1) {
				TP8.estado = 2;
			}
			if (TP8.estado == 2 && pieces_vector.get(id_peca_TP8).operations[0]==TP8.maq_cima()) {
				TP8.estado = 3;
			}
			if (TP8.estado == 3 && M4.presenca() == 0) {
				TP8.estado = 4;
			}
			if (TP8.estado == 4 && TP8.orientacao == 1) {
				TP8.estado = 5;
			}
			if (TP8.estado == 5 && M4.presenca() == 1) {
				TP8.estado = 6;
			}
			if (TP8.estado == 6 && TP8.orientacao == 0) {
				TP8.estado = 0;
			}
			if (TP8.estado == 2 && pieces_vector.get(id_peca_TP8).operations[0]==TP8.maq_baixo()) {
				TP8.estado = 7;
			}
			if (TP8.estado == 7 && M5.presenca() == 0) {
				TP8.estado = 8;
			}
			if (TP8.estado == 8 && TP8.orientacao == 1) {
				TP8.estado = 9;
			}
			if (TP8.estado == 9 && M5.presenca() == 1) {
				TP8.estado = 10;
			}
			if (TP8.estado == 10 && TP8.orientacao == 0) {
				TP8.estado = 0;
			}
			if (TP8.estado == 3 && M4.presenca() == 1) {
				TP8.estado = 11;
			}
			if (TP8.estado == 7 && M4.presenca() == 1) {
				TP8.estado = 11;
			}
			if (TP8.estado == 2 && pieces_vector.get(id_peca_TP8).operations[0]!=TP8.maq_baixo() && pieces_vector.get(id_peca_TP8).operations[0]==TP8.maq_cima()) {
				TP8.estado = 11;
			}
			if (TP8.estado == 11 && TP8.presenca() == 0) {
				TP8.estado = 12;
			}
			if (TP8.estado == 12 && TP9.presenca() == 1) {
				TP8.estado = 0;
			}
			if (TP8.estado == 0 && M4.envia_peca == 1) { //Maquina de cima envia peça
				TP8.estado = 13;
			}
			if (TP8.estado == 13 && TP8.orientacao == 1) {
				TP8.estado = 14;
			}
			if (TP8.estado == 14 && TP8.presenca() == 1) {
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
			if (TP8.estado == 17 && TP8.presenca() == 1) {
				TP8.estado = 18;
			}
			if (TP8.estado == 18 && TP8.orientacao == 0) {
				TP8.estado = 11;
			}
			//TRANSIÇÕES TAPETE 9
			if (TP9.estado == 0 && TP8.envia_peca == 1) {
				TP9.estado = 1;
			}
			if (TP9.estado == 1 && TP9.presenca() == 1) {
				TP9.estado = 2;
			}
			if (TP9.estado == 2 && pieces_vector.get(id_peca_TP9).operations[0]==TP9.maq_cima()) {
				TP9.estado = 3;
			}
			if (TP9.estado == 3 && M6.presenca() == 0) {
				TP9.estado = 5;
			}
			if (TP9.estado == 5 && TP9.orientacao == 1) {
				TP9.estado = 6;
			}
			if (TP9.estado == 6 && M6.presenca() == 1) {
				TP9.estado = 7;
			}
			if (TP9.estado == 7 && TP9.orientacao == 0) {
				TP9.estado = 0;
			}
			if (TP9.estado == 2 && (pieces_vector.get(id_peca_TP9).operations[0]!=TP9.maq_cima() || M6.presenca()==1)) {
				TP9.estado = 8;
			}
			if (TP9.estado == 8 && pieces_vector.get(id_peca_TP9).operations[0]==0) {
				TP9.estado = 9;
			}
			if (TP9.estado == 9 && TP10.presenca() == 0) {
				TP9.estado = 10;
			}
			if (TP9.estado == 10 && TP10.presenca() == 1) {
				TP9.estado = 0;
			}
			if (TP9.estado == 8 && pieces_vector.get(id_peca_TP9).operations[0]!=0) {
				TP9.estado = 11;
			}
			if (TP9.estado == 11 && TP11.presenca() == 0) {
				TP9.estado = 12;
			}
			if (TP9.estado == 12 && TP9.orientacao == 1) {
				TP9.estado = 13;
			}
			if (TP9.estado == 13 && TP11.presenca() == 1) {
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
			if (TP9.estado == 16 && TP9.presenca() == 1) {
				TP9.estado = 17;
			}
			if (TP9.estado == 17 && TP9.orientacao == 0) {
				TP9.estado = 8;
			}
			//TRANSIÇÕES TAPETE 10
			if (TP10.estado == 0 && TP9.envia_peca == 1) {
				TP10.estado = 1;
			}
			if (TP10.estado == 1 /*&& armazem não esta cheio*/) {
				TP10.estado = 2;
			}
			if (TP10.estado == 2 /*&& peça entrou armazem*/) {
				TP10.estado = 0;
			}
			//TRANSIÇÕES TAPETE 11
			if (TP11.estado == 0 && TP9.envia_peca == 1) {
				TP11.estado = 1;
			}
			if (TP11.estado == 1 && TP11.presenca() == 1) {
				TP11.estado = 2;
			}
			if (TP11.estado == 2 && TP12.presenca() == 0) {
				TP11.estado = 3;
			}
			if (TP11.estado == 3 && TP12.presenca() == 1) {
				TP11.estado = 0;
			}
			//TRANSIÇÕES TAPETE 12
			if (TP12.estado == 0 && TP11.envia_peca == 1) {
				TP12.estado = 1;
			}
			if (TP12.estado == 1 && TP12.presenca() == 1) {
				TP12.estado = 2;
			}
			if (TP12.estado == 2 && TP13.presenca() == 0) {
				TP12.estado = 3;
			}
			if (TP12.estado == 3 && TP12.orientacao == 0) {
				TP12.estado = 4;
			}
			if (TP12.estado == 4 && TP13.presenca() == 1) {
				TP12.estado = 5;
			}
			if (TP12.estado == 15 && TP12.orientacao == 1) {
				TP12.estado = 0;
			}
			//TRANSIÇÕES TAPETE 13
			if (TP13.estado == 0 && TP12.envia_peca == 1) {
				TP13.estado = 1;
			}
			if (TP13.estado == 1 && TP13.presenca() == 1) {
				TP13.estado = 2;
			}
			if (TP13.estado == 2 && TP14.presenca() == 0) {
				TP13.estado = 3;
			}
			if (TP13.estado == 3 && TP14.presenca() == 1) {
				TP13.estado = 0;
			}
			//TRANSIÇÕES TAPETE 14
			if (TP14.estado == 0 && TP13.envia_peca == 1) {
				TP14.estado = 1;
			}
			if (TP14.estado == 1 && TP14.presenca() == 1) {
				TP14.estado = 2;
			}
			if (TP14.estado == 2 && TP15.presenca() == 0) {
				TP14.estado = 3;
			}
			if (TP14.estado == 3 && TP15.presenca() == 1) {
				TP14.estado = 0;
			}
			//TRANSIÇÕES TAPETE 15
			if (TP15.estado == 0 && TP14.envia_peca == 1) {
				TP15.estado = 1;
			}
			if (TP15.estado == 1 && TP15.presenca() == 1) {
				TP15.estado = 2;
			}
			if (TP15.estado == 2 && TP16.presenca() == 0) {
				TP15.estado = 3;
			}
			if (TP15.estado == 3 && TP15.orientacao == 1) {
				TP15.estado = 4;
			}
			if (TP15.estado == 4 && TP16.presenca() == 1) {
				TP15.estado = 5;
			}
			if (TP15.estado == 5 && TP15.orientacao == 0) {
				TP15.estado = 0;
			}
			//TRANSIÇÕES TAPETE 16
			if (TP16.estado == 0 && TP15.envia_peca == 1) {
				TP16.estado = 1;
			}
			if (TP16.estado == 1 && TP16.presenca() == 1) {
				TP16.estado = 2;
			}
			if (TP16.estado == 2 && TP6.presenca() == 0) {
				TP16.estado = 3;
			}
			if (TP16.estado == 3 && TP6.orientacao == 1) {
				TP16.estado = 4;
			}
			if (TP16.estado == 4 && TP6.presenca() == 1) {
				TP16.estado = 0;
			}
			//TRANSIÇÕES MÁQUINA 1
			if (M1.estado == 0 && TP6.envia_peca_maq == 1) {
				M1.estado = 1;
			}
			if (M1.estado == 1 && M1.presenca() == 1) {
				M1.estado = 2;
			}
			if (M1.estado == 2 /*&& passou tempo de operação*/) {
				M1.estado = 3;
			}
			if (M1.estado == 3 && TP6.presenca() == 0) {
				M1.estado = 4;
			}
			if (M1.estado == 4 && TP6.orientacao == 1) {
				M1.estado = 5;
			}
			if (M1.estado == 5 && TP6.presenca() == 1) {
				M1.estado = 0;
			}
			//TRANSIÇÕES MÁQUINA 2
			if (M2.estado == 0 && TP7.envia_peca_maq == 1) {
				M2.estado = 1;
			}
			if (M2.estado == 1 && M2.presenca() == 1) {
				M2.estado = 2;
			}
			if (M2.estado == 2 /*&& passou tempo de operação*/) {
				M2.estado = 3;
			}
			if (M2.estado == 3 && TP7.presenca() == 0) {
				M2.estado = 4;
			}
			if (M2.estado == 4 && TP7.orientacao == 1) {
				M2.estado = 5;
			}
			if (M2.estado == 5 && TP7.presenca() == 1) {
				M2.estado = 0;
			}
			//TRANSIÇÕES MÁQUINA 3
			if (M3.estado == 0 && TP7.envia_peca_maq == 2) {
				M3.estado = 1;
			}
			if (M3.estado == 1 && M3.presenca() == 1) {
				M3.estado = 2;
			}
			if (M3.estado == 2 /*&& passou tempo de operação*/) {
				M3.estado = 3;
			}
			if (M3.estado == 3 && TP7.presenca() == 0) {
				M3.estado = 4;
			}
			if (M3.estado == 4 && TP7.orientacao == 1) {
				M3.estado = 5;
			}
			if (M3.estado == 5 && TP7.presenca() == 1) {
				M3.estado = 0;
			}
			//TRANSIÇÕES MÁQUINA 4
			if (M4.estado == 0 && TP8.envia_peca_maq == 1) {
				M4.estado = 1;
			}
			if (M4.estado == 1 && M4.presenca() == 1) {
				M4.estado = 2;
			}
			if (M4.estado == 2 /*&& passou tempo de operação*/) {
				M4.estado = 3;
			}
			if (M4.estado == 3 && TP8.presenca() == 0) {
				M4.estado = 4;
			}
			if (M4.estado == 4 && TP8.orientacao == 1) {
				M4.estado = 5;
			}
			if (M4.estado == 5 && TP8.presenca() == 1) {
				M4.estado = 0;
			}
			//TRANSIÇÕES MÁQUINA 5
			if (M5.estado == 0 && TP8.envia_peca_maq == 2) {
				M5.estado = 1;
			}
			if (M5.estado == 1 && M5.presenca() == 1) {
				M5.estado = 2;
			}
			if (M5.estado == 2 /*and passou tempo de operação*/) {
				M5.estado = 3;
			}
			if (M5.estado == 3 && TP8.presenca() == 0) {
				M5.estado = 4;
			}
			if (M5.estado == 4 && TP8.orientacao == 1) {
				M5.estado = 5;
			}
			if (M5.estado == 5 && TP8.presenca() == 1) {
				M5.estado = 0;
			}
			//TRANSIÇÕES MÁQUINA 6
			if (M6.estado == 0 && TP9.envia_peca_maq == 1) {
				M6.estado = 1;
			}
			if (M6.estado == 1 && M6.presenca() == 1) {
				M6.estado = 2;
			}
			if (M6.estado == 2 /*&& passou tempo de operação*/) {
				M6.estado = 3;
			}
			if (M6.estado == 3 && TP9.presenca() == 0) {
				M6.estado = 4;
			}
			if (M6.estado == 4 && TP9.orientacao == 1) {
				M6.estado = 5;
			}
			if (M6.estado == 5 && TP9.presenca() == 1) {
				M6.estado = 0;
			}

			//*******************ATUALIZAR OUTPUTS************************

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

		}
		
		
	}
	
}
