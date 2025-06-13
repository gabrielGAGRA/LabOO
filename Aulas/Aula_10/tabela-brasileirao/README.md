# Exercício: Tabela do Brasileirão

Sua empresa foi contratada para implementar um aplicativo que permite monitorar a tabela de pontuação do Campeonato Brasileiro de Futebol. O sistema deverá ser alimentado com os resultados de cada jogo (o nome de dois times e os gols marcados por cada) por meio de uma interface gráfica. A saída do sistema, ou seja, a Tabela do Brasileirão, deverá ser exibida também por interface gráfica.

No entanto, seu cliente já lhe avisou que diferentes formas de entrada e saída de dados poderão ser úteis no futuro e, portanto, você decidiu implementar o sistema baseado no padrão MVC. Além disso, o cliente lhe entregou o **modelo** de dados que eles já haviam desenvolvido para representar e atualizar os resultados de jogos, em umv versão preliminar do sistema que não possuia interface gráfica. Você se lembrou de um projeto antigo seguindo o padrão MVC cuja interface gráfica era similar (uma tabela de registros de pessoas e uma janela para cadastro de novas pessoas) e, aproveitando a modularidade do paradigma, resolveu reaproveitá-las com as alterações necessárias. 

Falta agora desenvolver a parte principal: adaptar as visões para as especificadas do domínio e implementar os **controladores**.

**Implemente o sistema descrito acima utilizando o padrão MVC e faça alguns testes**. Você pode, mas não precisa, usar as classes de modelo e visão fornecidas.

## Considerações

- O modelo de dados assume que os times são identificados por uma string de 3 letras maiúsculas, por exemplo, SAO representando São Paulo. Você não precisa seguir essa sugestão.
- O modelo de dados conta com uma função populate, que é útil para gerar dados falsos em quantidade e testar o sistema.
- A parte que recebe valores do usuário não faz nenhuma verificação nem tratamento de exceção. Procure melhorar essa interface!
- Existem várias escolhas de projeto de como implementar o padrão MVC. Procure ponderar flexibilidade (a capacidade de estender seu sistema), velocidade (a rapidez com que seu sistema é modificado) e complexidade (a dificuldade em entender a sua implementação).
- O exemplo fornece duas visões distintas: uma modifica o modelo (acrescenta dados) e outra apenas lê do modelo. Como os controladores são distintos uma modificação do modelo não é refletida automaticamente na outra visão. Você pode contornar isso fazendo com que a visão *observe* o modelo e reaja a mudanças de seu estado.

## Versionamento

Lembre-se de manter seu trabalho seguro em um repositório e fazer commits regulares e informativos.