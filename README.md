# manipulacao-arquivo-java

Tal repositório é dedicado para a segunda nota de NPC pela disciplina de Programação Orientada a Objetos (POO)
pela Universidade Estadual do Ceará (UECE).

## Descrição

Considere um arquivo texto onde cada linha representa as respostas de uma prova
objetiva de um aluno. Essa prova contém 10 questões, todas do tipo V ou F. O final de
cada linha contém o nome do aluno que respondeu aquelas opções separadas das
respostas por um “tab”. A Figura abaixo mostra um exemplo desse arquivo:

    VFFFVVVFVF BELTRANO DA SILVA
    FFVFFFVVVF FULANO DOS ANZÓIS PEREIRA
    VVFFFVFFVV CICRANO JOSÉ

Crie um programa que faça os seguintes itens:

1. Permita ao usuário criar o arquivo com as respostas de todos os alunos de uma
disciplina. O nome do arquivo será o nome da disciplina. O usuário é livre para inserir
quantos alunos ele queira. O usuário pode criar mais de uma disciplina.

2. Permita ao usuário gerar o resultado de uma disciplina. Seu programa deve permitir
ao usuário escolher a disciplina e então informar a localização do arquivo contendo o
gabarito oficial da prova (apenas uma linha com as 10 respostas corretas) da disciplina
escolhida. Em seguida, deve produzir como resposta dois outros arquivos: um contendo
a lista dos alunos e seus respectivos pontos (número de acertos) ordenadas por ordem
alfabética, e outro contendo as mesmas informações, porém ordenado por ordem
decrescente de notas (quantidade de acertos) e mostrando ao final a média da turma.
Caso o aluno tenha marcado todas as questões com V ou F, o aluno receberá 0. Permita
ao usuário visualizar esses dados na tela.

Fique livre para organizar seus arquivos em diretórios da melhor maneira possível.

## TO-DO

- Realizar pesquisa relacionada ao padrão Façade
- Implementar menu personalizado em classe main
- Implementar media geral em cada disciplina.

## Boas práticas de projeto (equipe)

- Manter repositório sempre atualizado com um **git fetch** ou **git pull** pela última branch atualizada.
- Trabalhar sempre em uma branch separada para cada funcionalidade do projeto.
- Sempre que necessário, realizar uma discussão para saber oque manter ou não no projeto, evitando **conflitos de merge**.

## Documentação 

Classes: Main, Fachada, Aluno
Classe Main: acontece o menu
Classe Fachada: responsável por lidar com abertura e escrita de arquivos, por lidar com a classe Aluno e por fazer verificações de existência de arquivo.
Classe Aluno: possui os seguintes atributos: String nome, String sequenciaAcertos, String gabarito, int nota;
Possui um construtor que recebe como parâmetro nome, sequenciaAcertos e gabarito e inicializa os atributos do objeto.
int nota é inicializado com um 0 de forma padrão;
Possui um método para calcular a nota que faz o seguinte: verifica se a sequenciaAcertos é composta apenas por V ou F, caso seja o aluno recebe 0, como regra e caso não seja é feito um for que começa em 0 e vai até a sequenciaAcertos.length(). Dentro deste for é feita uma verificação, caso a sequenciaAcertos.charAt(i) for igual ao gabaritoOficial.charAt(i) então o a nota do aluno é incrementa com mais 1.

