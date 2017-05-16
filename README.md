# Android_Vote_Remote
Composant permettant à un utilisateur de voter avec son smartphone

<strong>Description:</strong>

Ce composant se présente sous la forme d'une application Android permettant à l'utilisitateur de participer à un vote proposé
par un bureau de vote UPnP. Lorsque inscrit à un bureau de vote via l'application, l'utilisateur recevra une qeustion avec des 
propositions de réponse et en choisira une à l'aide du pavé numérique.
Il est a noté qu'un utilisateur est représenté par l'UDN de son composant, ce qui fait que le vote n'est pas tout à fait anonyme.


<strong>Lancement de l'application:</strong>

L'application ne peut pas communiquer via UPnP lorsque lancée dans un émulateur, elle doit être lancée sur un terminal physique
et appartenir au même réseau local que les autres composants.

Il faut donc installer l'apk sur le terminal, vérifier d'avoir autorisé les sources non vérifiées.

Après démarrage de l'application, il est possible d'ajouter le composant sur wcomp en suivant la méthode décrite sur le wiki
oppocampus.

<strong>Spécification UPnP:</strong>

Ce composant offre le service VoteRemtoeService dont voici la description:

  1) questionNotif(String question): permet de notifier au composant qu'une nouvelle question a été soumise, en lui passant 
  son énoncé et ses réponses possible.
  
Ce service envoie un événement Commande lorsque l'utilisateur a fait un choix de réponse, un document XML DOM est alors envoyé,
contenant l'UDN du composant ainsi que le choix.


Voici le schéma correspondant à ce composant:

![alt tag](https://github.com/components-upnp/Android_Vote_Remote/blob/master/TelecommandeEleve.png)

<strong>Maintenance:</strong>

Le projet de l'application est un projet gradle.
