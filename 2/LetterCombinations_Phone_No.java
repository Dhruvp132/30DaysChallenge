class Solution {
    final static char[][] L = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y','z'}};
    List<String> list = new ArrayList<>();

    public void bfs(int pos, int len, StringBuilder sb, String digit) {
        if(pos == len) {
            list.add(sb.toString());
            return;
        } else{
            char letter[] = L[Character.getNumericValue(digit.charAt(pos))];
            for(int i=0; i<letter.length; i++) {
                bfs(pos+1, len, new StringBuilder(sb).append(letter[i]), digit);
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        int length = digits.length();

        if(length == 0) {
            return list;
        }
        bfs(0, length, new StringBuilder(), digits);
        return list;
    }
}