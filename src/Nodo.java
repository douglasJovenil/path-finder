public class Nodo {
  private int dado;
  private int linha;
  private int coluna;
  private Nodo proximo;
  private Nodo anterior;
  private Nodo superior;
  private Nodo inferior;

  public int getLinha() {
    return linha;
  }

  public void setLinha(int linha) {
    this.linha = linha;
  }

  public int getColuna() {
    return coluna;
  }

  public void setColuna(int coluna) {
    this.coluna = coluna;
  }

  public int getDado() {
    return dado;
  }

  public void setDado(int dado) {
    this.dado = dado;
  }

  public Nodo getProximo() {
    return proximo;
  }

  public void setProximo(Nodo proximo) {
    this.proximo = proximo;
  }

  public Nodo getAnterior() {
    return anterior;
  }

  public void setAnterior(Nodo anterior) {
    this.anterior = anterior;
  }

  public Nodo getSuperior() {
    return superior;
  }

  public void setSuperior(Nodo superior) {
    this.superior = superior;
  }

  public Nodo getInferior() {
    return inferior;
  }

  public void setInferior(Nodo inferior) {
    this.inferior = inferior;
  }
}
