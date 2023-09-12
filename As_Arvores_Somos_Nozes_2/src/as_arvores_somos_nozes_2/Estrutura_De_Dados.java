/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package as_arvores_somos_nozes_2;

import java.util.Scanner;
import java.util.TreeMap;

public class Estrutura_De_Dados {
    public static void main(String[] args) {
        // Crie um TreeMap para armazenar as palavras e suas frequências
        TreeMap<String, Integer> contador = new TreeMap<>();
        int numComparacoes = 0;
        
        // Obtém o tempo de início da execução em nanossegundos
        long inicio = System.nanoTime();
        
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
                    // Incrementar o contador de comparações
                    numComparacoes++;
                }
            }
        }
        
        // Obtém o tempo de fim da execução em nanossegundos
        long fim = System.nanoTime();
        
        // Calcula o tempo total de execução em segundos
        double tempoExecucaoSegundos = (fim - inicio) / 1e9;
        
        // Imprima as palavras e suas frequências
        contador.forEach((palavra, frequencia) -> {
            System.out.println(palavra + ": " + frequencia);
        });
        
        // Imprima o número de comparações
        System.out.println("Número de comparações: " + numComparacoes);
        
        // Imprima o tempo de execução em segundos
        System.out.println("Tempo de execução (segundos): " + tempoExecucaoSegundos);
        
        // Feche o Scanner
        entrada.close();
    }
}
