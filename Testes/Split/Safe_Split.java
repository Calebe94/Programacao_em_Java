public class Safe_Split{
    public static void main(String [] args) {
        String line = "Olá Mundo />/> Comé que seis Tão?";
        String[] cmdArgs = line.split("/>/>");
        for(int index = 0; index<cmdArgs.length; index++){
            System.out.println(cmdArgs[index]);
        }

    }
}
