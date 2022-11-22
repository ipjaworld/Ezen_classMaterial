package days11;

class Person{
	String name;
	int age;
	String phone;
	
	// 멤버 메서드
	// 멤버 메서드의 제작 목적 #1 : 자꾸 반복되어서 쓰지귀찮은 코드들을 따로 작성해서 이름 불러 쓰려고...
	public void output() {
		System.out.println("이름 : " + name + "  나이 : " + age + "  전화번호 : " + phone);
	}
	//output 메서드의 목적은 멤버변수값을 지정한 양식에 맞춰 출력하는 목적으로 제작되었습니다.
	// 클래스안에 제작된 메서드는 객체들만 이용할수 있는 객체 전용 메서드 입니다.

	public void input() {
		
		name = "홍길동";
		age = 25;
		phone = "010-1111-2222";
		
	}
	public void input(String n, int a, String p) {
		
		name = n;
		age = a;
		phone = p;
		
	}
	
}
public class Class002 {

	public static void main(String[] args) {
		
		Person p1 = new Person();
		Person p2 = new Person();
		Person p3 = new Person();
		//System.out.println("이름 : " + p1.name + "  나이 : " + p1.age + "  전화번호 : " + p1.phone);
		//System.out.println("이름 : " + p2.name + "  나이 : " + p2.age + "  전화번호 : " + p2.phone);
		//System.out.println("이름 : " + p3.name + "  나이 : " + p3.age + "  전화번호 : " + p3.phone);
		p1.output();
		p2.output();
		p3.output();
		// output(); //에러 - output 메서드는 객체전용메서드 이므로 호출객체 없이 단독으로 사용할 수 없습니다.
		
		//p1.name = "홍길동";
		//p1.age = 25;
		//p1.phone = "010-1111-2222";
		p1.input();
		
		//p2.name = "홍길동";
		//p2.age = 25;
		//p2.phone = "010-1111-2222";
		p2.input();
		
		//p3.name = "홍길동";
		//p3.age = 25;
		//p3.phone = "010-1111-2222";
		p3.input();
		
		p1.output();
		p2.output();
		p3.output();
		
		p2.input("홍길남", 30, "010-1111-2223");
		p3.input("홍길서", 15, "010-1111-3333");
		
		p1.output();
		p2.output();
		p3.output();
	}

}
