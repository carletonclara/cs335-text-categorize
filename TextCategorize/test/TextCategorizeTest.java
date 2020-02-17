import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import static org.junit.jupiter.api.Assertions.<your-assert-here>

class TextCategorizeTest {

  // Input string for TextCategorize. Do not change!
  private String text = "The frisky rabbit ran rapidly away and avoided the hungry fox.";
  private TextCategorize tc;

  @BeforeEach
  void setUp() {
    tc = new TextCategorize(text);
  } //Instantiates object

  /**
  *Tests that categories are added only after completing the function
   */
  @Test
  void testCategorize() {
    assertFalse(tc.hasCategories());
    tc.categorize();
    assertTrue(tc.hasCategories());
  }

  /**
   *Tests that the correct categories are added and retained to the list
   */

  @Test
  void testGetCategories() {
    ArrayList<String> expected = new ArrayList<>(Arrays.asList("a", "r", "t", "f", "h"));
    assertEquals(0, tc.getCategories().size());
    tc.categorize();

    assertEquals(expected, tc.getCategories());
  }

  /**
  *Tests that words are only added to list after being categorized
   */
  @Test
  void testGetWordCount() {
    assertEquals(0, tc.getWordCount());
    tc.categorize();
    assertEquals(11, tc.getWordCount());
  }

  /**
  *Tests the correct words are indexed for particular key
   */
  @Test
  void testGetWordsFor() {
    ArrayList<String> expected = new ArrayList<>(Arrays.asList("away", "and", "avoided"));
    assertEquals(0, tc.getWordsFor("a").size());
    tc.categorize();

    assertEquals(3, tc.getWordsFor("a").size());
    assertEquals(expected, tc.getWordsFor("a"));
  }
}