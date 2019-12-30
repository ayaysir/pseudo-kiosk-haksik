package prj.nat.sres.gui;

import java.util.Scanner;

import prj.nat.sres.core.EntryMenu;
import prj.nat.sres.server.OpenServer;

public class ServerMain {
	
	static final long serialVersionUID = 1L;
	
	public static void main(String[] args) throws Exception {		
		
		Scanner s = new Scanner(System.in);
		EntryMenu em = new EntryMenu();
		
		while(true) {
			int i = 1;
			System.out.println("==== 서버 메뉴 선택 ====");
			System.out.println(i++ + ". 메뉴 등록");
			System.out.println(i++ + ". 메뉴 세트 등록");
			System.out.println(i++ + ". 메뉴 확인");
			System.out.println(i++ + ". 서버 오픈(식당 영업 개시)");
			System.out.println(i++ + ". 설정 및 기타");
			System.out.println(i++ + ". 나가기");
			
			int select = Integer.parseInt(s.nextLine());			
			
			switch(select) {
			case 1:
				// em.entryOneMenu("뉴 카테고리2", "콘솔에서 입력됨2", 9999, 999);
				System.out.println("CSV 파일을 수정해주세요.");
				break;
			case 2:
				System.out.print("csv(확장자 제외) >> ");
				String fileName = s.nextLine();
				em.entryCSV(fileName.concat(".csv"));
				System.out.print("서버를 오픈하시겠습니까?(Y/N) >> ");
				String chr = s.nextLine();
				if(chr.equalsIgnoreCase("Y")) {
					new OpenServer(em.getMenuList());
				}				
				break;
			case 3:
				System.out.println(em.printOutMenuList());
				break;
			case 4:
				new OpenServer(em.getMenuList());
				break;
			case 5:
				System.exit(0);
				break;
			}
		}
		
	}
}

