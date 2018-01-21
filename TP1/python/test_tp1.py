import unittest

from tp1 import Stuff

class TestTP1(unittest.TestCase):

    def test_creation_dico_vide_creation_nouvel_objet(self):
        s = Stuff()
        self.assertEqual([],s.refs())

    def test_ajout_reference_dans_le_dico(self):
        s = Stuff()
        s.add_ref('tacos')
        self.assertEqual(['tacos'],s.refs())

    def test_on_ne_peut_pas_ajouter_deux_fois_la_meme_reference(self):
        s = Stuff()
        s.add_ref('tacos')
        with self.assertRaises(ValueError) :
            s.add_ref('tacos')

    def test_suppression_reference_dans_le_dico(self):
        s = Stuff()
        s.add_ref('tacos')
        s.del_ref('tacos')
        self.assertEqual([],s.refs())

    def test_on_ne_peut_pas_supprimer_une_reference_qui_n_existe_pas(self):
        s = Stuff()
        with self.assertRaises(ValueError):
            s.del_ref('tacos')

    def test_on_ne_peut_pas_supprimer_une_reference_dont_la_valeur_associee_est_differente_de_0(self):
        s = Stuff()
        s.add_ref('tacos')
        s.add_item_ref('tacos',3)
        with self.assertRaises(ValueError):
            s.del_ref('tacos')

    def test_recuperation_de_la_valeur_associee_a_une_reference(self):
        s = Stuff()
        s.add_ref('tacos')
        self.assertEqual(0,s.items_ref('tacos'))

    def test_on_ne_peut_pas_recuperer_la_valeur_d_une_reference_non_definie(self):
        s = Stuff()
        with self.assertRaises(ValueError):
            s.items_ref('tacos')

    def test_ajout_valeur_a_une_reference_dont_la_valeur_associee_est_nulle(self):
        s = Stuff()
        s.add_ref('tacos')
        s.add_item_ref('tacos',4)
        self.assertEqual(4,s.items_ref('tacos'))

    def test_ajout_valeur_a_une_reference_dont_la_valeur_associee_est_non_nulle(self):
        s = Stuff()
        s.add_ref('tacos')
        s.add_item_ref('tacos',2)
        s.add_item_ref('tacos',5)
        self.assertEqual(7,s.items_ref('tacos'))

    def test_on_ne_peut_pas_ajouter_de_valeur_negative(self):
        s = Stuff()
        s.add_ref('tacos')
        with self.assertRaises(ValueError):
            s.add_item_ref('tacos', -1)

    def test_on_ne_peut_pas_ajouter_une_valeur_a_une_reference_non_definie(self):
        s = Stuff()
        with self.assertRaises(ValueError):
            s.add_item_ref('tacos', 3)

    def test_consommation_de_la_valeur_associee_a_une_reference(self):
        s = Stuff()
        s.add_ref('tacos')
        s.add_item_ref('tacos',3)
        s.cons_item_ref('tacos',1)

    def test_on_ne_peut_pas_consommer_une_valeur_associee_a_une_reference_non_definie(self):
        s = Stuff()
        with self.assertRaises(ValueError):
            s.cons_item_ref('tacos',2)

    def test_on_ne_peut_pas_consommer_d_une_valeur_negative(self):
        s = Stuff()
        s.add_ref('tacos')
        with self.assertRaises(ValueError):
            s.cons_item_ref('tacos',-1)

    def test_on_ne_peut_pas_consommer_d_une_valeur_superieure_a_la_valeur_associee_a_la_reference(self):
        s = Stuff()
        s.add_ref('tacos')
        s.add_item_ref('tacos',4)
        with self.assertRaises(ValueError):
            s.cons_item_ref('tacos',6)
