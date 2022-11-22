package days12;

import java.util.Calendar;

// Singleton pattern
// new 인스턴스를 만들려고 할때마다  새롭게 인스턴스가 만들어지는것이 아니라
// 미리 만들어놓은 인스턴스를 새로 만들어지는 객체들이 공유해서 사용하게 하는 패턴

// 멤버변수들이 스태틱변수가 아니면서, 각 객체들이 공유해서 일관된 값을 가져야한다면, 
// 덧붙여서 객체도 굳이 두개이상 만들필요가 없는 상황이라면, 
// 하나의 인스턴스를 만들고, 그주소를 새로 만들어지는 참조변수들이 공유해서 사용하게 합니다

class SingletonEx{
	int n1; 
	int n2;
	
	// 1. 생성자를 private 으로 보호합니다
	private SingletonEx() {
	}
	//2. 클래스 내부에서 생성자를 호출해서 객체하나(new 인스턴스)를 생성합니다. (private, static)
	private static SingletonEx itc = new SingletonEx();
	// 접속자(이용자)가 많을수 있고, 언제 들어올지 모르기때문에 미리 하나 만들어서 공유하게 합니다.
	
	// 3. 생성해놓은 객체의 참조변수값을 리턴하는 public 형의 메서드를 생성합니다.
	public static SingletonEx getInstance() {
		return itc;
	}
}
public class Class26 {

	public static void main(String[] args) {
		// SingletonEx m1 = new SingletonEx();  // 생성자가 private 이므로 이는 에러입니다
		SingletonEx m1 = SingletonEx.getInstance();
		SingletonEx m2 = SingletonEx.getInstance();
		SingletonEx m3 = SingletonEx.getInstance();
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
		
		m1.n1 = 150;
		m2.n2 = 200;
		System.out.println(m3.n1 + " " + m3.n2);
		
		// 생성자가 private 로 보호되어 main 메서드 안에서 new SingletonEx()로 새로운 객체 생성이 되지 않습니다. 
		// SingletonEx s1 = new SingletonEx(); 에러
		// 싱글톤 방식은 클래스내부에 유일한 객체(itc)를 생성해두고(private static 으로 생성) 
		// public static 으로 만들어진 getInstance() 메서드를 호출하여 itc(생성한 객체)를 리턴받아 객체를 사용합니다
		// 생성자 매서드는 static 인스턴스 itc 만들때 최초 실행된 때 말고는 실행되지 않습니다
		// 주로 유지되어야 할 정보와 매서드를 많이 갖고 있는 클래스에서 많이 사용됩니다
		// 두개의 객체가 유지되면 부담스러운 부분을 하나로 공유하고 필요한 내용을 멤버 변수로 해결하는 방식입니다
		// 싱글턴 패턴이 구현된 클래스의 활용
		// 날짜, 시간에 관련된 정보를 제공하는 Calendar 클래스 : 
		// 클래스 싱글턴 패턴이 구현되어 new 인스턴스를 사용하여 객체생성이 안됩니다
		//반드시 getInstance 메소드를 사용하여야 합니다.
		
		// Calendar cal = new Calendar();
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		
		// 싱글턴은 공동 요소가 많고, 메서드를 주로 공유해서 사용할때 많이 사용합니다.
		
		
		
		
		/*
		SingletonEx m1 = new SingletonEx();
		SingletonEx m2 = new SingletonEx();
		
		SingletonEx m3 = m1; // 같은 주소값으로 하나의 인스턴스를 공유하는 방법
		
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
		// 만들어진 객체의 참조변수를 바로 print로 출력하면
		// 패키지이름.클래스이름@해시코드
		// 해시코드 : 중복된 값이 나오지 않게 하기위해 실행된 알고리즘코드에의 해 나온 결과 값
		 */
		
		
	}

}







