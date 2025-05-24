import javax.swing.*;

public class SetCurrencyCode {

    private String moedaBase;
    private String moedaAlvo;
    private String valorMontante;


    public SetCurrencyCode() {
        this.moedaBase = "";
        this.moedaAlvo = "";
        this.valorMontante = "";
    }

    public String getMoedaBase() {
        return moedaBase;
    }

    public String getMoedaAlvo() {
        return moedaAlvo;
    }

    public String getValorMontante() {
        return valorMontante;
    }

    public void setValorMontante(String valorMontante) {
        this.valorMontante = valorMontante;
    }

    public void EscolheCodigoDeCambio(int opcao) {
        switch (opcao) {
            case 1:
                this.moedaBase = "USD";
                this.moedaAlvo = "BRL";
                break;
            case 2:
                this.moedaBase = "BRL";
                this.moedaAlvo = "USD";
                break;
            case 3:
                this.moedaBase = "BRL";
                this.moedaAlvo = "KRW";
                break;
            case 4:
                this.moedaBase = "BRL";
                this.moedaAlvo = "KRW";
                break;
            case 5:
                this.moedaBase = "BRL";
                this.moedaAlvo = "JPY";
                break;
            case 6:
                this.moedaBase = "JPY";
                this.moedaAlvo = "BRL";
                break;
            case 7:
                break;

        }
    }

}

