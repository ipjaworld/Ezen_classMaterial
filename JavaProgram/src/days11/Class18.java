package days11;
class Student2{
	private int bunho;
	private String name;
	private int [] scores;
	private int tot; 
	private double avg; 
	private char grade; 
	
	Student2(){
		this.scores = new int[3];
	}
	Student2(String name) {
		this();  // this로 형제 생성자를 호출할때는 모든 다른 명령보다 항상 위에서 호출합니다.
		this.name = name;
		this.scores[0] = 80;
		this.scores[1] = 90;
		this.scores[2] = 100;
	}
	Student2(String name, int k, int e, int m){
		this(); 
		this.name = name;
		this.scores[0] = k;
		this.scores[1] = e;
		this.scores[2] = m;
	}
	public void copy1(Student2 std) {
		this.name = 	std.name;
		this.scores[0] = std.scores[0];
		this.scores[1] = std.scores[1];
		this.scores[2] = std.scores[2];
	}
	public Student2 copy2() {
		Student2 temp = new Student2();
		temp.name = this.name;
		temp.scores[0] = this.scores[0];
		temp.scores[1] = this.scores[1];
		temp.scores[2] = this.scores[2];
		return temp;
	}
	public Student2(Student2 std) {
		// this에 새로 만들어진 인스턴스의 주소가 전달됩니다.
		this();
		this.name = std.name;
		this.scores[0]  =std.scores[0];
		this.scores[1]  =std.scores[1];
		this.scores[2]  =std.scores[2];
	}	
}
// 디폴트 생성자에서 배열(scores)에 저장공간을 할당해주세요  정수 3자리 배열. 그외 동작 없음
// String 자료를 전달인수로 하는 생성자에서 전달된 이름을 멤버변수에 저장하고 그외 점수는 임의점수를 입력하세요
// STring 자료와 점수들을 전달인수로 하는 생성자는 각 전달값을 멤버변수에 저장하세요
// 필요한 형제 생성자를 this 로 호출해주세요
// copy1  과  copy2 를 제작해주세요

public class Class18 {

	public static void main(String[] args) {
		
		Student2 std1 = new Student2();
		Student2 std2 = new Student2("홍길동");
		Student2 std3 = new Student2("홍길남", 98,87,89);
		
		std1.copy1(std3);
		Student2 std5 = std2.copy2();
		
		Student2 std4 = new Student2( std3 );  // new Student2 에 의해 새공간이 만들어지고 
		// 그 주소는 std4에 전달되어 저장됩니다. 추가로 생성자에 숨어 있는 this 에도 주소는 전달됩니다.
	}

}
