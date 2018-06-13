package www.person.manager.cantata;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Index implements ActionListener{
	JFrame frame;
	JTextField textField;
	
	// 생성자 만들기
	public Index() {
		frame = new JFrame("Title");  // 프레임 만들기
		frame.setBounds(100, 100, 450, 300); // 프레임 크기조정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
		JPanel panel = new JPanel(); // 패널 만들기
		frame.getContentPane().add(panel); // 프레임에 덧붙이기
		panel.setBackground(Color.BLUE); // 패널 바탕색 변경
		
		JButton button = new JButton("버튼");
		button.addActionListener(this);
		panel.add(button);
		
		textField = new JTextField();
		panel.add(textField);		// 패널에 더하기
		textField.setColumns(10);	// 글자수 지정
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("버튼이 클릭됨-->>>>" +textField.getText());
	}
}
