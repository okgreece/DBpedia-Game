package GetData;

/*
 * @author Despina-Eleana Chrysou
 */

import java.io.*;
import java.util.*;
import java.net.*;

public class ReadFromFile {
int selectedindex,selected,anagram,hangman,indexwithoutduplicates,indeximages=0,indexnoimages=0;
final int images=14;
final int noimages=17;
final int uniquevalues=23;
final int questions=images+noimages;
final int multivalues=questions-uniquevalues;
String URI1="http://wiki.el.dbpedia.org/apps/ssg/files/";
String URI2, selectedcategory="";
String [][] data =null;

public int [] index1 ()
{
   String strLine;
   int i=0,index=0;
   int [] indexarray;
   indexarray=new int[questions];
   for (i=0; i <questions; i++) {indexarray[i]=0;}
   
   try{
          URI2=URI1+"data.txt";
          URL url  = new URL(URI2);
          URLConnection urlConn = url.openConnection();
          InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream(),"Cp1253");
          BufferedReader br= new BufferedReader(inStream);
       
          i=0; int problem=0;
          while ((strLine = br.readLine()) != null) {
                          if (!strLine.equals("@@@")&&!strLine.equals("")&&!strLine.equals("ancientsite2,image,dbpedia1,wiki1")) {
                               String pr1_1="Γκότφριντ Βίλχελμ Λάιμπνιτς,\"γερμανός φιλόσοφος, επιστήμονας, μαθηματικός, διπλωμάτης, φυσικός, ιστορικός,";
                               String pr1_2="βιβλιοθηκονόμος και διδάκτορας των λαϊκών και εκκλησιαστικών νομικών\",http://el.dbpedia.org/resource/Γκότφριντ_Βίλχελμ_Λάιμπνιτς,http://el.wikipedia.org/wiki/%CE%93%CE%BA%CF%8C%CF%84%CF%86%CF%81%CE%B9%CE%BD%CF%84_%CE%92%CE%AF%CE%BB%CF%87%CE%B5%CE%BB%CE%BC_%CE%9B%CE%AC%CE%B9%CE%BC%CF%80%CE%BD%CE%B9%CF%84%CF%82";
                               String pr2_1="Χοσέ Μιγκέλ Γκομέζ,Κουβανός πολιτικός και στρατιωτικός";
                               String pr2_2="ΗΜΕΡΟΜΗΝΙΑ ΓΕΝΝΗΣΗΣ=28 Ιναουαρίου,http://el.dbpedia.org/resource/Χοσέ_Μιγκέλ_Γκομέζ,http://el.wikipedia.org/wiki/%CE%A7%CE%BF%CF%83%CE%AD_%CE%9C%CE%B9%CE%B3%CE%BA%CE%AD%CE%BB_%CE%93%CE%BA%CE%BF%CE%BC%CE%AD%CE%B6";
                               if (pr1_1.equals(strLine)) problem=1; 
                               if (pr1_2.equals(strLine)) problem=0;   
                               if (pr2_1.equals(strLine)) problem=1;
                               if (pr2_2.equals(strLine)) problem=0;                            
                              
                               if (problem==0) { index++;indexarray[i]++;}
                          }
                          else if (strLine.equals("@@@")) {i++;}
                         }
          }catch (Exception e){ System.err.println("Error: " + e.getMessage());}
   
   //for (i=0;i<questions;i++) { System.out.println("indexarray["+i+"]= "+indexarray[i]);}

   return indexarray;
}

