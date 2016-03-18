**NE PAS MODIFIER LES DOCUMENTS SOURCE ET TEST MIS EN PLACE PAR GRADLE**

# Installation
```
gradle clean // necessaire si il ne s'agit pas d'un clone propre
gradle build
```

```
Lancer Application.main()
```

## Ebean

Il va générer deux fichiers :
- `sqlite-create-all.sql`
- `sqlite-drop-all.sql`

Une fois qu'on aura une base de données stables,
on fera juste des migrations en passant par `flywaydb`.