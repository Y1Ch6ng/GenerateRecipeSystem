import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Recipe recipe = new Recipe() {
            @Override
            public void setRecipeDescription(String description) {

            }
        };

        System.out.println("Welcome to the Recipe Generator!");
        System.out.println("Enter recipe name you want.");
        System.out.println("Examples: Pasta, Salad, Cake");
        System.out.println();

        // Set recipe name
        System.out.print("Enter recipe name: ");
        String name = scanner.nextLine();
        recipe.setRecipeName(name);

        // Auto-generate ingredients based on the recipe name
        generateIngredientsForRecipe(recipe, name);

        // Print the recipe
        System.out.println("\nRecipe Details:");
        recipe.printRecipe();

        // Option to add an ingredient
        System.out.print("\nDo you want to add an ingredient? (yes/no): ");
        String addOption = scanner.nextLine();
        if (addOption.equalsIgnoreCase("yes")) {
            System.out.print("Enter ingredient name: ");
            String ingredientName = scanner.nextLine();
            System.out.print("Enter quantity: ");
            double quantity = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter unit (e.g., grams, liters): ");
            String unit = scanner.nextLine();
            Ingredient newIngredient = new Ingredient(ingredientName, quantity, unit);
            recipe.addIngredient(newIngredient);

            System.out.println("\nUpdated Recipe:");
            recipe.printRecipe();
        }

        // Option to delete an ingredient
        System.out.print("\nDo you want to delete an ingredient? (yes/no): ");
        String deleteOption = scanner.nextLine();
        if (deleteOption.equalsIgnoreCase("yes")) {
            System.out.print("Enter the name of the ingredient to delete: ");
            String ingredientNameToDelete = scanner.nextLine();
            Ingredient ingredientToDelete = findIngredientByName(recipe, ingredientNameToDelete);
            if (ingredientToDelete != null) {
                recipe.deleteIngredient(ingredientToDelete);
            } else {
                System.out.println("Ingredient not found.");
            }

            System.out.println("\nUpdated Recipe:");
            recipe.printRecipe();
        }

        // Option to scale the recipe
        System.out.print("\nDo you want to scale the recipe? (yes/no): ");
        String scaleOption = scanner.nextLine();
        if (scaleOption.equalsIgnoreCase("yes")) {
            System.out.print("Enter scaling factor (e.g., 2 for double): ");
            double scaleFactor = scanner.nextDouble();
            recipe.scaleRecipe(scaleFactor);

            System.out.println("\nScaled Recipe:");
            recipe.printRecipe();
        }

        // Option to clear the recipe
        System.out.print("\nDo you want to clear the recipe? (yes/no): ");
        String clearOption = scanner.next();
        if (clearOption.equalsIgnoreCase("yes")) {
            recipe.clearRecipe();
            System.out.println("\nRecipe cleared.");
        } else {
            // Show the recipe if the user decides not to clear it
            System.out.println("\nRecipe Details After Skipping Clear:");
            recipe.printRecipe();
        }

        scanner.close();
    }

    // Method to find an ingredient by its name in the recipe
    public static Ingredient findIngredientByName(Recipe recipe, String name) {
        for (Ingredient ingredient : recipe.getIngredients()) {
            if (ingredient.getName().equalsIgnoreCase(name)) {
                return ingredient;
            }
        }
        return null;
    }

    // Auto-generate ingredients based on the recipe name
    public static void generateIngredientsForRecipe(Recipe recipe, String name) {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        switch (name.toLowerCase()) {
            case "pasta":
                ingredients.add(new Ingredient("Pasta", 200, "grams"));
                ingredients.add(new Ingredient("Tomato Sauce", 100, "grams"));
                ingredients.add(new Ingredient("Cheese", 50, "grams"));
                break;
            case "salad":
                ingredients.add(new Ingredient("Lettuce", 100, "grams"));
                ingredients.add(new Ingredient("Tomato", 2, "units"));
                ingredients.add(new Ingredient("Cucumber", 1, "unit"));
                break;
            case "cake":
                ingredients.add(new Ingredient("Flour", 250, "grams"));
                ingredients.add(new Ingredient("Sugar", 100, "grams"));
                ingredients.add(new Ingredient("Eggs", 2, "units"));
                break;
            case "burger":
                ingredients.add(new Ingredient("Burger Bread", 1, "units"));
                ingredients.add(new Ingredient("Meat", 2, "units"));
                ingredients.add(new Ingredient("Eggs", 1, "units"));
                ingredients.add(new Ingredient("Onion", 0.25, "units"));
                break;
            case "chicken":
                ingredients.add(new Ingredient("Chicken", 1, "units"));
                ingredients.add(new Ingredient("Salt", 100, "grams"));
                ingredients.add(new Ingredient("Paper", 250, "grams"));
                ingredients.add(new Ingredient("Onion", 1, "units"));
                break;
            case "fried rice":
                ingredients.add(new Ingredient("Rice", 1, "bowls"));
                ingredients.add(new Ingredient("Meat", 300, "grams"));
                ingredients.add(new Ingredient("Eggs", 2, "units"));
                ingredients.add(new Ingredient("Onion", 0.5, "units"));
                ingredients.add(new Ingredient("vegetable", 200, "grams"));
                break;
            default:
                generateRandomIngredients(ingredients);
                break;
        }
        recipe.setIngredients(ingredients);
    }

    // Generate random ingredients
    public static void generateRandomIngredients(ArrayList<Ingredient> ingredients) {
        String[] possibleIngredients = {"Salt", "Butter", "Milk", "Flour", "Oil", "Pepper", "Garlic"};
        String[] units = {"grams", "liters", "tablespoons", "teaspoons"};

        Random random = new Random();
        int numberOfIngredients = 3 + random.nextInt(3); // Generate 3 to 5 ingredients

        for (int i = 0; i < numberOfIngredients; i++) {
            String ingredientName = possibleIngredients[random.nextInt(possibleIngredients.length)];
            double quantity = 50 + random.nextInt(150); // Generate quantity between 50 and 200
            String unit = units[random.nextInt(units.length)];
            ingredients.add(new Ingredient(ingredientName, quantity, unit));
        }
    }
}
