import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.print.DocFlavor.STRING;

public class prog {

    public static void main(String[] args) {
       Notebook n1 = new Notebook("Acer", "Black", 51000,"kx23456");
       n1.setRam(32);
       n1.setStorage("SDD");
       Notebook n2 = new Notebook("Acer", "Black", 56000,"klm23456"); 
       n2.setRam(16);
       n2.setStorage("HDD");
       Notebook n3 = new Notebook("Sony", "White", 76000,"3eret456"); 
       n3.setRam(32);
       n3.setStorage("SDD"); 
       Notebook n4 = new Notebook("Digma", "White", 26000,"366456"); 
       n4.setRam(8);
       n4.setStorage("HDD");         
        Set<Notebook> compSet = new HashSet<>();
        compSet.add(n1);
        compSet.add(n2);
        compSet.add(n3);  
        compSet.add(n4);               
        System.out.println("Ноутбуки в базе:"); 
        for (Notebook comp: compSet) {
        System.out.println(comp);
        }
       
       HashMap<Integer,String> filterlist = new HashMap<>();

       filterlist.put(1,"Цена");
       filterlist.put(2,"Объем ОЗУ в Гб");
       filterlist.put(3,"Вид накопителя HDD/SDD"); 
       filterlist.put(4,"Цвет Black/White");   
       filterlist.put(5,"Сложный фильтр");                  

       System.out.println("Имеющиеся фильтры:");       
        for (Map.Entry<Integer, String> entry : filterlist.entrySet()) {
            System.out.println("Номер: " + entry.getKey() + ", Критерий: " + entry.getValue());
        }      
        System.out.println("Введите номер критерия фильтрации:");
        Scanner console = new Scanner(System.in);
        Scanner console2 = new Scanner(System.in);    
        // String name = console.nextLine();
        int ch = console.nextInt(); 
        if (ch ==4){
            System.out.println("Введите значение критерия фильтрации:");
            String chvalue = console2.nextLine(); 
            chvalue = chvalue.toLowerCase();

            for (Notebook notebook : compSet) {
                if (chvalue.equals(notebook.getColor())) {
                    System.out.println(notebook);
                }
            }      
        }
        else if (ch ==1){
            System.out.println("Введите минимальное значение цены:");
            int chvalue = console.nextInt(); 
         

            for (Notebook notebook : compSet) {
                int price = notebook.getPrice();

                if (price>chvalue) {
                    System.out.println(notebook);
                }
            }      
        }
        else if (ch ==2){
            System.out.println("Введите минимальное значение ОЗУ:");
            int chvalue = console.nextInt(); 
         

            for (Notebook notebook : compSet) {
                int ram = notebook.getRam();

                if (ram>chvalue) {
                    System.out.println(notebook);
                }
            }      
        }
        if (ch ==3){
            System.out.println("Введите вид накопителя (HDD или SDD):");
            String chvalue = console2.nextLine(); 
            chvalue = chvalue.toLowerCase();

            for (Notebook notebook : compSet) {
                if (chvalue.equals(notebook.getStorage())) {
                    System.out.println(notebook);
                }
            }      
        }
        if (ch ==5){
            System.out.println("Введите требуемые занчения фильтров. Если фильтр не нужен нажмите enter:");


            HashMap<Integer,String> userfilter = new HashMap<>();
            for (Map.Entry<Integer, String> entry : filterlist.entrySet()) {
                Integer key =  entry.getKey();
                if (key<5){
                System.out.println(entry.getValue());             
                String fvalue = console2.nextLine(); 
                fvalue = fvalue.toLowerCase();
                userfilter.put(key, fvalue);
                }
            }     

             for (Notebook notebook : compSet) {
                boolean Fl = true;
                for (Map.Entry<Integer, String> entry : userfilter.entrySet()) 
                {
             
                int key = entry.getKey();
                int fvalue = 0;
                String fvalue2 =""; 

            
                if (key==1 || key ==2 )
                {
                    fvalue2 = entry.getValue();
                    if (fvalue2!="")  fvalue = Integer.parseInt(entry.getValue());
                }
                else {
                    fvalue2 = entry.getValue();
                    // System.out.println(key);                    
                    // System.out.println(fvalue2);
                }

                switch (key) {
                    case  1:
                    if (fvalue>0)
                    {
                    int price = notebook.getPrice();
                    if (price < fvalue) Fl = false;                  
                    }
                    break;
                    case  2:
                    if (fvalue>0)
                    {
                    int ram = notebook.getRam();
                    if (ram<fvalue) Fl = false;
                    }                  
                    break;                    
                    case  3:
                    if (fvalue2!="")
                    {
                    
                    if (fvalue2.equals(notebook.getStorage())) 
                    {}
                    else  {
                        Fl = false;
                        System.out.println(fvalue2+"  "+notebook.getStorage());
                    
                    }    
                    }               
                    break;  
                    case  4:
                    if (fvalue2!="")
                    {
                    if (fvalue2.equals(notebook.getColor())) {}
                    else  Fl = false;  
                    }                 
                    break;                      
                }

               
                

                }
                if (Fl) System.out.println(notebook);
            }      
        }
    }

}