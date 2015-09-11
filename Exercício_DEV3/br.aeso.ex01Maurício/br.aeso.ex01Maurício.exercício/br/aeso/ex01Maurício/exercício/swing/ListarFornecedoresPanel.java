package br.aeso.ex01Maurício.exercício.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import br.aeso.ex01Maurício.exercício.exceptions.projetoException;
import br.aeso.ex01Maurício.exercício.fachada.Fachada;
import br.aeso.ex01Maurício.exercício.modelo.Fornecedor;

@SuppressWarnings("serial")
public class ListarFornecedoresPanel extends JPanel {
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public ListarFornecedoresPanel() {
		setLayout(null);

		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fachada fachada = Fachada.getInstance();
				try {
					ArrayList<Fornecedor> fornecedores = fachada
							.listarfornecedores();

					String nomeFornecedores = "";
					if (fornecedores.size() != 0) {
						for (Fornecedor f : fornecedores) {
							nomeFornecedores = nomeFornecedores + "\n"
									+ f.toString();
						}
						textArea.setText(nomeFornecedores);
					} else {
						JOptionPane.showMessageDialog(null,
								"Não existem fornecedores!");
					}
				} catch (projetoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnListar.setBounds(255, 34, 89, 23);
		add(btnListar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 98, 464, 247);
		add(scrollPane);

		textArea = new JTextArea();
		textArea.setLocation(69, 0);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);

	}
}
