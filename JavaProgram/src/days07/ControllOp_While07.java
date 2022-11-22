package days07;

import java.util.Scanner;

public class ControllOp_While07 {

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
				switch(m) {
					case 12: days += 30;  	case 11: days += 31;   	case 10: days += 30;
					case 9: days += 31;   case 8: days += 31;   case 7: days += 30;
					case 6: days += 31;   case 5: days += 30;   case 4: days += 31;
					case 3: 
						if( (y%4 == 0) && (y%100 != 0) || (y%400 == 0) ) days += 29;
						else days += 28;				
					case 2: days += 31;  case 1:  days += 0;
				}		
				days = days + 1;   // 입력한 달의 1일자 요일을 구하기 위해 날자합산에 1을 더합니다
				int temp = days % 7;   //  0-일, 1-월, 2-화, 3-수, 4-목, 5-금,  6-토
				System.out.println("\n");
				System.out.println(y + "년  " + m + "월");
				System.out.println("--------------------------------------------------");
				System.out.println("일\t월\t화\t수\t목\t금\t토");
				System.out.println("--------------------------------------------------");
				int k;
				for( k=1; k<=temp; k++) System.out.printf("\t");
				int lastDay;
				switch(m) {
					case 12: 	case 10:	case 8:	case 7:	case 5:	case 3:	case 1:
						lastDay = 31; break;
					case 11:  case 9: case 6: case 4: 
						lastDay = 30; break;
					case 2: 
						if( (y%4 == 0) && (y%100 != 0) || (y%400 == 0) ) lastDay = 29;
						else lastDay = 28;
						break;
					default:
						lastDay=0;
				}
				for( int i = 1; i<=lastDay; i++) {
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
							m = 12;
							y--;
						}else {
							m--;
						}
						break;
					case 2:
						if(m==12) {
							m=1;
							y++;
						}else {
							m++;
						}
						break;
				}
				
		}
		System.out.println("프로그램을 종료합니다");
		
	}

}
