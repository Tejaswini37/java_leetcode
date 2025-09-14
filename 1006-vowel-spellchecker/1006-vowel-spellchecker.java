class Solution {
    public String mask(String s){
        return s.replaceAll("[aeiou]","*");
    }
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact=new HashSet<>();
        Map<String,String> caseInsensitive=new HashMap<>();
        Map<String,String> vowelMap=new HashMap<>();

        for(String w: wordlist){
            exact.add(w);
            caseInsensitive.putIfAbsent(w.toLowerCase(),w);
            String masked=mask(w.toLowerCase());
            vowelMap.putIfAbsent(masked,w);
        }

        String res[]=new String[queries.length];
        for(int i=0;i<queries.length;i++){
            String q=queries[i];
            if(exact.contains(q)) res[i]=q;
            else{
                String lower=q.toLowerCase();
                if(caseInsensitive.containsKey(lower)){
                    res[i]=caseInsensitive.get(lower);
                }
                else{
                    String masked=mask(lower);
                    res[i]=vowelMap.getOrDefault(masked,"");
                }
            }
        }
        return res;
    }
}

// 1.Exact match (case-sensitive).
// If query exists in dictionary exactly, return it.

// 2. Case-insensitive match.
// If query matches a dictionary word ignoring case, return the first such match.

//3. Vowel-error match.
// Treat all vowels (a, e, i, o, u) as interchangeable.
// Example: "LeetCode" and "l**e**etc**o**de" should match.
// Again, return the first match found in dictionary order.

// 4. If no match → return "".

// Exact words → Set<String>
// For O(1) exact lookup.

// Case-insensitive words → Map<String, String>
// Key = lowercased word
// Value = first word from dictionary.

// Vowel-masked words → Map<String, String>
// Replace all vowels with *.
// Key = lowercased + vowel-masked word
// Value = first word from dictionary.