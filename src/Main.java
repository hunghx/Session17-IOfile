import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        File demo = new File("C:\\Users\\hung1\\OneDrive\\Desktop\\demoApi\\Session17-IOFile\\demo");
        System.out.println(demo.getParentFile().getName());
        System.out.println(demo.getName());
        File file = new File("C:\\Users\\hung1\\OneDrive\\Desktop\\demoApi\\Session17-IOFile\\demo\\demo1.txt");
        System.out.println(file.exists());
//
//
//        if (!file.exists()){
//            file.mkdirs();
//        }
       File fileParent = file.getParentFile().getParentFile();
        System.out.println(fileParent.getName());

        // "C:\Users\hung1\OneDrive\Desktop\springconfig.txt"
        // một số phương thức làm việc của lớp File
// xóa toàn bộ file trong demo

        for (String fileName: demo.list()
             ) {
            File subFile = new File(demo, fileName);
            if (subFile.exists()){
                subFile.delete();
            }
        }
        for (File f : demo.listFiles()){
            f.delete();
        }




    }

}