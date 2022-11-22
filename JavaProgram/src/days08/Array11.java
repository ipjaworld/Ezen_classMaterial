package days08;

import java.util.Scanner;

public class Array11 {

	public static void main(String[] args) {
		
		// 야구 게임
		// 상대방 : 알려주지 않은 숫자 2 5 8 생성
		// 질문(공격) : 5 0 8 ?
		// 상대방 : 1S 1B
		
		// 컴퓨터가 나에게 알려주지 않은 숫자를  질문과 답변을 통해 맞춰가는 게임입니다.
		// 사용자에게 알려주지 않은 숫자 : 6 5 7 같은 한자리 숫자 세개를 준비하고
		// 질문 : 3 6 7  같은 한자리 숫자 세개를 입력받아 비교합니다.
		// 답변 : 같은 숫자가 자리수까지 같으면 S   숫자만 같으면 B 을 출력합니다.
		// 숫자 하나는 0~9 까지...  세개의 숫자 중 중복 숫자 없음	
		// 컴퓨터가 갖고 있는 숫자  : 5 6 8
		// 사용자가 컴퓨터에게 질문 : 4 5 8?    답변-> 1S 1B
		
		//1. 컴퓨터가 나에게 알려주지 않은 숫자를 저장할 배열, 사용자가 입력한 숫자를 저장할 배열 생성
		int [] com = new int[3];
		int [] user = new int[3];
		
		//2. 컴퓨터가 나에게 알려주지 않은 숫자 세개를 생성해서 배열에 저장
		int i=0, j;
		while(i<3) {
			com[i] = (int)(Math.random() * 10 );
			for(j=0; j<i; j++)
				if( com[i]==com[j] )break;
			if(i != j) continue;
			i++;
		}
		//System.out.println(com[0] + " " + com[1] + " " + com[2]);
		
		//3. 사용자로부터 숫자세개를 입력받습니다
		Scanner sc = new Scanner(System.in);
		
		while(true) {
				// 방법 #1
				/*
				System.out.print("숫자입력 (반드시 한자리 숫자만 입력하세요) : ");
				user[0] = Integer.parseInt( sc.nextLine() );
				System.out.print("숫자입력 (반드시 한자리 숫자만 입력하세요) : ");
				user[1] = Integer.parseInt( sc.nextLine() );
				System.out.print("숫자입력 (반드시 한자리 숫자만 입력하세요) : ");
				user[2] = Integer.parseInt( sc.nextLine() );
				*/
				
				// 방법 #2
				/*
				System.out.print("숫자 입력 (세자리숫자-중복되지않게)");
				int temp = Integer.parseInt( sc.nextLine() );   // 예를 들어 123 을 입력했다면
				user[0] = temp / 100;    // 123 / 100  -> 1
				user[1] = (temp%100) / 10;   //  123%100 -> 23    23/10  -> 2
				user[2] = temp % 10;    // 123%10   -> 3 
				*/
				
				// 방법 #3
				System.out.print("숫자 입력 (세자리숫자-중복되지 않게) : ");
				String temp = sc.nextLine();   //456
				user[0] = temp.charAt(0) - '0';    // '4' - '0'    ->  4
				user[1] = temp.charAt(1) - '0';   //  '5' - '0'  ->  5
				user[2] = temp.charAt(2) - '0';   //  '6' - '0'  ->  6
				
				// System.out.println(user[0] + " " + user[1] +" " + user[2]);
				
				//4. 컴퓨터가 저장한 숫자와 사용자가 입력한 숫자를 비교해서 Strike  와  Ball 을 count 합니다
				int s=0, b=0;
				for(i=0; i<com.length; i++) {
					for( j=0; j<user.length; j++) {
						if(com[i]==user[j]) {
							if( i==j ) s++;
							else b++;
						}
					}
				}
				//5. 카운트 결과를 출력합니다
				System.out.println(s + " Strike / " + b + " Ball");
				
				if( s==3)break;
		}
		System.out.println("맞췄습니다. 프로그램이 종료합니다");
		// 3~5를 숫자를 맞출때까지 반복합니다

	}

}













