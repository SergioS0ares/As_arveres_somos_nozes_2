/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package as_arvores_somos_nozes_2.ArquivoTXT;

/**
 *
 * @author julio
 */

public class ArvereDescadeirada {
    class Nozinho { // nó das bubububibibi
        String data;
        Nozinho left;
        Nozinho right;

        public Nozinho(String data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private Nozinho root; // que se faça o nó!
    private int comparamenteiro; // Contador para acompanhar o número de comparações

    public ArvereDescadeirada() { // chama esse aqui pra fazer a coisa toda existir
        root = null;
        comparamenteiro = 0;
    }

    // Método para inserir uma string na árvore
    public void insereNaDescadeirada(String data) { // enfia o papo
        root = treco(root, data);
    }

    // Função auxiliar para inserir uma string de forma recursiva
    private Nozinho treco(Nozinho raizera, String data) { // treco é a coisa que vc quer adicionar
        if (raizera == null) {
            raizera = new Nozinho(data);
            return raizera; // pipipipopopo
        }

        // Comparar a string alfabeticamente e decidir a direção
        int comparatoeira = data.compareTo(raizera.data); //contador da comparação
        comparamenteiro++; // Incrementar o contador de comparações

        if (comparatoeira < 0) {
            raizera.left = treco(raizera.left, data);
        } else if (comparatoeira > 0) {
            raizera.right = treco(raizera.right, data);
        }
        /*
        peguei essa coisa que divide os trecos de maior, menor... puxei isso tudo do gpt
                if (comparatoeira < 0) {
            raizera.left = treco(raizera.left, data);
        } else if (comparatoeira > 0) {
            raizera.right = treco(raizera.right, data);
        }

        */
        return raizera;
    }

    public boolean buscaNaDescadeirada(String data) {// Método para realizar uma pesquisa na árvore
        return trequinho(root, data);
    }

    private boolean trequinho(Nozinho root, String data) {// Função auxiliar para realizar uma pesquisa de forma recursiva
        if (root == null) {
            return false;
        }

        int resultadoComparacao = data.compareTo(root.data);
        comparamenteiro++; // Incrementar o contador de comparações

        if (resultadoComparacao == 0) { 
            return true;
        }

        if (resultadoComparacao < 0) {
            return trequinho(root.left, data);
        }

        return trequinho(root.right, data);
    }

    // Método para obter o número de comparações feitas
    public int getComparacoes() {
        return comparamenteiro;
    }
}
