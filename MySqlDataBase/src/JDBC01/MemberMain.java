package JDBC01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class MemberMain {

	public static void main(String[] args) {
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("\n--- 메뉴 선택 ---");
			System.out.printf("1. 데이터 추가.");		System.out.printf("  2. 데이터열람.");
			System.out.printf("  3. 데이터 수정.");		System.out.printf("  4. 데이터삭제.");
			System.out.printf("  5. 프로그램 종료.");		System.out.printf(">>메뉴 선택 : ");
			String choice = sc.nextLine();
			if(choice.equals("5")) break;
			switch( choice ) {
				case "1" : insert();		break;
				case "2" : select();		break;
				case "3" : update();	break;
				case "4" : delete();		break;
				default : System.out.println("메뉴 선택이 잘못되었습니다.");
			}
		}
		System.out.println("프로그램 종료");
		
	}

	private static void select() {
	      
	      // 테이블 내의 날짜 형식을 Dto에 맞는 String으로 변형해서 읽어오고 화면에 출력하세요
	      MemberDao mdao = new MemberDao();
	      ArrayList<MemberDto> list = mdao.selectAll();
	      System.out.println("번호\t이름\t\t\t생일\t포인트\t나이 \t성별\t  가입일\t\t번호");
	      System.out.println("-----------------------------------------------------------------------------------------");
	      
	      for(MemberDto dto : list) {
	         System.out.printf("%d \t %s \t %s \t %d \t %d \t %s \t %s \t %s\n",   
	               dto.getMembernum(),   dto.getName(), dto.getBirth(), dto.getBpoint(),
	               dto.getAge(), dto.getGender(), dto.getJoindate(), dto.getPhone() );
	      }
	   }


	private static void insert() {
		// 필요한 자료를 입력 받고, 그들을 Dto에 담아서 테이블의 레코드로 추가합니다.
		// 날짜를String으로 입력 받아서 SQL 문에서 날짜 형식으로 변경하세요
		
		
		MemberDao mdao = MemberDao.getInstance();
		Scanner sc = new Scanner(System.in);
		MemberDto mdto = new MemberDto();
		
		System.out.print("이름을 입력하세요 : ");
		mdto.setName( sc.nextLine() );
		
		System.out.print("전화번호를을 입력하세요 : ");
		mdto.setPhone( sc.nextLine() );
		
		// 날짜를 String 으로 입력 받아서 Dao로 전송하고, Dao의 SQL 문에서 날짜 형식으로 변경하세요
		System.out.print("생일을 입력하세요(YYYYMMDD) : ");
		String birth = sc.nextLine();
		String year = birth.substring(0, 4);
		mdto.setBirth(birth);
		Calendar today = Calendar.getInstance();
		int age = today.get(Calendar.YEAR) - Integer.parseInt(year)+1;
		mdto.setAge(age);
		
		System.out.print("성별을 입력하세요 : ");
		mdto.setGender( sc.nextLine() );
		
		mdao.insert( mdto );
		
		
		
		/*
		int result = mdao.insert( mdto );
		if( result == 1) System.out.println("레코드 추가 성공");
		else System.out.println("레코드 추가 실패");
		*/
		
	}

	private static void update() {
		// 수정하고자 하는 항목의 데이터를 입력 받아서 레코드를 수정합니다.
		MemberDao mdao = MemberDao.getInstance();
		Scanner sc = new Scanner(System.in);
		String temp;
		
		// 첫번째로 수정하고자 하는 회원의 회원 번호를 입력받고, 입력받은 회원번호로 회원을 조회해서 해당 회원이 존재하는지 확인합니다.
		
		// 조회 메서드 이름은 getMember 로 합니다.
		// 없으면 없다고 출력하고 메서드를 종료합니다
		// 해당 회원이 있으면 그 회원의 모든 정보를 mdto 객체에 저장합니다.
		String memberNum = "";
		while(true) {
			System.out.print("수정하고자 하는 회원의 회원번호를 입력해주세요");
			memberNum = sc.nextLine();
			if(memberNum.equals("")) {
				System.out.println("회원 번호는 반드시 입력해야합니다.");
		
			}else break;
		}
		MemberDto mdto = mdao.getMember(Integer.parseInt( memberNum ) );
		if( mdto == null) {
			System.out.println("해당 번호의 회원님이 없습니다");
			return;
		}
		
		String name = "";
		while(true) {
			System.out.println("기존 : " + mdto.getName());
			System.out.print("입력하세요");
			temp = sc.nextLine();
			if( name.equals("") ) {
				break;
			}
			name = temp;
			mdto.setName(name);
		}
		
		String birth = "";
		mdto.setBirth(birth);
		
		
		int bpoint = 0;
		mdto.setBpoint(bpoint);
		
		
		String joindate = "";
		mdto.setJoindate(joindate);
		
		
		String phone = "";
		mdto.setPhone(phone);
		
		
		int age = 0;
		mdto.setAge(age);
		
		
		String gender = "";
		mdto.setGender(gender);
		
		
		
		mdao.update(mdto);
		
		// 수정 데이터 입력은 항목 하나씩 물어보고 입력 받되, 수정이 필요 없는 항목은 엔터만 쳐서 다음 데이터 입력으로 넘어가게 합니다.
		// 수정 데이터 입력을 받기 전에 기존 데이터 내용을 출력하여 안내하고 수정할 내용을 입력 받습니다
		
		// 레코드 수정 메서드 이름은 update 입니다.
		
	}

	private static void delete() {
		
		
	}

}
