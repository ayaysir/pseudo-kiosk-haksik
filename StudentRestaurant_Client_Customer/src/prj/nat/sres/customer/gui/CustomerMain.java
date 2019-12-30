package prj.nat.sres.customer.gui;

import java.util.List;
import java.util.Scanner;

import prj.nat.sres.customer.net.ConnectionManager;
import prj.nat.sres.dto.Menu;

public class CustomerMain {

	public static void main(String[] args) {
		
		try(Scanner s = new Scanner(System.in);	) {			

			while(true) {
				int i = 1;
				System.out.println("==== 고객 메뉴 구매 ====");
				ConnectionManager cm = new ConnectionManager();
				List<Menu> list;

				list = cm.getMenuList();
				for(Menu t : list) {
					System.out.println(i++ + ". " + t.getMenuName());
				}

				int select = Integer.parseInt(s.nextLine());	

				System.out.println(cm.purchaseOneMenu(select - 1));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
