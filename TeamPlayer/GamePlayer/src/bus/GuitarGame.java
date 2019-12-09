package bus;

import java.util.Scanner;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JOptionPane;

import java.util.Random;

import java.io.File;

public class GuitarGame {
	private int m1;
	private int m2;
	private long id;
	private String name;
	private Scanner inputScanner = new Scanner(System.in);
	private String playerInput;
	private Color color;
	private GuitarBrand brand;

	// private static String m1Location = "D:/TeamPlayer/TeamPlayer/GamePlayer/Musics/SecretBase.wav";
	// private static String m2Location = "D:/TeamPlayer/TeamPlayer/GamePlayer/Musics/MiracleMountain.wav";

	public long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public int getMI() {
		return this.m1;
	}

	public int getMII() {
		return this.m2;
	}

	public GuitarBrand getBrand() {
		return this.brand;
	}

	public Color getColor() {
		return this.color;
	}

	public GuitarGame() {

	}

	public void start() {
		System.out.println("You choosed Guitar Player");

		while (true) {
			System.out.println("Please input your ID (numbers only): ");
			try {
				id = Long.parseLong(inputScanner.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Your input is invalid, please try again.");
			}
		}
		System.out.println("Please input your name: ");
		name = inputScanner.nextLine();
	}

	public void run() {
		GuitarPlayer player = new GuitarPlayer();
		Random randomColor = new Random();
		Random randomBrand = new Random();

		player.setColor(Color.values()[randomColor.nextInt(Color.values().length)]);
		player.setBrand(GuitarBrand.values()[randomBrand.nextInt(GuitarBrand.values().length)]);

		color = Color.values()[randomColor.nextInt(Color.values().length)];
		brand = GuitarBrand.values()[randomBrand.nextInt(GuitarBrand.values().length)];

		while (true) {
			System.out.println("Choose a music by input the index of the music");
			System.out.println(" 1. Secret Base \n 2. Miracle Mountain");
			System.out.println("or input [back] to back to the Main Menu");
			playerInput = inputScanner.nextLine();

			if (playerInput.equals("1")) {
				m1++;

				//playMusic(m2Location);

				System.out.println("Play \"Secret Base\"");

			} else if (playerInput.equals("2")) {
				m2++;
				System.out.println("Play \"Miracle Mountain\"");
			} else if (playerInput.equals("back")) {
				break;
			} else {
				System.out.println("I don't understand");
			}
		}
	}

	public void end() {
		System.out.println("Finish!");
	}

	public static void playMusic(String location) {
		
		try {
			File musicPath = new File(location);
			if(musicPath.exists()){
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				// Clip clip = AudioSystem.getClip();
				// clip.open(audioInput);
				// clip.start();
				// clip.loop(Clip.LOOP_CONTINUOUSLY);

				AudioFormat format = audioInput.getFormat();
				DataLine.Info info = new DataLine.Info(Clip.class, format);

				Clip audioClip = (Clip)AudioSystem.getLine(info);

				audioClip.open(audioInput);
				audioClip.start();

				JOptionPane.showMessageDialog(null, "Press OK to top player");
			}
			else{
				System.out.println("Can't find file");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
