package days15;

//인터페이스는 멤버필드로 public static final 멤버만 가질 수 있습니다.
//인터페이스는 멤버메소드로 public abstract 메소드만 가질 수 있습니다.

interface InterB{
	// 인터페이스 내에 선언되는 멤버 변수 : static final
	public static final int n1 = 1;
	public static final int n2 = 2;
	// 인터페이스 내부에 선언되는 멤버 필드는 public static final 을 생략할 수 있습니다.
	int n3 = 3; // static final 변수는 반드시 선언시점에 값이 초기화되어야 에러가 없습니다
	
	// 인터페이스 내에 선언되는 멤버 메서드 : abstract 
	public abstract void test1();
	public abstract void test2();
	// 인터페이스 내부에 선언되는 메소드는 public abstract 을 생략할 수 있습니다.
	void test3();
	
}
public class Interface02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
