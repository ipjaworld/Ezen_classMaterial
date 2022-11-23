package JDBC03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class MemberList_Main {

	public static void main(String[] args) {
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("\n--- 메뉴 선택 ---");
			System.out.printf("1. 데이터추가.\t 2. 데이터열람.\t 3. 데이터수정.\t 4. 데이터삭제. \t 5. 프로그램 종료.");
			System.out.print(">>메뉴 선택 : ");			
			String choice = sc.nextLine();
			if( choice.equals("5")) break;			
			switch( choice ) {
			case "1":		insert();		break;
			case "2":		select();		break;
			case "3":		update();		break;
			case "4":		delete();		break;
			default :
				System.out.println("메뉴 선택이 잘못되었습니다");
			}
		}
		System.out.println("프로그램 종료");
	}

	private static void select() {
		MemberDao mdao = new MemberDao();
		ArrayList<MemberDto> list = mdao.selectAll();
		System.out.println("번호\t이름\t\t전화\t\t\t\t생일 \t\t\t포인트 \t나이\t성별 \t가입일");
		System.out.println("-----------------------------------------------------------");
		
		for(MemberDto dto : list) {
			System.out.printf("%d \t %s \t %s \t %s \t %6d \t %3d \t %s \t %s\n",	
					dto.getMembernum(),	dto.getName(), dto.getPhone(), 
					dto.getBirth(), dto.getBpoint(),	dto.getAge(), dto.getGender() , 
					dto.getJoindate() );
		}
	}
	
	private static void insert() {
		MemberDao mdao = new MemberDao();
		// 추가할 레코드에 저장될 값들을 입력 받아서,
		// 각각의 값들을 MemberDto객체 하나에 담고
		// mdao.insert()함수를 호출해서 추가합니다
		MemberDto mdto = new MemberDto();
		
		Scanner sc  = new Scanner(System.in);
		
		// 이름 입력
		System.out.print("이름을 입력하세요");
		//String name = sc.nextLine();
		//mdto.setName(name);
		mdto.setName( sc.nextLine() );
		
		// 전화번호 입력
		System.out.print("전화번호를 입력하세요");
		mdto.setPhone(  sc.nextLine() );
		
		// 생일 입력 - java.util.Date()형식의 날짜 입력 후  java.sql.Date()로의 변환이 필요합니다
		// java.util.Date() 의 입력을 위해선  SimpleDateFormat 의 parse 메서드이 필요합니다
		System.out.print("생일을 입력하세요(YYYY-MM-DD) : ");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d = null;
		while(true) {
			try {
				d = sdf.parse( sc.nextLine() );
				break;
			} catch (ParseException e) {
				System.out.print("날짜를 입력예로 맞춰 다시 입력하세요(입력예:2015-12-31)");
			}
		}
		// java.util.Date 을  java.sql.Date 로 변환 
		// d.getTime() 을 java.sql.Date 의 생성자의 전달인수로 넣습니다.
		java.sql.Date birth = new java.sql.Date( d.getTime() );
		mdto.setBirth( birth );  //  입력받은날짜를 dto 객체에 저장
		
		// 나이는 입력 받지 않고 계산
		Calendar c = Calendar.getInstance();
		Calendar today = Calendar.getInstance();
		c.setTime( d );   //c.setTime( birth );  Date 자료를 Calendar  자료로 변환
		int age = today.get( Calendar.YEAR ) - c.get( Calendar.YEAR ) + 1;
		mdto.setAge(age);
		
		// 성별 입력
		System.out.print("성별을 입력하세요(M/F) : ");
		mdto.setGender(  sc.nextLine() );
				
		int result = mdao.insert(mdto);
		if( result == 1) System.out.println("레코드 추가 성공");
		else System.out.println("레코드 추가 실패");
	}
	
	
	private static void update() {
		
		MemberDao mdao = new MemberDao();
		MemberDto mdto = new MemberDto();
		Scanner sc = new Scanner(System.in);
		
		// 수정할 회원번호를 입력 받아서 해당회원이 존재하는지 검사하고
		String membernum;
		while(true) {
			System.out.print("수정할 회원의 회원번호를 입력하세요");
			membernum = sc.nextLine();
			if( membernum.equals("") ) System.out.println("회원번호 입력은 필수 입니다");
			else break;
		}
		
		// 있으면 mdto 에 저장
		mdto = mdao.selectOne( Integer.parseInt( membernum ) /* 입력받은 회원 번호 */ );
		if( mdto == null) {
			System.out.println("해당 회원이 없습니다");
			return;
		}
		// 수정할 내용을 차례로 입력받되 수정하지 않을 사항을 엔터만 입력해서
		// 수정할 내용이 있는건 mdto 에 수정
		
		System.out.println("기존 성명 " + mdto.getName() );
		System.out.printf("성명을 입력하세요(수정하지 않으려면 엔터를 치세요 : ");
		String name = sc.nextLine();
		if(!name.equals("")) mdto.setName(name);
		
		// 전화번호 입력
		System.out.println("기존 전화번호 " + mdto.getPhone() );
		System.out.printf("전화번호를 입력하세요 : ");
		String phone = sc.nextLine();
		if(!phone.equals("") ) mdto.setPhone( phone );
		
		//생일 입력
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(mdto.getBirth()!=null) System.out.println("기존 생일 : " + sdf.format( mdto.getBirth() ) );
		else System.out.println("기존 생일 : null");
		System.out.print("생일을 입력하세요(YYYY-MM-DD) (수정하지 않으려면 엔터를 치세요): ");
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
		if( d != null ) {
			java.sql.Date birth = new java.sql.Date( d.getTime() );
			mdto.setBirth( birth );  //  입력받은날짜를 dto 객체에 저장
			Calendar c = Calendar.getInstance();
			Calendar today = Calendar.getInstance();
			c.setTime( d );  
			int age = today.get( Calendar.YEAR ) - c.get( Calendar.YEAR ) + 1;
			mdto.setAge(age);
		}
		
		
		
		//가입일 입력
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("기존 가입일 : " + sdf.format( mdto.getJoindate() ) );
		System.out.print("수정할 가입일을 입력하세요(YYYY-MM-DD) (수정하지 않으려면 엔터를 치세요): ");
		d = null;
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
		if( d != null ) {
			java.sql.Date joinDate = new java.sql.Date( d.getTime() );
			mdto.setJoindate( joinDate );  
		}
		
		// 성별 입력
		System.out.println("기존 성별 " + mdto.getGender() );
		System.out.printf("성별을 입력하세요 : ");
		String gender = sc.nextLine();
		if( !gender.equals("") ) mdto.setGender( gender );
		
		// 사은포인 입력
		System.out.println("기존 포인트 " + mdto.getBpoint() );
		System.out.printf("사은 포인트를 입력하세요 : ");
		String bpoint = sc.nextLine();
		if( !bpoint.equals("") ) mdto.setBpoint( Integer.parseInt(bpoint) );
		
		int result = mdao.update( mdto );
		if( result == 1) System.out.println("레코드 수정 성공");
		else System.out.println("레코드 수정 실패");
		
		//System.out.printf("%d \t %s \t %s \t %s \t %6d \t %3d \t %s \t %s\n",	
		//		mdto.getMembernum(),	mdto.getName(), mdto.getPhone(), 
		//		mdto.getBirth(), mdto.getBpoint(),	mdto.getAge(), mdto.getGender() , 
		//		mdto.getJoindate() ); 
		
	}
	
	
	private static void delete() {
		
		MemberDao mdao = new MemberDao();
		MemberDto mdto = new MemberDto();
		Scanner sc = new Scanner(System.in);
		
		// 삭제할 회원번호를 입력 받아서 해당회원이 존재하는지 검사하고
		String membernum;
		while(true) {
			System.out.print("삭제할 회원의 회원번호를 입력하세요");
			membernum = sc.nextLine();
			if( membernum.equals("") ) System.out.println("회원번호 입력은 필수 입니다");
			else break;
		}
		// 있으면 mdto 에 저장
		mdto = mdao.selectOne( Integer.parseInt( membernum ) /* 입력받은 회원 번호 */ );
		if( mdto == null) {
			System.out.println("해당 회원이 없습니다");
			return;
		}else {
			int result = mdao.delete( Integer.parseInt( membernum ) );
			if( result == 1 )System.out.println("삭제 성공");
			else System.out.println("삭제 실패");
		}
		
	}



	

}
