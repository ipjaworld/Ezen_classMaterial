package days11;
class Student{
	private int bun;
	private String name;
	private int [] scores;
	Student(){
		scores = new int[3];
		bun=1;
		name = "홍길동";
		scores[0] = 100;
		scores[1] = 100;
		scores[2] = 100;
	}
	Student(String n) {
		scores = new int[3];
		bun=2;
		name = n;
		scores[0] = 95;
		scores[1] = 85;
		scores[2] = 75;
	}
	Student(String n, int k, int e, int m) {
		scores = new int[3];
		bun=3;
		name = n;
		scores[0] = k;
		scores[1] = e;
		scores[2] = m;
	}
	Student(Student s) {
		// 이미 new Student 는 만들어진 상태.
		// 전달된값을 copy 만하면 됩니다.
		// Student(String n, int k, int e, int m) 에서와 같이 전달값이 따로 전달되던 것을
		// s에 담겨서 한번에 전달한 셈입니다 
		name = s.name;
		scores[0] = s.scores[0];
		scores[1] = s.scores[1];
		scores[2] = s.scores[2];
		//bun = s.bun;
		bun=4;
	}
	public void prn() {
		
	}
}
// 아래 생성자들이 모두 실행가능하도록 생성자를 제작합니다
// 모든 생성자에서  scores 에 정수 세개를 저장할 배열을 만들고 주소를 저장하도록 코딩하세요

// 매개변수가 없는 생성자는 모든 변수값(번호, 이름, 점수)을 임의로 정한 값으로
// 매개변수에 이름만 전달되는 생성자는 이름을 제와한 모든 변수값을 임의의 값으로
// 이름과 점수가 전달되는 생성자는 번호만 임의의 값으로 저장하고, 다른 값들은 전달값으로 변수에 대입해주세요
// prn() 메서드는 멤버변수들의 값을 이용하여 출력하되 양식은 임의로 설정해주세요

// 전달인수가 클래스객체인경우 새로운 객체에 각 멤버변수 값을 복사한 객체가 만들어져서 그 참조값이 리턴되게 코딩하세요
public class Class14 {

	public static void main(String[] args) {
		Student s1 = new Student();   	
		Student s2 = new Student("홍길서");
		Student s3 = new Student("홍길남", 98,69,87);	
		Student s4 = new Student(s3);
		s1.prn(); 		s2.prn();		s3.prn();		s4.prn();
	}

}
