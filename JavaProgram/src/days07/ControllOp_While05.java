package days07;

import java.util.Random;

public class ControllOp_While05 {

	public static void main(String[] args) {
		
		// 랜덤한 숫자 발생 = 난수 발생 
		// 첫번째 방법 Math.random()
		
		double r = Math.random();
		System.out.println("최초 발생된 난수(Math.random()) : " + r);
		
		r = r * 100;
		System.out.println("Math.random() 난수 가공 #1 : " + r);
		
		int a = (int)r;
		System.out.println("Math.random() 난수 가공 #2 : " + a);
		
		// Math.random() 결과에 100을 곱하면 소수점 아래 두자리가 소수점 위로 올라오면서 필요한 정수를 얻을 수 있는
		// 동작의 첫번째 단계실행이 됩니다.
		// 만약 0~49(50미만)의 난수를 얻고 싶다면 Math.random() 에다가 50을 곱하면 필요한 숫자를 얻을수 있습니다
		// 모든 경우의 최종 연산은 (int) 캐스팅 연산으로 소수점 아래를 버리는 동작으로 마무리 합니다
		
		
		// Math.random과 반복문을 이용해서 0~65 사이의 10개의 난수를 발생하여 출력해주세요
		int i=1;
		while( i<=10) {
			a = (int)(Math.random()*66);
			System.out.printf("%d ", a);
			i++;
		}
		
		System.out.println();
		// 두번째 방법.  Random 클래스 사용
		// Scanner 와 같은 자료형이라고 보시면 되고 사용법도 비슷합니다
		Random rd = new Random();
		a = rd.nextInt();
		System.out.println("Random 클래스를 이용한 난수 : " + a);
		if( a < 0 ) a = a * (-1);
		a = a % 65;
		System.out.println("Random 클래스를 이용한 난수 가공 후 : " + a);
		
		
		// Random 클래스와  반복문을 이용해서 0~65 사이의 10개의 난수를 발생하여 출력해주세요
		i=1;
		while( i<=10) {
			a = rd.nextInt();
			if( a < 0 ) a = a * (-1);  // 음수를 양수로
			a = a % 65;  // 원하는 범위내 숫자를 얻기위해  % 연산을 이용
			System.out.printf("%d ", a);
			i++;
		}
	}
}



