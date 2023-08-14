package cuentas;

import java.time.LocalDate;

public class plazoFijo extends cuenta {

    private double tasaRecargo; // Tasa de recargo aplicada en caso de retiro antes del vencimiento
    private LocalDate dateVencimiento; // Fecha de vencimiento del plazo fijo

    // Constructor
    public plazoFijo(double saldo, double tasaRecargo, LocalDate dateVencimiento) {
        super(saldo); // Llama al constructor de la clase padre 'cuenta' y establece el saldo inicial
        this.tasaRecargo = tasaRecargo; // Inicializa la tasa de recargo
        this.dateVencimiento = dateVencimiento; // Inicializa la fecha de vencimiento
    }

    // Método para verificar si ha llegado el vencimiento
    boolean esVencimiento() {
        if (this.dateVencimiento.isAfter(LocalDate.now())) {
            return true; // Si la fecha de vencimiento es posterior a la fecha actual, devuelve verdadero
        }
        return false; // De lo contrario, devuelve falso
    }

    // Método para retirar saldo
    @Override
    public double retirarSaldos(double saldo) {
        if (this.saldo >= saldo) { // Verifica si hay suficiente saldo para el retiro
            if (esVencimiento()) { // Verifica si ha llegado el vencimiento
                this.saldo -= saldo; // Realiza el retiro
                var totalEntregar = saldo - (saldo * this.tasaRecargo); // Calcula el monto a entregar restando el recargo
                return totalEntregar; // Devuelve el monto a entregar
            }
            this.saldo -= saldo; // Realiza el retiro si no ha llegado el vencimiento
            return getSaldo(); // Devuelve el saldo actual
        }
        return 0; // Si no hay suficiente saldo, devuelve 0
    }

    // Métodos para obtener y establecer la tasa de recargo
    public double getTasaRecargo() {
        return tasaRecargo;
    }

    public void setTasaRecargo(double tasaRecargo) {
        this.tasaRecargo = tasaRecargo;
    }

    // Métodos para obtener y establecer la fecha de vencimiento
    public LocalDate getDateVencimiento() {
        return dateVencimiento;
    }

    public void setDateVencimiento(LocalDate dateVencimiento) {
        this.dateVencimiento = dateVencimiento;
    }

}
