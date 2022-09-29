package view;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public abstract class ReadAndWrite {
    public List<Integer> read(String csvfile)  {
        String line = "";
        String splitBy = ";";
        List<Integer> listNilai = new ArrayList<>();
        try{
            File file = new File(csvfile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine())!=null){
                String [] tempArr=line.split(splitBy);
//                   map.put(tempArr[0]);
                int nilaiRata = 0;
                for(int i = 1; i<tempArr.length; i++){
                    listNilai.add(Integer.parseInt(tempArr[i]));
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listNilai;
    }

    public void writeFile(Map<Object,Object> data, int pilihan){
        String txtFile = "D:\\Developing\\synergy-binar-batch-5\\Challenge_2\\Challenge 2";
        try{
            File file = new File(txtFile);
            if(file.createNewFile()){
                System.out.println("New File is Created ");
            }
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bwr = new BufferedWriter(fileWriter);
            bwr.write("Berikut Hasil Pengolahan Nilai : ");
            bwr.newLine();
            if(pilihan == 1){
                bwr.write("Nilai"+"\t\t\t\t\t"+"Frekuensi");
            }else if(pilihan== 2){
                bwr.write("Berikut hasil Pesebaran data Nilai");
            }
            for(Map.Entry<Object,Object> entry : data.entrySet()){
                    bwr.write(entry.getKey().toString()+"\t\t\t\t\t"+ entry.getValue().toString());
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
