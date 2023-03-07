package vn.coursemanage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.coursemanage.gui.MainGUI;

import java.util.logging.Level;

public class Main {
    public static void main(String[] args) {
        MainGUI gui = new MainGUI();
        gui.setVisible(true);
    }
}