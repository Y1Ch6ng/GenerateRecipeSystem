import java.util.ArrayList;

public interface RecipeCreator {
    void setRecipeName(String name);
    void setRecipeDescription(String description);
    void setIngredients(ArrayList<Ingredient> ingredients);
}
