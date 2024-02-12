# TP2 Partie Serveur
## Lancement du serveur
```ps1
asadmin start-domain
.\bean_entity.ps1
```

## Aide Personnelle
### Création du lien vers la base de données
```ps1
asadmin create-jdbc-connection-pool --datasourceclassname org.postgresql.ds.PGSimpleDataSource --restype javax.sql.ConnectionPoolDataSource --property portNumber=5432:password=3tud14nt:user=etdsn:serverName=pedago.univ-avignon.fr:databaseName=coursSN CoursSNPool

asadmin create-jdbc-resource --connectionpoolid CoursSNPool jdbc/courSN
```