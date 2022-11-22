package days20;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

class Car implements Serializable{
	private String carNumber;
	private String enterDateTime;
	private Date enterDateTime2;
	
	public String getEnterDateTime() {  return enterDateTime;  	}
	public void setEnterDateTime(String enterDateTime) {	this.enterDateTime = enterDateTime;	}
	public String getCarNumber() {	return carNumber;	}
	public void setCarNumber(String carNumber) {		this.carNumber = carNumber;	}
	
	Car( String carNumber){
		this.carNumber = carNumber; // 전달된 차량번호 저장
		enterDateTime2 = new Date();  // 오늘날짜 생성 & 멤버 변수에 저장
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm");
		enterDateTime = sdf.format(enterDateTime2) + "";  // 날짜시간을 String 으로 변환해서 저장
	}
	
	public String toString() {
		return this.carNumber + " # " + this.enterDateTime;
	} // 12가1234 # 2022-10-26_14:30  리턴
	
	public boolean equals( Object obj) {
		// 차량 번호가 같은 true 리턴   아니면 false 리턴
		if( !(obj instanceof Car) ) return false;
		Car target = (Car)obj;
		return this.carNumber.equals(target.carNumber);
	}
	
	public int payCount() throws ParseException {
		int pay = 0;
		
		Date now = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm");
		
		// 입차시간을 Date 로 변환  -> 밀리초로 환산
		Date enterD = sdf.parse(this.enterDateTime);  // String -> Date
		Calendar enterTime = Calendar.getInstance();
		enterTime.setTime( enterD );   // Date -> Calendar
		long e = enterTime.getTimeInMillis();   // Calendar -> MilliSecond
		
		// now 변수도 밀리초로 환산
		Calendar outTime = Calendar.getInstance();
		outTime.setTime( now );   // Date -> Calendar
		long n = outTime.getTimeInMillis();   // Calendar -> MilliSecond
		//now의 밀리초 - 입차시간 밀리초
		long dif = (n - e) / 1000;  // 초단위 계산
		
		// 그결과를 시 분 으로 환산
		int min = (int)( dif / 60.0 );  //  연산결과를 분단위로 환산
		int hour = (int)( min / 60.0 );  // 시 계산
		min = min % 60;   // 분계산
		min = min / 10;   // 10분단위로 환산 및 한자리분은 삭제
		
		// 주차비 시간당 2000원 10분당 400원으로 계산
		pay = hour*2000 + min*400;
		
		return pay;
	}
}

public class ParkingSystem {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, ParseException {
		
		Scanner sc = new Scanner(System.in);
		
		File dir = new File("D:\\JAVA01\\java_se\\parking");
		if( !dir.exists() )	dir.mkdirs();
		File file = new File(dir, "parking.dat");
		
		ArrayList<Car> list;  // 입차하는 차들이 저장될 리스트
		
		// 파일의 유무를 점검해서 파일이 있으면 읽어와서 list 에 저장
		// 파일이 없으면 최초 실행이므로 list에 새 ArrayList 를 생성
		if( file.exists() ) {
			ObjectInputStream ois 
				= new ObjectInputStream( new BufferedInputStream( new FileInputStream( file ) ) );
			list = (ArrayList<Car>)ois.readObject();
			ois.close();
		}else {
			list = new ArrayList<Car>();
		}
		
		while(true) {
			System.out.printf("1. 입차\t2. 출차\t3. 주차상황\t4. 종료\t");
			System.out.printf("입력>>");
			int input;
			input = Integer.parseInt( sc.nextLine() );
			if(input==4)break;  // 4번 입력시 while 문 종료  리스트를 파일에 저장후 프로그램도 종료
			
			switch(input) {
				case 1:
					enterCar(list);
					break;
				case 2:
					outCar(list);
					break;
				case 3:
					viewList(list);
				case 5:
					for(int i=0; i<list.size(); i++)
						list.get(i).setEnterDateTime("2022-10-25_23:30");
			}
		}
		System.out.println("프로그램이 종료합니다");
		ObjectOutputStream oos 
			= new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream( file )));
		oos.writeObject(list);  // 주차중인 차를 담고 있는 리스트를 파일에 저장
		oos.close();
	}
	
	
	public static void viewList(ArrayList<Car> list) {
		System.out.println("주차중인 차량 목록-------------------");
		// 한줄에 한대의 차량을 출력해주세요.  차량이 없으면 "주차중인 차량이 없습니다." 라고 출력합니다.
		if( list.size() == 0) 
			System.out.println("## 주차중인 차량이 없습니다. ##");
		else 
			for( Car c : list) 
				System.out.println( c );		
		System.out.println("\n");
	}
	
	
	public static void enterCar(ArrayList<Car> list) {
		// 차량번호를 입력받고, 객체를 생성해서, list 에 저장
		// 주차중인 차량의 댓수가 10이면 "만차입니다"라고 출력 및 종료
		if( list.size()==10) {
			System.out.println("만차입니다. 더이상 주차할 수 없습니다");
			return;
		}
		
		// 차량번호 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("입차 : 차량번호를 입력하세요 -> ");
		String num = sc.nextLine();
		
		// Car 객체 생성 : 차량번호를 전달인수로 전달하는 생성자 호출
		Car c = new Car(num);
		list.add(c); // 리스트에 차량 추가
	}
	
	
	
	public static void outCar(ArrayList<Car> list) throws ParseException {
		// 리스트 사이즈가 0이면 출차할 차가 없습니다 라는 메세지와 함께 메서드 종료
		if(list.size()==0) {
			System.out.println("출차할 차가 없습니다");
			return;
		}
		
		// 차량 번호 입력(뒤 숫자 네자리만 입력)
		System.out.print("출차할 차량의 번호 뒷자리 4자리를 입력하세요");
		Scanner sc = new Scanner(System.in);
		String num = sc.nextLine();
		
		// 입력받은 차번호로 주차된 차량의 번호뒤4자리와 비교해서 같은 차량이 있으면 모두 출력 후 선택하게 합니다.
		
		// 뒷자리 4자리가 같은 차량을 담을 배열을 따로 생성합니다
		Car [] cars = new Car[10];
		for(int i=0; i<list.size(); i++)
			// 입력한 차번호를 리스트에 있는 차량의 번호가 포함하고 있다면
			if( list.get(i).getCarNumber().contains(num) ) 				
				cars[i] = list.get(i);   // 현재 차량의 저장되 리스트 주소값을 cars 배열의 같은 위치에 저장
		
		if( cars.length == 0) {
			System.out.println("찾는 차량이 없습니다");
			return;
		}
		
		for(int i=0; i<cars.length; i++) {
			if(cars[i]!=null)   // cars 배열값들중 널이 아닌것들만 화면에 번호와 함께 출력
				System.out.println( (i+1) + ". " + cars[i].toString() );
		}
		
		// 출력된 리스트(1개 이상) 에서 출차할 차량의 순번 입력
		System.out.println("출차할 차의 주차 순번을 입력하세요");
		int k = sc.nextInt();
				
		// 요금 계산
		int pay = cars[k-1].payCount();
		// 요금 출력
		System.out.println("주차 요금은 " + pay + "원입니다");
		// 출차
		list.remove(k-1);
	}
	
	
}







