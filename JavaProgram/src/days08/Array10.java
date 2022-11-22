package days08;

import java.util.Scanner;

public class Array10 {

	public static void main(String[] args) {
		
		// 점수를 입력 받아서 해당 학점을 출력합니다.
		// if 문을 이용하지 않습니다. 배열을 이용합니다
		// 90이상 A , 80이상 B, 70이상 C ,  60이상  D,  나머지  F
		
		char [] grade = {'F' , 'F' , 'F' , 'F' , 'F' , 'F' , 'D' , 'C' , 'B' , 'A' , 'A'};
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("점수를 입력 하세요(0~100) : ");
		int score = Integer.parseInt( sc.nextLine() );
		
		int index = score / 10;
		// int index = (score==0)? 0 : score/10 ;
		
		System.out.println("학점 : " + grade[ index ]);
		
	}

}





