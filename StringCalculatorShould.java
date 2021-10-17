package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorShould {

    @Test
    void empty_string_should_return_0() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void string_with_single_number_should_return_number_as_int() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1, stringCalculator.add("1"));
    }
    
    @Test
    void string_with_comma_number_should_return_sum_of_number_as_int() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.add("1,2"));
    }
    
    @Test
    void string_with_newLine_number_should_return_sum_of_number_as_int() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, stringCalculator.add("1\n2,3"));
    }
    
    
    @Test
    public void  string_with_NegativeNumber(){
    	StringCalculator stringCalculator = new StringCalculator();
    	try {
    		stringCalculator.add("-1,2");
		}
		catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Negatives not allowed: -1");
		}

		try {
			stringCalculator.add("2,-4,3,-5");
		}
		catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Negatives not allowed: -4,-5");
		}
    }
    
    @Test
    public void testOverThousand(){
    	StringCalculator stringCalculator = new StringCalculator();
    	assertEquals(2, stringCalculator.add("1000,2"));
    }

    @Test
    public void testOtherDelimiter(){
    	StringCalculator stringCalculator = new StringCalculator();
    	assertEquals(3, stringCalculator.add("//;\n1;2"));
    }
    
     @Test
     public void test_any_length_Delimiter(){
     	StringCalculator stringCalculator = new StringCalculator();
     	assertEquals(6, stringCalculator.add("//[***]\n1***2***3"));
     }
    
     @Test
     public void test_multiple_delimiters(){
    	StringCalculator stringCalculator = new StringCalculator();
     	assertEquals(6, stringCalculator.add("//[*][%]\\n1*2%3"));
    }
}
