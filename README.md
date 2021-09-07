### FilmQueryProject ###

### Description

* The user is presented with a menu of (3) choices, choice (1) lets them look up a film from our database
using the films assigned Id number. then prints the title, release year, language, rating, description and casts names.
You are then presented with a sub menu that lets you exit back to the main menu or print all of the films details left out in the first printing. Choice (2) allows the user to look up a movie by a matching keyword that
searches the films title and description to try and find a match. If no matches the user is presented with a message
and sent back to the main menu. no sub menu for this choice. Lastly we have choice (3) Which leaves you with a goodbye statement and terminates the program.

### Technologies Used

* getters and setters, toStrings, hashcode and equals.
* Maven, pom.xml files
* SQL Queries, SELECT and WHERE statements
* JDBC

### Problems Faced

* In the sub menu When printing the full description for the film I was printing the first description, and then the full description after that. I had film.setActors(actors); and printFilm(film); before System.out.println(film.toString());
First I tried to remove both film.set and printFilm but when I would print the toString would print actors: null.
After leaving it and later coming back to try and troubleshoot I had an Ah-Ha moment where I realized I needed to set or load the actors but didn't necessarily need to print them that instant, so I solved the problem by simply removing printFilm(film);


* When printing the full description for the film in choice 1s sub menu I realized I needed to call the toString. Although when I called the toString, because the actors are coming from their own separate class, they had to be loaded in separately and I could not figure out how to remove the starting and ending "[ ]" brackets nor the comma at the end of the actors last name even though I had removed it from the toString.


* When working on the Sub Menu the application would terminate because I had put a break; within the if loops. I realized that without the break; the program will automatically move onto the next line of commands.
