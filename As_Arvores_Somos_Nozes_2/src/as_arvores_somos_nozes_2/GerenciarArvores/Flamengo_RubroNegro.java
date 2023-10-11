/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package as_arvores_somos_nozes_2.GerenciarArvores;

/**
 *
 * @author julio
 */
public class Flamengo_RubroNegro <K extends Comparable<K>, V> {
    private NodoRN<K, V> raiz; // Raiz da árvore
    private int comparacoes; // Contador de comparacoes

    // Constantes para cores dos nodos
    private static final boolean VERMELHO = true;
    private static final boolean PRETO = false;

    // Classe interna para representar os nodos
    private static class NodoRN<K, V> {
        K chave;
        V valor;
        NodoRN<K, V> esquerda, direita;
        boolean cor; // Cor do nodo (true para vermelho, false para preto)

        NodoRN(K chave, V valor, boolean cor) {
            this.chave = chave;
            this.valor = valor;
            this.cor = cor;
        }
    }

    public Flamengo_RubroNegro() {//Construtor Guloso
        this.raiz = null;
        this.comparacoes = 0;
    }

    // Inserir um nodo na árvore
    public void inserir(K chave, V valor) {
        raiz = preencherNodo(raiz, chave, valor);
        raiz.cor = PRETO; // A raiz deve sempre ser preta
    }

    // Inserir um nodo na árvore (método privado e recursivo)
    private NodoRN<K, V> preencherNodo(NodoRN<K, V> nodo, K chave, V valor) {
        if (nodo == null) {
            return new NodoRN<>(chave, valor, VERMELHO);
        }

        // Realizar a comparação
        comparacoes++;
        int comparacao = chave.compareTo(nodo.chave);

        if (comparacao < 0) {
            nodo.esquerda = preencherNodo(nodo.esquerda, chave, valor);
        } else if (comparacao > 0) {
            nodo.direita = preencherNodo(nodo.direita, chave, valor);
        } else {
            nodo.valor = valor;
        }

        // Realizar as rotações e correções de cores
        if (ehVermelho(nodo.direita) && !ehVermelho(nodo.esquerda)) {
            nodo = rotacaoEsquerda(nodo);
        }
        if (ehVermelho(nodo.esquerda) && ehVermelho(nodo.esquerda.esquerda)) {
            nodo = rotacaoDireita(nodo);
        }
        if (ehVermelho(nodo.esquerda) && ehVermelho(nodo.direita)) {
            inverterCores(nodo);
        }

        return nodo;
    }

    // Método para verificar se um nodo é vermelho
    private boolean ehVermelho(NodoRN<K, V> nodo) {
        if (nodo == null) {
            return false;
        }
        return nodo.cor == VERMELHO;
    }

    // Realizar rotação para a esquerda
    private NodoRN<K, V> rotacaoEsquerda(NodoRN<K, V> nodo) {
        NodoRN<K, V> treco = nodo.direita;
        nodo.direita = treco.esquerda;
        treco.esquerda = nodo;
        treco.cor = nodo.cor;
        nodo.cor = VERMELHO;
        return treco;
    }

    // Realizar rotação para a direita
    private NodoRN<K, V> rotacaoDireita(NodoRN<K, V> nodo) {
        NodoRN<K, V> treco = nodo.esquerda;
        nodo.esquerda = treco.direita;
        treco.direita = nodo;
        treco.cor = nodo.cor;
        nodo.cor = VERMELHO;
        return treco;
    }

    // Inverter cores de um nodo e seus filhos
    private void inverterCores(NodoRN<K, V> nodo) {
        nodo.cor = !nodo.cor;
        nodo.esquerda.cor = !nodo.esquerda.cor;
        nodo.direita.cor = !nodo.direita.cor;
    }

    // Contador de comparacoes
    public int getComparacoes() {
        return comparacoes;
    }
}
