package colaConPrioridad;

public interface IColaPrioridad {
    void inicializarCola(); //Sin precondiciones

    void acolarPrioridad(int x, int prioridad); //La cola debe estar inicializada

    void desacolar(); //cola inicializada y no vacia

    boolean colaVacia(); //Cola inicializada

    int primero(); //cola inicializada y no vacia

    int prioridad(); //cola inicializada y no vacia
}
