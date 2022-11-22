package days11;

//this 의 용도 #1
//: 멤버메서드내에 존재하면서, 메서드를 호출하는 호출객체의 레퍼런스값을 저장하는 숨어있는 레퍼런스 변수

//this 의 용도 #2
//: 오버로딩 되어 있는 생성자들 간 서로를 재호출 하기위한 이름으로 사용.
//: 호출하는 형태(매개변수의 형태)데로 생성자가 오버라이딩 되어 있어야 사용가능

class ThisB{
	private int num1;
	private int num2;
	private int num3;
	
	ThisB(int n){  // 생성자1
		num1 = n;
		System.out.println("ThisB클래스의 생성자1이 호출되었습니다.");
	}
	ThisB(int n1, int n2) {  // 생성자2
		// num1 = n1;
		// ThisB(n1);
		this(n1);  // this 라는 이름으로 전달인수를 하나 넣어서 메서드 호출하듯 쓰며, 매개변수가 한개인 생성자가 호출됩니다
		num2 = n2;
		System.out.println("ThisB클래스의 생성자2가 호출되었습니다.");
	}
	public ThisB(int n1, int n2, int n3) {
		this(n1, n2);
		num3 = n3;
		System.out.println("ThisB클래스의 생성자3이 호출되었습니다.");
	}
}
public class Class17 {

	public static void main(String[] args) {
		ThisB b1 = new ThisB(10);
		System.out.println();
		ThisB b2 = new ThisB(10,20);
		System.out.println();
		ThisB t3 = new ThisB(10,20,30);
	}

}
