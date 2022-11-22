package days07;

public class Array06 {

	public static void main(String[] args) {
		
		// 배열에 있는 값들중 최대값과 최소값을 찾아서 출력하세요
		int [] a = {56, 87, 96, 87, 45, 89, 69, 36, 13, 98, 100, 12};

		int max = a[0]; // 최종으로 가장 큰값이 저장될 변수
		
		// max에 저장된 값과 배열에 저장된 값들을 하나씩 하나씩 차례로 비교합니다
		// 비교결과 max에 있는 값보다 현재 비교하고 있는 배열의 값이 더 크다면, 
		// max 에 현재 배열값을 옮겨저장합니다.
		
		for( int i=1; i<a.length; i++) {
			if( max < a[i] ) max = a[i];
		}
		
		System.out.println("최대값 : " + max);
		
		
		int min = a[0];
		for(int i=1; i<a.length; i++) {
			if(min > a[i]) min = a[i];
		}
		System.out.println("최소값 : " + min);
		
	}

}
