package days13;
// toString 메서드의 사용
// Object 클래스에 있는 toString메서드는 "패키지이름.클래스이름@해시코드" 를 리턴해줍니다
// 이를 해당 클래스에 맞게 변경하려면 메서들 오버라이딩 기능을 이용합니다

class Point{
	private int x;
	private int y;
	public Point(int x, int y) {this.x = x; this.y = y;}
	public String toString() {
		String str = "(x=" + this.x + ",  y= " + this.y + ")";
		return str;
	}
}
public class Extends09_Object02 {

	public static void main(String[] args) {
		Point p = new Point(30,20);
		System.out.println("오버라이딩 된 toString() => " + p.toString());
		System.out.println("오버라이딩 된 toString() =>" + p);
		String msg = "Point => " + p;
		System.out.println(msg);
	}

}
