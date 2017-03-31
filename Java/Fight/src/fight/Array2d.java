package fight;

public class Array2d {

    public static void main(String[] args) {

        String[] fav = new String[3];
        
        int [][]array = new int[30][50];

        fav[0] = "playing";
        fav[1] = "Eating";
        fav[2] = "Sleepig";

        for (int i = 0; i < fav.length; i++) {
            System.out.println(i + 1 + ".");
            System.out.println(fav[i]);
        }
        
        
        

    }
}
