package days15;
// 추상 클래스 작성방법
// 클래스 생성구문 앞에 abstract 키워드를 붙여서 생성합니다.
// 추상메서드를 포함한 클래스 : 추상 메서드를 하나이상 포함하면 추상클래스라고 부릅니다
// 추상메서드 : 메소드의 원형만 존재하고 실제 내용이 없는 메서드
abstract class AbstractAnimal{
	public abstract void sound(); 
	// 메서드의 원형만 있고, 메서드의 body(몸체)구현은 없습니다.
}

//추상메소드의 작성방법
//접근지정자 abstract 리턴값의타입 메소드명( 매개변수 );
//추상 클래스는 일반 클래스와 동일하게 일반 멤버변수 일반 메소드, 생성자 등을 포함할 수 있습니다.
//단, 추상 메소드를 포함할 수 있는 특징이 추가된 클래스입니다.
//추상클래스는 상속을 통한 다형성 구현을 위해서 생성됩니다

class DogA extends AbstractAnimal{
	public void sound() {
		System.out.println("멍~멍~");
	}
}
class CatA extends AbstractAnimal{
	@Override  
	public void sound() {
		System.out.println("야옹~");
	}
}
// 추상클래스를 상속받은 자식클래스는 반드시 물려받은 추상메서드를 오버라이드 해야 에러가 발생하지 않습니다.
// - 오버라이딩에 강제성을 부여
public class Abstract02 {

	public static void main(String[] args) {
		
		// AbstractAnimal a = new AbstractAnimal();  // 에러
		// 추상클래스는 상속 전용으로 만들어졌기때문에 단독으로 객체 생성이 불가능합니다
		
		// 추상클래스를 상속받은 자식클래스는 객체 생성이 가능합니다
		DogA d1 = new DogA();
		CatA c1 = new CatA();
		d1.sound();
		c1.sound();
		
		AbstractAnimal a;  // 객체는 만들지 못하지만 참조변수는 생성이 가능합니다. 
		// new AbstractAnimal(); 는 여전히 에러
		// 부모참조변수에 자식 인스턴스 주소를 담을수도 있습니다
		AbstractAnimal b = new DogA(); 
		AbstractAnimal c = new CatA();
		b.sound();
		c.sound();

	}

}








