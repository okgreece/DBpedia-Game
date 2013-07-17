package Games;

import GetData.*;
import java.util.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.net.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.text.*;

public class Game extends javax.swing.JApplet implements ActionListener{
    String word, wordold, wordnew, word2, word3, word4, word6, word8, word9,
              quest,answ,dbpedia,wiki,quest2,dbpedia2,wiki2,quest3,dbpedia3,wiki3,quest4,dbpedia4,wiki4,quest5,dbpedia5,wiki5,
              answ1,answ2,answ3,answ4,answ5,answw,correctanswers,duplicatequestion="";
    String [] question, answer, usersanswer; String[] [] data;
    int frameNumber,indeximages,indexnoimages,mouseoverbutton=0;
    int [] frameNumber1;
    Timer timer;
    boolean frozen = false; boolean [] correct;
    char [] wordarray, word5, word7;
    int count, len, exist, total, game,score,num,comboindex=0,checkindex=0,numofcorrect;
    String name; String [] GamePlayed,Category;
    int TimesPlayed=1000,GameOver=0; int [] indexarray;
    String URI1="http://wiki.el.dbpedia.org/apps/ssg/files/";

    @Override
    public void init() {
       try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }

       try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {

                @Override
                public void run() {
                    initComponents();
                }
            });
       } catch (Exception ex) { }
        
       score=0; total=0;
       jButton25.setVisible(false);jButton27.setVisible(false);
       frameNumber1=new int[TimesPlayed];
       correct=new boolean[TimesPlayed];
       num=0;
       name="Άτομο χωρίς όνομα";
       name=JOptionPane.showInputDialog(null,"Πώς σε λένε;");  
       if (name==null | "".equals(name)) {name="άτομο χωρίς όνομα";}
       jLabel9.setText("Γεια σου "+name);
       for (int i=0;i<TimesPlayed;i++) {frameNumber1[i]=-1;}
       frameNumber = -1;
       jLabel10.setVisible(false);
       GamePlayed=new String[TimesPlayed];
       Category=new String[TimesPlayed];
       question=new String[TimesPlayed];
       answer=new String[TimesPlayed];       
       jScrollPane1.setVisible(false);
       jLabel2.setText(null);
        
       try { 
               URL url = new URL(URI1+"logos/el-dbpedia.png");
               BufferedImage img = ImageIO.read(url);
               Icon icon=new ImageIcon(img);   
               jLabel11.setIcon(icon);
             } catch (IOException e) {System.out.println("1");}
       try { 
               URL url = new URL(URI1+"logos/el-wikipedia.png");
               BufferedImage img = ImageIO.read(url);
               Icon icon=new ImageIcon(img);   
               jLabel12.setIcon(icon);
             } catch (IOException e) {System.out.println("2");}
       try { 
               URL url = new URL(URI1+"logos/auth-math.png");
               BufferedImage img = ImageIO.read(url);
               Icon icon=new ImageIcon(img);   
               jLabel13.setIcon(icon);
             } catch (IOException e) {System.out.println("3");}        
       try { 
               URL url = new URL(URI1+"logos/eldbpedia.png");
               BufferedImage img = ImageIO.read(url);
               Icon icon=new ImageIcon(img);   
               jLabel16.setIcon(icon);
               jLabel19.setIcon(icon);
               jLabel22.setIcon(icon);
               jLabel25.setIcon(icon);
               jLabel30.setIcon(icon);
             } catch (IOException e) {System.out.println("4");}
       try { 
               URL url = new URL(URI1+"logos/wikipedia.png");
               BufferedImage img = ImageIO.read(url);
               Icon icon=new ImageIcon(img);   
               jLabel17.setIcon(icon);
               jLabel20.setIcon(icon);
               jLabel23.setIcon(icon);
               jLabel26.setIcon(icon);
               jLabel31.setIcon(icon);
             } catch (IOException e) {System.out.println("5");}
       try { 
               URL url = new URL(URI1+"smileys/thinking.png");
               BufferedImage smiley = ImageIO.read(url);
               java.awt.Image smiley2=smiley.getScaledInstance(150,150,BufferedImage.SCALE_SMOOTH);
               Icon icon=new ImageIcon(smiley2);   
                jLabel32.setIcon(icon);
             } catch (IOException e) {System.out.println("6");}
       jLabel1.setText("Ερώτηση: 1η");
       ReadFromFile GetData = new ReadFromFile(); indexarray=GetData.index1(); data=GetData.data(indexarray);
       //indeximages=GetData.indeximages();
       //indexnoimages=GetData.indexnoimages();
       //System.out.println("to images= "+indeximages+"kai to no images="+indexnoimages);
       DeActivateAll();
       //if (indexnoimages==1) {GamePlayed[0]="Πολλαπλή Επιλογή (Multiple Choice)"; MultipleChoice();}
       //else if (indeximages==1 && indexnoimages==0) {GamePlayed[num]="Πολλαπλή Επιλογή (1 Εικόνα, 4 Επιλογές)"; Flag();}
       //else if (indexnoimages==0 && indeximages==0) {GamePlayed[num]="Κρεμάλα (Hangman)";Hangman();} 
       GamePlayed[0]="Πολλαπλή Επιλογή (Multiple Choice)"; MultipleChoice();
      
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTextField1 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jTextField2 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton19 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton25 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jButton26 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jButton27 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel32 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(240, 240, 240));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTextField1.setBackground(new java.awt.Color(255, 204, 204));
        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 16));
        jTextField1.setAlignmentX(3.0F);
        jTextField1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextField5.setBackground(new java.awt.Color(255, 204, 102));
        jTextField5.setEditable(false);
        jTextField5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField5.setAlignmentX(3.0F);
        jTextField5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jRadioButton1.setText("1η Απάντηση");
        jRadioButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 16));
        jRadioButton2.setText("2η Απάντηση");
        jRadioButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Tahoma", 0, 16));
        jRadioButton3.setText("3η Απάντηση");
        jRadioButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Tahoma", 0, 16));
        jRadioButton4.setText("4η Απάντηση");
        jRadioButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Εικόνα");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Κείμενο 1");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Κείμενο 2");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Κείμενο 3");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Κείμενο 4");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jComboBox1.setMaximumRowCount(4);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jComboBox4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jTextField2.setBackground(new java.awt.Color(204, 204, 255));
        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 16));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField6.setBackground(new java.awt.Color(204, 204, 255));
        jTextField6.setEditable(false);
        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 16));
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton19.setFont(new java.awt.Font("Tahoma", 0, 18));
        jButton19.setText("Τ");
        jButton19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton19.setDefaultCapable(false);
        jButton19.setPreferredSize(new java.awt.Dimension(41, 23));
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton17.setFont(new java.awt.Font("Tahoma", 0, 18));
        jButton17.setText("Ρ");
        jButton17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton17.setDefaultCapable(false);
        jButton17.setPreferredSize(new java.awt.Dimension(41, 23));
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setFont(new java.awt.Font("Tahoma", 0, 18));
        jButton18.setText("Σ");
        jButton18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton18.setDefaultCapable(false);
        jButton18.setPreferredSize(new java.awt.Dimension(41, 23));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton15.setFont(new java.awt.Font("Tahoma", 0, 18));
        jButton15.setText("Ο");
        jButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton15.setDefaultCapable(false);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setFont(new java.awt.Font("Tahoma", 0, 18));
        jButton16.setText("Π");
        jButton16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton16.setDefaultCapable(false);
        jButton16.setPreferredSize(new java.awt.Dimension(41, 23));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton22.setFont(new java.awt.Font("Tahoma", 0, 18));
        jButton22.setText("Χ");
        jButton22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton22.setDefaultCapable(false);
        jButton22.setPreferredSize(new java.awt.Dimension(41, 23));
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Tahoma", 0, 18));
        jButton13.setText("Ν");
        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton13.setDefaultCapable(false);
        jButton13.setPreferredSize(new java.awt.Dimension(41, 23));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton23.setFont(new java.awt.Font("Tahoma", 0, 18));
        jButton23.setText("Ψ");
        jButton23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton23.setDefaultCapable(false);
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton14.setFont(new java.awt.Font("Tahoma", 0, 18));
        jButton14.setText("Ξ");
        jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton14.setDefaultCapable(false);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton24.setFont(new java.awt.Font("Tahoma", 0, 18));
        jButton24.setText("Ω");
        jButton24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton24.setDefaultCapable(false);
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Tahoma", 0, 18));
        jButton11.setText("Λ");
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.setDefaultCapable(false);
        jButton11.setPreferredSize(new java.awt.Dimension(41, 23));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Tahoma", 0, 18));
        jButton12.setText("Μ");
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.setDefaultCapable(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 18));
        jButton10.setText("Κ");
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.setDefaultCapable(false);
        jButton10.setPreferredSize(new java.awt.Dimension(41, 23));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton20.setFont(new java.awt.Font("Tahoma", 0, 18));
        jButton20.setText("Υ");
        jButton20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton20.setDefaultCapable(false);
        jButton20.setPreferredSize(new java.awt.Dimension(41, 23));
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setFont(new java.awt.Font("Tahoma", 0, 18));
        jButton21.setText("Φ");
        jButton21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton21.setDefaultCapable(false);
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("Γ");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setDefaultCapable(false);
        jButton3.setPreferredSize(new java.awt.Dimension(41, 23));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18));
        jButton2.setText("Β");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setDefaultCapable(false);
        jButton2.setPreferredSize(new java.awt.Dimension(41, 23));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18));
        jButton1.setText("Α");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setDefaultCapable(false);
        jButton1.setPreferredSize(new java.awt.Dimension(41, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 18));
        jButton7.setText("Η");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setDefaultCapable(false);
        jButton7.setPreferredSize(new java.awt.Dimension(41, 23));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 18));
        jButton6.setText("Ζ");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setDefaultCapable(false);
        jButton6.setPreferredSize(new java.awt.Dimension(41, 23));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 18));
        jButton5.setText("Ε");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setDefaultCapable(false);
        jButton5.setPreferredSize(new java.awt.Dimension(41, 23));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18));
        jButton4.setText("Δ");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setDefaultCapable(false);
        jButton4.setPreferredSize(new java.awt.Dimension(41, 23));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 18));
        jButton9.setText("Ι");
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.setDefaultCapable(false);
        jButton9.setPreferredSize(new java.awt.Dimension(41, 23));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 18));
        jButton8.setText("Θ");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.setDefaultCapable(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ιωάννης\\Desktop\\ΤΡΕΧΟΝΤΑ\\hangman\\hanged0.jpg")); // NOI18N

        jLabel1.setText("Ερώτηση:");

        jLabel8.setText("Χρόνος");

        jLabel9.setText("Όνομα");

        jLabel7.setText("Συνολικός Χρόνος");

        jLabel14.setText("Βαθμολογία: 0 / 0");

        jButton25.setFont(new java.awt.Font("Tahoma", 0, 13));
        jButton25.setText("Επόμενη Ερώτηση");
        jButton25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel15.setForeground(new java.awt.Color(51, 51, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Για περισσότερες πληροφορίες σχετικά με: ");

        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });

        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel18.setForeground(new java.awt.Color(51, 51, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Για περισσότερες πληροφορίες σχετικά με: ");

        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel21.setForeground(new java.awt.Color(51, 51, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Για περισσότερες πληροφορίες σχετικά με: ");

        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel24.setForeground(new java.awt.Color(51, 51, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Για περισσότερες πληροφορίες σχετικά με: ");

        jLabel25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });

        jLabel26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });

        jButton26.setFont(new java.awt.Font("Tahoma", 0, 13));
        jButton26.setText("Υποβολή");
        jButton26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 16));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Ερώτημα");

        jLabel28.setText("Κατηγορία: Γενικές Γνώσεις");

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jCheckBox1.setText("1η Απάντηση");
        jCheckBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jCheckBox2.setText("2η Απάντηση");
        jCheckBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 16));
        jCheckBox3.setText("3η Απάντηση");
        jCheckBox3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 16));
        jCheckBox4.setText("4η Απάντηση");
        jCheckBox4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 16));
        jCheckBox5.setText("5η Απάντηση");
        jCheckBox5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        buttonGroup1.add(jRadioButton5);
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel29.setForeground(new java.awt.Color(51, 51, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Για περισσότερες πληροφορίες σχετικά με: ");

        jLabel30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
        });

        jLabel31.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
        });

        jButton27.setFont(new java.awt.Font("Tahoma", 1, 36));
        jButton27.setForeground(new java.awt.Color(255, 0, 0));
        jButton27.setText("X");
        jButton27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton27MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton27MouseEntered(evt);
            }
        });
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 2, 12)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5000);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel32.setText("Smiley");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(260, 260, 260)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(194, 194, 194)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(669, 669, 669))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 989, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(321, 321, 321))
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 989, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(804, 804, 804))
            .addGroup(layout.createSequentialGroup()
                .addGap(382, 382, 382)
                .addComponent(jRadioButton5)
                .addContainerGap(870, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 989, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(389, 389, 389)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel27)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(985, 985, 985))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 989, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(274, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 989, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(52, 52, 52)))
                .addGap(804, 804, 804))
            .addGroup(layout.createSequentialGroup()
                .addGap(404, 404, 404)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox5)
                    .addComponent(jCheckBox4)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox1)
                    .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                    .addComponent(jRadioButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                    .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(835, 835, 835))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jCheckBox1, jCheckBox2, jCheckBox3, jCheckBox4, jCheckBox5, jRadioButton1, jRadioButton2, jRadioButton3, jRadioButton4});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel27, jTextField1, jTextField2, jTextField5, jTextField6});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel16, jLabel19, jLabel22, jLabel25});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel17, jLabel20, jLabel23, jLabel26});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton25, jButton26});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton10, jButton11, jButton12, jButton13, jButton14, jButton15, jButton16, jButton17, jButton18, jButton19, jButton2, jButton20, jButton21, jButton22, jButton23, jButton24, jButton3, jButton4, jButton5, jButton6, jButton7, jButton8, jButton9});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel24, jLabel29});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel3, jLabel4, jLabel5, jLabel6});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBox1, jComboBox2, jComboBox3, jComboBox4});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton1)
                        .addGap(9, 9, 9)
                        .addComponent(jRadioButton2)
                        .addGap(9, 9, 9)
                        .addComponent(jRadioButton3)
                        .addGap(9, 9, 9)
                        .addComponent(jRadioButton4)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckBox1)
                        .addGap(9, 9, 9)
                        .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jCheckBox3)
                        .addGap(9, 9, 9)
                        .addComponent(jCheckBox4)
                        .addGap(9, 9, 9)
                        .addComponent(jCheckBox5)
                        .addGap(0, 0, 0)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel14, jLabel28, jLabel7, jLabel8, jLabel9});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel11, jLabel12});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel15, jLabel16, jLabel17, jLabel18, jLabel19, jLabel20, jLabel21, jLabel22, jLabel23, jLabel24, jLabel25, jLabel26, jLabel29, jLabel30, jLabel31});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton25, jButton26});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton10, jButton11, jButton12, jButton13, jButton14, jButton15, jButton16, jButton17, jButton18, jButton19, jButton2, jButton20, jButton21, jButton22, jButton23, jButton24, jButton3, jButton4, jButton5, jButton6, jButton7, jButton8, jButton9});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jComboBox1, jComboBox2, jComboBox3, jComboBox4, jLabel3, jLabel4, jLabel5, jLabel6});

    }// </editor-fold>//GEN-END:initComponents

    public int count1 () {
       if (word.equals(word9)) {count=11; }
       if (count==0)  jTextField2.setText("Απομένουν 6 λάθος επιλογές");
       if (count==1)  {
            jTextField2.setText("Απομένουν 5 λάθος επιλογές");   
            try { 
               URL url = new URL(URI1+"hangman/hanged1.jpg");
               BufferedImage img = ImageIO.read(url);
               Icon icon=new ImageIcon(img);   
               jLabel10.setIcon(icon);
            } catch (IOException e) {}
            }   
       if (count==2)  {
            jTextField2.setText("Απομένουν 4 λάθος επιλογές");
            try { 
               URL url = new URL(URI1+"hangman/hanged2.jpg");
               BufferedImage img = ImageIO.read(url);
               Icon icon=new ImageIcon(img);   
               jLabel10.setIcon(icon);
            } catch (IOException e) {}
       }
       if (count==3)  {
            jTextField2.setText("Απομένουν 3 λάθος επιλογές");
            try { 
               URL url = new URL(URI1+"hangman/hanged3.jpg");
               BufferedImage img = ImageIO.read(url);
               Icon icon=new ImageIcon(img);   
               jLabel10.setIcon(icon);
            } catch (IOException e) {}
        }
       if (count==4)  {
            jTextField2.setText("Απομένουν 2 λάθος επιλογές");
            try { 
               URL url = new URL(URI1+"hangman/hanged4.jpg");
               BufferedImage img = ImageIO.read(url);
               Icon icon=new ImageIcon(img);   
               jLabel10.setIcon(icon);
            } catch (IOException e) {}
       }
       if (count==5)  {
            jTextField2.setText("Απομένει 1 λάθος επιλογή");
            try { 
               URL url = new URL(URI1+"hangman/hanged5.jpg");
               BufferedImage img = ImageIO.read(url);
               Icon icon=new ImageIcon(img);   
               jLabel10.setIcon(icon);
            } catch (IOException e) {}
       }
       if (count==6) {
          jButton1.setEnabled(false); jButton2.setEnabled(false); jButton3.setEnabled(false);
          jButton4.setEnabled(false); jButton5.setEnabled(false); jButton6.setEnabled(false); 
          jButton7.setEnabled(false); jButton8.setEnabled(false); jButton9.setEnabled(false);
          jButton10.setEnabled(false); jButton11.setEnabled(false); jButton12.setEnabled(false);
          jButton13.setEnabled(false); jButton14.setEnabled(false); jButton15.setEnabled(false);
          jButton16.setEnabled(false); jButton17.setEnabled(false); jButton18.setEnabled(false); 
          jButton19.setEnabled(false); jButton20.setEnabled(false); jButton21.setEnabled(false);
          jButton22.setEnabled(false); jButton23.setEnabled(false); jButton24.setEnabled(false);
          jTextField2.setText("Λυπάμαι δεν το βρήκες! Η σωστή απάντηση ήταν: "+word);
          total++;
          frozen = true;stopAnimation();
          jButton25.setVisible(true);
          correct[num]=false;
          try { 
               URL url = new URL(URI1+"hangman/hanged6.jpg");
               BufferedImage img = ImageIO.read(url);
               Icon icon=new ImageIcon(img);   
               jLabel10.setIcon(icon);
            } catch (IOException e) {}
          jLabel15.setVisible(true);jLabel16.setVisible(true);jLabel17.setVisible(true);
          jLabel15.setText("Για περισσότερες πληροφορίες σχετικά με: "+quest);
          try { 
               URL url = new URL(URI1+"smileys/sad.png");
               BufferedImage smiley = ImageIO.read(url);
               java.awt.Image smiley2=smiley.getScaledInstance(150,150,BufferedImage.SCALE_SMOOTH);
               Icon icon=new ImageIcon(smiley2);   
                jLabel32.setIcon(icon);
             } catch (IOException e) {}
          if (num==TimesPlayed-1) EndGame();
       }
       if (count==11) {
          jButton1.setEnabled(false); jButton2.setEnabled(false); jButton3.setEnabled(false);
          jButton4.setEnabled(false); jButton5.setEnabled(false); jButton6.setEnabled(false); 
          jButton7.setEnabled(false); jButton8.setEnabled(false); jButton9.setEnabled(false);
          jButton10.setEnabled(false); jButton11.setEnabled(false); jButton12.setEnabled(false);
          jButton13.setEnabled(false); jButton14.setEnabled(false); jButton15.setEnabled(false);
          jButton16.setEnabled(false); jButton17.setEnabled(false); jButton18.setEnabled(false); 
          jButton19.setEnabled(false); jButton20.setEnabled(false); jButton21.setEnabled(false);
          jButton22.setEnabled(false); jButton23.setEnabled(false); jButton24.setEnabled(false);
          jTextField2.setText("Μπράβο, το βρήκες!"); score++; total++;
          frozen = true;stopAnimation();
           try { 
               URL url = new URL(URI1+"smileys/smile.png");
               BufferedImage smiley = ImageIO.read(url);
               java.awt.Image smiley2=smiley.getScaledInstance(150,150,BufferedImage.SCALE_SMOOTH);
               Icon icon=new ImageIcon(smiley2);   
                jLabel32.setIcon(icon);
             } catch (IOException e) {}
          jButton25.setVisible(true);
          correct[num]=true;
          jLabel15.setVisible(true);jLabel16.setVisible(true);jLabel17.setVisible(true);
          jLabel15.setText("Για περισσότερες πληροφορίες σχετικά με: "+quest);
          if (num==TimesPlayed-1) EndGame();
       }
       jLabel14.setText("Βαθμολογία: "+score+" / "+total);
       return count;
}

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       word3=word3.replace('Α', '*'); 
       exist=0;

       for (int i = 0; i < len; i++) {
            if (word5[i]=='Α') {
                word7[i]='Α';
                exist=1;
             }
       }
   
       if (exist==0) count=count+1;
       word8="";
       word9="";
       for (int i = 0; i < len; i++) {
            word8 = word8+word7[i]+' ';
            word9 = word9+word7[i];
       }
    
       jTextField5.setText(word8);      
       jButton1.setEnabled(false);    
       count1(); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       word3=word3.replace('Β', '*'); 
       exist=0;
    
       for (int i = 0; i < len; i++) {
            if (word5[i]=='Β') {
                word7[i]='Β';
                exist=1;
            }
       }
   
       if (exist==0) count=count+1;
       word8="";
       word9="";
       for (int i = 0; i < len; i++) {
            word8 = word8+word7[i]+' ';
            word9=word9+word7[i];
       }
    
       jTextField5.setText(word8);
       jButton2.setEnabled(false);  
       count1(); 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       word3=word3.replace('Γ', '*'); 
       exist=0;
    
       for (int i = 0; i < len; i++) {
            if (word5[i]=='Γ') {
                word7[i]='Γ';
                exist=1;
            }
       }
   
       if (exist==0) count=count+1;
       word8="";
       word9="";
   
       for (int i = 0; i < len; i++) {
            word8 = word8+word7[i]+' ';
            word9=word9+word7[i];
       }
    
       jTextField5.setText(word8);
       jButton3.setEnabled(false);  
       count1();  
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       word3=word3.replace('Δ', '*'); 
       exist=0;
   
       for (int i = 0; i < len; i++) {
            if (word5[i]=='Δ') {
                word7[i]='Δ';
                exist=1;
            }
       }
   
       if (exist==0) count=count+1;
       word8="";   
       word9="";
       for (int i = 0; i < len; i++) {
            word8 = word8+word7[i]+' ';
            word9 = word9+word7[i];
       }
    
       jTextField5.setText(word8);
       jButton4.setEnabled(false);  
       count1(); 
    }//GEN-LAST:event_jButton4ActionPerformed

        private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       word3=word3.replace('Ε', '*'); 
       exist=0;
   
       for (int i = 0; i < len; i++) {
            if (word5[i]=='Ε') {
                word7[i]='Ε';
                exist=1;
            }
       }
   
       if (exist==0) count=count+1;
       word8="";   
       word9="";
       for (int i = 0; i < len; i++) {
            word8 = word8+word7[i]+' ';
            word9 = word9+word7[i];
       }

       jTextField5.setText(word8);
       jButton5.setEnabled(false);  
       count1(); 
    }//GEN-LAST:event_jButton5ActionPerformed

        private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       word3=word3.replace('Ζ', '*'); 
       exist=0;
    
       for (int i = 0; i < len; i++) {
            if (word5[i]=='Ζ') {
                word7[i]='Ζ';
                exist=1;
            }
       }
   
       if (exist==0) count=count+1;
       word8="";     
       word9="";
       for (int i = 0; i < len; i++) {
            word8 = word8+word7[i]+' ';
            word9=word9+word7[i];
       }

       jTextField5.setText(word8);
       jButton6.setEnabled(false);  
       count1(); 
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       word3=word3.replace('Η', '*'); 
       exist=0;  

       for (int i = 0; i < len; i++) {
            if (word5[i]=='Η') {
                word7[i]='Η';
                exist=1;
            }
       }
   
       if (exist==0) count=count+1;
       word8="";     
       word9="";
       for (int i = 0; i < len; i++) {
            word8 = word8+word7[i]+' ';
            word9=word9+word7[i];
       }
    
       jTextField5.setText(word8);
       jButton7.setEnabled(false);  
       count1(); 
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       word3=word3.replace('Θ', '*'); 
       exist=0;
    
       for (int i = 0; i < len; i++) {
            if (word5[i]=='Θ') {
                word7[i]='Θ';
                exist=1;
            }
       }
   
       if (exist==0) count=count+1;
       word8="";     
       word9="";
       for (int i = 0; i < len; i++) {
            word8 = word8+word7[i]+' ';
            word9=word9+word7[i];
       }
    
       jTextField5.setText(word8);
       jButton8.setEnabled(false);  
       count1();  
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
       word3=word3.replace('Ι', '*'); 
       exist=0;
    
       for (int i = 0; i < len; i++) {
            if (word5[i]=='Ι') {
                word7[i]='Ι';
                exist=1;
            }
       }
   
        if (exist==0) count=count+1;
       word8="";     
       word9="";
       for (int i = 0; i < len; i++) {
            word8 = word8+word7[i]+' ';
            word9=word9+word7[i];
       }
    
       jTextField5.setText(word8);
       jButton9.setEnabled(false);  
       count1(); 
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
       word3=word3.replace('Κ', '*'); 
       exist=0;
    
       for (int i = 0; i < len; i++) {
            if (word5[i]=='Κ') {
                word7[i]='Κ';
                exist=1;
            }
       }
   
       if (exist==0) count=count+1;
       word8="";     
       word9="";
       for (int i = 0; i < len; i++) {
            word8 = word8+word7[i]+' ';
            word9=word9+word7[i];
       }
    
       jTextField5.setText(word8);
       jButton10.setEnabled(false);  
       count1(); 
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
       word3=word3.replace('Λ', '*'); 
       exist=0;

       for (int i = 0; i < len; i++) {
            if (word5[i]=='Λ') {
                word7[i]='Λ';
                exist=1;
            }
       }
       
       if (exist==0) count=count+1;
       word8="";     
       word9="";
       for (int i = 0; i < len; i++) {
            word8 = word8+word7[i]+' ';
            word9=word9+word7[i];
       }
 
       jTextField5.setText(word8);
       jButton11.setEnabled(false);  
       count1(); 
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
       word3=word3.replace('Μ', '*'); 
       exist=0; 

       for (int i = 0; i < len; i++) {
            if (word5[i]=='Μ') {
                word7[i]='Μ';
                exist=1;
            }
       }
   
       if (exist==0) count=count+1;
       word8="";     
       word9="";
       for (int i = 0; i < len; i++) {
            word8 = word8+word7[i]+' ';
            word9=word9+word7[i];
       }
    
       jTextField5.setText(word8);
       jButton12.setEnabled(false);  
       count1(); 
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
       word3=word3.replace('Ν', '*'); 
       exist=0;
    
       for (int i = 0; i < len; i++) {
            if (word5[i]=='Ν') {
                word7[i]='Ν';
                exist=1;
            }
       }
       
       if (exist==0) count=count+1;
       word8="";     
       word9="";
       for (int i = 0; i < len; i++) {
            word8 = word8+word7[i]+' ';
            word9=word9+word7[i];
       }

       jTextField5.setText(word8);
       jButton13.setEnabled(false);  
       count1(); 
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
       word3=word3.replace('Ξ', '*'); 
       exist=0;

       for (int i = 0; i < len; i++) {
            if (word5[i]=='Ξ') {
                word7[i]='Ξ';
                exist=1;
            }
       }
   
       if (exist==0) count=count+1;
       word8="";     
       word9="";
       for (int i = 0; i < len; i++) {
            word8 = word8+word7[i]+' ';
            word9=word9+word7[i];
       }
 
       jTextField5.setText(word8);
       jButton14.setEnabled(false);  
       count1(); 
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
       word3=word3.replace('Ο', '*'); 
       exist=0;
    
       for (int i = 0; i < len; i++) {
            if (word5[i]=='Ο') {
                word7[i]='Ο';
                exist=1;
            }
       }
   
       if (exist==0) count=count+1;
       word8="";     
       word9="";
       for (int i = 0; i < len; i++) {
            word8 = word8+word7[i]+' ';
            word9=word9+word7[i];
       }

       jTextField5.setText(word8);
       jButton15.setEnabled(false);  
       count1(); 
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
       word3=word3.replace('Π', '*'); 
       exist=0;
    
       for (int i = 0; i < len; i++) {
            if (word5[i]=='Π') {
                word7[i]='Π';
                exist=1;
            }
       }
   
       if (exist==0) count=count+1;
       word8="";     
       word9="";
       for (int i = 0; i < len; i++) {
            word8 = word8+word7[i]+' ';
            word9=word9+word7[i];
       }
    
       jTextField5.setText(word8);
       jButton16.setEnabled(false);  
       count1(); 
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
       word3=word3.replace('Ρ', '*'); 
       exist=0;
  
       for (int i = 0; i < len; i++) {
            if (word5[i]=='Ρ') {
                word7[i]='Ρ';
                exist=1;
            }
       }
   
       if (exist==0) count=count+1;
       word8="";     
       word9="";
       for (int i = 0; i < len; i++) {
            word8 = word8+word7[i]+' ';
            word9=word9+word7[i];
       }
    
       jTextField5.setText(word8);
       jButton17.setEnabled(false);  
       count1(); 
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
       word3=word3.replace('Σ', '*'); 
       exist=0;
    
       for (int i = 0; i < len; i++) {
            if (word5[i]=='Σ') {
                word7[i]='Σ';
                exist=1;
            }
       }
   
       if (exist==0) count=count+1;
       word8="";     
       word9="";
       for (int i = 0; i < len; i++) {
            word8 = word8+word7[i]+' ';
            word9=word9+word7[i];
       }
    
       jTextField5.setText(word8);
       jButton18.setEnabled(false);  
       count1(); 
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
       word3=word3.replace('Τ', '*'); 
       exist=0;
    
       for (int i = 0; i < len; i++) {
            if (word5[i]=='Τ') {
                word7[i]='Τ';
                exist=1;
            }
       }
   
       if (exist==0) count=count+1;
       word8="";     
       word9="";
       for (int i = 0; i < len; i++) {
            word8 = word8+word7[i]+' ';
            word9=word9+word7[i];
       }
    
       jTextField5.setText(word8);
       jButton19.setEnabled(false);  
       count1(); 
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
       word3=word3.replace('Υ', '*'); 
       exist=0;
    
       for (int i = 0; i < len; i++) {
            if (word5[i]=='Υ') {
                word7[i]='Υ';
                exist=1;
            }
       }
   
       if (exist==0) count=count+1;
       word8="";     
       word9="";
       for (int i = 0; i < len; i++) {
            word8 = word8+word7[i]+' ';
            word9=word9+word7[i];
       }
    
       jTextField5.setText(word8);
       jButton20.setEnabled(false);  
       count1(); 
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
       word3=word3.replace('Φ', '*'); 
       exist=0;
    
       for (int i = 0; i < len; i++) {
            if (word5[i]=='Φ') {
                word7[i]='Φ';
                exist=1;
            }
       }
   
       if (exist==0) count=count+1;
       word8="";     
       word9="";
       for (int i = 0; i < len; i++) {
            word8 = word8+word7[i]+' ';
            word9=word9+word7[i];
       }
    
       jTextField5.setText(word8);
       jButton21.setEnabled(false);  
       count1(); 
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
       word3=word3.replace('Χ', '*'); 
       exist=0;
    
       for (int i = 0; i < len; i++) {
            if (word5[i]=='Χ') {
                word7[i]='Χ';
                exist=1;
            }
       }
   
       if (exist==0) count=count+1;
       word8="";     
       word9="";
       for (int i = 0; i < len; i++) {
            word8 = word8+word7[i]+' ';
            word9=word9+word7[i];
       }
    
       jTextField5.setText(word8);
       jButton22.setEnabled(false);  
       count1(); 
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
       word3=word3.replace('Ψ', '*'); 
       exist=0;
    
       for (int i = 0; i < len; i++) {
            if (word5[i]=='Ψ') {
                word7[i]='Ψ';
                exist=1;
            }
       }
   
       if (exist==0) count=count+1;
       word8="";     
       word9="";
       for (int i = 0; i < len; i++) {
            word8 = word8+word7[i]+' ';
            word9=word9+word7[i];
       }
    
       jTextField5.setText(word8);
       jButton23.setEnabled(false);  
       count1(); 
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
       word3=word3.replace('Ω', '*'); 
       exist=0;
    
       for (int i = 0; i < len; i++) {
            if (word5[i]=='Ω') {
                word7[i]='Ω';
                exist=1;
             }
       }
   
       if (exist==0) count=count+1;
       word8="";     
       word9="";
       for (int i = 0; i < len; i++) {
            word8 = word8+word7[i]+' ';
            word9=word9+word7[i];
       }
    
       jTextField5.setText(word8);
       jButton24.setEnabled(false);  
       count1(); 
    }//GEN-LAST:event_jButton24ActionPerformed
    
    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
       
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
       frozen = true;
       stopAnimation();
       String b= answ1;
       jRadioButton1.setEnabled(false);
       jRadioButton2.setEnabled(false);
       jRadioButton3.setEnabled(false);
       jRadioButton4.setEnabled(false);
     
       if (b.equals(answ)) {
           jTextField2.setText("Μπράβο, το βρήκες!");    
           score++;correct[num]=true;
           try { 
               URL url = new URL(URI1+"smileys/smile.png");
               BufferedImage smiley = ImageIO.read(url);
               java.awt.Image smiley2=smiley.getScaledInstance(150,150,BufferedImage.SCALE_SMOOTH);
               Icon icon=new ImageIcon(smiley2);   
               jLabel32.setIcon(icon);
           } catch (IOException e) {}
         
       }
       else {
           if (game==5 )  jTextField2.setText("Λυπάμαι, λάθος! Η σωστή απάντηση είναι: "+answw);
           else if (game!=5) jTextField2.setText("Λυπάμαι, λάθος! Η σωστή απάντηση είναι: "+answ);
           correct[num]=false;
           try { 
               URL url = new URL(URI1+"smileys/sad.png");
               BufferedImage smiley = ImageIO.read(url);
               java.awt.Image smiley2=smiley.getScaledInstance(150,150,BufferedImage.SCALE_SMOOTH);
               Icon icon=new ImageIcon(smiley2);   
               jLabel32.setIcon(icon);
             } catch (IOException e) {}
       } 

       total++;
       if (game==1){
         jRadioButton1.setText(answ1);
         jRadioButton2.setText(answ2);
         jRadioButton3.setText(answ3);
         jRadioButton4.setText(answ4);     
       }
       jLabel14.setText("Βαθμολογία: "+score+" / "+total);
       jButton25.setVisible(true);
       jLabel15.setVisible(true);jLabel16.setVisible(true);jLabel17.setVisible(true);
       jLabel15.setText("Για περισσότερες πληροφορίες σχετικά με: "+quest);
       if (num==TimesPlayed-1) EndGame();
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
       frozen = true;
       stopAnimation();
       String b= answ2;
       jRadioButton1.setEnabled(false);
       jRadioButton2.setEnabled(false);
       jRadioButton3.setEnabled(false);
       jRadioButton4.setEnabled(false);
     
       if (b.equals(answ)) {
           jTextField2.setText("Μπράβο, το βρήκες!");
           score++;correct[num]=true;
           try { 
               URL url = new URL(URI1+"smileys/smile.png");
               BufferedImage smiley = ImageIO.read(url);
               java.awt.Image smiley2=smiley.getScaledInstance(150,150,BufferedImage.SCALE_SMOOTH);
               Icon icon=new ImageIcon(smiley2);   
               jLabel32.setIcon(icon);
             } catch (IOException e) {}
       }
       else {
           if (game==5 )  jTextField2.setText("Λυπάμαι, λάθος! Η σωστή απάντηση είναι: "+answw);
          else if (game!=5)  jTextField2.setText("Λυπάμαι, λάθος! Η σωστή απάντηση είναι: "+answ);
           correct[num]=false;
           try { 
               URL url = new URL(URI1+"smileys/sad.png");
               BufferedImage smiley = ImageIO.read(url);
               java.awt.Image smiley2=smiley.getScaledInstance(150,150,BufferedImage.SCALE_SMOOTH);
               Icon icon=new ImageIcon(smiley2);   
               jLabel32.setIcon(icon);
             } catch (IOException e) {}
       } 

       total++;
       if (game==1){
         jRadioButton1.setText(answ1);
         jRadioButton2.setText(answ2);
         jRadioButton3.setText(answ3);
         jRadioButton4.setText(answ4);     
       }
       jLabel14.setText("Βαθμολογία: "+score+" / "+total);
       jButton25.setVisible(true);
       jLabel15.setVisible(true);jLabel16.setVisible(true);jLabel17.setVisible(true);
       jLabel15.setText("Για περισσότερες πληροφορίες σχετικά με: "+quest);
       if (num==TimesPlayed-1) EndGame();
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
       frozen = true;
       stopAnimation();
       String b= answ3;
       jRadioButton1.setEnabled(false);
       jRadioButton2.setEnabled(false);
       jRadioButton3.setEnabled(false);
       jRadioButton4.setEnabled(false);
     
       if (b.equals(answ)) {
           jTextField2.setText("Μπράβο, το βρήκες!");
           score++;correct[num]=true;
           try { 
               URL url = new URL(URI1+"smileys/smile.png");
               BufferedImage smiley = ImageIO.read(url);
               java.awt.Image smiley2=smiley.getScaledInstance(150,150,BufferedImage.SCALE_SMOOTH);
               Icon icon=new ImageIcon(smiley2);   
               jLabel32.setIcon(icon);
             } catch (IOException e) {}
       }
       else {
           if (game==5 ) jTextField2.setText("Λυπάμαι, λάθος! Η σωστή απάντηση είναι: "+answw);
           else if (game!=5) jTextField2.setText("Λυπάμαι, λάθος! Η σωστή απάντηση είναι: "+answ);
           correct[num]=false;
           try { 
               URL url = new URL(URI1+"smileys/sad.png");
               BufferedImage smiley = ImageIO.read(url);
               java.awt.Image smiley2=smiley.getScaledInstance(150,150,BufferedImage.SCALE_SMOOTH);
               Icon icon=new ImageIcon(smiley2);   
                jLabel32.setIcon(icon);
             } catch (IOException e) {}
       } 

       total++;
       if (game==1){
         jRadioButton1.setText(answ1);
         jRadioButton2.setText(answ2);
         jRadioButton3.setText(answ3);
         jRadioButton4.setText(answ4);     
       }
       jLabel14.setText("Βαθμολογία: "+score+" / "+total);
       jButton25.setVisible(true);
       jLabel15.setVisible(true);jLabel16.setVisible(true);jLabel17.setVisible(true);
       jLabel15.setText("Για περισσότερες πληροφορίες σχετικά με: "+quest);
       if (num==TimesPlayed-1) EndGame();
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
       frozen = true;
       stopAnimation();
       String b= answ4;
       jRadioButton1.setEnabled(false);
       jRadioButton2.setEnabled(false);
       jRadioButton3.setEnabled(false);
       jRadioButton4.setEnabled(false);
     
       if (b.equals(answ)) {
           jTextField2.setText("Μπράβο, το βρήκες!");
           score++;correct[num]=true;
           try { 
               URL url = new URL(URI1+"smileys/smile.png");
               BufferedImage smiley = ImageIO.read(url);
               java.awt.Image smiley2=smiley.getScaledInstance(150,150,BufferedImage.SCALE_SMOOTH);
               Icon icon=new ImageIcon(smiley2);   
               jLabel32.setIcon(icon);
             } catch (IOException e) {}
       }
       else {
           if (game==5 ) jTextField2.setText("Λυπάμαι, λάθος! Η σωστή απάντηση είναι: "+answw);
           else if (game!=5) jTextField2.setText("Λυπάμαι, λάθος! Η σωστή απάντηση είναι: "+answ);
           correct[num]=false;
           try { 
               URL url = new URL(URI1+"smileys/sad.png");
               BufferedImage smiley = ImageIO.read(url);
               java.awt.Image smiley2=smiley.getScaledInstance(150,150,BufferedImage.SCALE_SMOOTH);
               Icon icon=new ImageIcon(smiley2);   
               jLabel32.setIcon(icon);
             } catch (IOException e) {}
       } 

       total++;
       if (game==1){
         jRadioButton1.setText(answ1);
         jRadioButton2.setText(answ2);
         jRadioButton3.setText(answ3);
         jRadioButton4.setText(answ4);     
       }
       jLabel14.setText("Βαθμολογία: "+score+" / "+total);
       jButton25.setVisible(true);
       jLabel15.setVisible(true);jLabel16.setVisible(true);jLabel17.setVisible(true);
       jLabel15.setText("Για περισσότερες πληροφορίες σχετικά με: "+quest);
       if (num==TimesPlayed-1) EndGame();
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
       DeActivateAll();
       ChooseGame();
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
       String command="cmd.exe /c start ";
       String site=command+dbpedia;
             
       try {
               Process pc = Runtime.getRuntime().exec(site);
              } catch (IOException ex) {JOptionPane.showMessageDialog(this, "Ο σύνδεσμος δε λειτουργεί!");}
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
       String command="cmd.exe /c start ";
       String site=command+wiki;
            
       try {
               Process pc = Runtime.getRuntime().exec(site);
             } catch (IOException ex) {JOptionPane.showMessageDialog(this, "Ο σύνδεσμος δε λειτουργεί!");}
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
       frozen = true;         
       stopAnimation();         
       double sc = 0.0;     
      
       jLabel15.setVisible(true); jLabel16.setVisible(true); jLabel17.setVisible(true);   
       jLabel18.setVisible(true);jLabel19.setVisible(true);jLabel20.setVisible(true);
       jComboBox1.setEnabled(false);jComboBox2.setEnabled(false);     
       jComboBox3.setEnabled(false);jComboBox4.setEnabled(false);    
       jButton26.setEnabled(false);    
       jCheckBox1.setEnabled(false);jCheckBox2.setEnabled(false);jCheckBox3.setEnabled(false);
       jCheckBox4.setEnabled(false);jCheckBox5.setEnabled(false);

       if (game==6) {
            jLabel15.setText("Για περισσότερες πληροφορίες σχετικά με: " + quest);  
            jLabel18.setText("Για περισσότερες πληροφορίες σχετικά με: "+quest2);
      
            if (jComboBox1.getSelectedItem() == answ1) {
                    //System.out.println("Βρήκες το 1ο"); 
                    if (comboindex > 4)  sc = sc + 0.25;
                    else if (comboindex == 4)  sc = sc + 1.0 / 3.0;
                    else if (comboindex == 3)  sc = sc + 0.5;  
            }        
            if (jComboBox2.getSelectedItem() == answ2) {      
                    //System.out.println("Βρήκες το 2ο");        
                    if (comboindex > 4)  sc = sc + 0.25;          
                    else if (comboindex == 4)  sc = sc + 1.0 / 3.0;            
                    else if (comboindex == 3)  sc = sc + 0.5;           
            }     
            if (comboindex > 3) {   
                    if (jComboBox3.getSelectedItem() == answ3) {   
                            //System.out.println("Βρήκες το 3ο");           
                            if (comboindex > 4)  sc = sc + 0.25;               
                            else if (comboindex == 4)  sc = sc + 1.0 / 3.0;             
                    }       
            }      
            if (comboindex > 4) {    
                    if (jComboBox4.getSelectedItem() == answ4) {      
                            //System.out.println("Βρήκες το 4ο");          
                            sc = sc + 0.25;       
                    }        
            }     
      
            if (sc == 1) { 
                    score++;    
                    jTextField2.setText("Μπράβο, το βρήκες! ");    
                    jTextField6.setText("Πήρες 1 βαθμό! ");         
                    correct[num] = true;     
                    try { 
                        URL url = new URL(URI1+"smileys/smile.png");
                        BufferedImage smiley = ImageIO.read(url);
                        java.awt.Image smiley2=smiley.getScaledInstance(150,150,BufferedImage.SCALE_SMOOTH);
                        Icon icon=new ImageIcon(smiley2);   
                        jLabel32.setIcon(icon);
                    } catch (IOException e) {}       
            }
            else {        
                    jTextField2.setText("Λυπάμαι, λάθος! Η σωστή απάντηση είναι:");    
                    jTextField6.setVisible(true);            
                    String text = "";           
                    if (comboindex > 4) text = "1 - " + answ1 + ", 2 - " + answ2 + ", 3 - " + answ3 + ", 4 - " + answ4;     
                    else if (comboindex == 4)  text = "1 - " + answ1 + ", 2 - " + answ2 + ", 3 - " + answ3;           
                    else if (comboindex == 3) text = "1 - " + answ1 + ", 2 - " + answ2; 
          
                    jTextField6.setText(text);  
                    correct[num] = false;       
                    try { 
                        URL url = new URL(URI1+"smileys/sad.png");
                        BufferedImage smiley = ImageIO.read(url);
                        java.awt.Image smiley2=smiley.getScaledInstance(150,150,BufferedImage.SCALE_SMOOTH);
                        Icon icon=new ImageIcon(smiley2);   
                        jLabel32.setIcon(icon);
                    } catch (IOException e) {}
            }    
 
            if (comboindex>3) {
                    jLabel21.setVisible(true);jLabel22.setVisible(true);jLabel23.setVisible(true);
                    jLabel21.setText("Για περισσότερες πληροφορίες σχετικά με: "+quest3);
            }
            if (comboindex>4) {
                    jLabel24.setVisible(true);jLabel25.setVisible(true);jLabel26.setVisible(true);
                    jLabel24.setText("Για περισσότερες πληροφορίες σχετικά με: "+quest4);
            }
       }
      
       else if (game==7) {
           sc=0;
           int selectedanswers=0;
           if (jCheckBox1.isSelected()) selectedanswers=selectedanswers+1;
           if (jCheckBox2.isSelected()) selectedanswers=selectedanswers+1;
           if (jCheckBox3.isSelected()) selectedanswers=selectedanswers+1;
           if (jCheckBox4.isSelected()) selectedanswers=selectedanswers+1;
           if (jCheckBox5.isSelected()) selectedanswers=selectedanswers+1;
           if (jCheckBox1.isSelected() && quest.equals(duplicatequestion)) sc=sc+1.0/numofcorrect;
           if (jCheckBox2.isSelected() && quest2.equals(duplicatequestion)) sc=sc+1.0/numofcorrect;
           if (jCheckBox3.isSelected() && quest3.equals(duplicatequestion)) sc=sc+1.0/numofcorrect;
           if (jCheckBox4.isSelected() && quest4.equals(duplicatequestion)) sc=sc+1.0/numofcorrect;
           if (jCheckBox5.isSelected() && quest5.equals(duplicatequestion)) sc=sc+1.0/numofcorrect;
           if (jCheckBox1.isSelected() && !quest.equals(duplicatequestion)) sc=sc-1.0/numofcorrect;
           if (jCheckBox2.isSelected() && !quest2.equals(duplicatequestion)) sc=sc-1.0/numofcorrect;
           if (jCheckBox3.isSelected() && !quest3.equals(duplicatequestion)) sc=sc-1.0/numofcorrect;
           if (jCheckBox4.isSelected() && !quest4.equals(duplicatequestion)) sc=sc-1.0/numofcorrect;
           if (jCheckBox5.isSelected() && !quest5.equals(duplicatequestion)) sc=sc-1.0/numofcorrect;
           
           if (sc==1 && selectedanswers==numofcorrect) {
                    score++;    
                    jTextField2.setText("Μπράβο, το βρήκες! ");    
                    jTextField6.setText("Πήρες 1 βαθμό! ");         
                    correct[num] = true;   
                    try { 
                        URL url = new URL(URI1+"smileys/smile.png");
                        BufferedImage smiley = ImageIO.read(url);
                        java.awt.Image smiley2=smiley.getScaledInstance(150,150,BufferedImage.SCALE_SMOOTH);
                        Icon icon=new ImageIcon(smiley2);   
                        jLabel32.setIcon(icon);
                    } catch (IOException e) {}
           }
           else {        
                    jTextField2.setText("Λυπάμαι, λάθος! Οι σωστές απαντήσεις είναι:");    
                    if (numofcorrect == 3) {jTextField2.setText("Λυπάμαι, λάθος!"); correctanswers = "Οι σωστές απαντήσεις είναι: " + correctanswers;}         
                    else if (numofcorrect== 2) {jTextField2.setText("Λυπάμαι, λάθος!");  correctanswers = "Οι σωστές απαντήσεις είναι: " + correctanswers;}
                    else if (numofcorrect== 1) {jTextField2.setText("Λυπάμαι, λάθος!"); correctanswers = "Η σωστή απάντηση είναι: "+ correctanswers; }
                    jTextField6.setText(correctanswers);  
                    correct[num] = false;   
                    try { 
                        URL url = new URL(URI1+"smileys/sad.png");
                        BufferedImage smiley = ImageIO.read(url);
                        java.awt.Image smiley2=smiley.getScaledInstance(150,150,BufferedImage.SCALE_SMOOTH);
                        Icon icon=new ImageIcon(smiley2);   
                        jLabel32.setIcon(icon);
                    } catch (IOException e) {}
           }    
 
         jLabel15.setText("Για περισσότερες πληροφορίες σχετικά με: " + answ);  
         jLabel18.setText("Για περισσότερες πληροφορίες σχετικά με: "+answ2);
         if (checkindex>3) {
                 jLabel21.setVisible(true);jLabel22.setVisible(true);jLabel23.setVisible(true);
                 jLabel21.setText("Για περισσότερες πληροφορίες σχετικά με: "+answ3);
         }
         if (checkindex>4) {
                 jLabel24.setVisible(true);jLabel25.setVisible(true);jLabel26.setVisible(true);
                 jLabel24.setText("Για περισσότερες πληροφορίες σχετικά με: "+answ4);
         }
         if (checkindex>5) {
                 jLabel29.setVisible(true);jLabel30.setVisible(true);jLabel31.setVisible(true);
                 jLabel29.setText("Για περισσότερες πληροφορίες σχετικά με: "+answ5);
         }
       }
      
       total++;   
       // System.out.println("Score=" + sc);    
       jLabel14.setText("Βαθμολογία: " + score + " / " + total);  
       jButton25.setVisible(true);jButton26.setVisible(false);       
       if (num == TimesPlayed - 1)   EndGame();
        
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
       String command="cmd.exe /c start ";
       String site=command+dbpedia2;
             
       try {
               Process pc = Runtime.getRuntime().exec(site);
              } catch (IOException ex) {JOptionPane.showMessageDialog(this, "Ο σύνδεσμος δε λειτουργεί!");}
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
       String command="cmd.exe /c start ";
       String site=command+dbpedia3;
             
       try {
               Process pc = Runtime.getRuntime().exec(site);
              } catch (IOException ex) {JOptionPane.showMessageDialog(this, "Ο σύνδεσμος δε λειτουργεί!");}  
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
       String command="cmd.exe /c start ";
       String site=command+wiki3;
             
       try {
               Process pc = Runtime.getRuntime().exec(site);
              } catch (IOException ex) {JOptionPane.showMessageDialog(this, "Ο σύνδεσμος δε λειτουργεί!");}
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
       String command="cmd.exe /c start ";
       String site=command+dbpedia4;
             
       try {
               Process pc = Runtime.getRuntime().exec(site);
              } catch (IOException ex) {JOptionPane.showMessageDialog(this, "Ο σύνδεσμος δε λειτουργεί!");}
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
       String command="cmd.exe /c start ";
       String site=command+wiki4;
             
       try {
               Process pc = Runtime.getRuntime().exec(site);
              } catch (IOException ex) {JOptionPane.showMessageDialog(this, "Ο σύνδεσμος δε λειτουργεί!");}
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
       String command="cmd.exe /c start ";
       String site=command+wiki2;
             
       try {
               Process pc = Runtime.getRuntime().exec(site);
              } catch (IOException ex) {JOptionPane.showMessageDialog(this, "Ο σύνδεσμος δε λειτουργεί!");}
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
       String command="cmd.exe /c start ";
       String site=command+dbpedia5;
             
       try {
               Process pc = Runtime.getRuntime().exec(site);
              } catch (IOException ex) {JOptionPane.showMessageDialog(this, "Ο σύνδεσμος δε λειτουργεί!");}  
    }//GEN-LAST:event_jLabel30MouseClicked

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
       String command="cmd.exe /c start ";
       String site=command+wiki5;
             
       try {
               Process pc = Runtime.getRuntime().exec(site);
              } catch (IOException ex) {JOptionPane.showMessageDialog(this, "Ο σύνδεσμος δε λειτουργεί!");}
    }//GEN-LAST:event_jLabel31MouseClicked

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jButton27MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton27MouseEntered
       //if (mouseoverbutton==0) {JOptionPane.showMessageDialog(this, "Αν πατήσεις το X θα τερματιστεί το πρόγραμμα!"); mouseoverbutton=1;}  
       jButton27.setToolTipText("Αν πατήσεις το X, το παιχνίδι θα τερματιστεί!");
    }//GEN-LAST:event_jButton27MouseEntered

