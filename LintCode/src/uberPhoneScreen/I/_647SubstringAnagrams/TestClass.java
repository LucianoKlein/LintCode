package uberPhoneScreen.I._647SubstringAnagrams;

import org.junit.Test;

public class TestClass {
	@Test
	public void test() {
		String s = "abab";
		String p = "ab";
		Solution solut = new Solution();
		System.out.println(solut.findAnagrams(s, p));
		
	}
}
