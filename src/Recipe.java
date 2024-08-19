import java.util.ArrayList;

public class Recipe {
    private String name;
    private String description;
    private ArrayList<Ingredient> ingredients;

    public Recipe() {
        this.ingredients = new ArrayList<>();
    }

    public void setRecipeName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
        System.out.println("Ingredient added: " + ingredient.getName());
    }

    public void deleteIngredient(Ingredient ingredient) {
        if (ingredients.remove(ingredient)) {
            System.out.println("Ingredient removed: " + ingredient.getName());
        } else {
            System.out.println("Ingredient not found: " + ingredient.getName());
        }
    }

    public void scaleRecipe(double scaleFactor) {
        for (Ingredient ingredient : ingredients) {
            ingredient.setQuantity(ingredient.getQuantity() * scaleFactor);
        }
    }

    public void clearRecipe() {
        ingredients.clear();
        System.out.println("All ingredients have been cleared from the recipe.");
    }

    public void printRecipe() {
        System.out.println("Recipe Name: " + name);
        System.out.println("Description: " + (description != null ? description : "No description available"));
        System.out.println("Ingredients:");
        for (Ingredient ingredient : ingredients) {
            System.out.println(ingredient.getName() + ": " + ingredient.getQuantity() + " " + ingredient.getUnit());
        }
    }
}
