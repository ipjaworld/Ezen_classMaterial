package days09;

import java.util.Scanner;

public class Method19 {

	public static void main(String[] args) {
		
		int [][] scores;
		double [] avg;
		String [] grade; 
		
		// 학생수와 과목수는 아직 결정되지 않았습니다
		
		int s=getStudentNumber(); // 학생수를 입력 받아서 리턴하는 메서드
		int k=getSubjectNumber(); // 과목수를 입력 받아서 리턴하는 메서드
		scores = new int[s][k+1];  // 총점이 저장될 공간을 위해 과목수 보다 한칸 더 공간을 생성합니다
		// scores = new int[getStudentNumber()][getSubjectNumber()+1]
		avg = new double[ s ];
		grade = new String[s];
		
		input(scores);  // s 명의 학생의 k 개의 과목 점수 입력  (과목점수 입력 받을때, 과목명은 '1과목', '2과목'... 으로)
		cals( scores, avg, grade ); // 총점 , 평균, 학점 계산
		output( scores, avg, grade );	// 양식에 맞게 성적표 출력
	}
	public static void output(  int [][] s, double [] a, String [] g ) {
		System.out.println("\t\t###성적표###");
		System.out.println("-------------------------------------------------");
		System.out.printf("번호\t");
		for(int i=0; i<s[0].length-1; i++)
			System.out.printf("%d과목\t", i+1);
		System.out.printf("총점\t평균\t학점\n");
		System.out.println("-------------------------------------------------");
		for(int i=0;i<s.length; i++) {
			System.out.printf("%d\t", i+1);
			for(int j=0; j<s[i].length; j++) {
				System.out.printf("%d\t", s[i][j]);  // 총점까지 출력
			}
			System.out.printf("%.1f\t", a[i]);
			System.out.printf("%s\n", g[i]);
		}
		System.out.println("-------------------------------------------------");
	}
	public static void cals( int [][] s, double [] a, String [] g) {
		String [] grade = {"F","F","F","F","F","F","D","C","B","A","A",}; 
		for(int i=0; i<s.length; i++) {
			int k = s[i].length-1;
			for(int j=0; j<s[i].length-1; j++) 
				s[i][ k ] += s[i][j];
			a[i] = s[i][k] / (double)k;
			int index = (int)(a[i]/10); 
			g[i] = grade[ index ];
		}
	}
	public static void input(int[][] s) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<s.length; i++) {
			for(int j=0; j<s[i].length-1; j++) {
				System.out.printf("%d번 학생의 %d과목 점수 :  ", i+1, j+1);
				s[i][j] = Integer.parseInt( sc.nextLine()  );
				// 호출당시 전달된 배열의 주소가 매개변수에 저장되어져서 사용됩니다
				// 이는 호출한곳에서 사용하고 있는 배열을 직접 제어할 권한을 얻은것이나 마찬가지입니다.
				// 따라서 input메서드의 s[i][j]에 값을 넣는것은 main의 scores[i][j] 에 값을 넣는것과 같습니다 
			}
		}
	}
	
	public static int getSubjectNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.print("과목수를 입력하세요 : ");
		int sbj = Integer.parseInt( sc.nextLine() );
		return sbj;
	}
	public static int getStudentNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.print("학생수를 입력하세요 : ");
		int std = Integer.parseInt( sc.nextLine() );
		return std;
	}
	
	

}
