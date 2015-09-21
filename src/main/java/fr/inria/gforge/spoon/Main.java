package fr.inria.gforge.spoon;

import spoon.Launcher;

public class Main {
	public static void main(String[] args) {
		new Launcher().run(new String[] {
				"-i", "./src/main/java",
				"-o", "./target/spoon",
				"-p", "fr.inria.gforge.spoon.processors.ClassProcessor"
		});
	}
}
