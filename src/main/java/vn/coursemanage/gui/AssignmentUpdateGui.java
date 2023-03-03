package vn.coursemanage.gui;

import java.awt.GridLayout;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vn.coursemanage.bll.CourseService;
import vn.coursemanage.bll.PersonService;
import vn.coursemanage.dao.CourseDao;
import vn.coursemanage.dao.PersonDao;
import vn.coursemanage.model.Course;
import vn.coursemanage.model.Person;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class AssignmentUpdateGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel1;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JComboBox<String> instructor;
	private JComboBox<String> course;

	public AssignmentUpdateGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 1, 0, 0));

		panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(4, 2, 0, 0));

		JLabel lblNewLabel = new JLabel("CourseName");
		panel.add(lblNewLabel);
		course = new JComboBox<>();
		CourseService courseService = new CourseService(new CourseDao());
		courseService.getAll().forEach(c -> course.addItem(c.getTitle()));

		panel.add(course);

		lblNewLabel_1 = new JLabel("Instructor");
		panel.add(lblNewLabel_1);

		instructor = new JComboBox<>();
		PersonService personService = new PersonService(new PersonDao());
		personService.getAll().forEach(p -> course.addItem(p.getFirstName() + p.getLastName()));
		panel.add(instructor);

		panel1 = new JPanel();
		contentPane.add(panel1);
		panel1.setLayout(new GridLayout(1, 2, 200, 100));

		btnNewButton = new JButton("Clear");
		panel1.add(btnNewButton);

		btnNewButton_1 = new JButton("Save");
		panel1.add(btnNewButton_1);
	}

}