Como dito antes a main é como se fosse o menu é onde o código roda. O usuário deve inserir a disciplina que ele deseja abrir. É feita é uma verificação no método enconrarArquivo(String nomeDoArquivo) que retorna true se o arquivo existir e false se não. A verificação é feita com a classe File que possui a função .exists(). Caso exista a fachada chama  a função lerArquivo que 1° mostra o gabarito oficial da disciplina 2° verifica se os arquivos dos alunos(por ordem alfabética e ordem de notas decrescente) existe. 2.1°Caso exista os aquivos, junto com uma função auxiliar leituraDosAlunos(String nomeDoArquivo), vai mostrar os alunos por ordem de notas decrescente e por ordem alfabética 2.2°Caso não exista os arquivos, então o programa irá criá-los. O gabarito ser lido novamente e será guardado na String gabaritoOficial, depois o arquivo com os alunos(formato original) será lido, mas durante a leitura também será feito o instanciamento dos objetos Aluno e serão colocados em uma List<Aluno> alunos. Após a leitura dos alunos e do preenchimento da List alunos for completada o seguinte irá acontecer: 1° Os alunos serão mostrados na tela por meio do foreach Aluno x : alunos e durante esse for também feita a chamada do método calcular nota para que os alunos tenham suas notas inicializadas. 2° depois é feito um alunos.sort(), aonde eu decidi por usar lambda para facilitar no processo de comparação e ordenação. Então ficou, alunos.sort((x,y) -> x.getNome().compareTo(y.getNome())), nesse momento a minha lista ficou ordenada de forma alfabética. 3° depois eu faço um foreach que percorre essa lista e durante esse for eu chamo a outra função auxiliar escreverNoArquivo(String nomeDoArquivo, String texto), essa função fica responsável por criar um arquivo caso ele não exista e caso exista o arquivo, apenas reescrever. Eu passo para esse método os argumentos: nomeDoArquivo+"ALFABETICA", x.toString(), toString foi uma função feita apenas para mostrar na tela a forma do objeto com nome, respostas e nota. 4° depois eu faço o mesmo processo só que para a ordem de notas decrescente. faço o sort de alunos novamente usando lambda mas dessa fica assim: alunos.sort((x, y) -> Integer.compare(y.getNota(), x.getNota())) eu tive que usar Interger pois era como o labda ia aceitar devido ao fato de ser int e tive que inverter a ordem para que não ficasse em ordem crescente que era o que eu não queria. Depois disso eu repito o processo de fazer um for e criar ou escrever no final do arquivo os dados dos alunos em ordem de notas decrescente. 5° por fim eu chamo novamente a função leituraDosAlunos para que esses arquivos sejam mostrado para o usuário.

*Documentação da Classe Fachada

Descrição Geral:
A classe Fachada gerencia a interação com arquivos relacionados a disciplinas, incluindo a criação e leitura de arquivos de gabarito e de respostas dos alunos. Ela também calcula a média geral das notas dos alunos e organiza a saída em arquivos com diferentes ordenações.

Métodos da Classe:

    criarArquivo(String nomeDoArquivo)
        Descrição: Cria dois arquivos:
            Um arquivo de gabarito oficial com as respostas corretas.
            Um arquivo contendo as respostas dos alunos, permitindo a inserção de múltiplos alunos até que o usuário escolha encerrar.
        Parâmetros:
            nomeDoArquivo: Nome base para os arquivos a serem criados.
        Exceções: IOException se ocorrer um erro de entrada/saída durante a criação ou escrita dos arquivos.

    lerArquivo(String nomeDoArquivo)
        Descrição: Lê e processa arquivos relacionados à disciplina:
            Exibe o gabarito oficial.
            Verifica se os arquivos de alunos por ordem de notas decrescentes e alfabética existem.
            Se os arquivos não existirem, cria-os e os preenche com as informações dos alunos, ordenando-os por nome e por nota.
            Adiciona a média geral das notas ao final dos arquivos correspondentes.
        Parâmetros:
            nomeDoArquivo: Nome base para os arquivos de entrada e saída.
        Exceções: IOException se ocorrer um erro de entrada/saída durante a leitura ou escrita dos arquivos.

    encontrarArquivo(String nomeDoArquivo)
        Descrição: Verifica a existência de um arquivo com o nome especificado.
        Parâmetros:
            nomeDoArquivo: Nome base do arquivo a ser verificado.
        Retorno: true se o arquivo existir, false caso contrário.

    leituraDosAlunos(String nomeDoArquivo)
        Descrição: Lê e exibe o conteúdo do arquivo de alunos especificado.
        Parâmetros:
            nomeDoArquivo: Nome base do arquivo de alunos a ser lido.
        Exceções: IOException se ocorrer um erro de entrada/saída durante a leitura do arquivo.

    escreverNoArquivo(String nomeDoArquivo, String texto)
        Descrição: Adiciona uma nova linha com o texto especificado ao final do arquivo.
        Parâmetros:
            nomeDoArquivo: Nome base do arquivo onde o texto será escrito.
            texto: Texto a ser adicionado ao final do arquivo.
        Exceções: IOException se ocorrer um erro de entrada/saída durante a escrita no arquivo.

    calcularMediaGeral(String nomeDoArquivo)
        Descrição: Calcula a média geral das notas dos alunos a partir do arquivo especificado.
        Parâmetros:
            nomeDoArquivo: Nome base do arquivo contendo as notas dos alunos.
        Retorno: Média das notas dos alunos.
        Exceções: FileNotFoundException e IOException se ocorrerem erros ao acessar ou ler o arquivo.
