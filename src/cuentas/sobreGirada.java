package cuentas;

public class sobreGirada extends cuenta {
    private double tasaCredito;

    public sobreGirada(double saldo, double tasaCredito) {
        super(saldo);
        this.tasaCredito = tasaCredito;
    }

    public void cargarInteres() {
        this.saldo += (this.saldo * this.tasaCredito);
    }

    @Override
    public double retirarSaldos(double saldo) {
        this.saldo -= saldo;
        if (this.saldo <= 0) {
            cargarInteres();
            return getSaldo() * -1;
        }
        return getSaldo();
    }

    // getters and setters
    public double getTasaCredito() {
        return tasaCredito;
    }

    public void setTasaCredito(double tasaCredito) {
        this.tasaCredito = tasaCredito;
    }

}
