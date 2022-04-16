#include"machine.h"

machine::machine(int id, int tool) : conveyor_belt(id, 0, 0) {
	this->tool = tool;
}

void machine::work() {

}

void machine::change_tool() {

}