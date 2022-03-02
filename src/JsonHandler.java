import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class JsonHandler {
    public static void newJson(String name, String path){
        File file=new File(path+"\\"+name);
        try {
            file.createNewFile();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void newObject(Path path, String key, String value){
        try {
            List<String> lines=Files.readAllLines(path);
            int size=lines.size();
            System.out.println("Size: "+size);

            String str="\t\""+key+"\":"+" \""+value+"\",";

            if(size==0){
                str="{\t\n\""+key+"\":"+" \""+value+"\"\n}";
                lines.add(0,str);
            }else{
                lines.add(1,str);

            }
            Files.write(path,lines, StandardCharsets.UTF_8);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
