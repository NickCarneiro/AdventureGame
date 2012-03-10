package game;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class RLetterGame extends Minigame {	
	private int word_index = 0;
	ArrayList<char[]> answerlist;
	public RLetterGame(ArrayList<Entity> entities,
			ArrayList<Entity> removeList, Engine engine) {
		super(entities, removeList, engine);

		  }
		 
	
	@Override
	public void setup(){
		
		
		Entity frame = new FrameEntity(engine,"sprites/BlueBackround.png", 0, 0);
		 entities.add(frame);
		
		Random generator = new Random();				
		Character[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'} ;				
		BufferedReader reader;		
		reader = new BufferedReader(new InputStreamReader(System.in));			
		answerlist = new ArrayList<char[]> ();		
		for (int i = 0; i < 6; i++){			
			int size = i;			
			if (i % 2==1){				
				size--;			
			}
			size = size + 5;			
			char[] answer = new char[size];			
			int position = 0;			
			while (position < size) { 									
				int a = generator.nextInt(26);					
				answer[position] = letters[a];				
				position++;							
			}
			
			//System.out.println(String.valueOf(answer));			
			answerlist.add(answer); 
		}
		
			
			
			
	}
	
	/*
	 * compare two character arrays
	 */
	private boolean compareChars(char[] answer, char[] input_chars){
		for(int i = 0; i < answer.length; i++){
			if(i >= input_chars.length){
				return false;
			}
			
			if(Character.toUpperCase(answer[i]) != Character.toUpperCase(input_chars[i])){
				return false;
			}
			
			
		}
		
		return true;
	}
	@Override 
	public void logic() {
		//create a new color
		Color color = new Color(255,255,153);
		//create text entity with color
		Entity text = new RiddleEntity(engine, 500, 50 + word_index*135, (String.valueOf(answerlist.get(word_index))), color);
		entities.add(text);
		removeList.add(text);
		
		if(engine.enterPressed == true) {
			//get user input as a string, compare against current word
			engine.enterPressed = false;
			char[] input_chars = new char[engine.keybuffer.size()];
			for(int i = 0; i < engine.keybuffer.size(); i++){
				input_chars[i] = engine.keybuffer.get(i);
			}
			String input_string = String.valueOf(input_chars).toUpperCase();
			engine.keybuffer.clear();
			
			//word is the correct string that was pregenerated
			String word = String.valueOf(answerlist.get(word_index)).toUpperCase();
			
			System.out.println(word + " : " + input_string);
			char[] answer = answerlist.get(word_index);
			System.out.println(compareChars(answer, input_chars));
			
			
			
			if(compareChars(answer, input_chars)){
				System.out.println("advancing word");
				if(word_index < 5) {
					word_index++;
					
				}
			}
		}
	}
}