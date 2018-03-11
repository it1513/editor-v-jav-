/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import sun.util.logging.PlatformLogger;

/**
 *
 * @author student
 */
public class MainWindow extends javax.swing.JFrame {
    private File soubor;
    private final Soubor txtSoubor = new Soubor();
    private String kodovani = "UTF-8";
    private String copy = "";
    private String take = "";
    private String searchText = "";
    private String replText = "";

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
    }
    
    private String informaceOSouboru(){
        String info = "";
        info += "Nazev souboru: " + soubor.getName() + "\n";
        info += "Umístění: " + soubor.getParent() + "\n";
        info += "Velikost: " + String.valueOf(soubor.length()) + "bytes\n";
        info += "Práva: ";
        info += soubor.canRead() ? "R " : "- ";
        info += soubor.canWrite()? "W " : "- ";
        info += soubor.canExecute()? "X\n" : "-\n";
        info += "Skrytý soubor: " + (soubor.isHidden() ? "ano " : "ne\n");
        Date datum = new Date();
        datum.setTime(soubor.lastModified());
        info += "Datum aktualizace: " + datum.toString();       
        return info;
    }
    
    private void searchOperation(String foundTxt,String replacedTxt, Boolean replace){
        editor.requestFocusInWindow();
        int startFrom = (editor.getCaretPosition() == editor.getDocument().getLength()) ? 0 : editor.getCaretPosition();
        int max = editor.getDocument().getLength() - startFrom;
        int searchIndex = -1;
        try {
            searchIndex = editor.getDocument().getText(startFrom, max).indexOf(foundTxt);
        } catch (BadLocationException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE,null,ex);
        }
        if (searchIndex != -1) {
            editor.select(searchIndex + startFrom, searchIndex + startFrom + foundTxt.length());
            if(replace) {
                editor.replaceSelection(replacedTxt);
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Řetězec nebyl nalezen");
            editor.setSelectionStart(-1);
            editor.setSelectionEnd(-1);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        toolBar = new javax.swing.JToolBar();
        NewFileButton = new javax.swing.JButton();
        OpenFileButton = new javax.swing.JButton();
        SaveFileButton = new javax.swing.JButton();
        statusBar = new javax.swing.JPanel();
        infoLeft = new javax.swing.JLabel();
        infoCenter = new javax.swing.JLabel();
        infoRight = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        editor = new javax.swing.JEditorPane();
        menuBar = new javax.swing.JMenuBar();
        MenuFile = new javax.swing.JMenu();
        NewFileItem = new javax.swing.JMenuItem();
        OpenFileItem = new javax.swing.JMenuItem();
        SaveFileItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        InfoFileItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        EndFile = new javax.swing.JMenuItem();
        MenuEdit = new javax.swing.JMenu();
        CutFileItem = new javax.swing.JMenuItem();
        CopyFileItem = new javax.swing.JMenuItem();
        PasteFileItem = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        FindFileItem = new javax.swing.JMenuItem();
        ReplaceFileItem = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        FindAllFileItem = new javax.swing.JMenuItem();
        MenuSettings = new javax.swing.JMenu();
        ViewMenu = new javax.swing.JMenu();
        ToolsItem = new javax.swing.JCheckBoxMenuItem();
        StatusBarItem = new javax.swing.JCheckBoxMenuItem();
        BackgroundColorItem = new javax.swing.JMenuItem();
        FontItem = new javax.swing.JMenuItem();
        MenuCode = new javax.swing.JMenu();
        utf8Code = new javax.swing.JRadioButtonMenuItem();
        windowsCode = new javax.swing.JRadioButtonMenuItem();
        isoCode = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        toolBar.setRollover(true);

        NewFileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikony/new.png"))); // NOI18N
        NewFileButton.setText("Nový");
        NewFileButton.setFocusable(false);
        NewFileButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        NewFileButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(NewFileButton);

        OpenFileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikony/open.png"))); // NOI18N
        OpenFileButton.setText("Otevřít");
        OpenFileButton.setFocusable(false);
        OpenFileButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        OpenFileButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        OpenFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenFileButtonActionPerformed(evt);
            }
        });
        toolBar.add(OpenFileButton);

        SaveFileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikony/save.png"))); // NOI18N
        SaveFileButton.setText("Uložit");
        SaveFileButton.setFocusable(false);
        SaveFileButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        SaveFileButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(SaveFileButton);

        statusBar.setLayout(new java.awt.GridLayout(1, 3, 10, 0));

        infoLeft.setBackground(new java.awt.Color(0, 51, 255));
        infoLeft.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoLeft.setText("Název souboru");
        statusBar.add(infoLeft);

        infoCenter.setBackground(new java.awt.Color(255, 153, 0));
        infoCenter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoCenter.setText("Vlastnosti souboru");
        statusBar.add(infoCenter);

        infoRight.setBackground(new java.awt.Color(0, 204, 0));
        infoRight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoRight.setText("Parametry textu");
        statusBar.add(infoRight);

        jScrollPane2.setViewportView(editor);

        MenuFile.setText("Soubor");

        NewFileItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        NewFileItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikony/new-small.png"))); // NOI18N
        NewFileItem.setText("Nový");
        MenuFile.add(NewFileItem);

        OpenFileItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        OpenFileItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikony/open-small.png"))); // NOI18N
        OpenFileItem.setText("Otevřít...");
        OpenFileItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenFileItemActionPerformed(evt);
            }
        });
        MenuFile.add(OpenFileItem);

        SaveFileItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        SaveFileItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikony/save-small.png"))); // NOI18N
        SaveFileItem.setText("Uložit...");
        SaveFileItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveFileItemActionPerformed(evt);
            }
        });
        MenuFile.add(SaveFileItem);
        MenuFile.add(jSeparator1);

        InfoFileItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        InfoFileItem.setText("Informace o souboru");
        InfoFileItem.setEnabled(false);
        InfoFileItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InfoFileItemActionPerformed(evt);
            }
        });
        MenuFile.add(InfoFileItem);
        MenuFile.add(jSeparator2);

        EndFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        EndFile.setText("Konec");
        MenuFile.add(EndFile);

        menuBar.add(MenuFile);

        MenuEdit.setText("Úpravy");

        CutFileItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        CutFileItem.setText("Vyjmout");
        CutFileItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CutFileItemActionPerformed(evt);
            }
        });
        MenuEdit.add(CutFileItem);

        CopyFileItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        CopyFileItem.setText("Kopírovat");
        CopyFileItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopyFileItemActionPerformed(evt);
            }
        });
        MenuEdit.add(CopyFileItem);

        PasteFileItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        PasteFileItem.setText("Vložit");
        MenuEdit.add(PasteFileItem);
        MenuEdit.add(jSeparator3);

        FindFileItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        FindFileItem.setText("Hledat..");
        FindFileItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FindFileItemActionPerformed(evt);
            }
        });
        MenuEdit.add(FindFileItem);

        ReplaceFileItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        ReplaceFileItem.setText("Nahradit..");
        ReplaceFileItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReplaceFileItemActionPerformed(evt);
            }
        });
        MenuEdit.add(ReplaceFileItem);
        MenuEdit.add(jSeparator4);

        FindAllFileItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        FindAllFileItem.setText("Vybrat vše");
        MenuEdit.add(FindAllFileItem);

        menuBar.add(MenuEdit);

        MenuSettings.setText("Nastavení");

        ViewMenu.setText("Zobrazení");

        ToolsItem.setSelected(true);
        ToolsItem.setText("Panel Nástrojů");
        ToolsItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToolsItemActionPerformed(evt);
            }
        });
        ViewMenu.add(ToolsItem);

        StatusBarItem.setSelected(true);
        StatusBarItem.setText("Stavový řádek");
        StatusBarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatusBarItemActionPerformed(evt);
            }
        });
        ViewMenu.add(StatusBarItem);

        MenuSettings.add(ViewMenu);

        BackgroundColorItem.setText("Barva pozadí..");
        BackgroundColorItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackgroundColorItemActionPerformed(evt);
            }
        });
        MenuSettings.add(BackgroundColorItem);

        FontItem.setText("Písmo..");
        FontItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FontItemActionPerformed(evt);
            }
        });
        MenuSettings.add(FontItem);

        MenuCode.setText("Kodovaní znaků..");

        buttonGroup1.add(utf8Code);
        utf8Code.setSelected(true);
        utf8Code.setText("UTF-8");
        MenuCode.add(utf8Code);

        buttonGroup1.add(windowsCode);
        windowsCode.setText("Windows 1250");
        MenuCode.add(windowsCode);

        buttonGroup1.add(isoCode);
        isoCode.setText("ISO-8859-2");
        MenuCode.add(isoCode);

        MenuSettings.add(MenuCode);

        menuBar.add(MenuSettings);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(statusBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 480, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(3, 3, 3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusBar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OpenFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenFileButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OpenFileButtonActionPerformed

    private void OpenFileItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenFileItemActionPerformed
        try {
        JFileChooser fc = new JFileChooser();
        fc.setDialogType(JFileChooser.OPEN_DIALOG);
        fc.setDialogTitle("Otevření souboru");
        fc.setCurrentDirectory(new java.io.File("."));
        FileNameExtensionFilter myFilter = new FileNameExtensionFilter("Text","txt");
        fc.setFileFilter(myFilter);
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            soubor = fc.getSelectedFile();
            try {
                txtSoubor.nactiZeSouboru(soubor,kodovani);
                editor.setText(txtSoubor.getData());
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this,"Požadovaný soubor nebyl nalezen!","Chyba",JOptionPane.ERROR_MESSAGE);
            }
        }
        InfoFileItem.setEnabled(true);
//        this.statusBarInfo();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Nastala chyba při otevření souboru!","Chyba",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_OpenFileItemActionPerformed

    private void CopyFileItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopyFileItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CopyFileItemActionPerformed

    private void ReplaceFileItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReplaceFileItemActionPerformed
        NahradDialog nahraditDialog = new NahradDialog(this,true,searchText,replText);
        if(nahraditDialog.showDialog().equals("Nahradit")){
            editor.requestFocusInWindow();
            searchText = nahraditDialog.getReplacedText();
            replText = nahraditDialog.getNewText();
            this.searchOperation(searchText,replText,true);
            
        }
    }//GEN-LAST:event_ReplaceFileItemActionPerformed

    private void CutFileItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CutFileItemActionPerformed
        take = editor.getSelectedText();
    }//GEN-LAST:event_CutFileItemActionPerformed

    private void ToolsItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ToolsItemActionPerformed
        if (ToolsItem.isSelected()){
            toolBar.setVisible(true);
        } else {
            toolBar.setVisible(false);
        }
    }//GEN-LAST:event_ToolsItemActionPerformed

    private void StatusBarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatusBarItemActionPerformed
        if (StatusBarItem.isSelected()){
            statusBar.setVisible(true);
        } else {
            statusBar.setVisible(false);
        }
    }//GEN-LAST:event_StatusBarItemActionPerformed

    private void BackgroundColorItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackgroundColorItemActionPerformed
        Color barva = JColorChooser.showDialog(this, "Vyber si barvu", editor.getBackground());
        editor.setBackground(barva);
    }//GEN-LAST:event_BackgroundColorItemActionPerformed

    private void FontItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FontItemActionPerformed
        Color color = editor.getForeground();
        Font font = editor.getFont();
        FontDialog fontDialog = new FontDialog(this,true,font ,color);
        //Color barva = JColorChooser.showDialog(this, "Vyber si barvu", editor.getForeground());
        //editor.setForeground(barva);
    }//GEN-LAST:event_FontItemActionPerformed

    private void SaveFileItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveFileItemActionPerformed
        try {
            JFileChooser fc = new JFileChooser();
            fc.setDialogType(JFileChooser.SAVE_DIALOG);
            fc.setDialogTitle("Uložení souboru");
            fc.setCurrentDirectory(new java.io.File("."));
            FileNameExtensionFilter myFilter = new FileNameExtensionFilter("Text","txt");
            fc.setFileFilter(myFilter);
            if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                txtSoubor.setData(editor.getText());
                txtSoubor.ulozDoSouboru(fc.getSelectedFile(), kodovani);
        }
        } catch (HeadlessException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(this,"Nastala chyba při ukládání souboru!","Chyba",JOptionPane.ERROR_MESSAGE);
        }    
    }//GEN-LAST:event_SaveFileItemActionPerformed

    private void InfoFileItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InfoFileItemActionPerformed
        JOptionPane.showMessageDialog(this,informaceOSouboru(),"Informace",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_InfoFileItemActionPerformed

    private void FindFileItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FindFileItemActionPerformed
        searchText = JOptionPane.showInputDialog(this, "Zadej hledaný řetězec");
        this.searchOperation(searchText,null,false);
    }//GEN-LAST:event_FindFileItemActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem BackgroundColorItem;
    private javax.swing.JMenuItem CopyFileItem;
    private javax.swing.JMenuItem CutFileItem;
    private javax.swing.JMenuItem EndFile;
    private javax.swing.JMenuItem FindAllFileItem;
    private javax.swing.JMenuItem FindFileItem;
    private javax.swing.JMenuItem FontItem;
    private javax.swing.JMenuItem InfoFileItem;
    private javax.swing.JMenu MenuCode;
    private javax.swing.JMenu MenuEdit;
    private javax.swing.JMenu MenuFile;
    private javax.swing.JMenu MenuSettings;
    private javax.swing.JButton NewFileButton;
    private javax.swing.JMenuItem NewFileItem;
    private javax.swing.JButton OpenFileButton;
    private javax.swing.JMenuItem OpenFileItem;
    private javax.swing.JMenuItem PasteFileItem;
    private javax.swing.JMenuItem ReplaceFileItem;
    private javax.swing.JButton SaveFileButton;
    private javax.swing.JMenuItem SaveFileItem;
    private javax.swing.JCheckBoxMenuItem StatusBarItem;
    private javax.swing.JCheckBoxMenuItem ToolsItem;
    private javax.swing.JMenu ViewMenu;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JEditorPane editor;
    private javax.swing.JLabel infoCenter;
    private javax.swing.JLabel infoLeft;
    private javax.swing.JLabel infoRight;
    private javax.swing.JRadioButtonMenuItem isoCode;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel statusBar;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JRadioButtonMenuItem utf8Code;
    private javax.swing.JRadioButtonMenuItem windowsCode;
    // End of variables declaration//GEN-END:variables

}