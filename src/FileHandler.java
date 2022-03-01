import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class FileHandler extends JsonHandler{
    private final String fileName;
    private final Path recentFile=Paths.get("C:\\Dhanraj\\Dhanraj Website\\recent\\recent.json");
    public FileHandler(String fileName) {
        this.fileName = fileName;
        sortFile();
    }

    protected void moveFile(String name, String catagory, String folder) {

        //1 for project
        //2 for blog
        //3 for courses

        String target = "C:\\Dhanraj\\Dhanraj Website\\" + folder + "\\" + name;
        String recentValue = "C:\\\\Dhanraj\\\\Dhanraj Website\\\\" + folder + "\\\\" + name;
        String source = "C:\\Dhanraj\\Dhanraj Website\\new_data_file\\" + fileName;
        int length=name.length();
        try {
            Files.move(Paths.get(source), Paths.get(target));
            recent(name.substring(0,length-5),catagory,recentValue);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected void recent(String name,String catagory, String path) {
        newObject(recentFile,catagory+" - "+name,path);
    }

    protected void sortFile() {
        String real_file_name = null;
        String folder = null;
        int n = 0;
        String catagory=null;
        try {
            if (fileName.startsWith("project_")) {
                real_file_name = fileName.substring(8);
                n = 1;
                catagory="Project";
                folder = "project_data";
                System.out.println(real_file_name);
            } else if (fileName.startsWith("blog_")) {
                real_file_name = fileName.substring(5);
                n = 2;
                catagory="Blog";
                folder = "blog_data";
                System.out.println(real_file_name);
            } else if (fileName.startsWith("course_")) {
                real_file_name = fileName.substring(7);
                n = 3;
                catagory="Course";
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
            moveFile(real_file_name,catagory, folder);
        }
    }
}
