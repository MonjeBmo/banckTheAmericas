package home;

import java.time.LocalDate;
import java.util.Scanner;

import cuentas.ahorro;
// import cuentas.cheque;
import cuentas.cuenta;
import cuentas.plazoFijo;
// import cuentas.sobreGirada;

public class mainClass {

    static double saldo = 2000;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        var x = 0;
        do {
            System.out.println("menu");
            System.out.println("1- Cuenta de Ahorro");
            System.out.println("2- Cuenta de Plazo Fijo");
            System.out.println("3- Cuenta de Cheques");
            System.out.println("4- Cuenta sobregirada");
            System.out.println("6- salir");
            x = s.nextInt();

            switch (x) {
                case 1:
                    ahorro();
                    break;
                case 2:
                    plazoFijo();
                    break;
                case 3:
                    cheques();
                    break;
                case 4:
                    sobregiro();
                    break;
                default:
                    System.out.println("Adios :D");
                    break;
            }

        } while (x == 6);
        s.close();
    }

    public static void ahorro() {
        double tasaInteres = 0.02;
        cuenta c = new ahorro(saldo, tasaInteres);
        c.depositarSaldo(0);
        System.out.println("El saldo es de : " + c.getSaldo());
        System.out.println("El nuevo saldo al retirar es de : " + c.retirarSaldos(200));
    }

    public static void plazoFijo() {
        LocalDate date = LocalDate.of(2023, 8, 13);
        cuenta c = new plazoFijo(saldo, 0.05, date);
        System.out.println("El saldo a entregar : " + c.retirarSaldos(1000));
        System.out.println("Nuevo saldo : " + c.getSaldo());
    }

    public static void cheques() {
        // cuenta c = new cheque(0, 0, 0);
    }

    public static void sobregiro() {
        // cuenta c = new sobreGirada(0, 0);
    }
}
