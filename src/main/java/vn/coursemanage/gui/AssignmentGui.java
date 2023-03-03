package vn.coursemanage.gui;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import vn.coursemanage.gui.tablemodel.BaseTable;
import vn.coursemanage.model.CourseInstructor;

public class AssignmentGui extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private BaseTable<CourseInstructor> model = new BaseTable<>(
			List.of(new CourseInstructor(1L, 1L), new CourseInstructor(2L, 2L)));
	private JPanel panel;
	private JButton btnDel;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JPanel panel1;
	private TextField textField;
	private JPanel panel_1;
	/**
	 * Create the frame.
	 */
	public AssignmentGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridBagLayout());

		btnAdd = new JButton("Create");
		panel.add(btnAdd);

		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(e->{
			AssignmentUpdateGui update = new AssignmentUpdateGui();
			update.setVisible(true);
		});
		panel.add(btnUpdate);

		btnDel = new JButton("Delete");
		panel.add(btnDel);

		panel1 = new JPanel();
		panel.add(panel1);

		Border border = BorderFactory.createEmptyBorder(80, 0, 80, 0);
		panel1.setLayout(new GridLayout(1, 0, 0, 0));

		textField = new TextField();
		panel1.add(textField);
		panel_1 = new JPanel();
		panel1.add(panel_1);

		panel1.setBorder(border);

		scrollPane = new JScrollPane();
		contentPane.add(scrollPane);

		table = new JTable(model);
		scrollPane.setViewportView(table);

	}

}
