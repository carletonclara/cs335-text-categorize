import java.util.ArrayList;
import java.util.List;

import java.util.Map;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Categorizes words in a text string by their start character.
 *
 * @ author Bob Zwolinski
 */
public class TextCategorize implements Categorize {

  private String text;
  private Pattern startCharacter = Pattern.compile("(^[A-Za-z0-9]{1})");
  private Map<String, List<String>> categories = new HashMap<>();

  public TextCategorize(String text) {
    this.text = text;
  }

  public void categorize() {
    for (String word : text.split(" ")) {
      Matcher m = startCharacter.matcher(word);
      if (m.find()) {
        String startsWith = m.group(1).toLowerCase();
        if (categories.containsKey(startsWith)) {
          categories.get(startsWith).add(word);
        } else {
          ArrayList<String> wordsInCategory = new ArrayList<String>();
          wordsInCategory.add(word);
          categories.put(startsWith, wordsInCategory);
        }
      }
    }
  }

  public ArrayList<String> getCategories() {
    return new ArrayList<String>(categories.keySet());
  }

  public int getWordCount() {
    int wordCount = 0;
    for (String startChar : categories.keySet()) {
      wordCount += categories.get(startChar).size();
    }
    return wordCount;
  }

  public boolean hasCategories() {
    return !categories.isEmpty();
  }

  public ArrayList<String> getWordsFor(String index) {
    return (ArrayList<String>) categories.getOrDefault(index, new ArrayList<String>());
  }
}
