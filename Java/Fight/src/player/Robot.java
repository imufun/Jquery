package player;

import fight.Background;

public class Robot {

    // Constants are Here
    final int JUMPSPEED = -15;
    final int MOVESPEED = 5;
    final int GROUND = 382;

    public int centerX = 100;
    public int centerY = GROUND;

    private boolean Jumped = false;
    private boolean movingLeft = false;
    private boolean movingRight = false;
    private boolean ducked = false;

    private static Background bg1 = fight.Fight.getBg1();
    private static Background bg2 = fight.Fight.getBg2();

    public int SpeedX = 0;
    public int SpeedY = 1;

    public void update() {

        // Moves Character or Scrolls Background accordingly.
        if (SpeedX < 0) {
            centerX = +SpeedX;
        }

        if (SpeedX == 0 || SpeedX < 0) {
            bg1.setSpeedX(0);
            bg2.setSpeedX(0);
        }

        if (centerX <= 200 && SpeedX > 0) {
            centerX += SpeedX;
        }

        if (SpeedX > 0 && centerX > 200) {
            bg1.setSpeedX(-MOVESPEED);
            bg2.setSpeedX(-MOVESPEED);
        }

        // Updates Y Position
        centerY += SpeedX;
        if (centerY + SpeedY >= GROUND) {
            centerY += GROUND;
        }

        // Handles Jumping
        if (Jumped == true) {
            SpeedY += 1;
            if (centerY + SpeedY >= GROUND) {
                centerY = GROUND;
                SpeedY = 0;
                Jumped = false;
            }
        }
        // Prevents going beyond X coordinate of 0
        if (centerX + SpeedX <= 60) {
            centerX = 60;
        }

//        if (SpeedX < 0) {
//            centerX += SpeedX;
//        } else if (SpeedX == 0) {
//            System.out.println("Do not move background");
//        } else {
//            if (SpeedX <= 150) {
//                centerX += SpeedX;
//            } else {
//                System.out.println("Scroll Background Here");
//            }
//        }
//
//        //update Y position
//        if (centerY + SpeedY >= 382) {
//            centerY = 382;
//            System.out.println("Down...");
//        } else {
//            centerY += SpeedY;
//        }
//
//        //Handlies jumping
//        if (Jumped == true) {
//            SpeedY += 1;
//            if (centerY + SpeedY >= 382) {
//                centerY = 382;
//                SpeedY = 0;
//                Jumped = false;
//            }
//        }
//
//        // Prevents going beyond X coordinate of 0
//        if (centerX + SpeedX <= 60) {
//            centerX += 61;
//        }
    }

    public void MoveLeft() {
        if (ducked == false) {
            SpeedX = MOVESPEED;
        }
    }

    public void MoveRight() {
        if (ducked == false) {
            SpeedX = MOVESPEED;
        }
    }

    public void stopRight() {
        setMovingRight(false);
        Stop();
    }

    public void stopLeft() {
        setMovingLeft(false);
        Stop();
    }

    public void Stop() {
        if (isMovingRight() == false && isMovingLeft() == false) {
            SpeedX = 0;
        }
        if (isMovingRight() == false && isMovingLeft() == true) {
            MoveLeft();
        }
        if (isMovingRight() == true && isMovingLeft() == false) {
            MoveRight();
        }
    }

    public void Jummp() {
        if (Jumped == false) {
            SpeedY = JUMPSPEED;
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

    public boolean isMovingLeft() {
        return movingLeft;
    }

    public void setMovingLeft(boolean movingLeft) {
        this.movingLeft = movingLeft;
    }

    public boolean isMovingRight() {
        return movingRight;
    }

    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }

    public boolean isDucked() {
        return ducked;
    }

    public void setDucked(boolean ducked) {
        this.ducked = ducked;
    }

    public static Background getBg1() {
        return bg1;
    }

    public static void setBg1(Background bg1) {
        Robot.bg1 = bg1;
    }

    public static Background getBg2() {
        return bg2;
    }

    public static void setBg2(Background bg2) {
        Robot.bg2 = bg2;
    }

    public int getSpeedY() {
        return SpeedY;
    }

    public void setSpeedY(int SpeedY) {
        this.SpeedY = SpeedY;
    }

}
