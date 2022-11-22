package days13;

// Object 클래스의 equals 메서드 : 객체간의 비교를 위해서 사용되는 메서드
// Object 가 상속한 메서드들 중 toString과 함꼐 가장 많이 오버라딩 되는 메서드

public class Extends09_Object03 {

	public static void main(String[] args) {
		
		// 일반적, 기본 자료형들의 갑의 비교는 비교연산자(==)를 사용합니다
		int n1 = 10;
		int n2 = 10;		
		if( n1 == n2 )	System.out.println("n1 변수와 n2 변수는 같습니다.");
		else 	System.out.println("n1 변수와 n2 변수는 다릅니다.");
		
		String s1 = "Hello";
		String s2 = "Hello";
		if( s1 == s2 )	System.out.println("s1 변수와 s2 변수는 같습니다.");
		else	System.out.println("s1 변수와 s2 변수는 다릅니다.");
		
		// Object 클래스안의 equals 메서드는 참조변수값들끼리 비교하도록 제작되어 있습니다.
		// String 클래스 안의 equals 메서드는 글자들끼지 비교하도록 오버라이딩 되어 있습니다.
		// s1 == s2 연산의 결과가 true 라는건  글자가 같아서 true가 아니고, 참조값이 같아서 true 라는 뜻입니다
		
		// String s1 = "Hellow";   최초 String 데이터가 새로운 공간에 저장되고 그 주소가 s1에 저장됩니다
		// 그러나 String s2 = "Hello"; 가 실행되면, 새공간이 만들어지는것이 아니라 , Heap 에 저장된 "Hello" 의 
		// 주소를 s2 저장합니다.    new 명령이 없어서 있는 자료를 재활용한 셈입니다.
		
		String s3 = new String("Hello");
		String s4 = new String("Hello");
		if( s3 == s4 )	System.out.println("s3 변수와 s4 변수는 같습니다.");
		else	System.out.println("s3 변수와 s4 변수는 다릅니다.");
		// 결론 : (==) 이 연산자는 클래스 멤버인 글자들의 비교가 아니라, 레퍼런스 주소들의 비교입니다.
		
		if( s3.equals(s4) )
			System.out.println("s3 변수와 s4 변수는 같습니다.(equals)");
		else	
			System.out.println("s3 변수와 s4 변수는 다릅니다.(equals)");
		// 참조값이 다른 객체라도 equals를 이용한다면 실제 저장된 멤버값들을 비교하여 같은지 같지 않은지를 확인할수 있습니다
		
		Point p1 = new Point(20,30);
		Point p2 = new Point(20,30);
		if( p1==p2 )
			System.out.println("p1 변수와 p2 변수는 같습니다.(==)");
		else	
			System.out.println("p1 변수와 p2 변수는 다릅니다.(==)");
		
		if( p1.equals(p2) )
			System.out.println("p1 변수와 p2 변수는 같습니다.(equals)");
		else	
			System.out.println("p1 변수와 p2 변수는 다릅니다.(equals)");
		
		// equals 메서드는 Object 클래스의 메서드로서 최초는 레퍼런스값(주소)들의 비교를 정의하고 있습니다.
		// String 클래스는 이미 equals 메서드를 실제값의 비교로 오버라이딩 되어 있으며
		// 기타 다른 사용자 정의 클래스(Point)에서는 별도로 equals 를 실제값으로 비교하도록 오버라이딩 해줘야 합니다
	}

}








