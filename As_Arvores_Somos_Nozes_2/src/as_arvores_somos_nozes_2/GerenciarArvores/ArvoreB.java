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
public class ArvoreB {
    
    public class NoDaArvoreB {

        public List<String> chaves; // Lista de chaves armazenadas no nó
        // não é uma referencia ao chaves, o nome na real deveria ser "keys", mas chaves tá de boa.
        public List<NoDaArvoreB> filhotes; // Lista de filhos do nó
        boolean folhinha; // Indica se o nó é uma folha
        // Construtor para inicializar um nó

        private NoDaArvoreB(boolean folhinha) {
            this.chaves = new ArrayList<>();
            this.filhotes = new ArrayList<>();
            this.folhinha = folhinha;
        }
    }
// Definição da classe principal da Árvore B

    NoDaArvoreB raiz; // Raiz da Árvore B... bem auto-explicativo.
    private int c; // Ordem da Árvore B (mínimo de chaves em um nó = t-1)
    private int comparacoesArvoreB;
    // O nome é pra ser "t" mesmo. esse é o nome padrão, não foi por preguiça.
    // Construtor para criar uma Árvore B com ordem t

    public ArvoreB(int chave) {
        this.raiz = new NoDaArvoreB(true);
        this.c = chave;
        this.comparacoesArvoreB = 0;
    } // Massa né?!
    // Método para inserir uma chave na Árvore B

    public void insert(String key) {
        NoDaArvoreB noRaiz = raiz;
        if (noRaiz.chaves.size() == (2 * c - 1)) {// Verificando se dá pra colocar nesse nó.
            NoDaArvoreB novaRaiz = new NoDaArvoreB(false);// Define como falso, até pq não é mais a raiz.
            novaRaiz.filhotes.add(noRaiz);
            dividirAHeranca(novaRaiz, 0);// chama o método que vai dividir o treco.
            // Agora a gente atualiza as coisas.
            noRaiz = novaRaiz;
            raiz = novaRaiz;
        }
        // Se o nó estava cheio, agoa ele vai estar com espaço disponível na raiz
        inserirOndeDisponivel(noRaiz, key);// Insere a infomação onde há espaço disponível pra inserí-lo
    }

    // Método auxiliar para inserir em um nó não cheio
    private void inserirOndeDisponivel(NoDaArvoreB no, String chave) {
        int index = no.chaves.size() - 1;// Define a medida do nó
        if (no.folhinha) {// Se ele for folha entra no if
            no.chaves.add(""); // Espaço para a nova chave (meio que instanciando ela)
            while (index >= 0 && chave.compareTo(no.chaves.get(index)) < 0) {
                no.chaves.set(index + 1, no.chaves.get(index));
                index--;
                comparacoesArvoreB++;
            }
            no.chaves.set(index + 1, chave);
        } else {// Se ele não for folha entra no else, óbviamente.
            while (index >= 0 && chave.compareTo(no.chaves.get(index)) < 0) {
                index--;
            }
            index++;
            NoDaArvoreB child = no.filhotes.get(index);
            if (child.chaves.size() == (2 * c - 1)) {// if dentro do else
                dividirAHeranca(no, index);
                if (chave.compareTo(no.chaves.get(index)) > 0) {// if dentro do if dentro do else
                    index++;
                }
            }
            inserirOndeDisponivel(no.filhotes.get(index), chave);
        }
    }

    // foi mal, tô com preguiça de saír escrevendo tudo que rola por aqui...
    // Método para dividir as chaves para um filho
    private void dividirAHeranca(NoDaArvoreB parentNode, int childIndex) {
        NoDaArvoreB child = parentNode.filhotes.get(childIndex);
        NoDaArvoreB newChild = new NoDaArvoreB(child.folhinha);
        parentNode.chaves.add(childIndex, child.chaves.get(c - 1));
        parentNode.filhotes.add(childIndex + 1, newChild);
        newChild.chaves.addAll(child.chaves.subList(c, 2 * c - 1));
        child.chaves.subList(c - 1, 2 * c - 1).clear();
        if (!child.folhinha) {
            newChild.filhotes.addAll(child.filhotes.subList(c, 2 * c));
            child.filhotes.subList(c, 2 * c).clear();
        }
        /*
        esse método vai dividir as coisas que estão no nó em outros quando ele encher.
        não adianta casar com ela, ela não vai ganhar herança...
         */
    }

    // Método para realizar uma busca na Árvore B
    public boolean search(String key) {
        return search(raiz, key);
    }

    // Método auxiliar para a busca
    private boolean search(NoDaArvoreB node, String key) {// Busca q retorna boolean
        int i = 0;
        while (i < node.chaves.size() && key.compareTo(node.chaves.get(i)) > 0) {
            i++;
            comparacoesArvoreB++;
        }
        if (i < node.chaves.size() && key.equals(node.chaves.get(i))) {
            return true;
        }
        if (node.folhinha) {
            return false;
        }
        return search(node.filhotes.get(i), key);
    }
    public NoDaArvoreB getRaiz() {
        return raiz;
    }

    public int getComparacoesArvoreB() {
        return comparacoesArvoreB;
    }

    public void setComparacoesArvoreB(int comparacoesArvoreB) {
        this.comparacoesArvoreB = comparacoesArvoreB;
    }

}
