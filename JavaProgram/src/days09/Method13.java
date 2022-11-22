package days09;

import java.util.Scanner;

public class Method13 {

	public static void main(String[] args) {
		
		int kor, eng, mat, tot;
		double ave;
		// String grade;	
		kor = myInput(1); //점수 입력
		eng = myInput(2);
		mat = myInput(3);
		tot = sum(kor, eng, mat); // 총점 계산
		ave = avg(kor, eng, mat); // 평균 계산
		// grade = selectGrade(ave);
		prnTitle();
		prnScore( kor, eng, mat, tot, ave);
		System.out.println("----------------------------------------------");
	}
	public static void prnScore(int k, int e, int m, int t, double a){
		System.out.printf("%d\t%d\t%d\t%d\t%d\t%.1f\n", 1,k,e,m,t,a);
	}
	public static void prnTitle() {
		System.out.println("\t\t###성적표###");
		System.out.println("----------------------------------------------");
		System.out.println("번호\t국어\t영어\t수학\t총점\t평균");
		System.out.println("----------------------------------------------");
	}
	public static double avg( int k, int e, int m) {
		// int sum = k+m+e;
		// double a = sum / 3.0;
		return sum(k, e, m) / 3.0;		
	}
	public static int sum( int k, int e, int m) {
		return k+e+m;
	}
	public static int myInput( int n ) {
		if( n==1) System.out.print("국어점수 입력 : ");
		else if( n==2) System.out.print("영어점수 입력 : ");
		else System.out.print("수학점수 입력 : ");
		
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

}
