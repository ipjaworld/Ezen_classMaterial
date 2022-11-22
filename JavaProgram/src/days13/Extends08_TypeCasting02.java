package days13;
class SuperE{
	int superNum;
	void abc() { 
		System.out.println("super method"); 
	}
}
class SubE extends SuperE{
	int subNum;
	void abc() { 
		System.out.println("sub method"); 
	}
}
public class Extends08_TypeCasting02 {

	public static void main(String[] args) {
		
		// 부모클래스의 객체 생성
		SuperE super1 = new SuperE();
		// 자식 클래스의 객체 생성
		SubE sub1 = new SubE();
		
		// 객체간의 TypeCasting  #1
		// 부모클래스의 참조변수에 자식클래스의 인스턴스 주소는 아무런 조치 없이 저장 가능합니다
		// 부모참조변수  <- 자식 인스턴스의 주소  OK
		super1 = sub1;  // 자식 클래스 인스턴스의 주소 저장.  자동캐스팅(스마트 캐스팅)
		SuperE super2 = new SubE();  // 새인스턴스의 주소 저장  
		
		
		// 객체간의 TypeCasting  #2
		// 자식클래스의 참조변수에 부코클래스의 인스턴스의 주소는 아무런 조치 없이 저장할 수 없습니다.
		// 자식참조변수 <- 부모 인스턴스의 주소 X
		// SubE sub2 = new SuperE();  // 에러
		SuperE super3 = new SuperE();
		// SubE sub2 = super3;  // 에러
		
		
		// 객체간의 TypeCasting  #3
		// 자식클래스의 참조변수에 부코클래스의 인스턴스 주소를 그래도 저장하고 싶다면 강제캐스팅을 이용할 수는 있습니다
		SuperE super4 = new SuperE();
		// SubE sub4 = (SubE) super4;  //런타임 에러
		// 코드 작성상에는 문제가 없으나, 프로그램을 실행하면 에러가 발생합니다.
		// 부모인스턴스가 강제캐스팅(SubE)를 앞에 두고 아무리 자식인척해도  언제는 부모인게 들통난다는 뜻입니다.
		
		
		// 객체간의 TypeCasting  #4
		// 만약 앞의 #3에서 super4 참조변수가 저장하고 있는 인스턴스 주소가 자식 인스턴스 주소였다면,
		// (부모클래스 참조변수는 자식클래스 인스턴스 주소를 저장할 수 있습니다.)
		// 그렇다면  SubE sub4 = (SubE) super4;  이코드는 정상 실행합니다.
		// 결과적으로 자식인스턴스 주소를 자식 참조변수에 저장한 셈이 되므로 정상 실행
		SuperE super5 = new SubE();  // 부모참조변수 <- 자식 인스턴스 주소
		SubE sub5 = (SubE)super5;   // 자식참조변수 <- (부모참조변수 <- 자식 인스턴스 주소)
		
		// 자식 레퍼런스 <- (타입캐스팅) 부모레퍼런스 <- 자식 인스턴스의 주소
		// 자식 레퍼런스 <- (타입캐스팅) 부모레퍼런스 <- 부모 인스턴스의 주소 - 러타임에러
		// 자식인스턴스 주소가 부모참조변수에 저장될때는 문제가 없지만  다시 나와서 자식참조변수에 저장될때는
		// 강제캐스팅이 반드시 필요합니다.
		
		// 객체간의 TypeCasting  #5
		// #1에서 자식인스턴스 주소를 저장한 부모참조변수는  부모클래스에서 물려준 멤들에만 접근이 가능합니다
		SuperE super6 = new SubE();  // 부모참조변수 <- 자식인스턴스주소
		super6.superNum = 100;  // 부모가 물려준 멤버변수 자유롭게 사용가능
		// super6.subNum = 200;  // ★★★★★ 에러 .  자식 멤버변수에는 접근이 불가능합니다.
		super6.abc();   // ★★★★★ 부모클래스 메서드보다 재정의된 자식클래스 매서드가 우선 실행됩니다.
		
		// 부모참조변수로 접근이 불가능한 자식멤버변수를 사용하려면...
		//   -> 저장된 자식인스턴스 주소를 자식 참조변수에 옮겨담고 접근하는 수 밖에 없습니다
		SubE sub6 = (SubE)super6;
		sub6.subNum = 300;
		
		
		// 객체간의 TypeCasting  #6
		// #4 에서 있었던    "자식 레퍼런스 <- (타입캐스팅) 부모레퍼런스 <- 부모 인스턴스의 주소 - 러타임에러"
		// 이에러를 방지하는 방법.
		SuperE super81 = new SubE();
		SuperE super82 = new SuperE();
		SubE sub8 = new SubE();
		if( super81 instanceof SubE ) {
			sub8 = (SubE)super81;
			System.out.println("super81 형변환 성공~!"); 
		}else {
			System.out.println("super81 형변환 실패~!"); 
		}
		
		if( super82 instanceof SubE ) {
			sub8 = (SubE)super82;
			System.out.println("super82 형변환 성공~!"); 
		}else {
			System.out.println("super82 형변환 실패~!"); 
		}
		
		

	}

}












