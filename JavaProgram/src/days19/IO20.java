package days19;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class IO20 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		File dir = new File("D:\\JAVA01\\Java_se\\temp");
		if( !dir.exists() )dir.mkdirs();	
		File file = new File(dir, "2022_10_25_17_09.dat");
		
		ObjectInputStream ois 
			=new ObjectInputStream(	new BufferedInputStream(new FileInputStream(file)));
		
		ArrayList<CalculatorResult> list	=	(ArrayList<CalculatorResult>)ois.readObject();
		
		int i=1;
		for( CalculatorResult c : list) {
			System.out.println(i + ".  " + c);
			i++;
		}
		ois.close();
	}

}
