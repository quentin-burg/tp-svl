# TP6 Login
## Quentin BURG - Alexia OMIETANSKI


**Question 1.1:**
  - Création d'un utilisateur dans la base à partir des nom, prénom, login :
    - *Cas nominal* : Le login n'est pas dans la base alors l'utilisateur est ajouté
    - *Cas d'exception* : Le login est déjà dans la base, une exception est alors
    levée.
  - Création d'une utilisateur à partir de son nom et prénom, le login étant généré
  automatiquement :
    - *Cas nominal* :
      - Le login est composé au maximum des 8 premières lettres du nom
      - Le login déjà pris :
          - Le login est composé des 7 premières lettres au maximum du nom concaténé
          à l'initiale du prénom
          - Sinon, l'admin cherche un login et vérifie qu'il n'existe pas
