package days20;



import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

// Server : 통신망에 연결되어서 자신에게 접속되어지는 클라이언트들에게 정보를 제공해주는 컴퓨터
// Client : Server 로 부터 정보를 제공받는 컴퓨터

public class TcpipServer01 {

	public static void main(String[] args) {
		
		// 서버와 클라이언트의 연결을 가능하게 해주는 클래스
		ServerSocket ss = null;  // 참조변수 생성
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");  // 클라이언트에게 보낼 현재시각의 양식
		
		try {
			ss = new ServerSocket(7777);
			// 서버소켓의 객체 생성
			// 위 문장이 실행되면 서버가 클라이언트의 연결요청을 기다리며, 수락할 준비가 완료됩니다.
			// 7777 : 클라이언트가 접속 요청하는 포트번호입니다.   포트번호는 반드시 7777 이 아니어도 되며, 
			// 자유롭게 설정해서 포트번호를 알고 있는 클라이언트만 접속하게도 할수 있습니다.
			System.out.println( f.format( new Date() ) + " 서버가 준비되었습니다");
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}  
		
		while(true) {
			try {
				// 서버소켓은 준비 완료 이후 클라이언트의 연결요청이 올 때까지 실행을 잠시 멈추고 계속 기다립니다
				System.out.println( f.format(new Date()) + " 연결요청을 기다립니다.");
				Socket s = ss.accept(); // 서버소켓이 연결을 기다리다가 요청을 감지하면 accept()가 실행됩니다.
				// 클라이언트의 연결요청이 오면 클라이언트 소켓과 통신할 새로운 통신용 소켓(s)을 연결정보와 함께 생성하고, 
				// 소켓이 요청받은 클라이언트 연결정보를 전달합니다
				System.out.println( f.format(new Date()) + s.getInetAddress() + " 로부터 연결요청이 들어왔습니다.");	
				
				OutputStream out = s.getOutputStream(); 
				// 정보 전달을 위한 OutputStream 객체를 생성하되 이는 연결된 통신소켓에서 얻어냅니다
				DataOutputStream dos = new DataOutputStream( out );// 최종 통신 출력 도구 : dos
				dos.writeUTF("[공지] 연결 성공~!!! 204호 00번 서버에 접속되셨습니다. ");
				
				System.out.println(f.format(new Date()) + " 메세지를 전송했습니다.");
				dos.close();
				s.close();
				// ss.close();			
			} catch (IOException e) {
				e.printStackTrace();
			}  
		}
	}
}