public String[][] data(int [] index1)
{
   String[] anArray = null;
   String strLine;
   int indexall=0;
   for (int j=0;j<questions;j++) indexall=indexall+index1[j];
   int i=0;
 
   try{
          URL url  = new URL(URI2);
          URLConnection urlConn = url.openConnection();
          InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream(),"Cp1253");
          BufferedReader br = new BufferedReader(inStream);
          anArray = new String[indexall];   
          data = new String[indexall][4];   
          int problem=0; String tempstring="";
          
          while ((strLine = br.readLine()) != null) {
              if (!strLine.equals("@@@")&&!strLine.equals("")&&!strLine.equals("ancientsite2,image,dbpedia1,wiki1")) {
                    anArray[i]=strLine;
                    int exist=0,exist2=0;
                    
                    String pr1_1="Γκότφριντ Βίλχελμ Λάιμπνιτς,\"γερμανός φιλόσοφος, επιστήμονας, μαθηματικός, διπλωμάτης, φυσικός, ιστορικός,";
                    String pr1_2="βιβλιοθηκονόμος και διδάκτορας των λαϊκών και εκκλησιαστικών νομικών\",http://el.dbpedia.org/resource/Γκότφριντ_Βίλχελμ_Λάιμπνιτς,http://el.wikipedia.org/wiki/%CE%93%CE%BA%CF%8C%CF%84%CF%86%CF%81%CE%B9%CE%BD%CF%84_%CE%92%CE%AF%CE%BB%CF%87%CE%B5%CE%BB%CE%BC_%CE%9B%CE%AC%CE%B9%CE%BC%CF%80%CE%BD%CE%B9%CF%84%CF%82";
                    String pr2_1="Χοσέ Μιγκέλ Γκομέζ,Κουβανός πολιτικός και στρατιωτικός";
                    String pr2_2="ΗΜΕΡΟΜΗΝΙΑ ΓΕΝΝΗΣΗΣ=28 Ιναουαρίου,http://el.dbpedia.org/resource/Χοσέ_Μιγκέλ_Γκομέζ,http://el.wikipedia.org/wiki/%CE%A7%CE%BF%CF%83%CE%AD_%CE%9C%CE%B9%CE%B3%CE%BA%CE%AD%CE%BB_%CE%93%CE%BA%CE%BF%CE%BC%CE%AD%CE%B6";
                    if (pr1_1.equals(strLine)) {problem=1; tempstring=pr1_1;}
                    if (pr1_2.equals(strLine)) { 
                       problem=0;   
                       anArray[i]=tempstring+pr1_2;  
                    }
                    if (pr2_1.equals(strLine)) {problem=1; tempstring=pr2_1;}
                    if (pr2_2.equals(strLine)) { 
                        problem=0;   
                        anArray[i]=tempstring+pr2_2;
                    }
         
                    if (problem!=1) {
                        char [] anArray2=anArray[i].toCharArray();
                        for (int k = 0; k < anArray[i].length(); k++) 
                            if (anArray2[k]=='\"')  {
                                exist=1; 
                                if (k>0) if (anArray2[k-1]==',') exist2=1;
                            }

                        String[] temp; temp=new String[4];
                        for (int g=0;g<4;g++) temp[g]="";
                        if (exist==0) temp = anArray[i].split(",");
                        else if (exist==1 & exist2==0) {anArray[i]=anArray[i].replace(",http","\",http");temp=anArray[i].split("\",");}
                        else if (exist==1 & exist2==1) {anArray[i]=anArray[i].replace("\",\"",",\"");anArray[i]=anArray[i].replace("\",",",\"");anArray[i]=anArray[i].replace(",http",",\"http");temp=anArray[i].split(",\"");}
                        temp[0]=temp[0].replace("\"","");temp[0]=temp[0].replace("\'", "");
                        data[i][0]=temp[0];
                        temp[1]=temp[1].replace("\"","");temp[1]=temp[1].replace("\'", "");
                        data[i][1]=temp[1];
                        temp[2]=temp[2].replace("\"","");temp[2]=temp[2].replace("\'", "");
                        data[i][2]=temp[2];
                        temp[3]=temp[3].replace("\"",""); temp[3]=temp[3].replace("\'", "");
                        data[i++][3]=temp[3];
                    }
              }
          }
   } catch (Exception e){ System.err.println("Error: " + e.getMessage()); }
 
   // Ερωτήματα με εικόνες
   data[0][0]="Ποια σημαία έχει η χώρα: ";
   data[0][1]="Ποια χώρα έχει τη σημαία: ";
   data[index1[0]][0]="Ποια φωτογραφία απεικονίζει την πρωτεύουσα: ";
   data[index1[0]][1]="Στην παρακάτω φωτογραφία, ποια πρωτεύουσα απεικονίζεται; ";
   int IndexStartsAt=IndexStartsAt=index1[0]+index1[1];
   //System.out.println("index starts at"+IndexStartsAt);
   data[IndexStartsAt][0]="Ποια φωτογραφία απεικονίζει την πόλη: ";
   data[IndexStartsAt][1]="Στην παρακάτω φωτογραφία, ποια πόλη απεικονίζεται; ";
   IndexStartsAt=IndexStartsAt+index1[2];
   //System.out.println("index starts at"+IndexStartsAt);
   data[IndexStartsAt][0]="Ποια σημαία έχει η Πολιτεία της Αμερικής: ";
   data[IndexStartsAt][1]="Ποια πολιτεία της Αμερικής έχει σημαία: ";
   IndexStartsAt=IndexStartsAt+index1[3];
   //System.out.println("index starts at"+IndexStartsAt);
   data[IndexStartsAt][0]="Ποια φωτογραφία απεικονίζει το χώρο: ";
   data[IndexStartsAt][1]="Στην παρακάτω φωτογραφία, τί απεικονίζεται; ";
   IndexStartsAt=IndexStartsAt+index1[4];
   //System.out.println("index starts at"+IndexStartsAt);
   data[IndexStartsAt][0]="Ποια φωτογραφία απεικονίζει τον αρχαιολογικό χώρο: ";
   data[IndexStartsAt][1]="Στην παρακάτω φωτογραφία, ποιος αρχαιολογικός χώρος απεικονίζεται; ";
   IndexStartsAt=IndexStartsAt+index1[5];
   //System.out.println("index starts at"+IndexStartsAt);
   data[IndexStartsAt][0]="Ποια φωτογραφία απεικονίζει το μνημείο: ";
   data[IndexStartsAt][1]="Στην παρακάτω φωτογραφία, ποιο μνημείο απεικονίζεται; ";
   IndexStartsAt=IndexStartsAt+index1[6];
   //System.out.println("index starts at"+IndexStartsAt);
   data[IndexStartsAt][0]="Ποια φωτογραφία απεικονίζει το κάστρο: ";
   data[IndexStartsAt][1]="Στην παρακάτω φωτογραφία, ποιο κάστρο απεικονίζεται; ";
   IndexStartsAt=IndexStartsAt+index1[7];
   //System.out.println("index starts at"+IndexStartsAt);
   data[IndexStartsAt][0]="Ποια φωτογραφία απεικονίζει τον πύργο: ";
   data[IndexStartsAt][1]="Στην παρακάτω φωτογραφία, ποιος πύργος απεικονίζεται; ";
   IndexStartsAt=IndexStartsAt+index1[8];
   //System.out.println("index starts at"+IndexStartsAt);
   data[IndexStartsAt][0]="Σε ποια φωτογραφία απεικονίζεται το άθλημα: ";
   data[IndexStartsAt][1]="Στην παρακάτω φωτογραφία, ποιο άθλημα απεικονίζεται; ";
   IndexStartsAt=IndexStartsAt+index1[9];
   //System.out.println("index starts at"+IndexStartsAt);
   data[IndexStartsAt][0]="Σε ποια φωτογραφία απεικονίζεται το ολυμπιακό άθλημα: ";
   data[IndexStartsAt][1]="Στην παρακάτω φωτογραφία, ποιο ολυμπιακό άθλημα απεικονίζεται; ";
   IndexStartsAt=IndexStartsAt+index1[10];
   //System.out.println("index starts at"+IndexStartsAt);
   data[IndexStartsAt][0]="Ποια εικόνα απεικονίζει τον πλανήτη: ";
   data[IndexStartsAt][1]="Στην παρακάτω εικόνα, ποιος πλανήτης απεικονίζεται; ";
   IndexStartsAt=IndexStartsAt+index1[11];
   //System.out.println("index starts at"+IndexStartsAt);
   data[IndexStartsAt][0]="Ποια φωτογραφία απεικονίζει το ζώο: ";
   data[IndexStartsAt][1]="Στην παρακάτω φωτογραφία, ποιο ζώο απεικονίζεται; ";
    IndexStartsAt=IndexStartsAt+index1[12];
   //System.out.println("index starts at"+IndexStartsAt);
   data[IndexStartsAt][0]="Ποια φωτογραφία απεικονίζει τον/την: ";
   data[IndexStartsAt][1]="Στην παρακάτω φωτογραφία, ποιος απεικονίζεται; ";

      
   // Ερωτήματα χωρίς εικόνες
   IndexStartsAt=IndexStartsAt+index1[13];
   //System.out.println("index starts at"+IndexStartsAt);
   data[IndexStartsAt][0]="Ποια είναι η πρωτεύουσα της χώρας: ";
   data[IndexStartsAt][1]="Σε ποια χώρα ανήκει η πρωτεύουσα: ";
   IndexStartsAt=IndexStartsAt+index1[14];
   //System.out.println("index starts at"+IndexStartsAt);
   data[IndexStartsAt][0]="Ποια είναι η πρωτεύουσα του νομού: ";
   data[IndexStartsAt][1]="Σε ποιο νομό ανήκει η πρωτεύουσα: ";
   IndexStartsAt=IndexStartsAt+index1[15];
   //System.out.println("index starts at"+IndexStartsAt);
   data[IndexStartsAt][0]="Ποια είναι η πρωτεύουσα της Πολιτείας της Αμερικής: ";
   data[IndexStartsAt][1]="Σε ποια Πολιτεία της Αμερικής ανήκει η πρωτεύουσα: ";
   IndexStartsAt=IndexStartsAt+index1[16];
   //System.out.println("index starts at"+IndexStartsAt);
   data[IndexStartsAt][0]="Σε ποια χώρα βρίσκεται το κάστρο: ";
   data[IndexStartsAt][1]="Ποιο κάστρο βρίσκεται στη χώρα: ";
   IndexStartsAt=IndexStartsAt+index1[17];
   //System.out.println("index starts at"+IndexStartsAt);
   data[IndexStartsAt][0]="Τί πληθυσμό έχει το νησί: ";
   data[IndexStartsAt][1]="Ποιο νησί έχει πληθυσμό: ";
   IndexStartsAt=IndexStartsAt+index1[18];
   //System.out.println("index starts at"+IndexStartsAt);
   data[IndexStartsAt][0]="Ποιο σύμβολο έχει το χημικό στοιχείο: ";
   data[IndexStartsAt][1]="Ποιο είναι το χημικό στοιχείο που έχει το σύμβολο: ";
   IndexStartsAt=IndexStartsAt+index1[19];
   //System.out.println("index starts at"+IndexStartsAt);
   data[IndexStartsAt][0]="Ποια ήταν η ημερομηνία εκτόξευσης της διαστημικής αποστολής: ";
   data[IndexStartsAt][1]="Ποια διαστημική αποστολή εκτοξεύτηκε στις: ";
   IndexStartsAt=IndexStartsAt+index1[20];
   //System.out.println("index starts at"+IndexStartsAt);
   data[IndexStartsAt][0]="Πότε έγινε ο πόλεμος: ";
   data[IndexStartsAt][1]="Ποιος πόλεμος έγινε στις: ";
   IndexStartsAt=IndexStartsAt+index1[21];
   //System.out.println("index starts at"+IndexStartsAt);
   data[IndexStartsAt][0]="Πότε πέθανε ο/η: ";
   data[IndexStartsAt][1]="Ποιος πέθανε στις: ";
   
   //Με πολλαπλές τιμές
   
   IndexStartsAt=IndexStartsAt+index1[22];
   //System.out.println("index starts at"+IndexStartsAt);
   data[IndexStartsAt][0]="Πού γεννήθηκε ο/η: ";
   data[IndexStartsAt][1]="Ποιος γεννήθηκε στον τόπο: ";
   IndexStartsAt=IndexStartsAt+index1[23];
   //System.out.println("index starts at"+IndexStartsAt);
   data[IndexStartsAt][0]="Σε ποια χώρα βρίσκεται ο τόπος: ";
   data[IndexStartsAt][1]="Ποιος τόπος βρίσκεται στη χώρα: ";
   IndexStartsAt=IndexStartsAt+index1[24];
   //System.out.println("index starts at"+IndexStartsAt);
   data[IndexStartsAt][0]="Τί θέση έχει/είχε ο πολιτικός: ";
   data[IndexStartsAt][1]="Ποιος πολιτικός είναι/ήταν: ";
   IndexStartsAt=IndexStartsAt+index1[25]; int language1=IndexStartsAt;
   //System.out.println("index starts at"+IndexStartsAt);
   data[IndexStartsAt][0]="Ποια γλώσσα μιλάνε στη χώρα: ";
   data[IndexStartsAt][1]="Σε ποια χώρα μιλάνε τη γλώσσα: ";
   IndexStartsAt=IndexStartsAt+index1[26]; int language2=IndexStartsAt;
   //System.out.println("index starts at"+IndexStartsAt);
   data[IndexStartsAt][0]="Τί νόμισμα έχει η χώρα: ";
   data[IndexStartsAt][1]="Ποια χώρα έχει νόμισμα το: ";
   IndexStartsAt=IndexStartsAt+index1[27];
   //System.out.println("index starts at"+IndexStartsAt);
   data[IndexStartsAt][0]="Σε ποια χώρα βρίσκεται το νησί: ";
   data[IndexStartsAt][1]="Ποιο νησί βρίσκεται στη χώρα: ";
   IndexStartsAt=IndexStartsAt+index1[28]; int pelagos1=IndexStartsAt;
   //System.out.println("index starts at"+IndexStartsAt);
   data[IndexStartsAt][0]="Πού βρίσκεται το νησί: ";
   data[IndexStartsAt][1]="Ποιο νησί βρίσκεται στο πέλαγος/σύμπλεγμα νησιών: ";
   IndexStartsAt=IndexStartsAt+index1[29]; int pelagos2=IndexStartsAt;
   //System.out.println("index starts at"+IndexStartsAt);
   data[IndexStartsAt][0]="Ποια είναι η ιδιότητα του/της: ";
   data[IndexStartsAt][1]="Ποιο άτομο έχει την ιδιότητα: ";
   // System.out.println("Μόλις διαβάστηκε το txt αρχείο!");
   // for (int line=0;line<indexall;line++) for (int col=0;col<4;col++)  System.out.println(data[line][col]);
   // for (int line=0;line<questions;line++) {int line1=line+1; System.out.println("Κατηγορία "+line1+"ης Ερώτησης="+category[line]);}
   
   for (i=language1;i<language2;i++)
   {
       data[i][1]=data[i][1].replace("Αγγλική γλώσσα", "Αγγλικά");
       data[i][1]=data[i][1].replace("Αγγλική Γλώσσα", "Αγγλικά");
       data[i][1]=data[i][1].replace("Γαλλική γλώσσα", "Γαλλικά");
       data[i][1]=data[i][1].replace("Γαλλική Γλώσσα", "Γαλλικά");
       data[i][1]=data[i][1].replace("Ισπανική γλώσσα", "Ισπανικά");
       data[i][1]=data[i][1].replace("Ισπανική Γλώσσα", "Ισπανικά");
       data[i][1]=data[i][1].replace("Ιταλική γλώσσα", "Ιταλικά");
       data[i][1]=data[i][1].replace("Ιταλική Γλώσσα", "Ιταλικά");
       data[i][1]=data[i][1].replace("Γερμανική γλώσσα", "Γερμανικά");
       data[i][1]=data[i][1].replace("Γερμανική Γλώσσα", "Γερμανικά");
       data[i][1]=data[i][1].replace("Ολλανδική γλώσσα", "Ολλανδικά");
       data[i][1]=data[i][1].replace("Ολλανδική Γλώσσα", "Ολλανδικά");
       data[i][1]=data[i][1].replace("Ελληνική γλώσσα", "Ελληνικά");
       data[i][1]=data[i][1].replace("Ελληνική Γλώσσα", "Ελληνικά");
       data[i][1]=data[i][1].replace("Τουρκική γλώσσα", "Τουρκικά");
       data[i][1]=data[i][1].replace("Τουρκική Γλώσσα", "Τουρκικά");
       data[i][1]=data[i][1].replace("Σουηδική γλώσσα", "Σουηδικά");
       data[i][1]=data[i][1].replace("Σουηδική Γλώσσα", "Σουηδικά");
       data[i][1]=data[i][1].replace("Πορτογαλική γλώσσα", "Πορτογαλικά");
       data[i][1]=data[i][1].replace("Πορτογαλική Γλώσσα", "Πορτογαλικά");
       data[i][1]=data[i][1].replace("Αραβική γλώσσα", "Αραβικά");
       data[i][1]=data[i][1].replace("Αραβική Γλώσσα", "Αραβικά");
       data[i][1]=data[i][1].replace("Ρωσική γλώσσα", "Ρωσικά");
       data[i][1]=data[i][1].replace("Ρωσική Γλώσσα", "Ρωσικά");
   }
   
   for (i=language1;i<language2;i++) data[i][1]=data[i][1].replace("Αιγαίο", "Αιγαίο Πέλαγος");

