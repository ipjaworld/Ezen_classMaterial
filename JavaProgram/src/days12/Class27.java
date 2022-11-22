package days12;
// 객체 배열
class Student{
	int bunho;
	String name;
	int [] scores;
	
	static int count = 0;
	
	Student(){
		scores = new int[3];
		bunho = ++count;
		name = "student" + count;
	}
	
	Student(int k, int e, int m){
		this();
		scores[0] = k;
		scores[1] = e;
		scores[2] = m;
	}
	
	void setBunho(int b) {
		bunho=b;
	}
}
public class Class27 {

	public static void main(String[] args) {
		
		//int [] a = new int[5];
		//String [] s = new String[5];
		//System.out.println(a[0]); // 0출력
		//System.out.println(s[0]); // null 출력
		
		Student [] std = new Student[5];  // 객체 배열 생성
		//System.out.println(std[0]); // null 출력
		//std[0].bunho = 1;
		//std[0].setBunho(10);
		
		// Student [] std = new Student[5]; 이명령은 객체 다섯개를 만든것이 아니라 참조변수 다섯개를 만든것
		// std[0] = new Student(); 다섯개의 참조변수가 객체로 활용되려면 이명령이 각각 실행되어야 합니다
		std[0] = new Student(98,78,98);
		std[1] = new Student(78,78,56);
		std[2] = new Student(65,98,34);
		std[3] = new Student(89,65,54);
		std[4] = new Student(76,45,56);
		
		// 결론 : 배열만 만들면 끝이아니라 배열의 한칸 한칸에 뉴인스턴스의 주소를
		//         채워줘야 배열의 요소 갯수 만큼 객체 사용이 가능합니다.
		for(int i=0; i< std.length; i++)
			std[i] = new Student(100,100,100);

	}

}
