/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package as_arvores_somos_nozes_2.Main;

import as_arvores_somos_nozes_2.ArquivoTXT.Txt_para_Lista;
import as_arvores_somos_nozes_2.GerenciarArvores.ArvereDescadeirada;
import as_arvores_somos_nozes_2.GerenciarArvores.ArvoreB;
import as_arvores_somos_nozes_2.Visual.Tela;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import as_arvores_somos_nozes_2.GerenciarArvores.ContadorDeComparacaoAvl;
import java.awt.EventQueue;

public class Estrutura_De_Dados {
     
    public static void main(String[] args) {
        // Instanciar a classe Txt_para_Lista para processar o arquivo de texto
        Txt_para_Lista processadorTxt = new Txt_para_Lista();
        processadorTxt.ProcessarTxt();
        ContadorDeComparacaoAvl programa = new ContadorDeComparacaoAvl();
        
        //Instanciar a classe ArvoreB, e mostrar quantas chaves de uma pagina
        ArvoreB arvoreb = new ArvoreB(4);
        
        // Obter a lista de palavras relevantes do processador de texto
        List<String> palavrasRelevantes = processadorTxt.getRelevantes();

        // Criar uma árvore AVL para armazenar as palavras e suas frequências
        TreeMap<String, Integer> arvoreAVL = new TreeMap<>();

        // Criar uma árvore desbalanceada a partir da classe ArvereDescadeirada
        ArvereDescadeirada arvoreDesbalanceada = new ArvereDescadeirada();

        // Medição de tempo da Árvore AVL
    long inicioArvoreB = System.currentTimeMillis();
    int comparacoesB = 0; // Variável para contar as comparações na AVL
    
     boolean coiso = true;
    for (String palavra : palavrasRelevantes) {
        if (coiso) {
            // Medição de tempo da Árvore Desbalanceada
            inicioArvoreB = System.currentTimeMillis();
            coiso = false;
        }
        // Inserir na árvore desbalanceada e contar comparações
        arvoreb.insert(palavra);
        //comparacoesDesbalanceada += arvoreDesbalanceada.getComparacoes(); AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    }
     // Medição de tempo da Arvore AVL
        long fimB = System.currentTimeMillis();
    
    
        // Medição de tempo da Árvore AVL
    long inicioArvoreAVL = System.currentTimeMillis();
    int comparacoesAVL = 0; // Variável para contar as comparações na AVL
    
    // Inserir as palavras nas árvores e contar comparações (desbalanceada)
    int comparacoesDesbalanceada = 0;

    for (String palavra : palavrasRelevantes) {
        // Inserir na árvore AVL e contar comparações
        if (arvoreAVL.containsKey(palavra)) {
            int frequencia = arvoreAVL.get(palavra);
            arvoreAVL.put(palavra, frequencia + 1);
        } else {
            arvoreAVL.put(palavra, 1);
        }
        // Realizar comparações na AVL e contar
    int comparacoes = programa.contarComparacoes(arvoreAVL, palavra);
    comparacoesAVL += comparacoes;
    }

    // Medição de tempo da Árvore Desbalanceada
    long inicioArvoreDescadeirada = System.currentTimeMillis();
    boolean treco = true;

    for (String palavra : palavrasRelevantes) {
        if (treco) {
            // Medição de tempo da Árvore Desbalanceada
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
        double tempoExecucaoBinarioSegundos = (double) tempoExecucaoBinario / 1000.0;
        
        System.out.println("\nResultados da Busca Binária:");
        System.out.println("Número de comparações: " + comparacoesBuscaBinaria);
        System.out.println("Tempo de execução: "+ tempoExecucaoBinarioSegundos);
        
        long tempoExecucaoArvoreB = fimB - inicioArvoreB;
        // Converter o tempo de execução de milissegundos para segundos
        double tempoExecucaoArvoreBSegundos = (double) tempoExecucaoArvoreB / 1000.0;
        
        System.out.println("\nResultados da Árvore B:");
        //System.out.println("Número de comparações: " + ); AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
        System.out.println("Tempo de execução: "+ tempoExecucaoArvoreBSegundos);
        
       
 // Criar uma instância da classe Tela
        Tela instanciaTela = new Tela();
        instanciaTela.setVisible(true);

        // Usar EventQueue.invokeLater para exibir a interface gráfica na thread de eventos
        EventQueue.invokeLater(() -> {
            // Exibir as árvores na interface gráfica
            instanciaTela.exibirArvoresGraficamente(arvoreAVL, arvoreDesbalanceada);
        });
      
    }
}
