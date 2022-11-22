package days12;

import java.util.Random;

// static 메서드

// static 변수와 같이 프로그램 구동전에 메모리에 로딩되어서 객체 생성없이 호출될수 있는 클래스의 멤버 메서드입니다.
// static 변수사용과 같이  메서드이름앞에  클래스이름과 (.)으로 연결해서 사용합니다. 객체생성과 상관없이 사용합니다

public class Class22 {

	public static void main(String[] args) {
		
		// java.lang 패키지에 있는 클래스중 static 메서드들의 실제 사용 예
		// 간단한 수학적 계산을 위해 만들어진 Math 클래스의 static 메서드들
		// sqrt, randaom,  abs 등
		// 클래스 내부에 정의된 메서드의 모습은
		// public static int abs(int n){ }

		// abs : 절대값 계산 메서드, 
		// sqrt : 제곱근 계산 메서드, 
		// random : 난수 발생 매서드
		
		// Math 클래스의 random 과 같은 역할을 하지만 방식 다르고, 특히 static 이 아니라 인스턴트 멤버메서드로
		// 난수를 발생하는 클래스도 있습니다
		Random rd = new Random();
		int a = rd.nextInt();
		// static 메서드는 클래스이름을 앞에 두고 호출되고,  인스턴스 메서드는 객체이름을 앞에 두고 호출됩니다
		double d = Math.random();
		
		//abs 의 사용
		int num = -10;
		System.out.printf("num = %d, num 변수의 절대값 = %d\n",num, Math.abs(num));
		//sqrt의 사용
		num = 9;
		System.out.printf("num = %d, num 변수의 제곱근 = %.2f\n",num, Math.sqrt(num));
				
		// random 의 사용
		System.out.println("Math클래스 난수발생 스태틱매서드 값 : "	+  Math.random() );
				
		System.out.println("0~32 난수발생 스태틱매서드 값 가공 : " +  (int)(Math.random()*33) );
		
		// Integer 클래스(int 타입의 자료형과 매칭되는 클래스)
		System.out.println("Integer의 max_value : " + Integer.MAX_VALUE);
		System.out.println("Integer의 min_value : " + Integer.MIN_VALUE);
		// 변수 선언신 static 키워드를 붙일수 있지만 별도로 final 이라는 키워드도 붙일수 있는데
		// 이는 최초에 지정한 값이 끝까지 변경될수 없는 변수로 만든다는 뜻입니다.
		
		// Integer.parseInt  : String 형으로 저장된  아라비아 기호들을 실제 숫자로 변환해 주는  static 메서드
		String strNum1 = "123";
		String strNum2 = "456";
		System.out.println("문자연산 : " + (strNum1 + strNum2) );
		System.out.println("정수변환 후 연산 : " 
				+ ( Integer.parseInt(strNum1) + Integer.parseInt(strNum2) ) );
		
		// Double 클래스 ( double 타입의 자료형과 매치되는 클래스)
		System.out.println("Double의 max_value : " + Double.MAX_VALUE);
		System.out.println("Double의 min_value : " + Double.MIN_VALUE);
		// Double.parseDouble
		strNum1 = "10.75";
		strNum2 = "5.2";
		// 문자열 결합
		System.out.println("문자연산 : " + (strNum1 + strNum2) );
		// 문자열의 값을 실수로 변환한 후 연산
		System.out.println("실수연산 :  " + 
				(Double.parseDouble(strNum1)+ Double.parseDouble(strNum2)) );
		
		// String 클래스(int->String   double->String  boolean->String ... )
		System.out.printf("%s, %s, %s\n", 123, 12.345, true);
		
		// int 또는 double 형 자료를  String 으로 변환 -   valueOf()
		int intNum1 = 456;
		int intNum2 = 789;
		System.out.println("int 산술연산 : " + (intNum1 + intNum2));
		System.out.println("문자변환 후 연산 : " 
					+ (String.valueOf(intNum1) + String.valueOf(intNum2)) );
		
		double doubleNum3 = 456.123;
		double doubleNum4 = 789.123;
		System.out.println("double 산술연산 : " + (doubleNum3 + doubleNum4));
		System.out.println("문자변환 후 연산 : " 
					+ ( String.valueOf(doubleNum3) + String.valueOf(doubleNum4) ) );
		
		boolean b1 = true;
		boolean b2 = false;
		System.out.println("boolean 논리연산 : " + (b1 && b2));
		System.out.println("boolean 문자변환 후 연산 : " 	+ (String.valueOf(b1) + String.valueOf(b2)));		
	}

}










