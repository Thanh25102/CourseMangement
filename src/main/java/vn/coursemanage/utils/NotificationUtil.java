/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.coursemanage.utils;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author popu
 */
public class NotificationUtil {
        
    public static final int YES = JOptionPane.YES_OPTION;    
    public static final int NO = JOptionPane.NO_OPTION;

    
    public static int showYesNo(Component _this, String title, String mess) {
        int choice = JOptionPane.showConfirmDialog(_this, mess, title, JOptionPane.YES_NO_OPTION);   
        if(choice == JOptionPane.YES_OPTION) return NotificationUtil.YES;
        else return NotificationUtil.NO;
        
    }
    
    public static void showInformation(Component _this, String mess) {
        JOptionPane.showMessageDialog(_this, mess, "Information", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void showWaring(Component _this, String mess) {
        JOptionPane.showMessageDialog(_this, mess, "Waring", JOptionPane.WARNING_MESSAGE);
    }
    
    public static void showError(Component _this, String mess) {
        JOptionPane.showMessageDialog(_this, mess, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
