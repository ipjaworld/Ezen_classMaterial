package days12;
// 인스턴스 메서드안에서 인스턴스 메서드 호출 O
// 인스턴스 메서드안에서 static 메서드 호출 O
// static 메서드안에서 인스턴스 메서드 호출 X
// static 메서드안에서 static 메서드 호출 O

class MemberCall{
	
	// 인스턴스 변수 : 객체가 생성될때 생성되는 변수
	int iv = 10;  
	
	// static 변수 : 프로그램이 시작될때 생성되는 변수
	static int sv = 20;
	
	// 인스턴스 변수는 스태틱 변수값으로 초기화가 가능
	int iv2 = sv;
	
	// 스태틱 변수는 인스턴스 변수값으로 초기화가 불가능
	// static int sv2 = iv;  // 에러
	// 에러 : iv 가 언제 생성될지 모르므로, sv2에 값을 전달할수없음.
	
	// 억지로 인스턴스 변수로 static변수를 초기화하려면
	static int sv2 = new MemberCall().iv;
	// 억지로라도   인스턴스(멤버)변수로   스태틱 변수의 값을 초기화하고자 한다면 위와 같은 방법을 씁니다. 
	// 레퍼런스 변수 없는 new 인스턴스를 만들어서 멤버변수 사용.
	
	static void staticMethod() {
		System.out.println(sv);//스태틱 메서드는 스태틱 변수를 사용할 수 있습니다.
		// System.out.println(iv);  // 에러 - 스태틱 메서드는 인스턴스 변수를 사용할수 없습니다
		System.out.println( new MemberCall().iv );
		//억지로라도 스태틱 메서드가 인스턴스 필드를 사용하려면 객체를 만들고 사용가능
		
		staticMethod2();  // 스태틱 메서드에서는 스태틱 메서드 호출이 가능합니다.
		// intanceMethod2();  // 에러 - 스태틱 메서드에서는 인스턴스 메서드 호출이 불가능합니다
		new MemberCall().intanceMethod2();   //  이와 같은 호출은 가능합니다
		
	}
	void instanceMethod1() {
		System.out.println(sv); // 인스턴스 메서드는 스태틱 변수를 사용할 수 있습니다
		System.out.println(iv); // 인스턴스 메서드는 인스턴스 변수를 사용할 수 있습니다.
		staticMethod2();  // 인스턴스 메서드에서는 스태틱 메서드 호출이 가능합니다.
		intanceMethod2();  // 인스턴스 메서드에서는 인스턴스 메서드 호출이 가능합니다
	}
	
	static void staticMethod2() {}
	void intanceMethod2() {}
	
}
public class Class24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
