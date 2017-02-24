public class ex1{
    public static void main(String args[]){
        int max = 399;
        int min = 201;
        int num_pares = 0;
        for(int count = 399; count > 200; count --){
            if(count % 2 == 0){
                num_pares++;
                System.out.println("Número:"+count+" É par!");
            }
        }
    }
}
