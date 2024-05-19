package colaConPrioridad;

public class ElementoPrioridad {
    private int valor;
    private int prioridad;

    public ElementoPrioridad() {}
    public ElementoPrioridad(int valor, int prioridad) { 
    	this.valor = valor;
    	this.prioridad = prioridad;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
}
