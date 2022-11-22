package days17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

class Calendars extends JFrame implements ActionListener{
	
	JTextField [] jt = new JTextField[42];
	JTextField y;
	JTextField m;
	int year = 0;
	int month = 0;
	
	Calendars(){
		
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		
		jp1.setLayout(new GridLayout(1,7));   // 일 월 화 수 목 금 토    맨윗줄 요일이 표시될 부분
		jp2.setLayout(new GridLayout(6,7));   // 달력이 표시될 부분
		jp3.setLayout(new FlowLayout());  // 현재 달력의 년 월이 표시될 부분
		
		Font f = new Font("굴림", Font.BOLD, 20);
		JButton b1 = new JButton("일");
		b1.setFont(f);
		JButton b2 = new JButton("월");
		b2.setFont(f);
		JButton b3 = new JButton("화");
		b3.setFont(f);
		JButton b4 = new JButton("수");
		b4.setFont(f);
		JButton b5 = new JButton("목");
		b5.setFont(f);
		JButton b6 = new JButton("금");
		b6.setFont(f);
		JButton b7 = new JButton("토");
		b7.setFont(f);
		jp1.add( b1 ).setForeground(Color.RED);
		jp1.add( b2 );
		jp1.add( b3 );
		jp1.add( b4 );
		jp1.add( b5 );
		jp1.add( b6 );
		jp1.add( b7 ).setForeground(Color.BLUE);
		
		for(int i=0; i<42; i++) {
			jt[i] = new JTextField();
			// jt[i].setText( String.valueOf(i+1) );
			jt[i].setFont(f);
			jt[i].setHorizontalAlignment(SwingConstants.RIGHT);
			if( i%7 == 6) jt[i].setForeground(Color.BLUE);
			else if(i%7 == 0)jt[i].setForeground(Color.RED);
			else jt[i].setForeground(Color.BLACK);
			jt[i].setEditable(false);
			jt[i].setBackground(Color.WHITE);
			jp2.add( jt[i] );
		}
		
		JButton jb0 = new JButton("확인");
		JButton jb1 = new JButton("이전달");
		JButton jb2 = new JButton("다음달");
		jb0.setFont(f);
		jb1.setFont(f);
		jb2.setFont(f);
		
		JLabel jl1 = new JLabel("년");
		JLabel jl2 = new JLabel("월");
		jl1.setFont(f);
		jl2.setFont(f);
		
		y =new JTextField(6);
		y.setFont(f);
		y.setHorizontalAlignment(SwingConstants.CENTER);
		
		m =new JTextField(3);
		m.setFont(f);
		m.setHorizontalAlignment(SwingConstants.CENTER);
		
		Calendar today = Calendar.getInstance();
		y.setText(String.valueOf(today.get(Calendar.YEAR)));
		m.setText(String.valueOf( today.get(Calendar.MONTH)+1 ));
		
		jp3.add(jb1);
		jp3.add(y);
		jp3.add(jl1);
		jp3.add(m);
		jp3.add(jl2);
		jp3.add(jb0);
		jp3.add(jb2);
		
		
		jb0.addActionListener(this);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		con.add(jp1, BorderLayout.NORTH);
		con.add(jp2,BorderLayout.CENTER);
		con.add(jp3,BorderLayout.SOUTH);

		setTitle("스윙 캘린더");
		setSize(600,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		year = Integer.parseInt(y.getText());
		month = Integer.parseInt(m.getText());
		
		drawCalendar();
		
		// ActionListener 설정후에 이전달 다음달 버튼을 클릭하면 현재 달력이 이전달 다음달 달력으로 바뀌게 코딩힙니다
		// 다음달부터 완성후 이전달을 추가하세요
		// 새달력이 출력되면 하단에 표시된 년월도 해당 년월로 수정해주세요
		
	}

	private void drawCalendar() {
		Calendar sDay = Calendar.getInstance();
		Calendar eDay = Calendar.getInstance();
		
		for(int i=0; i<42; i++) jt[i].setText("");
		
		sDay.set(year, month-1, 1); 
		eDay.set(year, month, 1);
        eDay.add(Calendar.DATE, -1);
        int startWeek = sDay.get(Calendar.DAY_OF_WEEK); 
        
        for( int i=startWeek-1;  
        		sDay.before( eDay)||( sDay.equals(eDay) ); 
        									sDay.add(Calendar.DATE, 1) ) {
       	// 계산한 요일의 숫자부터 시작,  반복조건은 시작날짜가 끝날짜보다 작거나 같다면 반복,  증감:시작날짜를 1일씩 증가
        	int day = sDay.get(Calendar.DATE);  // 시작날짜에 일자만 추출
        	jt[i++].setText( String.valueOf(day) );
        }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String s = e.getActionCommand();
		
		year = Integer.parseInt(y.getText());
		month = Integer.parseInt(m.getText());
		
		switch(s) {
			case "다음달" :
				if( month==12 ) {
					year++; month=1;
				}else {
					month++;
				}
				drawCalendar();
				y.setText( String.valueOf(year) );
				m.setText( String.valueOf(month) );
				break;
			case "이전달" :
				if( month==1 ) {
					year--; month=12;
				}else {
					month--;
				}
				drawCalendar();
				y.setText( String.valueOf(year) );
				m.setText( String.valueOf(month) );
				break;
			case "확인" :
				drawCalendar();			
		}
		
	}
}

public class Swing14 {

	public static void main(String[] args) {
		new Calendars();
	}

}
