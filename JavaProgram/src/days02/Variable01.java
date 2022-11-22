package days02;

public class Variable01 {

	public static void main(String[] args) {
		// 35 + 38 = 73
		System.out.println(35 + "+" + 38 + "=" + (35+38) );
		System.out.println(35 + "-" + 38 + "=" + (35-38) );
		System.out.println(35 + "x" + 38 + "=" + (35*38) );
		System.out.println(35 + "÷" + 38 + "=" + (35/38.0) );
		System.out.println(35 + "%" + 38 + "=" + (35%38) );
		
		// 변수(Variable) : 프로그램 실행중 발생 또는 입력되는 데이터를 저장할 목적으로 만든 임시 저장장소
		// 프로그램 실행명령시 생성도고, 프로그램 종료시 소멸됩니다.
		
		//변수의 생성
		int a; //a 라는 이름의 변수를 생성(정수를 저장하기 위한 변수)
		// 변수의 이름을 만드는 규칙
		// 1. 인터넷 사이트의 회원가입시  만드는 아이디 이름 규칙과 비슷합니다
		// 2. 영문과 숫자, 그리고 일부 특수문자(_)를 섞어서 사용가능하지만
		// 3. 첫글자는 반드시 영문으로 사용합니다
		// 4. 중간에 공백이 있을수 없습니다
		// 5. 너무 짧지 않게 약간의 의미를 부여해서 이름 생성하는 편입니다
		// 6. 변수의 이름이 너무 짧으면, 변수의 갯수가 많아졌을때 서로의 용도를 구분하기 어렵습니다
		// 7. 변수의 이름이 너무 길면, 사용할때마다 그 긴 이름을 타이핑해야하는 불편함이 있습니다
		// 8. 두가지 의미의 단어가 조합되어 변수이름이 만들어 진다면 첫단어는 소문자로, 두번째 단어첫글자 대문자로 생성합니다
		// ex) 덧셈의 결과 를 저장할 변수 이름 : plusResult
		// 9. 변수는 자료형(정수, 실수, 문자)에 따라 만드는 명령이 달라집니다
		
		// int : 정수,  double : 실수 , String : 문자 등
		// int a;  // 정수형 변수  a 가 생성
		// double b;   // 실수형 변수  b
		// String c;   // 문자형 변수  c
		int b;  //b 라는 이름의 변수를 생성(정수를 저장하기 위한 변수)
		int plusResult, minusResult, multiplyResult; // 한번에 여러변수를 생성(정수를 저장하기 위한 변수 세개)
		double divideResult;  //divideResult 라는 이름의 변수 생성(실수를 저장할 변수)
		
		// a = 123.12;   // 정수형 변수에 실수자료를 대입하면 소수점 아래 데이터 손실이 일어나기 때문에 에러입니다
		divideResult = 100;   // 실수형 변수에 정수를 저장하는건 데이터손실이 없으므로 정상 실행.
		
		
		a = 25;
		b = 13;
		
		plusResult = a+b;  // 연산에 변수이름 쓰면 변수에 저장된 값이 연산됩니다.
		// 연산의 결과가  = 연산자에 의해 plusResult 변수에 저장됩니다.
		minusResult = a - b;
		multiplyResult = a * b;
		divideResult = a / b;
		
		// System.out.println안에 변수이름이 쓰면, 그변수에 저장된 값이 출력됩니다.
		System.out.println( a + "+" + b + "=" + plusResult );
		// System.out.println( a + "+" + b + "=" + (a+b) );
		System.out.println( a + "-" + b + "=" + minusResult );
		System.out.println( a + "x" + b + "=" + multiplyResult );
		System.out.println( a + "÷" + b + "=" + divideResult );
		
		
		boolean b1;   // 참(true) 또는 거짓(false) 중 하나를 저장하는 자료형(변수)
		b1 = true;  // 또는 false  를 저장할수 있습니다
		System.out.printf("변수 b1 의 값 : %b\n", b1);
		System.out.println("변수 b1 의 값 : " + b1);
		// boolean 자료를 printf 로 출력할때 %b 를 사용합니다
		
		
		//int - 정수형 자료형    4 Byte형 정수  
		//long - 정수형 자료형  8 Byte형 정수
		//float - 실수형 자료형  4 Byte형 실수
		//double - 실수형 자료형  8Byte 형 실수
		//char - 문자(글자) 자료형  '', 'a', 'b'    2Byte형 문자 1자 - String 과 다릅니다
		//String - 문자열 자료형 "", "a", "abc"   0 글자 에서 글자갯수 제한 없이 저장할 수 있는 자료형
		//           String 은 현재는 자료형이라고 부르지만 엄밀히 자료형이라기 보다 클래스(객체)라고 부르는게 정확한표현입니다
		//boolean - 진위형 자료 1Byte형 자료 (true/false만 저장 가능)
		
		// byte - 1바이트형 정수   short - 2바이트형 정수
		byte b2; // -128~127
		// 저장용량의 최소단위 : 1bit ( 0 또는 1(이진수) 중 하나를 저장 )
		// 2bit -> 00 01 10 11(4개중 하나 저장)
		// 3bit -> 000 001 010 011 100 101 110 111  (8개중에 하나) 
		// 3bit는 십진수로 쳤을때 0~7까지 저장가능
		// 4 - 16   5-32   6-64   7-128   8-256
		// 8bit(=1Byte)  00000000~11111111 (256개중 하나를 저장가능) 0~255
		
		// 9-512  10-1024   11-2048   12-4096   13-8192   14-16384   15-32768   16-65536
		// 16bit(=2BYTE)  0000000000000000~1111111111111111
		// 65536개중 하나를 저장   0~65535(십진수)     -32768~32767(정수)
		// 우리가 주로 사용할 int (4 바이트)  : -2147483648 ~ 2147483647
		
		// 예전 시스템의 int - 2byte  (-32768 ~ 32767 )
		// 현재 시스템의 int - 4byte  (-2147483648 ~ 2147483647 )
		
		// double - 8byte   0.00002  => 0.2 x 10의 -4승     : 변수에 저장되는 값 ->  2 와  -4
		// 10의 약 -308승  ~  308승 
		
		
		char c;
		c = 'A';
		System.out.printf("변수 c 의 값 : %c\n", c);
		System.out.println("변수 c 의 값 : " + c);
		
		String s;
		s = "ABCD";
		System.out.printf("변수 s 의 값 : %s\n", s);
		System.out.println("변수 s 의 값 : " + s);
		
		
		a = 16;
		b = 52;
		c = '+';
		plusResult = a + b;
		System.out.printf("%d %c %d = %d\n",  a, c, b, plusResult);
		minusResult = a - b;
		c = '-';
		System.out.printf("%d %c %d = %d\n",  a, c, b, minusResult);
		multiplyResult = a * b;
		c = 'x';
		System.out.printf("%d %c %d = %d\n", a, c, b, multiplyResult);
		divideResult = a / b;
		c = '÷';
		System.out.printf("%d %c %d = %.2f\n", a, c, b, divideResult);
		
		
				
		
	}

}
