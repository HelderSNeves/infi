#pragma once
#include <iostream>
#include "piece.h"
using namespace std;

class conveyor_belt {
public:
	int id;
	int maq_cima; //tool da maquina a cima do tapete
	int maq_baixo; //tool da maquina a baixo do tapete
	int estado = 0;
	int orientacao = 0; //0 se esta horizontal 1 se esta vertical
	int envia_peca = 0; //informa se o tapete quer enviar uma peça pro segunte
	int envia_peca_maq = 0; //informa se o tapete quer enviar peça para a maquina de cima(1) ou de baixo(2)
	conveyor_belt(int id, int maq_baixo, int maq_cima);
	void move_left();
	void move_right();
	void rotate_clock();
	void rotate_anticlock();
	int P();

};
