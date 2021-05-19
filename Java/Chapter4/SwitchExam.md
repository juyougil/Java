## switch-case문 사용
package kr.java.chapter4;

public class SwitchExam {

	public static void main(String[] args) {
		int ranking = 1;
		char medalColor;
		
		switch(ranking) {
			case 1 : medalColor = 'G';
			break;
			case 2 : medalColor = 'S';
			break;
			case 3 : medalColor = 'B';
			break;
			default:
				medalColor = 'A';
		}
		System.out.println(ranking +"등 메달의 색깔은 "+ medalColor + " 입니다.");
		
	}

}

## switch-case문 사용(문자열)

package kr.java.chapter4;

public class SwitchExam3 {

	public static void main(String[] args) {
		String medal = "Gold";
		
		
		
		switch(medal) {
		case "Gold":
			System.out.println("금메달입니다.");
			break;
		case "Silver":
			System.out.println("은메달입니다.");
			break;
		case "Bronze":
			System.out.println("동메달입니다.");
			break;
		default:
			System.out.println("메달이 없습니다.");
			break;
		}

	}

}


## if-esle 로 표현

package kr.java.chapter4;

public class SwitchExam2 {

	public static void main(String[] args) {
		int ranking =1;
		char medalColor;
		
		if(ranking == 1) {
			medalColor = 'G';
		}else if( ranking == 2) {
			medalColor ='S';
		}else if (ranking == 3) {
			medalColor ='B';
		}else {
			medalColor = 'A';
		}
		System.out.println(ranking + "등 메달의 색깔은 " + medalColor+" 입니다.");
	}

}

