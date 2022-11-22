package days12;

class StaticD{
	// private 으로 지정된 static 멤버는 클래스의 내부에서만 사용이 가능한 멤버입니다
	private static int count;
	
	// private으로 지정된 static 변수를 이용(접근)하고자 한다면, public 으로 지정된 멤버메서드(static, 인스턴스)를
	// 만들고 이용해야 합니다
	public static void setCount(int count) {
		StaticD.count = count;
	}
	public static int getCount() {
		return count;
	}
	
	// 인스턴스 메서드에서도 접근은 가능하지만 객체 생성후 이용이 가능합니다
	public void setCount1(int count) {  StaticD.count = count;  }	
	public int getCount1() {	return StaticD.count;	}
}
public class Class25 {

	public static void main(String[] args) {
		// private 으로 감춰진 static 멤버변수는 클래스 외부에서 접근이 차단됩니다.
		// staticD.count = 50;   // 에러
		StaticD.setCount(15);	
		System.out.printf("StaticD.count = %d\n", StaticD.getCount());		
		
		StaticD d1 = new StaticD();		
		d1.setCount1(30);		
		System.out.printf("StaticD.count = %d\n", d1.getCount1());
	}

}
