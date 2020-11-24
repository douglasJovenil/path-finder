public class Main {
  public static void main(String[] args) {
    String path = System.getProperty("user.dir");
    String[] pathSeparado = path.split("/");
    Estrutura minhaMatriz = new Estrutura();
    Menu meuMenu = new Menu();
    Nodo minhaPosicao = null;
    
    path = "";
    for (int i = 0; i < pathSeparado.length - 1; i++) {
      path += pathSeparado[i];
      path += "/";
    }
    path += "data/labirinto.txt";

   meuMenu.start(minhaPosicao, minhaMatriz, meuMenu, path);
  }
}
