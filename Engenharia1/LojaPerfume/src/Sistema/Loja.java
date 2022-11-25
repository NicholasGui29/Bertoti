/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import java.util.ArrayList;
/**
 *
 * @author Cliente
 */
public class Loja {
    private static ArrayList<Produto> listaPerfumes = new ArrayList<>();

    //metodo GET
    public static ArrayList<Produto> getListaPerfumes() {
        return listaPerfumes;
    }
    
    //Adiciona um objeto na lista
    static public void adicionar(Produto l){
        listaPerfumes.add(l);
    }
    
    //lista os dados de todos os objetos da lista
    static public String listar(){
        String saida = "";
        int i = 1;
        for (Produto l : listaPerfumes) {
            saida += "\n====== PERFUME N° " + (i++) + " =====\n";
            saida += l.imprimir() + "\n";
            }
        return saida;
    }
    
    //pesquisar por aroma
    static public int pesquisar(String aroma){
        int qtd = 0;
        
        for(Produto l : listaPerfumes){
            if(l.getAroma().equalsIgnoreCase(aroma)){
                qtd++;
            }
        }
        
        return qtd;
    }
    
    //pesquisar por faixa de preco
    static public int pesquisar(double vInicial, double vFinal){
        int qtd = 0;
        
        for(Produto l : listaPerfumes){
            if(l.getPreco() >= vInicial && l.getPreco() <= vFinal){
                qtd++;
            }
        }
        
        return qtd;
    }
    
    //remove um livro pelo título
    static public boolean remover(String titulo) {
        for(Produto l : listaPerfumes){
            if(l.getTitulo().equalsIgnoreCase(titulo)){
                listaPerfumes.remove(l);
                return true;
            }
        }
        return false;
    }
    
    //total do Produto
    static double calcularTotalProdutos(){
        double total = 0;
        
        for(Produto l : listaPerfumes){
            total += l.getPreco();
        }
        
        return total;
    }
}
    


