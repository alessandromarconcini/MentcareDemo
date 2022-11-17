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

## 3.1 - Stakeholder 

Gli attori partecipanti al sistema sono:

- Pazienti
- Dottori
- Infermieri
- Visitatori a domicilio
- Addetti alla reception
- Staff di amministrazione

## 3.2 - Specifica

### 3.2.1 - Scenari

#### S1 - Un medico accede al sistema attraverso la fase di login e decide di scrivere una nuova prescrizione per un paziente già registrato nel database.

Durante la fase di login, la pagina presenta un’interfaccia con due campi in cui è possibile inserire “Nome utente” e “Password”, un bottone con scritto “Accedi” e un bottone con scritto “Registrati”.
Il medico, una volta inseriti i dati, cliccherà sul buttone “Accedi” e una volta entrato correttamente avrà la possibilità di:
-  Cercare il farmaco utilizzando un’apposita voce inserendo il rispettivo nome; inoltre una volta scelto il medico, dalla lista dei pazienti potrà prescriverlo.
   Per fare ciò, clicca sul rispettivo bottone “Nuova prescrizione” e verrà avviata la procedura.
   Il medico potrà scegliere la dose e la frequenza del farmaco che vuole prescrivere e dopo un opportuno controllo del sistema sulla dose, se sarà valida, potrà essere registrata nel sistema; in caso contrario, verrà notificato l’errore. Se l’errore si ripete, il medico dovrà inserire la motivazione circa il dosaggio errato;
-  Se il nome del farmaco inserito non è corretto, apparirà una schermata di errore la quale informerà che tale farmaco non è presente.

#### S2 - Un infermiere deve somministrare un farmaco al paziente

L’infermiere effettua il login nel sistema inserendo il suo codice ID a 8 cifre e la password di sicurezza, cliccando sulla sezione “pazienti odierni” visualizza l’elenco dei pazienti oggi in visita in struttura, seleziona il paziente con un click. Dopo il click visualizza il farmaco da somministrare, se disponibile, la dose da somministrare al paziente e la frequenza di dosaggio. L’infermiere può:

- Somministrare il farmaco: l’infermiere clicca sul bottone “somministrazione effettuata”. Allora un pop up chiede all’infermiere si confermare o meno l’operazione:

1. Se l’operazione viene confermata  il campo “somministrazione odierna” viene visualizzato con un pallino verde e il sistema ritorna all’elenco dei pazienti odierni.
2. Se l’operazione non viene confermata lo stato della “somministrazione odierna” non viene modificato e il sistema ritorna all’elenco dei pazienti odierni.

- Non somministrare il farmaco: clicca sul bottone “annulla” e ritorna all’elenco dei   pazienti odierni.

#### S3 - Un medico prova ad accedere ai dati di un paziente di cui non prende cura.
(Chat oppure altri requisiti sotto)

#### S4 - L'infermiere registra un nuovo paziente

Una volta effettuato il login, l’infermiere, scegliendo l’opzione “Registrazione utente”, dovrà inserire i seguenti campi richiesti:

-Codice fiscale
- Nome
- Cognome
- Nome e cognome del medico curante
- Allergie

   Se qualcuno dei campi relativi non è valido, comparirà un messaggio di errore per ciascuno dei possibili casi:
1. Il nome e il cognome del medico curante non risultano validi;
2. Nel caso in cui il codice fiscale è già presente nel database, questo risulterà non valido;
3. Nel caso in cui ci sia incongruenza tra il codice fiscale e l’anagrafica che lo compone, i campi inseriti non risulteranno validi.
4. Nel caso in cui il codice fiscale sia troppo corto o troppo lungo, non è valido. Dopo il messaggio di errore, sarà possibile modificare i campi errati e riconfermare.

Una volta inseriti tutti i campi l'infermiere può confermare l'operazione premendo il pulsante "Conferma", allora una finestra pop-up comparirà a schermo con i due pulsanti "Conferma" e "Annulla".
Se viene cliccato "Conferma" il paziente viene registrato, se clicca "Annulla" torna alla schermata precedente.
Se prima del pop-up invece clicca "Annulla" torna alla schermata precedente.


#### S5 - La segreteria deve registrare un nuovo appuntamento.

