package days15;
// 추상클래스

// 상속을 통한 다형성(여러 형태의 "자식 클래스의 객체 생성 & 활용 & 매서드오버라이딩 & type casting)의 구현에 
// 강제성(매서드오버라이딩)을 부여하기 위한 클래스

//상속의 문제점 : 강제성의 부재
//상속을 통해 다형성(부모클래스를 상속받아 여러 형태의 자식 클래스를 생성하고 활용함)을
//구현하고자 하여도, 하위클래스에서 메소드 오버라이딩을 구현하지 않으면 다형성을 완벽히
//구현할 수 없습니다. 

//이때, 오버라이딩을 구현하지 않는것이 문법상 문제가 없다는 점을 강제성의 부재라고 합니다

class Animal{
	public void crying() { 
		System.out.println("울음 소리~");  
	}
}
class Dog extends Animal{
	public void crying() { 	
		System.out.println("멍~멍~"); 
	}
}
class Cat extends Animal{
	
}
public class Abstract01 {

	public static void main(String[] args) {
		
		Dog d = new Dog();
		// Animal a = new Animal();  // 실제 프로그래밍에서 부모클래스의 객체는 만들어지는 일이 많지 않습니다 
		d.crying();
		Cat c = new Cat();
		c.crying();

	}

}
