package uc.poo;

class Date {
    private int dia;
    private int mes;
    private int ano;

    public Date() {}

    public Date(String date) {
        String[] arr = date.split("/", 3);
        this.dia = Integer.parseInt(arr[0]);
        this.mes = Integer.parseInt(arr[1]);
        this.ano = Integer.parseInt(arr[2]);
    }

    //returns date in string format: DD/MM/AAAA
    public String inString() {
        return dia + "/" + mes + "/" + ano;
    }

}//End Class Date
