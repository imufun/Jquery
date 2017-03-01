package input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import ui.UIManager;

public class MouseManager implements MouseListener, MouseMotionListener {

    private boolean leftPressed, rightPressed;
    private int mouseX, mouseY;
    private UIManager uIManager;

    public MouseManager() {
    }

    public void setUIManager(UIManager uIManager) {
        this.uIManager = uIManager;
    }

    //geters

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    @Override
<<<<<<< HEAD
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
=======
>>>>>>> 3f9c970d010f8db09bfa37908eff660d06e22bcf
    public void mousePressed(MouseEvent e) {

        if (e.getButton() == MouseEvent.BUTTON1) {
            leftPressed = true;
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            rightPressed = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            leftPressed = false;
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            rightPressed = false;
        }

        if (uIManager != null) {
<<<<<<< HEAD
            uIManager.onMouseRelease(e);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

        mouseX = e.getX();
        mouseY = e.getY();

        if (uIManager != null) {
=======
>>>>>>> 3f9c970d010f8db09bfa37908eff660d06e22bcf
            uIManager.onMouseRelease(e);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

        mouseX = e.getX();
        mouseY = e.getY();

        if (uIManager != null) {
            uIManager.onMouseMove(e);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
