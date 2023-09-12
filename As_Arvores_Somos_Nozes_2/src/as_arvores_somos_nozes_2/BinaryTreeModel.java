/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package as_arvores_somos_nozes_2;

/**
 *
 * @author sergy
 */
public class BinaryTreeModel {
    private String value;
    private BinaryTreeModel left;
    private BinaryTreeModel right;

    public BinaryTreeModel(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public String getValue() {
        return value;
    }

    public BinaryTreeModel getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeModel left) {
        this.left = left;
    }

    public BinaryTreeModel getRight() {
        return right;
    }

    public void setRight(BinaryTreeModel right) {
        this.right = right;
    }
}

