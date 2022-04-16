#include"client_order.h"

client_order::client_order(std::string name, int number, int piece_type, int piece_quantity, int due_date, int late_penalty, int early_penalty) {
	this->name = name;
	this->number = number;
	this->piece_type = piece_type;
	this->piece_quantity = piece_quantity;
	this->due_date = due_date;
	this->late_penalty = late_penalty;
	this->early_penalty = early_penalty;
}