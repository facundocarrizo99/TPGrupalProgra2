package conjuntoCompleto;

public interface IConjuntoCompleto {
    void inicializarConjunto(); //Sin precondiciones

    void agregar(int x); //Conjunto Inicializado

    int elegir(); //Conjunto Inicializado y no vacio

    boolean conjuntoVacio(); //Conjunto Inicializado

    void sacar(int x); //Conjunto Inicializado

    boolean pertenece(int x); //Conjunto Inicializado
}
