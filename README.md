**********************************************************************

                    Jeu de rôle basé sur un Tp

        A partir de l'exercie 1, ajout des changements demandés
                avec touche personnele (détails plus bas)

**********************************************************************


TP : Jeu de rôles - S2

Enoncé :

Nous allons enrichir le déroulement du jeu. En repartant du code réalisé précédemment.
Les personnages vont maintenant avoir une notion d’endurance. L’endurance permet de réaliser des
actions. Quand l’endurance atteint zéro, le personnage ne peut plus réaliser d’action hormis
manger. 

Trois actions possibles :

    - Attaquer (en faisant usage de l’arme qui est équipée).
    - Se défendre (en faisant usage du bouclier qui est équipé)
    - Manger (de la nourriture qui se trouve dans la sacoche)

Chaque personnage possèdera aussi un ensemble d’objets dans une sacoche. Les armes, les boucliers, la
nourriture feront partie des objets possédables par le personnage. 

Une arme ou un bouclier est équipable. Un personnage ne peut s’équiper que d’une seule arme et
d’un seul bouclier. Par contre, il peut en avoir autant qu’il le souhaite dans sa sacoche. Il doit
impérativement avoir une arme d’équipée, mais peut ne pas avoir de bouclier. 


Quand une arme (épée ou gourdin) est utilisée, elle réduira les points d’endurances du personnage
en suivant le calcul suivant : (longueurCm*poidsGr)/10000
Par exemple, un héros qui a 70pt d’endurance et qui est équipé d’une épée de 50cm pesant 900gr,
quand il attaque perdra (50*900)/10000 = 4.5pt d’endurance.

Le fonctionnement est le même avec les boucliers :

Par exemple, si un héros attaque un monstre et lui inflige 10pts de dégât, en se défendant avec un
bouclier qui encaisse 5, il ne perdra que 5 points de vie. Il ne pourra se défendre que si il a
l'endurance nécessaire. Chaque action de défense lui fera perdre des points d'endurances (même
principe qu'avec l'arme PE = (poidsGr/1000)
Notez que si un personnage n'a pas de bouclier, il ne pourra pas se défendre.
L’objet nourriture permet de gagner de l’endurance. 



Notez que si un personnage n'a pas de nourriture, il ne pourra pas manger.

Déroulement du jeu :
Le déroulement ressemble beaucoup au précédent, mais cette fois ci chaque personnage peut
attaquer, se défendre ou se nourrir.

Dans un premier temps :

    - les deux équipes sont fabriquées dans une méthode principale (un main).
    - On fera une équipe de héros et une équipe de monstres.
    - Les deux équipes ont la même taille (vous pouvez commencer avec des équipes de taille un)
    - Il faut fournir à chaque personnage
    - Obligatoirement au moins une arme (ou plusieurs)
    - Optionnellement un bouclier (ou plusieurs)
    - Optionnellement de la nourriture (ou plusieurs)
    
    - A chaque démarrage de tour de jeu :

    * Vous devez choisir aléatoirement qui va réaliser la première action.
    * Vous devez choisir aléatoirement l’action menée par chaque personnage.
    * Un tour peut se passer d’une des manières suivantes :
         J1 attaque J2, si J2 toujours en vie, il se défend contre J1
         J1 mange, J2 attaque J1
         J1 mange, J2 mange
         J2 attaque J1, si J1 toujours en vie, il se défend contre J2
         J2 attaque J1, J1 mange

    * Celui qui attaque perd des points d’endurance, celui qui ‘défend’ fera usage de son bouclier et perdra aussi des points d’endurance.

Celui qui mange, gagne des points d’endurance en fonction de la qualité de la nourriture

    * Quand un joueur n’a plus de points d’endurance, il ne peut plus que manger (si il lui reste de la nourriture)

    * Quand un joueur n’a plus de points de vie il rejoint le cimetière (ne fait plus partie de l'équipe).

L’équipe qui perd est la première qui n’a plus de personnage.

***************************************************************************

Changements par rapport à l'exercice :

    Endurance :

    - les points d'endurances passent en type Integer permettant de simplifier la lecture des combats
    - modification du calcul de la perte d'endurance de l'attaquant pour plus de réalisme
        : longueur de l'arme * poids / 1500
    - de meme pour le defenseur

    Nourriture :

    - ajout d'une variable : nbPointdevie qui permet de redonner des points de vie au combattant
    - modification de la variable valeur en nbEndurance qui redonne toujours des points d'enddurance

    - Deroullement du combat :

    - vérification des points d'endurance et des points de vie du combattant
    
    - si > 30 => 1 chance sur 5 de manger, sinon combat

    - si <30 => pour l'endurance 1 chance sur 3 de manger

    - si < 30 => pour les points de vie, une chance sur 2 de manger

    - si endurance < points d'endurance necessaire au combat => manger obligatoire

    - si manger impossible => pas d'action