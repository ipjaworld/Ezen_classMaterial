package JDBC04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import JDBC03.MemberDao;
import JDBC03.MemberDto;

public class RentList_Main {
	
	public static void main(String[] args) {
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("\n--- 메뉴 선택 ---");
			System.out.printf("1. 데이터추가.\t");    		System.out.printf(" 2. 데이터열람.\t");
			System.out.printf("3. 데이터수정.\t");		System.out.printf("4. 데이터삭제.\t");
			System.out.println("5. 프로그램 종료.");	System.out.print(">>메뉴 선택 : ");			
			String choice = sc.nextLine();
			if( choice.equals("5")) break;		  
			
			RentDao rdao = RentDao.getInstance();
			
			switch( choice ) {
				case "1": insert(rdao);		break;
				case "2": select(rdao);		break;
				case "3": update(rdao);		break;
				case "4": delete(rdao);		break;
				default : System.out.println("메뉴 선택이 잘못되었습니다");
			}
		}
		System.out.println("프로그램 종료");
	}

	private static void select(RentDao rdao) {
		ArrayList<RentDto> list =rdao.selectAll(); 
		System.out.println("날짜\t\t\t순번\t도서번호\t회원번호\t할인금액");
		System.out.println("--------------------------------------------------");
		for(RentDto dto : list)
			System.out.printf("%s\t%d\t%s\t\t%s\t\t%d\n", dto.getRentdate(),
					dto.getNumseq(), dto.getBooknum(), dto.getMembernum(), 
					dto.getDiscount() );			
	}

	private static void insert(RentDao rdao) {
		
		// rentdate 는 sysdate 로 현재 시간 입력
		// numseq 는 시퀀스로 처리
		
		// 회원번호와 도서번호는 입력받은후 조회해서 해당 회원 또는 도서가 없을때 다시 입력하라고 메세지를 출력합니다
		// 해당 회원이 있거나 도서가 있으면 다음으로 넘어갑니다.
		
		// 할인금액은 대여금액의 50%를 넘지 않게..... 넘으면   너무 할인이 과도합니다. 남는게 없어요.. 출력후 다시 입력
		Scanner sc = new Scanner(System.in);
		
		String membernum;
		while(true) {
			System.out.print("대여할 회원의 회원번호를 입력하세요");
			membernum = sc.nextLine();
			if( membernum.equals("") ) {
				System.out.println("회원번호 입력은 필수 입니다");
				continue;
			}
			MemberDao mdao = new MemberDao();  // MemberDao 객체 생성
			MemberDto mdto = mdao.selectOne( Integer.parseInt( membernum )  );  // 기존 메서드 이용
			if( mdto == null) {
				System.out.println("해당 회원이 없습니다. 다시 입력하세요");
				continue;
			}
			else break;
		}
			
		// 도서코드 조회는 RentDao에 별도로 제작하셔야 합니다.
		String booknum;
		String rentprice;
		while(true) {
			System.out.print("대여할 도서의 도서번호를 입력하세요");
			booknum = sc.nextLine();
			if( booknum.equals("") ) {
				System.out.println("도서번호 입력은 필수 입니다");
				continue;
			}
			rentprice = rdao.getSubject( booknum );
			if( rentprice == null) {
				System.out.println("해당 도서가 없습니다. 다시 입력하세요");
				continue;
			}
			else break;
		}
		
		int discount = 0;
		while(true) {
			System.out.print("할인금액을 입력하세요");
			String temp = sc.nextLine();
			if( !temp.equals("") ) discount = Integer.parseInt( temp );
			if( discount > Integer.parseInt( rentprice) ) 
				System.out.println("할인금액 과도합니다 다시 입력하세요");
			else break;
		}
		RentDto rdto = new RentDto();
		rdto.setBooknum( Integer.parseInt(booknum));
		rdto.setMembernum( Integer.parseInt(membernum));
		rdto.setDiscount(discount);
		
		int result = rdao.insert( rdto );
		if( result == 1) System.out.println("레코드 추가 성공");
		else System.out.println("레코드 추가 실패");
		
	}

	private static void update(RentDao rdao) {
		
		// 수정할 대여 내역의 대여번호(numseq) 입력
		Scanner sc = new Scanner(System.in);
		String numseq;
		while(true) {
			System.out.print("수정할 대여건의 일련번호를 입력하세요");
			numseq = sc.nextLine();
			if( numseq.equals("") ) System.out.println("대여번호 입력은 필수 입니다");
			else break;
		}
		RentDto rdto = rdao.selectOne( Integer.parseInt( numseq )  );
		if( rdto == null) {
			System.out.println("해당 번호의 대여내역이 없습니다");
			return;
		}
		// 글자형식으로 2022-11-22  와 같이 수정할 날짜를 입력 받으세요. RentDto 에 멤버변수에 저장합니다.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("기존 대여일 : " + rdto.getRentdate() );
		System.out.print("수정할 대여일을 입력하세요(YYYY-MM-DD) (수정하지 않으려면 엔터를 치세요): ");
		java.util.Date d = null;
		String temp;
		while(true) {
			try {
				temp = sc.nextLine();
				if( temp.equals("") )break;
				else d = sdf.parse( temp );
				break;
			} catch (ParseException e) {
				System.out.print("날짜를 입력예로 맞춰 다시 입력하세요(입력예:2015-12-31)");
			}
		}
		if( d != null ) rdto.setRentdate( temp );
		
		
		
		
		
		// 도서번호하고 회원번호 그리고 할인금액 입력과 수정에 필요한 사항은 insert 코드를 참고하세요
		String membernum;
		while(true) {
			System.out.println("기존 회원 번호 : " + rdto.getMembernum() );
			System.out.print("수정할 회원의 회원번호를 입력하세요. 수정하지 않으려면 엔터를 치세요");
			membernum = sc.nextLine();
			if( membernum.equals("") ) break;
			MemberDao mdao = new MemberDao();  // MemberDao 객체 생성
			MemberDto mdto = mdao.selectOne( Integer.parseInt( membernum )  );  // 기존 메서드 이용
			if( mdto == null) {
				System.out.println("해당 회원이 없습니다. 다시 입력하세요");
				continue;
			}else {
				rdto.setMembernum( Integer.parseInt(membernum) );
				break;
			}
		}
			
		
		
		// 도서코드 조회는 RentDao에 별도로 제작하셔야 합니다.
		String booknum;
		String rentprice="";
		while(true) {
			System.out.println("기존 도서코드 : " + rdto.getBooknum() );
			System.out.print("수정할 도서의 도서번호를 입력하세요");
			booknum = sc.nextLine();
			if( booknum.equals("") ) {
				rentprice = rdao.getSubject( String.valueOf( rdto.getBooknum() ) );
				break;
			}else {
				rentprice = rdao.getSubject( booknum );
			}
			if( rentprice == null) {
				System.out.println("해당 도서가 없습니다. 다시 입력하세요");
				continue;
			}else {
				rdto.setBooknum( Integer.parseInt(booknum) );
				break;
			}
		}
		
		int discount = 0;
		while(true) {
			System.out.println("기존 할인금액 : " + rdto.getDiscount() );
			System.out.print("할인금액을 입력하세요");
			temp = sc.nextLine();
			if( temp.equals("") ) break;
			discount = Integer.parseInt( temp );
			if( discount > Integer.parseInt( rentprice ) ) 
				System.out.println("할인금액 과도합니다 다시 입력하세요");
			else {
				rdto.setDiscount(discount);
				break;
			}
		}
		
		//System.out.printf("%s\t%d\t%s\t\t%s\t\t%d\n", rdto.getRentdate(),
		//		rdto.getNumseq(), rdto.getBooknum(), rdto.getMembernum(), 
		//		rdto.getDiscount() );
		
		int result = rdao.update(rdto);
		if(result == 1)System.out.println("수정 성공");
		else System.out.println("수정 실패");
		
	}

	private static void delete(RentDao rdao) {
		
		// 삭제할 대여 내역의 대여번호(numseq) 입력
		Scanner sc = new Scanner(System.in);
		String numseq;
		while(true) {
			System.out.print("삭제할 대여건의 일련번호를 입력하세요");
			numseq = sc.nextLine();
			if( numseq.equals("") ) System.out.println("대여번호 입력은 필수 입니다");
			else break;
		
			RentDto rdto = rdao.selectOne( Integer.parseInt( numseq )  );
			if( rdto == null) {
				System.out.println("해당 번호의 대여내역이 없습니다");
				return;
			}
		}
		
		int result = rdao.delete( numseq );
		if(result == 1)System.out.println("삭제 성공");
		else System.out.println("삭제 실패");
		
	}

}














