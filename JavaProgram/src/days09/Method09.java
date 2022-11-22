package days09;

import java.util.Scanner;

//메서드를 사용하는 세번째 목적
//메서드 호출 후 메서드에서 계산된 결과를 호출한 지점에 리턴받아서 사용하고자 할때

//리턴값이 존재하는 메서드를 사용하면 호출된 메서드가 return 명령을 이용하여 호출된 지점으로 
// 결과값하나를 되돌려보내서 활용할 수 있습니다.

public class Method09 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		
		int sq = squar( num );  // 전달인수로 전달된 값의 제곱을 계산하는 메서드
		System.out.printf("%d 의 제곱은 %d 입니다\n", num, sq);
		// squar 메서드가 실행되고, 실행된 결과를 squar 메서드내에서 출력하는게 아니라
		// 결과만 되돌려 받아서 호출된곳에서 결과를 출력합니다
		
		
		int maxValue = max(10, 34, 67);
		System.out.printf("%d %d %d 중 가장 큰숫자는? -> %d\n", 10, 24, 67, maxValue);
		
		max(65,87,12); // 문법적으로 오류는 없지만 열심히 계산하고 결과를 버리는 셈이 됩니다
		// 리턴값이 있는 메서드의 호출시 반드시 리턴값을 받아주는 변수가 있어야하는 것은 아닙니다.
		// 다만 리턴이라는 명령을 쓰는 목적은 실행결과를 되돌려 받아서 쓰려는 목적이므로,
		// 목적에 맞게 사용하는것이 올바른 사용이라고 할수 있습니다
		maxValue = max(65,87,12);
		
		// 또한 메서드실행의 결과(리턴값)는 변수에 저장할수 있을뿐만 아니라 
		// 다음과같이 다른 메서드 또는 연산의 일부로로 사용할수도 있습니다
		System.out.printf("%d %d %d 중 가장 큰숫자는? -> %d\n", 65,87,12,  max(65,87,12)  );
		// 리턴된 값이 System.out.printf()의 출력내용으로 사용됩니다
		int k = 10 + max(65,87,12);
		// 리턴된 값이 10과 덧셈연산이 실행됩니다

	}
	public static int max( int a, int b, int c) {
		int max;
		
		if(a>b) max = a;
		else max = b;
		
		if(c > max) max = c;
		
		return max;
	}
	
	public static int squar( int n ) {
		int k = n * n;
		return k;  // 메서드가 실행된 결과를 도돌려주는 명령 : return
		// 그동안 형식적으로 void 라고 썼던곳에 리턴되는 값의 자료형을 써줍니다
		// 그동안 썼던  void 는  리턴값이 없다는 뜻으로 썼던 키워드입니다.
	}

}