--------------------------------------------------------------------------------------------------
Documentação da Classe App

Descrição Geral:
A classe App contém o método principal (main) que executa a aplicação de gerenciamento de alunos e notas. Ela interage com o usuário para criar e ler arquivos relacionados a disciplinas, usando a classe Fachada para gerenciar as operações de arquivo.

Métodos da Classe:

    main(String[] args)
        Descrição: Método principal da aplicação que executa o fluxo principal do programa:
            Solicita o nome da disciplina ao usuário.
            Verifica se o arquivo da disciplina já existe.
            Oferece a opção de criar um novo arquivo ou encerrar o programa se o arquivo não existir.
            Se o arquivo existir, chama o método lerArquivo da classe Fachada para processar o arquivo.
            Pergunta ao usuário se deseja encerrar o programa.
        Parâmetros:
            args: Argumentos de linha de comando (não utilizados).
        Exceções: Exception se ocorrer algum erro durante a execução.

    inputValido(String input)
        Descrição: Verifica se a entrada do usuário é válida (S/N para Sim/Não).
        Parâmetros:
            input: Entrada do usuário a ser verificada.
        Retorno: true se a entrada for válida (S ou N), false caso contrário.
        Observações: O método contém um erro lógico na condição de comparação. A correção seria usar !input.equals("S") && !input.equals("s") && !input.equals("N") && !input.equals("n").
--------------------------------------------------------------------------------------------------
Documentação da Classe Aluno

Descrição Geral:
A classe Aluno representa um aluno com um nome, respostas a um teste e o gabarito oficial. Ela calcula a nota do aluno com base nas respostas e no gabarito e fornece métodos para acessar e modificar suas propriedades.

Métodos da Classe:

    Aluno(String nome, String respostas, String gabarito)
        Descrição: Construtor da classe Aluno, inicializa o nome, as respostas e o gabarito. A nota é inicializada como 0.
        Parâmetros:
            nome: Nome do aluno.
            respostas: Respostas do aluno para o teste.
            gabarito: Gabarito oficial do teste.

    calcularNota()
        Descrição: Calcula a nota do aluno com base na comparação entre as respostas do aluno e o gabarito. Se todas as respostas forem corretas ou incorretas, a nota é ajustada para 0. Caso contrário, incrementa a nota para cada resposta correta.
        Parâmetros: Nenhum.
        Observações: O método considera que respostas inteiramente corretas ou incorretas (todas V ou todas F) devem receber nota 0. Esse comportamento pode precisar de ajuste dependendo dos requisitos.

    toString()
        Descrição: Retorna uma representação em string das informações do aluno: nome, respostas e nota.
        Parâmetros: Nenhum.
        Retorno: String formatada contendo o nome, as respostas e a nota do aluno.

    getNome()
        Descrição: Retorna o nome do aluno.
        Parâmetros: Nenhum.
        Retorno: Nome do aluno.

    setNome(String nome)
        Descrição: Define o nome do aluno.
        Parâmetros:
            nome: Novo nome do aluno.

    getRespostas()
        Descrição: Retorna as respostas do aluno.
        Parâmetros: Nenhum.
        Retorno: Respostas do aluno.

    setRespostas(String respostas)
        Descrição: Define as respostas do aluno.
        Parâmetros:
            respostas: Novas respostas do aluno.

    getNota()
        Descrição: Retorna a nota do aluno.
        Parâmetros: Nenhum.
        Retorno: Nota do aluno.

    setNota(int nota)
        Descrição: Define a nota do aluno.
        Parâmetros:
            nota: Nova nota do aluno.

    incrementarNota()
        Descrição: Incrementa a nota do aluno em 1 ponto.
        Parâmetros: Nenhum.