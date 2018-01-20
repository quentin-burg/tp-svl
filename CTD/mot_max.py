# M. Nebut - demo SVL 1
# un petit ex Python bidon

class MotDeTailleMax:
    '''
    Représente un mot de taille bornée.

    Un mot est initialement vide.

    >>> mon_mot = MotDeTailleMax(5)
    >>> mon_mot.mot()
    ''

    On peut étendre le mot dans la limite de son maximum.
    >>> mon_mot.etendre('abc')
    >>> mon_mot.mot()
    'abc'

    L'extension se fait en fin de mot.

    >>> mon_mot.etendre('de')
    >>> mon_mot.mot()
    'abcde'

    On ne peut pas dépasser la taille max.
    >>> mon_mot.etendre('f')
    Traceback (most recent call last):
    ...
    ValueError
    '''    
    def __init__(self, lg_max):
        """
        Cree un mot de longueur max lg_max.
        """
        self.chaine = ''
        self.lg_max = lg_max

    def etendre(self, fin_mot):
        '''
        ajoute fin_mot a la fin de mon mot si possible.
        '''
        if len(self.chaine) + len(fin_mot) > self.lg_max:
            raise ValueError()
        self.chaine += fin_mot

    def reset(self):
        '''
        Vide le mot, mais il garde la meme taille max.
        '''
        self.chaine = ''

    def mot(self):
        '''
        Retourne la chaine contenue dans mon mot
        '''
        return self.chaine


