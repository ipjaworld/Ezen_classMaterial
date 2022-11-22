import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class Sender extends Thread{
	Socket socket;
	DataOutputStream dos; // 메세지 전송(송신)용 출력 스트림
	String name;
	
	Sender(Socket s){
		this.socket = s;  // 메인에서 전달된 socket 참조값을 현재클래스의 socket  멤버변수에 저장해서 사용합니다.
		// 이로써 현재 클래스에서 socket을 이용한 전송은 메인의 socket을 이용한 전송과 같은 동작이 됩니다
		OutputStream os;
		try {
			os = socket.getOutputStream();
			dos = new DataOutputStream( os );
			name = "[" + socket.getInetAddress() + ":" + socket.getPort() + "]"; 
			// 메세지를 전송하려는 주체의 아이피와 포트를 대화명으로 저장
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run() {
		Scanner sc = new Scanner(System.in);
		
		while( dos != null ) {  // 접속된 소켓이 살아 있어서 전송할 대상이 계속 존재한다면
			try {
				String mesaage = sc.nextLine();
				dos.writeUTF( name + mesaage); // 전송주체의 저장해둔 대화명과 전송할 메세지를 전송
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}
}

class Receiver extends Thread{
	Socket socket;
	DataInputStream dis;
	Receiver(Socket s){
		this.socket = s;
		try {
			InputStream is = socket.getInputStream();
			dis = new DataInputStream( is );
		} catch (IOException e) { 
			e.printStackTrace(); 
		}
	}
	public void run() {
		String message;
		while( dis != null ) {
			try {
				message = dis.readUTF();
				System.out.println(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

public class TcpipServer031 {

	public static void main(String[] args) {
		
		ServerSocket sS = null;
		Socket s = null;
		try {
			sS = new ServerSocket(7777);
			System.out.println("서버가 준비되었습니다.");
			s = sS.accept();
			// 앞선 예제에서는 DataOutputStream 에 s 를 사용하여 출력 또는 DataInputStream 에 s 를 활용하여 입력
			// 그러나 본 예제는  s 를 Sender 와 Receiver 의 생성자에 전달인수로 보내서
			// 현재 연결을 이용한 입력 출력을 양방향 자유롭게 가능하게 제작합니다
			// 각 클래스는 Thread 를 상속 받아, 동시실행이 가능하게 합니다.
			Sender sender = new Sender(s);
			Receiver receiver = new Receiver(s);
			sender.start();
			receiver.start();
			
		} catch (IOException e) { 
			e.printStackTrace(); 
		}
	}

}
