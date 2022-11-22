package days10;

class Cclass{
	private int age;
	
	// 1. 생성자의 매개변수를 활용하는 경우 각각의 객체마다 서로 다른 값을 가질 수 있습니다.
	Cclass(int a){
		age = a;
	}
	Cclass(){
		age = 30;
	}
	// 4. 생성자 메서드 오버로딩을 통해  없어진 디폴트 생성자 문제를  해결할 수 있습니다
}

class Dclass{
	private int age;
	private String name;
	
	Dclass(){}
	
	public Dclass(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

public class Class11 {

	public static void main(String[] args) {
		Cclass c1 = new Cclass(20);
		Cclass c2 = new Cclass(30);
		// 2. 생성자에 전달인수를 만들고 다른 값을 전달하여, 객체마다 멤버변수의 초기값을 달리 하여 시작할 수 있습니다.
		
		Cclass c3 = new Cclass();
		// 3. 클래스 내부에 생성자가 꺼내어 져서 매개변수를 사용할 경우, 매개변수가 없는 디폴트 생성자는 
		//    새로 생성된 생성자로 대체되어서 없는 생성자가 됩니다.   따라서 위 명령은 에러가 됩니다.
		
		//5. 디폴트 생성자가 생겼으므로 위는 정상 실행됩니다.

	}

}
