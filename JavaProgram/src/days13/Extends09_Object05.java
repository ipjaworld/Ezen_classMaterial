package days13;

class Circle{
	private int x;   // 원의 중점 x 좌표
	private int y;   // 원의 중점 y 좌표
	private int radius;  // 반지름
	Circle( int x, int y, int radius){
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	public String toString() {
		return "x좌표 : " + this.x + ", y좌표 : " + this.y + ", 반지름 : " + this.radius;
	}
	public boolean equals( Object obj ) {
		if( !(obj instanceof Circle) ) return false;
		Circle target = (Circle)obj;
		return (this.x==target.x)&&(this.y==target.y)&&(this.radius==target.radius);
	}
}
public class Extends09_Object05 {

	public static void main(String[] args) {
		Circle c1 = new Circle(5,7,10);
		Circle c2 = new Circle(5,7,10);
		Circle c3 = new Circle(6,9,5);
		
		System.out.println("원 c1의 정보 - " + c1);  // 원 c1의 정보 - x좌표:XX, y좌표:XX, 반지름:XX
		System.out.println("원 c2의 정보 - " + c2);
		System.out.println("원 c3의 정보 - " + c3);
		
		if( c1.equals(c2) )	 System.out.println("c1 변수와 c2 변수는 같습니다.");
		else	 System.out.println("c1 변수와 c2 변수는 다릅니다.");
		
		if( c1.equals(c3) )	System.out.println("c1 변수와 c3 변수는 같습니다.");
		else		System.out.println("c1 변수와 c3 변수는 다릅니다.");

	}

}
