package days12;

//접근지정자와 상속
class SuperA{
	private int n1;	
	// private : 현재 클래스 내에있는 멤버 메서드를 통해서만 접근 가능한 완전은닉 n1
	public int getN1() {		return n1;     	}
	// 자식 클래세 만들어진 getN1은 에러이지만, 부모클래스에서 만들어진 getN1은 에러가 아닙니다
	// 이는 상속되어져서 자식클래스에 있는걸로 인식될 예정이며, 
	// public 이므로 어디서든 객체가 생성되면 자유롭게 호출이 가능하빈다.
	public int n2;  // public:어디서든 자유롭게 접근 가능
	
	int n3;
	// 접근 지정을 아무것도 하지 않은 멤버 : default 로 지정됩니다
	// 동일한 패키지 내부에서는 public으로 동작, 다른 패키지에서는 private 으로 동작합니다.
	
	protected int n4;
	// 자식 클래스에서는 public 과 같으며, 외부로 부터는 private 로 작동합니다
	
}
class SubA extends SuperA{
    // 부모클래스의 private 멤버는 아무리 자식 클래스여도 접근할 수 없는 멤버입니다.
	// public int getN1() {		return n1;     	}
	
	public void printInfo() {
		// System.out.println(this.n1); //에러
		// 부모클래스의  private 멤버는 access 할 수 없습니다
		
		int n5 = getN1();
		System.out.println( "부모의 public 멤버를 이용한 prinvate n1 접근 : " + n5);
		// public으로 생성된 멤버 메서드를 이용하면 부모의 private 멤버에도 access가 가능합니다
		System.out.println("부모의 public 멤버변수 n2 접근: " + this.n2);
		// 부모의 public 멤버는 자유롭게 접근이 가능합니다.
		
		System.out.println("부모의 default 멤버변수 n3 접근: " +this.n4);
		// 부모클래스의 protected 는 자식클래스에게  public  과 같습니다
		
		System.out.println("부모의 protected 멤버변수 n4 접근: " +this.n4);
		// 부모클래스의 protected 는 자식클래스에게  public  과 같습니다		
	}
}

public class Extends03 {

	public static void main(String[] args) {
		SubA a = new SubA();
		a.printInfo();
		a.n3 = 20;
		a.n4 = 30;
		System.out.println( "부모의 default 멤버 n3 : "+ a.n3);
		System.out.println( "부모의 protected 멤버 n4 : "+ a.n4);
	}

}
