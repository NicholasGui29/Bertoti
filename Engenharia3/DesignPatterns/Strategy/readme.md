Strategy

Diagrama:

<img src=diagramaStrategy.png>


Código:
package strategypattern;

public class Pessoa {

    private Inscricao inscricao;
    private String nomePessoa;

    public void setInscricao(Inscricao inscricao) {
        this.inscricao = inscricao;
    }

    public void realizarInscricao() {
        this.inscricao.inscrever();
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }
}

public interface Inscricao {
    void inscrever();
}

public class InscricaoAluno implements Inscricao {
    public void inscrever() {
        System.out.println("Inscrição Aluno...");
    }
}

public class InscricaoProfessor implements Inscricao {
    public void inscrever() {
        System.out.println("Inscrição Professor...");
    }
}

public class Teste {
    public static void main(String[] args) {
        Pessoa nicholas = new Pessoa();
        nicholas.setInscricao(new InscricaoAluno());
        nicholas.realizarInscricao();

        System.out.println("--------------------------------");

        nicholas.setInscricao(new InscricaoProfessor());
        nicholas.realizarInscricao();
    }
}

public class Sala {
    private String nomeCadeira;

    public void setCadeira(String cadeira) {
        this.nomeCadeira = cadeira;
    }

    public void ocuparCadeira() {
        System.out.println("Cadeira ocupada: " + nomeCadeira);
    }
}

public class Armario {
    private String nomeArmario;

    public void setArmario(String armario) {
        this.nomeArmario = armario;
    }

    public void ocuparArmario() {
        System.out.println("Armário ocupado: " + nomeArmario);
    }
}

public class Livro {
    private String nomeLivro;

    public void setLivro(String livro) {
        this.nomeLivro = livro;
    }

    public void ocuparLivro() {
        System.out.println("Livro ocupado: " + nomeLivro);
    }
}
