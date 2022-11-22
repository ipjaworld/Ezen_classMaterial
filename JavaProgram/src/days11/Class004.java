package days11;
class Cat{
	String name;
	int age;
	String phone;
	// 멤버메서드는 한개만들어지고, 모든 객체가 그 메서드를 공유해서 사용합니다.
	// 많은 객체가 메서드를 필요할때마다 호출하는데 그 메서드 입장에서는 그들을, 누가 호출했는지를 어떻게 구분할까
	// 객체하나가 메서드를 호출하면 눈에 보이지 않게  호출객체의 참조값(주소)이 전달됩니다
	// 그 참조값은 눈에 보이지않는 this 라는 참조 매개변수에 저장(전달)됩니다
	// c1 이 호출하면   c1 -> this
	public void output(  /* Cat this */   ) {
		System.out.println("이름 : " + this.name + "  나이 : " + this.age 	+ "  전화번호 : " + this.phone);
		// this 변수는 매개변수와 멤버변수가 이름이 같은 경우 그둘을 구분하기 위해 많이 사용합니다.
		// 다만 그렇지 않은 경우 생략이 가능합니다. 
	}
	public void input(String name, int age, String phone /* , Cat this */ ) {
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
	public Cat copy1(  /* Cat this */ ) {  // this <- c2
		// 전달된 this 객체의 내용을 새로운 객체에 복사해서 새로운객체의 참조값을 리턴
		Cat temp = new Cat();
		temp.name = this.name;
		temp.age = this.age;
		temp.phone = this.phone;
		return temp;
	}
	public void copy2(Cat c  /*,  Cat this */) {  // this<- c5    c <- c4
		// c4(c)의 내용을 c5(this)에 복사
		this.name = c.name;
		this.age = c.age;
		this.phone = c.phone;		
	}
}
public class Class004 {

	public static void main(String[] args) {
		Cat c1 = new Cat();
		Cat c2 = new Cat();
		c2.input("야옹이", 5, "010-1234-1234");
		
		// Cat c4 = c2;  // 참조값만 복사됩니다. 객체는 하나 참조변수는 둘인상황이 발생.
		
		Cat c3 = new Cat();
		c3 = c2.copy1();  // 메서드 호출객체 c2,  전달인수 X, 리턴값이 Cat 의 참조값
		
		Cat c4 = new Cat();
		Cat c5 = new Cat();
		c4.input("냥이", 8, "010-1234-0000");
		c5.copy2(c4);  // 메서드 호출객체  c5, 전달인수 c4,   리턴값이 X
		
		c1.output();
		c2.output();
		c3.output();
		c4.output();
		c5.output();
	}

}
