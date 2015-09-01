package br.aeso.ex01Maurício.exercício.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.text.MaskFormatter;

import br.aeso.ex01Maurício.exercício.exceptions.projetoException;
import br.aeso.ex01Maurício.exercício.fachada.Fachada;
import br.aeso.ex01Maurício.exercício.modelo.Fornecedor;

@SuppressWarnings("serial")
public class ProcurarFornecedorPanel extends JPanel {
	private JFormattedTextField cpfFornecedor;
	private JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public ProcurarFornecedorPanel() {
		setLayout(null);

		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fachada fachada = Fachada.getInstance();
				String cpf = cpfFornecedor.getText();
				cpf = cpf.replaceAll(" ", "");
				Fornecedor fornecedorEncontrado = null;
				try {
					fornecedorEncontrado = fachada.procurarFornecedor(cpf);
				} catch (projetoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}

				if (fornecedorEncontrado != null) {
					limpalimparCampos();
					textArea.setText(fornecedorEncontrado.toString());
				} else {
					JOptionPane.showMessageDialog(getPanel(),
							"Fornecedor não encontrado!",
							"Procurar fornecedor",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		btnProcurar.setBounds(442, 52, 91, 23);
		add(btnProcurar);

		textArea = new JTextArea();
		textArea.setBounds(67, 121, 466, 220);
		add(textArea);

		cpfFornecedor = new JFormattedTextField();
		cpfFornecedor.setBounds(210, 52, 99, 23);
		MaskFormatter mf;
		try {
			mf = new MaskFormatter("###.###.###-##");
			mf.install(cpfFornecedor);
			add(cpfFornecedor);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(82, 56, 46, 14);
		add(lblCpf);
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				cpfFornecedor.requestFocus();
			}
		});
	}

	public JPanel getPanel() {
		return this;
	}
	
	public void limpalimparCampos(){
		cpfFornecedor.setText("");
	}
}
