Q1)

On doit mocker les instances de De et le Joueur à cause de la méthode mise parce qu'elle requiert une intervention de l'utilisateur. On mocke aussi la classe Banque.

Q2)

- le jeu est fermé => levée de JeuFermeException
- le joueur n'est pas solvable => levée de DebitImpossibleException
jouer catch l'exception et il ne se passe rien. On passe à la suite du jeu. On ne va pas lancer les dés, il faut vérifier cela avec un verify.
- le joueur est solvable :
	- le joueur perd : fin du jeu
	- le joueur gagne :
		- la banque solvable: jeu continue
		- la banque non solvable: fin du jeu

Q4)

C'est un test d'état.

Q5)

Pour tester si on ne touche pas aux dés, il faut vérifier que la méthode lancer
pour chaque dé n'a été appelée qu'une seule fois.
C'est un test d'état.
