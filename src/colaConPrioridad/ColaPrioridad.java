package colaConPrioridad;

public class ColaPrioridad implements IColaPrioridad{
    private ElementoPrioridad[] elementos;
    int indice;

    @Override
    public void inicializarCola() {
        indice = 0;
        elementos = new ElementoPrioridad[100];
    }

    @Override
    public void acolarPrioridad(int x, int prioridad) {
        int j = indice;

        for(; j > 0 && elementos[j-1].getPrioridad() == prioridad; j-- ){
            elementos[j] = elementos[j-1];
        }
        elementos[j] = new ElementoPrioridad();
        elementos[j].setValor(x);
        elementos[j].setPrioridad(prioridad);
        indice++;
    }

    @Override
    public void desacolar() {
        elementos[indice - 1] = null;
        indice--;
    }

    @Override
    public boolean colaVacia() {
        return (indice == 0);
    }

    @Override
    public int primero() {
        return elementos[indice - 1].getValor();
    }

    @Override
    public int prioridad() {
        return elementos[indice - 1].getPrioridad();
    }
}
