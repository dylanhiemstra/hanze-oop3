package week4;

public class Hex2Dec {
    public static void main(String[] args) {
        try {
            System.out.println(new Hex2Dec().hex2dec("FF"));
        } catch (NumberFormatException e) {
            System.out.println("Invalid hex!");
        }
    }

    public int hex2dec(String hex) {
        char[] chars = hex.toCharArray();

        int total = 0;
        int index = chars.length;
        int intValue;

        for(char c : chars) {
            int ascii = c;
            if(ascii == 0) break;

            if(ascii >= 48 && ascii <= 57) {
                intValue = Integer.parseInt(String.valueOf(c));
            } else if (ascii >= 65 && ascii <= 70) {
                intValue = Integer.parseInt(String.valueOf(ascii - 55));
            } else {
                throw new NumberFormatException();
            }

            total += (int) (intValue * Math.pow(16, index-1));
            index--;
        }

        return total;
    }
}
