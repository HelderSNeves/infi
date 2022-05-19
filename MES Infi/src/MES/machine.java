package MES;

public class machine extends conveyor_belt {
	
	int type;
	int tool;
	boolean working;
	machine(int id, int tool, int type){
		super(id,0,0);
		this.tool = tool;
		this.type = type;
	}
	void work() {
		
	}
	void change_tool() {
		
	}
}
