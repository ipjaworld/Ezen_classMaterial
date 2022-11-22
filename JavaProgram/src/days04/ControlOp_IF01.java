package days04;

import java.util.Scanner;

public class ControlOp_IF01 {

	public static void main(String[] args) {
		
		// 사용자로 부터 정수하나를 입력 받아서   짝수인지  홀수인지를 출력하려고 합니다
		// 이전예제처럼 짝수 홀수 상태를 true/false 로 출력하는것 아니라. 
		// 정확히 "짝수입니다" 또는 "홀수입니다" 로 출력할 예정입니다
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("정수를 입력하세요 : ");
		int a = sc.nextInt();		
		int b = a % 2;
		// System.out.println("입력한 정수는 짝수? : " + (b==0) );
		
		// if : if 명령옆에 있는 괄호() 안에 관계(비교)연산식을 넣어놓고 그결과 true냐 false냐에 따라 중괄호{}안의 명령을
		// 실행할 지 , 실행하지 않고 뛰어 넘을지 결정하는 명령입니다
		if( b==0 ) {
			System.out.println("짝수입니다");
		}
		if( b==1 ) {
			System.out.println("홀수입니다");
		}
		
		// if문의 특징
		// ( ) 안의 연산의 결과 또는 값이 true 이면  { } 안의 명령을 실행, false 이면 실행하지 않는 명령
		// ( ) 안의 값이 true 이면 실행해야할 명령이 두개 이상일수 있으므로, 
		// 			{  }로 그 경계를 구분해줍니다. 실행하거나 실행하지 않을 영역 구분
		// ( ) 안의 값이 true 일때 실행할 명령이 한개라면, 중괄호{}를 생략할 수 있습니다 
		// 만약 ()안에 일부러 true 를 썼다면 -> if( true ){  }
		//      { }안의 내용은 무조건 실행됩니다. 
		// 반대의 경우  if(false){  } 무조건 { }안의 내용을 실행안하고 건너뜁니다
		//  (  ) 안에는 비교연산과 논리연산이 조합된 복합연산식 표현이 가능합니다
		//     if( (x==0)&&(y!=0)||(z==0)  ){   }
		// ( ) 안에는 비교연산대신 true / false 값을 갖고 있는 boolean 변수도 들어갈수 있습니다.
		
		
		// 짝수입니다를 출력하기 위한 if문의 여러가지 구성
		if( b== 0 )
			System.out.println("짝수입니다");	
		if( b== 0 ) System.out.println("짝수입니다");
		// 명령이 하나만 있는 if명령은 if 부터 한개의 명령뒤에 세미콜론까지가 하나의 문장으로 인식됩니다.
		// 그래서 세미콜론도 마지막에 한번만 사용합니다
		// 명령이 여러개여서 중괄호가 사용되면 따로 if문자체레 세미콜론은 사용하지 않고,
		// 중괄호 안의 각 명령들에만 세미콜론을 사용합니다
		
		// 초보가 이부분에서 실수하는 문장
		//if( b== 0 );
		//	  System.out.println("짝수입니다");
		
		boolean result = b==0;
		if( result == true ) System.out.println("짝수입니다");
		if( result ) System.out.println("짝수입니다");
		if( a%2 == 0 ) System.out.println("짝수입니다");
		
		
		// 홀수입니다 를 출력하기 위한 if문의 여러가지 구성
		if( b== 1 ) System.out.println("홀수입니다");
		result = b==0;
		if( result == false ) System.out.println("홀수입니다");
		if( !result ) System.out.println("홀수입니다");
		
		result = b==1;
		if( result == true ) System.out.println("홀수입니다");
		if( result ) System.out.println("홀수입니다");
		
		if( !(a%2 == 0) ) System.out.println("홀수입니다");
		if( a%2 != 0 ) System.out.println("입력한 정수는 홀수입니다");
	}

}







