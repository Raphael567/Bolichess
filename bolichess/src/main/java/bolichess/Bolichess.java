package bolichess;

import bolichess.models.Tabuleiro;
import bolichess.ui.ConsoleUI;
import org.springframework.boot.SpringApplication;

import java.util.Scanner;

public class Bolichess {

	public static void main(String[] args) {
        new ConsoleUI().iniciar();
	}
}