return data;
}

public String[][] Selection(String [][] data){
   Random generator = new Random();
   String [][] selectedarray;
   int IndexStartsAt=0;
   int IndexEndsAt=0;
   int l=0; 

   selected=generator.nextInt(noimages); //selected=6;
   selected=images+selected;
   
   int [] index=index1();
   selectedindex=index[selected];
   selectedarray=new String[2][4];
 
   for (int i=0;i<selected;i++) {IndexStartsAt=IndexStartsAt+index[i];}
   //System.out.println("IndexStartsAt="+IndexStartsAt);
   IndexEndsAt=IndexStartsAt+index[selected];
   //System.out.println("IndexEndsAt="+IndexEndsAt);

   l=0;
   selectedarray=new String[index[selected]][4];
   for (int k=IndexStartsAt;k<IndexEndsAt;k++) {
          System.arraycopy(data[k], 0, selectedarray[l], 0, 4);   
          l++;
   }
   
   anagram=1; hangman=1;
   if (selected==18 || selected==19 || selected==20 || selected==21 || selected==22 || selected==30) {anagram=0;hangman=0;} 
   // 0 για να αλλάξει στήλη (Πληθυσμός Νησιών, Σύμβολα Χημικών Στοιχείων, Ημερομηνίες)
   // -1 για να αλλάξει παιχνίδι hangman=-1;
   
   return  selectedarray;
}

