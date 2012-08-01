Configuration de synapse (l'ensemble du contenue de se répertoire) à coller dans le repertoire: WSO2_HOME\repository\deployment\server\synapse-configs\default

Il faut copier le jar du connecteur mysql dans WSO2_HOME lib pour que la connection a la base de données soit opérationel.

warning:
-Le répertoire resources doit être copier dans le répertoire: WSO2_HOME\repository.

-ActiveMQ doit être installé et executé sur le poste hote pour garantir le fonctionnement.

pour lancer WSO2 utiliser la commmande

wso2server.bat

Il est nécessaire de créer un datasource avec L'ESB dans la configuration pour pouvoir fonctionner avec la base.
Voici les paramétre a utiliser pour garantir le fonctionnement avec mysql quand la base est installer sur l'hote local:
Name: mysqlConnection
Driver: com.mysql.jdbc.Driver
URL: jdbc:mysql://localhost:3306/articles
User Name: root
Password: secret

selection basicDataSource
selection InMemory

les répertoires utilisés sont les répertoires:
C:\input (directory de d'arivée des batch)
C:\output (directory de sortie des batch aprés taitement)

format des batchS (exemple):
<?xml version="1.0" encoding="UTF-8"?>
<item>
    <author>"Norah Jones"</author>
    <kind>"cd"</kind>
    <editor>"Sony"</editor>
    <meta>"number of track: 13"</meta>
    <title>"Little broken hearts collector"</title>
    <publishDate>"2012-04-30T00:00:00+02:00"</publishDate>
    <releaseDate>"2012-04-30T00:00:00+02:00"</releaseDate>
</item>