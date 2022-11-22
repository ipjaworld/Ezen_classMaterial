package days09;

import java.util.Scanner;

public class Method10 {

	public static void main(String[] args) {
		
		int ban;
		double n, d;
		Scanner sc = new Scanner(System.in);
		System.out.print("반지름을 입력하세요 ");
		ban = sc.nextInt();
		
		n = calculate1(ban); // 원의 넓이를 구하는 메서드
		d = calculate2(ban); // 원의 둘레를 구하는 메서드
		prn(n, d);	  // 넓이와 둘레를 출력하는 메서드

	}
	
	public static void prn(double n, double d) {
		System.out.printf("입력한 원의 넓이 : %.2f\n", n);
		System.out.printf("입력한 원의 둘레 : %.2f\n", d);	
	}

	public static double calculate2(int ban) {
		return 2*ban*3.14;
	}

	public static double calculate1(int b) {
		//double n = b*b*3.14;
		//return b;
		return b*b*3.14;
	}

}
