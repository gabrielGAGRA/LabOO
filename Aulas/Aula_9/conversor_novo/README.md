1. Refatore o código disponibilizado de um aplicativo de conversão de temperaturas para que ele isole o cliente AppConversor da instanciação de objetos do tipo Conversor. 

2. Use uma fábrica (ou fábrica abstrata) para criar os 3 diferentes conversores de temperatura (De/Para Celsius para Fahrenheit e sem conversão). 
    - Note que o conversor concreto é o produto e não temos ainda um método de fábrica ou classe de criador. 
    - Use o padrão Singleton para evitar duplicar objetos (conversores, fábricas etc).

3. Depois estenda seu código para permitir também conversões de e para Kelvin, totalizando 7 diferentes conversores. 
    - Use o padrão Protótipo para evitar if/elses de criações de objetos.

4. Por fim, modifique seu código para ter também uma fábrica de conversores de medidas de distância (km para milhas e vice-versa, por exemplo).