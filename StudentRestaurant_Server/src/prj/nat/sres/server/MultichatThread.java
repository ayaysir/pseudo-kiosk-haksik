package prj.nat.sres.server;

import java.io.IOException;
import java.util.List;

import prj.nat.sres.core.CurrentMenuMgmt;
import prj.nat.sres.dto.ConnectionResource;
import prj.nat.sres.dto.Menu;

public class MultichatThread extends Thread {

	private CurrentMenuMgmt cm;
	private ConnectionResource resource;    

	public MultichatThread(CurrentMenuMgmt cm, ConnectionResource resource) {
		this.cm = cm;
		this.resource = resource;
	}

	public ConnectionResource getResource() {
		return resource;
	}

	public void setResource(ConnectionResource resource) {
		this.resource = resource;
	}    

	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		try {
			
			resource.getOos().writeObject(cm.getCurrentMenu());
			resource.getOos().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while(true) {
			try {
				
				List<Menu> readObj = (List<Menu>) resource.getOis().readObject();
				if(readObj != null)	cm.setCurrentMenu(readObj);
				
				// View
				for(Menu t : cm.getCurrentMenu()) {
					System.out.println(t.toCSV());
				}
				
				for( ConnectionResource t : StaticResource.connectList ) // while true
				{ 
					// if (t.getSock() != resource.getSock()) {
						t.getOos().writeObject(readObj);
						t.getOos().flush();
					// }
				}
			} catch(Exception e) {StaticResource.connectList.remove(resource);}
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}            
	}
}
