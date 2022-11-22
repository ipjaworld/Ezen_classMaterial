package days04;

public class Operator02 {

	public static void main(String[] args) {
		// 관계연산자(비교연산자)
		// 좌항기준 >(초과), <(미만), >=(이상≥), <=(이하≤), ==(같다), !=(같지않다) 
		// 좌항과 우항의 크기를 비교하여 true/false 값이 결과가 되는 연산
		// 관계식이 올바른 경우 결과값이 true, 관계식이 틀린 경우 결과값이 false 가  됩니다
		
		int n1 = 10;
		int n2 = 5;
		boolean result = n1 > n2;
		System.out.printf("%d > %d -> %b\n", n1, n2, result);
		
		result = n1 < n2;
		System.out.printf("%d < %d -> %b\n", n1, n2, result);
		result = n1 >= n2;
		System.out.printf("%d >= %d -> %b\n", n1, n2, result);
		result = n1 <= n2;
		System.out.printf("%d <= %d -> %b\n", n1, n2, result);
		result = n1 == n2;
		System.out.printf("%d == %d -> %b\n", n1, n2, result);
		result = n1 != n2;
		System.out.printf("%d != %d -> %b\n", n1, n2, result);
		
		System.out.println();
		
		// 문자(char)데이터들 간의 비교
		char c1 = 'A', c2 = 'B';
		
		result = c1 > c2;
		System.out.printf("%c > %c -> %b\n", c1, c2, result);
		result = c1 < c2;
		System.out.printf("%c < %c -> %b\n", c1, c2, result);
		
		// "1234" < "987"
		String s1 = "9234", s2 = "987";
		// result  = s1 < s2;  // 에러
		// System.out.printf("%s < %s -> %b\n", s1, s2, result);  // 윗줄에러발생으로 여기까지 실행되지 않음
		
		// s1과 s2 는 기본자료들과는 달리 조금 특별한 자료형이며, 이두변수가 직접 문자를 자정하고 있지 않습니다.
		// 문자들은 별도의 장소에 저장하고, 변수에는 그 문자들의 위치정보(주기억장치내 위치)값을 저장합니다.
		//그나마 사용가능한 연산자는 ==   != 는 사용이 가능합니다. 그래도 우리가 원하는 결과는 얻을수 없습니다.
		// 그래서 == 와 != 연산이 에러없이 가능은 하지만 이도 사용은 하지 않습니다
		
		// String 자료간의 비교는 별도로 만들어져 있는 도구를 이용합니다.
		// String 의 크다 작다를 판단해주는 compareTo()
		// String 의 같다 다르다를 판단해주는  equals()
		int r = s1.compareTo(s2);
		System.out.printf("%s > %s => %d\n", s1, s2, r);
		// compareTo 의 결과는 정수입니다.  맨 첫글자부터 비교했을때 처음으로 같은글자가 아닌 곳에서
		// 앞글자에서 뒤에글자를 빼는 산술연산(아스키코드값들의 연산)을 해서 얻은 결과입니다.
		// 결과가 양수이면 앞쪽글자가 크다,  음수이면 뒷쪽글자가 크다 라고 표현합니다.
		// 둘의 글자들이 정확히 모두 일치하면 결과는 0입니다
		r = s2.compareTo(s1);
		System.out.printf("%s > %s => %d\n", s1, s2, r);
		
		r = s1.compareTo(s2);
		System.out.printf("%s > %s =>%b\n", s1, s2, r>0);
		System.out.printf("%s > %s =>%b\n", s2, s1, r<0);
		System.out.printf("%s == %s => %b\n", s1, s2, r==0);
		
		System.out.println();
		result = s1.equals(s2);
		System.out.printf("%s == %s  -> %b\n", s1, s2, result);
		result = s1.equals("9234");
		System.out.printf("%s == %s -> %b\n",  s1, "9234", result);
	}
}









