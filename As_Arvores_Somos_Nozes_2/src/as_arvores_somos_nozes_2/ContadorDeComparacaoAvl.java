/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package as_arvores_somos_nozes_2;

import java.util.TreeMap;

/**
 *
 * @author julio
 */
public class ContadorDeComparacaoAvl {
    // Método para contar comparações na Árvore AVL ao procurar uma palavra
    public int contarComparacoes(TreeMap<String, Integer> arvoreAVL, String palavra) {
        int comparacoes = 0;
        for (String chave : arvoreAVL.keySet()) {
            comparacoes++; // Conta a comparação atual
            int resultadoComparacao = palavra.compareTo(chave);
            if (resultadoComparacao == 0) {
                // A palavra foi encontrada, termine a busca
                break;
            } else if (resultadoComparacao < 0) {
                // A palavra está à esquerda, continue a busca na subárvore esquerda
                if (arvoreAVL.lowerKey(chave) == null) {
                    break; // Não há mais elementos à esquerda
                }
            } else {
                // A palavra está à direita, continue a busca na subárvore direita
                if (arvoreAVL.higherKey(chave) == null) {
                    break; // Não há mais elementos à direita
                }
            }
        }
        return comparacoes;
    }
}