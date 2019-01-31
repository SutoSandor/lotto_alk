package lotto2;
public class Lotto2 {
    public static void main(String[] args) {
           
        
           Lotto otoslotto = new Lotto(90,5);
           Lotto hatoslotto = new Lotto(45,6);
           Lotto skandinavlotto = new Lotto(35,7);
           lottFelulet felulet = new lottFelulet(otoslotto);
           otoslotto.sorsol();
           System.out.println(otoslotto);

    }
    
}
