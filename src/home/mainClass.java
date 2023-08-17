package home;

import java.time.LocalDate;
import java.util.Scanner;

import cuentas.ahorro;
import cuentas.cheque;
import cuentas.cuenta;
import cuentas.plazoFijo;
import cuentas.sobreGirada;

public class mainClass {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int x;
        do {
            System.out.println("<---menu--->");
            System.out.println("1- Cuenta de Ahorro");
            System.out.println("2- Cuenta de Plazo Fijo");
            System.out.println("3- Cuenta de Cheques");
            System.out.println("4- Cuenta sobregirada");
            System.out.println("6- salir");
            System.out.println("Ingrese su opcion : ");
            x = s.nextInt();

            switch (x) {
                case 1 -> ahorro(s);
                case 2 -> plazoFijo(s);
                case 3 -> cheques(s);
                case 4 -> sobregiro(s);
                default -> System.out.println("Adios :D");
            }

        } while (x != 6);
        s.close();
    }

    public static void ahorro(Scanner s) {
        double tasaInteres = 0.02, saldo = 2000;
        cuenta c = new ahorro(saldo, tasaInteres);
        c.depositarSaldo(0);
        System.out.println("El saldo es de : " + c.getSaldo());
        System.out.println("Ingrese el saldo a retirar : ");
        double retirar = s.nextDouble();
        System.out.println("El nuevo saldo al retirar es de : " + c.retirarSaldos(retirar));
    }

    public static void plazoFijo(Scanner s) {
        double saldo = 2000;
        System.out.println("Ingrese el dia: ");
        int day = s.nextInt();
        System.out.println("Ingrese el mes: ");
        int month = s.nextInt();
        System.out.println("Ingrese el año: ");
        int year = s.nextInt();

        LocalDate date = LocalDate.of(year, month, day);
        cuenta c = new plazoFijo(saldo, 0.05, date);

        System.out.println("Ingrese la cantidad a retirar : ");
        double retirar = s.nextDouble();
        System.out.println("El saldo a entregar : " + c.retirarSaldos(retirar));
        System.out.println("Nuevo saldo : " + c.getSaldo());
    }

    public static void cheques(Scanner s) {
        cheque c = new cheque(0, 1, 5);
        c.setSaldo(2000);
        String x;
        do {
            System.out.println("Su saldo es de : " + c.getSaldo());
            System.out.println("Cantidad a retirar : ");
            double retirar = s.nextDouble();
            c.retirarSaldos(retirar);
            System.out.println("Otra transaccion o cancelar ingrese la C");
            x = s.next();
        } while (!(x.equals("C") || x.equals("c")));

        System.out.println("Saldo Actual sin recargo: " + c.getSaldo());
        System.out.println("No. de Transacciones : " + cheque.noTransacciones);
        c.aplicarRecargo();
        System.out.println("Saldo Actual con el recargo: " + c.getSaldo());
    }

    public static void sobregiro(Scanner s) {
        cuenta c = new sobreGirada(0, 0.2);
        c.setSaldo(2000);
        System.out.println("Ingrese la cantidad a retirar : ");
        double retirar = s.nextDouble();
        System.out.println("Saldo Nuevo : " + c.retirarSaldos(retirar));
    }
}
