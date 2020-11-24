public class EstruturaLista {
  private NodoLista inicio;
  private NodoLista fim;
  private NodoLista atual;

  public EstruturaLista() {
    this.inicio = null;
    this.fim = null;
    this.atual = null;
  }

  public void insereFim(int dado) {
    NodoLista novo = new NodoLista();
    novo.setProximo(null);
    novo.setAnterior(null);
    novo.setDado(dado);

    if (this.inicio == null) {
      this.inicio = novo;
      this.fim = novo;
      this.atual = novo;
    } else {
      this.fim.setProximo(novo);
      novo.setAnterior(this.fim);
      this.fim = novo;
    }
  }

  public void removeFim() {
    try {
      this.fim = this.fim.getAnterior();
      this.fim.setProximo(null);
    } catch (NullPointerException e) {
      this.fim = null;
      this.inicio = null;
      System.out.println("Lista vazia!");
    }

  }

  public void show() {
    NodoLista aux = this.inicio;

    while (aux != null) {
      System.out.print(aux.getDado());
      aux = aux.getProximo();
    }
  }

  public void showBack() {
    NodoLista aux = this.fim;

    while (aux != null) {
      System.out.println(aux.getDado());
      aux = aux.getAnterior();
    }
  }

  public int getDado() {
    int retorno;
    retorno = this.atual.getDado();
    this.atual = this.atual.getProximo();

    if (this.atual == null) {
      return -1;
    } else {
      return retorno;
    }
  }
}
