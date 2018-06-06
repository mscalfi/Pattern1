### Specifica dei requisiti

Obiettivo dell'esercizio è *progettare* e *realizzare* un insieme di classi
che consentano di simulare un insieme di *anatre*, seguendo passo passo le specifiche di seguito riportate:

#### Step 1
Implementare due diverse classi che rappresentano due diverse specie di anatre: `MallardDuck` e `RedHeadDuck`. Entrambe le classi implementano l'interfaccia [Quackable](src/main/java/it/uniupo/disit/sweng/lab06/Quackable.java) e rispondono alla chiamata del metodo
```
#!java
public void quack()
```
scrivendo su [System.out](https://docs.oracle.com/javase/8/docs/api/java/lang/System.html#out) la stringa `"quack"`.

#### Step 2
Implementare altre due classi `RubberDuck` e `Goose`. Esse, pur NON implementando l'interfaccia `Quackable` hanno un comportamento molto simile: `RubberDuck` possiede un metodo
```
#!java
public void squeak()
```
la cui invocazione scrive su *System.out* la stringa `"squeak"`; `Goose` invece possiede un metodo
```
#!java
public void honk()
```
la cui invocazione scrive su *System.out* la stringa `"honk"`.

#### Step 3
Aggiungere la possibilità di **trattare** istanze delle classi `RubberDuck` e `Goose` come oggetti di tipo `Quackable`. Tale obiettivo deve essere raggiunto usando il *design pattern* denominato
**adapter**; più in dettaglio, è richiesta la realizzazione di due diversi adapter: `QuackableRubberDuck` e `QuackableGoose` che devono implementare l'interfaccia `Quackable` e *adattare* rispettivamente `RubberDuck` e `Goose`.

Le funzionalità fino ad ora sviluppate rappresentano la prima release del software che deve essere etichettata come `v1.0`.

#### Step 4
Aggiungere la possibilità di **contare** il numero di volte che un qualsiasi oggetto di tipo `Quackable` emetta un *verso*. Tale obiettivo deve essere raggiunto usando il *design pattern* denominato
**decorator**; più in dettaglio, è richiesta la realizzazione di una classe `QuackCounter` che implementa l'interfaccia `Quackable` e *decori* un'istanza di `Quackable` in modo che venga conteggiato il numero di *versi* emessi da una qualsiasi istanza decorata.
La classe `QuackCounter` deve implementare anche i metodi:
```
#!java
public static int getQuackNumber()
```
che restituisce il conteggio attuale;
```
#!java
public static void reset()
```
che resetta il conteggio attuale.

Le funzionalità fino ad ora sviluppate rappresentano la seconda release del software che deve essere etichettata come `v2.0`.


#### Step 5
Creare due diverse classi `SimpleDuckFactory` e `CounterDuckFactory` adibite rispettivamente alla **creazione** di semplici oggetti `Quackable` e oggetti `Quackable` incapsulati nel *decorator* introdotto al punto precedente. Tale obiettivo deve essere raggiunto usando il *design pattern* denominato **abstract factory**. Nello specifico le due factory concrete devono estendere la seguente classe astratta:
```
#!java
public abstract class AbstractDuckFactory {
  abstract public Quackable createMallardDuck();
  abstract public Quackable createRedHeadDuck();
  abstract public Quackable createQuackableRubberDuck();
  abstract public Quackable createQuackableGoose();
}
```

All'interno della fase di *refactoring* dell'iterazione corrente, ricordarsi di sostituire, ogni creazione di istanze `Quackable` presente nei *test*, con l'uso della *factory* opportuna.

Le funzionalità fino ad ora sviluppate rappresentano la terza release del software che deve essere etichettata come `v3.0`.

#### Step 6
Creare una classe che rappresenti uno stormo di oggetti di tipo `Quackable`. Tale obiettivo deve essere raggiunto usando il *design pattern* denominato **composite**; più in dettaglio, è richiesta la realizzazione di una classe `Flock` che deve implementare l'interfaccia `Quackable` e deve rispondere all'invocazione del metodo `void quack()` demandando la chiamata agli oggetti `Quackable` *aggregati*.
Le istanze della classe `Flock` devono consentire l'aggiunta di elementi "figli" tramite l'invocazione del metodo:
```
#!java
public void add(Quackable duck)
```

Le funzionalità fino ad ora sviluppate rappresentano la quarta release del software che deve essere etichettata come `v4.0`.

