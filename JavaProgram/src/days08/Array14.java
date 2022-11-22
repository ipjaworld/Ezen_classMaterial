package days08;

public class Array14 {

	public static void main(String[] args) {
		
		// 자바의 2차원 배열은 각행에 있는 열의 갯수가 서로 다를수 있습니다.
		// 2차원 배열의 선언
		int [][] a;    // 참조 변수 선언;
		
		a = new int[3][];  // 주소를 저장할수 있는 참조변수3개짜리 배열의 공간을 생성-할당합니다
		
		// 3개의 참조변수에  정수들을 저장할수 있는 1차원 배열공간을 생성해서 할당, 모두 갯수를 다르게 생성
		a[0] = new int[3];   // a[0][0], a[0][1], a[0][2]
		a[1] = new int[4];   // a[1][0], a[1][1], a[1][2], a[1][3] 
		a[2] = new int[5];   // a[2][0], a[2][1], a[2][2], a[2][3], a[2][4]
		
		// 생성된 배열에 행과 열의 순서데로 1부터 1씩 늘어나는 값을 저장합니다.  반복문과 length 이용
		int k=1;
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				a[i][j] = k++;
			}
		}
		// 저장된 값을 행과 열의 맞춰 출력합니다.  for(  변수 : 배열 ) 의 형식의 반복문 이용
		for( int [] rowAdd : a) {
			for( int colVal : rowAdd ) {
				System.out.printf("%2d ", colVal);
			}
			System.out.println();
		}
		

		
		
	}

}




