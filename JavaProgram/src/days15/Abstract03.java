package days15;

abstract class Pet{
	public abstract void crying();
}
class DogB extends Pet{
	@Override
	public void crying() {
		System.out.println("멍~멍~");
	}
}
class CatB extends Pet{
	@Override
	public void crying() {
		System.out.println("야옹~");
	}
}
public class Abstract03 {

	public static void main(String[] args) {
		DogB d = new DogB();
		CatB c = new CatB();
		singing( d );
		singing( c );
		
	}
	public static void singing( Pet p ) {
		p.crying();  // 전달된 객체에서 각자 오버라딩된 crying 메서드가 실행됩니다.
	}

}
