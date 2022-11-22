package days11;

// 생성자 메서드 (constructor)
// 생정자도 매서드입니다.
// 객체가 선언되는 시점에 딱 한번 호출됩니다.  그 외에 는 호출되지 않습니다
// new 명령과 함께 객체가 새로운 공간을 만들고 저장되도록 해줍니다
// 클래스이름과 생성자 메서드의 이름은 같습니다
// 리턴값이 없습니다.

// 내가 따로 기술하지 않아도 내부에 이미 존재하고 있는 메서드입니다

class Tiger{
	private String name;
	private int age;
	private String phone;
	
	//1.2  Tiger() 메서드가 따로 기술되지 않아도 호출이 가능합니다.
	//2. 따로 기술하지 않아도 호출가능한건 따로 기술해도 가능하다는 뜻입니다
	//		다만 따로 기술하되 아무것도 명령을 넣지 않으면, 따로 기술하지 않은것과 같습니다 
	// Tiger(){ }
	
	// 3. 따로 기술한다는건 주로 멤버변수의 초기값을 주기 위해서 많이 사용됩니다.
	//        생성자도 메서드이므로 매개변수가 있을수 잇습니다
	Tiger( String name, int age, String phone){
		this.name = name;
		this.age = age;
		this.phone = phone;
		System.out.println("Tiger class의 매개변수가 있는 생성자 호출");
		// 생성자의 고유기능 외에 추가로 실행할 명령이 쓰여지고, 멤버변수의 값을 초기화하고자 할때 사용합니다.
	}
	
	// 4. 생성자가 안에서 밖으로 꺼내져 와서 매개변수가 있는 생성자로 재정의 되는 순간
	// 숨어있던 매개변수 없는 디폴트 생성자는 없어집니다.(매개변수 있는 생성자로 대체)
	// 매개변수가 없는 디폴트 생성자도 사용하려면   오버로딩해서 사용합니다
	public Tiger() {
		name = "야옹이";
		age = 10;
		phone = "010-8888-7777";
	}
	
	public Tiger(int a, int b, int c, int d, String k) {
		// 생성자의 매개변수에 반드시 멤버변수에 필요한 값들만 선언되어야하는것은 아닙니다
		// 보통 멤버변수에 필요한 값드이 매개변수에 전달되도록 하는것이 보통입니다
		
		// 생성자 또는 메서드의 오버로딩은 필요에 따라 제작하는 것을 권장하며, 
		// 호출되지 않을 생성자와 메서드의 오버로딩은 만들지 않는 것을 권장합니다
	}
	
	void init(String name, int age, String phone) {
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
	
	
}

public class Class005 {

	public static void main(String[] args) {
		// 1.1  생성자를 따로 기술하지 않아도 이미 존재하는 메서드라서 에러없이 호출이가능합니다
		Tiger t1 = new Tiger();
		// 배열 생성시 int [] a = new int[5];  라고 쓰듯이  객체생성이 비슷하게 이루어집니다
		
		Tiger t2 = new Tiger("야옹이", 10, "010-7777-8888");
		
		

	}

}
