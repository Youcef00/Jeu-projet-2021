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

### Atteinte des objectifs
Nous avons atteint notre objectif qui était de finir la conceptualisation du projet. De plus nous avons réussi aussi à coder complétement les différents classes, et réussi à tester les deux jeux. Nous avons apporté quelques corrections de bugs, pour fludifier le jeu et de ne pas recontrer de problème. Nous allons maintemant nous focaliser sur une mise en place d'une interface graphique.

### Difficultés restant à résoudre
Il ne nous reste pas de problèmes non résolu. Il nous reste de finir de compléter la documentation des classes et d'ajouter quelques testes.

## Livrable 3

### Atteinte des objectifs

### Difficultés restant à résoudre

## Livrable 4

### Atteinte des objectifs

### Difficultés restant à résoudre

# Journal de bord

## Semaine 1
- UML provisoire
- Classes créees / partielment crées: 
  - Dans le dossier `Game` :
	- `Cell`, 
	- `Character`, classe abstrainte,
	- `Game`, classe abstrainte,
	- `Player`, classe abstrainte,
	- `util/Biome`, interface,
	- `util/Resource`, interface.
	
  - Dans le dossier `FarmeGame` :
	- `Worker`, hérite de la classe abstraite `Character`,
	- `util/biomes/Desert`, implémente l'interface `Biome`,
	- `util/biomes/Forest`, implémente l'interface `Biome`,
	- `util/biomes/Mountain`, implémente l'interface `Biome`,
	- `util/biomes/Océan`, implémente l'interface `Biome`,
	- `util/biomes/Plain`, implémente l'interface `Biome`,
	- `util/biomes/None`, implémente l'interface `Resouce`,
	- `util/biomes/Rock`, implémente l'interface `Resouce`,
	- `util/biomes/Sand`, implémente l'interface `Resouce`,
	- `util/biomes/Wheat`, implémente l'interface Resouce,
	- `util/biomes/Wood`, implémente l'interface `Resouce`.
	
  - Dans le dossier `WarGame` :
    - `Army`, hérite de la classe `Character`,
    - `WarGame`, hérite de la classe `Game`,
    - WarPlayer, hérite de la classe `Player`,
    - il possède aussi un dossier `util`, qui suit la meme structure que dans le dossier `FarmeGame`
	
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
    
- Corrections de bugs : 
  - erreur avec la classe `Input`,
  - erreur de valeurs négatives,
  - erreur de conversion de ressources dans le jeu `FarmGame`,
  - erreur d'affichage du plateau de jeu.
  
## Semaine 3

## Semaine 4

## Semaine 5

## Semaine 6

## Semaine 7

## Semaine 8

## Semaine 9

## Semaine 10

## Semaine 11

## Semaine 12
