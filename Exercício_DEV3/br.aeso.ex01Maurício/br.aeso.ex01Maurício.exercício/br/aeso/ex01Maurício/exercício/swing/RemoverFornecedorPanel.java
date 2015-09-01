package br.aeso.ex01Maurício.exercício.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.text.MaskFormatter;

import br.aeso.ex01Maurício.exercício.exceptions.projetoException;
import br.aeso.ex01Maurício.exercício.fachada.Fachada;

@SuppressWarnings("serial")
public class RemoverFornecedorPanel extends JPanel {
	private JFormattedTextField cpfFornecedor;

	/**
	 * Create the panel.
	 */
	public RemoverFornecedorPanel() {
		setLayout(null);

		JButton btnProcurar = new JButton("Remover");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fachada fachada = Fachada.getInstance();
				String cpf = cpfFornecedor.getText();
				cpf = cpf.replaceAll(" ", "");
				boolean fornecedorExcluir = false;
				try {
					fornecedorExcluir = fachada.removerFornecedor(cpf);
				} catch (projetoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}

				if (fornecedorExcluir == true) {
					limpalimparCampos();
					JOptionPane.showMessageDialog(getPanel(),
							"Fornecedor com CPF: "+cpf+" excluído com sucesso!",
							"Excluir fornecedor",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		btnProcurar.setBounds(442, 188, 91, 23);
		add(btnProcurar);

		cpfFornecedor = new JFormattedTextField();
		cpfFornecedor.setBounds(210, 188, 99, 23);
		MaskFormatter mf;
		try {
			mf = new MaskFormatter("###.###.###-##");
			mf.install(cpfFornecedor);
			add(cpfFornecedor);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(82, 193, 46, 14);
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

	public void limpalimparCampos() {
		cpfFornecedor.setText("");
	}
}
