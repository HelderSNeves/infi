package org.FactorySolutions.FactoryManager;

public class piece {
	int id;
	int type;
	int position;
	int[] operations = new int[3];
	char supplier;
	int raw;
	int order_id;
	int dispatch_date;
	int arrival_date;
	piece(int type, int position, int[] operations, int order_id, char supplier, int raw, int arrival_date){
		this.type = type;
		this.position = position;
		for(int i=0; i<3; i++) {
			this.operations[i]=operations[i];
		}
		this.order_id=order_id;
		this.supplier = supplier;
		this.raw = raw;
		this.arrival_date = arrival_date;
	}
	piece(){
	}
}
