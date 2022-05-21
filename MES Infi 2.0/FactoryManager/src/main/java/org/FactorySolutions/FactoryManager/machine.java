package org.FactorySolutions.FactoryManager;

import org.FactorySolutions.FactoryManager.WriteNode;

public class machine extends conveyor_belt {
	
	int type;
	int tool;
	boolean working;
	boolean sensorTool, sensorXplus, sensorXminus, sensorZplus, sensorZminus;
	machine(int id, int tool, int type){
		super(id,0,0);
		this.tool = tool;
		this.type = type;
	}
	void work() {
		
	}
	void change_tool() {
		
	}
	void Zplus() {
		WriteNode write = new WriteNode();
		
	}
	void Zminus() {
		
	}
	void Xplus() {
		
	}
	void Xminus() {
		
	}
	void set_sensorTool(boolean sensor) {
		sensorTool = sensor;
	}
	void set_sensorXplus(boolean sensor) {
		sensorXplus = sensor;
	}
	void set_sensorXminus(boolean sensor) {
		sensorXminus = sensor;
	}
	void set_sensorZplus(boolean sensor) {
		sensorZplus = sensor;
	}
	void set_sensorZminus(boolean sensor) {
		sensorZminus = sensor;
	}
}
