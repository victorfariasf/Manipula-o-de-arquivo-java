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