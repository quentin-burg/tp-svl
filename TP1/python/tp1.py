# TP1 - SVL - 1617
# classe mystere a tester
# M. Nebut - 01 / 2016 - revu 2017

class Stuff:
    """
    Une classe non (ou tres mal) documentee pour experimenter pendant le tp1.

    >>> s = Stuff()

    On peut ajouter une reference
    >>> s.add_ref('tacos')
    >>> s.refs()
    ['tacos']
    >>> s.add_ref('nuggets')

    Mais on ne peut ajouter deux fois la même
    >>> s.add_ref('tacos')
    Traceback (most recent call last):
    ...
    ValueError

    On peut supprimer une reference
    >>> s.del_ref('nuggets')

    Mais on ne peut pas supprimer une reference
    qui n'est pas definie
    >>> s.del_ref('poulpe')
    Traceback (most recent call last):
    ...
    ValueError

    On peut trouver la valeur associée a une reference
    >>> s.items_ref('tacos')
    0

    Mais on ne peut pas trouver la valeur associée à
    une référence indéfinie
    >>> s.items_ref('poulpe')
    Traceback (most recent call last):
    ...
    ValueError

    On peut ajouter une valeur à la valeur d'une référeference
    >>> s.add_item_ref('tacos', 2)

    On ne peut pas non plus supprimer une reference
    dont la valeur associée n'est pas égale à 0
    >>> s.del_ref('tacos')
    Traceback (most recent call last):
    ...
    ValueError

    Mais on ne peut pas l'ajouter à une référence indéfinie
    >>> s.add_item_ref('poulpe', 2)
    Traceback (most recent call last):
    ...
    ValueError

    On ne peut pas non plus ajouter une valeur négative ou nulle
    >>> s.add_item_ref('tacos', -1)
    Traceback (most recent call last):
    ...
    ValueError

    On peut décrémenter une valeur associée à une référence
    >>> s.cons_item_ref('tacos',1)

    Mais on ne peut pas décrémenter d'une valeur négative ou nulle
    >>> s.cons_item_ref('tacos', -1)
    Traceback (most recent call last):
    ...
    ValueError

    Et on ne peut pas non plus décrémenter la valeur d'une référence
    indéfinie
    >>> s.cons_item_ref('poulpe', 2)
    Traceback (most recent call last):
    ...
    ValueError

    """

    def __init__(self):
        """
        Constructeur de la classe,
        crée un dictionnaire vide
        """
        self.__stuff = dict()

    def refs(self):
        """
        Retourne la liste des références que contient
        l'objet Stuff
        """
        return list(self.__stuff.keys())

    def add_ref(self, ref):
        """
        Ajoute une référence à l'objet Stuff.
        La valeur qui y est associée est de 0.
        Lève une exception quand la référence
        est déjà définie dans le dictionnaire.
        """
        if ref in self.refs():
            raise ValueError()
        self.__stuff[ref] = 0

    def del_ref(self, ref):
        """
        Supprime la référence passée en paramètre
        de l'objet Stuff.
        Lève une exception quand la référence en paramètre
        n'est pas définie dans l'objet Stuff ou si la
        valeur qui y est associee est différente de 0.

        """
        if ref not in self.refs():
            raise ValueError()
        if self.__stuff[ref] != 0:
            raise ValueError()
        del self.__stuff[ref]

    def items_ref(self, ref):
        """
        Retourne la valeur associée à la référence
        passée en paramètre.
        Lève une exception si la référence en paramètre
        n'est pas définie dans l'objet Stuff.
        """
        if ref not in self.refs():
            raise ValueError()
        return self.__stuff[ref]

    def add_item_ref(self, ref, nbof):
        """
        Incrémente de nbof la valeur associée à
        la référence passée en paramètre.
        Lève une exception si nbof est négatif ou
        nul ou si la référence passée en paramètre
        n'est pas définie dans l'objet Stuff.
        """
        if nbof <= 0:
            raise ValueError()
        if ref not in self.refs():
            raise ValueError()
        self.__stuff[ref] += nbof

    def cons_item_ref(self, ref, nbof):
        """
        Décrémente de nbof la valeur associée à
        la référence passée en paramètre.
        Lève une exception si nbof est négatif ou
        nul, si la référence associée n'est pas
        définie dans l'objet Stuff ou si nbof est
        supérieur à la valeur associée à la référence
        passée en paramètre.
        """
        if ref not in self.refs():
            raise ValueError()
        if nbof <= 0 or nbof > self.items_ref(ref):
            raise ValueError()
        self.__stuff[ref] -= nbof

    if __name__ == "__main__":
        import doctest
        doctest.testmod()
