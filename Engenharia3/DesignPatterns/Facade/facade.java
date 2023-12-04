// Entidade Empresa
class Empresa {
    private String nomeEmpresa;

    public Empresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public void contratarFuncionario(Funcionario funcionario, Setor setor) {
        System.out.println("A empresa " + nomeEmpresa + " contratou o funcionário " + funcionario.getNomeFuncionario() +
                " para o setor " + setor.getNomeSetor());
        setor.adicionarFuncionario(funcionario);
    }
}

// Entidade Funcionario
class Funcionario {
    private String nomeFuncionario;

    public Funcionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void categorizarContratoPorSetor(Setor setor) {
        System.out.println("O funcionário " + nomeFuncionario + " foi categorizado para o setor " + setor.getNomeSetor());
    }
}

// Entidade Setor
class Setor {
    private String nomeSetor;
    private String categoriaSetor;

    public Setor(String nomeSetor, String categoriaSetor) {
        this.nomeSetor = nomeSetor;
        this.categoriaSetor = categoriaSetor;
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public String getCategoriaSetor() {
        return categoriaSetor;
    }

    public void comunicarSetorExterno(String nomeSetor, String categoriaSetor) {
        System.out.println("Setor " + nomeSetor + " da categoria " + categoriaSetor + " comunicando-se com setores externos");
    }

    public void resolverProblema(String nomeProblema, String nivelPrioridade) {
        System.out.println("Setor " + nomeSetor + " está resolvendo o problema: " + nomeProblema +
                " com prioridade " + nivelPrioridade);
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        System.out.println("Funcionário " + funcionario.getNomeFuncionario() + " adicionado ao setor " + nomeSetor);
    }
}

// Cliente
public class Main {
    public static void main(String[] args) {
        // Criando a fachada e as entidades
        FacadeEmpresa fachada = new FacadeEmpresa();
        Empresa minhaEmpresa = new Empresa("Minha Empresa");

        // Contratando funcionários para diferentes setores
        Funcionario funcionarioTI = new Funcionario("João");
        Funcionario funcionarioMarketing = new Funcionario("Maria");
        Funcionario funcionarioRH = new Funcionario("Carlos");

        Setor setorTI = new Setor("TI", "Tecnologia");
        Setor setorMarketing = new Setor("Marketing", "Publicidade");
        Setor setorRH = new Setor("RH", "Recursos Humanos");

        minhaEmpresa.contratarFuncionario(funcionarioTI, setorTI);
        minhaEmpresa.contratarFuncionario(funcionarioMarketing, setorMarketing);
        minhaEmpresa.contratarFuncionario(funcionarioRH, setorRH);

        // Realizando operações nos setores
        setorTI.comunicarSetorExterno(setorTI.getNomeSetor(), setorTI.getCategoriaSetor());
        setorMarketing.resolverProblema("Falta de visibilidade da marca", "Alta");
    }
}
