package days10;

import java.util.Scanner;

// 멤버 메서드의 역할은 은닉자료의 접근만 있는 것은 아닙니다.
// 멤버 자료의 유효한 값의 관리와 가공 및 권한적용 제어 등 을 담당하기도 합니다
class AccountWithPermission {
	private double balance;
	Scanner sc = new Scanner(System.in);
	
	public void initBanance(int money) { 
		balance = money; 
	}
	public void withraw() {
		
		System.out.print("출금할 금액을 입력하세요 : ");
		int money = Integer.parseInt( sc.nextLine() );
		
		System.out.println("비밀번호 네자리를 입력하세요");
		int pass = Integer.parseInt( sc.nextLine() );
		
		if( pass != 1234 ) {
			System.out.println("비밀번호가 맞지 않습니다");
			return;  // void 메서드에서  뒤에 값없이 사용되는 return 은  메서드를 그 지점에서 종료하라는 명령이됩니다
		}
		
		if( money > balance ) {
			System.out.println("잔액이 부족합니다.");
			return;   
		}
		
		balance -= money;
		System.out.println(money + "원 출금이 완료되었습니다");
		//System.out.printf("현재 잔액은 %.2f 원 입니다.\n", balance);
		display();
	}
	public void display() {
		System.out.printf("현재 잔액은 %.2f 원 입니다.\n", balance);
	}
	public void deposit() {
		
		System.out.print("입금할 금액을 입력하세요 : ");
		int money = Integer.parseInt( sc.nextLine() );
		
		if( money <= 0) {
			System.out.println("입금액 오류. 관리자에게 문의하세요");
			return;
		}
		balance += money;
		System.out.println(money + "원 입금이 완료되었습니다");
		display();
	}
}
public class Class06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int selectMenu;
		
		AccountWithPermission a = new AccountWithPermission(); //객체 생성
		a.initBanance(50000); //잔액 초기화
		
		System.out.print("메뉴선택 : 1. 입금  2.출금  3.잔액확인  4.종료 -> ");
		selectMenu = Integer.parseInt( sc.nextLine() );
		
		while( selectMenu != 4 ) {
			switch( selectMenu ) {
				case 1:
					a.deposit(); break;
				case 2:
					a.withraw(); break;
				case 3:
					a.display(); break;
			}
			System.out.print("메뉴선택 : 1. 입금  2.출금  3.잔액확인  4.종료 -> ");
			selectMenu = sc.nextInt();
		}
		System.out.println("프로그램이 종료되었습니다");
	}

}











