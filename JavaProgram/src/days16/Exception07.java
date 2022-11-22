package days16;

import java.io.File;
import java.io.IOException;

public class Exception07 {

	static int count = 0;
	public static void main(String[] args) {
		
		File f1 = createFile("abc.txt");
		File f2 = createFile("");
		File f3 = createFile("");

	}

	private static File createFile(String fileName) {
		// 파일 객체를 만들어서 전달된 파일이름으로 저장후 객체를 리턴
		File f = null;  // null 값을 갖는 파일 클래스 참조 변수생성
		try {
			if( (fileName==null)||(fileName.equals(""))) {
				throw new IOException("파일이름이 유효하지 않습니다" );
			}
		}catch( IOException e) {
			fileName = "제목없음" + ++count + ".txt";
			// count  변수는 현재위치에서만 늘어납니다. 정상 파일이름이 전달된경우 증가하지 않습니다.
		}catch( Exception e) {
			e.printStackTrace();
		}finally {
			// 예외가 발생하든 안하든 반드시 마지막에 실행하는 영역
			
			f = new File(fileName);
			try {
				f.createNewFile();
				// 객체에 설정된 파일이름으로 실제 파일이 생성 저장 됩니다
			} catch (IOException e) {
				System.out.println(fileName + "파일 생성에 실패했습니다");
			}  
		}
		return f;
	}

}
