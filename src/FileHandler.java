import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

class FileHandler{
    private final String fileName;
    public FileHandler(String fileName) {
        this.fileName = fileName;
        sortFile();
    }

    protected void moveFile(String name, String folder, int n) {

        //1 for project
        //2 for blog
        //3 for courses

        String target = "C:\\Dhanraj\\Dhanraj Website\\" + folder + "\\" + name;
        String source = "C:\\Dhanraj\\Dhanraj Website\\new_data_file\\" + fileName;
        try {
            Files.move(Paths.get(source), Paths.get(target));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected void recent(String name, Path path) throws IOException {
        File file=new File("C:\\Dhanraj\\Dhanraj Website\\recent\\recent.txt");
        FileReader fr= new FileReader(file);
        System.out.println(fr.read());
        Scanner sc=new Scanner(file);
        if(sc.hasNextLine()){
                    }
    }

    protected void sortFile() {
        String real_file_name = null;
        String folder = null;
        int n = 0;
        try {
            if (fileName.startsWith("project_")) {
                real_file_name = fileName.substring(8);
                n = 1;
                folder = "project_data";
                System.out.println(real_file_name);
            } else if (fileName.startsWith("blog_")) {
                real_file_name = fileName.substring(5);
                n = 2;
                folder = "blog_data";
                System.out.println(real_file_name);
            } else if (fileName.startsWith("course_")) {
                real_file_name = fileName.substring(7);
                n = 3;
                folder = "course_data";
                System.out.println(real_file_name);
            } else {
                throw new Exception("Invalid File, include prefix");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        //1 for project
        //2 for blog
        //3 for

        if (n != 0) {
            moveFile(real_file_name, folder, n);
        }
    }
}
