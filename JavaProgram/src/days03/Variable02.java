package days03;

import java.util.Scanner;   
// import 단축키 : Ctrl + Shift  + 'o'
// 단축키를 사용하면 아래 코드들에서 API가 import되지 않아서 빨간 밑즐이 나온 모든 사항들에 대해 import를 실행해줍니다

public class Variable02 {

	public static void main(String[] args) {
		
		int number1, number2;
		int result1;  // 덧셈, 뺄셈, 곱셈의 결과를 저장할 변수
		double result2;  //나눗셈의 결과를 저장할 변수
		
		// 프로그래밍을 하다보면, 외부에서 기능을 불러다 사용해야하는 
		// 경우가 있는데, 사용자로부터 화면 입력을 받으려면 외부에서 화면 입력을 받는 도구(명령)를 
		// 불러와서 사용하게 됩니다.
		// 사실 System.out.println 과 printf 도 불러와서 사용되는 외부 명령이며, 
		// 이는 따로 설정하지 않아도 자바 프로그래밍 시작과 동시에 자동으로 불러져오는 도구라고 보시면 됩니다. (java.lang)
		Scanner sc = new Scanner(System.in);   // 화면입력을 위한 준비코드
		// 아직 학습하지 않은 자료형의 특별한 변수를 생성합니다.
		
		// 그리고 그 변수를 이용해서 사용자로부터 화면으로 입력을 받습니다
		System.out.printf("첫번째 정수를 입력하세요  : ");
		number1 = sc.nextInt(); 
		// 컴파일러가 sc.nextInt() 라는 명령을 만나면 프로그램 실행을 멈추고 사용자의 입력을 무한정 기다립니다.
		// 화면으로 사용자가 정수를 입력하면,  입력 받아 number1 변수에 저장
		System.out.println("입력한 정수는 " + number1 + "입니다");
		
		System.out.printf("두번째 정수를 입력하세요 : ");
		number2 = sc.nextInt();
		System.out.println("입력한 정수는 " + number2 + "입니다");
		
		result1 = number1 + number2;   // 덧셈의 결과 저장
		System.out.printf("%d + %d = %d\n",number1, number2, result1);
		result1 = number1 - number2;  // 뺄셈의 결과 저장
		System.out.printf("%d - %d = %d\n",number1, number2, result1);
		result1 = number1 * number2; // 곱셈의 결과 저장
		System.out.printf("%d x %d = %d\n",number1, number2, result1);
		result2 = number1 / (double)number2; // 나눗셈의 결과 저장
		System.out.printf("%d ÷ %d = %.1f\n",number1, number2, result2);
		
	}
}
