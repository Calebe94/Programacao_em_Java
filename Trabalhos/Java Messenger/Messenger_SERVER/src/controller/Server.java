package controller;
import java.net.*;
import java.io.*;

public class Server extends Thread {
   private ServerSocket serverSocket;
   private Socket server;
   private DataInputStream in;
   private DataOutputStream out;
   //private int count = 0;
   public Server(int port) {
       try{
           serverSocket = new ServerSocket(port);
           InetAddress IP = InetAddress.getLocalHost();
           System.out.println(IP.getHostAddress());
       }catch (Exception e) {}
   }
   public void verifyOption(){
	   String[] options = MainController.getInstance().getGroupsOptions().split(":");
       boolean optionSelected = false;
       while(optionSelected == false){
    	   for(int count = 0; count < options.length; count++){
    		   String[] received = receiveData().split(":");
    		   if(received[0] == options[count]){
    			   MainController.getInstance().addClient2Group(server, received[0], received[1]);
    			   System.out.println("Adicionou o Cliente "+received[1]+" Ao Grupo "+received[0]);
    			   try{
    				   this.server.close();
    				   this.server = null;
    			   }catch(Exception e){}
            	   optionSelected = true;
            	   System.out.println("Fechou o Cliente!");
    			   break;
    		   }
    	   }
       }
       System.out.println("Saiu do Loop!");
   }
   public void listen(){
       try {
           //this.server = serverSocket.accept();
    	   Socket newClient = serverSocket.accept();
    	   DataOutputStream saida = new DataOutputStream(newClient.getOutputStream());
    	   saida.writeUTF(MainController.getInstance().getGroupsOptions());
    	   
           //sendData(MainController.getInstance().getGroupsOptions());
           //String returned = receiveData();
           DataInputStream entrada = new DataInputStream(newClient.getInputStream());
           String returned = entrada.readUTF();
           System.out.println(returned);
           //verifyOption();
           newClient.close();
       }catch(Exception e){}
   }

   public String getAddress(){
	   try{
		   InetAddress IP = InetAddress.getLocalHost();
		   return IP.getHostAddress().toString();
	   }catch(Exception e){}
	   return null;
   }
   public void sendData(String message){
       try {
           this.out = new DataOutputStream(this.server.getOutputStream());
           this.out.writeUTF(message);
       }catch (Exception e) {}
   }

   public String receiveData(){
       try {
           this.in = new DataInputStream(this.server.getInputStream());
           System.out.println(this.in.readUTF());
           return this.in.readUTF();
       }catch (Exception e) {}
       return null;
   }

   public void run() {
      while(true) {
          listen();
      }
   }
}
