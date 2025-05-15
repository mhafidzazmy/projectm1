package com.learnyt;

public class Aritmatika {
    public static void main(String[] args) {
        //Penjumlahan
        int variable1 = 2;
        int variable2 = 3;
        int hasil;
        hasil = variable1 + variable2;
        System.out.println(hasil);

        int a = 11;
        a = a + 10; //a berisikan variable sebelumnya yang diinputkan
        System.out.println(a);

        //Pengurangan
        int variable3 = 4;
        int variable4 = 2;
        hasil = variable3 - variable4; //nilai yang dihasilkan akan disesuaikan dengan statment yang diberikan
        System.out.println("hasil = " + variable3 + " - " + variable4 + " = " + hasil); // harus disertakan tanda "+" pada setiap variable
        System.out.printf("%d - %d = %d \n", variable3, variable4, hasil); //%d digunakan dalam bentuk format -> printf

        //Perkalian
        int per1 = 12;
        int per2 = 2;
        hasil = per1 * per2;
        System.out.println(per1 + " x " + per2 + " = " + hasil); // opsi lain mengeluarkan output

        //pembagian
        int pem3 = 10; //pem3 berisikan variable 10 yang sebelumnya diinputkan
        pem3 /= 5; //pem3/ tidak bisa jika pem3 = / akan terjadi error karna "=" merupakan assigment
        System.out.println(pem3);

        //modulus (dibagi dan terrdapat sisa)
        //modulus menggunakan %
        int molus1 = 10;
        int molus2 = 3; // modulus akan mencari nilai terdekat dari perkalian 3 untuk mendapatkan 10, 3x3 = 9 sisa 1
        hasil = molus1 % molus2;
        System.out.println(hasil);

        //contoh float
        float plot1 = 10;
        float plot2 = 3;
        float hasilfloat = plot1 / plot2;
        System.out.print(plot1 + " + " + plot2 + " = " + hasilfloat + "\n");


        //boolean dalam operator
        boolean ini = 3 < 4; // "ini" merupakan nama yang ingin diberikan kepada variable atau mewakili variable
        System.out.print("apakah nilai 3 lebih besar dari 4?" + ini);

        boolean samadengan = 4 <= 3;
        System.out.println(samadengan);

        boolean kaliini = 9 >= 9;
        System.out.println(kaliini);
    }
}
