package days07;

public class Array02 {

	public static void main(String[] args) {
		
		// 배열의 선언과 저장 공간 생성 방법 상세
		// null : 아무것도 아니고 아무것도 없다는 뜻의 값(value)입니다
		
		// 1. null 을 이용해서 참조변수값을 초기화
		int [] a1 = null;
		int [] b1;
		
		System.out.println(a1);  
		// System.out.println(b1);  // 에러
		// 아무것도 초기화하지 않은것과 아무것도 없는값(null)으로 초기화한것은 다릅니다
		// b1은 아무것도 초기화되지 않았으므로 연산도 안되고 출력도 안됩니다.
		// a1은 일부 연산의 제약이 있지만 연산도 가능하고, 출력도 가능합니다.  null 이라고 출력
		
		
		// 2. 배열 참조 변수의 선언과 배열 실제 공간의 생성을 동시에 new 를 이용하여 진행했다면
		int [] a2 = new int[4];
		// 각 변수 a2[0], a2[1], a2[2], a2[3] 에는 자동으로 0이 초기화됩니다.
		// new에 의 해서 HEAP 메모리에 생성되는 모든 영역은 0 또는 0.0, null 값으로 자동 초기화됩니다.
		a1 = new int[4];
		System.out.println(a1[0] + " " + a1[1] + " " + a1[2] + " " + a1[3]);
		System.out.println(a2[0] + " " + a2[1] + " " + a2[2] + " " + a2[3]);
		// double [] d = new double[5];  // 모두 0.0 으로 초기화
		// String [] s = new String[5];  //  모두 null 로 초기화
		System.out.println("\n");
		
		
		
		// 3. 배열을 생성과 동시에 값을 초기화하는 방법
		// 크기가 5 인 배열을 생성하면서, 각 요소의 값을 1,2,3,4,5 로 초기화하는 코드
		int [] a3 = new int[] {1,2,3,4,5};
		System.out.println(a3[0]+" "+a3[1]+" "+a3[2]+" "+a3[3]+" "+a3[4]);
		int [] a4 = {5,4,3,2,1};
		System.out.println(a4[0]+" "+a4[1]+" "+a4[2]+" "+a4[3]+" "+a4[4]);
		
		
		// 4. 배열 변수 a7, a8를 동시 선언하는 코드
		int [] a7, a8;
		a7 = new int[3];
		a8 = new int[3];
							
		// 5. 배열 변수 a9, a10,  일반 int형 변수 a11을 생성하는 코드
		int a9 [], a10 [], a11;
		a9 = new int[3];
		a10 = new int[3];
		a11 = 10;
		
	}
}





