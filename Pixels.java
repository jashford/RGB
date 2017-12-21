import java.awt.*;
import jm.util.*;
import jm.music.*;
import jm.music.data.*;
import jm.JMC;
import jm.music.data.Note;
import jm.util.Play;

public class Pixels implements JMC {
	public static void main(String[] args) {
		
		//makes an instance of the tool, reads in a file, and displays the image
		ImageTool imTool = new ImageTool();
		Image image = imTool.readImageFile("C:\\Users\\Jack\\Pictures\\stadia-ii-2004.jpg");
		imTool.showImage(image, "Stadia-ii-2004");
		
		//sets up a for loop to create a 3D array to fill in with notes that can be matched with RGB values
		int[][][] pixels = imTool.imageToPixels(image);
			double avg = 0;
			for(int i = 0; i < pixels.length; i++) {
				for(int j = 0; j < pixels[0].length; j++) {
		
						//sets up different channels that correspond with the piano, violin, and saxophone
						Part pianoPart = new Part("Piano", PIANO, 0);
						Part violinPart = new Part("Violin", VIOLIN, 1);
						Part saxophonePart = new Part("Saxophone", SAXOPHONE, 2);
						
						//sets up an integer array for the different note values for each instrument
						int[] pianoPitches = {C4, D4, G4, E4, A4};
						int[] violinPitches = {A4, G4, E4, D4, C4};
						int[] saxophonePitches = {G4, A4, D4, C4, E4};
						
						//sets up an integer array of whole notes that will correspond with each note value
						double[] durations = {SN, EN, QN, HN, WN};
						
						//creates unique musical meters for each respective instrument
						Phrase pianoPhrase = new Phrase(0.0);
						Phrase violinPhrase = new Phrase(0.0);
						Phrase saxophonePhrase = new Phrase(0.0);
			
			//sets up a for loop to create a note that will correspond to a note value in the integer arrays above
						//the red intensity will correspond with piano notes
						//the green intensity will correspond with violin notes
						//the blue intensity will correspond with saxophone notes
						
				for(int m = 0; m < pianoPitches.length; m++) {
						pianoPhrase.addNote(new Note(pianoPitches[m], durations[m]));
						violinPhrase.addNote(new Note(violinPitches[m], durations[m]));
						saxophonePhrase.addNote(new Note(saxophonePitches[m], durations[m]));
						
						//if statements that check the intensity of the individual RGB values in relation to the range of the note values
						//if the intensity is in the range of 0-52, its going to play C4, A4, G4, in SN
						if(0 < avg && avg < 52) {
						pianoPhrase.addNote(new Note(pianoPitches[0], durations[0]));
						violinPhrase.addNote(new Note(violinPitches[0], durations[0]));
						saxophonePhrase.addNote(new Note(saxophonePitches[0], durations[0]));
						}
						
						//if the intensity is in the range of 53-104, its going to play D4, G4, A4, in EN
						if(53 < avg && avg < 104) {
						pianoPhrase.addNote(new Note(pianoPitches[1], durations[1]));
						violinPhrase.addNote(new Note(violinPitches[1], durations[1]));
						saxophonePhrase.addNote(new Note(saxophonePitches[1], durations[1]));
						}
						
						//if the intensity is in the range of 105-155, its going to play G4, E4, D4, in QN
						if(105 < avg && avg < 155) {
						pianoPhrase.addNote(new Note(pianoPitches[2], durations[2]));
						violinPhrase.addNote(new Note(violinPitches[2], durations[2]));
						saxophonePhrase.addNote(new Note(saxophonePitches[2], durations[2]));
						}
						
						//if the intensity is in the range of 156-207, its going to play E4, D4, C4, in HN
						if(156 < avg && avg < 207) {
						pianoPhrase.addNote(new Note(pianoPitches[3], durations[3]));
						violinPhrase.addNote(new Note(violinPitches[3], durations[3]));
						saxophonePhrase.addNote(new Note(saxophonePitches[3], durations[3]));
						}
						
						//if the intensity is in the range of 208-255, its going to play A4, C4, E4, in WN
						if(208 < avg && avg < 255) {
						pianoPhrase.addNote(new Note(pianoPitches[4], durations[4]));
						violinPhrase.addNote(new Note(violinPitches[4], durations[4]));
						saxophonePhrase.addNote(new Note(saxophonePitches[4], durations[4]));
						}
			
						pianoPart.addPhrase(pianoPhrase);
						violinPart.addPhrase(violinPhrase);
						saxophonePart.addPhrase(saxophonePhrase);
						 
						//simultaneously creates and plays the different instruments based on the RGB values printed
						Score newScore = new Score();
						newScore.addPart(pianoPart);
						newScore.addPart(violinPart);
						newScore.addPart(saxophonePart);
						 
						Play.midi(newScore);
				
						//displays the pixel number, transparency, and the RGB for each pixel
						System.out.println("Pixel Number - " + (i++) + " ");
						System.out.println("Transparency: " + pixels[i][j][0]);
						System.out.println("Red Intensity: " + pixels[i][j][1]); 
						System.out.println("Green Intensity: " + pixels[i][j][2]);
						System.out.println("Blue Intensity: " + pixels[i][j][3]);
						System.out.println();
						 
			 }
		 }
	  }
	}
  }