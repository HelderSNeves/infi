#include"piece.h"

piece::piece(int type, std::string position, std::vector<int> operations, int order_id, char supplier, int raw, int arrival_date) {
	this->type = type;
	this->position = position;
	this->operations = operations;
	this->supplier = supplier;
	this->order_id = order_id;
	this->raw = raw;
	this->arrival_date = arrival_date;
}