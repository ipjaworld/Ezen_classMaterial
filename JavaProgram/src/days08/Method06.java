package days08;

public class Method06 {

	public static void main(String[] args) {
		
		int [] a = {111,222,333};
		
		System.out.println("\nmain 에서 출력 : ");
		for(int k : a) System.out.printf("%d ", k);
		System.out.println();
		
		updateValue( a );
		
		System.out.println("\nmain 에서 출력 : ");
		for(int k : a) System.out.printf("%d ", k);
		System.out.println();
	}
	// 전달인수가 주소라면, 매개변수도 그 주소를 저장할수 있는 변수이어야 합니다.
	public static void updateValue( int [] b ) {
		b[0] = 444; b[1]=555; b[2]=666;
		System.out.println("\nupdateValue 에서 출력 : ");
		for(int k : b) System.out.printf("%d ", k);
		System.out.println();
		
	}

}
