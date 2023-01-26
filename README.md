


<img src="./TRack 2.png" align="right" alt="logo" width="120" height="120"/>


<h1 align="center">Hi 👋 we are Track2</h1>
<h3 align="center">A group of software-engineers-in-training. This is our first BackEnd project!</h3>




### 🚀 Project Outline

---

<p> In this project we have built an API for a concert booking system. It implements Java, SpringBoot and a Postgres SQL Database. 

The two classes of `Concert` and `Attendee` will have a many-to-many relationship.

</p>


###  🌱 MVP

---

<p>
For started our project by defining our MVP. We decided the most integral logic of the application would be:

- creating, removing and updating concert details
- creating, removing and updating attendee details
- ability to add and remove attendees from concerts
- the ability to display all concerts and all attendees

### 🎸 Concert

---
Within the Concert Model we have defined the following properties: a `concert id`, `ticket price`, `capacity`, `date`, `time`, `artist` and a `list of attendees`.

Our `Concert` and `Attendee` classes have a many-to-many relationship and as such `attendees` can be removed or added to a `concert`.

In accordance with the principles of a many-to-many relationships it is possible for a `concert` to have many `attendees` and for an `attendee` to be going to many `concerts`.

### 🎹 Attendee

---
Each Attendee object has an attendee id, name, email address, phone number and a list of concerts they will be attending.

Attendees can be created or removed from the Repository as well as added or removed from individual concerts.
</p>


### Class Diagram and Entity Relationship Diagram

---
<div>
<img src="./ERDnoBG.png" alt ="erd diagram"/>
<img src="./UMLnoBG.png" alt ="uml diagram"/>
</div>

## 💻 Tech Stack :

---
- Intellij, JDK 17
- Spring Boot
- PostgresSQL
- Postman
- Postico

### Extensions

---
We were able to implement several of our ideas for extending our projects' functionality. They are as follows:
- We added a **Data Transfer Object** class to handle bookings
- We developed some **error handling** by adding response messages.
These related to letting the user know a concert/attendee has been successfully removed.
As well as writing an if/else statement to make sure only attendees and concerts with id's in existence could be updated/removed/added.
Similarly, if an id that doesn't exist is inputted in this way, an error message will be returned 
- We added some **derived queries** (see below, section Filter and Sort)


## 💬 How to use the API

---
### RESTful roots:
**Concert**
- GET http://localhost:8080/concerts ---►
gets all concerts
- GET http://localhost:8080/concerts/1 ---►
  gets a concert by id
- GET http://localhost:8080/concerts/ticketPrices/over150 ---►
Find concerts where the ticket price is greater than 150
- GET http://localhost:8080/concerts/capacities ---►
Sort concerts by capacity (Lowest to Highest)
- GET http://localhost:8080/concerts/ticketPrices ---►
Sort concerts by ticket price (Highest to Lowest)
- POST http://localhost:8080/concerts ---►
creating a new concert
- PUT http://localhost:8080/concerts/2 ---►
updating a concert
- PATCH http://localhost:8080/concerts/1 ---►
adding an attendee to a concert
- DELETE http://localhost:8080/concerts/1/attendees/3 ---►
removing an attendee from a concert
- DELETE http://localhost:8080/concerts/6 ---►
deleting a concert
---
**Attendee**
- GET http://localhost:8080/attendees ---►
gets all attendees
- GET http://localhost:8080/attendees/3 ---►
gets an attendee by id
- GET http://localhost:8080/attendees/names ---►
Getting a list of attendees name
- GET http://localhost:8080/attendees/numberOfAttendees ---►
Get number of attendees
- POST http://localhost:8080/attendees ---►
creating a new attendee
- PUT http://localhost:8080/attendees/5 ---►
updating an attendee
- DELETE http://localhost:8080/attendees/4 ---►
deleting an attendee



## 📫 How to install and run the project

---
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

---
The features we would like to implement in the future are as follows:
- Separate the property Artist *into its own class*
- Replace the strings of 'date' and 'time' with *LocalDate and LocalTime*
- Add parameter of age linked to Attendee
- Logic to define the age restrictions on a concert. Then add a Boolean which takes in an Attendee's age to confirm whether they are permitted to attend the concert or not.




## ⚡ Credits

---
**Caitlin Millar**: [caitlinmillar](https://github.com/caitlinmillar)

**Berna Yasar**: [Byasar3](https://github.com/Byasar3)

**Loshanth Selvanayagam**: [Losh-Selva](https://github.com/Losh-Selva)

**Abdullah Taibi**: [AbdullahTaibi](https://github.com/AbdullahTaibi)

[//]: # (<h3 align="left">Connect with me:</h3>)

[//]: # (<p align="left">)

[//]: # (</p>)

<h3 align="left">Languages and Tools:</h3>
<p align="left"> <a href="https://git-scm.com/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/git-scm/git-scm-icon.svg" alt="git" width="40" height="40"/> </a> <a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a> <a href="https://www.postgresql.org" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/postgresql/postgresql-original-wordmark.svg" alt="postgresql" width="40" height="40"/> </a> <a href="https://postman.com" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/getpostman/getpostman-icon.svg" alt="postman" width="40" height="40"/> </a> <a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> </a> </p>
