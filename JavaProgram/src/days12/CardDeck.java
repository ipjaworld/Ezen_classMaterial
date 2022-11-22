package days12;

public class CardDeck {
	
	private Card [] cards = new Card[52];
	// cards[0] = new Card(Card.spade, 1);
	// cards[1] = new Card(Card.spade, 2);
	// cards[2] = new Card(Card.spade, 3);
	// ...
	// cards[0] = new Card(Card.diamond, 1);
	// cards[1] = new Card(Card.diamond, 2);
	// cards[2] = new Card(Card.diamond, 3);
	// ...
	
	CardDeck() {
		// 52장의 카드 인스턴스를 만드어서 52개의 칸이 있는 참조변수 배열에 각각 저장해줍니다
		int cardIndex = 0;
		for( int shape = 1; shape<=4; shape++ ) {
			for( int num=1; num<=13; num++) {
				cards[ cardIndex ] = new Card( shape, num );
				cardIndex++;
			}
		}
	}
	
	public Card pick(int i) {
		return cards[i];  // cards[i] 객체가 리턴
	}

	public void shuffle() {
		// 0~51번까지의 카드 한장 한장을 순서데로 섞을 예정입니다.
		// 자기 순서가 된 카드는 random 으로 결정한 번째 카드와 자리(위치)를 바꾸면서 섞습니다
		for(int i=0; i<52; i++) {
			int r = (int)(Math.random()*52);  // 0~51 사이의 랜덤 숫자 발생
			//i번째 카드와 r번째 카드를 서로 자리바꿈합니다
			Card temp = cards[i];
			cards[i] = cards[r];
			cards[r] = temp;
		}
	}
		
}










