public class  BankAccount {
    private String nama;
    private String noRekening;
    private String password;
    private double saldo;

    public AkunBank(String nama, String noRekening, String password, double saldo) {
        setNama(nama);
        setNoRekening(noRekening);
        setPassword(password);
        setSaldo(saldo);
    }

    public void setNama(String nama) {
        if (nama.length() >= 4) {
            this.nama = nama;
        } else {
            System.out.println("❌ Nama minimal 4 karakter!");
        }
    }

    public void setNoRekening(String noRekening) {
        if (noRekening.length() >= 10) {
            this.noRekening = noRekening;
        } else {
            System.out.println("❌ No rekening minimal 10 karakter!");
        }
    }

    public void setPassword(String password) {
        boolean adaUnderscore = password.contains("_");
        boolean adaHurufBesar = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                adaHurufBesar = true;
                break;
            }
        }
        if (password.length() >= 8 && adaUnderscore && adaHurufBesar) {
            this.password = password;
        } else {
            System.out.println("❌ Password tidak valid!");
            System.out.println("   - Minimal 8 karakter");
            System.out.println("   - Harus mengandung underscore (_)");
            System.out.println("   - Harus ada minimal 1 huruf besar");
        }
    }

    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            System.out.println("❌ Saldo tidak boleh negatif!");
        }
    }

    public String getNama() { return nama; }
    public String getNoRekening() { return noRekening; }
    public double getSaldo() { return saldo; }

    public void cekSaldo(String password) {
        if (this.password.equals(password)) {
            System.out.println("✅ Saldo " + nama + ": Rp " + saldo);
        } else {
            System.out.println("❌ Password salah!");
        }
    }

    public void deposit(String password, double jumlah) {
        if (!this.password.equals(password)) {
            System.out.println("❌ Password salah!");
            return;
        }
        if (jumlah <= 0) {
            System.out.println("❌ Jumlah deposit harus lebih dari 0!");
            return;
        }
        saldo += jumlah;
        System.out.println("✅ Deposit Rp " + jumlah + " berhasil! Saldo sekarang: Rp " + saldo);
    }

    public void withdraw(String password, double jumlah) {
        if (!this.password.equals(password)) {
            System.out.println("❌ Password salah!");
            return;
        }
        if (jumlah <= 0) {
            System.out.println("❌ Jumlah penarikan harus lebih dari 0!");
            return;
        }
        if (jumlah > saldo) {
            System.out.println("❌ Saldo tidak cukup! Saldo kamu: Rp " + saldo);
            return;
        }
        saldo -= jumlah;
        System.out.println("✅ Penarikan Rp " + jumlah + " berhasil! Saldo sekarang: Rp " + saldo);
    }

    public void transfer(String password, AkunBank tujuan, double jumlah) {
        if (!this.password.equals(password)) {
            System.out.println("❌ Password salah!");
            return;
        }
        if (jumlah <= 0) {
            System.out.println("❌ Jumlah transfer harus lebih dari 0!");
            return;
        }
        if (jumlah > saldo) {
            System.out.println("❌ Saldo tidak cukup! Saldo kamu: Rp " + saldo);
            return;
        }
        saldo -= jumlah;
        tujuan.saldo += jumlah;
        System.out.println("✅ Transfer Rp " + jumlah + " ke " + tujuan.nama + " berhasil!");
        System.out.println("   Saldo kamu sekarang: Rp " + saldo);
    }

    public void displayAkun() {
        System.out.println("Nama       : " + nama);
        System.out.println("No Rek     : " + noRekening);
        System.out.println("Saldo      : Rp " + saldo);
    }
}