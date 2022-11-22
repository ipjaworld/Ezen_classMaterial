package days05;

import java.util.Scanner;

public class ControlOP_IF08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int kor, eng, mat, tot;
		double ave;
		
		// 국어 영어 수학점수를 입력받아서
		System.out.print("국어 점수 :  ");
		kor = sc.nextInt();
		System.out.print("영어 점수 :  ");
		eng = sc.nextInt();
		System.out.print("수학 점수 :  ");
		mat = sc.nextInt();
		// 총점 평균을 계산하고
		tot = kor+eng+mat;
		ave = tot / 3.0;
		
		// 평균 60점 이상이면서 모든 과목 40이상이면 합격
		// 그렇지 않다면 불합격을 출력하되,
		
		// 해당되는 불합격사유(평균 미달, 국어 과락, 영어과락, 수학과락)를 모두 함께 출력하세요
		/*
		if( (ave>=60) && (kor>=40) && (eng>=40) && (mat>=40) )
			System.out.println("합격");
		else if( (ave < 60) && (kor>=40) && (eng>=40) && (mat>=40)  )
			System.out.println("불합격 - 평균미달");
		else if( ave <60 && kor>=40 && eng>=40 && mat>=40)
			System.out.println("불합격\t평균미달");
		else if( eng < 40 )
			System.out.println("불합격 - 영어과락");
		else if( mat < 40 )
			System.out.println("불합격 - 수학과락");
		else if( ave<60 && kor<40 && eng>=40 && mat>=40 )
			System.out.println("불합격\t평균미달\t국어과락");
			
			... 경우의 수 24개
		*/
		
		if( (ave>=60) && (kor>=40) && (eng>=40) && (mat>=40) )
			System.out.println("합격");
		else {
			System.out.printf("불합격\t");
			if(ave<60) System.out.printf("평균미달\t");
			if(kor<40) System.out.printf("국어과락\t");
			if(eng<40) System.out.printf("영어과락\t");
			if(mat<40) System.out.printf("수학과락\t");
		}

	}

}










