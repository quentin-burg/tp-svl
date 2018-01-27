Q1) 

On doit mocker les instances de De et le Joueur à cause de la méthode mise parce qu'elle requiert une intervention de l'utilisateur. On mocke aussi la classe Banque.

Q2)

- le jeu est fermé => levée de JeuFermeException
- le joueur n'est pas solvable => levée de DebitImpossibleException
jouer catch l'exception et il ne se passe rien. On passe à la suite du jeu. On ne va pas lancer les dés, il faut vérifier cela (!!! avec verify !!!)
- le joueur est solvable : 
	- le joueur perd : fin du jeu
	- le joueur gagne : 
		- la banque solvable: jeu continue
		- la banque non solvable: fin du jeu

