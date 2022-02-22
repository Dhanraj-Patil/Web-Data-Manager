public class Boss {
    public static void main(String[] args)
    {
        MonitorThread thread=new MonitorThread();
        thread.setName("FolderMonitor");
        thread.start();
    }
}
