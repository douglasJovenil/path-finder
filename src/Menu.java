import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
  Scanner teclado = new Scanner(System.in);

  public int getOpcao() {
    int retorno;
    try {
      System.out.print("Informe sua opção: ");
      retorno = teclado.nextInt();
    } catch (InputMismatchException e) {
      teclado.next();
      return -1;
    }
    return retorno;
  }

  public int getLinha() {
    try {
      System.out.print("Informe a linha: ");
      return teclado.nextInt();
    } catch (InputMismatchException e) {
      teclado.next();
      return -1;
    }

  }

  public int getColuna() {
    try {
      System.out.print("Informe a coluna: ");
      return teclado.nextInt();
    } catch (InputMismatchException e) {
      teclado.next();
      return -1;
    }
  }

  public int getDado() {
    try {
      System.out.print("Informe o valor: ");
      return teclado.nextInt();
    } catch (InputMismatchException e) {
      teclado.next();
      return -1;
    }
  }

  public int getSentido() {
    int opcao;

    try {
      System.out.println("1 - Mover para cima");
      System.out.println("2 - Mover para direita");
      System.out.println("3 - Mover para baixo");
      System.out.println("4 - Mover para esquerda");
      System.out.print("Informe sua opção: ");
      opcao = teclado.nextInt();

    } catch (InputMismatchException e) {
      teclado.next();
      System.out.println("\nOpção inválida!");
      return -1;
    }

    switch (opcao) {
      case 1:
        return 1;
      case 2:
        return 2;
      case 3:
        return 3;
      case 4:
        return 4;
      default:
        System.out.println("");
        System.out.println("Opção inválida");
        return -1;
    }
  }

  public void start(Nodo minhaPosicao, Estrutura minhaMatriz, Menu meuMenu, String patch) {
    boolean flagMatriz = false;
    final int newLine = 10;
    final int pontoVirgula = 59;
    final int carriageReturn = 13;
    int opcao;
    int valor;

    do {
      if (flagMatriz) {
        minhaPosicao = minhaMatriz.getInicio();
        flagMatriz = false;
      }
      System.out.println("0 - Para sair");
      System.out.println("1 - Criar matriz");
      System.out.println("2 - Mostrar matriz");
      System.out.println("3 - Mostrar posição atual");
      System.out.println("4 - Se movimentar na matriz");
      System.out.println("5 - Definir posição atual");
      System.out.println("6 - Retornar o valor da posição atual");
      System.out.println("7 - Alterar o conteúdo de uma posição");
      System.out.println("8 - Abrir o arquivo");
      System.out.println("9 - Sair do labirinto");
      opcao = getOpcao();
      System.out.println("");
      switch (opcao) {
        case 0:
          System.out.println("Saindo...");
          break;
        case 1:
          minhaMatriz.zeraMatriz();
          LerArquivo meuArquivo = new LerArquivo(patch);
          EstruturaLista dados = meuArquivo.pegarCaracter();
          
          while ((valor = dados.getDado()) != -1) {
            if ((valor != newLine) && (valor != carriageReturn) && (valor != pontoVirgula)) {
              minhaMatriz.insert(Character.getNumericValue(valor));
            } else if (valor == newLine) {
              minhaMatriz.criaLinha();
            } 
          }
          System.out.println("Matriz criada com sucesso!");
          flagMatriz = true;
          break;
        case 2:
          if (minhaMatriz.getInicio() == null) {
            System.out.println("Matriz vazia!");
          } else {
            minhaMatriz.show();
          }
          break;
        case 3:
          if (minhaPosicao == null) {
            System.out.println("Matriz vazia!");
          } else {
            System.out.println(minhaPosicao.getLinha() + "," + minhaPosicao.getColuna());
          }
          break;
        case 4:
          if (minhaMatriz.getInicio() == null) {
            System.out.println("Matriz vazia!");
          } else {
            minhaPosicao = minhaMatriz.mover(minhaPosicao, meuMenu.getSentido());
          }
          break;
        case 5:
          if (minhaMatriz.getInicio() == null) {
            System.out.println("Matriz vazia!");
          } else {
            minhaPosicao = minhaMatriz.setPosicao(minhaPosicao, meuMenu.getLinha(), meuMenu.getColuna());
          }
          break;
        case 6:
          if (minhaMatriz.getInicio() == null) {
            System.out.println("Matriz vazia!");
          } else {
            System.out.println(minhaPosicao.getDado());
          }
          break;
        case 7:
          if (minhaMatriz.getInicio() == null) {
            System.out.println("Matriz vazia!");
          } else {
            Nodo auxPosicao = minhaMatriz.setPosicao(null, meuMenu.getLinha(), meuMenu.getColuna());
            minhaMatriz.setDado(auxPosicao, meuMenu.getDado());
          }
          break;
        case 8:
          try {
            Runtime.getRuntime().exec("notepad " + System.getProperty("user.dir") + "/src/matriz/dados.txt");
          } catch (IOException e) {
            System.out.println("Arquivo não encontrado!");
          }
          break;
        case 9:
          minhaMatriz.sairLabirinto(minhaPosicao);
          break;
        default:
          System.out.println("Opção inválida!");
          break;
      }
      System.out.println("");
    } while (opcao != 0);
  }
}
