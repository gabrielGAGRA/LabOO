# Primeira Avaliação - MAC0321


## Repositório


Endereço do repositório no Github: https://github.com/gabrielGAGRA/LabOO_Prova


## Instruções iniciais


Crie um repositório privado no Github e adicione @denismaua, @ArthurPilone e
@DaphLie com permissão para visualizar. Copie este arquivo como parte de seu
arquivo README.md, adicionando o endereço do repositório na seção acima.


Se seu repositório tiver visibilidade pública, será considerado plágio e sua nota
será zerada. Se você se esquecer de fornecer permissão para o docente e monitores,
receberá nota zero também.


Você pode acessar a internet para consultar a documentação de classes e bibliotecas
dos Java e fóruns de perguntas e resposta como o StackOverflow. O acesso a sites
que contenham soluções prontas ou muito similares a este exercício será considerado
plágio. O uso de assistentes de código (Copilot, ChatGPT etc) também será
considerado plágio.


## Descrição


Você foi contratado/a para desenvolver um aplicativo de controle de vendas e
estoque de uma biblioteca pública.

O sistema deve gerenciar o cadastro de usuários, cadastro de livros e controle de
empréstimos de livros.


## Cadastro de usuários


O sistema deve permitir cadastrar novos usuários a qualquer momento e sem restrição
no número de usuários. Os usuários devem possuir um número único de identificação
na biblioteca, gerado automaticamente quando o usuário é cadastrado, além de um
registro de identificação pessoal (CPF, RG, RNM, número de passaporte etc). O
sistema também deve armazenar nome, data de nascimento (para emails promocionais) e
endereço de cada usuário. O sistema deve possuir ao menos as funcionalidades de
cadastramento de usuário e busca de usuários pelo início do nome (para usuários que
esqueçam seus identificadores) e pelo número de identificação. Os usuários podem
ficar impedidos de fazer empréstimos dentro de um certo período, como punição por
descumprimento de regras; o sistema deve armazenar tal informação na ficha de cada
usuário.


## Cadastro de livros


O sistema deve permitir cadastrar novos livros. Livros possuem um número único
identificador de cadastro do patrimônio, gerado automaticamente quando o livro é
cadastrado, além de informações de publicação como título, autor, editora, ano de
publicação, ISBN ou ISSN, número de páginas e edição. Note que a biblioteca pode
possuir múltiplas cópias de um mesmo livro; cada cópia deve possuir um
identificador distinto, porém compartilhar as demais informações.

Os livros são classificados em recentes, de coleção ou de consulta. Livros recentes
são novas aquisições que em geral possuem maior procura enquanto livros de coleção
possuem menor demanda. Livros de consulta não podem ser emprestados. Regras
diferentes se aplicam para empréstimos de livros recentes ou de coleção. 


## Empréstimos


Um empréstimo é um associação entre um usuário e um livro (item), com informação
sobre a data de empréstimo, a data de retorno (devida) e a data de devolução
(efetiva).

O sistema deve permitir criar novos empréstimos, renovar empréstimos (o que altera
a data de retorno) e listar empréstimos atrasados.

Também deve ser possível listar todos os empréstimos em aberto de um usuário (ou
seja, empréstimos ainda não devolvidos, atrasados ou não), a partir de seu
identificador.


Um usuário pode tomar no máximo 3 empréstimos simultaneamente. O sistema só deve
permitir um novo empréstimo ou a renovação de um empréstimo se o usuário não
estiver  em período de impedimento e abaixo do limite de empréstimos. Caso o
usuário devolva o livro após a data de retorno, o sistema deve registrar um
impedimento de 3 dias para cada dia atrasado. 

A data de retorno é normalmente calculada como 30 dias a partir da data de
empréstimo para livros recentes e 60 dias para livros de coleção. A biblioteca
permanece fechada entre 24 de dezembro e 2 de janeiro. Caso a data de retorno seja
calculada para esse período ela deve ser estendida para 2 de janeiro.

Cada empréstimo de um livro de coleção pode ser renovado no máximo 2 vezes,
totalizando um período total de empréstimo de 180 dias. O empréstimo de um livro
recente só pode ser renovado uma vez, totalizando 60 dias.


## Interface


Seu sistema deve ter um menu textual para interação com o usuário, projetado para
ser o funcionário da biblioteca (e não os usuários da biblioteca). O sistema deve
ser permitir cadastrar novos usuários da biblioteca, cadastrar novos itens
(livros), cadastrar novos empréstimos, renovar empréstimos, registrar a devolução
de um empréstimo (isto é, seu término), e listar os usuários com empréstimos em
atraso (para que sejam contatados por email), exibindo a quantidade de dias em
atraso e o período de embargo (no qual não podem realizar novos empréstimos). O
sistema deve restringir  operações não permitidas, como emprestar livros a usuários
com pendências ou acima da quantidade máxima permitida. Você pode assumir que os
livros e os usuários são cadastrados toda vez que o programa é executado ou que são
lidos de um arquivo de texto, conforme for mais conveniente.


Crie uma classe executável com exemplos de utilização do seu sistema usando todas
as funcionalidades e envolvendo casos especiais e típicos.


## Recomendações gerais


Você deve escrever um código bem organizado, documentado, modular, flexível e
evitar a repetição de dados e redundância de código. Deve ser possível adicionar e
remover funcionalidades de seu sistema afetando apenas as partes relevantes do seu
código, o que implica não ter regras complexas com seleções condicionais que leve
ao casamento de tipos de dados distintos (como livros recentes e livros de
coleção). Lembre-se de aplicar as boas práticas de POO quanto à divisão de
responsabilidades de classes e métodos, usar nomes claros para classes, atributos e
métodos e manter a implementação de seus métodos curta (em geral, < 15 linhas),
além de outras recomendações típicas.

Uma boa organização de seu código em classes e hierarquias é fundamental.


## Entrega


Além de submeter seu código em seu repositório pessoal privado (commit e push),
você deve submeter sua solução no edisciplinas na forma de um arquivo comprimido
(zip) contendo todo os arquivos necessários para a execução, incluindo a estrutura
de pastas necessária. Plágios de qualquer tipo levarão a anulação do seu exame e
consequente nota zero.