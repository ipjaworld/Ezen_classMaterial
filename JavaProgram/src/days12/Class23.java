package days12;

class Mymath{
	int a, b;
	static int c = 0;
	Mymath(){
		c++;
	}
	
	// static 변수, static 메서드,  인스턴스 변수 , 인스턴스 메서드
	
	// 인스턴스 메서드에서는 인스턴스 변수들에 자유롭게 접근이 가능합니다.
	int add() { 
		return a+b;
	}
	int subtract() {  return a-b; }
	int multiply() {  return a*b; }
	double divide() {  return a/(double)b; }
	
	// 인스턴스 메서드들은 static 멤버변수에도 자유롭게 접근이 가능합니다.
	public void init() {
		a = c * 20; 
		b = c * 30;
	}
	
	// static 메서드들은 인스턴스 변수에 접근이 불가능합니다
	public static int add(int c, int d) {
		// return a+b+c+d;
		return Mymath.c + c +d;
	}
	// 스태틱 메서들은 스태틱 변수에 자유롭게 접근이 가능합니다.
	static int subtract(int e, int d) {return e-d+c;}
	static int multiply(int e, int d) {return e*d+c;}
	static double divide(double e, double d) {return e/d+c;}
}

// 인스턴스 메서드 -> 인스턴스 변수 O
// 인스턴스 메서드 -> static 변수 O
// static 메서드 -> 인스턴스 변수 X
// static 메서드 -> static 변수 O
//  -> : 변수 접근 가능/불가능

public class Class23 {

	public static void main(String[] args) {
		Mymath mm = new Mymath();
		mm.init();
		// 인스턴스 메서들은 멤버변수들을 이용할수 있기때문에 별도의 전달인수 없이 연산이 가능합니다.
		System.out.println( mm.add() );  
		System.out.println( mm.subtract() ); 
		System.out.println( mm.multiply() ); 
		System.out.println( mm.divide() );   
		// 매개변수로와 스태틱변수로 연산 : 필요한 값들을 전달인수로 전달해서 연산합니다
		System.out.println( Mymath.add(10, 30) );  
		System.out.println( Mymath.subtract(10, 30) ); 
		System.out.println( Mymath.multiply(10, 30) ); 
		System.out.println( Mymath.divide(10, 30) );  
		
		
	}

}
