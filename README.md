# Hello World Evolution in Java

## 1995 - [Hello World](https://github.com/lsegala/hello-world-evolution/tree/console)!

Com o objetivo de rodar em vários dispositivos, a linguagem Java foi rapidamente adotada por grandes
empresas, como a IBM.

## 1996 - [Java para Web](https://github.com/lsegala/hello-world-evolution/tree/servlet)

As Servlets nasceram para possibilitar a plataforma Java atender à requisições HTTP. Hoje encontra-se
versão 4.0, na qual sofreu diversas evoluções, como o uso de Annotations para substituir o XML, serviços assíncronos, 
WebSockets e suporte ao protocolo HTTP 2 mais recentemente.

## 1998 - [Enterprise Java Beans](https://github.com/lsegala/hello-world-evolution/tree/ejb2)

Nascido em 98, acabou sendo em 2001 que se popularizou no controle de transações e aplicações distribuídas.

## 2000 - [Struts](https://github.com/lsegala/hello-world-evolution/tree/struts)

Com a forma muito "crua" para se programar para Web utilizando Servlets, no início do ano de 2000, começaram a surgir
diversos frameworks para tornar a vida do programador mais fácil e produtiva, porém o primeiro a se destacar foi o
projeto Jakarta Struts, na qual se derivou para o projeto Web Work e que se reintegraram criando o Struts 2.

## 2002 - [Spring framework](https://github.com/lsegala/hello-world-evolution/tree/spring)

Lançado a princípio como um framework de IoC, cresceu rapidamente e se popularizou por sua programação orientada à aspectos,
geriamento de transações e acesso à dados.

## 2005 - [Boom dos frameworks Web em Java](https://github.com/lsegala/hello-world-evolution/tree/wicket)

Com a falta de posicionamento em padronizar um framework oficial, surgiram diversos frameworks logo após a popularização 
do Struts, como Tapestry, Vaadin, Wicket, Spring, entre outros.

## 2006 - [JEE 5](https://github.com/lsegala/hello-world-evolution/tree/jee5)

Considerado um marco importante para plataforma, ele entregou a primeira versão do JSF e a nova versão do EJB, que tornava
mais simples e amigável o desenvolvimento de aplicações web e seu respectivo acesso à dados

## 2008 - Arquitetura REST

Apesar do conceito ter nascido mais cedo, foi em 2008 que começou a se popularizar.

## 2010 - Aquisição da Sun pela Oracle

A Oracle adquiria o software e o hardware da Sun Microsystems, na qual teve impacto direto no futuro do MySQL, 
Problema de licença com a Google, descontinuação do Solaris e das tecnologias de virtualização.

## 2010 - [AngularJS](https://github.com/lsegala/hello-world-evolution/tree/angularJS-REST)

Primeira release do framework MVVW criado pela Google

## 2013 - Docker

Nascido especificamente para nuvem, popularizou o conceito de containers e foi rapidamente adotado por grandes empresas, 
como Red Hat e Amazon

## 2013 - [Vert.x](https://github.com/lsegala/hello-world-evolution/tree/vertex)

Iniciado inicialmente por um funcionário da VMWare, foi incubado na fundação Eclipse e se popularizou rapidamente, que assim como o
com o Node.js, fornece uma solução de realizar chamadas HTTP com I/O não blocante.

## 2013 - Arquitetura Microserviços

Derivada da arquitetura SOA, tem como filosofia a construção de pequenos módulos de código que se conversam, porém de forma
totalmente independente e de forma totalmente aderente a automação e elasticidade.

## 2014 - [Spring boot](https://github.com/lsegala/hello-world-evolution/tree/spring-boot)

Criado com objetivo de rodar aplicações Java dentro de Containers, rapidamente foi adotada por grandes empresas.

## 2014 - Java 8

Com evoluções significativas na lingaugem, além de introduzir de novas APIs, permitiu enfim a programação funcional na plataforma.

## 2014 - Kubernetes

Orquestrador de containers criado pela Google e amplamente adotado hoje em dia.

## 2017 - [Projeto jigsaw](https://github.com/lsegala/hello-world-evolution/tree/jigsaw)

Criado e distribuído junto com o Java 9, sua proposta foi criar uma nova formar de empacotar e distribuir as aplicações

## 2017 - [JEE 8](https://github.com/lsegala/hello-world-evolution/tree/Microprofile)

A Oracle lança uma versão reduzida da nova versão enterprise do Java.
No final do ano, ela decide transferir o Java EE inteiramente para uma iniciativa open source. Em parceria com parceiros Java EE, como Red Hat e IBM, ela decide transferir a referência de implamentação do Java EE e o TCK (Kit de Compatibilidade da Tecnlogia) inteiramente para fundação Eclipse.

```
$ eval $(minikube docker-env)
$ docker build -t hello-world-microprofile .
$ kubectl run hello-world --image=hello-world-microprofile:latest --port=8080 --image-pull-policy=IfNotPresent
$ kubectl expose deployment hello-world --type=NodePort
$ curl $(minikube service quarkus-quickstart --url)/hello
```

## 2019 - [Quarkus IO](https://github.com/lsegala/hello-world-evolution/tree/quarkus-io)

Stack de bibliotecas e frameworks em Java para desenvolver aplicações em microserviços para nuvem.

```
$ eval $(minikube docker-env)
$ docker build -f src/main/docker/Dockerfile.native -t quarkus-quickstart/quickstart .
$ kubectl run quarkus-quickstart --image=quarkus-quickstart/quickstart:latest --port=8080 --image-pull-policy=IfNotPresent
$ kubectl expose deployment quarkus-quickstart --type=NodePort
$ curl $(minikube service quarkus-quickstart --url)/hello
```
