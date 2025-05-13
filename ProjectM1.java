package com.juaracoding;

import java.util.Scanner;

public class ProjectM1 {

    // Variabel global agar bisa diakses dan dimodifikasi oleh semua method
    static String status;
    static String[][] daftarFilm = new String[10][4]; // Maksimal 10 film, setiap film punya 4 data: Judul, Genre, Durasi, Rating
    static int jumlahFilm = 0;

    public static void main(String[] args) {
        login(); // Panggil method login

        // Jika login berhasil, tampilkan menu terus-menerus
        if (status.equals("Berhasil Login")) {
            while (true) { // Looping agar bisa kembali ke menu utama setelah selesai satu aksi
                TampilkanMenu();
            }
        } else {
            System.out.println("Gagal menampilkan menu karena login gagal."); // menu tidak akan ditampilkan karna gagal login
        }
    }

    // Method login
    static void login() {
        String username = "admin";
        String password = "12345";

        Scanner input = new Scanner(System.in); // Scanner supaya huser dapat memasukan informasi
        System.out.println("Masukan Username:");
        String inputUsername = input.next();
        System.out.println("Masukan Password:");
        String inputPassword = input.next();

        // Validasi username dan password
        if (inputUsername.equals(username) && inputPassword.equals(password)) { //ketika salah satunya salah akan mengahasilkan gagal login
            status = "Berhasil Login";
            System.out.println(status);
        } else {
            status = "gagal login";
            System.out.println("Username atau Password tidak sesuai");// komentar yang akan dihasilkan ketika gagal login
        }
    }

    // Menu utama
    static void TampilkanMenu() { // merupakan function yang berisikan list menu utama yang akan tampil ketika berhasil login
        System.out.println("\n===== Menu Layanan =====");
        System.out.println("1. Tampilkan data film");
        System.out.println("2. Input data film");
        System.out.println("3. Cari film");
        System.out.println("4. Keluar");

        Scanner input = new Scanner(System.in);
        System.out.print("Masukan pilihanmu: ");
        int pilihan = input.nextInt();
        input.nextLine(); // user dapat memasukan lebih dari satu kata

        switch (pilihan) {
            case 1:
                TampilkanDataFilm(); // mengambil data dari function Tampilkan data film
                break; // berguna menghentikan percabangan
            case 2:
                InputFilmBaru();    // mengambil data dari function InputFIlmBaru
                break; // akan menghentikan percabangan ketika case tersebut dipilih
            case 3:
                CariFilm();
                break;
            case 4:
                System.out.println("Keluar dari program. Terima kasih!");
                System.exit(0); // Keluar dari program ketika tidak memilih menu
                break;
            default:
                System.out.println("Menu yang anda pilih tidak tersedia."); // akan tampil jika user menginputkan selain angka 1 hingga 4
        }
    }

    // Menampilkan semua data film
    static void TampilkanDataFilm() { //funtion yang akan menampilkan list utama
        if (jumlahFilm == 0) { //memberikan case jika tidak ada list film maka tidak dapat diakses
            System.out.println("Belum ada data film.");// akan menampilkan output ini ketika tidak ada list film
        } else { //kondisi yang akan ditampilkan ketika terdapat list film didalamnya
            System.out.println("\n===== Daftar Film =====");
            for (int i = 0; i < jumlahFilm; i++) {
                System.out.println("Judul  : " + daftarFilm[i][0]);
                System.out.println("Genre  : " + daftarFilm[i][1]);
                System.out.println("Durasi : " + daftarFilm[i][2] + " menit");
                System.out.println("Rating : " + daftarFilm[i][3] + " / 5");
                System.out.println("---------------------------");
            }
        }
    }

    // Menambahkan data film baru
    static void InputFilmBaru() {
        Scanner input = new Scanner(System.in);

        // Loop input film sampai maksimal 10 film atau user tidak ingin input lagi
        while (jumlahFilm < 10) {// akan melakukan perulangan hingga 10
            System.out.print("Masukkan Judul Film ke-" + (jumlahFilm + 1) + ": "); //+1 akan  berubah mengikuti looping yang dilakukan
            daftarFilm[jumlahFilm][0] = input.nextLine();

            System.out.print("Masukkan Genre: ");
            daftarFilm[jumlahFilm][1] = input.nextLine();

            System.out.print("Masukkan Durasi (menit): ");
            daftarFilm[jumlahFilm][2] = input.nextLine();

            System.out.print("Masukkan Rating (1-5): ");
            daftarFilm[jumlahFilm][3] = input.nextLine();

            jumlahFilm++; // Tambahkan jumlah film yang telah dimasukkan

            System.out.print("Ingin input film lagi? (Iya/Tidak): ");
            String lanjut = input.nextLine();
            if (!lanjut.equalsIgnoreCase("Iya")) {//equalsIgnoreCase dipakai supaya user bisa ngetik "iya", "IYA", atau "IyA" dan tetap dianggap sama.
                break; // Keluar dari loop jika user tidak mau input lagi
            }
        }

        if (jumlahFilm == 10) { //ketika jumlah data samadengan 10, user tidak bisa menginput lagi
            System.out.println("Data film sudah penuh (maksimal 10).");
        }
    }

    // Mencari film berdasarkan judul
    static void CariFilm() {
        if (jumlahFilm == 0) { //jika jumlah film tidak ada, menu tidak dapat digunakan
            System.out.println("Belum ada data film untuk dicari.");
            return;
        }

        Scanner input = new Scanner(System.in);//supaya user dapat mennginput
        System.out.print("Masukkan judul film yang dicari: ");
        String judulDicari = input.nextLine().toLowerCase(); //supaya selaras menjadi huruf kecil semua meminimalisir sistem salah mengartikan

        for (int i = 0; i < jumlahFilm; i++) {
            if (daftarFilm[i][0].toLowerCase().contains(judulDicari)) { // contains untuk sistem mencari judul yang diinputkan user apakah ada atau tidak
                System.out.println("\nFilm ditemukan:");
                System.out.println("Judul  : " + daftarFilm[i][0]);
                System.out.println("Genre  : " + daftarFilm[i][1]);
                System.out.println("Durasi : " + daftarFilm[i][2] + " menit");
                System.out.println("Rating : " + daftarFilm[i][3] + " / 5");
                System.out.println("---------------------------");
            } else {
                System.out.println("Film dengan judul '" + judulDicari + "' tidak ditemukan.");
            }
        }
    }
}