private void jButton27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton27MouseClicked
       Object[] options = {"Ναι","Όχι"};
       int more = JOptionPane.showOptionDialog(this,"Θέλεις να τερματίσεις το παιχνίδι;","'Εφτασε το τέλος!",
       JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
       System.out.println("more = " + more); 
       if (more==0) {GameOver=1; EndGame();}
       else if (more==1 && !jButton25.isVisible()){frozen=false;startAnimation();}
}//GEN-LAST:event_jButton27MouseClicked

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
       frozen = true;
       stopAnimation();
    }//GEN-LAST:event_jButton27ActionPerformed

    private void MultipleChoice() {
       MultipleChoiceActivate();
       jRadioButton5.setSelected(true);
       jTextField2.setText("Επέλεξε μία απάντηση!");
       jTextField1.setHorizontalAlignment(JTextField.CENTER);
       jTextField2.setHorizontalAlignment(JTextField.CENTER);
       ReadFromFile GetData = new ReadFromFile();
       String[][] selection;
       int index,question1,answer1;
       int nextInt=0,nextInt2=0,nextInt3=0,nextInt4=0;
       Random generator = new Random();
      
       do {
                selection=GetData.Selection(data); index=GetData.index();
            } while (index==2);

       String selectedcategory=GetData.selectedcategory();
       jLabel28.setText("Κατηγορία: "+selectedcategory);
       Category[num]=selectedcategory;
       
       frozen=false;
       String str;
       int fps = 0;
       str = getParameter("fps");
       try { 
            if (str != null) {
                fps = Integer.parseInt(str);
            }
       } catch (Exception e) {}

       int delay = (fps > 0) ? (1000 / fps) : 1000;
       timer = new Timer(delay, this);
       timer.setInitialDelay(0);
       timer.setCoalesce(true);
       startAnimation(); 
      
       question1 = generator.nextInt(2); 
       do {
            answer1 = generator.nextInt(2);
            } while (answer1==question1);
       do {
             nextInt = generator.nextInt(index);
            } while (nextInt==0);
       
       jTextField1.setText(selection[0][question1] +selection[nextInt][question1]+";");
       int change;   
       do {
            nextInt2 = generator.nextInt(index); change=0;
            for (int i=0;i<index;i++) {
                if (selection[nextInt2][answer1].equals(selection[i][answer1]) && selection[i][question1].equals(selection[nextInt][question1])) change=1;}
            } while (selection[nextInt2][0].equals(selection[nextInt][0]) || selection[nextInt2][1].equals(selection[nextInt][1]) || nextInt2==0 || change==1);

       if (index>3) {
          do {
             nextInt3 = generator.nextInt(index);  change=0; 
             for (int i=0;i<index;i++) {
                if (selection[nextInt3][answer1].equals(selection[i][answer1]) && selection[i][question1].equals(selection[nextInt][question1])) change=1;}
              } while (selection[nextInt3][0].equals(selection[nextInt][0]) || selection[nextInt3][0].equals(selection[nextInt2][0]) || 
                          selection[nextInt3][1].equals(selection[nextInt][1]) || selection[nextInt3][1].equals(selection[nextInt2][1]) || 
                          nextInt3==0 || change==1);
    
          if (index>4) {
              do {
                     nextInt4 = generator.nextInt(index); change=0;
                     for (int i=0;i<index;i++) {
                        if (selection[nextInt4][answer1].equals(selection[i][answer1]) && selection[i][question1].equals(selection[nextInt][question1])) change=1;}
                   } while (selection[nextInt4][0].equals(selection[nextInt][0]) || selection[nextInt4][0].equals(selection[nextInt2][0]) || selection[nextInt4][0].equals(selection[nextInt3][0]) || 
                                selection[nextInt4][1].equals(selection[nextInt][1]) || selection[nextInt4][1].equals(selection[nextInt2][1]) || selection[nextInt4][1].equals(selection[nextInt3][1]) || 
                                nextInt4==0 || change==1);
          }    
       }
      
       ArrayList nums = new ArrayList();
       nums.add(nextInt);
       nums.add(nextInt2);
       if (index>3) nums.add(nextInt3);
       if (index>4) nums.add(nextInt4);
       Collections.shuffle(nums);
     
       int ind[]= {nextInt,nextInt2,nextInt3,nextInt4};
       ind[0]=Integer.parseInt(nums.get(0).toString()); 
       ind[1]=Integer.parseInt(nums.get(1).toString()); 
       if (index>3) ind[2]=Integer.parseInt(nums.get(2).toString()); 
       if (index>4) ind[3]=Integer.parseInt(nums.get(3).toString()); 
     
       answ1=selection[ind[0]][answer1];
       answ2=selection[ind[1]][answer1];
       if (index>3) answ3=selection[ind[2]][answer1];
       if (index>4) answ4=selection[ind[3]][answer1];
     
       jRadioButton3.setVisible(false);
       jRadioButton4.setVisible(false);
       jRadioButton5.setVisible(false);
             
       if (index>3) jRadioButton3.setVisible(true); jRadioButton3.setText(answ3);
       if (index>4) jRadioButton4.setVisible(true); jRadioButton4.setText(answ4);
       jRadioButton1.setText(answ1);
       jRadioButton2.setText(answ2);
       jRadioButton1.setEnabled(true);
       jRadioButton2.setEnabled(true);
       jRadioButton3.setEnabled(true);
       jRadioButton4.setEnabled(true);
     
       answ=selection[nextInt][answer1];
       quest=selection[nextInt][0];
       dbpedia=selection[nextInt][2];
       wiki=selection[nextInt][3]; 
       question[num]="Η ερώτηση ήταν: "+selection[0][question1] +selection[nextInt][question1]+";";
       answer[num]="Η σωστή απάντηση ήταν: " +answ;
        
    }                                        
    
    public void Anagram(){
       frozen=false;
       String str;
       int fps = 0;
       str = getParameter("fps");
       try { 
            if (str != null) {
                fps = Integer.parseInt(str);
            }
       } catch (Exception e) {}

       int delay = (fps > 0) ? (1000 / fps) : 1000;
       timer = new Timer(delay, this);
       timer.setInitialDelay(0);
       timer.setCoalesce(true);
       startAnimation();
       
       MultipleChoiceActivate();
       jRadioButton5.setSelected(true);
       jTextField2.setText("Οι απαντήσεις είναι αναγραμματισμένες! Υπάρχει μόνο 1 σωστή επιλογή!");
       jTextField1.setHorizontalAlignment(JTextField.CENTER);
       jTextField2.setHorizontalAlignment(JTextField.CENTER);

       ReadFromFile GetData = new ReadFromFile();
       String[][] selection;
       int index,anagram,question1,answer1;
       int nextInt=0,nextInt2=0,nextInt3=0,nextInt4=0;
       Random generator = new Random();
          
       do {
             selection=GetData.Selection(data); index=GetData.index();anagram = GetData.anagram();//indexwithoutduplicates=GetData.indexwithoutduplicates();
            } while (index==2);
        
       String selectedcategory=GetData.selectedcategory();
       jLabel28.setText("Κατηγορία: "+selectedcategory);
       Category[num]=selectedcategory;
        
       question1 = generator.nextInt(2); 
       if (anagram==0) question1=1;
       do {
             answer1 = generator.nextInt(2);
            } while (answer1==question1);
       do {
             nextInt = generator.nextInt(index);
            } while (nextInt==0);
      
       jTextField1.setText(selection[0][question1] +selection[nextInt][question1]+";");
 
       int change;
       do {
             nextInt2 = generator.nextInt(index); change=0;
             for (int i=0;i<index;i++) {
                if (selection[nextInt2][answer1].equals(selection[i][answer1]) && selection[i][question1].equals(selection[nextInt][question1])) change=1;}
            } while (selection[nextInt2 ][0].equals(selection[nextInt][0]) || selection[nextInt2 ][1].equals(selection[nextInt][1]) || nextInt2==0 || change==1);
       if (index>3) {
          do {
                 nextInt3 = generator.nextInt(index); change=0; 
                 for (int i=0;i<index;i++) {
                   if (selection[nextInt3][answer1].equals(selection[i][answer1]) && selection[i][question1].equals(selection[nextInt][question1])) change=1;}
                } while (selection[nextInt3][0].equals(selection[nextInt][0]) || selection[nextInt3][0].equals(selection[nextInt2][0]) || 
                        selection[nextInt3][1].equals(selection[nextInt][1]) || selection[nextInt3][1].equals(selection[nextInt2][1]) || nextInt3==0 || change==1);
           if (index>4) {
                do {
                        nextInt4 = generator.nextInt(index); change=0;
                        for (int i=0;i<index;i++) {
                            if (selection[nextInt4][answer1].equals(selection[i][answer1]) && selection[i][question1].equals(selection[nextInt][question1])) change=1;}
                     } while (selection[nextInt4][0].equals(selection[nextInt][0]) || selection[nextInt4][0].equals(selection[nextInt2][0]) || selection[nextInt4][0].equals(selection[nextInt3][0]) || 
                             selection[nextInt4][1].equals(selection[nextInt][1]) || selection[nextInt4][1].equals(selection[nextInt2][1]) || selection[nextInt4][1].equals(selection[nextInt3][1]) || 
                             nextInt4==0 || change==1);
           }
       }
       ArrayList nums = new ArrayList();
       nums.add(nextInt);
       nums.add(nextInt2);
       if (index>3) nums.add(nextInt3);
       if (index>4) nums.add(nextInt4);
       Collections.shuffle(nums);
     
       int ind[]= {nextInt,nextInt2,nextInt3,nextInt4};
       ind[0]=Integer.parseInt(nums.get(0).toString()); 
       ind[1]=Integer.parseInt(nums.get(1).toString()); 
       if (index>3) ind[2]=Integer.parseInt(nums.get(2).toString()); 
       if (index>4) ind[3]=Integer.parseInt(nums.get(3).toString()); 
     
       answ1=selection[ind[0]][answer1];
       answ2=selection[ind[1]][answer1];
       if (index>3) answ3=selection[ind[2]][answer1];
       if (index>4) answ4=selection[ind[3]][answer1];
       // System.out.println("answ1="+answ1);
       // System.out.println("answ2="+answ2);
       // System.out.println("answ3="+answ3);
       // System.out.println("answ4="+answ4);
     
       Shuffle anagram1=new Shuffle();
       String AnagramString=anagram1.AnagramString(selection[ind[0]][answer1]);
       Shuffle anagram2=new Shuffle();
       String AnagramString2=anagram2.AnagramString(selection[ind[1]][answer1]);
     
       jRadioButton3.setVisible(false);
       jRadioButton4.setVisible(false);
       jRadioButton5.setVisible(false);
     
       if (index>3) {
          Shuffle anagram3=new Shuffle();
          String AnagramString3=anagram3.AnagramString(selection[ind[2]][answer1]);
          jRadioButton3.setVisible(true); jRadioButton3.setText(AnagramString3);
       }
       if (index>4) {
          Shuffle anagram4=new Shuffle();
          String AnagramString4=anagram4.AnagramString(selection[ind[3]][answer1]);
          jRadioButton4.setVisible(true); jRadioButton4.setText(AnagramString4);
       }

       jRadioButton1.setText(AnagramString);
       jRadioButton2.setText(AnagramString2);
       jRadioButton1.setEnabled(true);
       jRadioButton2.setEnabled(true);
       jRadioButton3.setEnabled(true);
       jRadioButton4.setEnabled(true);
     
       answ=selection[nextInt][answer1];
       quest=selection[nextInt][0];
       dbpedia=selection[nextInt][2];
       wiki=selection[nextInt][3];
       question[num]="Η ερώτηση ήταν: "+selection[0][question1] +selection[nextInt][question1]+";";
       answer[num]="Η σωστή απάντηση ήταν: " +answ;

    }
    
    private void Hangman() {
       try { 
               URL url = new URL(URI1+"hangman/hanged0.jpg");
               BufferedImage img = ImageIO.read(url);
               Icon icon=new ImageIcon(img);   
               jLabel10.setIcon(icon);
            } catch (IOException e) {System.out.println(e);}
       jLabel10.setVisible(true);
       frozen=false;
       String str;
       int fps = 0;
       str = getParameter("fps");
       try { 
            if (str != null) {
                fps = Integer.parseInt(str);
            }
       } catch (Exception e) {}

       int delay = (fps > 0) ? (1000 / fps) : 1000;
       timer = new Timer(delay, this);
       timer.setInitialDelay(0);
       timer.setCoalesce(true);
       startAnimation();
        
       jTextField2.setText("Επέλεξε ένα γράμμα!");
       HangmanActivate();
       word=""; word2="";  word4=""; word6=""; word8=""; word9="";count=0;
       jTextField1.setHorizontalAlignment(JTextField.CENTER);
       jTextField2.setHorizontalAlignment(JTextField.CENTER);
       jTextField5.setHorizontalAlignment(JTextField.CENTER);

       ReadFromFile GetData = new ReadFromFile();
       String[][] selection;
       int index,hangman,nextInt,question1,answer1;
        
       do {
            selection = GetData.Selection(data);
            index = GetData.index();
            hangman = GetData.hangman();
       } while (hangman==-1);
      
       String selectedcategory=GetData.selectedcategory();
       jLabel28.setText("Κατηγορία: "+selectedcategory);
       Category[num]=selectedcategory;
       
       Random generator = new Random();
       question1 = generator.nextInt(2);
       if (hangman==0) question1=1;       
       
       do {
                 answer1 = generator.nextInt(2);
       } while (answer1==question1);

       int play;
       do {
                 nextInt = generator.nextInt(index);
                 play=0;
                 String check=selection[nextInt][answer1];
                 int length1 = check.length();
                 check=check.toUpperCase();
                 char [] array2check=check.toCharArray();
                 for (int s=0;s<length1;s++)  
                     if (array2check[s]>='Α' &&  array2check[s]<='Ω') play++; 
             } while (nextInt==0 || play==0);  
                    
       jTextField1.setText(selection[0][question1]+selection[nextInt][question1]+"; ");
       wordold=selection[nextInt][answer1];
       len = wordold.length();
       wordold=wordold.replace('ΐ', 'ι');
       wordold=wordold.replace('ΰ', 'υ');
       wordnew=wordold.toUpperCase();
       wordarray=wordnew.toCharArray();
      
       for (int i = 0; i < len; i++) {
            if (wordarray[i]=='Ά') {wordarray[i]='Α';}
            if (wordarray[i]=='Έ') {wordarray[i]='Ε';}
            if (wordarray[i]=='Ή') {wordarray[i]='Η';}
            if (wordarray[i]=='Ί') {wordarray[i]='Ι';}
            if (wordarray[i]=='Ό') {wordarray[i]='Ο';}
            if (wordarray[i]=='Ύ') {wordarray[i]='Υ';}
            if (wordarray[i]=='Ώ') {wordarray[i]='Ω';}
            if (wordarray[i]=='Ϊ') {wordarray[i]='Ι';}
            if (wordarray[i]=='Ϋ') {wordarray[i]='Υ';}
       }
            
       for (int i = 0; i < len; i++)  word = word+wordarray[i];
       word3=word;
       for (int i = 0; i < len; i++)  word4 = word4+ "*";
       word5= new char[len];   
       word7= new char[len];   
       word5 = word.toCharArray();
       word7 = word.toCharArray();
       for (int i = 0; i < len; i ++) 
             if ((word7[i]>='Α')&&(word7[i]<='Ω'))  word7[i] = '_';
       for (int i = 0; i < len; i++)  word8 = word8+word7[i]+' ';
       
       if (word8.length()>185) jTextField5.setFont(new java.awt.Font("Tahoma", 1, 8));
       else if (word8.length()>145) jTextField5.setFont(new java.awt.Font("Tahoma", 1, 10));       
       else if (word8.length()>135) jTextField5.setFont(new java.awt.Font("Tahoma", 1, 12));
       else if (word8.length()>121) jTextField5.setFont(new java.awt.Font("Tahoma", 1, 14));
       else if (word8.length()>117) jTextField5.setFont(new java.awt.Font("Tahoma", 1, 16));
       else jTextField5.setFont(new java.awt.Font("Tahoma", 1, 18));
      jTextField5.setText(word8);
       
       quest=selection[nextInt][0];
       dbpedia=selection[nextInt][2];
       wiki=selection[nextInt][3];
       question[num]="Η ερώτηση ήταν: "+selection[0][question1] +selection[nextInt][question1]+";";
       answer[num]="Η σωστή απάντηση ήταν: " +selection[nextInt][answer1];

    }

 private void HangmanwithPicture() {      
       try { 
               URL url = new URL(URI1+"hangman/hanged0.jpg");
               BufferedImage img = ImageIO.read(url);
               Icon icon=new ImageIcon(img);   
               jLabel10.setIcon(icon);
            } catch (IOException e) {System.out.println(e);}
       jLabel10.setVisible(true);
       jLabel2.setVisible(true);
        
       jTextField2.setText("Επέλεξε ένα γράμμα!");
       HangmanActivate();
       word=""; word2="";  word4=""; word6=""; word8=""; word9="";count=0;
       jTextField1.setHorizontalAlignment(JTextField.CENTER);
       jTextField2.setHorizontalAlignment(JTextField.CENTER);
       jTextField5.setHorizontalAlignment(JTextField.CENTER);

       ReadFromFile GetData = new ReadFromFile();
       String[][] selection;
       int index,nextInt,question1,answer1;

       selection = GetData.Selection1(data);
       index = GetData.index();
       String selectedcategory=GetData.selectedcategory();
       jLabel28.setText("Κατηγορία: "+selectedcategory);
       Category[num]=selectedcategory;
       
       Random generator = new Random();
       question1=1;       
       answer1=0;
       String warning="Ο σύνδεσμος που περιέχει την εικόνα: ";
       
       int play;
       do {
                 nextInt = generator.nextInt(index);
                  play=0;
                  String check=selection[nextInt][0];
                  int length1 = check.length();
                  check=check.toUpperCase();
                  char [] array2check=check.toCharArray();
                  for (int s=0;s<length1;s++)  
                      if (array2check[s]>='Α' &&  array2check[s]<='Ω') play++; 
             } while (nextInt==0 || play==0);   
      
       try { 
               URL url = new URL(selection[nextInt][1]);
               BufferedImage img = ImageIO.read(url);
               java.awt.Image img2=img.getScaledInstance(240,140,BufferedImage.SCALE_SMOOTH);
               Icon icon=new ImageIcon(img2);   
               jLabel2.setIcon(icon);
            } catch (IOException e) {
                  jLabel2.setText("Εικόνα:"+selection[nextInt][0]);
                  JOptionPane.showMessageDialog(this, warning+selection[nextInt][0]+" δε λειτουργεί!");
               }
             
       frozen=false;
       String str;
       int fps = 0;
       str = getParameter("fps");
       try { 
            if (str != null) {
                fps = Integer.parseInt(str);
            }
       } catch (Exception e) {}

       int delay = (fps > 0) ? (1000 / fps) : 1000;
       timer = new Timer(delay, this);
       timer.setInitialDelay(0);
       timer.setCoalesce(true);
       startAnimation();
       
       jTextField1.setText(selection[0][question1]);
       wordold=selection[nextInt][answer1];
       len = wordold.length();
       wordold=wordold.replace('ΐ', 'ι');
       wordold=wordold.replace('ΰ', 'υ');
       wordnew=wordold.toUpperCase();
       wordarray=wordnew.toCharArray();
      
       for (int i = 0; i < len; i++) {
            if (wordarray[i]=='Ά') {wordarray[i]='Α';}
            if (wordarray[i]=='Έ') {wordarray[i]='Ε';}
            if (wordarray[i]=='Ή') {wordarray[i]='Η';}
            if (wordarray[i]=='Ί') {wordarray[i]='Ι';}
            if (wordarray[i]=='Ό') {wordarray[i]='Ο';}
            if (wordarray[i]=='Ύ') {wordarray[i]='Υ';}
            if (wordarray[i]=='Ώ') {wordarray[i]='Ω';}
            if (wordarray[i]=='Ϊ') {wordarray[i]='Ι';}
            if (wordarray[i]=='Ϋ') {wordarray[i]='Υ';}
       }
            
       for (int i = 0; i < len; i++)  word = word+wordarray[i];
       word3=word;
       for (int i = 0; i < len; i++)  word4 = word4+ "*";
       word5= new char[len];   
       word7= new char[len];   
       word5 = word.toCharArray();
       word7 = word.toCharArray();
       for (int i = 0; i < len; i ++) 
             if ((word7[i]>='Α')&&(word7[i]<='Ω'))  word7[i] = '_';
       for (int i = 0; i < len; i++)  word8 = word8+word7[i]+' ';
       
       if (word8.length()>185) jTextField5.setFont(new java.awt.Font("Tahoma", 1, 8));
       else if (word8.length()>145) jTextField5.setFont(new java.awt.Font("Tahoma", 1, 10));       
       else if (word8.length()>135) jTextField5.setFont(new java.awt.Font("Tahoma", 1, 12));
       else if (word8.length()>121) jTextField5.setFont(new java.awt.Font("Tahoma", 1, 14));
       else if (word8.length()>117) jTextField5.setFont(new java.awt.Font("Tahoma", 1, 16));
       else jTextField5.setFont(new java.awt.Font("Tahoma", 1, 18));
       jTextField5.setText(word8);
       
       quest=selection[nextInt][0];
       dbpedia=selection[nextInt][2];
       wiki=selection[nextInt][3];
       question[num]="Η ερώτηση ήταν: "+selection[0][question1] +selection[nextInt][question1]+";";
       answer[num]="Η σωστή απάντηση ήταν: " +selection[nextInt][answer1];
       
    }
        
    private void Flag() {
       frozen=false;
       String str,warning;
       int fps = 0;
     
       MultipleChoiceActivate();
       jLabel2.setVisible(true);
       jRadioButton5.setSelected(true);
       jTextField2.setText("Επέλεξε μία απάντηση!");
       jTextField1.setHorizontalAlignment(JTextField.CENTER);
       jTextField2.setHorizontalAlignment(JTextField.CENTER);
       ReadFromFile GetData = new ReadFromFile();
       String[][] selection;
       int index,nextInt=0,nextInt2=0,nextInt3=0,nextInt4=0;
       Random generator = new Random();

       do {
             selection=GetData.Selection1(data); index=GetData.index();//indexwithoutduplicates=GetData.indexwithoutduplicates();
            } while (index==2);
       
       String selectedcategory=GetData.selectedcategory();
       jLabel28.setText("Κατηγορία: "+selectedcategory);
       Category[num]=selectedcategory;
       
       do {
             nextInt = generator.nextInt(index);
            } while (nextInt==0 );
       warning="";

       jTextField1.setText(selection[0][1]); 
       warning="Ο σύνδεσμος που περιέχει την εικόνα: ";
 
       try { 
               URL url = new URL(selection[nextInt][1]);
               BufferedImage img = ImageIO.read(url);
               java.awt.Image img2=img.getScaledInstance(240,140,BufferedImage.SCALE_SMOOTH);
               Icon icon=new ImageIcon(img2);   
               jLabel2.setIcon(icon);
            } catch (IOException e) {
                  jLabel2.setText("Εικόνα:"+selection[nextInt][0]);
                  JOptionPane.showMessageDialog(this, warning+selection[nextInt][0]+" δε λειτουργεί!");
               }
       
       str = getParameter("fps");
       try { 
            if (str != null) {
                fps = Integer.parseInt(str);
            }
       } catch (Exception e) {}

       int delay = (fps > 0) ? (1000 / fps) : 1000;
       timer = new Timer(delay, this);
       timer.setInitialDelay(0);
       timer.setCoalesce(true);
       startAnimation();
       do {
             nextInt2 = generator.nextInt(index); 
            } while (selection[nextInt2][0].equals(selection[nextInt][0]) || selection[nextInt2][1].equals(selection[nextInt][1]) || nextInt2==0);
       if (index>3) {
           do {
                  nextInt3 = generator.nextInt(index); 
                } while (selection[nextInt3][0].equals(selection[nextInt][0]) || selection[nextInt3][0].equals(selection[nextInt2][0]) || 
                             selection[nextInt3][1].equals(selection[nextInt][1]) || selection[nextInt3][1].equals(selection[nextInt2][1]) || nextInt3==0);
           if (index>4) {
                do {
                       nextInt4 = generator.nextInt(index); 
                     } while (selection[nextInt4][0].equals(selection[nextInt][0]) || selection[nextInt4][0].equals(selection[nextInt2][0]) || selection[nextInt4][0].equals(selection[nextInt3][0]) || 
                                  selection[nextInt4][1].equals(selection[nextInt][1]) || selection[nextInt4][1].equals(selection[nextInt2][1]) || selection[nextInt4][1].equals(selection[nextInt3][1]) || nextInt4==0);
           }
       }
      
       //System.out.println("1. "+selection[nextInt][0]);
       //System.out.println("2. "+selection[nextInt2][0]);
       //System.out.println("3. "+selection[nextInt3][0]);
       //System.out.println("4. "+selection[nextInt4][0]);
     
       ArrayList nums = new ArrayList();
       nums.add(nextInt);
       nums.add(nextInt2);
       if (index>3) nums.add(nextInt3);
       if (index>4) nums.add(nextInt4);
       Collections.shuffle(nums);
     
       int ind[]= {nextInt,nextInt2,nextInt3,nextInt4};
       ind[0]=Integer.parseInt(nums.get(0).toString()); 
       ind[1]=Integer.parseInt(nums.get(1).toString()); 
       if (index>3) ind[2]=Integer.parseInt(nums.get(2).toString()); 
       if (index>4) ind[3]=Integer.parseInt(nums.get(3).toString()); 
     
       answ1=selection[ind[0]][0];
       answ2=selection[ind[1]][0];
       if (index>3) answ3=selection[ind[2]][0];
       if (index>4) answ4=selection[ind[3]][0];
     
       jRadioButton3.setVisible(false);
       jRadioButton4.setVisible(false);
       jRadioButton5.setVisible(false);
     
       if (index>3)  jRadioButton3.setVisible(true); jRadioButton3.setText(answ3);
       if (index>4)  jRadioButton4.setVisible(true); jRadioButton4.setText(answ4);
     
       jRadioButton1.setText(answ1);
       jRadioButton2.setText(answ2);
       jRadioButton1.setEnabled(true);
       jRadioButton2.setEnabled(true);
       jRadioButton3.setEnabled(true);
       jRadioButton4.setEnabled(true);
     
       answ=selection[nextInt][0];
       quest=selection[nextInt][0];
       dbpedia=selection[nextInt][2];
       wiki=selection[nextInt][3];
       // System.out.println("Η απάντηση είναι:  "+answ);
       question[num]="Η ερώτηση ήταν: "+selection[0][1] +selection[nextInt][1]+";";
       answer[num]="Η σωστή απάντηση ήταν: " +selection[nextInt][0];
    }            
      
    private void Flag2() {
       String str;
       MultipleChoiceActivate();
       jTextField1.setHorizontalAlignment(JTextField.CENTER);
       jTextField2.setHorizontalAlignment(JTextField.CENTER);
       jTextField2.setText("Επέλεξε μία απάντηση!");
       ReadFromFile GetData = new ReadFromFile();
       String[][] selection;
       int index,nextInt=0,nextInt2=0,nextInt3=0,nextInt4=0;
       Random generator = new Random();

       do {
             selection=GetData.Selection1(data); index=GetData.index();//indexwithoutduplicates=GetData.indexwithoutduplicates();
            } while (index==2);
       
       String selectedcategory=GetData.selectedcategory();
       jLabel28.setText("Κατηγορία: "+selectedcategory);
       Category[num]=selectedcategory;
       
       do {
             nextInt = generator.nextInt(index);
           } while (nextInt==0);
      
       jTextField1.setText(selection[0][0]+selection[nextInt][0]+";");

       do {
             nextInt2 = generator.nextInt(index); 
           } while (selection[nextInt2][0].equals(selection[nextInt][0]) || selection[nextInt2][1].equals(selection[nextInt][1]) || nextInt2==0);
       if (index>3) {
          do {
             nextInt3 = generator.nextInt(index); 
           } while (selection[nextInt3][0].equals(selection[nextInt][0]) || selection[nextInt3][0].equals(selection[nextInt2][0]) || 
                        selection[nextInt3][1].equals(selection[nextInt][1]) || selection[nextInt3][1].equals(selection[nextInt2][1]) || nextInt3==0);
          if (index>4) {
            do {
              nextInt4 = generator.nextInt(index); 
            } while (selection[nextInt4][0].equals(selection[nextInt][0]) | selection[nextInt4][0].equals(selection[nextInt2][0]) || selection[nextInt4][0].equals(selection[nextInt3][0]) || 
                         selection[nextInt4][1].equals(selection[nextInt][1]) | selection[nextInt4][1].equals(selection[nextInt2][1]) || selection[nextInt4][1].equals(selection[nextInt3][1]) || nextInt4==0);
          }
       }
       ArrayList nums = new ArrayList();
       nums.add(nextInt);
       nums.add(nextInt2);
       if (index>3) nums.add(nextInt3);
       if (index>4) nums.add(nextInt4);
       Collections.shuffle(nums);
     
       int ind[]= {nextInt,nextInt2,nextInt3,nextInt4};
       ind[0]=Integer.parseInt(nums.get(0).toString()); 
       ind[1]=Integer.parseInt(nums.get(1).toString()); 
       if (index>3) ind[2]=Integer.parseInt(nums.get(2).toString()); 
       if (index>4) ind[3]=Integer.parseInt(nums.get(3).toString()); 
     
       answ1=selection[ind[0]][1];
       answ2=selection[ind[1]][1];
       if (index>3) answ3=selection[ind[2]][1];
       if (index>4) answ4=selection[ind[3]][1];
     
       jRadioButton3.setVisible(false);
       jRadioButton4.setVisible(false);
      
       if (index>3) {
          jRadioButton3.setVisible(true); 
          try { 
               URL url = new URL(selection[ind[2]][1]);
               BufferedImage img = ImageIO.read(url);
               java.awt.Image img2 = img.getScaledInstance(150, 70, BufferedImage.SCALE_SMOOTH);
               Icon icon=new ImageIcon(img2);   
               jRadioButton3.setIcon(icon);
            } catch (IOException e) {
                  jRadioButton3.setText("Εικόνα:"+selection[ind[2]][0]);
                  JOptionPane.showMessageDialog(this, "Ο σύνδεσμος που περιέχει την εικόνα: "+selection[ind[2]][0]+" δε λειτουργεί!");
               }
       }
       if (index>4) {
          jRadioButton4.setVisible(true);
          try { 
               URL url = new URL(selection[ind[3]][1]);
               BufferedImage img = ImageIO.read(url);
               java.awt.Image img2 = img.getScaledInstance(150, 70, BufferedImage.SCALE_SMOOTH);
               Icon icon=new ImageIcon(img2);   
               jRadioButton4.setIcon(icon);
            } catch (IOException e) {
                  jRadioButton4.setText("Εικόνα:"+selection[ind[3]][0]);
                  JOptionPane.showMessageDialog(this, "Ο σύνδεσμος που περιέχει την εικόνα: "+selection[ind[3]][0]+" δε λειτουργεί!");
               }
       }

       try { 
               URL url = new URL(selection[ind[0]][1]);
               BufferedImage img = ImageIO.read(url);
               java.awt.Image img2 = img.getScaledInstance(150, 70, BufferedImage.SCALE_SMOOTH);
               Icon icon=new ImageIcon(img2);   
               jRadioButton1.setIcon(icon);
       } catch (IOException e) {
                  jRadioButton1.setText("Εικόνα:"+selection[ind[0]][0]);
                  JOptionPane.showMessageDialog(this, "Ο σύνδεσμος που περιέχει την εικόνα: "+selection[ind[0]][0]+" δε λειτουργεί!");
          }
          
       try { 
               URL url = new URL(selection[ind[1]][1]);
               BufferedImage img = ImageIO.read(url);
               java.awt.Image img2 = img.getScaledInstance(150, 70, BufferedImage.SCALE_SMOOTH);
               Icon icon=new ImageIcon(img2);   
               jRadioButton2.setIcon(icon);
       } catch (IOException e) {
                   jRadioButton2.setText("Εικόνα:"+selection[ind[1]][0]);
                  JOptionPane.showMessageDialog(this, "Ο σύνδεσμος που περιέχει την εικόνα: "+selection[ind[1]][0]+" δε λειτουργεί!");
          }

       frozen=false;
       int fps = 0;
       str = getParameter("fps");
       try { 
            if (str != null) {
                fps = Integer.parseInt(str);
            }
       } catch (Exception e) {}

       int delay = (fps > 0) ? (1000 / fps) : 1000;
       timer = new Timer(delay, this);
       timer.setInitialDelay(0);
       timer.setCoalesce(true);
       startAnimation();
        
       jRadioButton1.setEnabled(true);
       jRadioButton2.setEnabled(true);
       jRadioButton3.setEnabled(true);
       jRadioButton4.setEnabled(true);
     
       //System.out.println("1. "+selection[nextInt][0]);
       //System.out.println("2. "+selection[nextInt2][0]);
       //System.out.println("3. "+selection[nextInt3][0]);
       //System.out.println("4. "+selection[nextInt4][0]);
     
       answ=selection[nextInt][1];
       if ("η χώρα είναι: ".equals(selection[0][0]))  {
            if (nextInt==ind[0]) {answw="η πρώτη σημαία";}
            else if (nextInt==ind[1]) {answw="η δεύτερη σημαία";}
            else if (nextInt==ind[2]) {answw="η τρίτη σημαία";}
            else if (nextInt==ind[3]) {answw="η τέταρτη σημαία";}
       }
       else {
            if (nextInt==ind[0]) {answw="η πρώτη εικόνα";}
            else if (nextInt==ind[1]) {answw="η δεύτερη εικόνα";}
            else if (nextInt==ind[2]) {answw="η τρίτη εικόνα";}
            else if (nextInt==ind[3]) {answw="η τέταρτη εικόνα";}
       }
    
       quest=selection[nextInt][0];
       dbpedia=selection[nextInt][2];
       wiki=selection[nextInt][3];
       question[num]="Η ερώτηση ήταν: "+selection[0][0] +selection[nextInt][0]+";";
       answer[num]="Η σωστή απάντηση ήταν: " +selection[nextInt][1];
       
    }            
  
    private void Matching() {
       frozen=false;
       String str;
       int fps = 0;

       str = getParameter("fps");
       try { 
            if (str != null) {
                fps = Integer.parseInt(str);
            }
       } catch (Exception e) {}

       int delay = (fps > 0) ? (1000 / fps) : 1000;
       timer = new Timer(delay, this);
       timer.setInitialDelay(0);
       timer.setCoalesce(true);
       startAnimation();
        
       MatchingActivate();
       jTextField6.setVisible(true);
       jTextField2.setText("Αφού επιλέξεις τις απαντήσεις σου, πάτησε υποβολή!");
       jTextField1.setHorizontalAlignment(JTextField.CENTER);
       jTextField2.setHorizontalAlignment(JTextField.CENTER);
       jTextField6.setHorizontalAlignment(JTextField.CENTER);
       jTextField6.setText("Πρέπει να τα βρεις όλα, για να θεωρηθεί η απάντηση σου σωστή!");
       ReadFromFile GetData = new ReadFromFile();
       String[][] selection;
       int index,question1,answer1;
       int nextInt=0,nextInt2=0,nextInt3=0,nextInt4=0;
       Random generator = new Random();             
      
       do {
             selection=GetData.Selection(data); index=GetData.index(); //indexwithoutduplicates=GetData.indexwithoutduplicates();
            } while (index==2);
      
       String selectedcategory=GetData.selectedcategory();
       jLabel28.setText("Κατηγορία: "+selectedcategory);
       Category[num]=selectedcategory;
       
       comboindex=index;
       question1 = generator.nextInt(2); 
       do {
             answer1 = generator.nextInt(2);
           } while (answer1==question1);
      do {
             nextInt = generator.nextInt(index);
           } while (nextInt==0);
     
       jTextField1.setText(selection[0][question1]);
       jLabel27.setText("Αντιστοίχισε την 1η στήλη με τη 2η στήλη!");
      
       int change;
       do {
             nextInt2 = generator.nextInt(index); change=0;
             for (int i=0;i<index;i++) {
                if ((selection[nextInt2][answer1].equals(selection[i][answer1]) && selection[i][question1].equals(selection[nextInt][question1])) ||
                      (selection[nextInt2][question1].equals(selection[i][question1]) && selection[i][answer1].equals(selection[nextInt][answer1]))) 
                             change=1;
             }
            } while (selection[nextInt2][0].equals(selection[nextInt][0]) || selection[nextInt2][1].equals(selection[nextInt][1]) || nextInt2==0 || change==1);
       
       if (index>3) {
              do {
                        nextInt3 = generator.nextInt(index); change=0;
                        for (int i=0;i<index;i++) {
                           if (((selection[nextInt3][answer1].equals(selection[i][answer1]) && selection[i][question1].equals(selection[nextInt][question1])) ||
                               (selection[nextInt3][question1].equals(selection[i][question1]) && selection[i][answer1].equals(selection[nextInt][answer1]))) ||
                               ((selection[nextInt3][answer1].equals(selection[i][answer1]) && selection[i][question1].equals(selection[nextInt2][question1])) ||
                                (selection[nextInt3][question1].equals(selection[i][question1]) && selection[i][answer1].equals(selection[nextInt2][answer1]))))
                               change=1;
                         }
                   } while (selection[nextInt3][0].equals(selection[nextInt][0]) || selection[nextInt3][0].equals(selection[nextInt2][0]) || 
                                selection[nextInt3][1].equals(selection[nextInt][1]) || selection[nextInt3][1].equals(selection[nextInt2][1]) || nextInt3==0 || 
                                change==1);
              
              if (index>4) {
                    do {
                            nextInt4 = generator.nextInt(index); change=0;
                            for (int i=0;i<index;i++) {
                              if (((selection[nextInt4][answer1].equals(selection[i][answer1]) && selection[i][question1].equals(selection[nextInt][question1])) ||
                                   (selection[nextInt4][question1].equals(selection[i][question1]) && selection[i][answer1].equals(selection[nextInt][answer1]))) ||
                                 ((selection[nextInt4][answer1].equals(selection[i][answer1]) && selection[i][question1].equals(selection[nextInt2][question1])) ||
                                   (selection[nextInt4][question1].equals(selection[i][question1]) && selection[i][answer1].equals(selection[nextInt2][answer1]))) ||
                                 ((selection[nextInt4][answer1].equals(selection[i][answer1]) && selection[i][question1].equals(selection[nextInt3][question1])) ||
                                  (selection[nextInt4][question1].equals(selection[i][question1]) && selection[i][answer1].equals(selection[nextInt3][answer1]))))
                                  change=1;
                            }
                        } while (selection[nextInt4][0].equals(selection[nextInt][0]) || selection[nextInt4][0].equals(selection[nextInt2][0]) || selection[nextInt4][0].equals(selection[nextInt3][0]) || 
                                 selection[nextInt4][1].equals(selection[nextInt][1]) || selection[nextInt4][1].equals(selection[nextInt2][1]) || selection[nextInt4][1].equals(selection[nextInt3][1]) || 
                                 nextInt4==0 || change==1);
              }
       }
         
       ArrayList nums = new ArrayList();
       nums.add(nextInt);
       nums.add(nextInt2);
       if (index>3) nums.add(nextInt3);
       if (index>4) nums.add(nextInt4);
       Collections.shuffle(nums);
     
       int ind[]= {nextInt,nextInt2,nextInt3,nextInt4};
       ind[0]=Integer.parseInt(nums.get(0).toString()); 
       ind[1]=Integer.parseInt(nums.get(1).toString()); 
       if (index>3) ind[2]=Integer.parseInt(nums.get(2).toString()); 
       if (index>4) ind[3]=Integer.parseInt(nums.get(3).toString()); 
     
       answ1=selection[ind[0]][answer1];
       answ2=selection[ind[1]][answer1];
       if (index>3) answ3=selection[ind[2]][answer1];
       if (index>4) answ4=selection[ind[3]][answer1];
       if (index>3){
          jLabel5.setVisible(true); jLabel5.setText("3. "+selection[nextInt3][question1]);jComboBox3.setVisible(true);
       }
       if (index>4){
          jLabel6.setVisible(true); jLabel6.setText("4. "+selection[nextInt4][question1]);jComboBox4.setVisible(true);
       }

       jLabel3.setVisible(true);jLabel3.setText("1. "+selection[nextInt][question1]);
       jLabel4.setVisible(true);jLabel4.setText("2. "+selection[nextInt2][question1]);
       jComboBox1.removeAllItems();
       jComboBox1.insertItemAt(answ1, 0); 
       jComboBox1.insertItemAt(answ2, 1);    
       jComboBox2.removeAllItems();
       jComboBox2.insertItemAt(answ1, 0); 
       jComboBox2.insertItemAt(answ2, 1);
       if (index>3){
         jComboBox1.insertItemAt(answ3, 2); 
         jComboBox2.insertItemAt(answ3, 2);  
         jComboBox3.removeAllItems();
         jComboBox3.insertItemAt(answ1, 0); 
         jComboBox3.insertItemAt(answ2, 1);
         jComboBox3.insertItemAt(answ3, 2); 
       }
       if (index>4){
         jComboBox1.insertItemAt(answ4, 3);
         jComboBox2.insertItemAt(answ4, 3);
         jComboBox3.insertItemAt(answ4, 3);
         jComboBox4.removeAllItems();
         jComboBox4.insertItemAt(answ1, 0); 
         jComboBox4.insertItemAt(answ2, 1);
         jComboBox4.insertItemAt(answ3, 2); 
         jComboBox4.insertItemAt(answ4, 3);
       }
      
       answ1=selection[nextInt][answer1];
       answ2=selection[nextInt2][answer1];
       if (index>3)   answ3=selection[nextInt3][answer1];
       if (index>4)   answ4=selection[nextInt4][answer1];

       quest=selection[nextInt][0];
       dbpedia=selection[nextInt][2];
       wiki=selection[nextInt][3];    
       quest2=selection[nextInt2][0];
       dbpedia2=selection[nextInt2][2];
       wiki2=selection[nextInt2][3];      
       quest3=selection[nextInt3][0];
       dbpedia3=selection[nextInt3][2];
       wiki3=selection[nextInt3][3];      
       quest4=selection[nextInt4][0];
       dbpedia4=selection[nextInt4][2];
       wiki4=selection[nextInt4][3];  
       question[num]="Η ερώτηση ήταν: "+selection[0][question1];
       if (index>4) answer[num]="Η σωστή απάντηση ήταν: 1. " +selection[nextInt][question1] +" - "+selection[nextInt][answer1] +" 2. "+selection[nextInt2][question1] +" - "+selection[nextInt2][answer1] +
               " 3."+selection[nextInt3][question1] +" - "+selection[nextInt3][answer1] +" 4."+selection[nextInt4][question1] +" - "+selection[nextInt4][answer1];
       else if (index==4) answer[num]="Η σωστή απάντηση ήταν: 1. " +selection[nextInt][question1] +" - "+selection[nextInt][answer1] +" 2. "+selection[nextInt2][question1] +" - "+selection[nextInt2][answer1] +
               " 3."+selection[nextInt3][question1] +" - "+selection[nextInt3][answer1] ;
       else if (index==3) answer[num]="Η σωστή απάντηση ήταν: 1. " +selection[nextInt][question1] +" - "+selection[nextInt][answer1] +" 2. "+selection[nextInt2][question1] +" - "+selection[nextInt2][answer1];
     
    }                   
    
    private void MultipleChoicewithDuplicates() {
       jCheckBox1.setVisible(true);jCheckBox2.setVisible(true);jButton26.setVisible(true);
       jTextField2.setText("Επέλεξε μία ή περισσότερες απαντήσεις!");
       jTextField1.setHorizontalAlignment(JTextField.CENTER);
       jTextField2.setHorizontalAlignment(JTextField.CENTER);
       jCheckBox1.setSelected(false);jCheckBox2.setSelected(false);jCheckBox3.setSelected(false);
       jCheckBox4.setSelected(false);jCheckBox5.setSelected(false);
       jTextField6.setVisible(true);
       jTextField6.setText("Πρέπει να τα βρεις όλα, για να θεωρηθεί η απάντηση σου σωστή!");
       ReadFromFile GetData = new ReadFromFile();
       String[][] selection;
       int index,question1,answer1;
       int nextInt=0,nextInt2=0,nextInt3=0,nextInt4=0,nextInt5=0;
       Random generator = new Random();
      numofcorrect=0;
       do {
             selection=GetData.Selection2(data); index=GetData.index();
            } while (index==2);

       String selectedcategory=GetData.selectedcategory();
       jLabel28.setText("Κατηγορία: "+selectedcategory);
       Category[num]=selectedcategory;
       
       checkindex=index;
       frozen=false;
       String str;
       int fps = 0;
       str = getParameter("fps");
       try { 
            if (str != null) {
                fps = Integer.parseInt(str);
            }
            } catch (Exception e) {}

       int delay = (fps > 0) ? (1000 / fps) : 1000;
       timer = new Timer(delay, this);
       timer.setInitialDelay(0);
       timer.setCoalesce(true);
       startAnimation(); 
      
       question1=1;
       answer1=0;
       
       do {
             nextInt = generator.nextInt(index);
            } while (nextInt==0);
       
       //System.out.println("Το nexIint είναι ="+nextInt);
       jTextField1.setText(selection[0][question1] +selection[nextInt][question1]+";");
          
       do {
            nextInt2 = generator.nextInt(index); 
            } while (nextInt2 == nextInt || nextInt2==0 || selection[nextInt2][answer1].equals(selection[nextInt][answer1]));
       //System.out.println("Το nexIint2 είναι ="+nextInt2);
       if (index>3) {
          do {
             nextInt3 = generator.nextInt(index);    //System.out.println("Το INDEX είναι ="+index);
              } while (nextInt3 == nextInt || nextInt3 == nextInt2 || nextInt3==0 || 
                           selection[nextInt3][answer1].equals(selection[nextInt][answer1]) || selection[nextInt3][answer1].equals(selection[nextInt2][answer1]));
       //System.out.println("Το nexIint3 είναι ="+nextInt3);
          if (index>4) {
              do {
                     nextInt4 = generator.nextInt(index); 
                   } while (nextInt4 == nextInt || nextInt4 == nextInt2 || nextInt4 == nextInt3 || nextInt4==0 || 
                               selection[nextInt4][answer1].equals(selection[nextInt][answer1]) || selection[nextInt4][answer1].equals(selection[nextInt2][answer1]) || 
                               selection[nextInt4][answer1].equals(selection[nextInt3][answer1])) ;
       //System.out.println("Το nexIint4 είναι ="+nextInt4);
            if (index>5) {
              do {
                     nextInt5 = generator.nextInt(index); 
                   } while (nextInt5 == nextInt || nextInt5 == nextInt2 || nextInt5 == nextInt3 || nextInt5 == nextInt4 ||nextInt5==0 ||
                               selection[nextInt5][answer1].equals(selection[nextInt][answer1]) || selection[nextInt5][answer1].equals(selection[nextInt2][answer1]) || 
                               selection[nextInt5][answer1].equals(selection[nextInt3][answer1]) || selection[nextInt5][answer1].equals(selection[nextInt4][answer1])) ;
       //System.out.println("Το nexIint5 είναι ="+nextInt5);
            }
          }
       }
       
       for (int i=0;i<index;i++) {
           if (selection[nextInt2][answer1].equals(selection[i][answer1]) && selection[i][question1].equals(selection[nextInt][question1])) nextInt2=i;
           if (index>3 && selection[nextInt3][answer1].equals(selection[i][answer1]) && selection[i][question1].equals(selection[nextInt][question1])) nextInt3=i;
           if (index>4 && selection[nextInt4][answer1].equals(selection[i][answer1]) && selection[i][question1].equals(selection[nextInt][question1])) nextInt4=i;
           if (index>5 && selection[nextInt5][answer1].equals(selection[i][answer1]) && selection[i][question1].equals(selection[nextInt][question1])) nextInt5=i;
       }
       
       ArrayList nums = new ArrayList();
       nums.add(nextInt);
       nums.add(nextInt2);
       if (index>3) nums.add(nextInt3);
       if (index>4) nums.add(nextInt4);
       if (index>5) nums.add(nextInt5);
       Collections.shuffle(nums);
     
       int ind[]= {nextInt,nextInt2,nextInt3,nextInt4,nextInt5};
       ind[0]=Integer.parseInt(nums.get(0).toString()); 
       ind[1]=Integer.parseInt(nums.get(1).toString()); 
       if (index>3) ind[2]=Integer.parseInt(nums.get(2).toString()); 
       if (index>4) ind[3]=Integer.parseInt(nums.get(3).toString()); 
       if (index>5) ind[4]=Integer.parseInt(nums.get(4).toString()); 
     
       answ1=selection[ind[0]][answer1];
       answ2=selection[ind[1]][answer1];
       if (index>3) answ3=selection[ind[2]][answer1];
       if (index>4) answ4=selection[ind[3]][answer1];
       if (index>5) answ5=selection[ind[4]][answer1];
     
       jCheckBox3.setVisible(false);
       jCheckBox4.setVisible(false);
       jCheckBox5.setVisible(false);
             
       if (index>3) jCheckBox3.setVisible(true); jCheckBox3.setText(answ3);
       if (index>4) jCheckBox4.setVisible(true); jCheckBox4.setText(answ4);
       if (index>5) jCheckBox5.setVisible(true); jCheckBox5.setText(answ5);
       jCheckBox1.setText(answ1);
       jCheckBox2.setText(answ2);
       jCheckBox1.setEnabled(true);
       jCheckBox2.setEnabled(true);
       jCheckBox3.setEnabled(true);
       jCheckBox4.setEnabled(true);
       jCheckBox5.setEnabled(true);
     
       answ=selection[ind[0]][answer1];
       quest=selection[ind[0]][question1];
       dbpedia=selection[ind[0]][2];
       wiki=selection[ind[0]][3];
       answ2=selection[ind[1]][answer1];
       quest2=selection[ind[1]][question1];
       dbpedia2=selection[ind[1]][2];
       wiki2=selection[ind[1]][3];

       if (index>3) {
           answ3=selection[ind[2]][answer1];
           quest3=selection[ind[2]][question1];
           dbpedia3=selection[ind[2]][2];
           wiki3=selection[ind[2]][3];
       }
       if (index>4) {
           answ4=selection[ind[3]][answer1];
           quest4=selection[ind[3]][question1];
           dbpedia4=selection[ind[3]][2];
           wiki4=selection[ind[3]][3];
       }
       if (index>5) {
           answ5=selection[ind[4]][answer1];
           quest5=selection[ind[4]][question1];
           dbpedia5=selection[ind[4]][2];
           wiki5=selection[ind[4]][3];
       }
       question[num]=selection[0][question1] +selection[nextInt][question1]+";";

       int answers=0;
       answer[num]="";
       if (selection[nextInt][question1].equals(selection[ind[0]][question1])) {
           numofcorrect=numofcorrect+1;
           if (answers==0) {answer[num]=answer[num]+selection[ind[0]][answer1]; answers=1;}
           else if (answers==1) answer[num]=answer[num]+", "+selection[ind[0]][answer1];
       }
       
       if (selection[nextInt][question1].equals(selection[ind[1]][question1])) {
             numofcorrect=numofcorrect+1;
             if (answers==0) {answer[num]=answer[num]+selection[ind[1]][answer1];answers=1;}
            else if (answers==1) answer[num]=answer[num]+", "+selection[ind[1]][answer1];
       }
       if (selection[nextInt][question1].equals(selection[ind[2]][question1])) {
           numofcorrect=numofcorrect+1;
           if (answers==0) {answer[num]=answer[num]+selection[ind[2]][answer1];answers=1;}
             else if (answers==1) answer[num]=answer[num]+", "+selection[ind[2]][answer1];
       }
       if (selection[nextInt][question1].equals(selection[ind[3]][question1])) {
           numofcorrect=numofcorrect+1;
           if (answers==0) {answer[num]=answer[num]+selection[ind[3]][answer1];answers=1;}
           else if (answers==1) answer[num]=answer[num]+", "+selection[ind[3]][answer1];
       }
       if (selection[nextInt][question1].equals(selection[ind[4]][question1])) {
           numofcorrect=numofcorrect+1;
           if (answers==0) {answer[num]=answer[num]+selection[ind[4]][answer1];answers=1;}
           else if (answers==1) answer[num]=answer[num]+", "+selection[ind[4]][answer1];
       }
       
       // System.out.println("Οι σωστές είναι: "+numofcorrect);
       duplicatequestion=selection[nextInt][question1];
       jButton26.setEnabled(true);
       correctanswers="";
       correctanswers=answer[num]; // System.out.println("Correct="+correctanswers);
       answer[num]="Η σωστή απάντηση είναι: "+answer[num];
       
    }
     
    private void MultipleChoiceActivate(){
       jTextField5.setVisible(false);
       jLabel2.setText(null);
       jRadioButton5.setSelected(true);
       jRadioButton1.setVisible(true);
       jRadioButton2.setVisible(true);
       jRadioButton3.setVisible(true);
       jRadioButton4.setVisible(true);
    }
    
    private void HangmanActivate(){
       try { 
               URL url = new URL(URI1+"hanged/hanged0.jpg");
               BufferedImage img = ImageIO.read(url);
               Icon icon=new ImageIcon(img);   
               jLabel10.setIcon(icon);
             } catch (IOException e) {}
       jRadioButton1.setVisible(false); jRadioButton2.setVisible(false); jRadioButton3.setVisible(false);
       jRadioButton4.setVisible(false);jRadioButton5.setVisible(false);
       jButton1.setEnabled(true); jButton2.setEnabled(true); jButton3.setEnabled(true);
       jButton4.setEnabled(true); jButton5.setEnabled(true); jButton6.setEnabled(true); 
       jButton7.setEnabled(true); jButton8.setEnabled(true); jButton9.setEnabled(true);
       jButton10.setEnabled(true); jButton11.setEnabled(true); jButton12.setEnabled(true);
       jButton13.setEnabled(true); jButton14.setEnabled(true); jButton15.setEnabled(true);
       jButton16.setEnabled(true); jButton17.setEnabled(true); jButton18.setEnabled(true); 
       jButton19.setEnabled(true); jButton20.setEnabled(true); jButton21.setEnabled(true);
       jButton22.setEnabled(true); jButton23.setEnabled(true); jButton24.setEnabled(true);
       jButton1.setVisible(true);jButton2.setVisible(true);jButton3.setVisible(true);
       jButton4.setVisible(true); jButton5.setVisible(true); jButton6.setVisible(true); 
       jButton7.setVisible(true); jButton8.setVisible(true); jButton9.setVisible(true);
       jButton10.setVisible(true); jButton11.setVisible(true); jButton12.setVisible(true);
       jButton13.setVisible(true); jButton14.setVisible(true); jButton15.setVisible(true);
       jButton16.setVisible(true); jButton17.setVisible(true); jButton18.setVisible(true); 
       jButton19.setVisible(true); jButton20.setVisible(true); jButton21.setVisible(true);
       jButton22.setVisible(true); jButton23.setVisible(true); jButton24.setVisible(true);
       jTextField5.setVisible(true);
    }
    
    private void MatchingActivate(){
       jLabel3.setVisible(true);jLabel4.setVisible(true); jLabel5.setVisible(false);
       jLabel6.setVisible(false);jLabel27.setVisible(true);
       jComboBox1.setVisible(true);jComboBox2.setVisible(true);jComboBox3.setVisible(false);
       jComboBox4.setVisible(false);jButton26.setVisible(true);
       jComboBox1.setEnabled(true);jComboBox2.setEnabled(true);jComboBox3.setEnabled(true);
       jComboBox4.setEnabled(true);jButton26.setEnabled(true);
  }

    private void DeActivateAll(){
       jButton1.setEnabled(false); jButton2.setEnabled(false); jButton3.setEnabled(false);
       jButton4.setEnabled(false); jButton5.setEnabled(false); jButton6.setEnabled(false); 
       jButton7.setEnabled(false); jButton8.setEnabled(false); jButton9.setEnabled(false);
       jButton10.setEnabled(false); jButton11.setEnabled(false); jButton12.setEnabled(false);
       jButton13.setEnabled(false); jButton14.setEnabled(false); jButton15.setEnabled(false);
       jButton16.setEnabled(false); jButton17.setEnabled(false); jButton18.setEnabled(false); 
       jButton19.setEnabled(false); jButton20.setEnabled(false); jButton21.setEnabled(false);
       jButton22.setEnabled(false); jButton23.setEnabled(false); jButton24.setEnabled(false);
       jButton1.setVisible(false);jButton2.setVisible(false);jButton3.setVisible(false);
       jButton4.setVisible(false); jButton5.setVisible(false); jButton6.setVisible(false); 
       jButton7.setVisible(false); jButton8.setVisible(false); jButton9.setVisible(false);
       jButton10.setVisible(false); jButton11.setVisible(false); jButton12.setVisible(false);
       jButton13.setVisible(false); jButton14.setVisible(false); jButton15.setVisible(false);
       jButton16.setVisible(false); jButton17.setVisible(false); jButton18.setVisible(false); 
       jButton19.setVisible(false); jButton20.setVisible(false); jButton21.setVisible(false);
       jButton22.setVisible(false); jButton23.setVisible(false); jButton24.setVisible(false);
       jTextField5.setVisible(false); jTextField5.setText(null); jLabel2.setVisible(false);
       jRadioButton1.setVisible(false);jRadioButton2.setVisible(false);jRadioButton3.setVisible(false);
       jRadioButton4.setVisible(false);jRadioButton5.setVisible(false);
       jLabel3.setVisible(false);jLabel4.setVisible(false);jLabel5.setVisible(false);jLabel6.setVisible(false);
       jComboBox1.setVisible(false);jComboBox2.setVisible(false);jComboBox3.setVisible(false);
       jComboBox4.setVisible(false);jButton26.setVisible(false);jTextField6.setVisible(false);
       jRadioButton1.setText(null);jRadioButton1.setIcon(null);
       jRadioButton2.setText(null);jRadioButton2.setIcon(null);
       jRadioButton3.setText(null);jRadioButton3.setIcon(null);
       jRadioButton4.setText(null);jRadioButton4.setIcon(null);
       jLabel2.setIcon(null); jLabel10.setVisible(false); jLabel10.setIcon(null);
       jLabel15.setVisible(false);jLabel16.setVisible(false);jLabel17.setVisible(false);
       jLabel18.setVisible(false);jLabel19.setVisible(false);jLabel20.setVisible(false);
       jLabel21.setVisible(false);jLabel22.setVisible(false);jLabel23.setVisible(false);
       jLabel24.setVisible(false);jLabel25.setVisible(false);jLabel26.setVisible(false);
       jLabel27.setVisible(false);jCheckBox1.setVisible(false);jCheckBox2.setVisible(false);
       jCheckBox3.setVisible(false);jCheckBox4.setVisible(false);jCheckBox5.setVisible(false);
       jLabel29.setVisible(false);jLabel30.setVisible(false);jLabel31.setVisible(false);
       jLabel32.setText(null);
      try { 
               URL url = new URL(URI1+"smileys/thinking.png");
               BufferedImage smiley = ImageIO.read(url);
               java.awt.Image smiley2=smiley.getScaledInstance(150,150,BufferedImage.SCALE_SMOOTH);
               Icon icon=new ImageIcon(smiley2);   
                jLabel32.setIcon(icon);
             } catch (IOException e) {}
      }    
    
    private void ChooseGame(){
       Random generator = new Random();
       game=generator.nextInt(8); //System.out.println("Παιχνίδι: "+game);
       jButton27.setVisible(true);
       
       //if ((game==0 || game==1 || game==6) && indexnoimages==0) game=2;
       //if ((game==4 || game==5) && indeximages==0) game=3;
       
       //System.out.println("Game="+game);
       frameNumber=frameNumber-1;
       jButton25.setVisible(false);
       num++;
       int num_1=num+1;
       //game=2;
       jLabel1.setText("Ερώτηση: "+num_1+"η");

       if (game==0) {GamePlayed[num]="Πολλαπλή Επιλογή (Multiple Choice)";MultipleChoice();}
       else if (game==1) {GamePlayed[num]="Πολλαπλή Επιλογή με Αναγραμματισμό (Anagram Game)";Anagram();}
       else if (game==2) {GamePlayed[num]="Κρεμάλα (Hangman)";Hangman();}
       else if (game==3) {GamePlayed[num]="Κρεμάλα με εικόνα (Hangman)";HangmanwithPicture();}
       else if (game==4) {GamePlayed[num]="Πολλαπλή Επιλογή (1 Εικόνα, 4 Επιλογές)";Flag();}
       else if (game==5) {GamePlayed[num]="Πολλαπλή Επιλογή (Επιλογή από 4 Εικόνες)";Flag2();}
       else if (game==6) {GamePlayed[num]="Αντιστοίχιση";Matching();}
       else if (game==7) {GamePlayed[num]="Πολλαπλή Επιλογή με περισσότερες από 1 σωστές απαντήσεις";MultipleChoicewithDuplicates();}
         
    }    

    @Override
    public void start() { startAnimation(); }

    public void stop() { stopAnimation(); }

    public synchronized void startAnimation() {
       if (frozen) { 
       } 
       else {
                if (!timer.isRunning()) {
                timer.start();
                }
       }
    }

    public synchronized void stopAnimation() {
       if (timer.isRunning()) {
            timer.stop();
       }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       frameNumber++;
       frameNumber1[num]++;

       jLabel7.setText("Συνολικός Χρόνος:  " + frameNumber+ " ''");
       jLabel8.setText("Χρόνος:  " + frameNumber1[num]+ " ''");
    }

    public void EndGame() {
       if (GameOver==1) {TimesPlayed=total;}
       jLabel28.setVisible(false); jButton27.setVisible(false);jLabel32.setVisible(false);
       JOptionPane.showMessageDialog(this, name+", το παιχνίδι τελείωσε!");
       //PrintStream stdout = System.out;
       String correctness=""; String name1=name;
       Calendar calendar = Calendar.getInstance();
       Date date = calendar.getTime();
       String date1=date.toString();
       /*date1=date1.replace('/', '.'); date1=date1.replace(':', '.');
       name=name.replace('/', '.'); name=name.replace('\\', '.');   
       name=name.replace(':', '.'); name=name.replace('*', '.');  
       name=name.replace('?', '.'); name=name.replace('"', '.');  
       name=name.replace('<', '.'); name=name.replace('>', '.');  
       name=name.replace('|', '.'); 
       String filename=name+" "+date1+".txt";       
       String path2=JOptionPane.showInputDialog(null,"Γράψε το path στο οποίο θέλεις να σωθούν τα αποτελέσματα (π.χ. C:\\results). To default path είναι το:C:\\temp");  
       if (path2==null | "".equals(path2)) {path2="C:/temp";}
       new File(path2).mkdir();
       String path=path2+"/"+filename; 

       try{
              File file=new File(path);  
              OutputStream output = new FileOutputStream(file);
              PrintStream printOut = new PrintStream(output);
              OutputStreamWriter out = new OutputStreamWriter(printOut, "Cp1253");
              System.setOut(printOut);
       }catch (Exception e){  }*/
       // jTextArea1.setText("Ημερομηνία: "+date1);
       //jTextArea1.setText("Όνομα παίχτη: "+name1);
       String text= "Ημερομηνία: "+date1;
       text=text+"\n"+"Όνομα παίχτη: "+name1;
       text=text+"\n"+"Συνολικός χρόνος: "+frameNumber;
       text=text+"\n"+"Πλήθος ερωτήσεων που απαντήθηκαν: "+total;
       text=text+"\n"+"Απαντήθηκαν σωστά: "+score+" ερωτήσεις.";
       int wrong=total-score;
       text=text+"\n"+"Απαντήθηκαν λάθος: "+wrong+" ερωτήσεις.";
       double score1=score, wrong1=wrong,percentage=(score1/total)*100,percentage2=(wrong1/total)*100;
       DecimalFormat df = new DecimalFormat("#.##");
       text=text+"\n"+"To ποσοστό των σωστών απαντήσεων ήταν: "+df.format(percentage)+"%";
       text=text+"\n"+"To ποσοστό των λάθος απαντήσεων ήταν: "+df.format(percentage2)+"%";
       text=text+"\n"+"----------------------------------------------------------------------------------------------------------------------------------------";
       
       int time=0;
       for (int i=0;i<TimesPlayed;i++) {
            if (correct[i]==true) correctness="Σωστά";
            else if (correct[i]==false) correctness="Λάθος";
            int num1=i+1; time=time+frameNumber1[i];
            text=text+"\n"+"Η "+num1+"η ερώτηση απαντήθηκε "+correctness+" σε "+frameNumber1[i]+" δευτερόλεπτα";  
            text=text+"\n"+"Το παιχνίδι που παίχτηκε ήταν το: "+GamePlayed[i];
            text=text+"\n"+"Η κατηγορία του παιχνιδιού ήταν: "+Category[i];
            text=text+"\n"+question[i]; text=text+"\n"+answer[i];
            text=text+"\n"+"----------------------------------------------------------------------------------------------------------------------------------------";
       }          
       int TimesPlayed_1=TimesPlayed+1;
       if (GameOver==1 && time!=frameNumber) {
           text=text+"\n"+"Η "+TimesPlayed_1+"η ερώτηση δεν απαντήθηκε. Χρόνος παραμονής στην ερώτηση: "+frameNumber1[TimesPlayed]+" δευτερόλεπτα";
           text=text+"\n"+"Το παιχνίδι ήταν το: "+GamePlayed[TimesPlayed];
           text=text+"\n"+"Η κατηγορία του παιχνιδιού ήταν: "+Category[TimesPlayed];
           text=text+"\n"+question[TimesPlayed]; text=text+"\n"+answer[TimesPlayed];
           text=text+"\n"+"----------------------------------------------------------------------------------------------------------------------------------------";
       }  
       DeActivateAll();
       jTextArea1.setText(text);
       jTextField1.setVisible(false);
       jLabel8.setVisible(false);
       jButton25.setVisible(false);
       //JOptionPane.showMessageDialog(this, "Το αρχείο με τα στατιστικά στοιχεία είναι έτοιμο!");
       jTextField2.setVisible(false);//jTextField2.setText("Γεια σου!!!!!!!!!!");
       //System.setOut(stdout);           
        jScrollPane1.setVisible(true);
 
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
