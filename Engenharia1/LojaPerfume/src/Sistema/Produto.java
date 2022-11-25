/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

/**
 *
 * @author Cliente
 */
public class Produto {
    private String titulo;
    private String descricao;
    private String aroma;
    private float preco;
   
    public Produto() { } //default 
    //sobrecarregado
    public Produto(String titulo, String descricao, String aroma, float preco) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.aroma = aroma;
        this.preco = preco;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAroma() {
        return aroma;
    }

    public void setAroma(String aroma) {
        this.aroma = aroma;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    public String imprimir(){
        return "Título: " + titulo + "\nDescricao: " + descricao + 
                "\nAroma: " + aroma + 
                String.format("\nPreço R$ %.2f \n", preco); 
    }
    
}
