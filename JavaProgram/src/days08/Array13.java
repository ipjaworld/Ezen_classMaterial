package days08;

public class Array13 {

	public static void main(String[] args) {
		
		// 2차원 배열
		// 행과 열의 개념을 사용하는 인덱스가 2개인 배열
		// 2차원 배열의 변수 선언 -  행과 열을 의미하는 []가 두개 사용
		int [][] a;
		
		// 2차원 배열의 공간 생성
		// 변수명 = new 자료형[행의수][열의수];
		// 3행 2열의 2차원 배열 생성		
		// (2개의 요소를 가지는 일차원 배열을 3개 생성 - 3행 2열의 배열)
		a = new int[3][2];
		int [][] a1 = new int[3][2];   // 이와 같이 한번에 작성도 가능합니다
		// 1차원 배열과 마찬가지로 2차원도 HEAP 메모리에 생성되므로 
		// 초기화 값은 0 입니다.
		 
		int [][] b = { {1,2}, {3,4}, {5,6} };
		// int [][] a = new int[3][2];  -> 값이 모두 0으로 초기화 
		// 위 두개의 배열 선언은 각 구성요소 값들은 다르지만  행열의 갯수는 같습니다
		
		// 이차원배열의 구조

		// b[0] : {1,2}     b[1] : {3,4}     b[2] : {5,6}	
		
		// b[0][0]:1    b[0][1]:2
		// b[1][0]:3    b[1][1]:4
		// b[2][0]:5    b[2][1]:6
		
		
		// 2차원 배열의 요소 접근 - 2개의 인덱스를 사용
		// 변수명[행의인덱스 - 0부터시작][열의 인덱스 - 0부터시작] = 값;
		// a 2차원 배열의 3번째 행의 두번째 요소에 10을 입력
		a[2][1] = 456;
		// 세번째행의 두번째 값 출력
		System.out.println(a[2][1]);
		
		
		// 이차원 배열을 만들고, 이중반복문을 이용해서 값을 저장하고, 이중반복문을 이용해서 출력
		// 4행 6열 배열을 만들고,   값으로는 1~25를 저장
		int [][] c = new int[4][6];
		
		int k=1;
		for( int i=0; i<4; i++) {
			for(int j=0; j<6; j++) {
				c[i][j] = k++;
			}
		}
		
		for( int i=0; i< c.length /*행의 갯수*/ ;  i++) {
			for(int j=0; j< c[i].length /* 열의 갯수 */ ; j++) {
				System.out.printf("%2d  ", c[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		
		int [] d = {1,2,3,4,5};
		for( int p : d) {
			System.out.print(p + " ");
		}
		
		System.out.println();
		System.out.println();
		
		for( int [] row   : c  ) {  
			// c 참조변수가 저장한 주소에 있는  4개짜리 참조변수들. 그 주소들을 한번씩 row에 담으며 반복실행
			for( int value : row ) {
				//row 에 저장된 주소에 있는 진짜 int 값들을 value 변수에 하나씩 넣으며 반복 실행됩니다.
				System.out.print(value + " ");
			}
			System.out.println();
		}
		
		 
	}

}






