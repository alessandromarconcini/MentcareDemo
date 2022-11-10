# _Mentcare Demo_

# Indice

# 1 - Introduzione

Mentcare è un sistema informativo utile per la gestione di cliniche che trattano pazienti con problemi di salute mentale.
Esso dovrà fornire un insieme di metodi e strumenti necessari per la raccolta, conservazione e utilizzo dei dati
correlati all'attività informativa di una o più cliniche responsabili di pazienti che non necessitano di ospedalizzazione.
Sono dunque presi in cura da cliniche specializzare dove possono trovare un dottore che conosce attentamente il loro stato clinico.
Il suo scopo è gestire lo scambio di informazioni fra le varie componenti interne attraverso una banca dati centrale.

# 2 - Background

## 2.1 - Processo di sviluppo software

In questa sezione riportiamo le fasi di sviluppo del sw e eventualmente particolari
scelte o condizioni in cui ci siamo trovati

# 3 - Analisi dei requisiti

In questa sezione andiamo a indicare tutte le caratteristiche teoriche(i requisiti) che determinano come il sistema va realizzato

## 3.1 - Specifica

Suddivisione dei requisiti in tipologia (utente,sistema,funzionali,non funz e di dominio)

## 3.2 - Storie e scenari

Elenco e spiegazione di storie e scenari possibili riguardanti il sistema

## 3.3 - Diagrammi di casi d'uso

Utilizzo di diagrammi di casi d'uso per chiarificare come i vari utenti interagiscono con il sistema.
(Quindi un caso d'uso per ogni utente e non per ogni scenario/requisito)

## 3.4 - Definizione degli stati del sistema

Una volta definiti degli stati o delle operazioni chiave fatti dagli utenti,
è possibile attribuire responsabilità ai vari utenti di queste ultime.

## 3.5 - Creazione Test di accettazione

Definiamo a priori i test di accettazione per poter consegnare ad un ipotetico stakeholder un progetto funzionante secondo accordi presettati.

# 4 - Design architetturale

In questa sezione definiamo COME appare il sistema ipoteticamente prima di una possibile implementazione.

## 4.1 - Scelta dell'architetturale

Se modello Client-server oppure MVC (consiglio MVC).
MVC = Model View Controller

Model = Oggetti come entità statiche (i dati)
View = Vista, ovvero il frontend
Controller = tutta la parte dinamica e comportamentale (variazioni di stato)

Se la view è il frontend il controller è il backend.
Consiglio mio, attuare forme di sicurezza nel backend.

## 4.2 Activity Diagram

Questo diagramma enuncia tutte le possibili strade percorribili dall'esecuzione
(Da decidere quali tipi di errore possibili specificare).

## 4.3 - Class Diagram

Questo diagramma presenta la struttura del progetto suddivisa in classi.
(Consiglio mio: abbondare di classi diverse e non classi enormi singole).

## 4.4 - Sequence Diagram

Questo diagramma a vari livelli di dettaglio (logica astratta e/o metodi interni) spiega come avviene lo scambio di messaggi tra gli interlocutori (attori e sistema o attori e componenti di sistema).

## 4.5 - Mock up di interfaccia grafica

In questa sezione presentiamo come vorremmo mostrare l'interfaccia grafica.
Poi l'esito è deciso dall'implementazione del frontend e quindi si potrebbe distaccare non poco.
Draw.io possiede i bottoni e icone utili.
Consiglio di guardarsi i componenti di vaadin (open source).

# 5 - Implementazione e Testing di unità

In questa fase conviene scrivere il codice E contemporaneamente scrivere i test relativi ad ogni metodo (metodo1->test1->metodo2-->..) in modo da avere sott'occhio una realizzazione valida (e quindi sicura sotto certi punti di vista).

## 5.1 - Implementazione delle funzionalità

## 5.1.1 - Entità

Codice della parte model spiegato

## 5.1.2 - Controllers

Codice nelle varie classi controller

## 5.1.3 - View

Codice del frontend

## 5.1.4 - Errori

Codice rigardante possibili errori definti come classi

## 5.2 - Implementazione della sicurezza

## 5.2.1 - Implementazione dei checker
I checker controllano se l'utente che sta agendo ha i permessi per poter fare quella determinata operazione

## 5.2.n ...

## 5.3 - Testing di unità

In questa fase raccontiamo l'esperienza ottenuta dai test dei singoli metodi e delle singole parti suddivise del sistema(per attori oppure per requisiti eccetera)

## 5.4 - Testing di accettazione

Conclusione della realizzazione del progetto attraverso una fase di test più generici, mirati a svolgere tutti i possibili scenari del progetto e colpire il sistema per mandarlo in errore/violare determinate vulnerabilità

# Bibliografia

Io qui ci metterei i vari link
- [Java Spring Tutorial](https://spring.io/guides/tutorials/rest/)
- [Vaadin Components](https://vaadin.com/docs/latest/components)

