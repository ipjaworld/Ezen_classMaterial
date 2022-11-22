package days15;

import java.util.HashMap;
import java.util.Hashtable;

public class Collection06 {

	public static void main(String[] args) {
		
		Hashtable<String, Integer> ht = new Hashtable<>();
		HashMap<Integer, String> hm = new HashMap<>();
		
		ht.put("One", 1);	ht.put("Two", 2);	ht.put("Three", 3);
		hm.put(1, "One");	hm.put(2, "Two");	hm.put(3, "Three");
		
		System.out.printf("ht.size() -> %d\n", ht.size());
		System.out.printf("hm.size() -> %d\n", hm.size());
		
		// 두개의 데이터가 같은 키값을 갖고 있을수는 없습니다
		// 중복되지 않은 키 값으로 데이터를 추가
		ht.put("Four", 4);	ht.put("Five", 5);
		hm.put(4, "Four");	hm.put(5, "Five");
		
		System.out.printf("ht.size() -> %d\n", ht.size());
		System.out.printf("hm.size() -> %d\n", hm.size());
		
		// Value 값이 중복되게 데이터 추가
		ht.put("six", 1);		ht.put("seven", 2);
		hm.put(6, "One");	hm.put(7, "Two");
		
		for( String k : ht.keySet() ) 
			System.out.printf("k(%s)=v(%d)  ", k, ht.get(k));
		System.out.println();
		for( Integer k : hm.keySet() ) 
			System.out.printf("k(%d)=v(%s)  ", k, hm.get(k));
		
		System.out.println();
		// 동일한 키값으로 다른 Value가 입력되는 경우 기존의 Value 값이 수정됩니다.
		ht.put("Six", 6);	ht.put("Seven", 7);
		hm.put(6, "Six");	hm.put(7, "Seven");
		for( String k : ht.keySet() ) 
			System.out.printf("k(%s)=v(%d)  ", k, ht.get(k));
		System.out.println();
		for( Integer k : hm.keySet() ) 
			System.out.printf("k(%d)=v(%s)  ", k, hm.get(k));

	}

}
