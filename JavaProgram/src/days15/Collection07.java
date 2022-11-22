package days15;

import java.util.ArrayList;

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
}
public class Collection07 {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);	 list.add(20);		list.add(30);   
		int target_index = list.indexOf(20);
		System.out.printf("20의 위치 : %d\n", target_index);
		target_index = list.indexOf(50); // 검색할 값이 존재하지 않는 경우 -1이 반환
		System.out.printf("50의 위치 : %d\n", target_index);
		System.out.printf("20의 저장 유무 : %b\n", list.contains(20));
		System.out.printf("50의 저장 유무 : %b\n", list.contains(50));
		
		ArrayList<Point> pList = new ArrayList<Point>();
		Point p = new Point(10,10);
		pList.add(p);
		pList.add( new Point(20, 20) );
		pList.add( new Point(30, 30) );
		
		for( Point k : pList ) System.out.println( k.toString() );
		
		int index = pList.indexOf( new Point(30, 30) );
		System.out.printf("(30, 30)의 위치 : %d\n", index);
		
	}

}






