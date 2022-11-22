package days16;

import java.util.ArrayList;
import java.util.HashMap;

class Point{
	private int x;
	private int y;
	public Point(int x, int y) { this.x = x;  this.y = y; 	}
	public String toString() { return "x:" + x + ",y:" + y; }

	// equals  메서드를 오버라이딩 해주세요
	public boolean equals( Object obj) {
		if( !(obj instanceof Point) ) return false;
		Point target = (Point)obj;
		return (this.x == target.x)&&(this.y == target.y);
	}
	
	public int hashCode() {
		System.out.println("Rect 클래스의 hashCode 실행");
		return this.x + this.y;
	}
	// hashCode  메서드의 오버라이딩은 정~~~말 특별한 경우를 제외하고는 권장하지 않습니다.
	
	// 이미 중복값이 발생되지 않도록 철저히 준비된 연산을 다른 연사능로 바꿔서 실행하는 것 자체가
	// 자바의 코딩규칙을 무너뜨릴 가능성이 있기때문입니다. 
	// 다만 오버라이딩은 불가능한 동작이 아니므로 가능은 하다고 이해하면 됩니다.
}

public class Collection08 {

	public static void main(String[] args) {
		
		ArrayList<Point> pList = new ArrayList<>();
		pList.add( new Point(20, 20) );
		
		HashMap<Point, Integer> map = new HashMap<>();
		map.put( new Point(10, 10), 1);
		map.put( new Point(20, 20), 2);
		map.put( new Point(30, 30), 3);
		
		for( Point k  : map.keySet() ) {   // HashMap 의 키값들을 이용해서 키값마다 1회의 반복을 진행하는 구조
			// 반복에 적용할 리스는 해시맵의 키값들, 그것들중 하나를 저장할 변수는 Point 형 참조변수
			// 현재의 해시맵에서 new Point(10, 10) 키값으로  밸류는 찾는 방법 : map.get( new Point(10, 10 )  );
			System.out.printf("(%s)->%d\n", k , map.get(k));
		}
		
		System.out.printf("\n(30, 30)의 유무 : %b\n", map.containsKey(new Point(30, 30)));
	}

}









