package player;

public class Robot {

    // Constants are Here
    
    
    public int centerX = 100;
    public int centerY = 100;

    private boolean Jumped = false;

    public int SpeedX = 0;
    public int SpeedY = 1;

    public void update() {
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
            System.out.println("Down...");
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
        if (centerX + SpeedX <= 60) {
            centerX += 61;
        }

    }

    public void MoveLeft() {
        SpeedX = -6;
    }

    public void MoveRight() {
        SpeedX = 6;
    }

    public void Stop() {
        SpeedX = 0;
    }

    public void Jummp() {
        if (Jumped == false) {
            SpeedY = -15;
            Jumped = true;
        }
    }

    public int getCenterX() {
        return centerX;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public boolean isJumped() {
        return Jumped;
    }

    public void setJumped(boolean Jumped) {
        this.Jumped = Jumped;
    }

    public int getSpeedX() {
        return SpeedX;
    }

    public void setSpeedX(int SpeedX) {
        this.SpeedX = SpeedX;
    }

}
