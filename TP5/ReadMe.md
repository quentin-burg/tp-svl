# TP5 - Quentin BURG & Alexia OMIETANSKI

## Question 1 :
  **1)**
  - La classe *Filtre* a pour responsabilité de filtrer les messages selon une condition donnée.
  - La classe *Écrire* va écrire dans le fichier log les résultats filtrés
  - La classe *Lire* va lire dans le fichier log les éléments qui vont ensuite être filtrés.
  - La classe *Message* va convertir une chaîne de caractère qui correspond à une ligne du fichier log en un objet Message qui a trois attributs : date, priorité et message.
  - L'interface *ConditionInterface* permet d'avoir une abstraction des conditions, et donc de pouvoir créer des classes conditions qui implémentent cette interface pour pouvoir ajouter facilement de nouvelles conditions.
  - La classe *ConditionPriorité* implémente l'interface citée ci-dessus et désigne une condition de filtrage sur la priorité.

  **2)** Les cas à tester pour la classe *Filtre* sont:
  - Cas nominal :
      - Si on met une condition pour n=5, seuls les messages dont la priorité est supérieure ou égale à 5 seront réécrits.
      - Si on

   - Cas aux bornes :
      - Si la priorité est égale à 0 : tous les messages sont réécrits dans le nouveau fichier log

   - Cas d'exception :
      - S'il n'y a aucune condition : une exception est levée
