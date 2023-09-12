/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package as_arvores_somos_nozes_2;
import java.io.PrintStream;
import java.util.Scanner;

public class BinaryTreePrinter {

    private BinaryTreeModel tree;

    public BinaryTreePrinter(BinaryTreeModel tree) {
        this.tree = tree;
    }

    private String traversePreOrder(BinaryTreeModel root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.getValue());

        String pointerRight = "└──";
        String pointerLeft = (root.getRight() != null) ? "├──" : "└──";

        traverseNodes(sb, "", pointerLeft, root.getLeft(), root.getRight() != null);
        traverseNodes(sb, "", pointerRight, root.getRight(), false);

        return sb.toString();
    }

    private void traverseNodes(StringBuilder sb, String padding, String pointer, BinaryTreeModel node,
        boolean hasRightSibling) {
        if (node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getValue());

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (node.getRight() != null) ? "├──" : "└──";

            traverseNodes(sb, paddingForBoth, pointerLeft, node.getLeft(), node.getRight() != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.getRight(), false);
        }
    }

    public void print(PrintStream os) {
        os.print(traversePreOrder(tree));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite as informações da árvore (por exemplo, A, B, C): ");
        String arvoreInfo = scanner.nextLine();

        BinaryTreeModel arvore = criarArvoreComBaseNaEntrada(arvoreInfo);

        BinaryTreePrinter printer = new BinaryTreePrinter(arvore);
        System.out.println("Árvore:");
        printer.print(System.out);

        System.out.print("\nDigite o caminho desejado (por exemplo, L, R, R): ");
        String caminho = scanner.nextLine();
        caminho = caminho.replace(" ", "");

        BinaryTreeModel no = encontrarNoPorCaminho(arvore, caminho);
        if (no != null) {
            System.out.println("\nValor encontrado no caminho: " + no.getValue());
        } else {
            System.out.println("\nCaminho inválido ou nó não encontrado.");
        }

        scanner.close();
    }

    // Implemente a lógica para criar a árvore com base na entrada do usuário
    private static BinaryTreeModel criarArvoreComBaseNaEntrada(String entrada) {
        // Implemente sua lógica aqui
        // Por exemplo, você pode criar uma árvore binária de pesquisa com os valores fornecidos
        return null; // Substitua com a árvore criada
    }

    // Implemente a lógica para encontrar um nó por caminho
    private static BinaryTreeModel encontrarNoPorCaminho(BinaryTreeModel root, String caminho) {
        // Implemente sua lógica aqui
        return null; // Substitua com o nó encontrado ou null se não encontrado
    }
}
