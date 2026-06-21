# APAD

Materiale del corso **Algoritmi e Programmazione per l'Analisi dei Dati** (A.A. 2025/2026).

Il corso riguarda progettazione, analisi e sperimentazione di algoritmi efficienti per l'analisi dei dati, soprattutto su grafi, usando Python e librerie per data analysis. Tra gli argomenti: analisi degli algoritmi, complessità computazionale, Pandas, NetworkX, visite e distanze su grafi, small-world, conteggio probabilistico, community detection e centralità.

## Struttura

- [`algoritmi/`](./algoritmi/): spazio per aggiungere implementazioni Python degli algoritmi visti durante il corso.
- [`progetto/`](./progetto/): progetto pratico svolto per l'esame.
  - [`project-assignment.md`](./progetto/project-assignment.md): testo del progetto assegnato.
  - [`src/`](./progetto/src/): codice Python del progetto.
  - [`csv/`](./progetto/csv/): dataset DBLP in formato CSV.
  - [`results/`](./progetto/results/): risultati prodotti dagli script.
  - [`presentazione/`](./progetto/presentazione/): slide e PDF della presentazione.
  - [`requirements.txt`](./progetto/requirements.txt): dipendenze Python.

## Progetto

Il progetto usa il dataset DBLP per costruire grafi bipartiti autori-pubblicazioni e rispondere ad alcune domande assegnate: statistiche su autori e pubblicazioni, stime tramite sketch, analisi di distanze e centralità, grafo unione e collaborazioni tra autori.

Dipendenze principali:

- NumPy
- Pandas
- NetworkX

Esecuzione:

```powershell
cd APAD/progetto
python -m venv .venv
.\.venv\Scripts\Activate.ps1
pip install -r requirements.txt
python src/main.py
```

I file CSV del dataset devono essere presenti nella cartella [`csv/`](./progetto/csv/).