public int anagram () {return anagram;}
public int hangman () {return hangman;}

public String[][] Selection1(String [][] data){
   Random generator = new Random();
   String [][] selectedarray;
   int IndexStartsAt=0;
   int IndexEndsAt=0;
   int l=0;
   selected=generator.nextInt(images); //selected=12; 
   int [] index=index1();
  
   selectedindex=index[selected]; 
   selectedarray=new String[2][4];
 
   for (int i=0;i<selected;i++) {IndexStartsAt=IndexStartsAt+index[i];}
   //System.out.println("IndexStartsAt="+IndexStartsAt);
   IndexEndsAt=IndexStartsAt+index[selected];
   //System.out.println("IndexEndsAt="+IndexEndsAt);

   l=0;
   selectedarray=new String[index[selected]][4];
   for (int k=IndexStartsAt;k<IndexEndsAt;k++) {
          System.arraycopy(data[k], 0, selectedarray[l], 0, 4);
           l++;
   }

   
   return  selectedarray;
}

public String[][] Selection2(String [][] data){
   Random generator = new Random();
   String [][] selectedarray;
   int IndexStartsAt=0;
   int IndexEndsAt=0;
   int l=0;

   selected=generator.nextInt(multivalues); //selected=3;
   selected=uniquevalues+selected;
   
   int [] index=index1();
   selectedindex=index[selected];
   selectedarray=new String[2][4];
 
   for (int i=0;i<selected;i++) {IndexStartsAt=IndexStartsAt+index[i];}
   //System.out.println("IndexStartsAt="+IndexStartsAt);
   IndexEndsAt=IndexStartsAt+index[selected];
   //System.out.println("IndexEndsAt="+IndexEndsAt);

   l=0;
   selectedarray=new String[index[selected]][4];
   for (int k=IndexStartsAt;k<IndexEndsAt;k++) {
          System.arraycopy(data[k], 0, selectedarray[l], 0, 4);   
           l++;
   }
   
   
   return  selectedarray;
}

