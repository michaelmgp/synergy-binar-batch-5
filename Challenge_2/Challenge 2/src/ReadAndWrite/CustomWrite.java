package ReadAndWrite;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CustomWrite {

    public void writeKelompokData(Map<String, String> listAllData) {
        String txtFile = "D:\\Developing\\synergy-binar-batch-5\\Challenge_2\\Challenge 2\\kelompok_data.txt";
        try{
            File file = new File(txtFile);
            if(file.createNewFile()){
                System.out.println("New File is Created ");
            }
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bwr = new BufferedWriter(fileWriter);
            bwr.write("Berikut Hasil Pengolahan Nilai : ");
            bwr.newLine();
            bwr.write("Nilai"+"\t\t\t\t\t"+"Frekuensi");
            bwr.newLine();
            for(Map.Entry<String,String> entry : listAllData.entrySet()){
                bwr.write(entry.getKey()+"\t\t\t\t\t"+ entry.getValue());
                bwr.newLine();
            }
            bwr.flush();
            bwr.close();
            System.out.println("Succesfully written to a file");
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }
    public void writePersebaranData(Map<String, String> listAllData){
        String txtFile = "D:\\Developing\\synergy-binar-batch-5\\Challenge_2\\Challenge 2\\persebaran_data.txt";
        try{
            File file = new File(txtFile);
            if(file.createNewFile()){
                System.out.println("New File is Created ");
            }
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bwr = new BufferedWriter(fileWriter);
            bwr.write("Berikut Hasil Pengolahan Nilai : \n");
            bwr.newLine();
            bwr.write("Berikut Hasil Persebaran Data");
            bwr.newLine();
            for(Map.Entry<String,String> entry : listAllData.entrySet()){
                bwr.write(entry.getKey()+" : "+ entry.getValue());
                bwr.newLine();
            }
            bwr.flush();
            bwr.close();
            System.out.println("Succesfully written to a file");
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }
}
