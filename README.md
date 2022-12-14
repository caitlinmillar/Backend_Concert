
<div>
<img src="./TRack 2.png" alt="logo" align="centre" width="100" height="100"/>
</div>
<h1 align="center">Hi 👋 we are Track2!</h1>
<h3 align="center">A group of software-engineers-in-training. This is our first BackEnd project.</h3>




### 🚀 Project Outline

<p> In this project we have built an API for a concert booking system. It implements Java, SpringBoot and a Postgres SQL Database.

</p>


###  🌱 MVP

<p>
For started our project by defining our MVP. We decided the most integral logic of the application would be:

- creating, removing and updating concert details
- adding and removing attendees from concerts
- the ability to display all concerts and all attendees

### Concert

---
Within the Concert Model we have defined the following properties: a concert id, ticket price, capacity, date, time, artist and a list of attendees.
Our Concert and Attendee classes have a many-to-many relationship and as such attendees can be removed or added to a concert.

### Attendee

---
Each Attendee object has an attendee id, name, email address, phone number and a list of concerts they will be attending.
Attendees can be created or removed as well as added or removed from individual concerts.
</p>


### 💻 Class Diagram and Entity Relationship Diagram
<div>
<img src="./UML:ERD.png" alt ="uml and erd diagrams"/>
</div>

## Tech Stack :
- Intellij, JDK 17
- Spring Boot
- PostgresSQL
- Postman
- Postico

## 💬 How to use the API
### RESTful roots:
**Index**
-
-GET
-
**Show**
-
**Create**
-
**Update**
-
**Delete**
-
### Filters and Sort:
**Filter**
-
**Sort**
-



## 📫 How to install and run the project

Clone the project

```bash
  git clone https://github.com/caitlinmillar/Backend_Concert
```

Go to the project directory

```bash
  cd Backend_Concert
```

Install dependencies

```bash
  npm install
```

Start the server

```bash
  npm run start
```
## Roadmap

- (What improvements we want to make)




## ⚡ Credits
**Caitlin Millar**: [github](https://github.com/caitlinmillar)

**Berna Yasar** 

**Loshanth Selvanayagam**


**Abdullah Taibi**

[//]: # (<h3 align="left">Connect with me:</h3>)

[//]: # (<p align="left">)

[//]: # (</p>)

<h3 align="left">Languages and Tools:</h3>
<p align="left"> <a href="https://git-scm.com/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/git-scm/git-scm-icon.svg" alt="git" width="40" height="40"/> </a> <a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a> <a href="https://www.postgresql.org" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/postgresql/postgresql-original-wordmark.svg" alt="postgresql" width="40" height="40"/> </a> <a href="https://postman.com" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/getpostman/getpostman-icon.svg" alt="postman" width="40" height="40"/> </a> <a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> </a> </p>
