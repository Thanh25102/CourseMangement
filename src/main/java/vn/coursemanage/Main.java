package vn.coursemanage;

import vn.coursemanage.bll.DepartmentService;
import vn.coursemanage.dao.DepartmentDao;
import vn.coursemanage.gui.MainGUI;

public class Main {
    public static void main(String[] args) {
        MainGUI gui = new MainGUI();
        gui.setVisible(true);
    }
}