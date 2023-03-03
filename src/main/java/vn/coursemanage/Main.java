package vn.coursemanage;

import vn.coursemanage.bll.PersonService;
import vn.coursemanage.dao.PersonDao;
import vn.coursemanage.gui.AssignmentGui;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                PersonService service = new PersonService(new PersonDao());
                AssignmentGui frame = new AssignmentGui();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}