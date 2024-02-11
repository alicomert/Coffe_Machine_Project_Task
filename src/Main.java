public class Main {
    public static void main(String[] args) throws InterruptedException {

        String metin = "KAHVE MAKİNESİ BAŞLATILIYOR : ";
        int yuklemeSuresi = 2000;
        int adimSayisi = 20;
        int adimSuresi = yuklemeSuresi / adimSayisi;
        System.out.println(metin);
        for (int i = 0; i <= adimSayisi; i++) {
            System.out.print("\r[");

            for (int j = 0; j < i; j++) {
                System.out.print("=");
            }

            for (int j = i; j < adimSayisi; j++) {
                System.out.print(" ");
            }

            System.out.print("]");
            Thread.sleep(adimSuresi);
        }
        System.out.println("\nKAHVE MAKİNESİ BAŞLATILDI!");
        KahveMakinesi yeniKahve=new KahveMakinesi();
        yeniKahve.kahveTuruSec();

    }


}
