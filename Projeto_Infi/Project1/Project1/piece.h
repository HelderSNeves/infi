#pragma once
#include <iostream>
#include "client_order.h"
#include <vector>
using namespace std;

class piece {
public:
	int type;
	std::string position;
	std::vector <int> operations;
	char supplier;
	int raw;
	int order_id;
	int dispatch_date;
	int arrival_date;
	piece(int type, std::string position, std::vector<int> operations, int order_id, char supplier, int raw, int arrival_date);
};