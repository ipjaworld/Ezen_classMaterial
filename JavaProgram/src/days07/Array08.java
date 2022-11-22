package days07;

public class Array08 {

	public static void main(String[] args) {
		
		int[] a = new int[6];
		
		// 1~45 사이의 임의의 난수를  a 배열에 여섯개 저장한 후,
		// 오름차순으로 정렬해서 출력하세요.

		int i = 0;
		while( i<a.length ) {
			a[i] = (int)(Math.random() * 45) + 1;
			i++;
		}
		
		for( i = 0; i<a.length; i++) {
			for( int j = i+1; j<a.length; j++) {
				if( a[i] > a[j] ) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		
		for( i = 0; i<a.length; i++)	System.out.printf("%d  ", a[i]);
		
	}

}
