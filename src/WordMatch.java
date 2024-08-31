public class WordMatch {
    String secret;

    public WordMatch(String x){
        secret = x;
    }

    public int scoreGuess(String check){
        if(check.length() == 0){
            throw new IllegalArgumentException("Your guess cannot be an empty String!");
        }
        if(check.length() > secret.length()){
            throw new IllegalArgumentException("Your guess cannot exceed the number of characters in the Secret word");
        }
        int cnt = 0;
        for(int i=0; i<=secret.length()-check.length(); i++){
            String substr = secret.substring(i,i+check.length());
            if(substr.equals(check)){
                cnt++;
            }
        }
        return cnt * check.length() * check.length();
    }

    public String findBetterGuess(String a, String b){
        int sgA = scoreGuess(a);
        int sgB = scoreGuess(b);
        if(sgA > sgB){
            return a;
        }
        if(sgB > sgA){
            return b;
        }
        int compare = a.compareTo(b);
        if(compare < 0) return b;
        return a;
    }
}
