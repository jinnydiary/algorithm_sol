import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	static class Word implements Comparable<Word> {
		String word;
		
		public Word(String word) {
			this.word = word;
		}

		@Override
		public int compareTo(Word w) {
			int len = this.word.length() - w.word.length();
			if(len != 0) return len;
			else {
				return this.word.compareTo(w.word);
			}
		}
	}
	
	static ArrayList<Word> words;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		words = new ArrayList<>();
		for(int n = 0; n < N; ++n) {
			String word = br.readLine();
			if(checkWord(word)) words.add(new Word(word));
		}

		Collections.sort(words);
		
		for(int n = 0; n < words.size(); ++n)
			sb.append(words.get(n).word + "\n");
		System.out.print(sb.substring(0, sb.length()-1));
	}

	private static boolean checkWord(String word) {
		for(int n = 0; n < words.size(); ++n) {
			if(words.get(n).word.equals(word))
				return false;
		}
		return true;
	}

}
