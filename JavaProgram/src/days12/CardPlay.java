package days12;

public class CardPlay {

	public static void main(String[] args) {
		
		CardDeck d = new CardDeck();
		
		d.shuffle();
		
		Card [] player1 = new Card[5];
		Card [] player2 = new Card[5];
		Card [] player3 = new Card[5];
		Card [] player4 = new Card[5];
		
		// 1명당 5장씩 분배하고 한명당 1줄에 보유카드를 한번에 출력해서 네줄을 출력해주세요
		
		int cardIndex = 0;
		for( int i=0; i<5; i++) {
			player1[i] = d.pick( cardIndex++ );
			player2[i] = d.pick( cardIndex++ );
			player3[i] = d.pick( cardIndex++ );
			player4[i] = d.pick( cardIndex++ );
		}
		
		for(int i=0; i<5; i++) System.out.printf("%s ", player1[i]);
		System.out.println();
		for(int i=0; i<5; i++) System.out.printf("%s ", player2[i]);
		System.out.println();
		for(int i=0; i<5; i++) System.out.printf("%s ", player3[i]);
		System.out.println();
		for(int i=0; i<5; i++) System.out.printf("%s ", player4[i]);
		System.out.println();
		
		/*
		Card c1 = d.pick(0);
		Card c2 = d.pick(1);
		Card c3 = d.pick(2);
		Card c4 = d.pick(3);
		Card c5 = d.pick(4);
		System.out.println( c1 );
		System.out.println( c2 );
		System.out.println( c3 );
		System.out.println( c4 );
		System.out.println( c5 );
		*/
		
		/*
		Card c1 = new Card(Card.diamond , 13);
		System.out.println( c1.toString() );
		Card c2 = new Card();
		System.out.println( c2.toString() );
		
		// toString() 메서드를 포함한 클래스로 만든 객체는 
		// System.out.println() 으로 출력했을때  
		// "패키지이름.클래스이름@해시코드" 가 출력되는것이 아니라
		// toString() 메서드가 리턴해주는 String 값이 출력됩니다.
		System.out.println( c1 );
		System.out.println( c2 );
		// 이것은 참조변수 단독으로 사용되기 보단 다른연산에 참조변수가 참여하고 있을때 적용되는 규칙입니다
		String result = "카드 1 : " + c1;
		System.out.println( result );
		result = "카드 2 : " + c2;
		System.out.println( result );
		*/
	}

}
