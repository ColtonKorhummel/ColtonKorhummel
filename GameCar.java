import java.util.Scanner;
public class GameCar {
    private String myColor;
    private String Make;
    private int Position;


    public GameCar(){

    }
    public GameCar(String car, String color, int pos){
        Make = car;
        myColor = color;
        Position = pos;
    }
    public String toString(){
        return ("Car Information: " + Make + " ("+ myColor +"), Current Position: " + Position);
    }
    public void setColor(String color){
        myColor = color;
    }
    public void setCar(String car, String color, int pos){
        Make = car;
        myColor = color;
        Position = pos;
    }
    public void getCarInfo(){
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter the car name: ");
        Make = kb.nextLine();
        System.out.print("Enter the color: ");
        myColor = kb.nextLine();
        System.out.print("Enter the starting position: ");
        Position = kb.nextInt();
    }
    public void moveForward(int distance){
        Position += distance;
    }
    public void moveBackward(int distance){
        Position -= distance;
    }
    public void race(GameCar anotherCar){
        if(Position > anotherCar.Position){
            System.out.printf("%s Wins: %s (%d) vs. %s (%d)\n", Make, Make, Position, anotherCar.Make, anotherCar.Position);
        }
        if(Position < anotherCar.Position){
            System.out.printf("%s Wins: %s (%d) vs. %s (%d)\n", anotherCar.Make, Make, Position, anotherCar.Make, anotherCar.Position);
        }
        if(Position == anotherCar.Position){
            System.out.printf("Tie: %s (%d) vs. %s (%d)\n", Make, Position, anotherCar.Make, anotherCar.Position);
        }
    }
}