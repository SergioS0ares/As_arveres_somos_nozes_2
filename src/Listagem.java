import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Listagem{

    public ArrayList<String> LeituraArray() throws Exception{
    try{
        ArrayList<String> palavras = new ArrayList<>();
        String caminho = "C:/Users/Administrador/Documents/GitHub/As_arveres_somos_nozes_2/dados/teste.txt";
        FileReader fr = new FileReader(caminho);
        BufferedReader br = new BufferedReader(fr);
        String i;
        while((i=br.readLine()) != null){
            String[] separado = i.split(" |,");
            for(String s:separado){
              palavras.add(s);
            }
        }
    br.close();
    return palavras;
    }catch(Exception erro){
        throw erro;
    }
}  

}
