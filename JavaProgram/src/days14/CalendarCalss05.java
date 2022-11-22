package days14;
import java.util.Calendar;
import java.util.Scanner;

public class CalendarCalss05 {

	public static void main(String[] args) {
		
		int year, month; 
        int input=0;
        Scanner sc = new Scanner(System.in);
        System.out.printf("년도 입력 : ");
        year=Integer.parseInt( sc.nextLine() );
        System.out.printf("월 입력 : ");
        month=Integer.parseInt( sc.nextLine() );

        // 입력한 월의 1일자와 말일자를 두개의 객체에 설정후 시작날부터 끝날까지 출력합니다        
        // 1. 두개의 객체 생성
        Calendar sDay = Calendar.getInstance();
        Calendar eDay = Calendar.getInstance();
        
        //while(true) {
	    // 2. 1일자와 말일자를 해당객체에 설정
	    sDay.set(year,  month-1, 1);
	    //eDay.set(year, month-1, sDay.getActualMaximum(Calendar.DATE) );
	    eDay.set(year,  month, 1);
	    eDay.add( Calendar.DATE, -1);
	        
	    while(true) {
	        // 3. 1일자의 요일 추출
	        int startWeek = sDay.get(Calendar.DAY_OF_WEEK);
	        
	        // 4. 달력의 타이틀 출력
	        System.out.println("\n" + year + "년  " + month + "월  ");
	    	System.out.println("----------------------------------------------");
	        System.out.println("일\t월\t화\t수\t목\t금\t토");
	        System.out.println("----------------------------------------------");
	        
	        // 4. 1일자까지 빈칸 출력
	        for(int i=1; i<startWeek; i++) System.out.printf("\t");
	        
	        // 5. 1일자부터 말일자까지 날짜 출력 / startWeek 를 매 날짜마다 늘리면서  7의 배수일때 줄바꿈
	        for( int i=1; i<=eDay.get(Calendar.DATE); i++) {
	        	System.out.printf("%2d\t", i);
	        	if(startWeek++ % 7 == 0) System.out.println();
	        	//startWeek++;
	        }
	        
	        System.out.println("\n----------------------------------------------");
	        System.out.print("\n[이전달(1)] | [다음달(2)] | [종료(3)]");
	        input = Integer.parseInt( sc.nextLine() );
	        if(input==3)break;
	        // 해당프로그램의 유효한 영역을 반복실문에 넣고, 이전달 다음달을 위하 날짜를 설정해서 완성하세요
	        
	        if( input==1) {
	        	//if(month==1) { year--; month=12; }
	        	//else {month--; }
	        	sDay.add(Calendar.MONTH, -1);
	        	year = sDay.get(Calendar.YEAR);
	        	month = sDay.get(Calendar.MONTH)+1;
	        	eDay.set( year , month-1, sDay.getActualMaximum(Calendar.DATE) );
	        }else if( input==2) {
	        	//if(month==12) { year++; month=1; }
	        	//else {month++; }
	        	sDay.add(Calendar.MONTH, 1);
	        	year = sDay.get(Calendar.YEAR);
	        	month = sDay.get(Calendar.MONTH)+1;
	        	eDay.set( year , month-1, sDay.getActualMaximum(Calendar.DATE) );
	        }
	        
	        
        }

	}

}








