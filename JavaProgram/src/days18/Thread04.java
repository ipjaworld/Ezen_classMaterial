package days18;

//2. Runnable 인터페이스를 구현(implements)하는 방법
//2-1. Runnable 인터페이스를 구현하는 클래스 작성
//2-2. public void run() 오버라이딩 구현
//2-3. 해당 클래스의 A 객체 생성
//2-4. A 객체를 Thread 클래스의 생성자로 전달하여 Thread 객체 생성
//2-5. 생성시킨 쓰레드의 start 메소드 호출!

class ThreadD1 implements Runnable{
	@Override
	public void run() {
		for( int i = 1 ; i <= 10 ; i++ ) {			
			System.out.printf("ThreadD1 : i -> %d\n", i);
			try {	Thread.sleep(300);
			} catch (InterruptedException e) {	e.printStackTrace();}
		}
	}
}

class ThreadD2 implements Runnable {
	public void run() {
		for( int i = 1 ; i <= 10 ; i++ ) {
			System.out.printf("ThreadD2 : i -> %d\n", i);
			try {	Thread.sleep(400);
			} catch (InterruptedException e) {	e.printStackTrace();}
		}
	}
}

public class Thread04 {

	public static void main(String[] args) {
		
		// 1. Runnable 인터페이스를 구현한 클래스의 객체생성
		ThreadD1 d1 = new ThreadD1();
		// 2. 1에서 생성한 객체를 Thread 생성자의 전달인수로 전달해서 Thread 객체를 생성
		Thread t1 = new Thread(d1);
		// 3. 2에서 생성한 객체르로 start 를 호출 실행합니다
		t1.start();
		
		// 위 1. 2. 3. 과정을 한 라인으로 작성할수도 잇씁니다
		new Thread( new ThreadD2() ).start();
		
		for( int i = 1 ; i <= 10 ; i++ ) {
			System.out.printf("main : i -> %d\n", i);
			try { Thread.sleep(200);
			} catch (InterruptedException e) {	e.printStackTrace();}
		}

	}

}
