package days06;

public class ControlOp_While02 {

	public static void main(String[] args) {
		
		// 1부터 100 사이의 짝수의 출력 : while 문을 이용해주세요

		int i = 1;
		while( i<=100) {
			if( i%2 == 0)
				System.out.printf("%d ", i);
			i++;
		}
		System.out.println();
		i = 2;
		while( i<=100) {
			System.out.printf("%d ", i);
			i+=2;
		}
	}

}
