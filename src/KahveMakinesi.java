import java.util.Scanner;

public class KahveMakinesi {
    private boolean sut;
    private boolean seker;
    private int sekerMiktari;
    private Kahve kahve;
    private KahveBoyutu kahveBoyutu;


    Scanner readInt = new Scanner(System.in);
    Scanner readStr = new Scanner(System.in);

    public void kahveTuruSec() {
        for (Kahve kahve1 : Kahve.values()) {
            System.out.println(kahve1);
        }

        System.out.print("Kahvenizinin Türünü Seçebilir Misiniz : ");
        String kahve1 = readStr.nextLine().trim().toUpperCase();  // türk kahvesi

        try {
            this.kahve = Kahve.valueOf(kahve1); // String i enum a çeviriyoruz
            if (this.kahve == Kahve.BUZLUKAHVE || this.kahve == Kahve.FRAPPUCCINO) {
                System.out.println("Sıcak bir yaz gününde serinlemenin " +
                        "en iyi yolu… Mükemmel karar!");
            } else {
                System.out.println("Tam zamanında yetiştin");
            }

            String boyut = kahveBoyutu();

            System.out.println(boyut + " " + kahve1 + " hazırlanıyor..");

            Thread.sleep(1000);

            System.out.println(kahve1+" Süt Eklemek İster Misiniz(E/H)");
            String sutCevap=readStr.nextLine();

            if (sutCevap.equalsIgnoreCase("evet")){
                System.out.println(kahve1+" süt ekleniyor lütfen bekleyiniz");
                Thread.sleep(1000);
            }else{
                System.out.println(kahve1+" sütsüz hazırlanıyor");
            }

            int sugar =sekerMiktari();

            if (sugar > 0 && !(sutCevap.equalsIgnoreCase("evet")) ){
                System.out.println(boyut+" "+kahve1+" sütsüz"+
                        " "+ sugar+" küp şekele hazırlanıyor.." );
            } else if (!(sutCevap.equalsIgnoreCase("E")) && sugar==0) {
                System.out.println(boyut+" "+kahve1+" sütsüz ve şekersiz hazırlanıyor..");
            } else if ((sutCevap.equalsIgnoreCase("E") && sugar > 0)) {
                System.out.println(boyut+" "+kahve1+" süt ve "+
                        sugar+" "+" küp şekerle hazırlanıyor");
            } else {
                System.out.println(boyut+" "+kahve1+
                        " sütle hazırlanıyor,şeker ilave edilmeyecek");
            }


        } catch (IllegalArgumentException illegal) {
            System.out.println("Geçersiz seçim. Lütfen geçerli bir seçim yapınız!");
            kahveTuruSec(); // eğer catch içine girerse kahveSec(); methoduna
            // giderek döngü gibi davranıp kahveSec(); methoduna
            // yeniden girer
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public String kahveBoyutu() {
        for (KahveBoyutu boyut : KahveBoyutu.values()) {
            System.out.println(boyut);
        }

        System.out.print("Kahve Boyutunu Seçebilir Misiniz : ");
        String boyut = readStr.nextLine().trim().toUpperCase();

        try {
            this.kahveBoyutu = KahveBoyutu.valueOf(boyut);

        } catch (IllegalArgumentException exception) {
            System.out.println("Geçersiz seçim. Lütfen geçerli bir seçim yapınız!");
            kahveBoyutu();
        }

        return boyut;
    }

    public int sekerMiktari(){

        System.out.print(this.kahve + " şeker ister misiniz?(E/H) : ");
        String sekerCevap=readStr.nextLine();


        if (sekerCevap.equalsIgnoreCase("Evet")){
            System.out.print("Kaç Şeker İsterseniz : ");
            int sekerSayisi=readInt.nextInt();
            return sekerSayisi;

        }else {
            System.out.println("Kahveniz Şekersiz Hazırlanıyor");

        }


        return 0;
    }

    public boolean isSut() {
        return sut;
    }

    public void setSut(boolean sut) {
        this.sut = sut;
    }

    public boolean isSeker() {
        return seker;
    }

    public void setSeker(boolean seker) {
        this.seker = seker;
    }

    public int getSekerMiktari() {
        return sekerMiktari;
    }

    public void setSekerMiktari(int sekerMiktari) {
        this.sekerMiktari = sekerMiktari;
    }

    public Kahve getKahve() {
        return kahve;
    }

    public void setKahve(Kahve kahve) {
        this.kahve = kahve;
    }

    public KahveBoyutu getKahveBoyutu() {
        return kahveBoyutu;
    }

    public void setKahveBoyutu(KahveBoyutu kahveBoyutu) {
        this.kahveBoyutu = kahveBoyutu;
    }
}


//    public void kahveTurleri() {
//        System.out.println("Menüden bir Kahve Seçimi Giriniz :" +
//                "1-Americano\n" +
//                "2-Espresso\n" +
//                "3-Cappucino\n" +
//                "4-Latte\n" +
//                "5-Mocha\n" +
//                "6-Macchiato\n" +
//                "7-Affogato\n" +
//                "8-Buzlu Kahve (Soğuk kahve)\n" +
//                "9-Frappuccino (Soğuk kahve)\n" +
//                "10-Irish\n" + "0-Çıkış");
//
////        for (Kahve kahve1 : Kahve.values()){ // Enum listesindeki
////            System.out.println(kahve1);    // sabitleri yazım şekli
////        }
//
//    }
//
//    public void kahveSecimi() {
//
//        int secim = readInt.nextInt();
//
//        switch (secim) {
//            case 1:
//                this.kahve = Kahve.AMERICANO;
//                System.out.println(this.kahve + " yi seçtiniz");
//                System.out.println("Kahve Boyutunu Seçiniz");
//
//
//
//
//            case 2:
//                this.kahve = Kahve.ESPRESSO;
//                System.out.println(this.kahve + " yi seçtiniz");
//            case 3:
//                this.kahve = Kahve.CAPPUCINO;
//                System.out.println(this.kahve + " yi seçtiniz");
//            case 4:
//                this.kahve = Kahve.LATTE;
//                System.out.println(this.kahve + " yi seçtiniz");
//            case 5:
//                this.kahve = Kahve.MOCHA;
//                System.out.println(this.kahve + " yi seçtiniz");
//            case 6:
//                this.kahve = Kahve.MACCHIATO;
//                System.out.println(this.kahve + " yi seçtiniz");
//            case 7:
//                this.kahve = Kahve.AFFOGATO;
//                System.out.println(this.kahve + " yi seçtiniz");
//            case 10:
//                this.kahve = Kahve.IRISH;
//                System.out.println(this.kahve + " yi seçtiniz");
//                System.out.println("Tadı damağımda kaldı");
//                break;
//
//            case 8:
//                this.kahve = Kahve.BUZLUKAHVE;
//                System.out.println(this.kahve + " yi seçtiniz");
//            case 9:
//                this.kahve = Kahve.FRAPPUCCINO;
//                System.out.println(this.kahve + " yi seçtiniz");
//                System.out.println("Sicak bir yaz gününde serinlemenin en iyi yolu… Mükemmel karar!");
//                break;
//
//            default:
//                System.out.println("Geçersiz seçim. Lütfen geçerli bir düğmeye basın!");
//        }
//    }