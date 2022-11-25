/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Sistema;


import java.util.Scanner;
        
/**
 *
 * @author Cliente
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 1) Informe o seu login
        System.out.println("Login: ");
        String login = in.nextLine();
        // 2) Informe a sua senha
        System.out.println("Senha: ");
        String senha = in.nextLine();
        // 3) Armazenar em variaveis o login e a senha
        // 4) Verificar se o login e a senha estão corretos
        // Estamos comparando uma instância(objeto) com uma string
        if(login.equals("nicholas") && senha.equals("admin")){
            System.out.printf("Usuário %s logado com sucesso. \n", login);
            Scanner entrada = new Scanner(System.in);
            Scanner entradaString = new Scanner(System.in);

            int menu;
            double vInicial, vFinal;
            //referencia para a classe Produto
            Produto objProduto;

            String titulo, descricao, aroma;
            float preco;

            do{
                exibirMenu();
                menu = entrada.nextInt();

                switch(menu){
                    case 1: //cadastro do perfume
                        System.out.println("Digite o título: ");
                        titulo = entradaString.nextLine();
                        System.out.println("Digite o descricao: ");
                        descricao = entradaString.nextLine();
                        System.out.println("Digite o aroma: ");
                        aroma = entradaString.nextLine();
                        System.out.println("Digite o preço: ");
                        preco = entrada.nextFloat();

                        //criar objeto da classe
                        objProduto = new Produto(titulo, descricao, aroma, preco);

                        //guardar no ArrayList
                        Loja.adicionar(objProduto);
                        break;
                        
                    case 2:
                        System.out.println("===> Listagem de Produtos");
                        System.out.println( Loja.listar() );
                        break;
                        
                    case 3:
                        System.out.println("===> Exclusão do Produto");
                        System.out.println("Digite o título do perfume");
                        titulo = entradaString.nextLine();

                        if( ! (Loja.getListaPerfumes().isEmpty())){//produto não vazio
                            if( Loja.remover(titulo) ){
                                System.out.println("Produto removido com sucesso!!");
                            }else{
                                 System.out.println("Título não encontrado!!");
                            }
                        }else{
                             System.out.println("Não existem perfume no carrinho!!");
                        }
                        break;
                        
                    case 4:
                        System.out.println("===> Pesquisar pelo aroma");
                        System.out.println("Digite o aroma: ");
                        aroma = entradaString.nextLine();
                        System.out.println("Existem " + Loja.pesquisar(aroma) + " perfume(s) do aroma: ");         
                        break;
                        
                    case 5:
                        System.out.println("===> Pesquisar por faixa de preço");
                        System.out.println("Digie a faixa inicial e a final: ");
                        vInicial = entrada.nextDouble();
                        vFinal = entrada.nextDouble();

                        System.out.println("Existem " + Loja.pesquisar(vInicial, vFinal) + 
                                " perfume(s) com preço entre " + String.format("R$ %.2f \n", vInicial, vFinal));
                        break;
                        
                    case 6:
                        System.out.println("===> Total em R$ de perfumes no Carrinho");
                        System.out.println("O total é: " + String.format(" R$ %.2f \n", Loja.calcularTotalProdutos()));
                        break;
                        
                    case 7:
                        System.out.println("Saindo....");
                        break;

                    default:
                        System.out.println("Opção de menu inválida!!!");
                }
            }while(menu != 7);

        //fim main

        }else{
            System.out.println("Login ou senha inválidos!");
        }
    }
    
    static void exibirMenu(){
        System.out.println("========== Loja de Perfume ==========");
        System.out.println("1 - CADASTRAR");
        System.out.println("2 - LISTAR");
        System.out.println("3 - EXCLUIR PERFUME");
        System.out.println("4 - PESQUISAR POR AROMA");
        System.out.println("5 - PESQUISAR POR FAIXA DE PREÇO");
        System.out.println("6 - CALCULAR TOTAL DO CARRINHO");
        System.out.println("7 - SAIR");
        System.out.println("====> Escolha uma opção: ");
    }
    
}
