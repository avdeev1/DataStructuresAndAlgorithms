package Algoritms;

import java.util.*;

public class HaffmanDecoding {
    public static void main(String[] args) {
        new HaffmanDecoding().run();
    }

    private void run() {
        int k;
        int l;
        Scanner scanner = new Scanner(System.in);
        k = scanner.nextInt(); // letters count
        l = scanner.nextInt(); // str.length


        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            String letter = scanner.next();
            String code = scanner.next();
            map.put(code, letter.substring(0,1));
        }


        String encode = scanner.next();

        StringBuilder decode = new StringBuilder("");

        StringBuilder curr = new StringBuilder("");

        List<String> list = new ArrayList<>();//Arrays.asList(encode.split(""));

        for (int i = 0; i < encode.length(); i++) {
            String str = encode.substring(i, i+1);
            list.add(str);
        }


        while (!list.isEmpty()) {
            curr.append(list.get(0));
            list.remove(0);
            String key = new String(curr);
            if (map.containsKey(key)) {
                decode.append(map.get(key));
                curr = new StringBuilder("");
            }
        }
        System.out.println(decode);
    }
}
