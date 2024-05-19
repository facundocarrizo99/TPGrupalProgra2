package colaConPrioridad;
import java.util.Objects;

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
    	if(!estaInicializada()) {
    		inicializarCola(); // si no esta inicializada la inicializa
    	}
    	int j = indice;
        for(; j > 0 && elementos[j-1].getPrioridad() <= prioridad; j-- ){
            elementos[j] = elementos[j-1];
        }
        elementos[j] = new ElementoPrioridad(x, prioridad);
        indice++;
    }

    @Override
    public void desacolar() {
    	if (!estaInicializada()) {
    		System.out.println("### Error no Inicializada ###");
    		return;
    	}
    	if(colaVacia()) {
    		System.out.println("### Error Cola vacia ###");
    		return;
    	}
        elementos[indice - 1] = null;
        indice--;
    }

    @Override
    public boolean colaVacia() {
        return (indice == 0);
    }

    @Override
    public int primero() {
    	if (colaVacia() || !estaInicializada()) {
    		System.out.println("### Error ###");
    	}
        return elementos[indice - 1].getValor();
    }

    @Override
    public int prioridad() {
    	if (colaVacia() || !estaInicializada()) {
    		System.out.println("### Error ###");
    	}
        return elementos[indice - 1].getPrioridad();
    }
    
    private boolean estaInicializada() {//verifica si la cola esta inicializada para evitar errores
    	return !Objects.isNull(elementos);
    }
}
