 
public class TestLabs{
	// name,calories,cost,number of ingredients, list of ingredients (might change length). 
	private static String[] testData = {"Apple,120,2,2,Apple Junk,0.5,Redness,.5", 
				"Banana,180,1,3,Banana Mush,.3,Banana Skin,.4,Yellow Food Coloring,.3"};

	private static String file = "Nutrient Value of Some Common Foods - 2008 Edition Cleaned.csv";

 	public static void main(String[] args){

 		testLab7_bronze();

 		/*
		// Run tests of individual objects
		testLab1();
		testLab2();
		testLab3();
		testLab3_Silver();
		*/
	}

	public static void testLab7_bronze(){
		// String parsing

		// Parse String
		System.out.println("\nLab 7 - Bronze");

		Food[] foods = FoodLoader.loadFile(file);

		for(int i = 0; i < foods.length; i++){
			if(foods[i] != null)
				System.out.println(foods[i].toString());
		}
		
	}

}