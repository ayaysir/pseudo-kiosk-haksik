package prj.nat.sres.dto;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConnectionResource {

	private Socket sock;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    
	public ConnectionResource(Socket sock, ObjectInputStream ois, ObjectOutputStream oos) {
		super();
		this.sock = sock;
		this.ois = ois;
		this.oos = oos;
	}

	public Socket getSock() {
		return sock;
	}

	public void setSock(Socket sock) {
		this.sock = sock;
	}

	public ObjectInputStream getOis() {
		return ois;
	}

	public void setOis(ObjectInputStream ois) {
		this.ois = ois;
	}

	public ObjectOutputStream getOos() {
		return oos;
	}

	public void setOos(ObjectOutputStream oos) {
		this.oos = oos;
	}
	
}
