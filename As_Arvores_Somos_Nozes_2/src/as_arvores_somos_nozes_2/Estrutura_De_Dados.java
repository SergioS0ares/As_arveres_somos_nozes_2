/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package as_arvores_somos_nozes_2;

import as_arvores_somos_nozes_2.ArquivoTXT.Txt_para_Lista;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Arrays;

public class Estrutura_De_Dados {
    public static void main(String[] args) {
        Txt_para_Lista ProcessarTxt = new Txt_para_Lista();
        ProcessarTxt.ProcessarTxt();
        // TreeMap para armazenar as palavras e suas frequências
        TreeMap<String, Integer> contador = new TreeMap<>();
        int numComparacoesAVL = 0;
        int numComparacoesBinaria = 0;
        
        // Obtém o tempo de início da execução em Millisegundos
        long inicio = System.currentTimeMillis();
        
        // Crie um objeto Scanner para ler a entrada do usuário
        Scanner entrada = new Scanner(System.in);
        
        // Solicite ao usuário que insira um texto (sem considerar a pontuação)
        while (true) {
            System.out.print("Digite uma palavra (ou 'sair' para encerrar): ");
            String texto = entrada.nextLine().toLowerCase(); // Converter para minúsculas
            
            if (texto.equals("sair")) {
                break; // Encerra o loop se o usuário digitar 'sair'
            }
            
            // Divida o texto em palavras usando espaço como delimitador
            String[] palavras = texto.split("\\s+"); // Dividir por espaços em branco
        
            // Itere pelas palavras e conte a frequência
            for (String palavra : palavras) {
                // Verifique se a palavra não é vazia
                if (!palavra.isEmpty()) {
                    // Verifique se a palavra já existe no mapa
                    if (contador.containsKey(palavra)) {
                        // Se a palavra já existe, incremente a frequência
                        int frequencia = contador.get(palavra);
                        contador.put(palavra, frequencia + 1);
                    } else {
                        // Se a palavra é nova, adicione-a ao mapa com frequência 1
                        contador.put(palavra, 1);
                    }
                    // Incrementar o contador de comparações para AVL
                    numComparacoesAVL++;
                }
            }
        }        
        // Obtém o tempo de fim da execução da AVL em Millisegundos
        long fimAVL = System.currentTimeMillis();
        
        // Calcula o tempo total de execução da AVL em segundos
        double tempoExecucaoAVLSegundos = (fimAVL - inicio) / 1000.0;
        
        // Pesquisa binária usando Arrays.binarySearch
        String[] palavrasArray = contador.keySet().toArray(new String[0]);
        Arrays.sort(palavrasArray); // Ordena o array para pesquisa binária
        for (String palavra : palavrasArray) {
            numComparacoesBinaria++;
        }
        
        // Obtém o tempo de fim da execução da pesquisa binária em nanossegundos
        long fimBinaria = System.nanoTime();
        
        // Calcula o tempo total de execução da pesquisa binária em segundos
        double tempoExecucaoBinariaSegundos = (fimBinaria - fimAVL) / 1000.0;
        
        // Imprime os resultados
        System.out.println("Árvore AVL");
        System.out.println("comparações: " + numComparacoesAVL);
        System.out.println(tempoExecucaoAVLSegundos + " segundos\n");
        
        System.out.println("Pesquisa binária");
        System.out.println("comparações: " + numComparacoesBinaria);
        System.out.println(tempoExecucaoBinariaSegundos + " segundos\n");
        
        // Imprima as palavras em ordem alfabética e suas frequências diretamente do TreeMap
        System.out.println("Frequências das palavras:");
        contador.forEach((palavra, frequencia) -> {
            System.out.println(palavra + ": " + frequencia);
        });
        
        // Feche o Scanner
        entrada.close();
    }
}