public int index(){  return selectedindex; } 

public String selectedcategory() { 
   String [] category=new String [questions];
   
   category[0]="Γεωγραφία";
   category[1]="Γεωγραφία";
   category[2]="Γεωγραφία";
   category[3]="Γεωγραφία";
   category[4]="Γεωγραφία";
   category[5]="Ιστορία";
   category[6]="Γεωγραφία";
   category[7]="Γεωγραφία";
   category[8]="Γεωγραφία";
   category[9]="Αθλητισμός";
   category[10]="Αθλητισμός";
   category[11]="Αστρονομία";
   category[12]="Γενικές Γνώσεις";
   category[13]="Γενικές Γνώσεις";
   
   category[14]="Γεωγραφία";
   category[15]="Γεωγραφία";
   category[16]="Γεωγραφία";
   category[17]="Γεωγραφία";
   category[18]="Γεωγραφία";
   category[19]="Χημεία";
   category[20]="Αστρονομία";
   category[21]="Ιστορία";
   category[22]="Γενικές Γνώσεις";
   
   category[23]="Γενικές Γνώσεις";
   category[24]="Γεωγραφία";
   category[25]="Πολιτική";
   category[26]="Γεωγραφία";
   category[27]="Γεωγραφία";
   category[28]="Γεωγραφία";
   category[29]="Γεωγραφία";
   category[30]="Γενικές Γνώσεις";
   // System.out.println("category["+selected+"]="+category[selected]);
   
    return category[selected];
}

