/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ddgame;
import java.awt.event.ItemEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author Joe
 */
public class ClassSelectWindow2 extends javax.swing.JDialog {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DDGameGui origin;
    /**
     * Creates new form ClassSelectWindow
     */
    public ClassSelectWindow2(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        origin = (DDGameGui)parent;
        initComponents();
        System.arraycopy(origin.curChar.storedSelected, 0, Selected, 0, Selected.length);
        System.arraycopy(origin.curChar.storedHPTotals, 0, HPTotals, 0,HPTotals.length);
        Selected[0] = origin.curChar.storedSelected[0];
        if(Selected[0]>-1) {Level1SelectBox.setSelectedItem(origin.curChar.Classes.get(Selected[0]).getName());}
        Selected[1] = origin.curChar.storedSelected[1];
        if(Selected[1]>-1) {Level2SelectBox.setSelectedItem(origin.curChar.Classes.get(Selected[1]).getName());}
        Selected[2] = origin.curChar.storedSelected[2];
        if(Selected[2]>-1) {Level3SelectBox.setSelectedItem(origin.curChar.Classes.get(Selected[2]).getName());}
        Selected[3] = origin.curChar.storedSelected[3];
        if(Selected[3]>-1) {Level4SelectBox.setSelectedItem(origin.curChar.Classes.get(Selected[3]).getName());}
        Selected[4] = origin.curChar.storedSelected[4];
        if(Selected[4]>-1) {Level5SelectBox.setSelectedItem(origin.curChar.Classes.get(Selected[4]).getName());}
        Selected[5] = origin.curChar.storedSelected[5];
        if(Selected[5]>-1) {Level6SelectBox.setSelectedItem(origin.curChar.Classes.get(Selected[5]).getName());}
        Selected[6] = origin.curChar.storedSelected[6];
        if(Selected[6]>-1) {Level7SelectBox.setSelectedItem(origin.curChar.Classes.get(Selected[6]).getName());}
        Selected[7] = origin.curChar.storedSelected[7];
        if(Selected[7]>-1) {Level8SelectBox.setSelectedItem(origin.curChar.Classes.get(Selected[7]).getName());}
        Selected[8] = origin.curChar.storedSelected[8];
        if(Selected[8]>-1) {Level9SelectBox.setSelectedItem(origin.curChar.Classes.get(Selected[8]).getName());}
        Selected[9] = origin.curChar.storedSelected[9];
        if(Selected[9]>-1) {Level10SelectBox.setSelectedItem(origin.curChar.Classes.get(Selected[9]).getName());}
        Selected[10] = origin.curChar.storedSelected[10];
        if(Selected[10]>-1) {Level11SelectBox.setSelectedItem(origin.curChar.Classes.get(Selected[10]).getName());}
        Selected[11] = origin.curChar.storedSelected[11];
        if(Selected[11]>-1) {Level12SelectBox.setSelectedItem(origin.curChar.Classes.get(Selected[11]).getName());}
        Selected[12] = origin.curChar.storedSelected[12];
        if(Selected[12]>-1) {Level13SelectBox.setSelectedItem(origin.curChar.Classes.get(Selected[12]).getName());}
        Selected[13] = origin.curChar.storedSelected[13];
        if(Selected[13]>-1) {Level14SelectBox.setSelectedItem(origin.curChar.Classes.get(Selected[13]).getName());}
        Selected[14] = origin.curChar.storedSelected[14];
        if(Selected[14]>-1) {Level15SelectBox.setSelectedItem(origin.curChar.Classes.get(Selected[14]).getName());}
        Selected[15] = origin.curChar.storedSelected[15];
        if(Selected[15]>-1) {Level16SelectBox.setSelectedItem(origin.curChar.Classes.get(Selected[15]).getName());}
        Selected[16] = origin.curChar.storedSelected[16];
        if(Selected[16]>-1) {Level17SelectBox.setSelectedItem(origin.curChar.Classes.get(Selected[16]).getName());}
        Selected[17] = origin.curChar.storedSelected[17];
        if(Selected[17]>-1) {Level18SelectBox.setSelectedItem(origin.curChar.Classes.get(Selected[17]).getName());}
        Selected[18] = origin.curChar.storedSelected[18];
        if(Selected[18]>-1) {Level19SelectBox.setSelectedItem(origin.curChar.Classes.get(Selected[18]).getName());}
        Selected[19] = origin.curChar.storedSelected[19];
        if(Selected[19]>-1) {Level20SelectBox.setSelectedItem(origin.curChar.Classes.get(Selected[19]).getName());}
        Level1HPInput.setText("" + HPTotals[0]);
        Level2HPInput.setText("" + HPTotals[1]);
        Level3HPInput.setText("" + HPTotals[2]);
        Level4HPInput.setText("" + HPTotals[3]);
        Level5HPInput.setText("" + HPTotals[4]);
        Level6HPInput.setText("" + HPTotals[5]);
        Level7HPInput.setText("" + HPTotals[6]);
        Level8HPInput.setText("" + HPTotals[7]);
        Level9HPInput.setText("" + HPTotals[8]);
        Level10HPInput.setText("" + HPTotals[9]);
        Level11HPInput.setText("" + HPTotals[10]);
        Level12HPInput.setText("" + HPTotals[11]);
        Level13HPInput.setText("" + HPTotals[12]);
        Level14HPInput.setText("" + HPTotals[13]);
        Level15HPInput.setText("" + HPTotals[14]);
        Level16HPInput.setText("" + HPTotals[15]);
        Level17HPInput.setText("" + HPTotals[16]);
        Level18HPInput.setText("" + HPTotals[17]);
        Level19HPInput.setText("" + HPTotals[18]);
        Level20HPInput.setText("" + HPTotals[19]);
        setHPLabels();

        
    }
private void setHPLabels() {
    setSelected();
    int x = 0;
    for(JLabel Label : HPLabels) {
        if(Selected[x]>0) {
            Label.setText("d" + origin.curChar.Classes.get(Selected[x]).getHitDie()); 
        }
        else {
            Label.setText("d");
        }
        x++;
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        ClassSelectCancelButton = new javax.swing.JButton();
        ClassSelectOKButton = new javax.swing.JButton();
        Level1SelectBox = new javax.swing.JComboBox<>();
        Level1Label = new javax.swing.JLabel();
        Level2Label = new javax.swing.JLabel();
        Level3Label = new javax.swing.JLabel();
        Level4Label = new javax.swing.JLabel();
        Level5Label = new javax.swing.JLabel();
        Level6Label = new javax.swing.JLabel();
        Level7Label = new javax.swing.JLabel();
        Level8Label = new javax.swing.JLabel();
        Level2SelectBox = new javax.swing.JComboBox<>();
        Level3SelectBox = new javax.swing.JComboBox<>();
        Level4SelectBox = new javax.swing.JComboBox<>();
        Level5SelectBox = new javax.swing.JComboBox<>();
        Level6SelectBox = new javax.swing.JComboBox<>();
        Level7SelectBox = new javax.swing.JComboBox<>();
        Level8SelectBox = new javax.swing.JComboBox<>();
        Level9Label = new javax.swing.JLabel();
        Level10Label = new javax.swing.JLabel();
        Level9SelectBox = new javax.swing.JComboBox<>();
        Level10SelectBox = new javax.swing.JComboBox<>();
        Level18SelectBox = new javax.swing.JComboBox<>();
        Level19SelectBox = new javax.swing.JComboBox<>();
        Level16SelectBox = new javax.swing.JComboBox<>();
        Level20SelectBox = new javax.swing.JComboBox<>();
        Level17SelectBox = new javax.swing.JComboBox<>();
        Level14SelectBox = new javax.swing.JComboBox<>();
        Level15SelectBox = new javax.swing.JComboBox<>();
        Level12SelectBox = new javax.swing.JComboBox<>();
        Level13SelectBox = new javax.swing.JComboBox<>();
        Level17Label = new javax.swing.JLabel();
        Level18Label = new javax.swing.JLabel();
        Level20Label = new javax.swing.JLabel();
        Level19Label = new javax.swing.JLabel();
        Level16Label = new javax.swing.JLabel();
        Level13Label = new javax.swing.JLabel();
        Level12Label = new javax.swing.JLabel();
        Level11SelectBox = new javax.swing.JComboBox<>();
        Level15Label = new javax.swing.JLabel();
        Level14Label = new javax.swing.JLabel();
        Level11Label = new javax.swing.JLabel();
        HPRollsLabel = new javax.swing.JLabel();
        Level1HPInput = new javax.swing.JTextField();
        Level2HPInput = new javax.swing.JTextField();
        Level3HPInput = new javax.swing.JTextField();
        Level4HPInput = new javax.swing.JTextField();
        Level5HPInput = new javax.swing.JTextField();
        Level6HPInput = new javax.swing.JTextField();
        Level7HPInput = new javax.swing.JTextField();
        Level8HPInput = new javax.swing.JTextField();
        Level9HPInput = new javax.swing.JTextField();
        Level11HPInput = new javax.swing.JTextField();
	for(int x = 0; x<HPLabels.length;x++) {
		HPLabels[x] = new JLabel();
		HPLabels[x].setText("d");
	}
        Level10HPInput = new javax.swing.JTextField();
        Level12HPInput = new javax.swing.JTextField();
        Level13HPInput = new javax.swing.JTextField();
        Level14HPInput = new javax.swing.JTextField();
        Level15HPInput = new javax.swing.JTextField();
        Level16HPInput = new javax.swing.JTextField();
        Level17HPInput = new javax.swing.JTextField();
        Level18HPInput = new javax.swing.JTextField();
        Level19HPInput = new javax.swing.JTextField();
        Level20HPInput = new javax.swing.JTextField();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        ClassSelectCancelButton.setText("Cancel");
        ClassSelectCancelButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClassSelectCancelButtonActionPerformed(evt);
            }
        });

        ClassSelectOKButton.setText("OK");
        ClassSelectOKButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClassSelectOKButtonActionPerformed(evt);
            }
        });
        Level1SelectBox.addItemListener(new java.awt.event.ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                SelectBoxItemStateChanged(ie);
            }
        });
        Level2SelectBox.addItemListener(new java.awt.event.ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                SelectBoxItemStateChanged(ie);
            }
        });
        Level3SelectBox.addItemListener(new java.awt.event.ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                SelectBoxItemStateChanged(ie);
            }
        });
        Level4SelectBox.addItemListener(new java.awt.event.ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                SelectBoxItemStateChanged(ie);
            }
        });
        Level5SelectBox.addItemListener(new java.awt.event.ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                SelectBoxItemStateChanged(ie);
            }
        });
        Level6SelectBox.addItemListener(new java.awt.event.ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                SelectBoxItemStateChanged(ie);
            }
        });
        Level7SelectBox.addItemListener(new java.awt.event.ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                SelectBoxItemStateChanged(ie);
            }
        });
        Level8SelectBox.addItemListener(new java.awt.event.ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                SelectBoxItemStateChanged(ie);
            }
        });
        Level9SelectBox.addItemListener(new java.awt.event.ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                SelectBoxItemStateChanged(ie);
            }
        });
        Level10SelectBox.addItemListener(new java.awt.event.ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                SelectBoxItemStateChanged(ie);
            }
        });
        Level11SelectBox.addItemListener(new java.awt.event.ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                SelectBoxItemStateChanged(ie);
            }
        });
        Level12SelectBox.addItemListener(new java.awt.event.ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                SelectBoxItemStateChanged(ie);
            }
        });
        Level13SelectBox.addItemListener(new java.awt.event.ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                SelectBoxItemStateChanged(ie);
            }
        });
        Level14SelectBox.addItemListener(new java.awt.event.ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                SelectBoxItemStateChanged(ie);
            }
        });
        Level15SelectBox.addItemListener(new java.awt.event.ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                SelectBoxItemStateChanged(ie);
            }
        });
        Level16SelectBox.addItemListener(new java.awt.event.ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                SelectBoxItemStateChanged(ie);
            }
        });
        Level17SelectBox.addItemListener(new java.awt.event.ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                SelectBoxItemStateChanged(ie);
            }
        });
        Level18SelectBox.addItemListener(new java.awt.event.ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                SelectBoxItemStateChanged(ie);
            }
        });
        Level19SelectBox.addItemListener(new java.awt.event.ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                SelectBoxItemStateChanged(ie);
            }
        });
        Level20SelectBox.addItemListener(new java.awt.event.ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                SelectBoxItemStateChanged(ie);
            }
        });

        Level1SelectBox.setModel(ClassSelectList1);

        Level1Label.setText("Level 1");

        Level2Label.setText("Level 2");

        Level3Label.setText("Level 3");

        Level4Label.setText("Level 4");

        Level5Label.setText("Level 5");

        Level6Label.setText("Level 6");

        Level7Label.setText("Level 7");

        Level8Label.setText("Level 8");

        Level2SelectBox.setModel(ClassSelectList2);

        Level3SelectBox.setModel(ClassSelectList3);

        Level4SelectBox.setModel(ClassSelectList4);

        Level5SelectBox.setModel(ClassSelectList5);

        Level6SelectBox.setModel(ClassSelectList6);

        Level7SelectBox.setModel(ClassSelectList7);

        Level8SelectBox.setModel(ClassSelectList8);

        Level9Label.setText("Level 9");

        Level10Label.setText("Level 10");

        Level9SelectBox.setModel(ClassSelectList9);

        Level10SelectBox.setModel(ClassSelectList10);

        Level18SelectBox.setModel(ClassSelectList18);

        Level19SelectBox.setModel(ClassSelectList19);

        Level16SelectBox.setModel(ClassSelectList16);

        Level20SelectBox.setModel(ClassSelectList20);

        Level17SelectBox.setModel(ClassSelectList17);

        Level14SelectBox.setModel(ClassSelectList14);

        Level15SelectBox.setModel(ClassSelectList15);

        Level12SelectBox.setModel(ClassSelectList12);

        Level13SelectBox.setModel(ClassSelectList13);

        Level17Label.setText("Level 17");

        Level18Label.setText("Level 18");

        Level20Label.setText("Level 20");

        Level19Label.setText("Level 19");

        Level16Label.setText("Level 16");

        Level13Label.setText("Level 13");

        Level12Label.setText("Level 12");

        Level11SelectBox.setModel(ClassSelectList11);

        Level15Label.setText("Level 15");

        Level14Label.setText("Level 14");

        Level11Label.setText("Level 11");

        HPRollsLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        HPRollsLabel.setText("Enter HP Rolls");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Level3Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Level3SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Level4Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Level4SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Level5Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Level5SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Level6Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Level6SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Level7Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Level7SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Level8Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Level8SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Level1Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Level1SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Level2Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Level2SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Level9Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Level9SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Level10Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(ClassSelectOKButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ClassSelectCancelButton))
                            .addComponent(Level10SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Level11Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Level11SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Level12Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Level12SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Level13Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Level13SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Level14Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Level14SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Level15Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Level15SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Level16Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Level16SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Level17Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Level17SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Level18Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Level18SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Level19Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Level19SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Level20Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Level20SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Level10HPInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HPLabels[9], javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Level20HPInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HPLabels[19], javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(HPRollsLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Level2HPInput, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Level1HPInput, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Level3HPInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(Level4HPInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(Level5HPInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(Level6HPInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(Level7HPInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(Level8HPInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(Level9HPInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(HPLabels[0], javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Level11HPInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(HPLabels[10], javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(HPLabels[1], javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Level12HPInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(HPLabels[11], javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(HPLabels[2], javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Level13HPInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(HPLabels[12], javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(HPLabels[3], javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Level14HPInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(HPLabels[13], javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(HPLabels[4], javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Level15HPInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(HPLabels[14], javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(HPLabels[5], javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Level16HPInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(HPLabels[15], javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(HPLabels[6], javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Level17HPInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(HPLabels[16], javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(HPLabels[7], javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Level18HPInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(HPLabels[17], javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(HPLabels[8], javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Level19HPInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(HPLabels[18], javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(HPRollsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Level1HPInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HPLabels[0])
                            .addComponent(Level11HPInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HPLabels[10]))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Level2HPInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(HPLabels[1])
                                .addComponent(Level12HPInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(HPLabels[11])))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Level3HPInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HPLabels[2])
                            .addComponent(Level13HPInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HPLabels[12]))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Level4HPInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HPLabels[3])
                            .addComponent(Level14HPInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HPLabels[13]))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Level5HPInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HPLabels[4])
                            .addComponent(Level15HPInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HPLabels[14]))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Level6HPInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HPLabels[5])
                            .addComponent(Level16HPInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HPLabels[15]))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Level7HPInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HPLabels[6])
                            .addComponent(Level17HPInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HPLabels[16]))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Level8HPInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HPLabels[7])
                            .addComponent(Level18HPInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HPLabels[17]))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Level9HPInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HPLabels[8])
                            .addComponent(Level19HPInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HPLabels[18]))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(HPLabels[9])
                            .addComponent(Level10HPInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Level20HPInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HPLabels[19])))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Level1SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Level1Label))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Level2Label)
                                    .addComponent(Level2SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Level3Label)
                                    .addComponent(Level3SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Level4Label)
                                    .addComponent(Level4SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Level5Label)
                                    .addComponent(Level5SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Level6Label)
                                    .addComponent(Level6SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Level7Label)
                                    .addComponent(Level7SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Level8Label)
                                    .addComponent(Level8SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Level9Label)
                                    .addComponent(Level9SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Level10Label)
                                    .addComponent(Level10SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Level11SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Level11Label))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Level12Label)
                                    .addComponent(Level12SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Level13Label)
                                    .addComponent(Level13SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Level14Label)
                                    .addComponent(Level14SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Level15Label)
                                    .addComponent(Level15SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Level16Label)
                                    .addComponent(Level16SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Level17Label)
                                    .addComponent(Level17SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Level18Label)
                                    .addComponent(Level18SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Level19Label)
                                    .addComponent(Level19SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Level20Label)
                                    .addComponent(Level20SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ClassSelectOKButton)
                            .addComponent(ClassSelectCancelButton))))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void ClassSelectOKButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
        ClassUpdater();
        origin.updater();
        this.dispose();
    }                                                   
    private void SelectBoxItemStateChanged(java.awt.event.ItemEvent evt) {
        setHPLabels();
    }
    private void ClassSelectCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        // TODO add your handling code here:
        this.dispose();
    }                                                       
    private void setSelected() {
        Selected[0]=Level1SelectBox.getSelectedIndex();
        Selected[1]=Level2SelectBox.getSelectedIndex();
        Selected[2]=Level3SelectBox.getSelectedIndex();
        Selected[3]=Level4SelectBox.getSelectedIndex();
        Selected[4]=Level5SelectBox.getSelectedIndex();
        Selected[5]=Level6SelectBox.getSelectedIndex();
        Selected[6]=Level7SelectBox.getSelectedIndex();
        Selected[7]=Level8SelectBox.getSelectedIndex();
        Selected[8]=Level9SelectBox.getSelectedIndex();
        Selected[9]=Level10SelectBox.getSelectedIndex();
        Selected[10]=Level11SelectBox.getSelectedIndex();
        Selected[11]=Level12SelectBox.getSelectedIndex();
        Selected[12]=Level13SelectBox.getSelectedIndex();
        Selected[13]=Level14SelectBox.getSelectedIndex();
        Selected[14]=Level15SelectBox.getSelectedIndex();
        Selected[15]=Level16SelectBox.getSelectedIndex();
        Selected[16]=Level17SelectBox.getSelectedIndex();
        Selected[17]=Level18SelectBox.getSelectedIndex();
        Selected[18]=Level19SelectBox.getSelectedIndex();
        Selected[19]=Level20SelectBox.getSelectedIndex();        
    }
    private void ClassUpdater() {
        setSelected();
        try {
		
        HPTotals[0]=Integer.parseInt(Level1HPInput.getText());
        HPTotals[1]=Integer.parseInt(Level2HPInput.getText());
        HPTotals[2]=Integer.parseInt(Level3HPInput.getText());
        HPTotals[3]=Integer.parseInt(Level4HPInput.getText());
        HPTotals[4]=Integer.parseInt(Level5HPInput.getText());
        HPTotals[5]=Integer.parseInt(Level6HPInput.getText());
        HPTotals[6]=Integer.parseInt(Level7HPInput.getText());
        HPTotals[7]=Integer.parseInt(Level8HPInput.getText());
        HPTotals[8]=Integer.parseInt(Level9HPInput.getText());
        HPTotals[9]=Integer.parseInt(Level10HPInput.getText());
        HPTotals[10]=Integer.parseInt(Level11HPInput.getText());
        HPTotals[11]=Integer.parseInt(Level12HPInput.getText());
        HPTotals[12]=Integer.parseInt(Level13HPInput.getText());
        HPTotals[13]=Integer.parseInt(Level14HPInput.getText());
        HPTotals[14]=Integer.parseInt(Level15HPInput.getText());
        HPTotals[15]=Integer.parseInt(Level16HPInput.getText());
        HPTotals[16]=Integer.parseInt(Level17HPInput.getText());
        HPTotals[17]=Integer.parseInt(Level18HPInput.getText());
        HPTotals[18]=Integer.parseInt(Level19HPInput.getText());
        HPTotals[19]=Integer.parseInt(Level20HPInput.getText());
        }
        catch(NumberFormatException c) {
            JOptionPane.showMessageDialog(this,"You entered a non-integer into one of the HP Insert Boxes, these must be integers");
            
        }
        int[] toBeSent = new int[20];
        System.arraycopy(Selected, 0, toBeSent, 0, toBeSent.length);
        origin.curChar.setCharLevels(toBeSent);
        origin.curChar.setHPMax(HPTotals);
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClassSelectWindow2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ClassSelectWindow2 dialog = new ClassSelectWindow2(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JButton ClassSelectCancelButton;
    private javax.swing.JButton ClassSelectOKButton;
    private javax.swing.JLabel HPRollsLabel;
    private javax.swing.JTextField Level10HPInput;
    private javax.swing.JLabel Level10Label;
    private javax.swing.JComboBox<String> Level10SelectBox;
    private javax.swing.JTextField Level11HPInput;
    private javax.swing.JLabel Level11Label;
    private javax.swing.JComboBox<String> Level11SelectBox;
    private javax.swing.JTextField Level12HPInput;
    private javax.swing.JLabel Level12Label;
    private javax.swing.JComboBox<String> Level12SelectBox;
    private javax.swing.JTextField Level13HPInput;
    private javax.swing.JLabel Level13Label;
    private javax.swing.JComboBox<String> Level13SelectBox;
    private javax.swing.JTextField Level14HPInput;
    private javax.swing.JLabel Level14Label;
    private javax.swing.JComboBox<String> Level14SelectBox;
    private javax.swing.JTextField Level15HPInput;
    private javax.swing.JLabel Level15Label;
    private javax.swing.JComboBox<String> Level15SelectBox;
    private javax.swing.JTextField Level16HPInput;
    private javax.swing.JLabel Level16Label;
    private javax.swing.JComboBox<String> Level16SelectBox;
    private javax.swing.JTextField Level17HPInput;
    private javax.swing.JLabel Level17Label;
    private javax.swing.JComboBox<String> Level17SelectBox;
    private javax.swing.JTextField Level18HPInput;
    private javax.swing.JLabel Level18Label;
    private javax.swing.JComboBox<String> Level18SelectBox;
    private javax.swing.JTextField Level19HPInput;
    private javax.swing.JLabel Level19Label;
    private javax.swing.JComboBox<String> Level19SelectBox;
    private javax.swing.JTextField Level1HPInput;
    private javax.swing.JLabel Level1Label;
    private javax.swing.JComboBox<String> Level1SelectBox;
    private javax.swing.JTextField Level20HPInput;
    private javax.swing.JLabel Level20Label;
    private javax.swing.JComboBox<String> Level20SelectBox;
    private javax.swing.JTextField Level2HPInput;
    private javax.swing.JLabel Level2Label;
    private javax.swing.JComboBox<String> Level2SelectBox;
    private javax.swing.JTextField Level3HPInput;
    private javax.swing.JLabel Level3Label;
    private javax.swing.JComboBox<String> Level3SelectBox;
    private javax.swing.JTextField Level4HPInput;
    private javax.swing.JLabel Level4Label;
    private javax.swing.JComboBox<String> Level4SelectBox;
    private javax.swing.JTextField Level5HPInput;
    private javax.swing.JLabel Level5Label;
    private javax.swing.JComboBox<String> Level5SelectBox;
    private javax.swing.JTextField Level6HPInput;
    private javax.swing.JLabel Level6Label;
    private javax.swing.JComboBox<String> Level6SelectBox;
    private javax.swing.JTextField Level7HPInput;
    private javax.swing.JLabel Level7Label;
    private javax.swing.JComboBox<String> Level7SelectBox;
    private javax.swing.JTextField Level8HPInput;
    private javax.swing.JLabel Level8Label;
    private javax.swing.JComboBox<String> Level8SelectBox;
    private javax.swing.JTextField Level9HPInput;
    private javax.swing.JLabel Level9Label;
    private javax.swing.JComboBox<String> Level9SelectBox;
    // End of variables declaration                   
    private javax.swing.DefaultComboBoxModel<String> ClassSelectList1 = new javax.swing.DefaultComboBoxModel<>(CharClass.getCharClassNames());
    private javax.swing.DefaultComboBoxModel<String> ClassSelectList2 = new javax.swing.DefaultComboBoxModel<>(CharClass.getCharClassNames());
    private javax.swing.DefaultComboBoxModel<String> ClassSelectList3 = new javax.swing.DefaultComboBoxModel<>(CharClass.getCharClassNames());
    private javax.swing.DefaultComboBoxModel<String> ClassSelectList4 = new javax.swing.DefaultComboBoxModel<>(CharClass.getCharClassNames());
    private javax.swing.DefaultComboBoxModel<String> ClassSelectList5 = new javax.swing.DefaultComboBoxModel<>(CharClass.getCharClassNames());
    private javax.swing.DefaultComboBoxModel<String> ClassSelectList6 = new javax.swing.DefaultComboBoxModel<>(CharClass.getCharClassNames());
    private javax.swing.DefaultComboBoxModel<String> ClassSelectList7 = new javax.swing.DefaultComboBoxModel<>(CharClass.getCharClassNames());
    private javax.swing.DefaultComboBoxModel<String> ClassSelectList8 = new javax.swing.DefaultComboBoxModel<>(CharClass.getCharClassNames());
    private javax.swing.DefaultComboBoxModel<String> ClassSelectList9 = new javax.swing.DefaultComboBoxModel<>(CharClass.getCharClassNames());
    private javax.swing.DefaultComboBoxModel<String> ClassSelectList10 = new javax.swing.DefaultComboBoxModel<>(CharClass.getCharClassNames());
    private javax.swing.DefaultComboBoxModel<String> ClassSelectList11 = new javax.swing.DefaultComboBoxModel<>(CharClass.getCharClassNames());
    private javax.swing.DefaultComboBoxModel<String> ClassSelectList12 = new javax.swing.DefaultComboBoxModel<>(CharClass.getCharClassNames());
    private javax.swing.DefaultComboBoxModel<String> ClassSelectList13 = new javax.swing.DefaultComboBoxModel<>(CharClass.getCharClassNames());
    private javax.swing.DefaultComboBoxModel<String> ClassSelectList14 = new javax.swing.DefaultComboBoxModel<>(CharClass.getCharClassNames());
    private javax.swing.DefaultComboBoxModel<String> ClassSelectList15 = new javax.swing.DefaultComboBoxModel<>(CharClass.getCharClassNames());
    private javax.swing.DefaultComboBoxModel<String> ClassSelectList16 = new javax.swing.DefaultComboBoxModel<>(CharClass.getCharClassNames());
    private javax.swing.DefaultComboBoxModel<String> ClassSelectList17 = new javax.swing.DefaultComboBoxModel<>(CharClass.getCharClassNames());
    private javax.swing.DefaultComboBoxModel<String> ClassSelectList18 = new javax.swing.DefaultComboBoxModel<>(CharClass.getCharClassNames());
    private javax.swing.DefaultComboBoxModel<String> ClassSelectList19 = new javax.swing.DefaultComboBoxModel<>(CharClass.getCharClassNames());
    private javax.swing.DefaultComboBoxModel<String> ClassSelectList20 = new javax.swing.DefaultComboBoxModel<>(CharClass.getCharClassNames());
    static private int[] Selected = new int[20];
    static private int[] HPTotals = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    private JLabel[] HPLabels = new JLabel[20];
}