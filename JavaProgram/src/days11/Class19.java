package days11;
//static 키워드
//멤버변수, 멤버메서드에 적용할 수 있는 키워드
//정적 변수(클래스의 변수), 정적 메소드(클래스의 메소드)를 선언할 때 사용

//자바프로그램의 구동 과정
//1. JVM에 의해서 실행할 모든 클래스 중, static 메소드, static 멤버필드를 수집해서 
//    메모리에 로딩되고, 프로그램의 시작(main메소드의 실행)전에 메모리에 적재됩니다
//2. 메모리에 로딩된 static 메소드 중, main 이름을 검색
//3. main 메소드가 검색되었다면 JVM 해당 main 메소드를 호출하여 프로그램을 시작합니다


// static 변수/메서드의 특징
// 프로그램 실행전부터 메모리에 자리를 확보하고 실행되기를 기다리는 변수/메서드 

// static 이 아닌 변수 메서드의 특징
// Student std = new Student() 와 같은 객체생성 명령이 있어야 그제서야 객체 안에 만들어지는 변수/메서드

class StaticA{
	int num;  // 인스턴스 변수 - 멤버변수이면서 static 이 아닌 변수(동적 멤버변수)입니다
	static int number = 100; // static 변수 - 얘도 멤버변수입니다.  static 멤버변수(정적 멤버변수)입니다
	// 스태틱 변수는 프로그램 실행전(객체가 만들어지기 전)에 먼저 생성되어서 사용할 준비가 완료되는 변수입니다.
	// 객체 생성과 상관없이, 만들어지는 객체의 갯수와도 상관없이 딱한개 만들어지는 변수
	// 그를 둘러싼 클래스에 소속되어 사용되지만, 객체와는 독립적으로 사용됩니다.
}
public class Class19 {

	public static void abcd() { } 
	// 다른 클래스에서는 안그런데 main 메서드가 포함된 클래스에서 메서드를 추가하면 유독 static을 붙여서 제작한 이유
	//   - main에서 호출할꺼니까 
	//   - 미리 메모리에 적재된 main 안에서 호출해서 사용하려면 그 호출대상도  메모리에 적재되어 있어야 합니다
	//   - 그럴려면 어쩔수 없이 static 으로 제작....
	
	public static void main(String[] args) {
		// 1. 정적멤버변수(static멤버변수)는 객체의 생성 유무와상관없이 그 변수를 사용할 수가 있습니다
		//     스태틱 변수는 main 메서드 실행전에 , 객체생성 전에 미리 생성되어 있는 변수, 객체와는 독립적이면서, 
		//     클래스에는 종속적으로 사용하도록 생성됩니다. 
		//     객체를 생성하지 않고도 사용할 수 있는 클래스의 멤버변수입니다.
		//     다만 "클래스외부"에서 static 변수에 접근하려면 아래와 같이 클래스 이름과 함께 사용합니다.
		System.out.println("StaticA 클래스의 정적 멤버변수 값 : " + StaticA.number);
		// Math.random()   Integer.parseInt()   
		
		// 2. 동적멤버변수(인스턴스멤버변수)는 객체가 반드시 생성되어야 그 변수를 사용할 수가 있습니다
		StaticA a1 = new StaticA();
		a1.num = 100;
		System.out.println("a1  객체의 동적 멤버변수 값 : " + a1.num);
		
		
		// 3. 인스턴스 변수는 객체 생성마다 만들어져서 객쳇의 갯수 만큼 생성되지만, 스태틱변수는 프로그램 전체를 통틀어
		//   한개만 만들어지고   그 값도 객체와 상관없이 현재값이 변경전 또는 프로그램 끝날때까 유지됩니다.
		StaticA a2 = new StaticA(); 
		a2.num = 200;
		System.out.println("a2  객체의 동적 멤버변수 값 : " + a2.num);
		StaticA a3 = new StaticA(); 
		a3.num = 300;
		System.out.println("a3  객체의 동적 멤버변수 값 : " + a3.num);
		StaticA.number = StaticA.number + 50;  // 스태틱 변수값의 변경
		System.out.println("StaticA 클래스의 정적 멤버변수 값 : " + StaticA.number);  
		// 원래값 100 에 50이 합산
		
		// 4. 인스턴스변수와 마찬가지로 private 으로 보호 되지 않았다면 아래와 같이 임의 접근이 가능하고
		StaticA.number = 10;
		System.out.println("StaticA 클래스의  정적 멤버변수 값 : " + StaticA.number);
		// private로 보호된 static 변수는  static 메서드를 따로 제작해서  값을 저장하거나 얻어 냅니다.
		// static  이 아닌 인스턴스 메서드에서는 static 멤버 변수/메서드의 접근이 불가능합니다.
		
		
		
	}

}
