package prj.nat.sres.server;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import prj.nat.sres.dto.ConnectionResource;

public class StaticResource {
	
	public static final int PORT_NUM = 33355;
	// public static List<Menu> currentMenu = null;
	public static List<ConnectionResource> connectList = new CopyOnWriteArrayList<>();

}
