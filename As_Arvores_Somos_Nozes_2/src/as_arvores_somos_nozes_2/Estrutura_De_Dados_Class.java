/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package as_arvores_somos_nozes_2;

import as_arvores_somos_nozes_2.ArquivoTXT.Txt_para_Lista;
import as_arvores_somos_nozes_2.ArquivoTXT.ArvereDescadeirada;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import java.util.Comparator;

public class Estrutura_De_Dados_Class {

    public static void main(String[] args) {
        // Instanciar a classe Txt_para_Lista para processar o arquivo de texto
        Txt_para_Lista processadorTxt = new Txt_para_Lista();
        processadorTxt.ProcessarTxt();

        // Obter a lista de palavras relevantes do processador de texto
        List<String> palavrasRelevantes = processadorTxt.getRelevantes();

        // Criar uma árvore AVL para armazenar as palavras e suas frequências
        TreeMap<String, Integer> arvoreAVL = new TreeMap<>();

        // Criar uma árvore desbalanceada a partir da classe ArvereDescadeirada
        ArvereDescadeirada arvoreDesbalanceada = new ArvereDescadeirada();

        // Inserir as palavras nas árvores e contar comparações (AVL e desbalanceada)
        int comparacoesAVL = 0;
        int comparacoesDesbalanceada = 0;
        
        // Medição de tempo da Arvore AVL 
        long inicioArvoreAVL = System.currentTimeMillis();
        long inicioArvoreDescadeirada = 0;
        boolean treco = true;
        for (String palavra : palavrasRelevantes) {
            // Inserir na árvore AVL e contar comparações
            if (arvoreAVL.containsKey(palavra)) {
                int frequencia = arvoreAVL.get(palavra);
                arvoreAVL.put(palavra, frequencia + 1);
            } else {
                arvoreAVL.put(palavra, 1);
            }
            if (treco){
            // Medição de tempo da Arvore Desbalanceada
            inicioArvoreDescadeirada = System.currentTimeMillis();
            treco = false;
            }
            // Inserir na árvore desbalanceada e contar comparações
            arvoreDesbalanceada.insereNaDescadeirada(palavra);
            comparacoesDesbalanceada += arvoreDesbalanceada.getComparacoes();
        
        }
            
          // Medição de tempo da Arvore AVL
        long fimAVL = System.currentTimeMillis();
        
        // Medição de tempo da Arvore Desbalanceada
        long fimDescadeirada = System.currentTimeMillis();
        
        // Medição de tempo da Busca Binario
        long inicioBinario = System.currentTimeMillis();
        // Ordenar as palavras alfabeticamente (usando ArrayList para Busca Binária)
        ArrayList<String> palavrasOrdenadas = new ArrayList<>(palavrasRelevantes);
        Collections.sort(palavrasOrdenadas);

        // Realizar busca binária e contar comparações
        int comparacoesBuscaBinaria = 0;

        for (String palavra : palavrasOrdenadas) {
            boolean encontrada = Collections.binarySearch(palavrasOrdenadas, palavra) >= 0;
            if (encontrada) {
                comparacoesBuscaBinaria++;
            }
        }
        // Medição de tempo da Busca Binario
        long fimBinario = System.currentTimeMillis();
        
        // Exibir as palavras e suas frequências
        System.out.println("\nFrequências das palavras (ordenadas alfabeticamente):");
        arvoreAVL.forEach((palavra, frequencia) -> {
            System.out.println(palavra + ": " + frequencia);
        });
        
        long tempoExecucaoAVL = fimAVL - inicioArvoreAVL;
        // Converter o tempo de execução de milissegundos para segundos
        double tempoExecucaoAVLSegundos = (double) tempoExecucaoAVL / 1000.0;
        
        // Exibir resultados das árvores AVL e desbalanceada, bem como da busca binária
        System.out.println("Resultados da Árvore AVL:");
        System.out.println("Número de comparações: " + comparacoesAVL);
        System.out.println("Tempo de execução: " + tempoExecucaoAVLSegundos);

        long tempoExecucaoDescadeirada = fimDescadeirada - inicioArvoreDescadeirada;
        // Converter o tempo de execução de milissegundos para segundos
        double tempoExecucaoDescadeiradaSegundos = (double) tempoExecucaoDescadeirada / 1000.0;
        
        System.out.println("\nResultados da Árvore Desbalanceada:");
        System.out.println("Número de comparações: " + comparacoesDesbalanceada);
        System.out.println("Tempo de execução: " + tempoExecucaoDescadeiradaSegundos);

        long tempoExecucaoBinario = fimBinario - inicioBinario;
        // Converter o tempo de execução de milissegundos para segundos
        double tempoExecucaoBinaioSegundos = (double) tempoExecucaoBinario / 1000.0;
        
        System.out.println("\nResultados da Busca Binária:");
        System.out.println("Número de comparações: " + comparacoesBuscaBinaria);
        System.out.println("Tempo de execução: "+ tempoExecucaoBinaioSegundos);
    }
}
