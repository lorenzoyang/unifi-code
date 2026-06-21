The DBLP (Digital Bibliography & Library Project) dataset is a comprehensive bibliographic database of computer science research papers and proceedings. It contains over 5 million records, including articles, conference papers, and book chapters, spanning several decades of computer science research. The dataset covers a broad range of topics, including computer networks, databases, artificial intelligence, programming languages, and software engineering.

Each record includes metadata such as the title, author(s), publication venue, and publication year. The dataset also includes information about citations, including the number of times a paper has been cited and the papers that have cited it.

The DBLP dataset is widely used in computer science research and has been the basis for numerous studies on topics such as citation analysis, authorship attribution, and topic modeling. It is frequently used as a benchmark dataset for evaluating new techniques and algorithms in natural language processing, information retrieval, and machine learning. [https://www.kaggle.com/datasets/dheerajmpai/dblp2023]

Download the following files, each one in .csv format, or all of them in a single .zip here: https://drive.google.com/file/d/1kiys5-N3YYV6EcbcfxptImE_zpCPFfTX/view?usp=sharing

The fields of each file are described by the first row of the file, which is also reported here. Each row of each file is a publication (in file 1 there are the articles, in file 2 there are the books, ....). 

WARNING: Opening these files with an editor (like blocknotes) is risky as some of them are too big!!! If you want to open, rename the file with extension .txt and open it with a browser, like chrome.

CREDITS: I downloaded the files from DBLP and processed them to get the .csv using XMLToCSV.py available here: https://github.com/ThomHurks/dblp-to-csv

For each link, in order to download the file, copy and paste the URL in your browser, e.g. chrome.

1==> out-dblp_article.csv <== 

Link: https://drive.google.com/file/d/1kZUAXx1_A-aIZM3ttBzlDTDuB1o525UB/view?usp=sharing
Fields id;author;author-aux;author-orcid;booktitle;cdate;cdrom;cite;cite-label;crossref;editor;editor-orcid;ee;ee-type;i;journal;key;mdate;month;note;note-label;note-type;number;pages;publisher;publnr;publtype;sub;sup;title;title-bibtex;tt;url;volume;year
2==> out-dblp_book.csv <==

Link: https://drive.google.com/file/d/1kSG-yoBE-ody21RpMbY1K1GIEpnO7GgK/view?usp=sharing
Fields: id;author;author-bibtex;author-orcid;booktitle;cdrom;cite;cite-label;crossref;editor;editor-orcid;ee;ee-type;i;isbn;isbn-type;key;mdate;month;note;note-type;pages;publisher;publisher-href;publtype;school;series;series-href;sub;sup;title;url;volume;year
3==> out-dblp_incollection.csv <==

Link: https://drive.google.com/file/d/1kRW2D-LXTY8u_U10kbkT2Qb2aJFUIbxm/view?usp=sharing
Fields: id;author;author-orcid;booktitle;cdrom;chapter;cite;cite-label;crossref;ee;ee-type;i;key;mdate;note;number;pages;publisher;publisher-href;publtype;sub;sup;title;url;year 
4==> out-dblp_inproceedings.csv <==

Link: https://drive.google.com/file/d/1kVuWwVFDLWOS4Ulg7LymAkvcXq1RGGYU/view?usp=sharing
Fields: id;author;author-aux;author-orcid;booktitle;cdrom;cite;cite-label;crossref;editor;editor-orcid;ee;ee-type;i;key;mdate;month;note;note-type;number;pages;publtype;sub;sup;title;title-bibtex;tt;url;volume;year 
5==> out-dblp_mastersthesis.csv <==

Link: https://drive.google.com/file/d/1k_fxwJ6roo3zcj0LvP8s8ZAOtXFCOTg_/view?usp=sharing
Fields: id;author;ee;ee-type;key;mdate;note;note-type;school;title;year
6==> out-dblp_phdthesis.csv <==

Link: https://drive.google.com/file/d/1kCxA1W9doUyL0E6E8uWbxwrhBBsPtM6m/view?usp=sharing
Fields: id;author;author-orcid;ee;ee-type;i;isbn;isbn-type;key;mdate;month;note;note-type;number;pages;publisher;publtype;school;series;series-href;sub;sup;title;volume;year
7==> out-dblp_proceedings.csv <==

Link: https://drive.google.com/file/d/1kXp55QfNsnGR4WquTCfK9gxYEHT-hAzq/view?usp=sharing
id;address;author;booktitle;cite;cite-label;editor;editor-orcid;ee;ee-type;i;isbn;isbn-type;journal;key;mdate;note;note-type;number;pages;publisher;publisher-href;publtype;school;series;series-href;sub;sup;title;url;volume;year
Note that the field author contains the list of the authors of the publications separated by "|"

For each of the 7 dataset build the bipartite graph authors vs publication using Networkx. In this graph each publication is a node, and also each author corresponds to a node. There is an edge (undirected) between an author and a publication if the author authored the publication.

Tip: each publication and each author will have a number in the graph. Build a dictionary associating to each publication or author the number of the corresponding node in the graph. Also, build the reverse dictionary (or store as an attribute on the nodes) which says for each node number the corresponding publication id or author.

All the algorithms must have complexity quasi-linear otherwise it will take too long to end.

Moreover, it is convenient to put a label on each publication, which tells its year, title, number of pages, publisher, venue (depending on the chosen question). For venue we mean: journal (for out-dblp_article.csv), booktitle (for out-dblp_incollection.csv and out-dblp_inproceedings.csv), title (for out-dblp_proceedings.csv)

Choose a QUESTION 1, a QUESTION 2, a QUESTION 3, and a QUESTION 4 and solve them (eventualy) using the graphs just built, giving an answer for each of the dataset. QUESTION 5 is only for computer scientists and engineers.

QUESTION 1:
 
For each graph of the kind in {article,book,incollection,inproceedings,mastersthesis,phdthesis,proceedings}, considering only the publications up to year x with x in {1960,1970,1980,1990,2000,2010,2020,2023}:
 
A. Which is the publication with largest number of authors? Report Title and Authors
B. Who is the author who did the largest number of papers? Report his/her name
C. Who is the author who worked for more years, counting only the years in which he/she published? Report his/her name
D. Who is the author who worked for the longest period (compute the difference between the first and the last year he/she worked)? Report his/her name
E. Average number of publications per year?
F. Average number of publications per author per year?
G. Which is the oldest venue?
H. Which is the venue having more publications?
I. Who is the author who wrote more papers by himself/herself?
 
QUESTION 2:
Eventually, using ChatGPT (or other LMMs), implement a class using one of the following sketch strategies, implementing both size estimation and Jaccard one:
 
(i). K-min (both size and jaccard estimation formulas in the slides)
(ii). Bottom-k (both size and jaccard estimation formulas in the slides)
(iii). Threshold sampling (in this case, see jaccard estimation on the slide, make size estimation using 1: |A| = t: |S(A)|)
 
In any case, you must declare if you used ChatGPT or not and you must be able to understand and explain every instruction used.
Assume that the universe is a set of strings and use hashing for implicitly define the permutation of the universe, i.e. the ranking of each element of the universe. For instance you can use this simple function, that given a string s returns the ranking of s: 
 
def simple_hash(x, seed=0, m=2**32)::
   h = seed
   for c in s:
        h = (31 * h + ord(c)) % m
   return h/m
 
In order to make different experiments, you must change the seed.
 
QUESTION 3: 
 
Let S be {article,book,incollection,inproceedings,mastersthesis,phdthesis,proceedings}. Use the class implemented in QUESTION 2 to:
 
I. Estimate the number of distinct authors for each x in S. For each pair x,y with x,y in S, estimate the Jaccard coefficient between the set of authors of x and y.
II. Estimate the number of distinct publisher for each x in S. For each pair x,y with x,y in S, estimate the Jaccard coefficient between the set of publishers of x and y.
III. Estimate the number of distinct words (except articles and adverbs) used in all the titles in S. For each pair x,y with x,y in S, estimate the Jaccard coefficient between the set of words in the titles of of x and y.
 
Evaluate the precision of the estimation with respect to the exact value, varying the size of the sketches.
 
QUESTION 4: 
 
Considering only the publications up to year x with x in {1960,1970,1980,1990,2000,2010,2020,2023} and restricting to the largest connected component of each graph:
 
1-Compute exactly the diameter of G using ifub
2-Approximate the average distance
3-Approximate the closeness centrality for each node. Who are the top-10 authors?
4-Approximate the average eccentricity, where the eccentricity of a node v is the maximum distance from v to every other vertex, i.e. max_{u in V} d(v,u).
5-Approximate the average number of shared authors for each pair of publication nodes, i.e for two vertex publications u and v consider |N(u) \cap N(v)|.
6-Approximate the average number of publications shared by pairs of authors, i.e for two authors u and v consider |N(u) \cap N(v)|.
 
TIP: For 1 use the algorithm in the slides, For 2,3,4 sample vertices using classical sampling in the slides. For 5,6 sample pairs of vertices.
 
QUESTION 5: only for computer scientists and engineers
 
Build the union graph and repeat the chosen questions.
 
Build also the author graph, whose nodes are only authors, and two authors are connected if they did a publication together (considering all the files). Answer to the following question:
Which pair of authors collaborated most frequently?
 
FAQ:
 
Please write an email only after checking that the info you are looking for is not already here. The answer to questions posed by mail will be posted here. So we suggest to check this page regularly.
 
It is possible to use Pandas, Numpy, and all the packages used during the lectures.
Even if NetworkX contains a procedure to answer directly to the questions, you must implement on your own.
You can use other libraries instead of NetworkX
Rows not respecting the format can be ignored
If the algorithm you did takes too long and you think it is because your laptop is not powerful enough, consider only the maximum x such that you algorithm ends considering only the first x rows of the files.
In the presentation, I expect to see the idea of the algorithms, some snippets of the code, and the results got by running the programs with also the time of execution.
It is only possible to pose questions or ask for meetings up to one week before the deadline.
 
RULES
The project can be done either in couples or individually. If in a couple, both students must do the exam in the same session.
 
Each project must be booked in this page inserting the chosen questions, reporting surnames of both the members. Just one choice is allowed and each combination of questions can be assigned to just one team. It is mandatory for the student before inserting the choice, checking whether that project has already been chosen by someone else. This can be checked looking at the list below. 
 
The evaluation will consider efficiency of the proposed solutions and whether the requirements have been satisfied. During the oral exam there will be a presentation of the work done in the project explaining how the algorithms work: 10 minutes per person (if the project is done by just one person, it will be 10 minutes in total).
 
Each student must submit the following files using the "compito" activity in the main page in a single .zip file with name lastname1-lastname2.zip containing:
 
lastname1-lastname2.py containing the implementation required in to build the graph and the algorithms. Alternatively, the file can be a notebook file. 
 
lastname1-lastname2.pdf (in pdf format) containing the slides to be presented  (they can be in Italian or English, as you prefer)
 
Lastname1 and lastname2 refers to the two members of the team in lexicographic order. In the case the project is done individually, then use only your lastname.
 
In order to participate in an exam session, it is mandatory to do the submission within the deadline for the subscription to the exam (see the introduction of the course to get it). The date of the oral and presentation will be communicated using e-learning platform after the evaluation of the project. 
 
If you cannot do the oral exam during some of the days listed above, you must declare it before the deadline for subscription to the exam sending an email to andrea.marino@unifi.it, putting in CC also the (eventual) partner with subject [APAD 2026: oral exam] specifying the motivation.
 
All the dates applies to everyone, including Computer Scientists and Engineers. If you are an Engineer and you intend to give the exam in a session, send an email to me and I will activate the session in GCS (Gestione Carriere Studenti).
 
Understanding the requirements, the procedure (which is actually an algorithm) to submit your material is part of the evaluation.
 
This project will be valid until February 2027, meaning that if you send this project and you do not give the exam before February 2027, the project will not be valid anymore. If you gave the project in a previous session you do not have send it again.


---

COMBINAZIONE SCELTA:

- QUESTION 1.I
- QUESTION 2.(ii) Bottom-k
- QUESTION 3.I
- QUESTION 4.2
- QUESTION 5
