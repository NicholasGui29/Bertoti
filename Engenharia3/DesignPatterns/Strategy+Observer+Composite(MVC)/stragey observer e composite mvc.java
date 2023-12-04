import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Estratégia: Define a interface para as estratégias de processamento de leituras
interface EstrategiaProcessamentoLeitura {
    double processarLeitura(double leitura);
}

// Estratégia: Implementa uma estratégia específica de processamento (média)
class EstrategiaMedia implements EstrategiaProcessamentoLeitura {
    @Override
    public double processarLeitura(double leitura) {
        // Simplesmente retorna a média da leitura
        return leitura;
    }
}

// Estratégia: Outra estratégia de processamento (duplicar valor)
class EstrategiaDuplicar implements EstrategiaProcessamentoLeitura {
    @Override
    public double processarLeitura(double leitura) {
        // Retorna o dobro da leitura
        return leitura * 2;
    }
}

// Observador: Define a interface para os observadores (views)
interface ObservadorLeitura {
    void atualizar(double leitura);
}

// Observador: Implementa um observador específico (console)
class ObservadorConsole implements ObservadorLeitura {
    @Override
    public void atualizar(double leitura) {
        System.out.println("Nova leitura: " + leitura);
    }
}

// Componente: Componente abstrato (leitor)
interface LeituraComponente {
    void adicionar(LeituraComponente componente);

    void remover(LeituraComponente componente);

    void notificarLeituras();
}

// Componente: Implementa o componente composto (grupo de leituras)
class GrupoLeituras implements LeituraComponente {
    private List<LeituraComponente> componentes = new ArrayList<>();

    @Override
    public void adicionar(LeituraComponente componente) {
        componentes.add(componente);
    }

    @Override
    public void remover(LeituraComponente componente) {
        componentes.remove(componente);
    }

    @Override
    public void notificarLeituras() {
        for (LeituraComponente componente : componentes) {
            componente.notificarLeituras();
        }
    }
}

// Componente: Implementa o componente folha (sensor)
class Sensor implements LeituraComponente {
    private List<ObservadorLeitura> observadores = new ArrayList<>();
    private EstrategiaProcessamentoLeitura estrategiaProcessamento;

    public Sensor(EstrategiaProcessamentoLeitura estrategiaProcessamento) {
        this.estrategiaProcessamento = estrategiaProcessamento;
    }

    public void adicionarObservador(ObservadorLeitura observador) {
        observadores.add(observador);
    }

    public void removerObservador(ObservadorLeitura observador) {
        observadores.remove(observador);
    }

    private double gerarLeitura() {
        // Simula a geração de uma leitura aleatória
        return new Random().nextDouble() * 100;
    }

    @Override
    public void adicionar(LeituraComponente componente) {
        // Não aplicável para folhas (sensores)
    }

    @Override
    public void remover(LeituraComponente componente) {
        // Não aplicável para folhas (sensores)
    }

    @Override
    public void notificarLeituras() {
        double leitura = gerarLeitura();
        double leituraProcessada = estrategiaProcessamento.processarLeitura(leitura);
        System.out.println("Leitura original: " + leitura + ", Leitura processada: " + leituraProcessada);

        for (ObservadorLeitura observador : observadores) {
            observador.atualizar(leituraProcessada);
        }
    }
}

// Cliente: Aplicação principal usando o padrão MVC
public class AplicacaoMonitoramentoSensores {
    public static void principal(String[] args) {
        // Configuração dos sensores com diferentes estratégias de processamento
        Sensor sensor1 = new Sensor(new EstrategiaMedia());
        Sensor sensor2 = new Sensor(new EstrategiaDuplicar());

        // Configuração dos observadores
        ObservadorLeitura observadorConsole = new ObservadorConsole();
        sensor1.adicionarObservador(observadorConsole);
        sensor2.adicionarObservador(observadorConsole);

        // Configuração do grupo de leituras
        GrupoLeituras grupoLeituras = new GrupoLeituras();
        grupoLeituras.adicionar(sensor1);
        grupoLeituras.adicionar(sensor2);

        // Simulação de novas leituras
        grupoLeituras.notificarLeituras();
    }
}