public int indexall(){    
   int []index=index1();
   int indexall=0;
    
   for (int j=0;j<questions;j++) indexall=indexall+index[j];
 
   return indexall; 
}

/*
public int indexwithoutduplicates(){  return indexwithoutduplicates;  }

public int indexwithduplicates(){  return selectedindex;  }

public int indeximages (){
   int IndexStartsAt=0, IndexEndsAt=0,duplicate2=0, duplicates2;
   //String [][] data=data();
   int [] index1=index1();

   for (int plithos=0;plithos<images;plithos++) {  
   duplicates2=0;
   IndexStartsAt=0;IndexEndsAt=0;
   for (int i=0;i<plithos;i++) {IndexStartsAt=IndexStartsAt+index1[i];}
   for (int i=0;i<plithos+1;i++) {IndexEndsAt=IndexEndsAt+index1[i];}
   for (int line=IndexStartsAt;line<IndexEndsAt-1;line++) {
           duplicate2=0;
           for (int line2=line+1;line2<IndexEndsAt;line2++) {
                  if (data[line][0].equals(data[line2][0]) || data[line][1].equals(data[line2][1])) {
                        duplicate2=1;       
                  }
           }
           if( duplicate2==1) duplicates2++;
   }
   int indeximageswithoutduplicates=index1[plithos]-duplicates2; 
   if (indeximageswithoutduplicates>2) {indeximages=1; System.out.println("YES, γιατί "+index1[plithos]+" και "+indeximageswithoutduplicates);}
   else System.out.println("NO, γιατί "+index1[plithos]+" και "+indeximageswithoutduplicates);
   }
   System.out.println("Το τελικό:"+indeximages);
   return indeximages; 
}

public int indexnoimages (){
   int IndexStartsAt=0, IndexEndsAt=0,duplicate2=0, duplicates2;
   //String [][] data=data();
   int [] index1=index1();
  
   for (int plithos=images;plithos<images+noimages;plithos++) {  
        duplicates2=0;
        IndexStartsAt=0;IndexEndsAt=0;
        for (int i=0;i<plithos;i++) {IndexStartsAt=IndexStartsAt+index1[i];}
        for (int i=0;i<plithos+1;i++) {IndexEndsAt=IndexEndsAt+index1[i];}
        for (int line=IndexStartsAt;line<IndexEndsAt-1;line++) {
              duplicate2=0;
              for (int line2=line+1;line2<IndexEndsAt;line2++) {
                   if (data[line][0].equals(data[line2][0]) || data[line][1].equals(data[line2][1])) {
                        duplicate2=1;     //   System.out.println("Το "+line+" με το "+line2);    
                    }
              }
              if( duplicate2==1) duplicates2++;
        }
        int indexnoimageswithoutduplicates=index1[plithos]-duplicates2; 
        if (indexnoimageswithoutduplicates>2) indexnoimages=1;
   }
      
   return indexnoimages;  
}
*/

}