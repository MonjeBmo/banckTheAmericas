package cuentas;

public class ahorro extends cuenta {

    private double tasaInteres; // Tasa de interés aplicada al saldo

    // Constructor
    public ahorro(double saldo, double tasaInteres) {
        super(saldo); // Llama al constructor de la clase padre 'cuenta' y establece el saldo inicial
        this.tasaInteres = tasaInteres; // Inicializa la tasa de interés
    }

    // Método para sumar intereses al saldo
    public void sumarIntereses() {
        double saldoActual = super.getSaldo(); // Obtiene el saldo actual
        super.setSaldo(saldoActual + (super.getSaldo() * this.tasaInteres)); // Calcula e incrementa el saldo con los intereses
    }

    // Método para retirar saldo
    @Override
    public double retirarSaldos(double saldo) {
        if (super.getSaldo() >= saldo) { // Verifica si hay suficiente saldo para el retiro
            this.saldo -= saldo; // Realiza el retiro
            return getSaldo(); // Devuelve el saldo actual
        }
        return 0; // Si no hay suficiente saldo, devuelve 0
    }

    // Métodos para obtener y establecer la tasa de interés
    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

}
