import java.util.Scanner;

public class bandara {
    
    static String Nama;
    static String tujuan;
    static String jenispesawat;
    static int hargatiket;
    static int pembayaran;
    static String status;

    public bandara (String nama,String pergi, String jp, int ht, int bayar, String ver) {
        Nama = nama;
        tujuan = pergi;
        jenispesawat = jp;
        hargatiket = ht;
        pembayaran = bayar;
        status = ver;
    }
       
    public void displaymenu () {
        System.out.println("================================================");
        System.out.println("                      Menu                      ");
        System.out.println("================================================");
        System.out.println(" No Tujuan          Tujuan          Harga       ");
        System.out.println("    1               JOG              600        ");
        System.out.println("    2               SOC              500        ");
        System.out.println("    3               JKT              800        ");
        System.out.println("    4               SUB              600        ");
        System.out.println("    5               SRG              700        ");
        System.out.println("================================================");
        System.out.println(" No Pesawat         Class           Harga       ");
        System.out.println("    1               First            150%       ");
        System.out.println("    2               Business         120%       ");
        System.out.println("    3               Economy          100%       ");
        System.out.println("================================================");
        System.out.println("││││││││││││││││││││││││││││││││││││││││││││││││");
        System.out.println("================================================");
        System.out.println("                                                ");
    }
    
    public String nama (String NM) {
        Scanner nama = new Scanner(System.in);
        NM = nama.nextLine();
        return NM; 
        
    }
    
    public int BAYAR (int BYR) {
        Scanner bayar = new Scanner(System.in);
        System.out.print("Bayar          : ");
        BYR = bayar.nextInt();
        return BYR;
    }
    
    

    public String pesawat (String Pilih) {
        jenispesawat = Pilih;
        switch (Pilih) {
            case "1":
                jenispesawat = "First class";
                break;
            case "2":
                jenispesawat = "Business class";
                break;
            case "3":
                jenispesawat = "Economy class";
                break;
        }
        return jenispesawat;
    }
    
    public String go (String Pilih) {
        switch (Pilih) {
            case "1":tujuan = "JOG";
                break;
            case "2":tujuan = "SOC";
                break;
            case "3":tujuan = "JKT";
                break;
            case "4":tujuan = "SUB";
                break;
            case "5":tujuan = "SRG";
                break;
        }
        return tujuan;
    }

    public int Tiket (String pergi) {
    tujuan = pergi;
        switch (tujuan) {
            case "JOG": hargatiket = 600;
                break; 
            case "SOC": hargatiket = 500;
                break;
            case "JKT": hargatiket = 800;
                break;
            case "SUB": hargatiket = 600;
                break;
            case "SRG": hargatiket = 700;
                break;
        }
        return hargatiket;
    }

    public int biaya(String total) {
    jenispesawat = total;
        if (jenispesawat == "First class") {
            hargatiket = (int) (hargatiket *1.5);
        }  
        else if (jenispesawat == "Business class"){
            hargatiket = (int) (hargatiket *1.2);
        }
        else if (jenispesawat == "Economy class"){
            hargatiket = (int) (hargatiket *1.0);
        }
        return hargatiket;
    }

    public int Billing (int bil) {
        pembayaran = bil;
        if (pembayaran < hargatiket) {
            System.out.println("========== Maaf Uang anda tidak Cukup ==========");
            System.out.println("Harga tiket    : "+ hargatiket);
            pembayaran = pembayaran - hargatiket;
            System.out.println("Pembayaran Kurang : "+ pembayaran);
        }
        else if (pembayaran == hargatiket){
            System.out.println("Pembayaran Lunas !!!");
            System.out.println("Harga tiket    : "+ hargatiket);
        }
        else if (pembayaran > hargatiket){
            pembayaran = pembayaran - hargatiket;
            System.out.println("Pembayaran Lunas !!!");
            System.out.println("Harga tiket    : "+ hargatiket);
            System.out.println("Sisa Kembalian : "+ pembayaran);
            pembayaran = hargatiket;
        }
        return pembayaran;
    }

    public String verifikasi(int bill) {
        pembayaran = bill;
        if (pembayaran >hargatiket){
            status = "Terverifikasi";
        }
        else if (pembayaran == hargatiket){
            status = "Terverifikasi";
        }
        else {
            status = "Belum Terverifikasi";
        }
        return status;
    }

    public void Displayall (String nama, String pergi, String jp, int ht, int bayar, String ver) {
        System.out.println("================================================");
        System.out.println("││││││││││││││││││││││││││││││││││││││││││││││││");
        System.out.println("================================================");
        System.out.println("   Terimakasih telah menggunakan layanan kami   ");
        System.out.println("================================================");
        System.out.println("                    Tiket Pesawat               ");
        System.out.println("================================================");
        System.out.println(" Nama Penumpang = "+ nama);
        System.out.println(" Tujuan kota    = "+ pergi);
        System.out.println(" Jenis Pesawat  = "+ jp);
        System.out.println(" Harga Tiket    = "+ ht);
        System.out.println(" Pembayaran     = "+ bayar);
        System.out.println(" Status Tiket   = "+ ver);
        System.out.println("================================================");
    }
    public static void main(String[] args) {
        bandara Data = new bandara (Nama, tujuan, jenispesawat, hargatiket, pembayaran, status);
        
        Data.displaymenu();
        
        System.out.print("Nama Penumpang : ");
        String nama = Data.nama(Nama);
        
        System.out.print("No Tujuan Anda : ");
        String pergi = Data.nama (tujuan);
        Data.go(pergi);
        Data.Tiket(tujuan);
        
        System.out.print("Jenis Pesawat  : ");
        String jp = Data.nama(jenispesawat);
        Data.pesawat(jp);
        Data.biaya(jenispesawat);
        
        int bayar = Data.BAYAR (pembayaran);
        Data.Billing(bayar);
        System.out.println();
        
        Data.verifikasi(pembayaran);
        
        Data.Displayall(nama, tujuan, jenispesawat, hargatiket, pembayaran, status);

        
    } 
}