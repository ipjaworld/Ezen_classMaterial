package days07;

import java.util.Scanner;

public class Array04 {

	public static void main(String[] args) {
		
		// n 명의 학생의  국어, 영어, 수학 입력받아서
		// 성적표를 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.print("학생이 몇명인가요? ");
		/*
		int std = sc.nextInt();
		System.out.print("이름을 입력하세요");
		String name = sc.nextLine();
		System.out.println("\n학생수 : " + std + ", 이름 : " + name);
		// sc.nextInt() 는 사용자 입력중에 마지막Enter 를 제외한 앞의 정수만 취합니다
		// 공교롭게 바로 다음에 sc.nextLine() 명령이 온다면 입력 버퍼에 남아있는 Enter 를
		// 해당 입력String 데이터로 인식해서 취하고, 명령을 종료합니다. 원하는String 입력이 불가능해집니다
		// 따라서 별도의 조치가 없어도 되는 상황이 아니라면 sc.nextLine() 으로 먼저 입력받고 이를 숫자로 변경합니다 
		*/
		//String temp = sc.nextLine();
		//int std = Integer.parseInt(temp);
		int std = Integer.parseInt( sc.nextLine() );
		
		int [] kor = new int[std];   // 국어점수들 저장용 배열
		int [] eng = new int[std]; // 영어 점수용
		int [] mat = new int[std]; // 수학점수용
		int [] tot  = new int[std]; // 총점 용
		double [] avg = new double[std];   // 평균용
		String [] name = new String[std];   // 이름용
		
		/*
		System.out.print("1번학생 이름 : ");
		name[0] = sc.nextLine();
		System.out.print("1번학생 국어 : ");
		kor[0] = Integer.parseInt( sc.nextLine() );
		System.out.print("1번학생 영어 : ");
		eng[0] = Integer.parseInt( sc.nextLine() );
		System.out.print("1번학생 수학 : ");
		mat[0] = Integer.parseInt( sc.nextLine() );
		*/
		
		for(int i=0; i<std; i++) {
			System.out.print((i+1) + "번학생 이름 : ");
			name[i] = sc.nextLine();
			System.out.print((i+1) + "번학생 국어 : ");
			kor[i] = Integer.parseInt( sc.nextLine() );
			System.out.print((i+1) + "번학생 영어 : ");
			eng[i] = Integer.parseInt( sc.nextLine() );
			System.out.print((i+1) + "번학생 수학 : ");
			mat[i] = Integer.parseInt( sc.nextLine() );
		}
		
		for(int i=0; i<std; i++ ) {
			tot[i] = kor[i] + eng[i] + mat[i];
			avg[i] = tot[i] / 3.0;
		}
		
		// 성적표출력
		System.out.println("\t\t###성적표###");
		System.out.println("-------------------------------------------------");
		System.out.println("번호\t성명\t국어\t영어\t수학\t총점\t평균");
		System.out.println("-------------------------------------------------");
		
		for( int i = 0; i< kor.length; i++) {
			System.out.printf("%3d\t", i+1);
			System.out.printf("%3s\t", name[i] );
			System.out.printf("%3d\t", kor[i] );
			System.out.printf("%3d\t", eng[i] );
			System.out.printf("%3d\t", mat[i] );
			System.out.printf("%3d\t", tot[i] );
			System.out.printf("%6.2f\n", avg[i] );
		}	
		System.out.println("-------------------------------------------------");
		// 배열의 크기 : 배열크기는 프로그램에서 중요한 정보입니다.
		// 배열의 크기에 따라 반복의 횟수나, 특정 인덱스의 값을 참조하는것이 수시로 
		// 바뀌기 때문입니다.
		// 배열은 이러한 문제를 해결하기 위해 length 라는 속성을 제공합니다.
		// 배열의이름.length -> 배열의 크기, 정수 타입의 데이터를 얻습니다

	}

}
