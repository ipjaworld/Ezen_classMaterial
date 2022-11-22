package days11;

// this 키워드의 용도 #1

// this 변수는 레퍼런스(참조) 변수입니다.
// 멤버변수는 new 생성자() 에 의해 새로운공간 객체별로 각각 만들입니다.
// 반면에 멤버 메서드는 한개만 만들어지며, 각객체들이 공유&호출해서 사용합니다.
// 이때 메서드내에는 누가 자신을 호출했는지 구분하기 위해 this 라는 참조변수를 준비해놓고 있습니다.
// 호출한 객체의 참조값이 this에 저장됩니다.
// this 변수는 따로 기술하지 않은 숨어있는 변수입니다.

class ThisA{
	private int num;
	
	// this 에는 현재 메서드를 호출한 객체의 참조변수값이 전달되어 저장됩니다.
	// 보통 멤버변수를 this 없이 사용해도 이름이 중복된 매개변수가 아니라면, 내부적으로 this가 모두 붙어서 실행됩니다.
	public int getNum( /*  ThisA this  */) {
		return this.num;
	}
	public void setNum(int num /* , ThisA this  */) {
		this.num = num;
	}
	public void init(int num /* , ThisA this  */ ) {
		this.num = num;
	}
	public void prn( /*  ThisA this  */ ) {
		System.out.println("멤버변수 num 의 값 : " + this.num );
	}
	
	public void copy1(ThisA a  /* , ThisA this  */ ) {    // this <- a4   매개변수 a <-  a2 
		this.num = a.num;
	}
	public ThisA copy2(/*  ThisA this  */) {   // this <- a3
		ThisA temp = new ThisA();
		temp.num = this.num;		
		return temp;
	}
}
public class Class15 {

	public static void main(String[] args) {
		ThisA  t1 = new ThisA();   // new 로 새로 생성된 뉴인스턴스의 주소값이 생성자의 this로 전달
		t1.init(100);  // t1 -> init 메서드의  this 로 전달  , 100은 매개변수 num 으로 전달
		t1.prn();   // t1 -> prn 메서드의  this 로 전달 
		System.out.println();
		
		ThisA a1 = new ThisA();
		ThisA a2 = new ThisA();
		
		a1.setNum(300);  //  a1 -> this   300->매개변수num
		a2.setNum(400);  //  a2 -> this   400->매개변수num
		
		ThisA a3 = a2;
		a2.setNum(500);
		// 두 레퍼런스 변수값이 같으므로 한쪽에 변화를 주면 다른쪽도 같이 변하는 효과있음
		// a3.setNum(500);
		a2.prn();  // 500 출력
		a3.prn();  // 500 출력 - 객채의 복사가 아니라 참조값의 복사가 일어났기때문에 a2와 a3은 같은 인스턴스 주소를 
		// 갖고 있습니다 따라서 a2의 멤버변수 수정은  a3의 멤버변수를 수정하는것과 같습니다
		System.out.println();
		
		ThisA a4 = new ThisA();  // 새로운 공간이 생성
		a4.copy1(a2);   // a2 멤버변수를 a4의 멤버변수에 복사.  this <- a4   매개변수 a <-  a2 
		a2.setNum(100);
		a2.prn();  // 100 출력
		a4.prn();  // 500 출력
		System.out.println();
		
		ThisA a5 = a3.copy2();  // 새로운 공간도 만들고 멤버변수값도 카피하고
		// 전달인수 없고 리턴값이 있음. this<-a3   새로운공간 만들어서 a3의 내용이 복사된후 그 새로운 공간이 리턴
		a3.setNum(200);
		a3.prn();
		a5.prn();
		

		// 새로운 공간을 만들고자 한다면 어디에선가는 반드시 new ThisA() 가 필요합니다.
	}

}
