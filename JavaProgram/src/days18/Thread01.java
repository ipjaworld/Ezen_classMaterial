package days18;

//Thread : 프로그램의 명령을 실행하게끔 해주는 실행 주체. 
//개발자가 별도의 Thread 를 생성하지 않는 다면, 
//한 프로그램에 하나의 Thread 가 존재하여 해당 명령을 차례 차례 순서대로 실행 시킴

class ThreadA1 {
	public void run() {
		
		for( int i = 1 ; i <= 10 ; i++ )	{
			System.out.printf("ThreadA1 : i -> %d\n", i);
			try { 	
				Thread.sleep(300);  // 0.3초씩 실행을 딜레이시키는 Thread 클래스의 static 메서드
			} catch (InterruptedException e) {	e.printStackTrace();}  
		}
		
	}
}

class ThreadA2 {
	public void run() {
		for( int i = 1 ; i <= 10 ; i++ )	{
			System.out.printf("ThreadA2 : i -> %d\n", i);
			try { 	Thread.sleep(300);
			} catch (InterruptedException e) {	e.printStackTrace();}
		}
	}
}

public class Thread01 {

	public static void main(String[] args) {
		ThreadA1 t1 = new ThreadA1();
		ThreadA2 t2 = new ThreadA2();
		t1.run();
		t2.run();
	
		for( int i = 1 ; i <= 10 ; i++ ) {
			System.out.printf("main : i -> %d\n", i);
			try { 	Thread.sleep(300);
			} catch (InterruptedException e) {	e.printStackTrace();}
		}
	}
}
