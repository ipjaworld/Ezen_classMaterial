package days06;

public class ControlOp_For12 {

	public static void main(String[] args) {
		
		int i; 
		int j;
		
		for(j=1; j<=10; j++) {
			for(i=1; i<=10; i++) {
				//System.out.printf("#");
				System.out.printf("(%d, %d) ", j, i);
			}
			System.out.println();
		}
		// j가 1일때,   i 가 1~10까지 반복
		// j가 2일때,   i 가 1~10까지 반복
		// j가 3일때,   i 가 1~10까지 반복
		// ....
		// j가 10일때,   i 가 1~10까지 반복
		

	}

}
