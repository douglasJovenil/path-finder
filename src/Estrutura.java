public class Estrutura {
  private Nodo inicio;
  private Nodo fim;
  private Nodo linha;
  private Nodo coluna;
  private Nodo aux;
  private boolean flagNewLine;
  private int indiceLinha;
  private int indiceColuna;

  public Estrutura() {
    this.inicio = null;
    this.fim = null;
    this.linha = null;
    this.aux = null;
    this.coluna = null;
    this.indiceLinha = 1;
    this.indiceColuna = 1;
  }

  public void insert(int dado) {
    Nodo novo = new Nodo();
    novo.setProximo(null);
    novo.setAnterior(null);
    novo.setSuperior(null);
    novo.setInferior(null);
    novo.setDado(dado);
    novo.setLinha(this.indiceLinha);
    novo.setColuna(this.indiceColuna);
    this.indiceColuna++;

    if ((this.inicio == null) && !this.flagNewLine && (this.inicio == this.linha)) { // Inicia a matriz
      this.inicio = novo;
      this.fim = novo;
      this.linha = novo;
      this.coluna = novo;
    } else if (!this.flagNewLine && (this.inicio == this.linha)) { // Insere linhas
      this.fim.setProximo(novo);
      novo.setAnterior(this.fim);
      this.fim = novo;
    } else if (!this.flagNewLine && (this.inicio != this.linha)) { // Insere colunas
      this.fim.setProximo(novo);
      novo.setAnterior(this.fim);
      this.fim = novo;
      this.coluna = this.coluna.getProximo();
      this.coluna.setInferior(this.fim);
      this.fim.setSuperior(this.coluna);
    }

    if (this.flagNewLine) { // Seta o valor das linhas na primeira coluna
      this.fim.setDado(dado);
      this.flagNewLine = false;
    } // Lógica para inserir uma linha
  }

  public void criaLinha() {
    Nodo novo = new Nodo();
    novo.setProximo(null);
    novo.setAnterior(null);
    novo.setSuperior(null);
    novo.setInferior(null);
    this.coluna = this.linha;
    this.aux = novo;
    novo.setLinha(this.indiceLinha);
    this.indiceColuna = 1;

    this.aux.setSuperior(this.linha);
    this.linha.setInferior(this.aux);
    this.fim = this.aux;
    this.linha = this.aux;
    this.flagNewLine = true;
    this.indiceLinha++;
  }

  public void show() {
    Nodo auxColuna = this.inicio;
    Nodo auxLinha = this.inicio;

    while (auxLinha != null) {
      while (auxColuna != null) {
        System.out.print(auxColuna.getDado() + " ");
        auxColuna = auxColuna.getProximo();
      }
      System.out.println("");
      auxLinha = auxLinha.getInferior();
      auxColuna = auxLinha;
    }

  }

  public Nodo mover(Nodo nodo, int sentido) {
    try {
      switch (sentido) {
        case 1: // subir na matriz
          if (nodo.getSuperior() == null) {
            System.out.println("\nPosição inválida!");
            return nodo;
          } else {
            return nodo.getSuperior();
          }
        case 2: // ir para direita
          if (nodo.getProximo() == null) {
            System.out.println("\nPosição inválida!");
            return nodo;
          } else {
            return nodo.getProximo();
          }
        case 3: // descer
          if (nodo.getInferior() == null) {
            System.out.println("\nPosição inválida!");
            return nodo;
          } else {
            return nodo.getInferior();
          }
        case 4: // ir para esquerda
          if (nodo.getAnterior() == null) {
            System.out.println("\nPosição inválida!");
            return nodo;
          } else {
            return nodo.getAnterior();
          }
        default:
          return nodo;
      }
    } catch (NullPointerException e) {
      System.out.println("\nPosição inválida!");
      return nodo;
    }
  }

  public Nodo setPosicao(Nodo posicaoAtual, int linha, int coluna) {
    Nodo auxLinha = this.inicio;
    Nodo auxColuna = this.inicio;

    if (linha > this.indiceLinha || coluna > this.indiceColuna) {
      return posicaoAtual;
    }
    while ((auxLinha != null)) {
      while ((auxColuna != null)) {
        if ((linha == auxColuna.getLinha()) && (coluna == auxColuna.getColuna())) {
          return auxColuna;
        }
        auxColuna = auxColuna.getProximo();
      }
      auxLinha = auxLinha.getInferior();
      auxColuna = auxLinha;
    }
    return posicaoAtual;
  }

  public void sairLabirinto(Nodo minhaPosicao) {
    EstruturaPilha pilhaLabirinto = new EstruturaPilha();
    Nodo atual = getPosicaoLabirinto(true);
    Nodo saida = getPosicaoLabirinto(false);

    try {
      while (atual != saida) {

        if ((atual.getProximo().getDado() == 9) || (atual.getAnterior().getDado() == 9) || (atual.getSuperior().getDado() == 9) || (atual.getInferior().getDado() == 9)) {
          break;
        }

        if (atual.getProximo().getDado() == 0) {
          pilhaLabirinto.push(atual.getProximo());
        }
        if (atual.getAnterior().getDado() == 0) {
          pilhaLabirinto.push(atual.getAnterior());
        }
        if (atual.getInferior().getDado() == 0) {
          pilhaLabirinto.push(atual.getInferior());
        }
        if (atual.getSuperior().getDado() == 0) {
          pilhaLabirinto.push(atual.getSuperior());
        }

        if (pilhaLabirinto.isEmpty()) {
          break;
        } else {
          atual = pilhaLabirinto.pop().getDado();
        }
        System.out.println("");
        atual.setDado(4);
        this.show();
      }
      System.out.println("\nLabirinto final:\n");
      this.show();
      minhaPosicao.setLinha(atual.getLinha());
      minhaPosicao.setColuna(atual.getColuna());
    } catch (NullPointerException e) {
      this.show();
      System.out.println("\nLabirinto inválido!");
    }

  }

  private Nodo getPosicaoLabirinto(boolean coordenada) { // coordenada = true, pegar a entrada / coordenada = false, pegar a saida
    Nodo auxColuna = this.inicio;
    Nodo auxLinha = this.inicio;

    while (auxLinha != null) {
      while (auxColuna != null) {
        if (coordenada && (auxColuna.getDado() == 5)) {
          return auxColuna;
        } else if (!coordenada && (auxColuna.getDado() == 9)) {
          return auxColuna;
        }
        auxColuna = auxColuna.getProximo();
      }
      auxLinha = auxLinha.getInferior();
      auxColuna = auxLinha;
    }

    return null;
  }

  public Nodo getInicio() {
    return this.inicio;
  }

  public int getDado(Nodo nodo) {
    return nodo.getDado();
  }

  public void setDado(Nodo nodo, int dado) {
    try {
      nodo.setDado(dado);
    } catch (NullPointerException e) {
      System.out.println("\nOpção inválida");
    }

  }

  public int getLinha(Nodo nodo) {
    return nodo.getLinha();
  }

  public int getColuna(Nodo nodo) {
    return nodo.getColuna();
  }

  public int getIndiceLinha() {
    return this.indiceLinha;
  }

  public int getIndiceColuna() {
    return this.indiceColuna;
  }
  
  public void zeraMatriz(){
    this.inicio = null;
    this.fim = null;
    this.linha = null;
    this.aux = null;
    this.coluna = null;
    this.indiceLinha = 1;
    this.indiceColuna = 1;
  }
}
