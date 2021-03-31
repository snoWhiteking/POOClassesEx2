public class Game {
    public static void main(String[] args) throws InterruptedException {

        Character hunter = new Character("Ace", 10, 0, 0, "default");
        Character sleepy = new Character("Sleepy", 2, 0, 8, "sleepy");
        Character hungry = new Character("Hungry", 3, 7, 0, "hungry");

        while(true) {
            hunter.play();
            System.out.println(" ");
            sleepy.play();
            System.out.println(" ");
            hungry.play();
            System.out.println("===============================");
            Thread.sleep(6000);
        }
    }
}
