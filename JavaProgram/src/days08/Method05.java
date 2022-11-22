package days08;

public class Method05 {

	public static void main(String[] args) {
		
		int num = 100;
		System.out.println("main 메서드내의  num 변수 값 : " + num);
		
		updateValue(num); // updateValue 메서드 호출
		// 메서드 호출시 전달인수로 사용하는 변수는 변수가 저장한 값의 복사본을 전달인수로 보낸다는 뜻이며
		// 호출된 메서드에서 전달값을 변경하더라도  호출한곳의 변수값에는 영향을 줄 수 없습니다.
		System.out.println("main 메서드내의  num 변수 값 : " + num);
	}
	
	public static void updateValue(int num) {	
		num = 200;
		System.out.printf("updateValue  메서드 내의 num 변수 값 : %d\n", num);
	}
	// 1. 메서드 호출할때 전달인수로 넣어주는 변수와 updateValue 메서드 영역의
	//     매개변수로 쓰이는 변수의 이름 같아도 상관없습니다.
	//     위에서 언급한 두변수는 지역변수라고 부르며, 서로 다른 변수로 사용됩니다.
	// 2. 전달인수의 변수값이 매개변수 변수로 "값"만 전달되는 방식을
	//     Call by Value 라고 부릅니다

}
