## Segunda Prova - MAC0321

Você foi contratado/a para desenvolver um aplicativo que permite que pessoas ofereçam ou peguem caronas entre cidades, dividindo o custo da viagem. O aplicativo deve gerenciar o cadastro de usuários e viagens, fazer o casamento entre caronas sendo ofertadas e procuradas e calcular as cobranças devidas para cada passageiro.

Em particular, o sistema deve permitir a seguinte interação:

- Um usuário (que chamamos de motorista) anuncia uma carona informando a cidade de partida, a cidade de destino, a quantidade de assentos disponíveis e um valor a ser cobrado para cada passageiro.
- Outros usuários procuram por caronas, informando as cidades de destino e partida.
- O sistema exibe as viagens sendo oferecidas naquele percurso de acordo com o critério decidido pelo usuário.
- Ao iniciar a viagem o motorista altera o estado da viagem para "em andamento", o que bloqueia que novos usuários se cadastrem naquela viagem.
- Ao término da viagem, o motorista altera o estado da viagem para concluída, gerando a cobrança devida de cada passageiro.

Note que um mesmo usuário pode oferecer (ou seja, ser um motorista) ou requisitar caronas (ou seja, ser um passageiro). 

Cada viagem está sempre em um dos seguintes estados:

- Aceitando passageiros: para viagens ainda não iniciadas e com vagas disponíveis.
- Lotada: para viagens ainda não iniciadas mas sem vagas disponíveis.
- Em andamento: para viagens já iniciadas mas ainda não concluídas.
- Concluída: para viagens já realizadas.
- Cancelada: para viagens canceladas pelo motorista.

Seu sistema deve também permitir as seguintes funcionalidades:

- O motorista pode cancelar a viagem antes de seu início; viagens canceladas não recebem passageiros, não podem ser iniciadas ou concluídas e não geram cobranças.
- Os passageiros podem cancelar seu pedido antes do início da viagem, o que não cancela a viagem (apenas remove o passageiro) e não gera cobrança para o passageiro.
- Viagens em andamento não aceitam novos passageiros nem pedidos de cancelamento.
- Apenas viagens em andamento podem ser concluídas.
- Deve ser possível gerar um relatório para cada viagem exibindo o motorista, os passageiros, o estado atual e o valor cobrado (se concluída).
- Devem também ser possível gerar relatórios de quantidade de usuários do sistema, quantidade de viagens concluídas e a quantia total movimentada e por viagem.
- Os usuários devem definir uma estratégia de seleção de escolha de viagens, que decide, dada uma lista de viagens com mesmo destino e origem, qual viagem escolher. Deve ser possível alterar essa estratégia em tempo de execução, assim como permitir que estratégias sejam facilmente adicionadas e removidas do sistema.

Observações:

- A viagem só pode ser cancelada antes de ser iniciada.
- Use o Padrão Estado para implementar os comportamentos associados à viagem dependentes do estado (recebendo passageiros, lotação de passeiros, em percurso, concluída, cancelado).
- Use o Padrão Estratégia para implementar a seleção de viagem para um usuário a partir de uma lista ou vetor de viagens com destino e origem desejados. 
- Use o Padrão Singleton para implementar o sistema de gerenciamento de viagens e clientes.

Observação: lembre-se de seguir as boas práticas de programação orientada a objetos (encapsulamento, código limpo, claro e bem organizado) e de evitar métodos longos (p.ex., > 15 linhas) e seguir o princípio de responsabilidade única para classes e métodos.


Submeta sua solução aqui no ediscplinas na forma de um arquivo .zip