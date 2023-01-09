package com.itwill.shop.ui.김준;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductDetailPanel_김준 extends JPanel {
	private JTextField NameTextField;
	private JTextField PriceTextField;
	private JTextField DetailTextField;

	/**
	 * Create the panel.
	 */
	public ProductDetailPanel_김준() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel ProductDetailImageLB = new JLabel("");
		ProductDetailImageLB.setHorizontalAlignment(SwingConstants.CENTER);
		ProductDetailImageLB.setIcon(new ImageIcon(ProductDetailPanel_김준.class.getResource("/images/product01.jpg")));
		panel.add(ProductDetailImageLB, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel NameLB = new JLabel("이름");
		NameLB.setBounds(38, 58, 57, 15);
		panel_1.add(NameLB);
		
		NameTextField = new JTextField();
		NameTextField.setEditable(false);
		NameTextField.setBounds(134, 55, 116, 21);
		panel_1.add(NameTextField);
		NameTextField.setColumns(10);
		
		JLabel PriceLB = new JLabel("가격");
		PriceLB.setBounds(38, 114, 57, 15);
		panel_1.add(PriceLB);
		
		PriceTextField = new JTextField();
		PriceTextField.setEditable(false);
		PriceTextField.setBounds(134, 111, 116, 21);
		panel_1.add(PriceTextField);
		PriceTextField.setColumns(10);
		
		JLabel DeatilLB = new JLabel("설명");
		DeatilLB.setBounds(38, 159, 57, 15);
		panel_1.add(DeatilLB);
		
		DetailTextField = new JTextField();
		DetailTextField.setEditable(false);
		DetailTextField.setBounds(134, 156, 116, 21);
		panel_1.add(DetailTextField);
		DetailTextField.setColumns(10);
		
		JButton CartAddBtn = new JButton("담기");
		CartAddBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		CartAddBtn.setBounds(134, 261, 97, 23);
		CartAddBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//클릭시 주문으로 이동 or 장바구니에 담겨짐
			}
		});
		panel_1.add(CartAddBtn);

	}
}
