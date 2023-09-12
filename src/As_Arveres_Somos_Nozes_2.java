/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package as_arveres_somos_nozes_2;

import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class As_Arveres_Somos_Nozes_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Listagem lista = new Listagem();
         try{
         ArrayList<String> p = lista.LeituraArray();
         for(String palavras:p){
            System.out.println(palavras);
         }
}catch(Exception e){
    e.printStackTrace();
}
    }
    
}
