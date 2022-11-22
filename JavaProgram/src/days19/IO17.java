package days19;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

class Point implements Serializable{
	private int x; 	
	private int y;
	public Point(int x, int y) {
		this.x = x;this.y = y;	
	}
	public String toString() {	
		return "(x:"+ this.x + ",y:" + this.y + ")";
	}
}
public class IO17 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		// 랜덤한 x, y 값(0~99 사이의 랜덤 값)을 갖는 객체 100개를 만들어서  ArrayList에 저장하고,
		// 그 ArrayList를 파일에 저장
		ArrayList<Point> list = new ArrayList<>();
		
		for(int i=0; i<100; i++) {
			Point p = new Point( (int)(Math.random()*100) , (int)(Math.random()*100) );
			list.add( p );
		}
		
		File dir = new File("D:\\JAVA01\\java_se\\temp");
		if( !dir.exists() ) dir.mkdir();
		File file = new File( dir, "Point.dat");
		
		ObjectOutputStream oos 
			= new ObjectOutputStream( new BufferedOutputStream( new FileOutputStream( file ) ) );
		
		oos.writeObject( list );
		
		oos.close();

	}

}
