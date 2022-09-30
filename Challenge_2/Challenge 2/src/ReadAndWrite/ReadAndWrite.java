package ReadAndWrite;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public abstract class ReadAndWrite extends CustomWrite {

    Scanner scanner = new Scanner(System.in);
    public boolean readFile(String csvfile)  {
        File file = new File(csvfile);
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan\n" +
                    "1. Kembali ke menu utama\n" +
                    "0. Exit");
            int pilihan = scanner.nextInt();
            if(pilihan==1){
                return true;
            }else {
                System.exit(0);
            }
        }

        return false;
    }

    public List<Integer> convertedData(String pathlain){
        List<Integer> listNilai = new ArrayList<>();
        String line = "";
        String splitBy = ";";
        File file = new File(pathlain);
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader br = new BufferedReader(fr);
        while (true){
            try {
                if (!((line = br.readLine())!=null)) break;
            } catch (IOException e) {

            }
            String [] tempArr=line.split(splitBy);
            for(int i = 1; i<tempArr.length; i++){
                listNilai.add(Integer.parseInt(tempArr[i]));
            }
        }

        return listNilai;
    }


    public boolean writeFile(Map<String,String> data, Integer pilihan){

        if(pilihan==1){
            writeKelompokData(data);
        }else if(pilihan==2){
            writePersebaranData(data);
        }
        return true;
    }
    public boolean writeFile(Map<String,String> data,Map<String,String> data2){
        writeKelompokData(data);
        writePersebaranData(data2);
        return true;
    }


}
