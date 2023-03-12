/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vn.coursemanage.gui.courseintructor;

import vn.coursemanage.bll.CourseInstructorService;
import vn.coursemanage.bll.CourseService;
import vn.coursemanage.bll.PersonService;
import vn.coursemanage.dao.CourseDao;
import vn.coursemanage.dao.CourseInstructorDao;
import vn.coursemanage.dao.PersonDao;
import vn.coursemanage.exception.FieldNotValidException;
import vn.coursemanage.exception.NotFoundRecordException;
import vn.coursemanage.gui.tablemodel.BaseTable;
import vn.coursemanage.gui.tablemodel.ItemRenderer;
import vn.coursemanage.model.CourseInstructor;
import vn.coursemanage.model.Item;
import vn.coursemanage.model.SearchByFields;
import vn.coursemanage.utils.NotificationUtil;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author popu
 */
public class CourseInstructorManagerGUI extends javax.swing.JPanel {

    private CourseInstructorService courseInstructorService = new CourseInstructorService(new CourseInstructorDao());
    private CourseService courseService = new CourseService(new CourseDao());
    private PersonService personService = new PersonService(new PersonDao());
    private List<CourseInstructor> courseInstructors;
    private BaseTable model;

    /**
     * Creates new form CourseInstructorManagerGUI
     */
    public CourseInstructorManagerGUI() {
        initComponents();
        initTable();
    }

    private void initTable() {
        courseInstructors = courseInstructorService.findAll();
        model = new BaseTable<>(courseInstructors, CourseInstructor.class);
        tableCourseInstructor.setModel(model);
        /**
         * set up combobox student
         */
        cbbCourse.removeAll();
        cbbPerson.removeAll();
        cbbCourse.setRenderer(new ItemRenderer());
        cbbPerson.setRenderer(new ItemRenderer());
        cbbPerson.addItem(new Item(null, "### INSTRUCTOR NAME ###"));
        cbbCourse.addItem(new Item(null, "### COURSE NAME ###"));
        personService.findIntructor()
                .forEach(instructor
                        -> cbbPerson.addItem(new Item(instructor.getPersonId(), 
                                instructor.getFirstName() + " " + instructor.getLastName())));
        courseService.findAll()
                .forEach(course
                        -> cbbCourse.addItem(new Item(course.getCourseId(), course.getTitle())));

    }

    private void reloadTable() {
        model.setData(courseInstructors);
        model.fireTableDataChanged();
    }

    private void resetForm() {
        cbbPerson.setSelectedIndex(0);
        cbbCourse.setSelectedIndex(0);
    }

    private List<SearchByFields> setSearchFields() {
        List<SearchByFields> searchMap = new ArrayList<>();
        searchMap.add(new SearchByFields(((Item) cbbPerson.getSelectedItem()).getId(), "personId"));
        searchMap.add(new SearchByFields(((Item) cbbCourse.getSelectedItem()).getId(), "courseId"));
        return searchMap;
    }

    public void setSelectedValue(JComboBox comboBox, Long value) {
        Item item;
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            item = (Item) comboBox.getItemAt(i);
            if (item.getId() == value) {
                comboBox.setSelectedIndex(i);
                break;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cbbCourse = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cbbPerson = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCourseInstructor = new javax.swing.JTable();

        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSearch.setText("SEARCH");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnReset.setText("RESET");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                        .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jLabel8.setText("COURSE");

        jLabel9.setText("PERSON");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbbPerson, 0, 230, Short.MAX_VALUE)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbbCourse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        tableCourseInstructor.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        tableCourseInstructor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCourseInstructorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableCourseInstructor);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 807, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 557, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        int choice = NotificationUtil.showYesNo(this, "Question", "Do you want to update ?");
        if (choice == NotificationUtil.NO) {
            return;
        }

        Integer selected = tableCourseInstructor.getSelectedRow();
        if (selected >= 0) {
            Long id1 = (Long) tableCourseInstructor.getValueAt(selected, 0);
            Long id2 = (Long) tableCourseInstructor.getValueAt(selected, 2);
            CourseInstructor courseInstructorPrev
                    = new CourseInstructor(id1, id2);

            try {
                CourseInstructor courseInstructorUpdate
                        = new CourseInstructor(
                                ((Item) cbbCourse.getSelectedItem()).getId(), 
                                ((Item) cbbPerson.getSelectedItem()).getId());
                courseInstructorService.update(courseInstructorPrev, courseInstructorUpdate);
                initTable();
                resetForm();
                
            } catch (NullPointerException | NumberFormatException e) {
                NotificationUtil.showInformation(this, "Fields isn't able empty");
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        int choice = NotificationUtil.showYesNo(this, "Question", "Do you want to add ?");
        if (choice == NotificationUtil.NO) {
            return;
        }
        CourseInstructor courseInstructor = new CourseInstructor();
        courseInstructor.setCourseId(((Item) cbbCourse.getSelectedItem()).getId());
        courseInstructor.setPersonId(((Item) cbbPerson.getSelectedItem()).getId());

        courseInstructorService.insert(courseInstructor);

        initTable();
        resetForm();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int choice = NotificationUtil.showYesNo(this, "Question", "Do you want to delete");
        if (choice == NotificationUtil.NO) {
            return;
        }

        Integer selected = tableCourseInstructor.getSelectedRow();
        if (selected >= 0) {
            Long courseId = (Long) tableCourseInstructor.getValueAt(selected, 0);
            Long personId = (Long) tableCourseInstructor.getValueAt(selected, 2);

            courseInstructorService.deleteOne(courseId, personId);
            resetForm();
            initTable();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            List<CourseInstructor> searchList = courseInstructorService.searchByFields(
                    setSearchFields()
            );
            courseInstructors = searchList;
            reloadTable();
        } catch (NotFoundRecordException e) {
            NotificationUtil.showInformation(this, "Can't not find any record of CourseInstructor");
        } catch (FieldNotValidException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        resetForm();
        initTable();
    }//GEN-LAST:event_btnResetActionPerformed

    private void tableCourseInstructorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCourseInstructorMouseClicked
        // TODO add your handling code here:
        Integer selected = tableCourseInstructor.getSelectedRow();
        if (selected >= 0) {
            Long id1 = (Long) tableCourseInstructor.getValueAt(selected, 0);
            Long id2 = (Long) tableCourseInstructor.getValueAt(selected, 2);
            courseInstructors.stream()
                    .anyMatch(courseInstructor -> {
                        if (courseInstructor.getCourseId() == id1 && courseInstructor.getPersonId() == id2) {
                            setSelectedValue(cbbCourse, id1);
                            setSelectedValue(cbbPerson, id2);
                            return true;
                        }
                        return false;
                    });
        }
    }//GEN-LAST:event_tableCourseInstructorMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<Item> cbbCourse;
    private javax.swing.JComboBox<Item> cbbPerson;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableCourseInstructor;
    // End of variables declaration//GEN-END:variables
}
