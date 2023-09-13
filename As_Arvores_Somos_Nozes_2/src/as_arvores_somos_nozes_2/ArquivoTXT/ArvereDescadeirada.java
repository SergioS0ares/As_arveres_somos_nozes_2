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
    class Nozinho {
        int data;
        Nozinho left;
        Nozinho right;

        public Nozinho(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private Nozinho root;

    public ArvereDescadeirada() {
        root = null;
    }

    // Método para inserir um elemento na árvore
    public void insereNaDescadeirada(int data) {
        root = treco(root, data);
    }

    // Função auxiliar para inserir um elemento de forma recursiva
    private Nozinho treco(Nozinho raizera, int data) {
        if (raizera == null) {
            raizera = new Nozinho(data);
            return raizera;
        }

        if (data < raizera.data) {
            raizera.left = treco(raizera.left, data);
        } else if (data > raizera.data) {
            raizera.right = treco(raizera.right, data);
        }

        return raizera;
    }

    // Método para realizar uma pesquisa na árvore
    public boolean buscaNaDescadeirada(int data) {
        return trequinho(root, data);
    }

    // Função auxiliar para realizar uma pesquisa de forma recursiva
    private boolean trequinho(Nozinho root, int data) {
        if (root == null) {
            return false;
        }

        if (data == root.data) {
            return true;
        }

        if (data < root.data) {
            return trequinho(root.left, data);
        }

        return trequinho(root.right, data);
    }
}