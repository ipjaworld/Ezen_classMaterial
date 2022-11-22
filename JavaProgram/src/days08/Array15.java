package days08;

import java.util.Scanner;

public class Array15 {

	public static void main(String[] args) {
		
		// 3명 학생의 3과목 점수 저장 배열.  마지막 열은 총점
		int [][] score = new int[3][4];
		// 마지막 열은 총점을 위한 열
		
		double [] avg = new double[3];
		String [] name = new String[3];
		char [] grade = new char[3];
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<score.length; i++) {
			System.out.print((i+1) + "번 학생 이름 : ");
			name[i] = sc.nextLine();
			
			for( int j=0; j<score[i].length-1 ; j++) {
				if( j==0)System.out.print("국어 점수 : ");
				else if(j==1)System.out.print("영어 점수 : ");
				else System.out.print("수학 점수 : ");
				score[i][j] = Integer.parseInt( sc.nextLine()  );
			}
		}
		char [] g = { 'F', 'F', 'F', 'F', 'F', 'F', 'D', 'C', 'B', 'A', 'A' };
		// 이중 반복문을 이용해서 총점 평균 학점 계산
		
		for(int i=0; i<score.length; i++) {
			for(int j=0; j<score[i].length-1; j++) 
				score[i][3] += score[i][j];
			avg[i] = score[i][3]/3.0;
			int index = (int)(avg[i]/10);
			//System.out.println(avg[i] + " " + index);
			grade[i] = g[ index ];
		}
		// 이중 반복문을 이용해서 성적표 출력
		System.out.println("\t\t=====성적표=====");
		System.out.println("--------------------------------------------------");
		System.out.println("번호\t성명\t\t국어\t영어\t수학\t총점\t평균\t학점");
		System.out.println("--------------------------------------------------");
		for(int i=0; i<score.length; i++) {
			System.out.printf("%3d\t", i+1);
			System.out.printf("%3s\t\t", name[i]);
			for(int j=0; j<score[i].length; j++)
				System.out.printf("%3d\t", score[i][j]);
			System.out.printf("%.1f\t", avg[i]);
			System.out.printf("%c\n", grade[i]);
		}

	}

}








