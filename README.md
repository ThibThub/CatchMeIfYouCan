# CatchMeIfYouCan

TP amené quasiment au bout. Au programme :

- Remplissage d'une liste d'aeroports à partir d'un fichier csv
- Rotation de la terre après avoir imprimé la texture sur une Sphere
- Récupération des coordonnées longitude et lattitude après un clic de souris
- Création et exploitation de fonctions de recherche d'aeroports par ces coordonnées ou d'un IATA
- Affichage sphères correspondant aux positions des aéroports les plus proches à chaque clic de souris (non résolu totalement)
- Lecture et exploitation de données au format Json via fichier texte statique
- Remplissage d'une base de données de vols à l'aide de ces données
- Récupération de données en temps réel via une requête HTTP  API sur le site AviationStack.com
- Exploitation de ces données pour affichage des vols en destination de l'aeroport le plus proche d'un clic utilisateur (affichage dans console)
- Utilisation de l'interface Runnable pour éviter les freezes dus à la requete HTTP



## Points restant à résoudre :
- L'affichage des spheres rouges des aeroports proches se fait sur un plan 2D autour de la terre, je n'ai pas eu le temps de corriger le problème
- Par conséquent l'affichage des spheres jaunes des aeroports de départ n'a pas été traité
- Lors de requêtes HTML, il se peut que le format du fichier Json lève des exceptions, cela n'entrave pas le bon fonctionnement du programme mais fait apparaître un nombre d'erreurs importants dans la console pouvant gêner la lecture des données ayant pu être exploitées


## Le TP
Le TP a été très intéressant mais un peu long pour seulement trois séances. Quelques points étaient particulièrement compliqués (suppression du pane pour la gestion des coordonnées sur la terre) et faisaient appel à des connaissances qui nécessitaient de passer par le professeur en charge du TP.

Reste que pas mal de concepts et de mécanismes ont été appréhendés durant ce TP et j'en ressors avec une vraie plus-value pour ma formation, ce qui est rare jusqu'ici dans nos cours mettant en oeuvre de la programmation.

## Structure du code
La structure est celle donnée par l'UML en début de TP, à l'exception d'une classe RequeteAviationStack qui a été créée pour permettre l'utilisation de l'interface Runnable



### Merci pour le TP !
