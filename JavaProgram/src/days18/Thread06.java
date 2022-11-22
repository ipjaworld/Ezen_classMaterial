package days18;

import javax.swing.JOptionPane;

class ThreadE extends Thread{
	private boolean state = true;  // run 메서드 내부에서 실행종료를 판단할 변수로 생성 사용
	
	private boolean 중간종료 = true;  // 시간이 지나서 종료된 상태인지 입력이되어서 종료된 상태인지를 체크하는 변수
	
	public void setState(boolean s) { state = s; }
	public boolean get중간종료() {return 중간종료;}
	public void run() {
		for(int i=10; (i>0) && (state==true)  ; i--) {
			System.out.println(i);
			try {sleep(1000);
			}catch( Exception e) {}
		}
		if(state==true) {
			System.out.println("입력시간이 지났습니다");
			중간종료 = false;
		}
	}
}
public class Thread06 {

	public static void main(String[] args) {
		
		ThreadE e= new ThreadE();
		e.start();  // 카운트 다운을 위한 스레드가 시작됩니다.
		String input = JOptionPane.showInputDialog("정답을 입력하세요.");  // 정답 입력 대기도 시작됩니다.
		// 다이얼로그 박스에 입력이 되면 다음명령이 실행되고 입력이 없으면 계속 대기합니다
		// 아래 명령이 실행된다는건 입력이 되었다는 뜻입니다		
		// 현재 위치에서 ThreadE 를 멈추게 하는 값에 설정을 실행합니다
		e.setState(false);
		if( e.get중간종료() ) System.out.println("입력하신 값은 " + input + "입니다.");
		// 중간종료 변수는   카운트 다운 내에 입력이 완료되었을때 true 이고, 
		// 카운트 다운이 모두 실행되고 끝났을때는 false 입니다
		// get중간종료 메서드로 중간종료변수값을 얻어왔을때 true 이면 입력한값 출력이 실행되고
		// false 이면 실행되지 않습니다.
		
		// e.stop() 은 사용하지 않습니다.
		

	}

}
