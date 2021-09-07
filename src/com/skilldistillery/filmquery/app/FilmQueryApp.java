package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//    app.test();
		app.launch();
	}

//  private void test() {
//    Film film = db.findFilmById(1);
//    System.out.println(film);
//    Actor actor = db.findActorById(1);
//    System.out.println(actor);
//    List<Actor> actors = db.findActorsByFilmId(1);
//    film.setActors(actors);
//  }

	private void listFilmsKeyword(List<Film> films) {
		for (Film film : films) {
			printFilm(film);
		}
	}

	private void listActors(List<Actor> actors) {
		for (Actor actor : actors) {
			System.out.println(actor.getFirstName() + " " + actor.getLastName());
			System.out.println();
		}
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		int userInput;
		int userInputTwo;
		int max = 1000;
		do {
			System.out.println("              " + "             ⋆               ⋆            ⋆            ");
			System.out.println("  ⋆   |       " + "     ⋆                    ________________________    ⋆");
			System.out.println("   \\  :  /   " + " ⋆                   ⋆    (_______________________()   ");
			System.out.println("`. __/ \\__ .'" + "                        _.-||⋆        ⋆          ⋆||   ");
			System.out.println("_ _\\     /_ _" + "  ⋆                 _.-'   ||      -SELECT-       || ⋆ ");
			System.out.println("   /_   _\\   " + "   ______  ⋆    _.-'       ||         ⋆           ||   ");
			System.out.println(" .'  \\ /  `. " + "  |  JP  |_ _.-'           ||       -FROM-        ||     ⋆");
			System.out.println("   /  :  \\   " + "  |  SD  | |               ||         ⋆           ||   ");
			System.out.println("  ⋆   |       " + " | 2021 |_|_              ||         ⋆           ||  ⋆ ");
			System.out.println("         ⋆    " + " |______|   `-._          ||        -A-          ||    ");
			System.out.println("              " + "    /\\     ⋆    `-._      ||         ⋆           ||   ");
			System.out.println(" ⋆            " + " ⋆ /  \\             `-._  ||⋆     -Choice-      ⋆||   ");
			System.out.println("              " + "  /    \\          ⋆     `-||_____________________||   ");
			System.out.println("              " + " /      \\  ⋆              -------------------------   ");
			System.out.println("______________" + "/________\\___________________/________________\\_________");
			System.out.println("              " + "");
			System.out.println("----------User Menu----------");
			System.out.println("1) Look Up Film By Id...");
			System.out.println("2) Look Up Film By Keyword...");
			System.out.println("3) Exit...");
			System.out.println();
			System.out.println("Please Select A Number From The Choices...");

			userInput = input.nextInt();
			if (userInput == 1) {
				System.out.println("Please Enter The Films Id...");
				int filmId = input.nextInt();
				if (filmId <= max) {
					Film film = db.findFilmById(filmId);
					List<Actor> actors = db.findActorsByFilmId(filmId);
					film.setActors(actors);
					printFilm(film);
				} 
				
				else {
					System.out.println("This Film Id Is Outside The Range Returning To Main Menu...");
					System.out.println();
				}
				System.out.println("----------Sub Menu---------");
				System.out.println("1) Return To The Main Menu...");
				System.out.println("2) Display All Film Info...");
				System.out.println("Please Select A Number From The Choices...");
				userInputTwo = input.nextInt();
				if (userInputTwo == 1) {
				} 
				
				else {
					Film film = db.findFilmById(filmId);
					List<Actor> actors = db.findActorsByFilmId(filmId);
					film.setActors(actors);
					System.out.println(film.toString());
				}

			} 
			
			else if (userInput == 2) {
				System.out.println("Please Enter A Keyword...");
				String keyword = input.next();
				List<Film> films = db.findFilmByKeyword(keyword);
				if (films.size() == 0) {
					System.out.println("Sorry Your Keyword Does Not Match Any Films In The Database...\n");
				} 
				
				else {
					listFilmsKeyword(films);
				}
				System.out.println("Sorry, No User Choice, Back To Main Menu...");
			}

			else if (userInput == 3) {
				System.out.println("Sayonara!");
				System.out.println();
			} 
			
			else {
				System.out.println("Outside Of Choice Range...\nSelect From 1-3\n");
			}
		}

		while (userInput != 3);
		input.close();
	}

	private void printFilm(Film film) {
		System.out.println("Title: \n" + film.getTitle() + "\n\nRelease Year: \n" + film.getReleaseYear()
				+ "\n\nLanguage: \n" + film.getLanguage() + "\n\nRating: \n" + film.getRating() + "\n\nDescription: \n"
				+ film.getDescription() + "\n\nCasts Names:\n");
		listActors(film.getActors());
		System.out.println("----------------------------------------------------------------------");
		System.out.println();
	}

}
