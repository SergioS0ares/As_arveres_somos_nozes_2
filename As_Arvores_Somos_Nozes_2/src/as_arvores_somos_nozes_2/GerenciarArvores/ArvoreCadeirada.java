/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package as_arvores_somos_nozes_2.GerenciarArvores;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julio
 */
public class ArvoreCadeirada {
    public class Nozinho { 
        public String data;
        public Nozinho left;
        public Nozinho right;
        int altura; // Adicionamos a altura do nó

        public Nozinho(String data) {
            this.data = data;
            left = null;
            right = null;
            altura = 1; // Começamos com altura 1
        }

        // Métodos getters para a altura
        public int getAltura() {
            return altura;
        }

        public void atualizarAltura() {
            int alturaEsquerda = (left != null) ? left.getAltura() : 0;
            int alturaDireita = (right != null) ? right.getAltura() : 0;
            altura = Math.max(alturaEsquerda, alturaDireita) + 1;
        }
    }

    public Nozinho root;
    private int comparamenteiro;

    public ArvoreCadeirada() {
        root = null;
        comparamenteiro = 0;
    }

    // Método para inserir uma string na árvore
    public void insereNaDescadeirada(String data) {
        root = nodoAtual(root, data);
    }

    private Nozinho nodoAtual(Nozinho raizera, String data) {
        if (raizera == null) {
            raizera = new Nozinho(data);
            return raizera;
        }

        int comparatoeira = data.compareTo(raizera.data);
        comparamenteiro++;

        if (comparatoeira < 0) {
            raizera.left = nodoAtual(raizera.left, data);
        } else if (comparatoeira > 0) {
            raizera.right = nodoAtual(raizera.right, data);
        }

        raizera.atualizarAltura(); // Atualiza a altura após a inserção

        // Realizamos as rotações necessárias para balancear a árvore
        int fatorBalanceamento = getFatorBalanceamento(raizera);

        if (fatorBalanceamento > 1) {
            if (data.compareTo(raizera.left.data) < 0) {
                return rotacaoDireita(raizera);
            } else {
                raizera.left = rotacaoEsquerda(raizera.left);
                return rotacaoDireita(raizera);
            }
        }

        if (fatorBalanceamento < -1) {
            if (data.compareTo(raizera.right.data) > 0) {
                return rotacaoEsquerda(raizera);
            } else {
                raizera.right = rotacaoDireita(raizera.right);
                return rotacaoEsquerda(raizera);
            }
        }

        return raizera;
    }

    private int getFatorBalanceamento(Nozinho nodo) {
        int alturaEsquerda = (nodo.left != null) ? nodo.left.getAltura() : 0;
        int alturaDireita = (nodo.right != null) ? nodo.right.getAltura() : 0;
        return alturaEsquerda - alturaDireita;
    }

    private Nozinho rotacaoEsquerda(Nozinho nodo) {
        Nozinho nodoDireita = nodo.right;
        nodo.right = nodoDireita.left;
        nodoDireita.left = nodo;
        nodo.atualizarAltura();
        nodoDireita.atualizarAltura();
        return nodoDireita;
    }

    private Nozinho rotacaoDireita(Nozinho nodo) {
        Nozinho nodoEsquerda = nodo.left;
        nodo.left = nodoEsquerda.right;
        nodoEsquerda.right = nodo;
        nodo.atualizarAltura();
        nodoEsquerda.atualizarAltura();
        return nodoEsquerda;
    }

    public boolean buscaNaDescadeirada(String data) {
        return trequinho(root, data);
    }

    private boolean trequinho(Nozinho root, String data) {
        if (root == null) {
            return false;
        }

        int resultadoComparacao = data.compareTo(root.data);
        comparamenteiro++;

        if (resultadoComparacao == 0) {
            return true;
        }

        if (resultadoComparacao < 0) {
            return trequinho(root.left, data);
        }

        return trequinho(root.right, data);
    }

    public Nozinho getRoot() {
        return root;
    }

    public List<Nozinho> getChildren(Nozinho noAtual) {
        List<Nozinho> children = new ArrayList<>();
        if (noAtual != null) {
            if (noAtual.left != null) {
                children.add(noAtual.left);
            }
            if (noAtual.right != null) {
                children.add(noAtual.right);
            }
        }
        return children;
    }

    public int getComparacoes() {
        return comparamenteiro;
    }
}