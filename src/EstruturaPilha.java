public class EstruturaPilha {
  private NodoPilha topo;

  public EstruturaPilha() {
    this.topo = null;
  }

  public void push(Nodo dado) {
    NodoPilha novo = new NodoPilha();
    novo.setAnterior(null);
    novo.setDado(dado);

    if (this.topo == null) {
      this.topo = novo;
    } else {
      novo.setAnterior(this.topo);
      this.topo = novo;
    }
  }

  public NodoPilha peek() {
    NodoPilha atual = this.topo;

    if (this.topo == null) {
      return null;
    } else {
      atual = this.topo;
    }

    return atual;
  }

  public NodoPilha pop() {
    NodoPilha atual = this.topo;

    if (this.topo == null) {
      return null;
    } else {
      atual = this.topo;
      this.topo = this.topo.getAnterior();
    }
    return atual;
  }

  public void show() {
    NodoPilha aux = this.topo;

    if (aux == null) {
      System.out.println("Pilha vazia!");
    } else {
      while (aux != null) {
        System.out.println(aux.getDado());
        aux = aux.getAnterior();
      }
    }
  }

  public boolean isEmpty() {
    return (this.topo == null);
  }
}
