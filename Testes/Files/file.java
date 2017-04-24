import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class file {

    public static void main(String args[]) throws IOException {  
        PrintWriter out = null;
        String readData;
        try {
            out = new PrintWriter("meu_teste.txt");
            String Linha1 = "Linha1,Ainda Linha1";
            String Linha2 = "Linha2,Ainda Linha2";
            System.out.println("Exportando Dados!");
            out.println(Linha1);
            out.println(Linha2);
        
      }finally {
         if (out != null) {
            out.close();
         }
      }
      System.out.println("Lendo Dados!");
      Scanner fileIn = new Scanner(new File("meu_teste.txt"));]
      readData = fileIn.nextLine();
      System.out.print("Dados lidos:");
      for(String nome:readData.split(",")){
        System.out.print("\t"+nome);
      }
      System.out.println();
      readData = fileIn.nextLine();
      System.out.print("Dados lidos:");
      for(String nome:readData.split(",")){
        System.out.print("\t"+nome);
      }
   }
}
