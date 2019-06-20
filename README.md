# Logging-Service
Een microservice voor het centraal opslaan en verwerken van logs, draaiende op [KumuluzEE](https://ee.kumuluz.com/) met het doel om zo licht mogelijk te zijn.

## Technieken
- Java
- KumuluzEE
- REST Endpoints
- Predefined tokens

## Voordelen
### KumuluzEE
Initieel maakten we gebruik van Wildfly voor het hosten van onze applicaties. Toen we eenmaal over gingen naar microservices merkte we dat Wildfly echt bedoeld is voor het hosten van meerdere applicaties tegelijkertijd, terwijl wij steeds per wildfly instantie één applicatie aan het hosten waren. Wildfly kost veel resources om te hosten en dat past niet bij de microservice architectuur: een microservice moet zo licht mogelijk zijn en zo snel mogelijk opstarten.

Als alternatief voor Wildfly hebben we KumuluzEE gevonden, wat modulair is en ons dus laat kiezen wat we wel en niet nodig hebben. Dat maakte elke applicatie zo licht en snel mogelijk, terwijl het de applicatie geeft wat het nodig heeft.

## Nadelen
### KumuluzEE
Nadelen van KumuluzEE is dat je voor sommige features even moet opzoeken wat je moet importeren. Het heeft ook niet alle features van Wildfly, maar wij hebben geen features nodig die Kumuluz niet heeft. 
