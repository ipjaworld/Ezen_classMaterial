package days05;

import java.util.Scanner;

public class ControlOp_IF06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String level;   // 직급을 저장할 변수
		int pay;   // 판매실적금액 변수
		
		// 직급을 입력 받습니다
		System.out.printf("직급 입력(과장/대리/사원) : ");
		level = sc.nextLine();
		
		// 판매실적을 입력 받습니다
		System.out.printf("판매실적금액 입력 : ");
		pay = sc.nextInt();
		
		double r, total=0.0;   // r : 활동비를 계산할 비율저장 변수,  total : 판매실적+활동비  를 저장할 변수
		
		//  판매실적금액에 과장 50%, 대리 25%, 사원 15% 의 활동비를 합산하여 출력해주세요
		
		if( level.equals("과장") ) {
			r = 0.5;
			//total = pay + pay*0.5;
		}else if( level.equals("대리") ) {
			r = 0.25;
			//total = pay + pay*0.25;
		}else {
			r = 0.15;
			//total = pay + pay*0.15;
		}
		
		total = pay + pay*r;
		
		System.out.println("입력한 직원의 활동비 합산금액 : " + total );		
		
	}

}
