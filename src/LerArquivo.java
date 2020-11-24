import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivo {

  private String caminho;

  public LerArquivo(String caminho) {
    this.caminho = caminho;
  }

  public EstruturaLista pegarCaracter() {
    int caracter;
    EstruturaLista retorno = new EstruturaLista();

    try {
      FileReader caminhoArquivo = new FileReader(this.caminho);
      BufferedReader arquivo = new BufferedReader(caminhoArquivo);

      while ((caracter = arquivo.read()) != -1) {
        retorno.insereFim(caracter);
      }

      return retorno;
    } catch (IOException e) {
      e.getMessage();
      return null;
    }
  }
}
