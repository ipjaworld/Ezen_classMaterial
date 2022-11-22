package days17;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class JPanelTest extends JFrame{
	JPanelTest(){
		Container con = getContentPane();
		con.setLayout( new BorderLayout() );
		
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		// 패널 = 보조 컨테이너, 새끼컨테이너, 컨테이너위에 올려질 작은 컨테이너
		
		jp1.setLayout( new GridLayout(5,1) );
		jp2.setLayout( new GridLayout(4,1) );
		
		jp1.add( new JButton("JAVA") );
		jp1.add( new JButton("C++") );
		jp1.add( new JButton("ASP") );
		jp1.add( new JButton("JSP") );
		jp1.add( new JButton("PHP") );
		
		jp2.add( new JButton("HTML5") );
		jp2.add( new JButton("CSS") );
		jp2.add( new JButton("JQUERY") );
		jp2.add( new JButton("AJAX") );
		
		con.add(jp1, BorderLayout.WEST);
		con.add(jp2, BorderLayout.EAST);
		
		setTitle("패널  실습");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
public class Swing12 {

	public static void main(String[] args) {
		new JPanelTest();
	}

}
