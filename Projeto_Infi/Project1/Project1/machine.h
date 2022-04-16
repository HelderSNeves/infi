#pragma once
#include <iostream>
#include"conveyor_belt.h"
using namespace std;

class machine : public conveyor_belt {
public:
	int type;
	int tool;
	bool working;
	machine(int id, int tool);
	void work();
	void change_tool();
};