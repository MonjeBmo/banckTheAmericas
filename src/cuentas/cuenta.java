package cuentas;

public abstract class cuenta {

    protected double saldo;

    // methods
    public void depositarSaldo(double saldo) {
        this.saldo += saldo;
    }

    public abstract double retirarSaldos(double saldo);

    // getters & setters
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // constructor
    public cuenta(double saldo) {
        this.saldo = saldo;
    }

}
