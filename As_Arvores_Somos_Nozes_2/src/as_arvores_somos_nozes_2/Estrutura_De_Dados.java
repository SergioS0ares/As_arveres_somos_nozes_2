/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package as_arvores_somos_nozes_2;

import as_arvores_somos_nozes_2.ArquivoTXT.Txt_para_Lista;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;
import java.util.List;
import java.util.Comparator;

public class Estrutura_De_Dados {
    public static void main(String[] args) {
        Txt_para_Lista processadorTxt = new Txt_para_Lista();
        processadorTxt.processarTxt();
        
        // TreeMap para armazenar as palavras e suas frequências na árvore AVL balanceada
        TreeMap<String, Integer> contadorAVL = new TreeMap<>();
        
        // ArrayList para armazenar as palavras e depois ordená-las para pesquisa binária
        ArrayList<String> palavrasArrayList = new ArrayList<>();
        
        // Preencha a árvore AVL e o ArrayList com as palavras relevantes
        for (String palavra : processadorTxt.getRelevantes()) {
            // Árvore AVL balanceada
            if (contadorAVL.containsKey(palavra)) {
                int frequencia = contadorAVL.get(palavra);
                contadorAVL.put(palavra, frequencia + 1);
            } else {
                contadorAVL.put(palavra, 1);
            }
            
            // ArrayList para pesquisa binária
            palavrasArrayList.add(palavra);
        }
        
        // Ordena o ArrayList para pesquisa binária
        Collections.sort(palavrasArrayList);
        
        // Medição do tempo na árvore AVL
        long inicioAVL = System.currentTimeMillis();
        
        // Imprime os resultados da árvore AVL balanceada
        System.out.println("Árvore AVL balanceada");
        System.out.println("Frequências das palavras:");
        List<String> palavrasOrdenadas = new ArrayList<>(contadorAVL.keySet());
        palavrasOrdenadas.sort(Comparator.naturalOrder());
        for (String palavra : palavrasOrdenadas) {
            System.out.println(palavra + ": " + contadorAVL.get(palavra));
        }
        
        // Medição do tempo na árvore AVL
        long fimAVL = System.currentTimeMillis();
        long tempoExecucaoAVL = fimAVL - inicioAVL;
        
        // Converte o tempo de execução de milissegundos para segundos
        double tempoExecucaoAVLSegundos = (double) tempoExecucaoAVL / 1000.0;
        
        System.out.println("Comparações AVL: " + processadorTxt.getRelevantes().size());
        System.out.println("Tempo de execução AVL (segundos): " + tempoExecucaoAVLSegundos);
        
        // Medição do tempo na pesquisa binária
        long inicioBinaria = System.currentTimeMillis();
        
        // Realiza pesquisa binária em palavrasArrayList
        System.out.println("\nPesquisa binária");
        System.out.println("Comparações pesquisa binária: " + palavrasArrayList.size());
        
        // Medição do tempo na pesquisa binária
        long fimBinaria = System.currentTimeMillis();
        long tempoExecucaoBinaria = fimBinaria - inicioBinaria;
        
        // Converte o tempo de execução de milissegundos para segundos
        double tempoExecucaoBinariaSegundos = (double) tempoExecucaoBinaria / 1000.0;
        
        System.out.println("Tempo de execução pesquisa binária (segundos): " + tempoExecucaoBinariaSegundos);
    }
}
