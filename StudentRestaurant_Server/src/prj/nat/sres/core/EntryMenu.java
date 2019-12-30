package prj.nat.sres.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import prj.nat.sres.dto.Menu;
import prj.nat.sres.util.ExportCSV;
import prj.nat.sres.util.ImportCSV;
import prj.nat.sres.util.PropertiesManager;

// csv 파일로 입출력

public class EntryMenu {
	
	private List<Menu> list = new ArrayList<>();
	private String fileName = "newFile.csv";
	
	public EntryMenu() {
		
	}
	
	public EntryMenu(String fileName) throws Exception {
		this.fileName = fileName;
		entryCSV(fileName);
	}
	
	public List<Menu> getMenuList() {
		return list;
	}
	
	public void entryCSV(String fileName) throws Exception {
		this.fileName = fileName;
		list = new ImportCSV().menuImport(fileName);
		Properties props = new Properties();
		props.setProperty("currentFileName", fileName);
		new PropertiesManager().propertiesExport(props, "tempInfo.properties");
	}
	
	public void entryOneMenu(String category, String menuName, int price, int quantity) {
		Menu aMenu = new Menu(category, menuName, price, quantity);
		list.add(aMenu);
		
		new ExportCSV().menuExport(fileName, list);
	}
	
	public String printOutMenuList() {
		StringBuilder sb = new StringBuilder();
		for(Menu t : list) {
			sb.append(t.toCSV() + "\n");
		}
		return sb.toString();
	}

	
	
	
//	public static void main(String[] args) {
//		EntryMenu em = new EntryMenu();
//		em.entryOneMenu("ddd", 10000, 300);
//		System.out.println(em.tempViewList());
//	}

}
