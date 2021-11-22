package foodie.restapi;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import core.Cookbook;
import core.Recipe;

/**
 * Unit test for CookbookController
 */
class CookbookControllerTest {

  private CookbookController controller;

  @BeforeEach
  void setUp() {
    try {
      controller = new CookbookController();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  void testGetCookbook() {
    Cookbook cookbook = controller.getCookbook();
    assertNotNull(cookbook, "Cookbook was null");
  }

  @Test
  void testAddRecipe() {
    assertTrue("addRecipe-method did not return true", controller.addRecipe("recipe", new Recipe("recipe", 1)));
  }

  @Test
  void testEditRecipe() {
    controller.addRecipe("recipe", new Recipe("recipe", 1));
    assertTrue("editRecipe-method did not return true", controller.editRecipe("recipe", new Recipe("recipe", 2)));
  }

  @Test
  void testRemoveRecipe() {
    controller.addRecipe("recipe", new Recipe("recipe", 1));
    assertTrue("removeRecipe-method did not return true", controller.removeRecipe("recipe"));
  }

}
