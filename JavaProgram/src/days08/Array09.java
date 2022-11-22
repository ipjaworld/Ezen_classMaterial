package days08;

import java.util.Scanner;

public class Array09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("년 입력 : "); 
		int y = sc.nextInt(); 		
		System.out.printf("월 입력 : ");
		int m = sc.nextInt();
		int input;
		while(true) {
				int days = 365 * (y-1);
				for( int i=1; i<y;  i++) 
					if( (i%4 == 0) && (i%100 != 0) || (i%400 == 0) )	
						days++;
				int [] mdays = {0,31,28,31,30,31,30,31,31,30,31,30,31};
				if( (y%4 == 0) && (y%100 != 0) || (y%400 == 0) ) mdays[2] = 29;
				for(int i=1; i<m; i++) days += mdays[i];	
				days = days + 1;   // 입력한 달의 1일자 요일을 구하기 위해 날자합산에 1을 더합니다
				int temp = days % 7;   //  0-일, 1-월, 2-화, 3-수, 4-목, 5-금,  6-토
				System.out.println("\n");
				System.out.println(y + "년  " + m + "월");
				System.out.println("--------------------------------------------------");
				System.out.println("일\t월\t화\t수\t목\t금\t토");
				System.out.println("--------------------------------------------------");
				int k;
				for( k=1; k<=temp; k++) System.out.printf("\t");
				for( int i = 1; i<=mdays[m]; i++) {
					System.out.printf("%2d\t", i);
					if(k%7 == 0) System.out.println();
					k++;
				}
				System.out.printf("\n\n[1.이전달]\t[2.다음달]\t[3.종료] ");
				input = sc.nextInt();
				if(input==3) break;
				switch( input ) {
					case 1:
						if( m == 1) {
							m = 12;	y--;
						}else 
							m--;
						break;
					case 2:
						if(m==12) {
							m=1;	y++;
						}else 
							m++;
						break;
				}
		}
		System.out.println("프로그램을 종료합니다");

	}

}
