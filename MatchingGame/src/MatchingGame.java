import java.io.File;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

public class MatchingGame {
	// Congratulations message
	private final static String CONGRA_MSG = "CONGRATULATIONS! YOU WON!";
	// Cards not matched message
	private final static String NOT_MATCHED = "CARDS NOT MATCHED. Try again!";
	// Cards matched message
	private final static String MATCHED = "CARDS MATCHED! Good Job!";
	// 2D-array which stores cards coordinates on the window display
	private final static float[][] CARDS_COORDINATES =
			new float[][] {{170, 170}, {324, 170}, {478, 170}, {632, 170},{170, 324}, {324, 324}, {478, 324}, {632, 324},
						   {170, 478}, {324, 478}, {478, 478}, {632, 478}};
						   // Array that stores the card images filenames
	private final static String[] CARD_IMAGES_NAMES = new String[] {"apple.png",
			"ball.png", "peach.png", "redFlower.png", "shark.png", "yellowFlower.png"};
	private static PApplet processing; // PApplet object that represents
	 								// the graphic display window
	private static Card[] cards; // one dimensional array of cards
	private static PImage[] images; // array of images of the different cards
	private static Random randGen; // generator of random numbers
	private static Card selectedCard1; // First selected card
	private static Card selectedCard2; // Second selected card
	private static boolean winner; // boolean evaluated true if the game is won,
								// and false otherwise
	private static int matchedCardsCount; // number of cards matched so far
										// in one session of the game
	private static String message; // Displayed message to the display window
	
	/**
	 * Defines the initial environment properties of this game as the program starts
	 */
	public static void setup(PApplet processing) {
		MatchingGame.processing = processing;
		images = new PImage[CARD_IMAGES_NAMES.length];
		//load apple.png image file as PImage object and store its reference into images[0]
		images[0] = processing.loadImage("images" + File.separator + CARD_IMAGES_NAMES[0]);
		images[1] = processing.loadImage("images" + File.separator + CARD_IMAGES_NAMES[1]);
		images[2] = processing.loadImage("images" + File.separator + CARD_IMAGES_NAMES[2]);
		images[3] = processing.loadImage("images" + File.separator + CARD_IMAGES_NAMES[3]);
		images[4] = processing.loadImage("images" + File.separator + CARD_IMAGES_NAMES[4]);
		images[5] = processing.loadImage("images" + File.separator + CARD_IMAGES_NAMES[5]);
      	initGame();
	}
	
	/**
	 * Initializes the game
	 */
	public static void initGame() {
		randGen = new Random(Utility.getSeed());
		selectedCard1 = null;
		selectedCard2 = null;
		matchedCardsCount = 0;
		winner = false;
		message = "";
		cards = new Card[CARD_IMAGES_NAMES.length * 2];
		randGen = new Random();
		PImage[] indexArray = new PImage[12];
		for(int i = 0; i <= 11; i+=2) {
			indexArray[i] = images[i/2];
			indexArray[i+1] = images[i/2];
		}
		int n = indexArray.length;
		for (int i = 0; i < indexArray.length; i++) {
			int randomValue = i + randGen.nextInt(n - i);
			PImage randomElement = indexArray[randomValue];
            indexArray[randomValue] = indexArray[i];
            indexArray[i] = randomElement;
		}
		for(int i = 0; i < 12; i++) {
			cards[i] = new Card(indexArray[i], CARDS_COORDINATES[i][0], CARDS_COORDINATES[i][1]);
		}
		
	}
	
	/**
	 * Callback method called each time the user presses a key
	 */
	public static void keyPressed() {
		if(processing.key =='n'||processing.key == 'N') {
			initGame();
		}
	}
	
	/**
	 * Callback method draws continuously this application window display
	 */
	public static void draw() {
		processing.background(245, 255, 250); // Mint cream color
		for(int i = 0; i < 12; i++) {
			cards[i].draw();
		}
		displayMessage(message);
	}
	
	/**
	 * Displays a given message to the display window
	 * @param  message to be displayed to the display window
	 */
	public static void displayMessage(String message) {
		processing.fill(0);
		processing.textSize(20);
		processing.text(message, processing.width / 2, 50);
		processing.textSize(12);
	}
	
	/**
	 * Checks whether the mouse is over a given Card
	 * @return true if the mouse is over the storage list, false otherwise
	 */
	public static boolean isMouseOver(Card card) { 
		double top = card.getY() + card.getHeight()/2;
		double bottom = card.getY() - card.getHeight()/2;
		double left = card.getX() - card.getWidth()/2;
		double right = card.getX() + card.getWidth()/2;
		if(processing.mouseY < top && processing.mouseY > bottom && processing.mouseX < right && processing.mouseX > left) {
			return true;
		} 
		return false;
	}
	
	/**
	 * Callback method called each time the user presses the mouse
	 */
	public static void mousePressed() {
		if(selectedCard2 != null) {
			if(matchingCards(selectedCard1, selectedCard2) == false) {
				selectedCard1.setVisible(false);
				selectedCard2.setVisible(false);
			}
			selectedCard1.deselect();
			selectedCard2.deselect();
			selectedCard1 = null;
			selectedCard2 = null;
			message = "";
		}
		for(int i = 0; i < 12; i++) {
			if(isMouseOver(cards[i]) == true && cards[i].isVisible() == false) {
				if(selectedCard1 == null) {
					selectedCard1 = cards[i];
					selectedCard1.setVisible(true);
					selectedCard1.select();
				} else {
					if(cards[i] != selectedCard1) {
						selectedCard2 = cards[i];
						if(matchingCards(selectedCard1, selectedCard2) == true) {
							selectedCard2.setVisible(true);
							selectedCard2.select();
							message = MATCHED;
						} else {
							selectedCard2.setVisible(true);
							selectedCard2.select();
							message = NOT_MATCHED;
						}
					}	
					}
			}
		}
		for(int i = 0; i < 12; i++) {
			if(cards[i].isVisible() == false) {
				break;
			} else {
				if(i != 11) {
					continue;
				}
				message = CONGRA_MSG;
			}
			
		}
		
	}
	
	/**
	 * Checks whether two cards match or not
	 * @param card1 reference to the first card
	 * @param card2 reference to the second car
	 * @return true if card1 and card2 image references are the same, false otherwise
	 */
	public static boolean matchingCards(Card card1, Card card2) {
		if(card1.getImage() == card2.getImage()) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
	Utility.runApplication();

	}

}
