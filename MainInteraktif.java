import java.util.Scanner;

public class MainInteraktif {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("===== BUAT AKUN BANK =====");
        System.out.print("Masukkan nama        : ");
        String nama = input.nextLine();
        System.out.print("Masukkan no rekening : ");
        String noRek = input.nextLine();
        System.out.print("Masukkan password    : ");
        String pass = input.nextLine();
        System.out.print("Masukkan saldo awal  : ");
        double saldo = input.nextDouble();
        input.nextLine();

        AkunBank akun = new AkunBank(nama, noRek, pass, saldo);

        boolean running = true;
        while (running) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Cek Saldo");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int menu = input.nextInt();
            input.nextLine();

            switch (menu) {
                case 1:
                    System.out.print("Masukkan password: ");
                    String p1 = input.nextLine();
                    akun.cekSaldo(p1);
                    break;
                case 2:
                    System.out.print("Masukkan password: ");
                    String p2 = input.nextLine();
                    System.out.print("Jumlah deposit   : ");
                    double dep = input.nextDouble();
                    input.nextLine();
                    akun.deposit(p2, dep);
                    break;
                case 3:
                    System.out.print("Masukkan password: ");
                    String p3 = input.nextLine();
                    System.out.print("Jumlah penarikan : ");
                    double wit = input.nextDouble();
                    input.nextLine();
                    akun.withdraw(p3, wit);
                    break;
                case 4:
                    System.out.print("Masukkan password: ");
                    String p4 = input.nextLine();
                    System.out.print("No rekening tujuan: ");
                    String noTujuan = input.nextLine();
                    System.out.print("Jumlah transfer  : ");
                    double trf = input.nextDouble();
                    input.nextLine();
                    System.out.println("Fitur transfer butuh 2 akun, coba di versi hardcode!");
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    running = false;
                    break;
                default:
                    System.out.println("Menu tidak valid!");
            }
        }
        input.close();
    }
}