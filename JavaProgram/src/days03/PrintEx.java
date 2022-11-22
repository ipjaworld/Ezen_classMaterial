package days03;

public class PrintEx {

	public static void main(String[] args) {
		int a, b, plusResult, minusResult, multiplyResult;
		char c;
		double divideResult;
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
		divideResult = a / (double)b;  // 정수와 정수의 연산은 결과고 정수
		c = '÷';
		System.out.printf("%d %c %d = %.2f\n", a, c, b, divideResult);
		
		System.out.println("\n");
		// 위의 네개의 출력을 println 으로 바꿔서 출력하세요
		String s = "";
		c = '+';
		//System.out.println( a + c + b + "=" + plusResult);
		System.out.println( a + "" + c  + b + "=" + plusResult);  // 15+""  ->  "15"
		// char 변수는 int 변수와 호환성이 존재합니다. 그래서  15 + 'A'  -> 80
		// 'A' 의 이진수 코드값이 정수로 변해서 다른 정수와 산술덧셈이 된다는 뜻입니다.
		// 다른 형식의 자료들이 산술연산되지 않고 이어붙이기가 되려면 피연산자중 반드시하나는 String 이어야 합니다.
		// 그건 ""  " " 상관없이 적용됩니다
		//System.out.println(a+c);
		c = '-';
		System.out.println(a + " " + c + " " + b + " =" + minusResult );
		c = 'x';
		System.out.println(a + " " + c + " " + b + " =" + multiplyResult);
		c = '÷';
		System.out.println(a + " " + c + " " + b + " =" +divideResult );
		
		// int와  char 간의 관계
		System.out.println("\n");
		char ch = 'A';
		// int와 char사이에는 자료형 간 호환성이 존재합니다.
		System.out.printf("ch 변수의 값 : %c(%d)\n", ch, (int)ch);
		System.out.printf("ch 변수의 값 다음 글자 : %c(%d)\n", ch+1, (int)ch+1);
		System.out.printf("알파벳 A: %d\n", (int)'A');
		System.out.printf("알파벳 Z: %d\n", (int)'Z');
		System.out.printf("알파벳 a: %d\n", (int)'a');
		System.out.printf("알파벳 z: %d\n", (int)'z');
		System.out.printf("아라비아 기호 0: %d\n", (int)'0');
		System.out.printf("아라비아 기호 9: %d\n", (int)'9');
		System.out.printf("연산기호 +: %d\n", (int)'+');
		System.out.printf("연산기호 -: %d\n", (int)'-');
		System.out.printf("연산기호 *: %d\n", (int)'*');
		System.out.printf("연산기호 ÷: %d\n", (int)'÷');
		// 이숫자들을 아스키코드라고 부릅니다
		
		System.out.printf("아스키코드 65: %c \n", 65);
		System.out.printf("아스키코드 90: %c \n", 90);
		System.out.printf("아스키코드 97: %c \n", 97);
		System.out.printf("아스키코드 122: %c \n", 122);
		
		ch = 122;
		int d = 'a';
		
		System.out.println( "char변수 ch변수 : " + ch + ", 정수형 변수 d 값 : "  + d );
		
		
		
		int today = 2022;  //변수값은 변수 생성(선언)과 동시에 초기화(대입)할수 있습니다
		int myYear = 2000;
		
		// 현재는 2022년입니다.
		// 저의 출생년도는 2000년입니다.
		// 한국나이는 23세, 만나이는 생일이 지나지 않았으므로  만 21세입니다
		// printf와 println 둘다 출력하세요. 
		// 연산결과를 별도의 변수를 생성해서 사용해도되고, 연산식을 print 안에 넣어도 됩니다
		
		System.out.printf("현재는 %d년 입니다. \n저의 출생년도는 %d 년 입니다\n", today, myYear);
		System.out.printf("한국나이는 %d세, 만나이는 생일이 지나지 않았으므로 만 %d세 입니다\n", 
				today-myYear+1,today-myYear-1);   // ';' 이 한개만 사용된 두줄의 문장은 하나의 명령으로 인식됩니다
		
		System.out.println("현재는 " + today + "년 입니다. \n저의 출생년도는 " + myYear + "년입니다");
		System.out.println("한국나이는 " + (today-myYear+1) + "세, 만나이는 생일이 지나지 않았으므로 만 " + 
				(today-myYear-1) + "세 입니다");

		
		
		
		// 정수형 변수 세개를 만듭니다(kor, eng, mat)
	    // printf 또는 println을 이용해서 성적표를 출력하세요
	   //  점수는 임의의 점수 아무 점수나 대입하고, 총점 평균도 출력해주세요
	   //  두명의 학생의 성적표를 출력하되, 각 학생의 점수는 한줄성적표 출력후 점수를 바꿔서 대입하고 두번째 성적을 출력합니다
		System.out.println("\t\t###성적표###");
		System.out.println("------------------------------------------------------------");
		System.out.println("번호\t성명\t\t국어\t영어\t수학\t총점\t평균");
		System.out.println("------------------------------------------------------------");
		int kor = 89, eng = 99, mat = 87;
		System.out.printf("%d\t%s\t\t%d\t%d\t%d\t%d\t%.2f\n", 
					1, "홍길동", kor, eng, mat, (kor+eng+mat), (kor+eng+mat)/3.0);
		kor=70;
		eng=90;
		mat=98;	
		System.out.printf("%d\t%s\t\t%d\t%d\t%d\t%d\t%.2f\n", 
				2, "홍길남", kor, eng, mat, (kor+eng+mat), (kor+eng+mat)/3.0);
		System.out.println("------------------------------------------------------------");
	}
}



