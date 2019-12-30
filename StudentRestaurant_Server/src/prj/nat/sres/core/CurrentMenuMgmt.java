package prj.nat.sres.core;

import java.util.List;

import prj.nat.sres.dto.Menu;

public class CurrentMenuMgmt {
	
	private List<Menu> currentMenu;
	
	public CurrentMenuMgmt(List<Menu> list) {
		this.currentMenu = list;
	}

	public List<Menu> getCurrentMenu() {
		return currentMenu;
	}

	public void setCurrentMenu(List<Menu> currentMenu) {
		this.currentMenu = currentMenu;
	}
	
	
}
