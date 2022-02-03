# Electronic-Store-console

L’obiettivo è sviluppare in Java un sistema software per la vendita online di prodotti elettronici, utilizzando in modo appropriato le tecniche di riferimento della programmazione orientata agli oggetti.
I prodotti elettronici, sono identificati da: nome prodotto, codice prodotto (univoco), nome produttore, e il prezzo.
Il sistema interagisce con utenti (persone che vogliono acquistare dei prodotti elettronici) e impiegati (persone che gestiscono la gestione delle vendite).
Un utente può registrarsi (nome utente e password) e quindi usare le sue credenziali per accedere al sistema.
Dopo l’accesso un utente può ricercare prodotti per nome prodotto, nome produttore e prezzo minimo o massimo, e acquistare dei prodotti. Le ricerche sono possibili con uno o più parametri.
Un dipendente può usare le sue credenziali per accedere al sistema.
Dopo l’accesso un dipendente può spedire dei prodotti ai clienti e rimpiazzare i prodotti venduti.
Un particolare dipendente opera con il ruolo di amministratore, le sue credenziali sono definite nella fase di configurazione del sistema e ha anche il compito di assegnare le credenziali agli altri dipendenti. L’amministratore ha anche il compito di aggiungere e rimuovere dei tipi di prodotto.
Quando un utente fa un ordine per dei prodotti, l’ordine viene automaticamente caricato nel sistema.
Quando un dipendente invia i prodotti di un ordine, la quantità di prodotti in magazzino viene automaticamente aggiornata, e se la giacenza diventa nulla per qualche prodotto, allora il sistema invia a uno degli impiegati la lista dei prodotti da acquisire.
All’arrivo dei nuovi prodotti, un dipendente aggiorna la quantità di prodotti in magazzino.
Gli utenti e i dipendenti interagiscono con il sistema tramite console.
