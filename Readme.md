#### 'Hades - Proiect PA'
--- Etapa 1 ---
Hades este jucatorul de sah implementat de echipa Apollo 20. 

In aceasta parte a proiectului, cea mai mare parte din timp a fost petrecuta
cu diverse incercari de a realiza legatura dintre Hades si Winboard astfel ca
este posibil si foarte probabil sa modificam foarte mult structura programului.

Nu a mers totusi pornirea jocului cu comanda de pe forum 
"C:\WinBoard-4.8.0\WinBoard>.\winboard.exe -debug -fcp "java -classpath 
C:\Users\Dragos\IdeaProjects\Chess2020\out\artifacts\Chess2020_jar\Chess2020
.jar upb.pa.Main", a trebuit sa il incarcam manual in Winboard. Am testat si pe
linux si pare totul ok.

Pentru aceasta etapa Hades poate doar sa mute pe rand, fiecare pion (primul pe
care il gaseste, pana cand nu mai poate sa intainteze cu cate o unitate, caz
in care verifica daca poate sa ia o piesa a oponentului, daca nu poate Hades 
va da resign. Programul implementeaza toate comenzile cerute (force, go, white
etc.) asa ca Hades poate sa joace atat cu piese albe cat si negre.

In arhiva se afla toate clasele folosite, Makefile-ul si MANIFEST-ul folosit.
Pentru utilizare se compileaza cu make build, comanda care genereaza si
Hades.jar care trebuie incarcat in Winboard/Xboard. Am folosit Java 13.

In aceasta etapa nu am folosit surse de inspiratie.

Ambii membrii ai echipei au incercat sa realizeze legatura dintre Hades si 
Winboard. Eduard Paunoiu a realizat documentatia, procedeul de compilare 
(Makefile) si debug, iar Petrut Tita a realizat partea tehnica (initializare,
gasirea mutarii, generatorul de mutari etc).

----------------------------- Etapa 2 ----------------------------------

In aceasta etapa am implementat miscarile tuturor pieselor si un algoritm
minimax de baza pentru jucatorul nostru de sah.

Algoritmul nostru minimax este mediocru, urmand sa il imbunatatim in cadrul
etapei 3. Procesul nostru de evaluare atribuie o pondere fiecarei piese,
dar totodata am ales din sursa [1] o tabela de evaluare care adauga puncte
bonus pieselor care se afla intr-o pozitie strategica (ex. doi pioni in aparare
franceza). Am facut ca in cazul in care se pierde regele (este in sah) functia
de evaluare sa intoarca -Inf insa are cateva buguri pe care nu am reusit sa 
le rezolvam pana la deadline si uneori nu scoate regele din sah, si Xboard 
descalifica jucatorul cu Invalid Move.

De asemenea, in unele cazuri, nebunul face miscari gresite, inca nu am gasit
cauza (speram sa nu faca miscari invalide la corectare :D). 

Am implementat si rocadele, insa din cauza functiei de evaluare Hades nu alege
de obicei sa faca rocada. Insa am testat cu force mode si este in regula. 


Algoritmul nostru minimax are depth 4 si nu este deloc optimizat (inca). 
Hades este programat sa poata muta orice piesa. 

In aceasta etapa contributia membrilor a fost urmatoarea: 
Andrei-Petrut Tita: programare tura, nebun, regina, debug, rocade, minimax.
Eduard-Ionut Paunoiu: programare cal, rege, pioni (en passant, promotion),
testare.

Referinte si surse de inspiratie: 
[1] https://www.chessprogramming.org/Simplified_Evaluation_Function