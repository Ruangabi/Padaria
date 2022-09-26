/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.padaria.telas;

import br.com.padaria.dao.ProdutoDAO;
import br.com.padaria.models.Produto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.EventObject;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aluno
 */
public class TelaProduto extends javax.swing.JFrame {

    private DefaultTableModel modelo = new DefaultTableModel();
    List<Produto> produtos = new ArrayList();

    /**
     * Creates new form TelaProduto
     */
    public TelaProduto() {
        initComponents();
        modelo.addColumn("Código");
        modelo.addColumn("Descrição");
        modelo.addColumn("Nome");
        modelo.addColumn("Valor(R$)");
        tblProdutos.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        txtDesc = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        bntNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        txtPesquisa = new javax.swing.JTextField();
        cbOpcaoPesquisa = new javax.swing.JComboBox<>();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(611, 479));
        setResizable(false);

        jLabel1.setText("*Código:");

        jLabel2.setText("Descrição:");

        jLabel3.setText("Nome:");

        jLabel4.setText("Valor(R$):");

        bntNovo.setText("Novo");
        bntNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNovoActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAlterarMouseClicked(evt);
            }
        });
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        cbOpcaoPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cod", "Nome" }));

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        tblProdutos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;

            }
        };
        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdutosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProdutos);

        jLabel5.setText("*Campo obrigatorio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome)
                            .addComponent(txtDesc)
                            .addComponent(txtCod)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 41, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bntNovo)
                        .addGap(46, 46, 46)
                        .addComponent(btnAlterar)
                        .addGap(37, 37, 37)
                        .addComponent(btnSalvar)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(42, 42, 42))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbOpcaoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnPesquisar)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel5)))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bntNovo)
                            .addComponent(btnAlterar)
                            .addComponent(btnSalvar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbOpcaoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(614, 517));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:

        Produto produto = new Produto();
        produto.setCodigo_pro(txtCod.getText());
        produto.setDescricao(txtDesc.getText());
        produto.setNome(txtNome.getText());
        produto.setValor_R$(BigDecimal.valueOf(Double.parseDouble(txtValor.getText())));

        if (txtCod.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Erro ao inserir produto");
            return;
        }

        if (produto.getCodigo_pro() != null) {
            this.onCreate(produto);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:

        this.modelo.setNumRows(0);
        System.out.println(cbOpcaoPesquisa.getSelectedItem());
        ProdutoDAO dao = new ProdutoDAO();
        produtos = new ArrayList();
        try {
            produtos = dao.Pesquisar(txtPesquisa.getText(), cbOpcaoPesquisa.getSelectedItem().toString());
            for (Produto p : produtos) {
                this.modelo.addRow(new Object[]{p.getCodigo_pro(), p.getDescricao(), p.getNome(), p.getValor_R$()});
            }
        } catch (Exception e) {
            System.out.println("Erro... " + e.getMessage());
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void tblProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutosMouseClicked
        // TODO add your handling code here:

        int row = tblProdutos.getSelectedRow();
        System.out.println(":: " + row);
        Produto p = new Produto();
        p = produtos.get(row);
        System.out.println("Código:: " + p.getCodigo_pro());
        Produto produtoForm = new Produto();
        produtoForm = getProdutoByCodigo_pro(p.getCodigo_pro());

        txtDesc.setText(produtoForm.getDescricao());
        txtNome.setText(produtoForm.getNome());
        txtValor.setText(produtoForm.getValor_R$().toString());
        txtCod.setText(produtoForm.getCodigo_pro());


    }//GEN-LAST:event_tblProdutosMouseClicked

    private void btnAlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarMouseClicked
        // TODO add your handling code here:

//        Produto produto = new Produto();
//        produto.setCodigo_pro(txtCod.getText());
//        produto.setDescricao(txtDesc.getText());
//        produto.setNome(txtNome.getText());
//        produto.setValor_R$(BigDecimal.valueOf(Double.parseDouble(txtValor.getText())));
//
//        if (txtCod.getText().isEmpty()) {
//
//            JOptionPane.showMessageDialog(null, "Erro ao inserir produto");
//            return;
//        }
//
//        if (produto.getCodigo_pro() != null) {
//            this.onUpdate(produto);
//        }
    }//GEN-LAST:event_btnAlterarMouseClicked

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:

        Produto produto = new Produto();
        produto.setCodigo_pro(txtCod.getText());
        produto.setDescricao(txtDesc.getText());
        produto.setNome(txtNome.getText());
        produto.setValor_R$(BigDecimal.valueOf(Double.parseDouble(txtValor.getText())));

        if (txtCod.getText().isEmpty()) {

            produto.setCodigo_pro(txtCod.getText());
        }

        if (produto.getCodigo_pro() != null) {
            this.onUpdate(produto);
        }

    }//GEN-LAST:event_btnAlterarActionPerformed

    private void bntNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNovoActionPerformed
        // TODO add your handling code here:

        Produto produto = new Produto();
        produto.setCodigo_pro(txtCod.getText());
        produto.setDescricao(txtDesc.getText());
        produto.setNome(txtNome.getText());
        produto.setValor_R$(BigDecimal.valueOf(Double.parseDouble(txtValor.getText())));

        if (txtCod.getText().isEmpty()) {

            produto.setCodigo_pro(txtCod.getText());
        }

        if (produto.getCodigo_pro() != null) {
            this.resetForm();
        } else {
            this.resetForm();
        }
    }//GEN-LAST:event_bntNovoActionPerformed

    private void onCreate(Produto produto) {
        ProdutoDAO dao = new ProdutoDAO();
        try {
            dao.Insert(produto);
            JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");
            this.resetForm();
            this.getProdutos();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao inserir produto");
        }
    }

    private void onUpdate(Produto produto) {
        try {
            ProdutoDAO dao = new ProdutoDAO();
            dao.Update(produto);
            JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!");
            this.resetForm();
            this.getProdutos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + e.getMessage());
        }
    }

    private void getProdutos() {

        this.modelo.setNumRows(0);
        System.out.println(cbOpcaoPesquisa.getSelectedItem());
        ProdutoDAO dao = new ProdutoDAO();
        produtos = new ArrayList();
        try {
            produtos = dao.Select();
            for (Produto p : produtos) {
                this.modelo.addRow(new Object[]{p.getCodigo_pro(), p.getDescricao(), p.getNome(), p.getValor_R$()});
            }
        } catch (Exception e) {
            System.out.println("Erro... " + e.getMessage());
        }
    }

    private void resetForm() {
        txtCod.setText("");
        txtDesc.setText("");
        txtNome.setText("");
        txtValor.setText("");
        txtPesquisa.setText("");
        modelo.setNumRows(0);
    }

    private Produto getProdutoByCodigo_pro(String codigo_pro) {
        Produto p = new Produto();
        ProdutoDAO dao = new ProdutoDAO();
        try {
            p = dao.SelectOne(codigo_pro);
            System.out.println(p.getNome());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar produto: " + e.getMessage());
        }
        return p;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntNovo;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbOpcaoPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
