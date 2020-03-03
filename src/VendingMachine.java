
public class VendingMachine{
      // A2 Bronze - Instance
      private Food[][] foods;

      // A3 Bronze - Static
      // 5 rows of 4 items each is 20 total 
      private static int maxFoods_rows = 5;
      private static int maxFoods_cols = 4;

      public VendingMachine(){
            // Create a new 2d array for Food in the vending machine. 
            foods = new Food[maxFoods_rows][maxFoods_cols]; 
      }

      // Return the count of all valid food objects in the machine. 
      public int count(){
            int count = 0;
            for(int i = 0; i < foods.length; i++){
                  for(int j = 0; j < foods[i].length; j++){
                        if( foods[i][j] != null){
                              count++;
                        }
                  }
            }
            return count;
      }

      // returns the size of the current array, or 0 if it is null
      public int size(){
            if(foods == null || foods[0] == null )
                  return 0;
            else
                  return foods.length * foods[0].length;
      }

      // Add food to the array at a given index if it is valid and not already assigned
      // Return true if you added the new food successfully and false otherwise. 
      // Silver
      public boolean addFood(Food newFood, int index){
            
            // // [] internally edit to add to the correct spot in the 2d array even though it was passed in as an int value. 

            boolean returnVal = false;
            // if spot is valid, and empty, add the food and return true
            int col = getCol(index); 
            int row = getRow(index); 
            // otherwise return false. 
            if(col >= 0 && col < maxFoods_cols && row >= 0 && row < maxFoods_rows ){
                  if(foods[row][col] == null){
                        foods[row][col] = newFood;
                        returnVal = true; // was added. 
                  }
            }
            return returnVal;
      }

      // Add food to the array at a given index if it is valid and not already assigned
      // Return true if you added the new food successfully and false otherwise. 
      public boolean addFood(Food newFood, int row, int col){
            boolean returnVal = false;
            // if spot is valid, and empty, add the food and return true
            // otherwise return false. 
            // Check against max index size of the array
            if(row < maxFoods_rows && col < maxFoods_cols && row >= 0 && col >= 0 ){
                  if(foods[row][col] == null){
                        foods[row][col] = newFood;
                        returnVal = true; // was added. 
                  }
            }
            return returnVal;
      }

      // Useful utility methods for Silver
      public int rowsColsToIndex(int row, int col){
            int index = row * maxFoods_cols + col ;
            return index;
      }

      // Find the Row as given by the index
      public int getRow(int index){
            return index / maxFoods_cols;
      }

      // Find the Col as given by the index
      public int getCol(int index){
            return index % maxFoods_cols;
      }

      // To String for the Vending Machine - prints out all foods including the index of the array they are stored in. 
      public String toString(){
            String st = "Vending Machine Interface:";
            st += "\nContains: " + count() + " Food Items";
            for(int i = 0; i < foods.length; i++){
                  for(int j = 0; j < foods[i].length; j++){
                        st += "\nItem [" + i + "," + j + "] at index " + rowsColsToIndex(i,j) + " is " ;
                        if( foods[i][j] != null){
                              st += foods[i][j].toString();
                        }else{
                              st += "Empty";
                        }
                  }
            }
            return st;
      } 
}
