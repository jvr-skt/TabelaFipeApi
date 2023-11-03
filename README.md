# TabelaFipeApi
## API desenvolvida durante desafio de conclusão de curso da Alura
Curso: [Java: trabalhando com lambdas, streams e Spring Framework](https://cursos.alura.com.br/course/java-trabalhando-lambdas-streams-spring-framework)


O curso tem como objetivo exercitar o Trabalho com listas, coleções, funções lambdas, streams, projetos envolvendo frameworks e gerenciadores de dependências 
que são tarefas do dia a dia de uma pessoa desenvolvedora.
Ao finalizar o curso, foi proposto um desafio para consolidar o conhecimento adquirido durante os estudos.

### O objetivo do projeto porposto pelo curso é consuir uma API que simula uma consulta ao site [FIPE](https://veiculos.fipe.org.br/) Fundação Instituto de Pesquisas Econômicas
### Documentação da API neste [link](https://deividfortuna.github.io/fipe/)

Devemos criar uma API com um fluxo similar ao que é feito no site, porém com algumas melhorias.
* Criar um projeto Spring com linha de comando, utilizando a classe Scanner para fazer interações com o usuário via terminal.
* Solicitaremos que o usuário digite o tipo de veículo desejado (carro, caminhão ou moto).
* Feito isso, listaremos todas as marcas daquele tipo de veículo, solicitando que o usuário escolha uma marca pelo código.
* Após essa escolha, listaremos todos os modelos de veículos daquela marca.
* Solicitaremos que o usuário digite um trecho do modelo que ele quer visualizar, por exemplo PALIO.
* Listaremos apenas os modelos que tiverem a palavra PALIO no nome.
* Usuário escolherá um modelo específico pelo código e, diferente do site, já listaremos as avaliações para TODOS os anos disponíveis daquele modelo, retornando uma lista de forma similar à imagem abaixo:
