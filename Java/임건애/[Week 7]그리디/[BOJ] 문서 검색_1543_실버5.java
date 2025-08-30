import java.util.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String sentence = br.readLine();
		String word = br.readLine();
		
		String replace = sentence.replaceAll(word, "1");
		
// 		System.out.println(replace);

        int result = 0;
        
        for (int i = 0; i < replace.length(); i++) {
            if (replace.charAt(i) == '1') {
                result++;
            }
        }
        
        System.out.println(result);

	}
	
}