package days10;

// 멤버메서드를 제작하는 주된 목적은 private으로 보호되는 멤버변수에 값을 저장하거나 얻어오거나...
// 그 둘의 목적이 가장큽니다.
// 따라서 특정 멤버 메서드(값을 저장하거나 얻어오는 메서드)를 별도의 사유없이 필요한만큼 만들고 시작하는 경우가 많습니다
// 메서드의 이름은 getter  setter 와   멤버변수이름을 조합해서 만듭니다

class GetSetTest {
	private int intVar;
	private double doubleVar;
	private String stringVar;
	private boolean booleanVar;
	
	/*
	public void setIntVar(int intVar) {
		this.intVar = intVar;  
		// 매개변수와 멤버변수가 이름이 같은 경우 둘을 구분하기 위해 멤버변수에  this. 을 붙여서 사용합니다
	}
	public int getIntVar() {
		return intVar;
	}
	*/
	
	// getter 와 setter 의 자동 생성 
	// 현위치에서 마우스오른쪽 버튼 클릭 
	// -> Source 메뉴 
	// -> Generate Getters and Setters 선택
	// -> selectAll 클릭 
	// -> Generate 클릭
	
	public int getIntVar() {
		return intVar;
	}
	public void setIntVar(int intVar) {
		this.intVar = intVar;
	}
	public double getDoubleVar() {
		return doubleVar;
	}
	public void setDoubleVar(double doubleVar) {
		this.doubleVar = doubleVar;
	}
	public String getStringVar() {
		return stringVar;
	}
	public void setStringVar(String stringVar) {
		this.stringVar = stringVar;
	}
	public boolean isBooleanVar() {
		return booleanVar;
	}
	public void setBooleanVar(boolean booleanVar) {
		this.booleanVar = booleanVar;
	}
	
	
}

public class Class07 {

	public static void main(String[] args) {
		GetSetTest gs = new GetSetTest();
		gs.setIntVar(123);
		System.out.println("멤버변수 intVar : " + gs.getIntVar() );
	}

}
