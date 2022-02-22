import java.io.*;
import java.util.Scanner;

public class JsonHandler {
    public static void newJson(String name, String path){
        File file=new File(path+"\\"+name);
        try {
            if(file.createNewFile()){
                System.out.println("File created: "+name);
                BufferedWriter br=new BufferedWriter(new FileWriter(file));
                br.write("{");
                br.write("}");
                br.close();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void newObject(File file,String key,String value){
        try {
            FileReader br=new FileReader(file);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            String str="\""+key+"\":"+"\""+value+"\",";
            int start=br.read();
            System.out.println(start);
//            if(start=="{}"){
//                str="{\""+key+"\":"+"\""+value+"\",}";
//            }
            bw.write(str,0,str.length());
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String []args){
//        newJson("recent.json","C:\\Dhanraj\\Dhanraj Website\\recent");
        newObject(new File("C:\\Dhanraj\\Dhanraj Website\\recent\\recent.json"),"name","Dhanraj");
    }
}
