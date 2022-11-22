package days10;

public class Method21 {

	public static void main(String[] args) {
		
		int[] a;
		
		// 1~45 사이의 임의의 난수를  a 배열에 여섯개 저장한 후,
		// 오름차순으로 정렬해서 출력하세요.

		for(int k=1; k<=5; k++) {		
			a = newNumber();  // 중복없는 6개의 숫자를 발생해서 6칸짜리 배열에 저장후 리턴하는 메서드 제작
			sort(a);
			prn(a);
		}			
	}

	private static void prn(int[] a) {
		for( int k : a)	
			System.out.printf("%d  ", k);
		System.out.println();		
	}

	private static void sort(int[] a) {
		for(int i = 0; i<a.length; i++) {
			for( int j = i+1; j<a.length; j++) {
				if( a[i] > a[j] ) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}

	private static int[] newNumber() {
		int [] k = new int[6];
		int i = 0;
		while( i<k.length ) {
			k[i] = (int)(Math.random() * 45) + 1;
			int j;
			for(j=0; j<i; j++)
				if( k[i] == k[j] ) break;
			if( i!=j ) continue;
			else i++;
		}
		return k;
	}
	
	
}
