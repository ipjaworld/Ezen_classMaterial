package days05;

public class ControlOp_For03 {

	public static void main(String[] args) {
		
		// 1부터 100까지의 합
		// int sum = 1+2+3+4+5+6+7+8+9+10;
		
		int sum = 0; // 합계를 저장할 변수
		int i; // 반복 제어용 변수
		
		for(i=1; i<=10000; i++) {
			sum = sum + i;
			System.out.println("1부터 " + i + "까지의 합 : " + sum);
		}		
	}
}
