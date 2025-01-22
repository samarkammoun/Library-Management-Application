# Library Management Application

## Description

L'application de gestion de bibliothèque permet de gérer les utilisateurs, les clients, les livres et les emprunts. Elle permet de :

- Gérer les informations des utilisateurs (login, mot de passe).
- Gérer les clients (avec une liste de livres empruntés).
- Gérer les administrateurs.
- Gérer les livres (ISBN, auteur, titre, prix, quantité).

Les clients peuvent consulter et emprunter des livres, tandis que les administrateurs peuvent gérer les livres et les utilisateurs.

## Prérequis

Avant de commencer, assurez-vous que les éléments suivants sont installés sur votre machine :

- **Java 8 ou supérieur** (pour exécuter l'application).
- **MySQL** (pour la base de données).
- **MySQL Workbench** (facultatif, mais utile pour gérer la base de données).
- **mysql-connector.jar** (pour la connexion à la base de données).

## Installation

1. Clonez le projet dans votre répertoire local :

git clone https://github.com/samarkammoun/Library-Management-App.git

Base de données :

Importez la base de données en utilisant le fichier library_dump.sql généré avec MySQL Workbench (ou créez les tables manuellement si nécessaire).
Pour importer le fichier .sql dans MySQL, utilisez la commande suivante :

mysql -u username -p database_name < library_dump.sql
Ajout de MySQL Connector :

Téléchargez le fichier mysql-connector.jar à partir de MySQL Connector/J.
Ajoutez-le à votre projet pour permettre la connexion à la base de données.

Si vous utilisez un IDE comme Eclipse, ajoutez le .jar dans les Libraries de votre projet.
Si vous utilisez Maven ou Gradle, ajoutez la dépendance suivante :
Maven :

<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.26</version>
</dependency>
Gradle :

gradle
Copier
Modifier
implementation 'mysql:mysql-connector-java:8.0.26'

Configuration :

Modifiez le fichier config.properties pour y mettre les informations de connexion à votre base de données (nom d'utilisateur, mot de passe, etc.).
Exemple de contenu pour config.properties :

# Exemple de configuration (à personnaliser)
DB_USERNAME=your_username
DB_PASSWORD=your_password
DB_URL=jdbc:mysql://localhost:3306/your_database_name

Exécution :

Compilez et exécutez le projet avec votre IDE Java (par exemple, Eclipse) ou en ligne de commande avec Maven/Gradle.

Utilisation:

Login : Les utilisateurs peuvent se connecter via leurs identifiants.
Clients : Les clients peuvent consulter et emprunter des livres.
Administrateurs : Les administrateurs peuvent gérer les livres et les utilisateurs.


### Changements :

- Ajout d'un point spécifique pour télécharger et intégrer le `mysql-connector.jar`.
- Si vous utilisez Maven ou Gradle, la dépendance correspondante est également incluse.

Cela devrait maintenant couvrir toutes les étapes nécessaires pour bien configurer l'application, y compris la connexion à la base de données avec le connecteur MySQL.