Il receptionist, una volta effettuata la fase di login, può inserire nuovi appuntamenti cliccando il pulsante “Nuovo appuntamento”. Inserendo il codice fiscale del paziente e del medico per cui si vuole registrare l’appuntamento, sarà reindirizzato in una pagina in cui dovrà inserire i dettagli dell’appuntamento;
- Se il receptionist inserisce in modo errato il codice fiscale, comparirà un messaggio di errore in cui sarà richiesto di inserire nuovamente il codice fiscale corretto;
- Se i dati inseriti sono corretti, apparirà una schermata che confermerà che l’appuntamento è stato correttamente inserito nel database.

#### S6 - Utente che vuole prendere visione degli appuntamenti.

Un utente, una volta effettuato il login, può visualizzare gli appuntamenti tramite la sezione “visualizza appuntamenti”.
Si possono verificare i seguenti casi:
-  Se l’utente è un paziente / medico, può visionare solo i propri appuntamenti;
-  Se l’utente è un receptionist, può visualizzare la lista di tutti gli appuntamenti della clinica;
-  Se l’utente è un infermiere a domicilio, può visualizzare la propria lista di appuntamenti.

#### S7 - Caso report mensile da generare.

Il sistema, alla fine di ogni mese, dopo le 17:30, genera un report sottoforma di raccolta dati che enuncia le seguenti informazioni:
- Numero di pazienti per clinica;
- Numero dei pazienti inseriti e cancellati nel sistema;
- Numero di pazienti per sintomatologia con annessi farmaci prescritti;
- I farmaci prescritti vengono arricchiti con i dati relativi alle dosi fornite e i costi ad essi associati.

#### S8 - Caso ispezione giudiziaria o indagine di polizia.

È possibile, durante un’ispezione giudiziaria o un’indagine di polizia che venga richiesto l’accesso ai dati sensibili degli utenti. In particolare, il richiedente ottiene un file con i dati del singolo paziente oppure con un sommario di tutti i pazienti della clinica. Lo staff di amministrazione troverà di fronte a sé un registro dei pazienti con annessi i due bottoni che svolgono rispettivamente queste funzionalità. Una volta selezionata la modalità, viene mostrata a schermo una finestra di conferma.
Se lo staff di amministrazione sbaglia ad inserire il nome dell’utente ricercato, il registro mostrerà una schermata vuota.

#### S9 - Logout di un utente.

Un utente qualsiasi, una volta entrato nel sistema attraverso la metodologia d’accesso, ha la possibilità di poter effettuare il logout in qualsiasi momento andando nell’apposita sezione in alto a destra e selezionando la voce “Logout” specificato su un bottone. Un volta che il bottone viene premuto, viene effettuata l’operazione e l’utente sarà disconnesso dal sistema.

### 3.2.2 - Requisiti funzionali per attori

(a) Medici

- (a.1) Un medico può registrare pazienti nel database
- (a.2) Un medico può modificare i dati del paziente
- (a.3) Un medico può prescrivere farmaci ad ogni paziente da lui in cura
- (a.4) Un medico può visualizzare la cartella clinica del paziente
- (a.5) Un medico può visualizzare la lista di farmaci somministrati da ogni paziente da lui in cura
- (a.6) Un medico può visualizzare la lista dei propri appuntamenti
- (a.7) Un medico può ricercare l'appuntamento con un determinato paziente inserendo il relativo codice fiscale
- (a.8) Un medico può inserire i farmaci ad un paziente a lui associato

(b) Infermieri

- (b.1) Un infermiere può visualizzare la lista con le informazioni di tutti i suoi pazienti
- (b.2) Un infermiere ha la possibilità di cercare i pazienti in base al codice fiscale
- (b.3) Un infermiere può visualizzare la lista di farmaci assunti da ogni paziente

(c) Pazienti
- (c.1) Un paziente può visualizzare il proprio calendario farmacologico
- (c.2) Un paziente può visualizzare la lista dei propri appuntamenti sul calendario
- (c.3) Un paziene può visualizzare le dosi che deve assumere per ogni farmaco avendo la possibilità di filtrare ogni farmaco in base al nome
- (c.4) Un paziente può visualizzare il report di resoconto di una certa visita

(d) Addetto alla reception
- (d.1) Un receptionist può registrare e modificare gli appuntamenti inserendo il codice fiscale del paziente e del personale medico
- (d.2) Un receptionist può visualizzare la lista di tutti gli appuntamenti filtrando le ricerche inserendo l'id del paziente

(e) Staff di amministrazione
- (e.1) Un membro dello staff di amministrazione ha accesso ad un' area riservata dove può ricercare un utente e stamparne il report

### 3.2.3 Requisiti funzionali di sicurezza

