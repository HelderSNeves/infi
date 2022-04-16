#pragma once
#include <iostream>
using namespace std;

class client_order {
public:
	std::string name;
	int number;
	int piece_type;
	int piece_quantity;
	int due_date;
	int late_penalty;
	int early_penalty;
	client_order(std::string name, int number, int piece_type, int piece_quantity, int due_date, int late_penalty, int early_penalty);
};
