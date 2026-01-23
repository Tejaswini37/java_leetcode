public class Codec {
    String base="http://tinyurl.com/";
    int idx=0;
    HashMap<String, String> hm=new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key=Integer.toString(idx++);
        hm.put(key,longUrl);
        return base+key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String key=shortUrl.replace(base,"");
        return hm.get(key);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));


// public class Codec {

//     Map<String, String> map = new HashMap<>();
//     String base = "http://tinyurl.com/";
//     String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//     Random rand = new Random();

//     private String getKey() {
//         StringBuilder sb = new StringBuilder();
//         for (int i = 0; i < 6; i++) {
//             sb.append(chars.charAt(rand.nextInt(chars.length())));
//         }
//         return sb.toString();
//     }

//     public String encode(String longUrl) {
//         String key = getKey();
//         while (map.containsKey(key)) {
//             key = getKey(); // avoid collision
//         }
//         map.put(key, longUrl);
//         return base + key;
//     }

//     public String decode(String shortUrl) {
//         String key = shortUrl.replace(base, "");
//         return map.get(key);
//     }
// }

