package conjuntoCompleto;
import java.util.Objects;

public class Conjunto implements IConjuntoCompleto{
    int [] a;
    int cant;


    @Override
    public void inicializarConjunto() {
        a = new int[100];
        cant = 0;
    }

    @Override
    public void agregar(int x) {
    	if (!estaInicializada()) {
    		inicializarConjunto();
    	}
        if (!this.pertenece(x)){
            a[cant] = x;
            cant++;
        }
    }

    @Override
    public int elegir() {
    	if (conjuntoVacio() || !estaInicializada()) {
    		System.out.println("### ERROR ###");
    		return 0;
    	}
    	int indiceRandom = (int)(Math.random()  * cant);
        return a[indiceRandom];
    }

    @Override
    public boolean conjuntoVacio() {
        return (cant == 0);
    }
    
    private boolean estaInicializada() {
    	return !Objects.isNull(a);
    }

    @Override
    public void sacar(int x) {
    	if (conjuntoVacio() || !estaInicializada()) {
    		System.out.println("### ERROR ###");
    		return;
    	}
        int i = 0;
        while (i < cant && a[i] != x ){
            i++;
        }
        if (i < cant){
        	for(int j = i; j < cant; j++) {
        		a[j] = a[j + 1];
        	}
            cant--;
        }
    }

    @Override
    public boolean pertenece(int x) {
    	if (!estaInicializada()) {
    		System.out.println("### ERROR ###");
    		return false;
    	}
        int i = 0;
        while (i < cant && a[i] != x ){
            i++;
        }
        return (i < cant);
    }
}
