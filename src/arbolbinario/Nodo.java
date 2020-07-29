
package arbolbinario;

public class Nodo {
    
    private int valor;
    private Nodo izquierdo;
    private Nodo derecho;
    
    Nodo(int n){
        
        this.valor = n;
        this.izquierdo = null;
        this.derecho   = null;
        
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }
    
}
