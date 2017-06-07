package model;
import java.net.*;
import java.io.*;
import java.util.Scanner;
import controller.*;
public class Client extends Thread{
    private Socket client;
    private OutputStream outToServer;
    private DataOutputStream out;

    private InputStream inFromServer;
    private DataInputStream in;

    public Client(String serverName, int port){
        try{
            System.out.println("Connecting to "+serverName+" on Port "+ port);
            this.client = new Socket(serverName, port);
            // Testes com os Grupos !
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void sendData(String message){
        try{
            this.outToServer = client.getOutputStream();
            this.out = new DataOutputStream(outToServer);

            //this.out.writeUTF("Client Says: "+message);
            this.out.writeUTF(message.toString());
        }catch(IOException e){}
    }
    public String receiveData(){
        try{
            this.inFromServer = client.getInputStream();
            this.in = new DataInputStream(inFromServer);

            //System.out.println(this.in.readUTF());
            return this.in.readUTF();
        }catch (Exception e) {}
        return null;
    }

    @Override
    public void run(){
    	
		String groups = receiveData();
		System.out.println(groups);
		MainController.getInstance().setGroupsCombobox(groups);
		
    	String[] options = groups.split(":");
    	boolean optionSelected = false;
        while(optionSelected == false){
     	   for(int count = 0; count < options.length; count ++){
     		   String selection = MainController.getInstance().getSelection().toString();
     		   if(selection.toString() == options[count].toString()){
     			   System.out.println(selection);
     			   sendData(selection.toString());
     			   break;
     		   }
     	   }
     	   System.out.println("Sem dados Para Enviar!");
        }
    	
        while(true){
        	sendData(MainController.getInstance().getMessage()); 
        }
    }

    public void keyboardScanner(){
        Scanner keyboard = new Scanner(System.in);
        while(keyboard.hasNext()){
            sendData(keyboard.nextLine());
        }
    keyboard.close();

    }
    /*
    public static void main(String [] args) {

        String serverName = "127.0.1.1";
        int port = 12345;
        try{
            Thread clientThread = new Client(serverName,port);
            clientThread.start();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
