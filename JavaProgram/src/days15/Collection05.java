package days15;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;

// Hashtable, HashMap 클래스
// 데이터베이스 내부의 키 값을 검색하기 위해서 만들어진 알고리즘을 기반으로 작성된 클래스
// - 검색을 위해서 사용되는 클래스
// - Key, Value를 저장할 수 있는 클래스
// - Key 는 중복을 허용하지 않습니다
// - Value 는 중복을 허용합니다.
// 저장 예
// HashMap hm = new HashMap(); 
// hm.put(1, "One");	
// hm.put(2, "Two");	
// hm.put(3, "Three");


public class Collection05 {

	public static void main(String[] args) {
		
		// Key 값은 String, Value 값은 Integer 형의 자료를 Hashtable에 저장할 객체를 생성한다면
		Hashtable<String, Integer> ht = new Hashtable<>();
		
		// 같은 제네릭형의  HashMap 생성
		HashMap<Integer, String>  hm = new HashMap<>();
		
		// Hashtable, HashMap 클래스는 put 메소드를 사용하여 데이터를 추가
		ht.put("One", 1);
		ht.put("Two", 2);
		ht.put("Three", 3);
		
		hm.put(1,  "One");
		hm.put(2,  "Two");
		hm.put(3,  "Three");
		
		// Hashtable, HashMap 클래스는 get 메소드에  Key 값을 전달하여 Value를 리턴받습니다
		System.out.printf("\"Three\" = %d\n", ht.get("Three"));
		System.out.printf("3 = %s\n", hm.get(3));
		
		
		//  반복문을 이용해서 Hashtable, HashMap 에 Value 들을 출력하려면, 별도의 객체가 필요합니다
		// Enumeration 객체
		// Enumeration 은 열거형 자료형식(인터페이스)입니다
		Enumeration<String> e1 = ht.keys();  // 키값들은 리스트형식으로 얻어서 저장합니다.
		
		//객체이름.hasMoreElements() 메서드를 이용해서 다음 키값이 있는지 확인한 후 마지막 키값까지 하나씩
		// 접근합니다
		while(e1.hasMoreElements()) {
			String key = e1.nextElement();  // 다음 키값을 얻어내고
			int value = ht.get(key);   // 키값으로 검색한 밸류값을 얻어냅니다
			System.out.printf("key(%s)=Value(%d)   ", key, value);
		}
		System.out.println();
		
		// for 문을 활용하여 Key 값을 순회하는 방법
		for( Integer k : hm.keySet() ) {   //hm.keySet() : 키값들만 모아서 리스트로 생성
			String v = hm.get(k);
			System.out.printf("key(%d)=Value (%s)   ", k, v);
		}
		
		
		
		
		// 확장 사용 예
		HashMap<Integer, Object> hm2 = new HashMap<Integer, Object>();
		//  key:1   value:"abcd"
		//  key:2   value:1234
		//  key:3   value:23.56
		//  key:4   value:{"abcd" , "efg" , "hij"}
		
		HashMap<Integer,  ArrayList<String> > hm3 = new HashMap<>();
		//  key:1   value:{"abcd" , "efg" , "hij"}
		//  key:2   value:{"kkkk" , "ffff" , "ddddd", "ghghZ" }
		
		

	}

}










