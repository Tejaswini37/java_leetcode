// class Solution {
//     public String makeLargestSpecial(String s) {
        
//     }
// }
// import java.util.*;

class Solution {

    public String makeLargestSpecial(String s) {
        List<String> parts = new ArrayList<>();
        int count = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '1') {
                count++;
            } else {
                count--;
            }

            // When balanced, we found one special substring
            if (count == 0) {
                // Recursively solve inside part
                String inner = s.substring(start + 1, i);
                String processed = makeLargestSpecial(inner);

                parts.add("1" + processed + "0");
                start = i + 1;
            }
        }

        // Sort in descending order to make largest string
        Collections.sort(parts, Collections.reverseOrder());

        // Join everything
        StringBuilder result = new StringBuilder();
        for (String part : parts) {
            result.append(part);
        }

        return result.toString();
    }
}