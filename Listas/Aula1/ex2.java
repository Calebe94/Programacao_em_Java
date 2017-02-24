import javax.swing.JOptionPane;
public class ex2{
    public static void main(String[] args) {

        int num_func=0;
        String get_num_func;
        get_num_func = JOptionPane.showInputDialog(null, "Digite o Número de Funcionários:", "Funcionários", JOptionPane.QUESTION_MESSAGE);
        num_func = Integer.parseInt(get_num_func);

        int sal_total = 0;
        int sal_medio = 0;
        for(int counter = 0 ; counter < num_func ; counter ++){
            int aux = 0;
            String string="";
            int pos = counter+1;
            String message = "Digite o Salário do "+pos+"° Funcionário:";
            string = JOptionPane.showInputDialog(null,message,"Salários",JOptionPane.QUESTION_MESSAGE);
            aux = Integer.parseInt(string);
            sal_total = sal_total + aux;
        }
        sal_medio = sal_total/num_func;
        System.out.println("O Salário médio dos Funcionários é:"+sal_medio);
    }
}
