# HEBCandidates

## Backend Setup

### Setup mysql server (testing on local machine)

- Open mysql workbench and connect to your local database<\p>
- Open and run the candidateDB.sql file in the DatabaseStuffs folder (this builds the tables)<\p>
- Optional - do the same for the mockData.sql file (this only has 7 entries for testing)<\p>

### Setup java maven project

#### Eclipse (Assuming no one is using intellJ ultimate)

##### Import as maven project

- Open Eclipse -> File -> Import -> Maven -> Existing Maven Projects -> Select the folder (HEBCandidate) -> Check the pom.xml box -> Finish <\p>

##### Or Import as existing project

- Build the project using maven by typing mvn compile (if you have maven installed) -> FIle -> Import -> Existing Project -> Find the folder (HEBCandidate) -> Finish <\p>

##### VSCode

- Installed these extensions : Debugger for Java, Java Extension Pack <\p>
- Go to File -> Open Folder -> Find HEBCandidate <\p>

### Change application.properties file

- Find application.properties file in HEBCandidates\src\main\resources\application.properties <\p>
- Change username on line 3 to your account to your local machine mysql server <\p>
- Change password on line 4 to your account to your local machine mysql server <\p>
- Optional - you might need to change line 2 if you host your mysql server on another port other than 3306 and/or the database name is not heb <\n>(jdbc:mysql://localhost:yourPort#/databaseName) <\p>

### Run the service

- For VSCode : Navigate through HEBCandidates\src\main\java\heb\candidate\CandidateApplication.java and run that file <\p>
- For Eclipse : Navigae through demo\src\main\java\heb.candidate\CandidateApplication.java and run that file <\p>
