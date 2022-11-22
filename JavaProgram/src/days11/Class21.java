package days11;

class Student3{
	private int bun;
	private String name;
	private int [] scores;
	static int count = 0;
	
	Student3(){
		this.scores = new int[3];
		count++;
		bun = count;
	}
	Student3(String name) {
		this();  // this로 형제 생성자를 호출할때는 모든 다른 명령보다 항상 위에서 호출합니다.
		this.name = name;
		this.scores[0] = 80;
		this.scores[1] = 90;
		this.scores[2] = 100;
	}
	Student3(String name, int k, int e, int m){
		this(); 
		this.name = name;
		this.scores[0] = k;
		this.scores[1] = e;
		this.scores[2] = m;
	}
	public Student3(Student3 std) {
		// this에 새로 만들어진 인스턴스의 주소가 전달됩니다.
		this();
		this.name = std.name;
		this.scores[0]  =std.scores[0];
		this.scores[1]  =std.scores[1];
		this.scores[2]  =std.scores[2];
	}	
	
	public void copy(Student3 std) {
		// 번호는 고유번호들이 모두 있으므로 copy 하지 않습니다.
		this.name = 	std.name;
		this.scores[0] = std.scores[0];
		this.scores[1] = std.scores[1];
		this.scores[2] = std.scores[2];
	}
	
	public void prn() {
		int tot = 0;
		System.out.printf("%d\t%s\t", this.bun, this.name);
		for(int i=0; i<this.scores.length; i++) {
			System.out.printf("%d\t", scores[i]);
			tot += scores[i];
		}
		System.out.printf("%d\t", tot);
		System.out.printf("%.1f\n",  tot / (double)(this.scores.length) );
	}
}
// 전달인수 없는 생성자에서 메모리 할당 & count를 증가하고 번호를 저장합니다.
// 그외 생성자에서는 전달인수 없는 생성자를 호출해서 해당 코드가 실행되게 하고 나머지 코드는 이전 예제와 같습니다
// 출력은 아래 양식에 맞추고 , 전체 학생수를 맨아래 출력하세요
public class Class21 {

	public static void main(String[] args) {
		Student3 s1 = new Student3();
		Student3 s2 = new Student3("홍길서");	
		Student3 s3 = new Student3("홍길동", 56,99,55);	
		Student3 s4 = new Student3( s3 );
		s1.copy(s2);
		System.out.println("\t\t======성적표========");
		System.out.println("-------------------------------------------------");
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("-------------------------------------------------");
		s1.prn(); 		s2.prn(); 		s3.prn(); 		s4.prn();
		System.out.println("-------------------------------------------------");
		System.out.println("학생 총인원 : " +  ( Student3.count ) );

	}

}
