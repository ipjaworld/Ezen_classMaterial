package days09;

public class Method14 {

	public static void main(String[] args) {
		
		int [] a = {65,87,89,12,45,36,57,45};
		int tot = sum(a);
		double avg = average(a);
		prn(a, tot, avg);
	}
	public static void prn( int [] d, int t, double a) {
		System.out.print("배열의 요소 : ");
		for(int k : d) System.out.printf("%d ", k);
		System.out.println();
		System.out.printf("합계 : %d, 평균 : %.1f", t, a);
	}
	public static int sum(int [] b) {
		int s = 0;
		for( int i=0; i<b.length; i++ ) s+=b[i];
		return s;
	}
	public static double average( int [] c) {
		return sum( c ) / (double)c.length;
	}
		

}
