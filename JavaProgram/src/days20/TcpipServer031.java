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
	DataOutputStream dos; // �޼��� ����(�۽�)�� ��� ��Ʈ��
	String name;
	
	Sender(Socket s){
		this.socket = s;  // ���ο��� ���޵� socket �������� ����Ŭ������ socket  ��������� �����ؼ� ����մϴ�.
		// �̷ν� ���� Ŭ�������� socket�� �̿��� ������ ������ socket�� �̿��� ���۰� ���� ������ �˴ϴ�
		OutputStream os;
		try {
			os = socket.getOutputStream();
			dos = new DataOutputStream( os );
			name = "[" + socket.getInetAddress() + ":" + socket.getPort() + "]"; 
			// �޼����� �����Ϸ��� ��ü�� �����ǿ� ��Ʈ�� ��ȭ������ ����
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run() {
		Scanner sc = new Scanner(System.in);
		
		while( dos != null ) {  // ���ӵ� ������ ��� �־ ������ ����� ��� �����Ѵٸ�
			try {
				String mesaage = sc.nextLine();
				dos.writeUTF( name + mesaage); // ������ü�� �����ص� ��ȭ��� ������ �޼����� ����
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
			System.out.println("������ �غ�Ǿ����ϴ�.");
			s = sS.accept();
			// �ռ� ���������� DataOutputStream �� s �� ����Ͽ� ��� �Ǵ� DataInputStream �� s �� Ȱ���Ͽ� �Է�
			// �׷��� �� ������  s �� Sender �� Receiver �� �����ڿ� �����μ��� ������
			// ���� ������ �̿��� �Է� ����� ����� �����Ӱ� �����ϰ� �����մϴ�
			// �� Ŭ������ Thread �� ��� �޾�, ���ý����� �����ϰ� �մϴ�.
			Sender sender = new Sender(s);
			Receiver receiver = new Receiver(s);
			sender.start();
			receiver.start();
			
		} catch (IOException e) { 
			e.printStackTrace(); 
		}
	}

}
