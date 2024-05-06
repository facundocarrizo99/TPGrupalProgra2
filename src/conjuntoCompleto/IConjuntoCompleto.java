package conjuntoCompleto;

public interface IConjuntoCompleto {
    void inicializarConjunto(); //Sin precondiciones

    void agregar(int x); //Conjunto Inicializado

    int elegir(); //Conjunto Inicializado y no vacio

    boolean conjuntoVacio(); //Conjunto Inicializado

    void sacar(); //Conjunto Inicializado

    boolean pertenece(); //Conjunto Inicializado
}
