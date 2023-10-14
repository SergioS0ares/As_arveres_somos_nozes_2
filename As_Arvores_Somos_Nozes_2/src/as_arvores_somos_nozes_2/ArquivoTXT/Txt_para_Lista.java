/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package as_arvores_somos_nozes_2.ArquivoTXT;

import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Txt_para_Lista {

    private List<String> stopwords;
    private List<String> relevantes;
    int x;

    public Txt_para_Lista() {
        // Inicialize a lista de stopwords no construtor
        stopwords = Arrays.asList("de", "a", "que", "e", "do", "da", "em", "um", "para", "é", "com", "não", "uma", "os", "no", "se", "na", "por", "mais", "as", "dos", "como", "mas", "foi", "ao", "ele", "das", "tem", "à", "seu", "sua", "ou", "ser", "quando", "muito", "há", "nos", "já", "está", "eu", "também", "só", "pelo", "pela", "até", "isso", "ela", "entre", "era", "depois", "sem", "mesmo", "aos", "ter", "seus", "quem", "nas", "me", "esse", "eles", "estão", "você", "tinha", "foram", "essa", "num", "nem", "suas", "meu", "às", "minha", "têm", "numa", "pelos", "elas", "havia", "seja", "qual", "será", "nós", "tenho", "lhe", "deles", "essas", "esses", "pelas", "este", "fosse", "dele", "tu", "te", "vocês", "vos", "lhes", "meus", "minhas", "teu", "tua", "teus", "tuas", "nosso", "nossa", "nossos", "nossas", "dela", "delas", "esta", "estes", "estas", "aquele", "aquela", "aqueles", "aquelas", "isto", "aquilo", "estou", "está", "estamos", "estão", "estive", "esteve", "estivemos", "estiveram", "estava", "estávamos", "estavam", "estivera", "estivéramos", "esteja", "estejamos", "estejam", "estivesse", "estivéssemos", "estivessem", "estiver", "estivermos", "estiverem", "hei", "há", "havemos", "hão", "houve", "houvemos", "houveram", "houvera", "houvéramos", "haja", "hajamos", "hajam", "houvesse", "houvéssemos", "houvessem", "houver", "houvermos", "houverem", "houverei", "houverá", "houveremos", "houverão", "houveria", "houveríamos", "houveriam", "sou", "somos", "são", "era", "éramos", "eram", "fui", "foi", "fomos", "foram", "fora", "fôramos", "seja", "sejamos", "sejam", "fosse", "fôssemos", "fossem", "for", "formos", "forem", "serei", "será", "seremos", "serão", "seria", "seríamos", "seriam", "tenho", "tem", "temos", "tém", "tinha", "tínhamos", "tinham", "tive", "teve", "tivemos", "tiveram", "tivera", "tivéramos", "tenha", "tenhamos", "tenham", "tivesse", "tivéssemos", "tivessem", "tiver", "tivermos", "tiverem", "terei", "terá", "teremos", "terão", "teria", "teríamos", "teriam");
        relevantes = new ArrayList<>();//vazia q eu ainda vou botar umas budega aqui ainda
    }


    public void ProcessarTxt() {

        JFileChooser fileChooser = new JFileChooser();//bonitão aqui
        int numeradorLogico = fileChooser.showOpenDialog(null);//numerador logico (um sim ou nao)

        if (numeradorLogico == JFileChooser.APPROVE_OPTION) {
            File arquivoSelecionado = fileChooser.getSelectedFile();//aquivo selecionado == trequinho;

            try (BufferedReader leitor = new BufferedReader(new FileReader(arquivoSelecionado))) {//passa o trequinho pro leitor
                String linha;//string que vai receber a linha do txt
                while ((linha = leitor.readLine()) != null) {//aqui vai se repetir cada vez que a linha receber uma linha do txt até ele não receber mais
                    String[] palavras_separadas = linha.split("[\\s\\p{Punct}]+");// Divida a linha em palavras usando espaços em branco e pontuação como delimitadores
                    //peguei esse treco de "[\\s\\p{Punct}]+" do gpt...
                    for (String word : palavras_separadas) {//repete até que eu tenha percorrido todo o vetor de string
                        word = word.toLowerCase();// Converta para minúsculas
                        if (!stopwords.contains(word)) {// Verifique se a palavra não é uma stopword
                            relevantes.add(word);// adiciona a palavra a lista de palavras relevantes.
                        }//se nao for entao... fodase
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<String> getRelevantes() {
        return relevantes;
    }

    public int getTamanhoDoVetor() {
        return x;
    }
    
    public int getFrequencia(int index){
        int valor; // valor a ser retornado
        int[] vetor = CalcularFrequancia(); // vetor que a gente vai trabalhar aqui
        valor = vetor[index];
        System.out.println("calculando frequencia... pos: " + index);
        return valor;
    }
    
    private int[] aumentarVetor(int[] vetor, int tamanhoAtual){
        int[] novoVetor = new int[tamanhoAtual + 1];
        for (int z = 0; z < tamanhoAtual; z = z + 1){
            novoVetor[z] = vetor[z];
        }
        return novoVetor;
    }
    
    public int[] CalcularFrequancia(){
        int quantFrequencia = 1;// Quantas vezes a palavra se repetiu.
        int tamanhoVet = 1; // tamanho do vetor de frequencia
        int posFreq = 0; // posição no vetor de frequencias
        int frequencia[] = new int[tamanhoVet]; // vetor com tamanho alterável
        int cordenadaPalavra = 0; // cordenada da palavra na lista de palavras relevantes
        ArrayList<String> treco;
        treco = (ArrayList<String>) this.relevantes;
        Collections.sort(treco);// ordenando uma nova array, já q quem vai ter  resolver esse paranaue e a arvore
        for (String palavra : treco){
            if (cordenadaPalavra == 0){// se for a primeira palavra:
                frequencia[posFreq] = quantFrequencia;
                cordenadaPalavra = cordenadaPalavra + 1;
            } else if (cordenadaPalavra != 0 && !palavra.equals(treco.get(cordenadaPalavra -1))){
                // se não for a primeira palavra e for diferente da palavra anterior:
                if (tamanhoVet - 1 == posFreq){
                    frequencia = aumentarVetor(frequencia, tamanhoVet);
                    tamanhoVet = tamanhoVet + 1;
                }
                // se o vetor estiver cheio, chama o metodo que aumenta o vetor
                posFreq = posFreq + 1; // passa pra próxima posição do vetor
                quantFrequencia = 1; // nova palavra, nova frequencia
                frequencia[posFreq] = quantFrequencia; // coloca que é a primeira vez que voce ve essa palavra
                cordenadaPalavra = cordenadaPalavra + 1; // passa pra próxima palavra
            } else {
                // se não for a primeira palavra e for igual a palavra anterior:
                frequencia[posFreq] = quantFrequencia + 1;// aumenta dizendo que repetiu a palavra
                cordenadaPalavra = cordenadaPalavra + 1; // passa pra próxima palavra
            }
            
        }
        this.x = posFreq;
        return frequencia;
    }
    
    public boolean frequencia_ForNulo(int index){
        /*
        se a próxima poxição não existir, ou seja, for null; retona verdadeiro
        enquanto a posição existir ele retorna falso
        */
        return index > x;
    }
}
