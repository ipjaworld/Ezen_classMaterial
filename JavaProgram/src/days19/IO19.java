package days19;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

// 사칙연산 프로그램
// 두개의 피연산자(정수)와  연산자(연산기호)를 입력 받아서 그 결과를 출력하는 프로그램
// 연산했던 기록을 두개의 정수와 하나의 연산기호를 저장할 수 있는 클래스 객체에 저장해서 파일에 저장
// 추후에 파일을 열어서 계산했던 기록을 열람할수 있게 합니다
// 파일은 날짜를 이용해서 이름을 만들고, 검색은 날짜를 입력해서 파일을 검색하고, 그날 계산했던 기록을 한번에 열람합니다

class CalculatorResult implements Serializable{
	private int leftValue;
	private int rightValue;
	private String operator;
	private double result;
	public CalculatorResult(int leftValue, int rightValue, String operator, double result) {
		this.leftValue = leftValue;
		this.rightValue = rightValue;
		this.operator = operator;
		this.result = result;
	}// 생성자 : 각 멤버 변수를 전달인수들로 초기회합니다
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00");
		return this.leftValue + this.operator	+ this.rightValue + "=" + df.format(this.result);
	}// 왼쪽값 연산자 오른쪽값 = 결과값 을 String 으로 리턴합니다(소수점 두자리까지 표시)
}

public class IO19 {

	public static void main(String[] args) throws IOException {
		
		//CalculatorResult a = new CalculatorResult( 20, 30, "x", 60000.0 );
		//System.out.println(a);
		
		// 입력받아서 계산하고 그 값들을 객체에 생성자를 통해 저장합니다.  그 정된 객체는  ArrayList 에 저장합니다
		// 입력 및 계산 종료의사를 입력하면 ArrayList 는 오늘 날짜를 파일이름으로한 파일에 저장됩니다
		
		// 필요변수 선언
		int leftValue, rightValue;
		String operator;
		double result = 0.0;
		
		ArrayList<CalculatorResult> list = new ArrayList<>();
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in) );
		
		while( true ) {
			
			// 좌항입력 
			System.out.print("좌항을 입력하세요 : ");
			leftValue = Integer.parseInt( in.readLine() );
			// 연산부호 입력
			System.out.print("연산 부호를 입력하세요 : ");
			operator = in.readLine();
			// trim 메소드는 문자열 앞뒤에 있는 공백을 제거 (문자열 사이의 공백은 제거되지 않음)
			operator = operator.trim();
			// 우항입력
			System.out.print("우항을 입력하세요 : ");
			rightValue = Integer.parseInt(in.readLine());
			
			// 연산부호에 따른 연산
			switch(operator) {
				case "+": result = leftValue + rightValue; break;
				case "-": result = leftValue - rightValue; break;
				case "x": result = leftValue * rightValue; break;
				case "/": result = leftValue / (double)rightValue; break;
				case "%": result = leftValue % rightValue; break;
			}
			
			// 객체 생성
			CalculatorResult temp = new CalculatorResult(leftValue, rightValue, operator, result );
			// 객체를 리스트에 저장
			list.add( temp );  
			// 연산결과 출력
			System.out.println(temp);  
			
			System.out.print("계속하시겠습니까? (y/n) : ");
			char isExit = in.readLine().trim().charAt(0);
			if(isExit == 'n' || isExit =='N') break;
		}
		
		File dir = new File("D:\\JAVA01\\Java_se\\temp");
		if( !dir.exists() )dir.mkdirs();
		
		// 파일이름을 오늘 날짜 현재시간.dat 로 생성합니다.  파일이름 예 : 2022_10_25_17_00.dat
		Date now = new Date(); // 오늘 날짜를 담은 Date  객체 생성
		
		// 파일이름이 될 양식으로 SimpleDateFormat 객체 생성
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy_MM_dd_HH_mm" );
		
		// 오늘 날짜를 sdf 에 적용하고 뒤에 ".dat" 를 이어붙이기해서  String 데이터로 변환
		String fileName = sdf.format(now) + ".dat";  //모든 자료형은 String과 이어붙이기했을때 결과가 String 이 됩니다.
		// 2022_10_25_17_00.dat   생성완료
		
		File file = new File( dir, fileName);
		ObjectOutputStream oos 
			= new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
		oos.writeObject( list );
		
		oos.close();		

	}

}

















