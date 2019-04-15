package kr.ac.hanggies.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Patient {
	private String sid;
	private String name;
	private String room;
	private int needChange;
}
