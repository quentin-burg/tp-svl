# TP4 SVL
# 08/02/18

## Question 1 :
  **TDD à la mockist :** On ne crée que la classe qu'on veut tester et on mock le reste.
  **TDD classique :** On crée les classes et les méthodes au fur et à mesure qu'on en a besoin et avec le comportement minimal nécessaire pour pouvoir passer les tests.

## Question 2 :
  - Débiter ticket:
      - Nombre tickets suffisant et solde suffisant : OK
      - Nombre de tickets suffisant mais solde insuffisant : Levée d'exception
      - Nombre tickets insuffisant : Levée d'exception et débit sur le solde de la carte (porte-monnaie)
  - Débiter porte-monnaie :
      - Montant porte-monnaie solde suffisant : OK
      - Montant porte-monnaie solde insuffisant : Levée d'exception

## Question 3 :
  - Création d'une nouvelle carte
  - Récupération du solde
  - Récupération du nombre de tickets
  - Récupération de la valeur d'un ticket
  - Débiter sans ticket :
      - Vérifier que le montant est déduit du solde
      si le solde est supérieur au montant
  - Débiter avec ticket :
      - Vérifier qu'on débite bien un ticket si le
      nombre de tickets est suffisant
