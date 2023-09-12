public class Main {
    public static void main(String[] args) {
        String string="kshitij";
        String reverse="";
        char ch;
        for(int i=0;i<string.length();i++){
            ch= string.charAt(i);
            reverse=ch + reverse;
        }
        System.out.println(reverse);
    }
}
