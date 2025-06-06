Você foi contratado por uma empresa de jogos para desenvolver o melhor jogo de Pac-Mac da história do videogame! Inicialmente, para ter uma ideia inicial de como seria a arquitetura de software desse jogo, seu chefe pediu para você criar um diagrama de classes UML representando os principais elementos do jogo.

Para tornar o jogo mais interessante, você deverá:
1) Usar o padrão Estratégia (Strategy) para implementar diferentes comportamentos para os fantasmas. Por exemplo, fantasmas vermelhos perseguem o Pac-Man, fantasmas rosas tentam se posicionar na frente da boca do Pac-Man, fantasmas laranjas são completamente aleatórios, fantasmas brancos fogem do Pac-Man e assim por diante.
2) Usar o padrão Fábrica Abstrata para oferecer diferentes aparências ("look-and-feels"). Assim, facilmente, o jogador poderá escolher se o espaço do jogo terá uma aparência de supermercado em tempos de covid, velho oeste, espaço sideral ou os corredores de uma empresa, por exemplo. Quando o usuário selecionar uma nova aparência, todos os elementos gráficos do jogo devem se redesenhar imediatamente.

Note que, neste exercício, você não precisa implementar nenhuma linha de código. Você deverá apenas criar um diagrama de classes UML representando as principais abstrações da sua arquitetura de software, por exemplo, as principais classes que você utilizaria para, num outro momento, implementar tal jogo.
Sugerimos que antes de fazer este exercício que você assista novamente aos vídeos de UML, do padrão Estratégia e do padrão Fábrica Abstrata.

Dica
Pense nas principais abstrações que você precisará representar: Tabuleiro, PacMan, Fantasma, tipos específicos de fantasma, pontos, placar, entrada dos movimentos do jogador via teclado ou joystick, etc. Verifique se você está usando herança e agregação apropriadamente e se as associações entre os objetos estão adequadas.

Criterios de avaliacao (para avaliar colegas, e auto-avaliacao):
1) Avalie se as abstrações mostradas pelo diagrama de classes são realmente as mais importantes. Alguma das classes mostradas são pouco relevantes? As classes mais importantes para essa arquitetura estão presentes?

2) Avalie se os relacionamentos entre as classes está adequado. As relações de herança, agregação e 
demais associações estão corretas? Faltou algum relacionamento importante?

3) O padrão Estratégia foi usado corretamente para representar diferentes comportamentos para os fantasmas?

4) O padrão Fábrica Abstrata foi usado corretamente para oferecer diferentes aparências (look-and-feels)?