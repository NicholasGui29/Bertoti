
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Strategy: Define a interface para as estratégias de processamento de leituras
interface ReadingProcessingStrategy {
    double processReading(double reading);
}

// Strategy: Implementa uma estratégia específica de processamento (média)
class AverageProcessingStrategy implements ReadingProcessingStrategy {
    @Override
    public double processReading(double reading) {
        // Simplesmente retorna a média da leitura
        return reading;
    }
}

// Strategy: Outra estratégia de processamento (duplicar valor)
class DuplicateProcessingStrategy implements ReadingProcessingStrategy {
    @Override
    public double processReading(double reading) {
        // Retorna o dobro da leitura
        return reading * 2;
    }
}

// Observer: Define a interface para os observadores (views)
interface ReadingObserver {
    void update(double reading);
}

// Observer: Implementa um observador específico (console)
class ConsoleReadingObserver implements ReadingObserver {
    @Override
    public void update(double reading) {
        System.out.println("Nova leitura: " + reading);
    }
}

// Composite: Componente abstrato (leitor)
interface ReadingComponent {
    void add(ReadingComponent component);

    void remove(ReadingComponent component);

    void notifyReadings();
}

// Composite: Implementa o componente composto (grupo de leituras)
class ReadingGroup implements ReadingComponent {
    private List<ReadingComponent> components = new ArrayList<>();

    @Override
    public void add(ReadingComponent component) {
        components.add(component);
    }

    @Override
    public void remove(ReadingComponent component) {
        components.remove(component);
    }

    @Override
    public void notifyReadings() {
        for (ReadingComponent component : components) {
            component.notifyReadings();
        }
    }
}

// Composite: Implementa o componente folha (sensor)
class Sensor implements ReadingComponent {
    private List<ReadingObserver> observers = new ArrayList<>();
    private ReadingProcessingStrategy processingStrategy;

    public Sensor(ReadingProcessingStrategy processingStrategy) {
        this.processingStrategy = processingStrategy;
    }

    public void addObserver(ReadingObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ReadingObserver observer) {
        observers.remove(observer);
    }

    private double generateReading() {
        // Simula a geração de uma leitura aleatória
        return new Random().nextDouble() * 100;
    }

    @Override
    public void add(ReadingComponent component) {
        // Não aplicável para folhas (sensores)
    }

    @Override
    public void remove(ReadingComponent component) {
        // Não aplicável para folhas (sensores)
    }

    @Override
    public void notifyReadings() {
        double reading = generateReading();
        double processedReading = processingStrategy.processReading(reading);
        System.out.println("Leitura original: " + reading + ", Leitura processada: " + processedReading);

        for (ReadingObserver observer : observers) {
            observer.update(processedReading);
        }
    }
}

// Facade: Simplifica a interface e coordena as interações entre os subsistemas
class SensorMonitoringFacade {
    private ReadingGroup readingGroup;

    public SensorMonitoringFacade() {
        // Configuração dos sensores com diferentes estratégias de processamento
        Sensor sensor1 = new Sensor(new AverageProcessingStrategy());
        Sensor sensor2 = new Sensor(new DuplicateProcessingStrategy());

        // Configuração dos observadores
        ReadingObserver consoleObserver = new ConsoleReadingObserver();
        sensor1.addObserver(consoleObserver);
        sensor2.addObserver(consoleObserver);

        // Configuração do grupo de leituras
        readingGroup = new ReadingGroup();
        readingGroup.add(sensor1);
        readingGroup.add(sensor2);
    }

    public void monitorReadings() {
        // Simulação de novas leituras
        readingGroup.notifyReadings();
    }
}

// Singleton: Garante que apenas uma instância da classe SensorMonitoringApp seja criada
class SensorMonitoringApp {
    private static SensorMonitoringApp instance;

    private SensorMonitoringApp() {
        // Privatiza o construtor para evitar instâncias adicionais
    }

    public static synchronized SensorMonitoringApp getInstance() {
        if (instance == null) {
            instance = new SensorMonitoringApp();
        }
        return instance;
    }

    public void run() {
        // Utiliza a fachada para monitorar leituras
        SensorMonitoringFacade facade = new SensorMonitoringFacade();
        facade.monitorReadings();
    }
}

// Cliente: Aplicação principal usando o padrão Singleton
public class Main {
    public static void main(String[] args) {
        // Executa o aplicativo usando a instância única do SensorMonitoringApp
        SensorMonitoringApp.getInstance().run();
    }
}




Facade: O padrão Facade (SensorMonitoringFacade) simplifica a interface e coordena as interações entre os subsistemas (Sensor, ReadingObserver, ReadingGroup). Isso proporciona uma interface única e simplificada para o cliente (SensorMonitoringApp), encapsulando a complexidade da interação entre os componentes.

Singleton: O padrão Singleton (SensorMonitoringApp) garante que apenas uma instância da classe seja criada. Isso é útil quando se deseja ter um ponto de controle centralizado, como no caso de uma aplicação principal.