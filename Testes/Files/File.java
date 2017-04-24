import java.util.*;
public class File{
    public static void main(String[] args){
        static final String fileServices = "/home/calebe/workspace_neon/Trabalho/Services.md";
        try{
            this.service_file = new Formatter(fileServices);
        }catch(Exception e){}
        ArrayList<> lista = new ArrayList<>();
        for (index = 0; index < limit;index++){
            ArrayList<Service> aux = services.getServicesRegistred();
            String name = aux.get(index).getServiceName();
            double value = aux.get(index).getValuePerHour();
            this.service_file.format("%s:%f",name,value);
        }
    }
}
