package text;

import model.Student;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // tạo file luuwu trữ
        File file = new File("text.txt");
        File file2 = new File("student.txt");


//        if (!file.exists()){
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//        // ghi ra file
//        try {
//            writeToFile("hunghx12345",file);
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//        try {
//            readFromFile(file);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
        // tạo đối tượng
//        Student st1 = new Student(1,"Hồ Xuân Hùng");
//        try {
//            writeToFile(st1.toString(),file2);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
    public  static void writeToFile(String text,File file) throws IOException{
       FileWriter fileWriter = new FileWriter(file);
       BufferedWriter writer = new BufferedWriter(fileWriter); // mở stream
            // ghi file
//            writer.write(text);
            // ghi từng kí tự từng hàng
//            for (int i = 0; i < text.length(); i++) {
//                writer.write(text.charAt(i));
//                writer.newLine();
//            }
//            writer.flush(); // đẩy từ bộ nhớ đệm ra file
        writer.write(text);
        writer.flush();
        writer.close();
    }
    public static void readFromFile(File file) throws IOException {
        FileReader fileReader = new FileReader(file); // đối tượng fileReader
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null ;
        while ((line = bufferedReader.readLine())!=null){
            System.out.println(line);
        }
    }
}
