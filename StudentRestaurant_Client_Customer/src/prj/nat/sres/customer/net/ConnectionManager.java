package prj.nat.sres.customer.net;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import prj.nat.sres.dto.Menu;
import prj.nat.sres.dto.Purchase;

public class ConnectionManager {
	
	@SuppressWarnings("unchecked")
	public List<Menu> getMenuList() throws Exception  {
		
		try (Socket sock = new Socket("192.168.20.56", 33355);) {			

			// ois 생성 전 반드시 oos를 만들어야 됨
			ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(sock.getInputStream());
			
			List<Menu> list = (List<Menu>) ois.readObject();
			oos.close();
			ois.close();
			
			return list;			

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
	}
	
	@SuppressWarnings("unchecked")
	public boolean purchaseOneMenu(int menuIndex) throws Exception  {

		try (Socket sock = new Socket("192.168.20.56", 33355);) {			

			// ois 생성 전 반드시 oos를 만들어야 됨
			ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(sock.getInputStream());

			List<Menu> list = (List<Menu>) ois.readObject();
			
			int currentQuantity = list.get(menuIndex).getQuantity();
			list.get(menuIndex).setQuantity(currentQuantity - 1);
			oos.writeObject(list);
			oos.flush();
			oos.close();
			
			ois.close();
			
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public boolean purchaseSomeMenu(int menuIndex, int quantity) throws Exception  {

		try (Socket sock = new Socket("192.168.20.56", 33355);) {			

			// ois 생성 전 반드시 oos를 만들어야 됨
			ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(sock.getInputStream());

			List<Menu> list = (List<Menu>) ois.readObject();
			
			int currentQuantity = list.get(menuIndex).getQuantity();
			list.get(menuIndex).setQuantity(currentQuantity - quantity);
			oos.writeObject(list);
			oos.flush();
			oos.close();
			
			ois.close();
			
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean purchaseMultipleMenu(List<Purchase> purchaseList) throws Exception  {
		
		for(Purchase t : purchaseList) {
			purchaseSomeMenu(t.getMenuIndex(), t.getQuantity());
		}

		return true;
	}
}
