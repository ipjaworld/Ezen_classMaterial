package days16;

import java.text.ParseException;
import java.util.Scanner;

public class Exception06 {

	public static void main(String[] args) {
		
		// 순수하게 숫자만으로 이루어진 정수를 입력 받는  while 과 try-catch 를 제작하세요
		// 입력값에 문자가 섞이거나 하면 에러가 발생되어 "잘못입력했습니다" 라고 출력
		// Integer.parseInt() 메서드는 숫자로 변환될 입력이 아라비아기호(문자)가 아닌 다른 문자 등이 입력되면
		// 에러가 발생합니다
		Scanner sc = new Scanner(System.in);
		int num;
		System.out.print("정수를 입력하세요 : ");
		while(true) {
			String s  = sc.nextLine();
			try {
				num = Integer.parseInt(s); // 현재위치에서 에러발생시 catch 이동. 에러가 없으면 break 실행
				break;
			} catch (NumberFormatException e) {
				// 최초 catch 에 Exception 만 쓰고 일부러 에러를 발생하면, e.printStackTrace 를 통해
				// Exception 종류를 알아낼 수 잇습니다.
				// 이후에 간경하게 수정하세요
				System.out.print("잘못입력했습니다. 숫자만 입력하세요 : ");
				//e.printStackTrace();
			}
		}
		System.out.println("입력한 숫자는 " + num + " 입니다");

	}

}
