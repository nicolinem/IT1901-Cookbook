package foodie.restapi;

import org.springframework.stereotype.Service;
import core.Recipe;
import json.CookbookPersistence;
import core.Cookbook;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

@Service
public class CookbookService {

  private Cookbook cookbook;
  private CookbookPersistence cookbookPersistence;
  public static final String COOKBOOK_SERVICE_PATH = "/cookbook";

  /**
   * Initializes the service with a specific cookbook.
   *
   * @param cookbook
   */
  public CookbookService(Cookbook cookbook) {
    this.cookbook = cookbook;
    this.cookbookPersistence = new CookbookPersistence();
    cookbookPersistence.setSaveFile("springbootserver-cookbook.json");
  }

  public CookbookService() {
    this(createDefaultCookbook());
  }

  public Cookbook getCookbook() {
    return this.cookbook;
  }

  public void setCookbook(Cookbook cookbook) {
    this.cookbook = cookbook;
  }

  /**
   * Creates a default cookbook. Often used for testing.
   */

  public static Cookbook createDefaultCookbook() {
    CookbookPersistence cookbookPersistence = new CookbookPersistence();
    try (Reader reader = new FileReader(
        new File(System.getProperty("user.dir") + File.separator + ("default-cookbook.json")),
        StandardCharsets.UTF_8)) {
      return cookbookPersistence.readCookbook(reader);
    } catch (IOException e) {
      System.out.println("Couldn't read default-cookbook.json, so rigging cookbook manually (" + e + ")");
    }
    Cookbook cookbook = new Cookbook();
    cookbook.addRecipe(new Recipe("recipe1", 1));
    cookbook.addRecipe(new Recipe("recipe2", 2));
    return cookbook;
  }

  public void autoSaveCookbook() {
    if (cookbookPersistence != null) {
      try {
        cookbookPersistence.saveCookbook(this.cookbook);
      } catch (IllegalStateException | IOException e) {
        System.err.println("Couldn't auto-save cookbook: " + e);
      }
    }
  }
  /*
   * public Recipe getRecipe(String name) { return
   * cookbook.getRecipes().stream().filter(r ->
   * r.getName().equals(name)).findFirst() .orElseThrow(() -> new
   * IllegalArgumentException("No recipe named " + name));
   * 
   * }
   */

  public void addRecipe(Recipe recipe) {
    cookbook.addRecipe(recipe);
    autoSaveCookbook();
  }
  /*
   * public void renameRecipe(String name, String newName) { Recipe res =
   * cookbook.getRecipes().stream().filter(r ->
   * r.getName().equals(name)).findFirst() .orElseThrow(() -> new
   * IllegalArgumentException("No recipe named \"" + name + "\""));
   * 
   * res.setName(newName); autoSaveCookbook(); }
   */

  public void removeRecipe(String name) {
    cookbook.removeRecipe(name);
    autoSaveCookbook();
  }

}
