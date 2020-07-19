# Prática com Sockets


### O objetivo do trabalho é praticar a implementação de Sockets, tanto TCP quanto UDP.


Q1 – Baixe e execute os sockets UDP e TCP do livro:
Acesse: http://www.cdk5.net/wp/extra-material/
Depois clique em: Supplementary material for Chapter 4

Q2 – Utilizando UDP, implemente uma calculadora remota que
execute as 4 funções básicas (+,-,∙,÷). Descreva o formato e o tipo
das mensagens (requisição - resposta).

Q3 – Implemente um Chat sobre TCP a partir dos códigos baixados. O
Chat pode ser entre 2 processos apenas. O que deve ser modificado
na classe TCPClient?

Q4 – Refatore o Chat para uma versão não-bloqueante em que as
mensagens podem ser enviadas a qualquer tempo depois que uma
conexão está estabelecida.

Q5 – Adicione um serviço simples, de sua escolha, ao processo
servidor. Quais modificações são necessárias para oferecer mais de
um serviço no mesmo processo? Compare essa solução com a criação
de um processo servidor para cada serviço.

Extra – Transforme os Objetos que fornecem o serviço em Singletons
(http://pt.wikipedia.org/wiki/Singleton).