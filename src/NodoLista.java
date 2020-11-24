public class NodoLista {
  private NodoLista proximo;
  private NodoLista anterior;
  private int dado;

  public int getDado() {
    return dado;
  }

  public void setDado(int dado) {
    this.dado = dado;
  }

  public NodoLista getProximo() {
    return proximo;
  }

  public void setProximo(NodoLista proximo) {
    this.proximo = proximo;
  }

  public NodoLista getAnterior() {
    return anterior;
  }

  public void setAnterior(NodoLista anterior) {
    this.anterior = anterior;
  }
}
