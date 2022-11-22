package days16;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

//윈도우에 텍스트필드1  버튼1   버튼2   텍스트필드2
//순서로 배치합니다
//버튼1의 표면에는 ">" 글자 표시 , 버튼 2의 표면에는 "<" 글자를 표시합니다
//버튼 1을 클릭하면 텍스트필드1의 글자가 텍스트필드2로 옮겨지게
//버튼 2을 클릭하면 텍스트필드2의 글자가 텍스트필드12로 옮겨지게
//글자가 없는 상태에서 버튼을클릭하면  아무일도 안일어나게 ....
//윈도클래스 이름은   TextFieldEx 로 제작해주세요
//윈도우의 가로 세로크기는 적절히 조절해주세요

class TextFieldEx extends JFrame implements ActionListener{
	JTextField t1;
	JTextField t2;
	
	TextFieldEx(){
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	}	
}
public class Swing11 {

	public static void main(String[] args) {
		new TextFieldEx();
	}

}
