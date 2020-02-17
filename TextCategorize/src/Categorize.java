import java.util.ArrayList;

interface Categorize {

  /**
   * Process the text and build a map of startCharacter to words that start with that character.
   */
  void categorize();

  /**
   * @return a list of all categories.
   */
  ArrayList<String> getCategories();

  /**
   * @return the total number of words across all categories.
   */
  int getWordCount();

  /**
   * @return list of words for index or empty list if index not found.
   */
  ArrayList<String> getWordsFor(String index);
}
