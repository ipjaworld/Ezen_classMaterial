package days15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// - Set(HashSet) 클래스
//	데이터의 중복을 허용하지 않고 저장하는 클래스
//	- 검색을 위해서 사용되는 클래스
//			(저장할때 hash 연산의 결과로 저장하니, 검색할때도 hash 연산 결과로 검색하여 빠른 검색이 가능)
// - hash 연산 : 클래스 내에서 유일 한값을 얻어 낼수 있는 고유 알고리즘연산
//	- 중복된 값을 제거하면서 데이터를 저장하기 위해 사용
public class Collection04 {

	public static void main(String[] args) {
		
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);	a.add(2);	a.add(2);
		System.out.println(a.size()); // 중복을 허용하기 때문에 3이 반환
		
		HashSet<Integer> h = new HashSet<>();
		h.add(1);	h.add(2);	h.add(2); 
		System.out.println(h.size()); // 중복을 허용하기 않기 때문에 2이 반환
		
		// 로또번호 발생기
		HashSet<Integer> lotto = new HashSet<>();
		while( lotto.size() < 6) {
			lotto.add(   (int)(Math.random() * 45) + 1   );
		}
		for( Integer i : lotto ) 	System.out.printf("%d  ", i);
		System.out.println();
		
		// 해쉬세트에는 정렬 네서드가 없습니다. 
		// 따라서 링크드 리스트의 부모클래스인 List 클래스에 전해주고 리스트로 변환해서 , 
		// Collection의 스태틱 메서드로 정렬합니다
		List<Integer> list = new LinkedList(lotto);
		Collections.sort(list);
		System.out.println(list); // 한번에 출력
		for( Integer i : list ) 	 // 반복문으로 하나씩 출력 
			System.out.printf("%d  ", i);
		System.out.println();
		
		
		
		// 리스트나 해쉬세트의 내부 값을 순회하는 방법
		// 1. Iterator 객체를 사용하는 방법
		// - Iterator 객체는 컬렉션 내부의 데이터를  순회할 수 있는 객체
		Iterator<Integer> iter = lotto.iterator();
		Iterator<Integer> iter2 = list.iterator();
		// lotto 및 list 에 값들에 접근할 수 있는 권한을 Iterator 객체에 저장합니다
		
		while( iter.hasNext() )  //iter.hasNext() : 다음 데이터가 있으면   true 리턴
			System.out.printf("%d  ", iter.next() );
		System.out.println();
		while( iter2.hasNext() )  //iter2.hasNext() : 다음 데이터가 있으면   true 리턴
			System.out.printf("%d  ", iter2.next() );
		// 제어권을 넘겨받아서 위와 같이 한번 리스트를 모두 순회하면, iter = lotto.iterator(); 를 통해서 
		// 다시 방문 필요할때 제어권을 다시 얻어내야합니다.
		System.out.println();
	}

}









