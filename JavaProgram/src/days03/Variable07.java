package days03;

import java.util.Scanner;

public class Variable07 {

	public static void main(String[] args) {
		
		// (입력)포장을 기다리는 사과의 갯수 입력
		// (입력)상자 하나에 담길 수 있는 사과의 갯수 입력
		int myApple;   // 내가 갖고 있는 사과의 갯수
		int quantityOneBox;   // 한상자에 들어갈수 있는 사과의 갯수
		int boxQuantity;   // 포장된 상자의 갯수
		int theRest;   // 포장을 끝낸후 나머지 사과의 갯수
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("보유한 사과의 갯수를 입력하세요 : ");
		myApple = sc.nextInt();
		
		System.out.printf("한상자에 포장될수 있는 사과의 갯수를 입력하세요 : ");
		quantityOneBox = sc.nextInt();  // 자동완성 단축키 : Ctrl + Space
		
		boxQuantity = myApple / quantityOneBox;
		theRest = myApple % quantityOneBox;
		
		System.out.println("포장된 사과박스 갯수 : " + boxQuantity);
		System.out.println("남은 사과갯수 : " + theRest );
		
		// (출력)입력조건으로 포장했을때, 포장된 박스갯수, 남은 사과 갯수 출력
		// 박스갯수 : XX 
		// 남은 사과 : XX

	}

}
