package days14;

import java.util.Date;

public class StringClass {

	public static void main(String[] args) {
		
		// 0.
		// 가용한 HEAP 공간에 "Hello를 저장하고 주소를 참조변수에 저장
		String s1 = "Hello";
		// new 를 사용하지 않고 새공간을 만든다는 점
		// Integer, Double 같이 기본자료형을 클래스로 생성한 것들에 공통으로 있는 기능
		// 다만 String 에만 있는 단점. : 같은 문자들로 새로운 참조변수를 생성하면, 새로운 공간이 할당되지 않고
		// 같은 글자들의 주소가 참조변수에 저장합니다
		String s2 = "Hello";
		
		// 1. 
		// String 객체의 내용이 항상 새로운 공간에 만들어지려면 반드시 new 키워드를 사용합니다
		s1 = new String("Hello");
		s2 = new String("Hello");
		System.out.println("1. " + s1); 
		// String 클래스는 Object 클래스를 상속받고, 
		// 이미 toString 과 equals 가 자신에게 적합하게 오버라이딩 되어 있습니다.
		
		// 2.
		// char 배열을 String 으로 변환
		char [] c = {'H', 'e', 'l', 'l', 'o' };
		String s3 = new String(c);  // 배열주소를 초기값으로 문자열 구성.
		System.out.println("2. " + s2);
		
		// 3.
		// String -> char
		String n = "0123456789";
		char c1 = n.charAt(8);
		char c2 = n.charAt(0);  //괄호안에 정수값 번째의 글자를 얻음.(0부터 시작)
		System.out.println("3. " + c1 + " " + c2);
		
		// 4.
		String a1 = new String("ABCD");
		String a2 = new String("CCD");
		String a3 = new String("ABCD");
		System.out.println("4. a1.compareTo(a2) ? " + a1.compareTo(a2));
		System.out.println("4. a2.compareTo(a3) ? " + a2.compareTo(a3));
		System.out.println("4. a1.compareTo(a3) ? " + a1.compareTo(a3));
		// String 데이터들간의 비교
		// 차례로 한글자씩 같은 자리 글자들을 비교
		// 두 글자간의 뺄셈의 결과를 얻어서 아스키 코드로 어떤게 더 작은지 큰지를 결정합니다.
		//  ex) 'A' - 'B' => -1  뒤에서 빼려는 글자가 크다
		// 앞쪽부터 비교해서 같은글자는 지나치는 방식으로, 크기가 결정되면 뒤에 글자들은 비교하지 않습니다
		String [] k =  {"korea","japan","canada", "china", "kenya","jamaica "};
		for(int i=0; i<k.length; i++) {
			for(int j=i+1; j<k.length; j++) {
				if(k[i].compareTo(k[j]) > 0 ) {  
					// "연산의 결과가 0보다 크다"는  앞에서자료에서 뒤에 자료를 뺄셈한 결과...뒤에 값이 작아서 나온 결과					
					String temp = k[i];
					k[i] = k[j];
					k[j] = temp;
				}
			}
		}
		for(int i=0; i<k.length; i++)System.out.printf("%s  ", k[i]);
		System.out.println();
		
		
		
		// 5.
		// concat 메서드 : 전달인수 String 을 메서드 호출객체의 String에 이어붙이기 연산
		s2 = s1.concat(" World");
		// s2 = s1 + " World";
		// concat 메서드는 원본s에 있는 문자열에 World 를 이어붙이기하고 s1 에 업데이트해서 저장하는 것이 아니라
		// 이어붙이기된 새로운 문자열 객체를 만들어서 새로운 레퍼런스 변수에 저장할수 있게 리턴해줍니다.
		System.out.println("5. " + s2);
		System.out.println("5. " + s1);
		
		
		//6.
		s1 = new String("abcdefg");
		boolean b = s1.contains("bc");
		// boolean b = new String("abcdefg").contains("bc");  // 체이닝 기법
		// 괄호안의 문자열이 메서드 호출 객체가 갖고 있는 문자열의 일부로 포함되어 있다면 true 를 리턴해주는 메서드.
		// 없으면 false 리턴
		System.out.println("6. 문자열 "+s1+"에는 \"bc\" 가 포함되어 있다? "+b);

		s1 = new String("Hi");
		b = s1.concat(" World").contains("i W");  
		// a = 1+2+3-5  => 1+2연산후 결과에 +3, 그 결과에 -5  하듯이
		//  s1.concat(" World") 결과에   .contains("i W");  적용실행
		//s2 = s1.concat(" World");
		//b = s2.contains("i W");
		System.out.println("6. 문자열 "+s2+"에는 \"i W\" 가 포함되어 있다? "+b);
		
		
		
		
		//7.
		String s = new String("Hello.txt");
		b = s.endsWith("txt");   // s.startsWith() 도 있습니다. 
		// 메서드 호출 객체가 갖고 있는 문자열이 괄호안의 문자열로 끝나면 true 를 리턴해주는 메서드
		System.out.println("7. 문자열 " + s + "는 \"txt\" 로 끝난다 ? " + b);
		
		s = new String("Hello.txt");
		b = s.startsWith("Hel");
		System.out.println("7. 문자열 " + s + "는 \"Hel\" 로 시작한다 ? " + b);
		
		
		
		//8.
		s = new String("Hello");
		// 대소문자 구분 해서 비교
		System.out.println("8. " + s + "는 \"Hello\" 와 같다 ? " + s.equals("Hello"));
		System.out.println("8. " + s + "는 \"hello\" 와 같다 ? " + s.equals("hello"));
		// 대소문자를 구분하지 않고 비교
		System.out.println("8. " + s + "는 \"HELLO\" 와 같다 ? " + s.equalsIgnoreCase("HELLO"));
		System.out.println("8. " + s + "는 \"Hello\" 와 같다 ? " + s.equalsIgnoreCase("Hello"));
		
		
		
		// 9.
		// Hello
		System.out.println("\n9. " + s + "의 문자중 \'o\' 의 위치 " + s.indexOf('o') );
		System.out.println("9. " + s + "의 문자중 \'k\'의 위치" + s.indexOf('k'));
		// 메서드 호출 객체의 문자열중에 괄호안에 있는 문자가 몇번째로 위치하는 지를 구해줍니다. 
		// 있으면 위치값(0부터 시작하는 정수), 없으면 -1
		
		// Hello
		System.out.println("9. " +s + " s.indexOf(\'e\', 1)->" + s.indexOf('e', 1));
		System.out.println("9. " +s + " s.indexOf(\'o\', 3)->" + s.indexOf('o', 2));
		System.out.println("9. " +s + " s.indexOf(\'e\', 2)->" + s.indexOf('e', 2));
		// 찾고자 하는 문자가 지정한 정수(0부터 시작)번째부터 시작해서 몇번째 글자인지 찾고
		// 그 원래 인덱스를 리턴합니다.
		// 첫번째 사용예 : 알파벳 'e' 가 문자열 s의 1번째 글자부터 찾아서 전체 글자의 몇번째 글자인지 구함 : 1리턴
		// 두번째 사용예 : 알파벳 'o' 가 문자열 s의 3번째 글자부터 찾아서 전체 글자의 몇번째 글자인지 구함 : 4리턴
		// 세번째 사용예 : 알파벳 'e' 가 문자열 s의 2번째 글자부터 찾아서 전체 글자의 몇번째 글자인지 구함.  
		// 없으면 -1 리턴
		
		
		
		
		
		// 10.
		s1 = "Hello";
		System.out.println("\n10. " + s1 + " s1.replace(\'H\' , \'C\')->"	+ s1.replace('H','C'));
		s2 = s1.replace('H','C');  // H 를 C 로 치환
		System.out.println("10. " + s1 + "  " + s2);
		System.out.println("10. " + s1 + " s1.replace(\"ll\" , \"LL\")->" + s1.replace("ll","LL"));
		s2 = s1.replace("ll","LL"); // ll 을 LL 로 치환
		System.out.println("10. " + s1 + "  " + s2);
		// replace 메서드의 결과를 별도의 변수에 저장. 원래 원보은 보호
		
		
		
		// 11. 
		String  animal = "dog-cat-bear";
		String [] a = animal.split("-");
		// ',' 를 기준으로 문자열을 분리 - 문자열 배열로 만듬
		System.out.print("\n11. ");
		for(int i=0; i<a.length; i++) System.out.printf("%s  ", a[i]);
		
		
		
		// 12. ☆☆☆☆☆☆☆☆☆
		s1 = "java.lang.Object";
		s2 = s1.substring(5, 9);   // 원본에서  다섯번째 글자(0부터 시작)부터 8번째(9-1)까지 추출
		System.out.println("\n\n12. " + s2);
		// String 데이터중 필요한 글자들만 추출
		// .substring( 시작index, 끝index + 1 )
		
		s2 = s1.substring(10); // 원본에서 열번째 글자부터 끝까지 추출
		System.out.println("12. " + s2);
		
		
		// 13.
		System.out.println("\n13. " + String.valueOf(true));
		s = String.valueOf("13. " + 100);
		System.out.println(s);
		s = String.valueOf(100.123);
		System.out.println("13. " + s);
		//java.util.Date dd = new java.util.Date();
		Date dd  = new Date();  //java.util.Date
		s = String.valueOf(dd);
		System.out.println("13. " + s); 
		
		
		
	}

}














