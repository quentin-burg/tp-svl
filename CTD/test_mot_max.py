# M. Nebut - SVL 1617 - demo CTD1
# un ex bidon pour unittest

import unittest
from mot_max import MotDeTailleMax

class TestEtendreUnMot(unittest.TestCase):
    
    def test_un_mot_est_initialement_vide(self):
        mot_max = MotDeTailleMax(5)
        self.assertEqual("", mot_max.mot())

    def test_on_peut_etendre_un_mot_vide(self):
        mot_max = MotDeTailleMax(5)
        mot_max.etendre("ab")
        self.assertEqual("ab", mot_max.mot())

    def test_on_peut_etendre_un_mot_non_vide(self):
        mot_max = MotDeTailleMax(5)
        mot_max.etendre("ab")
        mot_max.etendre("cd")
        self.assertEqual("abcd", mot_max.mot())

    def test_on_ne_peut_pas_etendre_un_mot_en_depassant_son_max(self):
        mot_max = MotDeTailleMax(5)
        mot_max.etendre("ab")
        self.assertRaises(ValueError,
                          mot_max.etendre,
                          "cded")

    def test_on_ne_peut_pas_etendre_un_mot_en_depassant_son_max_autre_syntaxe(self):
        mot_max = MotDeTailleMax(5)
        mot_max.etendre("ab")
        with self.assertRaises(ValueError) : 
            mot_max.etendre("cded")        


#    def setUp(self):
#        self.mot_max_7 = MotDeTailleMax(7)
        

                    
#    def test_avec_setup(self):
#        self.mot_max_7.etendre("1234567")
#        self.assertEqual("1234567", self.mot_max_7.mot())
