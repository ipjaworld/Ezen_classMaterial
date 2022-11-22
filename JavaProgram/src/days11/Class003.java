package days11;
// 멤버 메서드의 생성 목적 #2 : 멤버 변수에 값을 대입하고, 연산하고, 출력하는 것입니다.
// 목적대로 한다면 d1.name = "댕댕이";  연산이 가능하므로, 메서드가 필요 없을수도 있습니다.
// 다만 멤버변수에  private  이 붙어 있다면 d1.name = "댕댕이";  가 불가능하므로,  
// public  형태의 멤버 메서드를 생성하여 사용합니다

class Dog{
	private String name;
	private int age;
	private String phone;
	
	// getter 와 setter 의 자동 생성 
	// 현위치에서 마우스오른쪽 버튼 클릭 
	//   -> Source 메뉴 -> Generate Getters and Setters 선택
	// selectAll 클릭 -> Generate 클릭
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}

public class Class003 {

	public static void main(String[] args) {
		Dog d1 = new Dog();
		// d1.name = "댕댕이";
		
		d1.setName("댕댕이");
		d1.setAge(6);
		d1.setPhone("010-5555-6666");
		// 변수값을 메서드를 이용해서 저장 -> 한번에 저장하는 메서드(input()같은 메서드)는 필요에 따라 제작하면 됩니다.
		System.out.println("이름:" + d1.getName() + "  나이 : " + 
				d1.getAge() + "  전화번호 : " + d1.getPhone() );

	}

}
