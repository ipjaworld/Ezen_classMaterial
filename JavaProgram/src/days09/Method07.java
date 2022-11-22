package days09;

public class Method07 {

	public static void main(String[] args) {
		
		int [] a = {56,54,87,89,25,36,57,98};
		// 아래명령 sum(a); 이 정상 실행되어서 배열내 값들의 합계와 평균을 출력도록
		// sum 함수를 제작하세요
		sum(a);

	}
	
	public static void sum( int [] b ) {
		int s = 0;
		double avg;
		for( int i=0; i<b.length; i++) 
			s = s + b[i];
		avg = s / (double)b.length;
		System.out.printf("합계 : %d, 평균 : %.2f\n", s, avg);
		
	}

}
