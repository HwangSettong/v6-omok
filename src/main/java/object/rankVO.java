package object;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class rankVO {
	private int rank;
	private String userId;
	private String userNickname;
	private double point; // 승률 또는 승 횟수 
}
