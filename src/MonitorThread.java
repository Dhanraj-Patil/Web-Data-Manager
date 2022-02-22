import java.io.*;
import java.util.Arrays;

public class MonitorThread extends Thread{
    public synchronized void run(){
        task();
    }
    synchronized void task(){
        File file=new File("C:\\Dhanraj\\Dhanraj Website\\new_data_file");
        System.out.println(Arrays.toString(file.list()));
        try {
            while(true) {
                String[] file_list = file.list();

                if(file_list.length>0){
                    for (String name : file_list) {
                        System.out.println(name);
                        new FileHandler(name);
                    }
                }else{
                    System.out.println("No entity");
                }
                sleep(60000);
                System.out.println("1 min passed");
            }
        }catch(Exception e){
            System.out.println(e+": MonitorThread");
        }
    }
}
