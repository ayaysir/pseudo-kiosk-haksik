package prj.nat.sres.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import prj.nat.sres.core.CurrentMenuMgmt;
import prj.nat.sres.dto.ConnectionResource;
import prj.nat.sres.dto.Menu;


public class OpenServer {
	
	private CurrentMenuMgmt cm;


	public OpenServer() {

	}

	public OpenServer(List<Menu> list) throws Exception{
		// StaticResource.currentMenu = list;
		cm = new CurrentMenuMgmt(list);
		
		
		startCore();		
	}

	public void startCore() {
		
		// 1. 메뉴 목록 전송
		System.out.println("서버 가동중");
		

		try(ServerSocket server = new ServerSocket(StaticResource.PORT_NUM);
				) { 		
			
			while(true) {				
				
				Socket sock = server.accept();	
				ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());	
				ObjectInputStream ois = new ObjectInputStream(sock.getInputStream());
				
				System.out.println( sock.getLocalAddress() + " 접속");					

				ConnectionResource resource = new ConnectionResource(sock, ois, oos);
				StaticResource.connectList.add(resource);							

				new MultichatThread(
						cm,
						StaticResource.connectList.get(StaticResource.connectList.size() - 1)
						).start();
				
				Thread.sleep(100);
				
				

			}  	

		} catch(Exception e) {System.err.println(e);}

	}

}