- Il sistema deve garantire la protezione dei dati coperti da 
privacy in modo che solamente lo staff medico e il paziente
possano avervi accesso
- Gli utenti che possono accedere ai report devono essere riportati su una white list
- Solo l'utente che apre il record può modificarlo
- Ogni membro dello staff deve essere identificato da un codice univoco di 8 cifre

### 3.2.4 Requisiti funzionali safety

- Il sistema deve avvertire lo staff medico circa la pericolosità di una particolare patologia del paziente se essa è presente
- Il sistema effettua un controllo sulle dosi dei farmaci basandosi su un range di sicurezza. In caso di errore la dose deve essere reinserita
- Se il paziente soffre di allergie particolari il sistema deve rispondere alla somministrazione di un farmaco scorretto con un messaggio di warning e se la figura che prescrive ignora il messaggio di warning deve essere obbligato a lasciare una ragione scritta del perchè

### 3.2.5 Requisiti funzionali riguardanti interfaccia grafica

- Il sistema deve mostrare i record dei pazienti
- Il sistema deve essere dotato di un medication field
- Il sistema deve poter consentire la selezione delle voci 'current medication','new medication' e 'formulary'
- Se si sceglie 'current medication' il sistema chiede un check della dose, la dose può anche essere cambiata
- Se si sceglie 'new medication' il medico può effettuare una ricerca scrivendo anche solo parzialmente le lettere del farmaco
- Se si sceglie 'formulary' il sistema mostra una search box in cui cercare il farmaco e viene effettuato un check circa la validità della medicazione, viene inserita la dose anche in questo caso
- Dopo che il medico ha fatto tutta la procedura, il sistema notifica una schermata di check riassuntiva laddove sono presenti i bottoni 'Ok' e 'Modifica'
- Durante il check di dose serve un pulsante 'Conferma'
- un utente dovrebbe avere la possibilità di vedere gli appuntamenti relativi ed effettuare ricerche su di essi
- Il sistema deve notificare i dottori online con un menù a cascata
- Il sistema deve essere dotato di una chat fra i dottori online

### 3.2.5 Requisiti funzionali di automazione

- Il sistema genera un report mensile mostrando il numero di pazienti per clinica, il numero dei pazienti inseriti o cancellati dal sistema,il numero di pazienti per tipologia, i farmaci loro prescritti ed i relativi costi, questo l'ultimo giorno *lavorativo* del mese, dopo le 17:30
- Il report deve contenere anche le seguenti informazioni: nomi dei farmaci,numero di prescrizioni,numero di dosi prescritte e costi totali delle dosi prescritte
- Se il report ha dosi di differenti unità(10mg,20mg), il sistema deve registrarle in report separati per ogni unità
- il sistema deve generare una lista dei pazienti attesi quel giorno, per ogni clinica

### 3.2.6 Altri requisiti funzionali

- Il sistema prevede sommari dei dati che possano essere facilmente interpretabili dai medici in velocità (problemi chiave e trattamenti iniziati)
- Le informazioni vanno raccolte all'interno di un database centrale a cui differenti host hanno accesso copiandone le informazioni dalla fonte principale
- Ogni farmaco deve possedere i campi 'Maximum dose' e 'Minimum dose'
- Gli addetti alla reception devono poter trasferire i dati di un paziente da un database ad un altro(PSR), come informazioni di tipo anagrafico o sommari di diagnosi e trattamenti di pazienti, lo scambio in sè va regolato secondo il metodo
  di handshacking (il sistema deve essere in grado di ricevere una risposta positiva dal PSR)

### 3.2.7 Requisiti non funzionali

- Il sistema Mentcare dove essere disponibile a tutte le cliniche durante le normali ore lavorative
  (LUN-VEN 8:30-17:30)
- Il sistema non deve riavviarsi se non in 5 o meno secondi
- Tutti gli utenti del sistema devono potersi autenticare con la tessera sanitaria
- Il sistema deve rispettare le linee guida per la privacy in HStan-03-2006-priv
- Gli errori utente (come ad esempio segnalazioni) devono essere comunicati in modo semplice e minimizzati

## 3.4 - Diagrammi di casi d'uso

Utilizzo di diagrammi di casi d'uso per chiarificare come i vari utenti interagiscono con il sistema.
(Quindi un caso d'uso per ogni utente e non per ogni scenario/requisito)

## 3.4 - Definizione degli stati del sistema

Una volta definiti degli stati o delle operazioni chiave fatti dagli utenti,
è possibile attribuire responsabilità ai vari utenti di queste ultime.

## 3.6 - Creazione Test di accettazione

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

