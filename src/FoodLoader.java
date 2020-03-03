import java.util.Scanner;
import java.io.*;

public class FoodLoader{

	private static final int maxFileLines = 100;
	
	// Bronze
	// Load the String of Food data and return a fully initialized Food object (including ingredients)
	public static Food parseString(String foodAsString){

		Food foodItem = null;

		try{
			Scanner scan = new Scanner(foodAsString);
			scan.useDelimiter(",");
			
			//Apple,120,2,2,Apple Junk,Redness 
			// cache data incoming
			String name = scan.next();
			int calories = scan.nextInt();
			int cost = scan.nextInt();

			// -- Ingredients -- (silver)
			// check number of ingredients, needed for the loop
			int numOfIngredients = scan.nextInt();

			// list of ingredients
			Ingredient[] ings = new Ingredient[numOfIngredients];
			for(int i = 0; i < numOfIngredients; i++){
				String ingName = scan.next();
				double ingAmount = scan.nextDouble();
				ings[i] = new Ingredient(ingName,ingAmount);
			}

			// Create the food item
			foodItem = new Food(name, calories, cost, ings);


		}catch(Exception e){
			System.out.println(e.toString());
			e.printStackTrace();
		}

		return foodItem; // change this to return the initialized object
	}

	// given a specified file, load it and parse each line into a Food[] type object. Be sure to handle
	// any exceptions. 
	public static Food[] loadFile(String fileName){

		// Return data
		Food[] foodList = new Food[maxFileLines];
		int count =0;

		try{
			// Open up the file reader and buffered reader
			FileReader fileReader = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fileReader);

			// read in strings, use parseString to turn into foods
			// Use an oversized array for now
			String line = br.readLine();
			while(line != null && count < maxFileLines){
				foodList[count] = parseString(line);
				count++;
				line = br.readLine();
			}

			// copy over the correct sized array. s
			Food[] newFood = new Food[count];
			for(int i =0; i < count; i++){
				newFood[i] = foodList[i];
			}

			foodList = newFood;

		}catch(Exception e){
			System.out.println(e.toString());
			e.printStackTrace();
		}

		return foodList; // return an initialized food array. 
	}

}