package days08;

public class Method04 {

	public static void main(String[] args) {
		
		// prnTitle() : 성적표 제목, 번호 이름 국어 영어 등과 같은 열제목을 출력하는 메서드
		// prnScore() : 이름, 국어, 영어, 수학 를 전달받아서 총점 평균을 계산하고 성적점수들을 출력하는 메서드
		prnTitle();
		prnScore("홍길동", 87, 89, 97);
		prnScore("홍길서", 45, 98, 78);
		prnScore("홍길남", 77, 88, 99);
		System.out.println("-------------------------------------------------------------");
	}
	public static void prnScore( String name, int kor, int eng, int mat) {
		int tot = kor + eng + mat;
		double avg = tot/3.0;
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\n", name, kor, eng, mat, tot, avg);
	}
	public static void prnTitle() {
		System.out.println("\t\t#####성적표######");
		System.out.println("-------------------------------------------------------------");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("-------------------------------------------------------------");		
	}

}
