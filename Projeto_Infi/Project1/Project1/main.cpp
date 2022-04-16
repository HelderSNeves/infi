#include"main.h"
#define ON 1
#define OFF 0

int main() {
	//CRIAR TAPETES
	conveyor_belt TP5(5, 0 ,0), TP6(6, 1, 0), TP7(7, 1, 2), TP8(8, 3, 3), TP9(9, 4, 0), TP10(10, 0, 0), TP11(11, 0, 0), TP12(12, 0, 0), TP13(13, 0, 0), TP14(14, 0, 0), TP15(15, 0, 0), TP16(16, 0, 0);
	//CRIAR MAQUINAS
	machine M1(1, 1), M2(2, 1), M3(3, 2), M4(4, 3), M5(5, 3), M6(6, 4);
	//RODAR TAPETE 15 PARA POSIÇÃO HORIZONTAL (MAQUINA DE ESTADOS ASSUME ESTA ORIENTAÇÃO COMO DEFAULT)
	while (TP15.orientacao != 0) 
		TP15.rotate_anticlock();
	//CRIAR VETOR DAS PEÇAS QUE SE ENCONTRAM A CIRCULAR NOS TAPETES
	std::vector<piece> pecas;

	while (1) {

		//*******************DISPARAR TRANSIÇÕES************************

		//TRANSIÇÕES TAPETE 5
		if (TP5.estado == 0 /*and armazem envia peça */) {
			TP5.estado == 1;
		}
		if (TP5.estado == 1 and TP6.P() == 0) {
			TP5.estado == 2;
		}
		if (TP5.estado == 2 and TP6.P() == 1) {
			TP5.estado == 0;
		}
		//TRANSIÇÕES TAPETE 6
		if (TP6.estado == 0 and TP5.envia_peca == 1) {
			TP6.estado = 1;
		}
		if (TP6.estado == 1 and TP6.P() == 1) {
			TP6.estado = 2;
		}
		if (TP6.estado == 2 /*and proxima operacao peça que esta no TP6 == TP6.maq_cima and M1.P()==0*/) {
			TP6.estado = 3;
		}
		if (TP6.estado == 3 and M1.P() == 0) {
			TP6.estado = 4;
		}
		if (TP6.estado == 4 and TP6.orientacao == 1) {
			TP6.estado = 5;
		}
		if (TP6.estado == 5 and M1.P() == 1) {
			TP6.estado = 6;
		}
		if (TP6.estado == 6 and TP6.orientacao == 0) {
			TP6.estado = 0;
		}
		if (TP6.estado == 2 /*and proxima operacao peça que esta no TP6 != TP6.maq_cima ou M1.P()==1*/) {
			TP6.estado = 7;
		}
		if (TP6.estado == 7 and TP7.P() == 0) {
			TP6.estado = 8;
		}
		if (TP6.estado == 8 and TP7.P() == 1) {
			TP6.estado = 0;
		}
		if (TP6.estado == 0 and TP16.envia_peca == 1) {
			TP6.estado = 9;
		}
		if (TP6.estado == 9 and TP6.orientacao == 1) {
			TP6.estado = 10;
		}
		if (TP6.estado == 10 and TP6.P() == 1) {
			TP6.estado = 11;
		}
		if (TP6.estado == 11 and TP6.orientacao == 0) {
			TP6.estado = 2;
		}
		if (TP6.estado == 0 and M1.envia_peca == 1) { //Maquina de cima envia peça
			TP6.estado = 12;
		}
		if (TP6.estado == 12 and TP6.orientacao == 1) {
			TP6.estado = 13;
		}
		if (TP6.estado == 13 and TP6.P() == 1) {
			TP6.estado = 14;
		}
		if (TP6.estado == 14 and TP6.orientacao == 0) {
			TP6.estado = 7;
		}
		//TRANSIÇÕES TAPETE 7
		if (TP7.estado == 0 and TP6.envia_peca == 1) {
			TP7.estado = 1;
		}
		if (TP7.estado == 1 and TP7.P() == 1) {
			TP7.estado = 2;
		}
		if (TP7.estado == 2 /*and realiza operacao TP7.maq_cima*/) {
			TP7.estado = 3;
		}
		if (TP7.estado == 3 and M2.P() == 0) {
			TP7.estado = 4;
		}
		if (TP7.estado == 4 and TP7.orientacao == 1) {
			TP7.estado = 5;
		}
		if (TP7.estado == 5 and M2.P() == 1) {
			TP7.estado = 6;
		}
		if (TP7.estado == 6 and TP7.orientacao == 0) {
			TP7.estado = 0;
		}
		if (TP7.estado == 2 /*and realiza operacao TP7.maq_baixo*/) {
			TP7.estado = 7;
		}
		if (TP7.estado == 7 and M3.P() == 0) {
			TP7.estado = 8;
		}
		if (TP7.estado == 8 and TP7.orientacao == 1) {
			TP7.estado = 9;
		}
		if (TP7.estado == 9 and M3.P() == 1) {
			TP7.estado = 10;
		}
		if (TP7.estado == 10 and TP7.orientacao == 0) {
			TP7.estado = 0;
		}
		if (TP7.estado == 3 and M2.P() == 1) {
			TP7.estado = 11;
		}
		if (TP7.estado == 7 and M3.P() == 1) {
			TP7.estado = 11;
		}
		if (TP7.estado == 2 /*and nao realiza operaçao TP7.maq_cima nem TP7.maq_baixo*/) {
			TP7.estado = 11;
		}
		if (TP7.estado == 11 and TP8.P() == 0) {
			TP7.estado = 12;
		}
		if (TP7.estado == 12 and TP8.P() == 1){
			TP7.estado = 0;
		}
		if (TP7.estado == 0 and M2.envia_peca == 1) { //Maquina de cima envia peça
			TP7.estado = 13;
		}
		if (TP7.estado == 13 and TP7.orientacao == 1) {
			TP7.estado = 14;
		}
		if (TP7.estado == 14 and TP7.P() == 1) {
			TP7.estado = 15;
		}
		if (TP7.estado == 15 and TP7.orientacao == 0) {
			TP7.estado = 11;
		}
		if (TP7.estado == 0 and M3.envia_peca == 1) { //Maquina de baixo envia peça
			TP7.estado = 16;
		}
		if (TP7.estado == 16 and TP7.orientacao == 1) {
			TP7.estado = 17;
		}
		if (TP7.estado == 17 and TP7.P() == 1) {
			TP7.estado = 18;
		}
		if (TP7.estado == 18 and TP7.orientacao == 0) {
			TP7.estado = 11;
		}
		//TRANSIÇÕES TAPETE 8
		if (TP8.estado == 0 and TP7.envia_peca == 1) {
			TP8.estado = 1;
		}
		if (TP8.estado == 1 and TP8.P() == 1) {
			TP8.estado = 2;
		}
		if (TP8.estado == 2 /*and realiza operacao TP8.maq_cima*/) {
			TP8.estado = 3;
		}
		if (TP8.estado == 3 and M4.P() == 0) {
			TP8.estado = 4;
		}
		if (TP8.estado == 4 and TP8.orientacao == 1) {
			TP8.estado = 5;
		}
		if (TP8.estado == 5 and M4.P() == 1) {
			TP8.estado = 6;
		}
		if (TP8.estado == 6 and TP8.orientacao == 0) {
			TP8.estado = 0;
		}
		if (TP8.estado == 2 /*and realiza operacao TP8.maq_baixo*/) {
			TP8.estado = 7;
		}
		if (TP8.estado == 7 and M5.P() == 0) {
			TP8.estado = 8;
		}
		if (TP8.estado == 8 and TP8.orientacao == 1) {
			TP8.estado = 9;
		}
		if (TP8.estado == 9 and M5.P() == 1) {
			TP8.estado = 10;
		}
		if (TP8.estado == 10 and TP8.orientacao == 0) {
			TP8.estado = 0;
		}
		if (TP8.estado == 3 and M4.P() == 1) {
			TP8.estado = 11;
		}
		if (TP8.estado == 7 and M4.P() == 1) {
			TP8.estado = 11;
		}
		if (TP8.estado == 2 /*and nao realiza operaçao TP8.maq_cima nem TP8.maq_baixo*/) {
			TP8.estado = 11;
		}
		if (TP8.estado == 11 and TP8.P() == 0) {
			TP8.estado = 12;
		}
		if (TP8.estado == 12 and TP9.P() == 1) {
			TP8.estado = 0;
		}
		if (TP8.estado == 0 and M4.envia_peca == 1) { //Maquina de cima envia peça
			TP8.estado = 13;
		}
		if (TP8.estado == 13 and TP8.orientacao == 1) {
			TP8.estado = 14;
		}
		if (TP8.estado == 14 and TP8.P() == 1) {
			TP8.estado = 15;
		}
		if (TP8.estado == 15 and TP8.orientacao == 0) {
			TP8.estado = 11;
		}
		if (TP8.estado == 0 and M5.envia_peca == 1) { //Maquina de baixo envia peça
			TP8.estado = 16;
		}
		if (TP8.estado == 16 and TP8.orientacao == 1) {
			TP8.estado = 17;
		}
		if (TP8.estado == 17 and TP8.P() == 1) {
			TP8.estado = 18;
		}
		if (TP8.estado == 18 and TP8.orientacao == 0) {
			TP8.estado = 11;
		}
		//TRANSIÇÕES TAPETE 9
		if (TP9.estado == 0 and TP8.envia_peca == 1) {
			TP9.estado = 1;
		}
		if (TP9.estado == 1 and TP9.P() == 1) {
			TP9.estado = 2;
		}
		if (TP9.estado == 2 /*and realiza operação TP9.maq_cima*/) {
			TP9.estado = 3;
		}
		if (TP9.estado == 3 and M6.P() == 0) {
			TP9.estado = 5;
		}
		if (TP9.estado == 5 and TP9.orientacao == 1) {
			TP9.estado = 6;
		}
		if (TP9.estado == 6 and M6.P() == 1) {
			TP9.estado = 7;
		}
		if (TP9.estado == 7 and TP7.orientacao == 0) {
			TP9.estado = 0;
		}
		if (TP9.estado == 2 /*and nao realiza operação TP9.maq_cima ou M6.P()==1*/) {
			TP9.estado == 8;
		}
		if (TP9.estado == 8 /*and acabou operações*/) {
			TP9.estado = 9;
		}
		if (TP9.estado == 9 and TP10.P() == 0) {
			TP9.estado = 10;
		}
		if (TP9.estado == 10 and TP10.P() == 1) {
			TP9.estado = 0;
		}
		if (TP9.estado == 8 /*and nao acabou operações*/) {
			TP9.estado = 11;
		}
		if (TP9.estado == 11 and TP11.P() == 0) {
			TP9.estado = 12;
		}
		if (TP9.estado == 12 and TP9.orientacao == 1) {
			TP9.estado = 13;
		}
		if (TP9.estado == 13 and TP11.P() == 1) {
			TP9.estado = 14;
		}
		if (TP9.estado == 14 and TP9.orientacao == 0) {
			TP9.estado = 0;
		}
		if (TP9.estado == 0 and M6.envia_peca == 1) { //Maquina de cima envia peça
			TP9.estado = 15;
		}
		if (TP9.estado == 15 and TP9.orientacao == 1) {
			TP9.estado = 16;
		}
		if (TP9.estado == 16 and TP9.P() == 1) {
			TP9.estado = 17;
		}
		if (TP9.estado == 17 and TP9.orientacao == 0) {
			TP9.estado = 8;
		}
		//TRANSIÇÕES TAPETE 10
		if (TP10.estado == 0 and TP9.envia_peca == 1) {
			TP10.estado = 1;
		}
		if (TP10.estado == 1 /*and armazem não esta cheio*/) {
			TP10.estado = 2;
		}
		if (TP10.estado == 2 /*and peça entrou armazem*/) {
			TP10.estado = 0;
		}
		//TRANSIÇÕES TAPETE 11
		if (TP11.estado == 0 and TP9.envia_peca == 1) {
			TP11.estado = 1;
		}
		if (TP11.estado == 1 and TP11.P() == 1) {
			TP11.estado = 2;
		}
		if (TP11.estado == 2 and TP12.P() == 0) {
			TP11.estado = 3;
		}
		if (TP11.estado == 3 and TP12.P() == 1) {
			TP11.estado = 0;
		}
		//TRANSIÇÕES TAPETE 12
		if (TP12.estado == 0 and TP11.envia_peca == 1) {
			TP12.estado = 1;
		}
		if (TP12.estado == 1 and TP12.P() == 1) {
			TP12.estado = 2;
		}
		if (TP12.estado == 2 and TP13.P() == 0) {
			TP12.estado = 3;
		}
		if (TP12.estado == 3 and TP12.orientacao == 0) {
			TP12.estado = 4;
		}
		if (TP12.estado == 4 and TP13.P() == 1) {
			TP12.estado = 5;
		}
		if (TP12.estado == 15 and TP12.orientacao == 1) {
			TP12.estado = 0;
		}
		//TRANSIÇÕES TAPETE 13
		if (TP13.estado == 0 and TP12.envia_peca == 1) {
			TP13.estado == 1;
		}
		if (TP13.estado == 1 and TP13.P() == 1) {
			TP13.estado = 2;
		}
		if (TP13.estado == 2 and TP14.P() == 0) {
			TP13.estado = 3;
		}
		if (TP13.estado == 3 and TP14.P() == 1) {
			TP13.estado = 0;
		}
		//TRANSIÇÕES TAPETE 14
		if (TP14.estado == 0 and TP13.envia_peca == 1) {
			TP14.estado == 1;
		}
		if (TP14.estado == 1 and TP14.P() == 1) {
			TP14.estado = 2;
		}
		if (TP14.estado == 2 and TP15.P() == 0) {
			TP14.estado = 3;
		}
		if (TP14.estado == 3 and TP15.P() == 1) {
			TP14.estado = 0;
		}
		//TRANSIÇÕES TAPETE 15
		if (TP15.estado == 0 and TP14.envia_peca == 1) {
			TP15.estado = 1;
		}
		if (TP15.estado == 1 and TP15.P() == 1) {
			TP15.estado = 2;
		}
		if (TP15.estado == 2 and TP16.P() == 0) {
			TP15.estado = 3;
		}
		if (TP15.estado == 3 and TP15.orientacao == 1) {
			TP15.estado = 4;
		}
		if (TP15.estado == 4 and TP16.P() == 1) {
			TP15.estado = 5;
		}
		if (TP15.estado == 5 and TP15.orientacao == 0) {
			TP15.estado = 0;
		}
		//TRANSIÇÕES TAPETE 16
		if (TP16.estado == 0 and TP15.envia_peca == 1) {
			TP16.estado = 1;
		}
		if (TP16.estado == 1 and TP16.P() == 1) {
			TP16.estado = 2;
		}
		if (TP16.estado == 2 and TP6.P() == 0) {
			TP16.estado = 3;
		}
		if (TP16.estado == 3 and TP6.orientacao == 1) {
			TP16.estado = 4;
		}
		if (TP16.estado == 4 and TP6.P() == 1) {
			TP16.estado = 0;
		}
		//TRANSIÇÕES MÁQUINA 1
		if (M1.estado == 0 and TP6.envia_peca_maq == 1) {
			M1.estado = 1;
		}
		if (M1.estado == 1 and M1.P() == 1) {
			M1.estado = 2;
		}
		if (M1.estado == 2 /*and passou tempo de operação*/) {
			M1.estado = 3;
		}
		if (M1.estado == 3 and TP6.P() == 0) {
			M1.estado = 4;
		}
		if (M1.estado == 4 and TP6.orientacao == 1) {
			M1.estado = 5;
		}
		if (M1.estado == 5 and TP6.P() == 1) {
			M1.estado = 0;
		}
		//TRANSIÇÕES MÁQUINA 2
		if (M2.estado == 0 and TP7.envia_peca_maq == 1) {
			M2.estado = 1;
		}
		if (M2.estado == 1 and M2.P() == 1) {
			M2.estado = 2;
		}
		if (M2.estado == 2 /*and passou tempo de operação*/) {
			M2.estado = 3;
		}
		if (M2.estado == 3 and TP7.P() == 0) {
			M2.estado = 4;
		}
		if (M2.estado == 4 and TP7.orientacao == 1) {
			M2.estado = 5;
		}
		if (M2.estado == 5 and TP7.P() == 1) {
			M2.estado = 0;
		}
		//TRANSIÇÕES MÁQUINA 3
		if (M3.estado == 0 and TP7.envia_peca_maq == 2) {
			M3.estado = 1;
		}
		if (M3.estado == 1 and M3.P() == 1) {
			M3.estado = 2;
		}
		if (M3.estado == 2 /*and passou tempo de operação*/) {
			M3.estado = 3;
		}
		if (M3.estado == 3 and TP7.P() == 0) {
			M3.estado = 4;
		}
		if (M3.estado == 4 and TP7.orientacao == 1) {
			M3.estado = 5;
		}
		if (M3.estado == 5 and TP7.P() == 1) {
			M3.estado = 0;
		}
		//TRANSIÇÕES MÁQUINA 4
		if (M4.estado == 0 and TP8.envia_peca_maq == 1) {
			M4.estado = 1;
		}
		if (M4.estado == 1 and M4.P() == 1) {
			M4.estado = 2;
		}
		if (M4.estado == 2 /*and passou tempo de operação*/) {
			M4.estado = 3;
		}
		if (M4.estado == 3 and TP8.P() == 0) {
			M4.estado = 4;
		}
		if (M4.estado == 4 and TP8.orientacao == 1) {
			M4.estado = 5;
		}
		if (M4.estado == 5 and TP8.P() == 1) {
			M4.estado = 0;
		}
		//TRANSIÇÕES MÁQUINA 5
		if (M5.estado == 0 and TP8.envia_peca_maq == 2) {
			M5.estado = 1;
		}
		if (M5.estado == 1 and M5.P() == 1) {
			M5.estado = 2;
		}
		if (M5.estado == 2 /*and passou tempo de operação*/) {
			M5.estado = 3;
		}
		if (M5.estado == 3 and TP8.P() == 0) {
			M5.estado = 4;
		}
		if (M5.estado == 4 and TP8.orientacao == 1) {
			M5.estado = 5;
		}
		if (M5.estado == 5 and TP8.P() == 1) {
			M5.estado = 0;
		}
		//TRANSIÇÕES MÁQUINA 6
		if (M6.estado == 0 and TP9.envia_peca_maq == 1) {
			M6.estado = 1;
		}
		if (M6.estado == 1 and M6.P() == 1) {
			M6.estado = 2;
		}
		if (M6.estado == 2 /*and passou tempo de operação*/) {
			M6.estado = 3;
		}
		if (M6.estado == 3 and TP9.P() == 0) {
			M6.estado = 4;
		}
		if (M6.estado == 4 and TP9.orientacao == 1) {
			M6.estado = 5;
		}
		if (M6.estado == 5 and TP9.P() == 1) {
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