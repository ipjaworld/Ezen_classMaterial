package days16;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//윈도우 프로그래밍에 필요한 윈도우 구성요소를 보유한 클래스(JFrame)를 상속받아 
//추가기능 탑재 형식의 개발을 진행합니다
class ButtonTest extends JFrame{
	// 윈도우 최초 화면의 구성은 대부분 생성자 메서드에서 구성합니다.
	ButtonTest(){
		JButton male = new JButton("남자");
		JButton female = new JButton("여자");
		// 생성자에 입력된 텍스트를 한가운데 표시한 버튼을 생성합니다
		// 아직 화면에 버튼이 보이는 상태는 아닙니다. 생성만 해서 아직 배치하고나 보여주는 단계는 아닙니다.
		// 버튼 또는 그 외 컨트롤들은 윈도우에 배치되고 위치를 잡아 올라가고 윈도우가 회면에 보여질때 같이 표시됩니다.
		
		// 라벨, 이름표, 명찰 등의 역할을 하는 안내문구 표시용 텍스 도구
		JLabel label = new JLabel("당신의 성별은?");
		
		// 윈도우 위에 생성된 컨트롤객체를 오려놓을수 있게 해주는 객체
		Container con = getContentPane();  // 윈도우에 올라갈 컨트롤들을 담을 바구니 역할을 하는 객체.
		// 그위에 정렬기준을 설정합니다.
		con.setLayout( new FlowLayout() ); // 올라가는 순서데로 일직선상에 위치시키는 레이아웃
		
		// 컨테이너에 생성된 컨트롤을 순서에 맞춰 올려놓으면 화면에 표시될 준비가 완료됩니다
		con.add(label);
		con.add(male);
		con.add(female);
		
		setTitle("버튼 컴퍼넌트 테스트");  // 윈도우 좌측 상단에 표시된 타이틀 내용 설정
		setSize(300, 200); // 윈도우 크기 설정 : 단위(픽셀)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 현재 윈도우 종료시 프로그램까지 종료 설정
		setVisible(true);  // 화면에 윈도우를 출현 시키는 메서드
	}
}
public class Swing01 {

	public static void main(String[] args) {
		
		new ButtonTest();
		

	}

}
