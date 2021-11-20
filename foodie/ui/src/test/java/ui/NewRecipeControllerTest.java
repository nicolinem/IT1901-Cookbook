package ui;


import java.io.FileNotFoundException;
import java.net.URL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ui.NewRecipeController;

public class NewRecipeControllerTest extends AbstractAppTest {

  private NewRecipeController controller;

  @FXML
  private TextField recipeTitle, recipePortions, ingredientTitle;

  @FXML
  private ListView ingredientListView;

  @Override
  public void start(final Stage stage) throws Exception {

    URL fxmlLocation = getClass().getResource("NewRecipe_test.fxml");
    FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);
    Parent root = fxmlLoader.load();
    this.controller = fxmlLoader.getController();

    Scene scene = new Scene(root);

    stage.setScene(scene);
    stage.show();
  }

  @BeforeEach
  public void setupItems() {
    setTestData();
    this.controller.initData(cookbook, dataAccess);

  }

  @Test
  public void testNewIngredient() {
    clickOn("#ingredientTitle").write("Eple");
    clickOn("#ingredientAmount").write("3");
    clickOn("#ingredientUnit").write("stk");
    clickOn("#addIngredient");
    checkIngredient(controller.getIngredients().get(0), ing1);
  }


  @Test
  public void testNewRecipe() throws FileNotFoundException {
    clickOn("#recipeTitle").write("Eple");
    clickOn("#recipePortions").write("2");
    clickOn("#ingredientTitle").write("Eple");
    clickOn("#ingredientAmount").write("3");
    clickOn("#ingredientUnit").write("stk");
    clickOn("#addIngredient");
    clickOn("#recipeDescription").write("Epler...");
    clickOn("#createRecipeButton");
    testRecipes(dataAccess.getCookbook().getRecipes(), recipe1, recipe2, recipe3, recipe4);
  }

  @Test
  public void testDeleteRecipe() throws FileNotFoundException {
    this.controller.initData(recipe4, 1, dataAccess);
    clickOn("#deleteRecipeButton");
    testRecipes(dataAccess.getCookbook().getRecipes(), recipe1, recipe2, recipe3);
  }

  // @Test
  // public void testEditRecipe() {

  // clickOn("#recipeTitle");
  // // TextField textField5 = ;
  // // assertEquals(recipe1.getName(), lookup("#recipeTitle").query());
  // recipeTitle.setText("test");
  // assertEquals(recipe4.getName(), recipeTitle.getText());
  // assertEquals(recipe4.getPortions(),
  // Integer.parseInt(recipePortions.getText()));
  // for (int i = 0; i < ingredients.size(); i++) {
  // checkIngredient((Ingredient) ingredientListView.getItems().get(i),
  // ingredients.get(i));
  // }

  // }

}
