package days16;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class ButtonEvent extends JFrame implements ActionListener{
	
	// 1. ActionListener 를 implements 합니다
	// 2. 적용할 컨트롤에 addActionListener 메서드로  감시설정을합니다
	// 3. 해당 컨트롤에 이벤트가 발생하면 호출되는  ActionPerformed  메스드를 오버라이드합니다
	
	JLabel result ;
	
	ButtonEvent(){
		JButton male = new JButton("남자");
		JButton female = new JButton("여자");
		JLabel label = new JLabel("당신의 성별은?");
		result = new JLabel(""); // 버튼 클릭에 의해서 결과가 담길 라벨
		
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		con.add(label);
		con.add(male);
		con.add(female);
		con.add(result);
		
		male.addActionListener(this);
		female.addActionListener(this);
		
		setTitle("버튼 이벤트 테스트");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 리스너가 설정된 컨트롤에 이벤트가 일어나면 자동 호출되는 메서드 : 이벤트가 일어난 내용이 e에 전달
		
		// 클릭된 컨트롤의 표시된 값이 문자변수 s에 저장
		String s = e.getActionCommand();  
		
		result.setText(s + "를 선택하셨습니다");
	}
}

public class Swing03 {

	public static void main(String[] args) {
		new ButtonEvent();		
	}

}
