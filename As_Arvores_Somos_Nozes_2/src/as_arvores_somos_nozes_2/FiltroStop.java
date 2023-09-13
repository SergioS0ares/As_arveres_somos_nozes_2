package as_arvores_somos_nozes_2;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class FiltroStop {
    
    public ArrayList<String> stopwords() throws Exception{
        try{
        ArrayList<String> palavras = new ArrayList<>();
        String caminho = "C:/Users/User/Documents/GitHub/As_arveres_somos_nozes_2/dados/stopwords.txt";
        FileReader fr = new FileReader(caminho);
        BufferedReader br = new BufferedReader(fr);
        String i;
        while((i=br.readLine()) != null){
            palavras.add(i);
            System.out.println(palavras);
    }
    br.close();
    return palavras; 
}catch(Exception erro){
    throw erro;
}
}
}
