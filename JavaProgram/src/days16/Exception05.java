package days16;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Exception05 {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Scanner sc = new Scanner(System.in);
		Date inDate = null;
		System.out.print("날짜를 예와 같이 입력해주세요.(입력예:2015-12-31) ");	
		
		while(true) {
			String s  = sc.nextLine();
			try {
				inDate = sdf.parse(s); // 현재위치에서 에러발생시 catch 이동. 에러가 없으면 break 실행
				break;
			} catch (ParseException e) {
				System.out.print("잘못입력했습니다. 양식데로 다시입력하세요(입력예:2015-12-31) : ");
			}
		}
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy년 MM월 dd일");
		System.out.println("입력한 날짜는 " + sdf2.format(inDate));

	}

}
