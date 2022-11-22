package days13;
class Human{
	private String name;
	private int age;
	public Human(String name, int age) {	
		this.name = name;	
		this.age = age;
	}
	public String toString() {
		// "이름:XXX 나이:@@"
		String str = "이름 : " + this.name + ", 나이 : " + this.age;
		return str;
		// return "이름 : " + this.name + ", 나이 : " + this.age;
	}
	
	// 오버라이딩 되는 메서드의 조건 : 리턴값의 유형, 매개변수의 유형-갯수-순서가 같아야 합니다
	// equals 메서드는 어떤 클래스 내부에서도 오버라이딩 될 준비를 해야하므로
	// 매개변수를 모든 클래스가 전달 가능하도록 모든 클래스의 부모클래스인 Object 자료형으로 정해져 있습니다.
	public boolean equals( Object obj ) {
		// s1.equals(s2);    
		// this <- s1    obj <- s2
		// this.name와  obj.name의 비교, this.age 와  obj.age 의 비교
		// obj는 부모참조변수이므로 자식클래스의 멤버변수에 접근이 안됩니다.
		// 접근하려면 다시 Human 형으로 변환(강제캐스팅)을 해야합니다.
		
		// Human이 아닌 다른 클래스의 인스턴스 주소가 전달인수로 전달되었다면, 바로 return false로 메서드 종료
		if( !(obj instanceof Human) ) return false; 
		// if문 조건이 false 여서... 지나쳤으면 형변환
		Human  target = (Human)obj;
		
		//  아까와는 사정이 달라졌어요
		// this.name와  taget.name, this.age 와  target.age 를 비교합니다
		boolean flag_name = this.name.equals(target.name);
		boolean flag_age = this.age == target.age;
		boolean result = flag_name && flag_age;
		
		return result;
	}
	
	
	
}
public class Extends09_Object04 {

	public static void main(String[] args) {
		
		Human s1 = new Human("홍길동", 21);
		Human s2 = new Human("홍길동", 21);
		Human s3 = new Human("홍길서", 22);
		System.out.println("Human1의 정보 - " + s1);
		System.out.println("Human2의 정보 - " + s2);
		System.out.println("Human3의 정보 - " + s3);
		
		// 레퍼런스 변수들간의 비교
		if( s1 == s2 )	
			System.out.println("s1 변수와 s2 변수는 같습니다.(s1==s2)");
		else	
			System.out.println("s1 변수와 s2 변수는 다릅니다.(s1==s2)");
		// 결과 : s1 변수와 s2 변수는 다릅니다.(s1==s2)
		
		/*
		// .equals 메서드를 사용하여 비교(equals 메서드 오버라이드 이전)
		if( s1.equals(s2) )	
			System.out.println("s1 변수와 s2 변수는 같습니다.(s1.equals(s2))");
		else	
			System.out.println("s1 변수와 s2 변수는 다릅니다.(s1.equals(s2))");
		// 결과 : s1 변수와 s2 변수는 다릅니다.(s1.equals(s2))
		// Object 클래스의 equals 메소드는 기본적으로 두 객체의 레퍼런스 값을 비교하는 연산만을 수행합니다
		*/
		
		// equals 메서드를 사용하여 비교(equals메서드 오버라이드 이후)
		if( s1.equals(s2) )	
			System.out.println("s1 변수와 s2 변수는 같습니다.(s1.equals(s2))");
		else	
			System.out.println("s1 변수와 s2 변수는 다릅니다.(s1.equals(s2))");
		
		if( s1.equals(s3) )	
			System.out.println("s1 변수와 s3 변수는 같습니다.(s1.equals(s3))");
		else	
			System.out.println("s1 변수와 s3 변수는 다릅니다.(s1.equals(s3))");
		
	}

}






