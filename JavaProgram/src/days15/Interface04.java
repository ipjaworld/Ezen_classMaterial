package days15;

interface Repairable{ }

abstract class Unit{
	private int hp; // 현제 생명력(체력, 피)
	private int max_hp; // 최대 생명력 
	Unit(int p){
		max_hp = p;   // 캐릭터별 전달된 최대 체력 초기화
		hp = (int)(p*0.9);  // 현재 체력은 최대의 90%로 초기화
	}
	public abstract void move(int x, int y);
	//public void move(int x, int y) {
	//	System.out.println("x:" + x + ", y:" + y + " 로 이동합니다");
	//}
	public int getHp() {  	return hp;	}
	public int getMax_hp() {   	return max_hp;	}
	public void setHp(int hp) {   	this.hp = hp;	}
	public void setMax_hp(int max_hp) {   this.max_hp = max_hp;	}
}

class GroundUnit extends Unit{ 
	GroundUnit(int p){   super(p);	}
	@Override
	public void move(int x, int y) {
		System.out.println("x:" + x + ", y:" + y + " 로 뛰어갑니다");		
	}
}
class AirUnit extends Unit{ 
	AirUnit(int p){		super(p);	}
	@Override
	public void move(int x, int y) {
		System.out.println("x:" + x + ", y:" + y + " 로 날아갑니다");
	}
}	
class Tank extends GroundUnit implements Repairable{
	Tank(){ super(150);  }
	public String toString() {  return "Tank"; }
}
class Dropship extends AirUnit implements Repairable{ 
	Dropship(){ super(150); }
	public String toString() {  return "Dropship"; }
}
class Marine extends GroundUnit{ 
	Marine(){ super(40); }
	public String toString() { return "Marine"; }
}
class SCV extends GroundUnit implements Repairable{ 
	SCV(){ super(40); }
	public String toString() { return "SCV"; }
	
	//public void repair(Tank t) {}
	//public void repair(Dropship d) {}
	//public void repair(SCV s) {}
	
	public void repaire( Repairable r  ) {
		// this 가 r 을 수리합니다.
		//  r.getHp();  // getHp() 는 인터페이스 Repairable 의 멤버가 아니기때문에 사용이 안됩니다.
		// getHp() 와 setHp() 를 사용하려면 Unit 클래스의 참조변수에 옮겨담아야 합니다.
		// "자식참조변수 <- 부모참조 <- 자식인스턴스" 가 아니라    
		// "부모1 참조변수에 담겨있는 자식인스턴스 주소를 부모2 참조변수로 이동"
		if( r instanceof Unit) {  // r 에 담겨있는 인스턴스 주소가 Unit 으로 형변환이 가능하다면
			Unit u = (Unit)r;	
			if(u.getHp()  !=  u.getMax_hp() ) {
				while( u.getHp()  !=  u.getMax_hp() ) {
					u.setHp( u.getHp() + 1 );
					System.out.println(u + "체력 1를 repair 했습니다. 현재 체력 : " + u.getHp() );
				}
			}else {
				System.out.println(u + "의 hp는 만땅입니다.");
				return;
			}
			System.out.println(u + "의 수리가 끝났습니다\n");
		}
	}
}


public class Interface04 {

	public static void main(String[] args) {
		
		Tank t = new Tank();
		Dropship d = new Dropship();
		Marine m = new Marine();
		SCV s1 = new SCV();
		SCV s2 = new SCV();
		
		System.out.print( t + " : ");
		t.move(10,40);
		System.out.print( d + " : ");
		d.move(20,30);
		System.out.print( m + " : ");
		m.move(30,20);
		System.out.print( s1 + " : ");
		s1.move(40,10);
		
		s1.repaire(t);
		s1.repaire(d);
		s1.repaire(s2);
		// s1.repaire(m);  // Repairable을 implements 하지 않은 클래스의 객체
		

	}

}
