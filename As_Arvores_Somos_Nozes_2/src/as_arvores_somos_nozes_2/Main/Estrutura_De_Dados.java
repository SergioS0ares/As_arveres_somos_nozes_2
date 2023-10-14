/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package as_arvores_somos_nozes_2.Main;

import as_arvores_somos_nozes_2.ArquivoTXT.Txt_para_Lista;
import as_arvores_somos_nozes_2.GerenciarArvores.ArvereDescadeirada;
import as_arvores_somos_nozes_2.GerenciarArvores.ArvoreCadeirada;
import as_arvores_somos_nozes_2.GerenciarArvores.ArvoreB;
import as_arvores_somos_nozes_2.Visual.Tela;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import as_arvores_somos_nozes_2.GerenciarArvores.Flamengo_RubroNegro;
import java.awt.EventQueue;

public class Estrutura_De_Dados {
     
    public static void main(String[] args) {
        // Instanciar a classe Txt_para_Lista para processar o arquivo de texto
        Txt_para_Lista processadorTxt = new Txt_para_Lista();
        processadorTxt.ProcessarTxt();

        // Instanciar a nova classe ArvereDescadeirada
        ArvereDescadeirada arvoreDescadeirada = new ArvereDescadeirada();
        
        // Instanciar a nova Classe ArvoreCadeirada
        ArvoreCadeirada arvoreCadeirada = new ArvoreCadeirada();

        // Instanciar a classe ArvoreB e mostrar quantas chaves de uma página
        ArvoreB arvoreBBB = new ArvoreB(4);

        // Instanciar a classe Flamengo_RubroNegro (Árvore Rubro-Negra)
        Flamengo_RubroNegro arvoreFlamenguista = new Flamengo_RubroNegro();

        // Obter a lista de palavras relevantes do processador de texto
        List<String> palavrasRelevantes = processadorTxt.getRelevantes();

        // Medição de tempo da Árvore B
        long inicioArvoreB = System.currentTimeMillis();

        for (String palavra : palavrasRelevantes) {
            // Inserir na Árvore B
            arvoreBBB.insert(palavra);
        }
        // Medição de tempo da Árvore B
        long fimB = System.currentTimeMillis();

        // Medição de tempo da Árvore Cadeirada (ArvoreCadeirada)
        long inicioArvoreCadeirada = System.currentTimeMillis();
        int comparacoesCadeirada = 0; // Variável para contar as comparações na ArvoreCadeirada

        for (String palavra : palavrasRelevantes) {
            // Inserir na Árvore Cadeirada e contar comparações
            arvoreCadeirada.insereNaDescadeirada(palavra);
            comparacoesCadeirada += arvoreCadeirada.getComparacoes();
        }
        // Medição de tempo da Árvore Cadeirada
        long fimCadeirada = System.currentTimeMillis();

        // Medição de tempo da Árvore Descadeirada (ArvoreCadeirada)
        long inicioArvoreDescadeirada = System.currentTimeMillis();
        int comparacoesDescadeirada = 0; // Variável para contar as comparações na ArvoreCadeirada

        for (String palavra : palavrasRelevantes) {
            // Inserir na Árvore Descadeirada e contar comparações
            arvoreDescadeirada.insereNaDescadeirada(palavra);
            comparacoesDescadeirada += arvoreDescadeirada.getComparacoes();
        }
        // Medição de tempo da Árvore Descadeirada
        long fimDescadeirada = System.currentTimeMillis();
        
        // Medição de tempo da Árvore Rubro-Negra
        long inicioArvoreRubroNegra = System.currentTimeMillis();
        int comparacoesRubroNegra = 0; // Variável para contar as comparações na Árvore Rubro-Negra

        for (String palavra : palavrasRelevantes) {
            // Inserir na Árvore Rubro-Negra
            arvoreFlamenguista.inserir(palavra, null); // O segundo argumento pode ser ajustado conforme sua necessidade
        }
        // Medição de tempo da Árvore Rubro-Negra
        long fimRubroNegra = System.currentTimeMillis();

        // Medição de tempo da Busca Binária
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
        // Medição de tempo da Busca Binária
        long fimBinario = System.currentTimeMillis();
        ArrayList<String> treco = new ArrayList<>();

        // Exibir as palavras e suas frequências
        treco.add("\nFrequências das palavras (ordenadas alfabeticamente):");
        int listaRelevantes = 0;// contador que vai acompanhar a lista de palavras relevantes
        int posFreq = 0;// contador que vai acompanhar o vetor de frequencia
        for (String palavra : palavrasOrdenadas){// repetição que vai percorrer palavra por palavra da lista de palavras relevantes
            if (listaRelevantes == 0){// se for a primeira palavra
                treco.add("\n" + palavra + ": " + processadorTxt.getFrequencia(posFreq));
                // adiciona o que vai ser imprimido
                posFreq ++;// passa pra proxima posição do vetor
                listaRelevantes ++;// passa pra proxima palavra relevante
            } else if (listaRelevantes > 0 && !palavra.equals(palavrasOrdenadas.get(listaRelevantes-1))){
                /*
                se não for a primeira palavra e for diferente da palavra enterior entao é uma nova palavra
                */
                treco.add("\n" + palavra + ": " + processadorTxt.getFrequencia(posFreq));// adiciona pra impressão
                listaRelevantes ++;// passa pra próxima palavra relevante
                if (!processadorTxt.frequencia_ForNulo(posFreq + 1)){// verifica se a próxima posição do vetor é nula
                    posFreq ++;// passa pra proxima posição do vetor
                }
            } else {
                // Se não for a primeira palavra e for igual a palavra anterior, então não deve ser imprimido novamente.
                listaRelevantes ++;// passa pra próxima palavra
            }
        }

        long tempoExecucaoArvoreCadeirada = fimCadeirada - inicioArvoreCadeirada;
        // Converter o tempo de execução de milissegundos para segundos
        double tempoExecucaoArvoreCadeiradaSegundos = (double) tempoExecucaoArvoreCadeirada / 1000.0;

        treco.add("\nResultados da Árvore Balanceada:\n");
        treco.add("Número de comparações: " + comparacoesCadeirada + "\n");
        treco.add("Tempo de execução: " + tempoExecucaoArvoreCadeiradaSegundos + " segundos\n");

        long tempoExecucaoArvoreDescadeirada = fimCadeirada - inicioArvoreCadeirada;
        // Converter o tempo de execução de milissegundos para segundos
        double tempoExecucaoArvoreDescadeiradaSegundos = (double) tempoExecucaoArvoreCadeirada / 1000.0;

        treco.add("\nResultados da Árvore Desbalanceada:\n");
        treco.add("Número de comparações: " + comparacoesDescadeirada + "\n");
        treco.add("Tempo de execução: " + tempoExecucaoArvoreDescadeiradaSegundos + " segundos\n");
        
        long tempoExecucaoRubroNegra = fimRubroNegra - inicioArvoreRubroNegra;
        // Converter o tempo de execução de milissegundos para segundos
        double tempoExecucaoRubroNegraSegundos = (double) tempoExecucaoRubroNegra / 1000.0;

        treco.add("\nResultados da Árvore Rubro-Negra:\n");
        treco.add("Número de comparações: " + comparacoesRubroNegra + "\n");
        treco.add("Tempo de execução: " + tempoExecucaoRubroNegraSegundos + " segundos\n");

        long tempoExecucaoBinario = fimBinario - inicioBinario;
        // Converter o tempo de execução de milissegundos para segundos
        double tempoExecucaoBinarioSegundos = (double) tempoExecucaoBinario / 1000.0;

        treco.add("\nResultados da Busca Binária:\n");
        treco.add("Número de comparações: " + comparacoesBuscaBinaria + "\n");
        treco.add("Tempo de execução: " + tempoExecucaoBinarioSegundos + " segundos\n");

        long tempoExecucaoArvoreB = fimB - inicioArvoreB;
        // Converter o tempo de execução de milissegundos para segundos
        double tempoExecucaoArvoreBSegundos = (double) tempoExecucaoArvoreB / 1000.0;

        treco.add("\nResultados da Árvore B:\n");
        treco.add("Número de comparações: " + arvoreBBB.getComparacoesArvoreB() + "\n");
        treco.add("Tempo de execução: " + tempoExecucaoArvoreBSegundos + " segundos\n");

        // Criar uma instância da classe Tela
        Tela instanciaTela = new Tela();
        instanciaTela.setVisible(true);

        // Usar EventQueue.invokeLater para exibir a interface gráfica na thread de eventos
        EventQueue.invokeLater(() -> {
            // Exibir as árvores na interface gráfica
            instanciaTela.ExibirArvoreGraficamente(arvoreCadeirada, arvoreDescadeirada, arvoreBBB, arvoreFlamenguista);
            instanciaTela.printarTextoGraficamente(treco);
        });      
    }
}

