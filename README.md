# l2s4-projet-2021



# Equipe

- Youcef MOUKEUT
- Alpha Oumar BARRY
- Haik PHAGRADIANI
- Mohamed CAMARA

# Sujet

[Le sujet 2021](https://www.fil.univ-lille1.fr/portail/index.php?dipl=L&sem=S4&ue=Projet&label=Documents)

# Livrables

## Livrable 1

### Modélisation des personnages : 
Pour notre modélisation de nos personnages nous avons décidé de créer une **classe abstraite**, <code>Character</code>. Tous les "personnages" d'un jeu devront hériter de cette classe, en respectant bien la construction de la classe. Nous avons choisi cette modélisation pour permettre l'implémentation d'un jeu de tuiles assez facilement. En effet un personnage devra avoir en attribut sa tuile et le nombre d'or. Sa tuile permet de savoir en permanence la position du personnage sur la tuile.

### Atteinte des objectifs

Voici un résume de nos modélisations : 

<ul>
<li>Modélisation des personnages :
        <ul>
        	<li>La classe <code>Character</code> est une <b>classe abstraite</b> commune à tous les personnages d'un jeu,</li>
        	<li>Les classes <code>Army</code> et <code>Worker</code> représentent les personnages de jeu, elles héritent de la classe <code>Character</code>.</li>
        </ul>
    </li>
    
<li>Modélisation d'un joueur :
    	<ul>
    		<li>La classe <code>Player</code> est une <b>classe abstraite</b> commune à tous les joueurs d'un jeu,</li>
    		<li>Les classes <code>WarPlayer</code> et <code>FarmPlayer</code> représentent réspectivement les joueurs du jeu de guerre et du jeu de développement agricoleelles, elles héritent de la classe <code>Player</code>,</li>
    	</ul>
    </li>
    	
<li> Modélisation de la nature des tuiles :
    	<ul>
    		<li>L'interface  <code>Biome</code> représente le type de tuile,</li>
    		<li>Les classes <code>Mountain</code>, <code>Desert</code>, <code>Plain</code>, <code>Forest</code> et <code>Ocean</code> sont des classes qui implémentent <code>Biome</code>.</li>
    	</ul>
    </li>
    	
<li> Modélisation des ressources d'une tuile :
    	<ul>
    		<li>L'interface  <code>Resource</code> représente les ressources,</li>
    		<li>Les classes <code>Rock</code>, <code>Sand</code>, <code>Whead</code>, <code>Wood</code> et <code>Ocean</code>, <code>None</code> sont des classes qui implémentent <code>Resource</code>.</li>
    	</ul>
    </li>
    
</ul>

Tous ces modélisations, sont accompagnés d'un diagramme **UML**, qui comporte les attribues et les méthodes associées. Vous trouverez ces diagrammes __UML__ dans le dossier `/UML`, puis ouvrer l'un des fichiers dont le format vous convient.

Nous avons aussi organisé et codé la plus part de nos classes modélisées. 

### Difficultés restant à résoudre

Il nous reste à mettre en place les régles des jeux, la modélisation d'un plateau, et plus exactement re-penser la modélisation d'une tuile.


## Livrable 2

### Modélisation du plateau
Nous avons opté de générer le plateau dans la class <code>Game</code>, grâce à la méthode <code>setBoard</code>

### Atteinte des objectifs
Nous avons atteint notre objectif qui était de finir la conceptualisation du projet. De plus nous avons réussi aussi à coder complétement les différents classes, et réussi à tester les deux jeux. Nous avons apporté quelques corrections de bugs, pour fludifier le jeu et de ne pas recontrer de problème. Nous allons maintemant nous focaliser sur une mise en place d'une interface graphique.

### Difficultés restant à résoudre
Il ne nous reste pas de problèmes non résolu. Il nous reste de finir de compléter la documentation des classes et d'ajouter quelques testes.

## Livrable 3

### Atteinte des objectifs

### Difficultés restant à résoudre

Implémentations de l'affichage pour l'utilisateur

## Livrable 4

### Affichage dans le terminal :

#### La carte

- Nous avons implémenté un affichage de la carte dans le terminal. Voici comment l'utiliser. Chaque biome possède une lettre qui l'identifie : 
	- `O` -> océan
	- `[M]` -> montagne
	- `[D]` -> desert
	- `[P]` -> plaine
	- `[F]` -> foret
	
Voici un exemple d'affichage de la carte : 

![arborescences dossier](images/exemples/carte_exemple.png?raw=true "Title")
	
- Lorsque l'on ajoute une armée ou un ouvrier sur la carte, la lettre du biome change et devient alors `[A]`, cela permet de visualiser l'emplacement où les autres joueurs ont déployé.

- Comment bien déployer en utilisant les coordonnées ? 
L'axe des `x` est l'axe vertical et l'axe des `y` est  l'axe horizontal.
	
#### Informatoins complémentaires

- Pour que l'utilisateur ne soit pas perdu, à chaque tour l'utilisateur voit ses troupes déployées, ses ressources et peut s'appuier sur la carte pour choisir les zones les plus stratégiques. 
- A la fin de la partie, il y a un résumé des points des joueurs et le vainqueur.


# Arborescences 
Voici la structure de notre projet. 

## Dossiers
Voici l'arborescence des dossiers :

![arborescences_dossier](images/arborescences/arborescence_dossiers.png?raw=true "Title")

## Fichiers

### Dossier : `src`
Voici l'arborescence des fichiers dans le dossier `src` : 

![arborescences src](images/arborescences/arborescence_src.png?raw=true "Title")

### Dossier : `tests`
Voici l'arborescence des fichiers dans le dossier `tests` :

![arborescences tests](images/arborescences/arborescence_tests.png?raw=true "Title")



# UML 
Ce UML est accésible en plus grand si vous cliquez dessus, ou dans le dossier `./images/UML`. 
- Précision : les méthodes possédant le symbole `#` sont des méthodes abstraites.

![UML](images/UML/class-diagram.jpeg?raw=true "Title")


# Makefile

- Les commandes `make` : 
	- `all`, 
	- `cls`, produit les fichiers `.class`,
	- `doc`, produit la javadoc,
	- `guerre.jar`, créer l'executable pour le jeu de guerre aléatoire, 
	- `guerre-multi.jar`, créer l'executable pour le jeu de guerre sans le mode aléatoire, 
	- `agricole.jar`, créer l'executable pour le jeu agricole aléatoire, 
	- `agricole-multi.jar`, créer l'executable pour le jeu agricole sans le mode aléatoire, 
	- `clean`,
	- `.PHONY`.

# Jouer (aléatoire)
Après avoir crée l'executable, vous pouvez lancer le jeu : 

- Jeu de `Guerre` :
```shell
% java -jar jar/guerre.jar Raymond Odette
```

- Jeu `Agricole` :
```shell
% java -jar jar/agricole.jar Vigneron Eleveur Maraicher
```

# Journal de bord

## Semaine 1
- Modélisation de l'ensemble de notre projet
- UML provisoire
- Classes créees / partielment crées: 
  - Dans le dossier `Game` :
	- `Cell`, 
	- `Character`, classe abstrainte,
	- `Game`, classe abstrainte,
	- `Player`, classe abstrainte,
	- `util/Biome`, interface,
	- `util/Resource`, interface.
	
  - Dans le dossier `FarmGame` :
	- `Worker`, hérite de la classe abstraite `Character`,
	- `util/biomes/Desert`, implémente l'interface `Biome`,
	- `util/biomes/Forest`, implémente l'interface `Biome`,
	- `util/biomes/Mountain`, implémente l'interface `Biome`,
	- `util/biomes/Ocean`, implémente l'interface `Biome`,
	- `util/biomes/Plain`, implémente l'interface `Biome`,
	- `util/biomes/None`, implémente l'interface `Resouce`,
	- `util/biomes/Rock`, implémente l'interface `Resouce`,
	- `util/biomes/Sand`, implémente l'interface `Resouce`,
	- `util/biomes/Wheat`, implémente l'interface `Resouce`,
	- `util/biomes/Wood`, implémente l'interface `Resouce`.
	
  - Dans le dossier `WarGame` :
    - `Army`, hérite de la classe `Character`,
    - `WarGame`, hérite de la classe `Game`,
    - `WarPlayer`, hérite de la classe `Player`,
    - il possède aussi un dossier `util`, qui suit la meme structure que dans le dossier `FarmGame`
	
## Semaine 2
- UML correcte,
- Toutes les classes existantes ont été enrichi d'attributs et de méthodes.
- Nouvelles classes ajoutées : 
  - Dans le dossier `Game` :
    - `util/Input`, permet de gérer les valeurs d'entrées,
    - `util/ParmsNotCompatibleException`, hérite de la classe `Exception` et permet de lancer une exception concernant la taille d'une troupe sur une case,
  - Dans le dossier `FarmGame` : 
    - `FarmGame`, hérite de la classe abstraite `Game`,
    - `FarmGameMain`, permet de lancer le jeu de `FarmGame`,
    - `FarmPlayer`, hérite de la classe abstraite `Player`,
  - Dans le dossier `WarGame` :
    - `WarGameMain`, permet de lancer le jeu de `WarGame`,
    - `WarPlayer`, hérite de la classe abstraite `Player`,
    
- Corrections de bugs (Bugs déjà corrigés): 
  - erreur avec la classe `Input`,
  - erreur de valeurs négatives,
  - erreur de conversion de ressources dans le jeu `FarmGame`,
  - erreur d'affichage du plateau de jeu.
  
## Semaine 3

- Modifications du readme
- Corrections de bugs :
	- problème avec la condition dans le `while` (class `FarmGame` :  `playOneRound`)
	- problème avec la condition dans le `while` (class `WarGame` :  `playOneRound`)


## Semaine 9

- Modifications `playOneRound` dans `WarGame` :
	- On demande maintenant la taille de l'armée après avoir demandé les coordonnées de la case
	- gestion de ressources (amélioration)
	- amélioration de `playOneRound`

- Modifications de la class `Game`:
	- amélioration du code `checkCoord`
	
- Mise en place du `random` dans la classe `WarGame`
	
- Créations des tests suivant la même structure de dossiers que les dossiers des classes. Commposition du dossier `tests`, voici les premiers fichiers :
	- `tests/Game/CellTest.java`
	- `tests/Game/GameTest.java`
	- `tests/Game/PlayerTest.java`
	- `tests/WarGame/WarPlayerTest.java`
	- `tests/FarmGame/FarmPlayerTest.java`

- Mise en place du `Makefile`

## Semaine 10

- Finitions du `random` pour les classes `FarmGame` et `WarGame`: 
	- mise en place de la class `FarmGameRandom`
	- mise en place de la class `FarmGameRandomMain`
	- mise en place de la class `WarGameRandom`
	- mise en place de la class `WarGameRandomMain`
	
- Mise à jour 1 de `Makefile` :
	- modification de `cls`
	- ajout de `guerre.jar`
	- ajout de `agricole.jar`
		
- Tests : 
	- pour la classe `WarPlayTest`

## Semaine 11

- Mise à jour 1 de `Makefile` :
	- ajout de `guerre-multi.jar`
	- ajout de `agricole-multi.jar`
	- modification `clean`
	- modification `agricole.jar`
	
- Mise à jour 2 de `Makefile`, utilisation de `ifeq` et `endif` :
	- modification de `guerre.jar`
	- modification de `guerre-multi.jar`
	- modification de `agricole.jar`
	- modification de `agricole-multi.jar`

- Modification du message d'erreur en cas d'erreur, classes concernées :
	- `FarmGame`
	- `WarGame`
	
- Ajout méthode `addPlayer` pour faciliter la manipulation des joueurs dans la classe `Game`

-Ajout `equals` dans la classe `Player`

- Tests 1 (suite) : 
	- classe `FarmGameTest`
	- classe `FarmePlayerTest`
	- classe `FarmGameMain`
	- classe `WorkerTest`
	- classe `ArmyTest`
	- classe `WarGameTest`

- Tests 2 (suite) : 
	- classe `WarGameTest` (utilisation de `@Before`)
	
- Modification de la classe `FarmGameMain`


## Semaine 12

- Documentation de toutes les classes
- Finalisation et amélioration du code


## Comment créer un jeu :




	
	
	
	
	
	
	
	
	
	


