<h1>Design Pattern:</h1>

Os padrões de design são usados para representar algumas das melhores práticas adaptadas por desenvolvedores de software orientados a objetos experientes. Um padrão de design sistematicamente nomeia, motiva e explica um design geral que aborda um problema de design recorrente em sistemas orientados a objetos. Descreve o problema, a solução, quando aplicar a solução e suas consequências. Ele também dá dicas de implementação e exemplos.

Os padrões são baseado no site do Guru Manufacturing e em baixo, temos a tabela de comparação e reposótorio de cada padrão, onde encontra-se os diagramas e o código JAVA.
<table>
	<thead style="background-color: blue"> <!--não está funcionando -->
	<tr>
		<th>Nome do Padrão</th>
		<th>Anti-Padrão</th>
		<th>Definição do Padrão</th>
		<th>Problema que ele resolve</th>
		<th>Exemplos de onde aplicar</th>
	</tr>	</thead>	<tbody>	<tr>
		<td>Strategy</td>
		<td>Repetição de códigos - "Bad smells"</td>
		<td>É um padrão de design comportamental que permite definir uma família de algoritmos, colocar cada um deles em uma classe separada e tornar seus objetos intercambiáveis.</td>
		<td>O principal problema que ele resolve é o Poliformismo.</td>
		<td>Quando queremos aplicar uma classe que herda.</td>
	</tr>
	<tr>
		<td>Observer</td>
		<td>Alto Acoplamento - Programar para classes concretas.</td>
		<td>É um padrão de design comportamental que permite definir um mecanismo de assinatura para notificar vários objetos sobre quaisquer eventos que aconteçam com o objeto que eles estão observando.</td></td>
		<td>Traz o baixo acoplamento, que é  quando tem pouco ou nada de dependência em relação aos outros componentes do sistema</td>
		<td>Ajuda a implementar outros métodos diferentes(?)</td>
	</tr>
	<tr>
		<td>Composite</td>
		<td>Explosão da complexidade - "Complexidade Explosiva."</td>
		<td>É um padrão de projeto estrutural que permite que você componha objetos em estruturas de árvores e então trabalhe com essas estruturas como se elas fossem objetos individuais.</td>
		<td>O Composite resolve o problema de ter que tratar objetos individuais e composições de objetos de maneira uniforme. Evita a complexidade ao permitir que clientes tratem objetos individuais e composições de objetos de maneira uniforme.</td>
		<td>Em um sistema gráfico, onde você tem formas simples (círculos, quadrados) e grupos que consistem em outras formas, ou em Estrutura de diretórios no sistema operacional, onde uma pasta pode conter arquivos e outras pastas.</td>
	</tr>
	<tr>
		<td>Facade</td>
		<td>Interfaces complexas e difíceis de usar - "Interface Gigante."</td>
		<td>É um padrão de projeto estrutural que fornece uma interface simplificada para uma biblioteca, um framework, ou qualquer conjunto complexo de classes.</td>
		<td>O Facade resolve o problema de uma interface complexa, fornecendo uma interface simplificada para um conjunto de classes ou subsistemas. Isso oculta a complexidade e facilita o uso para os clientes.</td>
		<td>Em um sistema de entrega online, onde a fachada pode fornecer métodos simples para realizar tarefas complexas, como fazer um pedido, rastrear um pacote, etc.</td>
	</tr>
	<tr>
		<td>Singleton</td>
		<td>Acoplamento Global - "Instância Global."</td>
		<td>É um padrão de projeto criacional que permite a você garantir que uma classe tenha apenas uma instância, enquanto provê um ponto de acesso global para essa instância.</td>
		<td> O Singleton resolve o problema de garantir que uma classe tenha apenas uma instância, evitando o acoplamento global. Ele fornece um ponto de acesso global para essa instância, mas isso pode levar a um acoplamento indesejado.</td>
		<td>Um gerenciador de log único para toda a aplicação, onde o Singleton garante que todas as partes do sistema usem o mesmo log.</td>
	</tr>
	</tbody>
</table>
