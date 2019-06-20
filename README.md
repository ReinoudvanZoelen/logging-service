# Logging-Service
Een microservice voor het centraal opslaan en verwerken van logs, draaiende op [KumuluzEE](https://ee.kumuluz.com/) met het doel om zo licht mogelijk te zijn.

## Technieken
- Microservices
- KumuluzEE
- REST Endpoints
- Predefined tokens

## Microservices
### Voordelen
- Schaalbaar waar het nodig is
- Herbruikbaarheid
- Kleinere, overzichtelijkere code

### Nadelen
- Deployment per microservice i.p.v. per monoliet
- Interne communicatie zoals het gebruik van types moet actief gestandaardiseerd worden

## KumuluzEE
Initieel maakten we gebruik van Wildfly voor het hosten van onze applicaties. Toen we eenmaal over gingen naar microservices merkte we dat Wildfly echt bedoeld is voor het hosten van meerdere applicaties tegelijkertijd, terwijl wij steeds per wildfly instantie één applicatie aan het hosten waren. Wildfly kost veel resources om te hosten en dat past niet bij de microservice architectuur: een microservice moet zo licht mogelijk zijn en zo snel mogelijk opstarten.

Als alternatief voor Wildfly hebben we KumuluzEE gevonden, wat modulair is en ons dus laat kiezen wat we wel en niet nodig hebben. Dat maakte elke applicatie zo licht en snel mogelijk, terwijl het de applicatie geeft wat het nodig heeft.

Nadelen van KumuluzEE is dat je voor sommige features even moet opzoeken wat je moet importeren. Het heeft ook niet alle features van Wildfly, maar wij hebben geen features nodig die Kumuluz niet heeft. 

### Voordelen
- Snel
- Modulair

### Nadelen
- Soms even de module zoeken

## Rest endpoints
### Voordelen
- Verkeer over HTTP
- Brede ondersteuning
- Overzichtelijke code

### Nadelen
- Één message per keer, geen stream
- Elk bericht opnieuw authenticeren
- Het endpoint staat in principe open voor al het verkeer

## Predefined tokens
Als security-implementatie wordt in deze applicatie gebruik gemaakt van predefined tokens. Bij het loggen geeft de verstuurder een Origin en een Secret. Het origin is de verstuurder van de log en het secret is ons interne secret key. 

Momenteel staan de Secrets statisch in de code. Als uitbreiding van deze applicatie zou ik het kunnen hosten in [Portainer](https://www.portainer.io/). Portainer heeft onder andere een secrets service waarin we bij voorbeeld voor de proftaak de Google API key bewaren, zodat deze niet extern in te zien is. Diezelfde service zou ook gebruikt worden voor de predefined tokens. 

### Voordelen
 - Houdt de logs schoon
 
 ### Nadelen
 - Onbekend of een token in foute handen is gevallen
 - Single point of failure
