package days05;

import java.util.Scanner;

public class ControlOp_For05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, a, b;
		System.out.printf("첫번째 정수 입력 : ");
		a = sc.nextInt();
		System.out.printf("두번째 정수 입력 : ");
		b = sc.nextInt();
		
		// 입력받은 숫자 중 작은 숫자부터 큰숫자까지 모든 정수를 출력하세요
		// 8과 3을 입력했다면  3 4 5 6 7 8

		if(a<b) {
		
			for( i=a ; i<=b ; i++  )
				System.out.printf("%d ", i);
		
		}else {
		
			for( i=b ; i<=a ; i++  )
				System.out.printf("%d ", i);
		
		}
	}

}
