package binary;

import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        File file2 = new File("student.txt");
        List<Student> list  = Arrays.asList(new Student(1,"Hồ Xuân Hùng"),new Student(2,"Trần Hồng Sơn"));
            writeToFile("student.txt",list);
        System.out.println(readFromFile("student.txt"));
//        try {
//            writeToFile(file2,list);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        //  bài toán lưu trữ : danh sách sinh viên
        // lưu cả 1 list - 1 object
        // lưu từng Student - nhiều object
//        List<Student> list = readFromFile("student.txt");
//        Student s1 = new Student(1,"Hồ Xuân Hùng");
//        // thêm mới
//        list.add(s1);
//        writeToFile("student.txt",list); // ghi đè
//        System.out.println(list);

        // ghi chèn
    }

    public static  List<Student> readFromFile(String fileName)  {
        List<Student> list = new ArrayList<>();
        File file = new File(fileName);
        FileInputStream  fis =null;
        ObjectInputStream ois =null;
        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis); // trả về 1 stream
            // tiến hành ghi file
            Student std = null;
            while ((std = (Student) ois.readObject()) != null) {
                list.add(std);
            }
            ;
        }catch (EOFException e){
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return list;
    }
    public static void writeToFile(String fileName,List<Student> list) {
       File file = new File(fileName);
       FileOutputStream  fos =null;
       ObjectOutputStream oos =null;
       try{
           fos = new FileOutputStream(file,true); // ghi đè , append = false


           // tiến hành ghi file
           for (Student s:list) {
               // check file có rỗng hay không
               if(file.length()==0){
                   oos = new ObjectOutputStream(fos);
               }else {
                   oos = new MyObjectOutputStream(fos);
               }
                oos.writeObject(s);
           }
//           oos.flush(); // đảy từ bộ nhứ đệm vào file
       }catch (IOException e){
           e.printStackTrace();
       }finally {
           if (oos!=null){
               try {
                   oos.close();
               } catch (IOException e) {
                   throw new RuntimeException(e);
               }
           }
       }

    }

}
