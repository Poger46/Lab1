import java.io.*;
import java.util.zip.*;

public class Arx {

    public static void main(String[] args) {

        String filename = "C:\\Users\\Poger46\\untitled8\\src\\arx.txt";
        try(ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("C:\\Users\\Poger46\\untitled8\\src\\output.zip"));
            FileInputStream fis= new FileInputStream(filename);)
        {
            ZipEntry entry1=new ZipEntry("arx.txt");
            zout.putNextEntry(entry1);
            // считываем содержимое файла в массив byte
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            // добавляем содержимое к архиву
            zout.write(buffer);
            // закрываем текущую запись для новой записи
            zout.closeEntry();
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
}