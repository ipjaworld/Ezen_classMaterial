package days16;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Exception03 {

	public static void main(String[] args) throws ParseException {
		
		try {
			// ArithmeticException 등의 클래들을 이용해 객체를 만들고 그 객체로 에러를 일부러 발생시킬 수 있습니다
			ArithmeticException a = new ArithmeticException ("ArithmeticException 고의 발생");
			throw a;
		}catch( ArithmeticException e) {
			System.out.printf("ArithmeticException - ");
			System.out.println("에러 메시지 : " + e.getMessage());
		}catch( RuntimeException e){
			System.out.printf("RuntimeException - ");
			System.out.println("에러 메시지 : " + e.getMessage());
		}catch( Exception e) {
			System.out.printf("Exception - ");
			System.out.println("에러 메시지 : " + e.getMessage());
		}
		
		try {
			RuntimeException a = new RuntimeException ("RuntimeException 고의 발생");
			throw a;
		}catch( ArithmeticException e) {
			System.out.printf("ArithmeticException - ");
			System.out.println("에러 메시지 : " + e.getMessage());
		}catch( RuntimeException e){
			System.out.printf("RuntimeException - ");
			System.out.println("에러 메시지 : " + e.getMessage());
		}catch( Exception e) {
			System.out.printf("Exception - ");
			System.out.println("에러 메시지 : " + e.getMessage());
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String k = "2022/10/19";
		try {
			Date d = sdf.parse(k);
		} catch (ParseException e) {
			System.out.println("String 데이터의 날짜양식을 확인하세요");
			e.printStackTrace();
		}
		
		Date d = sdf.parse(k);
		
		// 어떤 명령 그리고 메서드는 에러발생의 요인을 쉽게 예상할수 없지만, 어떤 명령과 메서드는 쉽게 예상이 가능하기도 합니다
		// 그런 상황에서 만들어진 메서드는 위와 같이 에외처리 요소를 품고 있다가, 사용하게 되면 개발자에게
		// 예외처리를 권유합니다.  권유를 받은 개발자는 위와 같이 try catch 구문을 사용(surround with try catch)하거나
		// 현재 코드를 사용하는상위 메서드에게 처리를 일임(add throw declaration)하는것중 하나를 선택하여 처리합니다
	}

}









