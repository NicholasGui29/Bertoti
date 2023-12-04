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

// Cliente: Aplicação principal usando o padrão MVC
public class SensorMonitoringApp {
    public static void main(String[] args) {
        // Configuração dos sensores com diferentes estratégias de processamento
        Sensor sensor1 = new Sensor(new AverageProcessingStrategy());
        Sensor sensor2 = new Sensor(new DuplicateProcessingStrategy());

        // Configuração dos observadores
        ReadingObserver consoleObserver = new ConsoleReadingObserver();
        sensor1.addObserver(consoleObserver);
        sensor2.addObserver(consoleObserver);

        // Configuração do grupo de leituras
        ReadingGroup readingGroup = new ReadingGroup();
        readingGroup.add(sensor1);
        readingGroup.add(sensor2);

        // Simulação de novas leituras
        readingGroup.notifyReadings();
    }
}
