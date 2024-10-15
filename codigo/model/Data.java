package codigo.model;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data (int dia, int mes, int ano){
        this.ano = ano;
        this.dia = dia;
        this.mes = mes;

    }
    @Override

    public String toString(){
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }
}
