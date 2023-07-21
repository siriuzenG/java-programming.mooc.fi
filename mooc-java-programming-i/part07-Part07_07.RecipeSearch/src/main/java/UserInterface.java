/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SAM
 */
import java.util.ArrayList;
import java.util.Scanner;
public class UserInterface {
    private ArrayList<Recipe> recipes;
    private Scanner scan;
    
    public UserInterface(Scanner scan) {
        this.scan = scan;
        this.recipes = new ArrayList<>();
    }
    
    public void start() {
        System.out.println("Commands:\n"+
                "list - lists the recipes\n"+
                "stop - stops the program\n"+
                "find name - searches recipes by name\n"+
                "find cooking time - searches recipes by cooking time\n"+
                "find ingredient - searches recipes by ingredient");
        
        while(true) {
            System.out.println("Enter command: ");
            String cmd = this.scan.nextLine();
            
            if(cmd.equals("stop")) {
                break;
            }
            
            if(cmd.equals("list")) {
                for(Recipe recipe : this.recipes) {
                    System.out.println(recipe);
                }
            }
            
            if(cmd.equals("find name")) {
                System.out.println("Searched word: ");
                String search = this.scan.nextLine();
                
                System.out.println("Recipes:");
                for(Recipe recipe : this.recipes) {
                    if(recipe.getName().contains(search)) {
                        System.out.println(recipe);
                    }
                }
            }
            
            if(cmd.equals("find cooking time")) {
                System.out.println("Max cooking time: ");
                String search = this.scan.nextLine();
                int max = Integer.valueOf(search);
                
                System.out.println("Recipes:");
                for(Recipe recipe : this.recipes) {
                    if(recipe.getTime() <= max) {
                        System.out.println(recipe);
                    }
                }
            }
            
            if(cmd.equals("find ingredient")) {
                System.out.println("Ingredient: ");
                String search = this.scan.nextLine();
                
                for(Recipe recipe : this.recipes) {
                    for(String ingredient : recipe.getIngredients()) {
                        if(ingredient.equals(search)) {
                            System.out.println(recipe);
                            break;
                        }
                    }
                }
            }
        }
    }
    
    public void getInputsFromFiles(Scanner file) {
        int idx = 0;
        int count = 0;
        while(file.hasNextLine()) {
            String input = file.nextLine();
            if(input.isEmpty()) {
                idx += 1;
                count = 0;
                continue;
            }

            if(count == 0) {
                this.recipes.add(new Recipe(input));
                count += 1;
                continue;
            }

            if(count == 1) {
                int time = Integer.valueOf(input);
                this.recipes.get(idx).setTime(time);
                count += 1;
                continue;
            }

            this.recipes.get(idx).add(input);
        }
    }
}
