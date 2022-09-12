package interfaces;

public interface PressAnyKey {
    public static void pressAnyKey(){
        System.out.println("Tekan ENTER Untuk Kembali Ke Menu Utama . . . . ");
        try{
            System.in.read();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
