## Mini gestion de médiathèque

### Objectifs de l’exercice
- Manipuler des variables simples (`int`, `String`, `boolean`, etc.).
- Créer et utiliser des classes.
- Comprendre l’héritage (`extends`).
- Comprendre et implémenter une interface.
- Utiliser une `List` pour stocker plusieurs objets.
- Utiliser une `Map` pour rechercher un objet par identifiant.
---

## Contexte

On veut modéliser une petite **médiathèque** qui contient des documents : des **livres** et des **DVD**.

On veut pouvoir :
- Ajouter des documents à un catalogue.
- Afficher la liste des documents.
- Rechercher un document par son identifiant (`id`).
- Emprunter et retourner des documents.
---

## Étape 1 – Classe de base `ht.mbds.frst.java.models.Document`

1. Crée une classe `ht.mbds.frst.java.models.Document` avec les attributs privés :
   - `int id`
   - `String titre`
   - `int anneePublication`

2. Ajoute :
   - Un constructeur avec ces 3 paramètres.
   - Des **getters** et **setters** pour chaque attribut.
   - Une méthode `toString()` qui renvoie :

     ```text
     ht.mbds.frst.java.models.Document{id=1, titre='Le Seigneur des Anneaux', annee=1954}
     ```

3. Dans une classe `ht.mbds.frst.java.Main`, crée quelques objets `ht.mbds.frst.java.models.Document` et affiche-les.

---

## Étape 2 – Héritage : classes `ht.mbds.frst.java.models.Livre` et `ht.mbds.frst.java.models.Dvd`

1. Crée une classe `ht.mbds.frst.java.models.Livre` qui **étend** `ht.mbds.frst.java.models.Document`.
2. Crée une classe `ht.mbds.frst.java.models.Dvd` qui **étend** `ht.mbds.frst.java.models.Document`.
3. Dans `ht.mbds.frst.java.Main`, crée 2–3 livres et 2–3 DVD et affiche-les.

---

## Étape 3 – Interface `Empruntable`

1. Crée une interface `Empruntable` avec :

   ```java
   boolean estDisponible();
   void emprunter();
   void retourner();
   ```

2. Fais en sorte que `ht.mbds.frst.java.models.Livre` l’implémente (et éventuellement `ht.mbds.frst.java.models.Dvd`).

---

## Étape 4 – Utiliser une `List` pour le catalogue

1. Crée une liste `List<ht.mbds.frst.java.models.Document> catalogue`.
2. Ajoute-y tous les documents créés.
3. Crée une méthode `afficherCatalogue`.

---

## Étape 5 – Utiliser une `Map` pour rechercher par `id`

1. Crée une `Map<Integer, ht.mbds.frst.java.models.Document>`.
2. Ajoute-y chaque document avec `put(id, document)`.
3. Crée une méthode `rechercherParId`.

---

## Étape 6 – Emprunter / retourner un document

1. Crée une méthode `emprunterDocument`.
2. Crée une méthode `retournerDocument`.
3. (Optionnel) Ajoute un menu texte dans `main`.

### Consignes
1. Créer une méthode

```java
import ht.mbds.frst.java.models.Document;

static void emprunterDocument(Map<Integer, Document> index, int id)
```
- Récupérer le document via la Map.
- Si le document n’existe pas : afficher "ht.mbds.frst.java.models.Document introuvable".
- Sinon
    - Vérifier si le document est une instance de Empruntable :
```java 
  if (document instanceof Empruntable) {
    Empruntable e = (Empruntable) document;
    e.emprunter();
   } else {
    System.out.println("Ce document ne peut pas être emprunté.");
}
  ```
 
2. Créer une méthode similaire retournerDocument(Map<Integer, ht.mbds.frst.java.models.Document> index, int id) qui permet à un emprunteur de retourner un document préalablement emprunté.

## Étape 7 – Implémenter un menu
Votre menu doit proposer les options suivantes :
1 - Afficher le catalogue
2 - Rechercher un document par id
3 - Emprunter un document
4 - Retourner un document
0 - Quitter

### Consignes 
- Utiliser une boucle while pour répéter le menu.
- Utiliser Scanner pour lire le choix de l’utilisateur.

## Etape 8 - Bonus 
- Implémenter une fonction de statistiques qui permet d'afficher 
  - Le nombre de document disponibles
  - Le nombre de document empruntés
- Implémenter une logique de pénalité pour les livraisons hors délai 
- Ajouter un menu permettant de créer de nouveaux documents
- Ajouter d'autre type de documents avec ou sans options d'emprunt
