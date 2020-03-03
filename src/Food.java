
public class Food{
  
  // basic info
  private String name;
  // related to nutrition
  private int weight;
  private int calories;
   
  private int protein;
  private int fat;
  private int carbs;

  private int sugar;
  private double fibre;

  private static int totalCount; // total amount of Food objects Created
   
   
   // Constructor
   public Food(String newName,int weight, int newCalories,int protein, int carbs, int sugar, double fibre, int fat){
       // basic info
       name = newName;
       // related to nutrition
       calories = newCalories;

       this.weight = weight;
       this.carbs = carbs;
       this.fat = fat;
       this.protein = protein;
       this.sugar = sugar;
       this.fibre = fibre;
       
       totalCount++;
    }
    
    public String toString(){
        return "Name: " + name + " Calories: " + calories + " Protein: " + protein + " Carbs: " + carbs + " Fat: " + fat;
    }

    
    public static int getCount(){
        return totalCount;
    }
}
