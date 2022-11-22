package days19;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class IO18 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		File dir = new File("D:\\JAVA01\\Java_se\\temp");
		if( !dir.exists() )dir.mkdirs();	
		File file = new File(dir, "Point.dat");
		
		ObjectInputStream ois
				= new ObjectInputStream( new BufferedInputStream( new FileInputStream( file ) ) );
		
		ArrayList<Point> list = (ArrayList<Point>)ois.readObject();
		int i = 1;
		for( Point p : list ) {
			System.out.printf("%s  ", p.toString() );
			if( i++ % 7 == 0 )System.out.println();
		}

	}

}
