package days04;

public class Operator04 {

	public static void main(String[] args) {
		
		// 캐스팅 연산 & 자료의 형변환
		
		byte b1 = 100;
		// 정수 데이터에 별도의 표시(100L) 없다면 그 데이터는 int 형 데이터입니다
		// 위 명령의 byte 변수에 int 형 자료를 대입하는 동작은 원래는 에러를 발생하고 캐스팅 연산이 필요하지만
		// 정수에 한해서만 생략 가능합니다
		// byte b1 = (byte)100; 원래는 이와 같이 써야 맞습니다.
		// 생략이 가능한건 단순정수데이터를 정수형(byte, short)변수에 대입하는 동작까지만 가능합니다.
		byte b2 = 120;
		
		//byte b3 = b1 + b2;  // 에러
		// 정수(int, byte, short) 들의 산술연산의 결과는 모두 int 이기 때문에 위의 연산은 에러입니다
		byte b3 = (byte)(b1 + b2);  
		System.out.println(b3);
		// 127  128   129    130    131
		// 127  -128  -127  -126  -125
		
		
		
		// double -> int
		double d1 = 1.123456;
		int a = (int)d1;    // a 변수에  1이 저장
		// int -> double
		double d2 = (double) a;    // d2 변수에   1.0 이 저장
		// double d2 = a; // 데이터 손실이 일어나지 않는 형변환은 캐스팅 연산이 생략 가능합니다
		
		
		// char -> int
		char c = 'A';
		a = (int)c;  // 문자 'A' 에 해당하는 아스키코드 65 가 저장
		// int -> char 
		a = 97;
		c = (char)a;  // 97  아스키코드에 해당하는 'a' 글자 저장
		
		
		// long -> int
		long a2 = 10000000000L;  
		// -21억~21억 사이의 값은 L 을 생략가능합니다
		int a3 = (int)a2;
		System.out.println(a3);
		
		// double -> float
		double f1 = 123.123;
		float f2 = (float)f1;
		
		
		
		// String -> int   아라비아기호로만 구성된 String 을 int 형으로 변환
		String s1 = "1234";
		
		// 잘못된 예
		// int a4 = (int)s1;   // 에러
		// String 변수가 사용될때  저장된 문자들이 사용되는 때는  다른 자료와 연산할때이지만,
		// 지금처럼 혼자 연산될때는 문자들이 저장된 위치 정보가 사용됩니다. 따라서 위 내용은 에러입니다
		
		// 반대의 경우도 에러입니다
		//잘못된 예  (int->String)
		int a5 = 123456;
		// String str2= (String)a5;   // 에러
		
		
		// 호환이 되지 않는 자료들간의 형변환은 별도의 도구(메서드)가 필요합니다
		String s2 = "123456";
		int a6 = Integer.parseInt(s2); //String -> int
		
		int a7 = 123456;
		String s3 = String.valueOf(a7);  // int -> String
		
		
		// double -> String
		double d3 = 123.1234;
		// String s3 = (String)d3;  // 에러
		String s4 = String.valueOf(d3); // 정상실행
		
		// String -> double
		String s5 = "123.1234";
		// double d4 = (double)s4;   // 에러
		double d4 = Double.parseDouble(s5);  // 정상실행
		
		
		
		// String -> char
		String s6 = "ABCDEFG";
		// char ch1 = (char)s6; // 에러
		char ch1 = s6.charAt(1);  // 정상실행   0:첫글자   1:두번째글자  2:세번째글자 ....
		
		
		// char -> String
		char c6 = 'A';
		// String s7 = (String)c6;  // 에러
		String s7 = String .valueOf(c6);
		
		
	}

}







