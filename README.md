**NE PAS MODIFIER LES DOCUMENTS SOURCE ET TEST MIS EN PLACE PAR GRADLE**

# Installation

1. Récupérer les dépendances externes avec *Gradle*
```
gradle clean // necessaire si il ne s'agit pas d'un clone propre
gradle build
```
2. Installer le plugin `EbeanORM Enhancement` sur IntelliJ
3. Compiler le dossier *models*
4. Lancer location.Application.main()


## Ebean

Il va générer deux fichiers :
- `sqlite-create-all.sql`
- `sqlite-drop-all.sql`

Une fois qu'on aura une base de données stables,
on fera juste des migrations en passant par `flywaydb`.



## TODO
- lier btn tableau et dialogue
- formulaire location
	- champs basiques
	- tableau exemplaire dispo
	- tableau exemplaire selectionné
- choix chemin pdf (devis et facture)
- Dialogue detail location:
	- btn "generer devis" -> accepter devis -> approuvee = true -> btn devient "rendre vehicule"
	- btn "rendre vehicule" -> formulaire :
		- date rendu
		- etat vehicule
		- etat reservoir
		-> active btn generer facture
	- btn "generer facture" -> date rendu, vehicule reparer/rempli/disponible.