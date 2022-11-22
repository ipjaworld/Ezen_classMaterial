package days09;

public class Method18 {

	public static void main(String[] args) {
		
		cals("합계",98,78,45,12,23,87,69,59);
		System.out.println();
		cals("평균",98,78,45,12,23,32,98,63,25,87);

	}
	
	public static void cals(String op, int ... a) {
		int tot=0;
		for(int i=0; i<a.length; i++) tot = tot + a[i];
		
		if( op.equals("합계")) {
			System.out.printf("합계 : %d" , tot);
		}else {
			System.out.printf("평균 : %.1f" , tot/(double)a.length);
		}
		
	}

}
