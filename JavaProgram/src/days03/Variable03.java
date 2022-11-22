package days03;

import java.util.Scanner;

public class Variable03 {

	public static void main(String[] args) {
		// 삼각형의 밑변과 높이를 입력받아서   넓이를 출력
		// 삼각형의 넓이 : 밑변 x 높이 x 0.5
		
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("삼각형의 높이를 입력하세요 : ");
		int number1 = sc.nextInt();
		// int number1;
		// number1 = sc.nextInt();
		
		System.out.printf("사각형의 밑변을 입력하세요 : ");
		int number2 = sc.nextInt();
		
		double result = number1 * number2 * 0.5;
		
		System.out.printf("입력한 삼각형의 넓이는 %.1f 입니다 \n", result);

	}

}
