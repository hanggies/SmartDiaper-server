package kr.ac.hanggies.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class State implements Comparable<State>{
	private int needChange;
	private String roomNumber;
	
	@Override
	public int compareTo(State o) {
		
		if(Integer.parseInt(this.roomNumber) > Integer.parseInt(o.roomNumber)) {
			return 1;
		}
		else if(Integer.parseInt(this.roomNumber) < Integer.parseInt(o.roomNumber)) {
			return -1;
		}
		else
			return 0;
	}
}
