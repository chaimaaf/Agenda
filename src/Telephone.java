public class Telephone {
    protected String numero;
    protected String typeTel;

    public Telephone(){}
    public Telephone(String numero, String typeTel){
        this.numero = numero;
        this.typeTel = typeTel;
    }
    public Telephone getTelephone(){
        return new Telephone(numero, typeTel);
    }
    public void setType(String type){
        typeTel = type;
    }
    public void setNum(String num){
        numero = num;
    }
    public String toString(){
        return typeTel + " : " + numero;
    }
}
