[![Gitpod Ready-to-Code](https://img.shields.io/badge/Gitpod-Ready--to--Code-blue?logo=gitpod)](https://gitpod.stud.ntnu.no/#https://gitlab.stud.idi.ntnu.no/it1901/groups-2021/gr2115/gr2115)
# Foodie-prosjektet 

Dette prosjektet er tilknyttet emnet IT1901 Informatikk prosjektarbeid I.
## Oppsett av prosjektet 
- Selve kodingsprosjektet ligger i mappen `foodie`. Her er prosjektet delt inn i tre moduler: core, ui og restapi. 
- Kjernelogikken og filbehandling, samt tester til disse klassene ligger i mappen `core`. Logikken er skrevet i Java og tilknyttede tester med JUnit 5. Vi har valgt å bruke Jackson-biblioteket for å lese og skrive JSON objekter til fil. 
- Design av brukergrensesnittet er laget med JavaFX og kontroller-klassene som styrer dette ligger i `ui`.
- REST-APIet og restserver ligger i mappen `rest`, og er implementert med Spring Boot. 
- Brukerhistorier som viser appens hovedfunksjonalitet ligger i mappen `foodie`. 
- Dokumentasjonen for hver release ligger i mappen `docs`.

## Bygging og kjøring av prosjektet
Prosjektet bruker Maven til bygging og kjøring. 
For å kjøre prosjektet, skriv følgende kommandoer i terminalen. Dette kjører også alt av tester. 
- `cd foodie` 
- `mvn install` 
- `cd rest`
- `mvn spring-boot:run` for å starte serveren
- Åpne en ny terminal og skriv
- `cd foodie`
- `mvn -pl ui javafx:run`

For å se appen i GitPod må du inn på Remote Explorer og trykke på "Open browser" på port 6080. For å avslutte appen: kryss ut appen (øverst til høyre) og lukk app-vinduet. For å avslutte serveren, gå inn i terminalen der serveren ble startet og skriv `Control + C`.

## Shippable product
Vi bruker **jlink** og **jpackage** for å lage et "shippable product" av vår applikasjon. 
jlink genererer en kjørbar fil (.exe, .app), mens jpackage oppretter installasjonsprogrammet for den kjørbare filen. Installasjonsfilen kan kjøres på en annen maskin med samme operativsystem. jpackage vil lage en .dmg fil for Mac, .msi fil for Windows og .deb eller .rpm for Linux.

Applikasjonen kan kjøres med disse tilleggene lokalt på IDE, men ikke i Gitpod, grunnet at "fakeroot" ikke er tilgjengelig. 

For å starte jlink og jpackage skriv følgende kommandoer i terminalen ..
- `cd foodie` 
- `mvn install` 
- `cd rest`
- `mvn spring-boot:run` for å starte serveren
- Åpne en ny terminal og skriv
- `cd foodie/ui`
- `mvn clean compile javafx:jlink jpackage:jpackage`

## Verktøy tilknyttet kodekvalitet
Vi har brukt følgende verktøy tilknyttet kodekvalitet:

- **Checkstyle** - sjekker mer overfladiske og stilmessige egenskaper til koden som tekst.
- **Spotbugs** - analyserer koden for vanlige feil.
- **Jacoco** - samler inn og presenterer informasjon og testdekningsgrad. 

For å kjøre alle testtilleggene: 
- `cd foodie`
- `mvn verify`
For å finne jacoco-rapporten, gå inn i target på ønsket modul, site og åpne index.html med Live Server.
## Arbeidsvaner og arbeidsflyt
Vi har brukt Scrum som en del av vår utviklingsprosess. Scrum er et rammeverk for å støtte smidig utvikling av informasjonssystemer. 
Her struktureres utviklingen i sykler kalt sprinter. I starten av hver sprint har vi et møte for å sette opp Sprint Backloggene som ligger i docs-mappen. Her ble det også foretatt en vurdering av tidligere arbeid. Vi har møttes minst to ganger i uken for å jobbe sammen med prosjektet. Da har vi vekslet mellom parprogrammering og programmering individuelt. 

Vi har hatt en god og strukturert arbeidsflyt underveis i utviklingsprosessen. Hver milestone i prosjektet er tilknyttet en sprint. For hver sprint har vi benyttet boards på Gitlab for å danne en oversikt over alle issues (kodingsoppgaver) tilknyttet denne sprinten. Her kan man se hvilke issues som gjenstår å løses, er under arbeid og er løst. Hvert issue ble merket med passende labels og tildelt et eller flere av gruppemedlemmene. Når et gruppemedlem tok på seg et issue, opprettet de en branch tilknyttet dette issuet. Etter at et issuet var løst, ble det opprettet en merge request fra tilknyttet branch til master. Vi har brukt code review, slik at et av de andre gruppemedlememmene så over merge requesten og ga en kort tilbakemelding. Dersom vedkomne var fornøyd med endringene, ble branchen merget med master. 




