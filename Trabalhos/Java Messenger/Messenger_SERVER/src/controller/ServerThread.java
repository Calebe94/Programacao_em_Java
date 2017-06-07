package controller;

public class ServerThread extends Thread {
	private Server server;
	public ServerThread(Server server ){
		this.server = server;
	}
	@Override
	public void run() {
		super.run();
		server.listen();
	}
}
