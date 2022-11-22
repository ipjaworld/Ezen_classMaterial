package days08;

public class Array08 {

	public static void main(String[] args) {
		
		int[] a = new int[6];
		
		// 1~45 사이의 임의의 난수를  a 배열에 여섯개 저장한 후,
		// 오름차순으로 정렬해서 출력하세요.

		for(int k=1; k<=5; k++) {
			
				int i = 0;
				while( i<a.length ) {
					a[i] = (int)(Math.random() * 45) + 1;
					/*
					int cnt = 0;
					for(int j=0; j<i; j++)
						if( a[i] == a[j] ) cnt++;  // 앞선숫자와 지금 추첨한 숫자가 같은 숫자일경우 cnt 가 늘어납니다
					if( cnt != 0) continue;
					// cnt가 0이 아니고 늘어난 상태라면 같은숫자가 있었다는 뜻입니다.
					*/
					int j;
					for(j=0; j<i; j++)
						if( a[i] == a[j] ) break;
					if( i!=j ) continue;
					// 반복실행이 중간에 break 되지 않고 모두 실행되고 끝나면 i값과 j값은 같은 값이 됩니다
					else i++;
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
				System.out.println();
				
		}		
	}

}
