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
        double tasaInteres = 0.02, saldo = 1000;
        ahorro c = new ahorro(saldo, tasaInteres);
        String f;
        do {
            System.out.println("Saldo sin intereses aplicados : " + c.getSaldo());
            c.sumarIntereses();
            System.out.println("El saldo con los intereses sumados : " + c.getSaldo() + " El interes es de : " + c.getTasaInteres());
            System.out.println("Desea depositar S/N : ");
            var x = s.next();
            if (x.equals("S") || x.equals("s")) {
                System.out.println("Cantidad a depositar : ");
                double deposito = s.nextDouble();
                c.depositarSaldo(deposito);
                System.out.println("Nuevo saldo despues del Deposito : " + c.getSaldo());
            }
            System.out.println("Ingrese el saldo a retirar : ");
            double retirar = s.nextDouble();
            System.out.println("El nuevo saldo despues del retiro : " + c.retirarSaldos(retirar));
            System.out.println("Realizar otra vez la accion s/n");
            f = s.next();

        } while (f.equals("S") || f.equals("s"));

    }

    public static void plazoFijo(Scanner s) {
        double saldo = 1000;
        var year = 2003;
        var month = 8;
        var day = 16;
        LocalDate date = LocalDate.of(2023, 8, 16);
        System.out.println("Fecha para retirar : " + year + "/" + month + "/" + day);
        plazoFijo c = new plazoFijo(saldo, 0.05, date);
        String f;
        do {
            System.out.println("Saldo Actual : " + c.getSaldo());
            System.out.println("Desea depositar S/N : ");
            var x = s.next();
            if (x.equals("S") || x.equals("s")) {
                System.out.println("Cantidad a depositar : ");
                double deposito = s.nextDouble();
                c.depositarSaldo(deposito);
                System.out.println("Nuevo saldo despues del Deposito : " + c.getSaldo());
            }
            System.out.println("Ingrese la cantidad a retirar : ");
            double retirar = s.nextDouble();
            System.out.println("Uso de una tasa de Recargo si aplica de : " + c.getTasaRecargo());
            System.out.println("El saldo a entregar : " + c.retirarSaldos(retirar));
            System.out.println("Nuevo saldo : " + c.getSaldo());
            System.out.println("Realizar otra vez la accion s/n");
            f = s.next();

        } while (f.equals("S") || f.equals("s"));

    }

    public static void cheques(Scanner s) {
        cheque c = new cheque(0, 1, 5);
        c.setSaldo(2000);
        String x;
        do {
            System.out.println("Su saldo es de : " + c.getSaldo());
            System.out.println("Desea depositar S/N : ");
            var f = s.next();
            if (f.equals("S") || f.equals("s")) {
                System.out.println("Cantidad a depositar : ");
                double deposito = s.nextDouble();
                c.depositarSaldo(deposito);
                System.out.println("Nuevo saldo despues del Deposito : " + c.getSaldo());
            }
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
        sobreGirada c = new sobreGirada(0, 0.2);
        c.setSaldo(2000);
        String f;
        do {
            System.out.println("Saldo actual : " + c.getSaldo());
            System.out.println("Desea depositar S/N : ");
            var x = s.next();
            if (x.equals("S") || x.equals("s")) {
                System.out.println("Cantidad a depositar : ");
                double deposito = s.nextDouble();
                c.depositarSaldo(deposito);
                System.out.println("Nuevo saldo despues del Deposito : " + c.getSaldo());
            }
            System.out.println("Se le aplicara un tasa de credito si aplica de : " + c.getTasaCredito());
            System.out.println("Ingrese la cantidad a retirar : ");
            double retirar = s.nextDouble();
            System.out.println("Saldo Nuevo : " + c.retirarSaldos(retirar));
            System.out.println("Realizar otra vez la accion s/n");
            f = s.next();
        } while (f.equals("S") || f.equals("s"));

    }
}
