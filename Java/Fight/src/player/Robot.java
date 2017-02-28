package player;

public class Robot {

    private int centerX = 100;
    private int centerY = 100;

    private boolean Jumped = false;

    private int SpeedX = 0;
    private int SpeedY = 1;

    private void update() {
        if (SpeedX < 0) {
            centerX += SpeedX;
        } else if (SpeedX == 0) {
            System.out.println("Do not move background");
        } else {
            if (SpeedX <= 150) {
                centerX += SpeedX;
            } else {
                System.out.println("Scroll Background Here");
            }
        }

        //update Y position
        if (centerY + SpeedY >= 382) {
            centerY = 382;
        } else {
            centerY += SpeedY;
        }

        //Handlies jumping
        if (Jumped == true) {
            SpeedY += 1;
            if (centerY + SpeedY >= 382) {
                centerY = 382;
                SpeedY = 0;
                Jumped = false;
            }
        }
        
       // Prevents going beyond X coordinate of 0
        


    }

    private void MoveLeft() {
    }

    private void MoveRight() {
    }

    private void Stop() {
    }

    private void Jummp() {
    }
}
