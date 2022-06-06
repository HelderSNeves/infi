
public class Counting_Time_mes extends Thread{
	private long current_time;
	private int day_flag;
	private long start_time;
	
	public Counting_Time_mes(long current_time, int day_flag, long start_time) {
		this.current_time = current_time;
		this.day_flag = day_flag;
	}
	public int get_day_flag() {
		return this.day_flag;
	}
	public void set_day_flag(int day_flag) {
		this.day_flag = day_flag;
	}
	public int get_current_time_seconds() {
		return (int) ((this.current_time-this.start_time)/1000000000);
	}
	
	public void run() {
		int i = 1;
		day_flag = 0;
		start_time = System.nanoTime();
		long second = 1000000000;
		while(true) {
			current_time = System.nanoTime();
			if((current_time-start_time) >= ((60*i) * second)) {
				day_flag++;
				i++;
			}
		}
	}
}
