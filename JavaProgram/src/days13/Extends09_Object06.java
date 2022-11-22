package days13;

import java.util.Vector;

// 쇼핑 관련 프로젝트
// 클래스로 만들어질 대상 : 판매상품(Tv, Computer, Audio), 구매자
// 구매자가 상품을 사고, 환불하는 행위가 가능하도록 class와 프로그램을 제작합니다
class Product{
	 protected int price;
	 protected int bonusPoint;
	 Product(int p){
		 this.price = p;
		 this.bonusPoint = p/10;
	 }
}
class Computer extends Product{
	Computer(){
		super(1500000);
	}
	public String toString() {
		return "Computer";
	}
}
class Tv extends Product{
	Tv(){
		super(1000000);
	}
	public String toString() {
		return "Tv";
	}
}
class SmartPhone extends Product{
	SmartPhone(){
		super(800000);
	}
	public String toString() {
		return "SmartPhone";
	}
}

class Buyer{
	int money = 10000000;
	int bonusPoint = 0;
	Vector itemList = new Vector();    // 구매목록
	// 벡터란 배열의 확장형 리스트 구조.  - 객체들을 저장할 수 있는 배열이라고 이해해도 무방합니다
	// 사용자가 만든 클래스의 객체(메모리를 할당 받은 레퍼런스값) 등이 저장되는 다형성 객체 저장 리스트입니다
	// 추가된 순서로 번호(index)도 설정이 되서 나중에 번호로 검색할수 있습니다.
	// Computer c = new Computer();
	// item.add(c);     
	// add : Vertor 클래스의 멤버 메서드입니다
	// public boolean add( Object obj ){}
	
	//public void buy(Computer c) {	}
	//public void buy(Tv t) { }
	//public void buy(SmartPhone s) { }	
	public void buy( Product p ) {
		// 구매하려는 물건의 가격보다 내 보유금액이 더 큰가.  잔액은 충분한가
		if( p.price > this.money) {
			System.out.println("잔액이 부족합니다");
			return;
		}
		// 상품 가격만큼 보유금액을 차감합니다
		this.money -= p.price;
		// 상품의 보너스 포인트 만큼 구매자 보너스 포인트를 합산
		this.bonusPoint += p.bonusPoint;
		// 상품 객체를 item 에 추가합니다
		itemList.add(p);
		System.out.println(p + "을(를) 구입하셨습니다");
		// 자식 클래스에서 오버라이딩 된 toString() 이 실행됩니다
	}
	public void summary() {
		int sum = 0; //  지출 총액을 계산할 변수
		String item = ""; // 구입한 상품들을 화면에 나열하기 위해서 준비한 String 변수
		if( itemList.isEmpty() ) {
			// itemList.isEmpty() : Vector 가 비어있으면 true, 하나라도 채워져있으면 false 를 리턴
			System.out.println("구매하신 제품이 없습니다");
			return;
		}
		
		for( int i=0; i<itemList.size(); i++) {
			// itemList.size() : 저장된 요소의 갯수 리턴
			//Vector에서 저장요소를 꺼내는 멤버메서드 : itemList.get(0);	itemList.get(1);
			Product p = (Product)itemList.get(i);
			// Vertor에 저장될때 Object 형으로 저장된 객체를 다시 꺼내서 원래 자료형에 저장하려면
			// 그 클래스 형으로 강제캐스팅이 필요합니다
			sum += p.price;
			item += "  " + p.toString();
		}
		System.out.println("지출총액 : " + sum);
		System.out.println("구매목록 :" + item);
	}
	
	
	//환불 메서드
	//  itemList.remove(상품) : itemLsit에서 상품을 삭제 
	// 		- remove하려는상품이 존재하여 잘 지워졌다면 true 리턴
	// 잔액이 상품 가격만큼 늘어납니다
	// 보너스 포인트가 줄어듭니다
	// itemList에서 상품이 삭제됩니다
	// 제일먼저 itemList 가 비어 있으면  구매한 내역이 없습니다
	// 환불하려는 상품이 없으면 해당상품이 없습니다
	public void refund(Product p) {
		if( itemList.isEmpty() ) {
			System.out.println("구매하신 제품이 없습니다");
			return;
		}
		
		if( itemList.remove(p) ) {
			money += p.price;
			bonusPoint -= p.bonusPoint;
			System.out.println(p + "을/를 반품하셨습니다.");
		} else {
			System.out.println("구입하신 물품중에 해당 제품이 없습니다");
		}
	}
}

public class Extends09_Object06 {

	public static void main(String[] args) {
		Computer c = new Computer();
		Tv t = new Tv();
		SmartPhone s = new SmartPhone();

		System.out.println("t객체 제품명 : " + t);
		System.out.println("c객체 제품명 : " + c);
		System.out.println("s객체 제품명 : " + s);
		
		Buyer b = new Buyer();
		b.buy(c);
		b.buy(t);
		b.buy(s);
		
		b.summary();
		
		b.refund( t );
		
		b.summary();
	}

}
