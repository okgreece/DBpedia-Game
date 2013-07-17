package GetData;

/*
 * @author Despina-Eleana Chrysou
 */
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import java.io.*;
import javax.swing.*;

public class Jena {
 public static void GetResults() {
     
 //Ερωτήματα με εικόνες
          
       // Ερώτημα 1: Χώρες-Σημαίες
        String QueryString=       
        "PREFIX ontology: <http://dbpedia.org/ontology/>" +
        "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
        "PREFIX foaf: <http://xmlns.com/foaf/0.1/>" +
        
        "select distinct ?country ?flag ?dbpedia1 ?wiki1 " +
        "where {  " +
        "?dbpedia1  rdf:type ontology:Country;" +
        "rdfs:label ?country.  " +
        "?dbpedia1 ontology:thumbnail ?flag." +
        "OPTIONAL {?dbpedia1 foaf:page ?wiki1.}" +
        "} ORDER BY ASC(?country) " ;

         Query query = QueryFactory.create(QueryString);
         QueryExecution qexec = QueryExecutionFactory.sparqlService("http://el.dbpedia.org/sparql", query);
         ResultSet results = qexec.execSelect();
         PrintStream stdout = System.out;
         
         //new File("C:\\temp").mkdir();
     
       String path2=JOptionPane.showInputDialog(null,"Γράψε το path στο οποίο θέλεις να σωθούν τα αποτελέσματα (π.χ. C:\\temp):");  
       if (path2==null | "".equals(path2)) {path2="C:/temp";}
       new File(path2).mkdir();
       String path=path2+"/"+"data.txt"; 
         
         try{
              File file=new File(path);  
              OutputStream output = new FileOutputStream(file);
              PrintStream printOut = new PrintStream(output,false,"Cp1253");
            
              System.setOut(printOut); 
              ResultSetFormatter.outputAsCSV(System.out,results); 
              
         }catch (Exception e){  }
         qexec.close() ;
         System.out.println("@@@");      
         
         
         // Ερώτημα 2: Πρωτεύουσες-Εικόνες   
         QueryString=    
        "PREFIX ontology: <http://dbpedia.org/ontology/>" +
        "PREFIX dbpedia-owl: <http://dbpedia.org/ontology/>" +
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
        "PREFIX foaf: <http://xmlns.com/foaf/0.1/>" +
                    
        "select distinct ?capital ?image ?dbpedia1 ?wiki1 " +
        "where { "+
        "?c ontology:capital ?dbpedia1. " +
        "?dbpedia1 rdfs:label ?capital . " +
        "?dbpedia1 dbpedia-owl:thumbnail ?image." +
        "OPTIONAL {?dbpedia1 foaf:page ?wiki1.}" +
        "} ORDER BY ASC(?capital) " ;
        
         query = QueryFactory.create(QueryString);
         qexec = QueryExecutionFactory.sparqlService("http://el.dbpedia.org/sparql", query);
         results = qexec.execSelect();
         try{
                 ResultSetFormatter.outputAsCSV(System.out,results);
          }catch (Exception e){  }
          qexec.close() ;
          System.out.println("@@@");
          
          // Ερώτημα 3: Πόλεις-Εικόνες   
         QueryString=    
        "PREFIX ontology: <http://dbpedia.org/ontology/>" +
        "PREFIX dbpedia-owl: <http://dbpedia.org/ontology/>" +
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
        "PREFIX foaf: <http://xmlns.com/foaf/0.1/>" +
                    
        "select distinct ?city ?image ?dbpedia1 ?wiki1 " +
        "where { "+
        "?c ontology:city ?dbpedia1. " +
        "?dbpedia1 rdfs:label ?city . " +
        "?dbpedia1 dbpedia-owl:thumbnail ?image." +
        "OPTIONAL {?dbpedia1 foaf:page ?wiki1.}" +
        "} ORDER BY ASC(?city) " ;
        
         query = QueryFactory.create(QueryString);
         qexec = QueryExecutionFactory.sparqlService("http://el.dbpedia.org/sparql", query);
         results = qexec.execSelect();
         try{
                 ResultSetFormatter.outputAsCSV(System.out,results);
          }catch (Exception e){  }
          qexec.close() ;
          System.out.println("@@@");
                    
        // Ερώτημα 4: Πολιτείες της Αμερικής-Σημαίες 
        QueryString=       
        "PREFIX ontology: <http://dbpedia.org/ontology/>" +
        "PREFIX dbpedia-owl: <http://dbpedia.org/ontology/>" +
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
        "PREFIX dcterms: <http://purl.org/dc/terms/>"+
        "PREFIX category-el: <http://el.dbpedia.org/resource/Κατηγορία:>" +
        "PREFIX foaf: <http://xmlns.com/foaf/0.1/>" +
        
        "select distinct ?state ?image ?dbpedia1 ?wiki1 " +
        "where { " +
        "?dbpedia1 rdfs:label ?state; "+
        "dcterms:subject category-el:Πολιτείες_των_ΗΠΑ. " +
        "?dbpedia1 dbpedia-owl:thumbnail ?image. " +
        "OPTIONAL {?dbpedia1 foaf:page ?wiki1.}" +
        "} ORDER BY ASC(?state) " ;
                     
         query = QueryFactory.create(QueryString);
         qexec = QueryExecutionFactory.sparqlService("http://el.dbpedia.org/sparql", query);
         results = qexec.execSelect();
         try{
                 ResultSetFormatter.outputAsCSV(System.out,results);
          }catch (Exception e){  }
          qexec.close() ;
          System.out.println("@@@");                     
        
          // Ερώτημα 5: Πολιτισμική Κληρονομιά-Εικόνες   
          QueryString=    
        "PREFIX ontology: <http://dbpedia.org/ontology/> " +
        "PREFIX dbpedia-owl: <http://dbpedia.org/ontology/> " +
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
        "PREFIX dbpprop-el: <http://el.dbpedia.org/property/> " +
        "PREFIX prototype-el: <http://el.dbpedia.org/resource/Πρότυπο:> " +
        "PREFIX foaf: <http://xmlns.com/foaf/0.1/> " +

        "select distinct ?politismiki_klironomia ?image ?dbpedia1 ?wiki1 " +
        "where {  " +
        "?dbpedia1  dbpprop-el:wikiPageUsesTemplate prototype-el:Πληροφορίες_Παγκόσμια_Πολιτισμική_Κληρονομιά; " +
        "rdfs:label ?politismiki_klironomia. " +
        "?dbpedia1 dbpedia-owl:thumbnail ?image. " +
        "OPTIONAL {?dbpedia1 foaf:page ?wiki1.}  " +
        "} ORDER BY ASC(?politismiki_klironomia) " ;
  
         query = QueryFactory.create(QueryString);
         qexec = QueryExecutionFactory.sparqlService("http://el.dbpedia.org/sparql", query);
         results = qexec.execSelect();
         try{
                 ResultSetFormatter.outputAsCSV(System.out,results);
          }catch (Exception e){  }
          qexec.close() ;
          System.out.println("@@@");

        // Ερώτημα 6: Αρχαιολογικοί χώροι-Εικόνες 
        QueryString=    
        "PREFIX ontology: <http://dbpedia.org/ontology/>" +
        "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
        "PREFIX dcterms: <http://purl.org/dc/terms/>" +
        "PREFIX category-el: <http://el.dbpedia.org/resource/Κατηγορία:>" +
        "PREFIX foaf: <http://xmlns.com/foaf/0.1/>" +
        
        "select distinct ?ancientsite ?image ?dbpedia1 ?wiki1 " +
        "where { " +
        "?dbpedia1  dcterms:subject category-el:Αρχαιολογικοί_τόποι_στην_Ελλάδα;" +
        "rdfs:label ?ancientsite. " +
        "?dbpedia1  ontology:thumbnail ?image. " +
        "OPTIONAL {?dbpedia1 foaf:page ?wiki1.}" +
        "} ORDER BY ASC(?ancientsite) " ;
         
         query = QueryFactory.create(QueryString);
         qexec = QueryExecutionFactory.sparqlService("http://el.dbpedia.org/sparql", query);
         results = qexec.execSelect();
         try{
                 ResultSetFormatter.outputAsCSV(System.out,results);
          }catch (Exception e){  }
          qexec.close() ;
           
         QueryString=    
        "PREFIX ontology: <http://dbpedia.org/ontology/>" +
        "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
        "PREFIX dcterms: <http://purl.org/dc/terms/>" +
        "PREFIX category-el: <http://el.dbpedia.org/resource/Κατηγορία:>" +
        "PREFIX foaf: <http://xmlns.com/foaf/0.1/>" +
        
        "select distinct ?ancientsite2 ?image ?dbpedia1 ?wiki1 " +
        "where { " +
        "?dbpedia1  dcterms:subject category-el:Αρχαίοι_ναοί_της_Αθήνας; " +
        "rdfs:label ?ancientsite2. " +
        "?dbpedia1  ontology:thumbnail ?image. " +
        "OPTIONAL {?dbpedia1 foaf:page ?wiki1.}" +
        "} ORDER BY ASC(?ancientsite2) " ;
         
         query = QueryFactory.create(QueryString);
         qexec = QueryExecutionFactory.sparqlService("http://el.dbpedia.org/sparql", query);
         results = qexec.execSelect();
         try{
                 ResultSetFormatter.outputAsCSV(System.out,results);
          }catch (Exception e){  }
          qexec.close() ;

        QueryString=    
        "PREFIX ontology: <http://dbpedia.org/ontology/>" +
        "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
        "PREFIX dcterms: <http://purl.org/dc/terms/>" +
        "PREFIX category-el: <http://el.dbpedia.org/resource/Κατηγορία:>" +
        "PREFIX foaf: <http://xmlns.com/foaf/0.1/>" +
        
        "select distinct ?ancientsite2 ?image ?dbpedia1 ?wiki1 " +
        "where { " +
        "?dbpedia1  dcterms:subject category-el:Αρχαίοι_ναοί; " +
        "rdfs:label ?ancientsite2. " +
        "?dbpedia1  ontology:thumbnail ?image. " +
        "OPTIONAL {?dbpedia1 foaf:page ?wiki1.}" +
        "} ORDER BY ASC(?ancientsite2) " ;
         
         query = QueryFactory.create(QueryString);
         qexec = QueryExecutionFactory.sparqlService("http://el.dbpedia.org/sparql", query);
         results = qexec.execSelect();
         try{
                 ResultSetFormatter.outputAsCSV(System.out,results);
          }catch (Exception e){  }
          qexec.close() ;
          
         QueryString=    
        "PREFIX ontology: <http://dbpedia.org/ontology/>" +
        "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
        "PREFIX dcterms: <http://purl.org/dc/terms/>" +
        "PREFIX yago: <http://dbpedia.org/class/yago/>"+
        "PREFIX foaf: <http://xmlns.com/foaf/0.1/>" +
        
        "select distinct ?ancientsite2 ?image ?dbpedia1 ?wiki1 " +
        "where { "+
        "?dbpedia1  rdf:type yago:AncientGreekArchaeologicalSitesInGreece; " +
        "rdfs:label ?ancientsite2. " +
        "?dbpedia1 ontology:thumbnail ?image. " +
        "OPTIONAL {?dbpedia1 foaf:page ?wiki1.}" +
        "} ORDER BY ASC(?ancientsite2) " ;
         
         query = QueryFactory.create(QueryString);
         qexec = QueryExecutionFactory.sparqlService("http://el.dbpedia.org/sparql", query);
         results = qexec.execSelect();
         try{
                 ResultSetFormatter.outputAsCSV(System.out,results);
          }catch (Exception e){  }
          qexec.close() ;
          System.out.println("@@@");
          
        // Ερώτημα 7: Μνημεία-Εικόνες  
        QueryString=    
        "PREFIX ontology: <http://dbpedia.org/ontology/>" +
        "PREFIX dbpedia-owl: <http://dbpedia.org/ontology/>"+
        "PREFIX category-el: <http://el.dbpedia.org/resource/Κατηγορία:>" +
        "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "+
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "+
        "PREFIX dcterms: <http://purl.org/dc/terms/>" +
        "PREFIX foaf: <http://xmlns.com/foaf/0.1/>" +
               
        "select distinct ?monument ?image ?dbpedia1 ?wiki1 " +
        "where { "+
        "?dbpedia1  rdfs:label ?monument; " +
        "rdf:type dbpedia-owl:Place; " +
        "dcterms:subject category-el:Μνημεία_Παγκόσμιας_Πολιτιστικής_Κληρονομιάς. " +
        " ?dbpedia1  dbpedia-owl:thumbnail ?image." +
        "OPTIONAL {?dbpedia1 foaf:page ?wiki1.}" +
        "} ORDER BY ASC(?monument) " ;
         
         query = QueryFactory.create(QueryString);
         qexec = QueryExecutionFactory.sparqlService("http://el.dbpedia.org/sparql", query);
         results = qexec.execSelect();
         try{
                 ResultSetFormatter.outputAsCSV(System.out,results);
          }catch (Exception e){  }
          qexec.close() ;
          System.out.println("@@@");
    
        // Ερώτημα 8: Κάστρα-Εικόνες  
        QueryString=    
        "PREFIX ontology: <http://dbpedia.org/ontology/> " +
        "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
        "PREFIX dcterms: <http://purl.org/dc/terms/> " +
        "PREFIX category-el: <http://el.dbpedia.org/resource/Κατηγορία:> " +
        "PREFIX foaf: <http://xmlns.com/foaf/0.1/> " +
        
        "select distinct ?castle ?image ?dbpedia1 ?wiki1  " +
        "where { " +
        "?dbpedia1  dcterms:subject category-el:Κάστρα; " +
        "rdfs:label ?castle. " +
        "?dbpedia1  ontology:thumbnail ?image.  " +
        "OPTIONAL {?dbpedia1 foaf:page ?wiki1.} " +  
        "} ORDER BY ASC(?castle) " ;

         query = QueryFactory.create(QueryString);
         qexec = QueryExecutionFactory.sparqlService("http://el.dbpedia.org/sparql", query);
         results = qexec.execSelect();
         try{
                 ResultSetFormatter.outputAsCSV(System.out,results);
          }catch (Exception e){  }
          qexec.close() ;
          System.out.println("@@@");
       
        // Ερώτημα 9: Πύργοι-Εικόνες   
        QueryString=    
        "PREFIX ontology: <http://dbpedia.org/ontology/> " +
        "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
        "PREFIX dcterms: <http://purl.org/dc/terms/> " +
        "PREFIX category-el: <http://el.dbpedia.org/resource/Κατηγορία:> " +
        "PREFIX foaf: <http://xmlns.com/foaf/0.1/> " +
        
        "select distinct ?tower ?image ?dbpedia1 ?wiki1  " +
        "where { " +
        "?dbpedia1  dcterms:subject category-el:Πύργοι; " +
        "rdfs:label ?tower. " +
        "?dbpedia1  ontology:thumbnail ?image.  " +
        "OPTIONAL {?dbpedia1 foaf:page ?wiki1.} " +  
        "} ORDER BY ASC(?tower) " ;

         query = QueryFactory.create(QueryString);
         qexec = QueryExecutionFactory.sparqlService("http://el.dbpedia.org/sparql", query);
         results = qexec.execSelect();
         try{
                 ResultSetFormatter.outputAsCSV(System.out,results);
          }catch (Exception e){  }
          qexec.close() ;
          System.out.println("@@@");

        // Ερώτημα 10: Αθλήματα-Εικόνες  
        QueryString=    
        "PREFIX ontology: <http://dbpedia.org/ontology/> " +
        "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
        "PREFIX dcterms: <http://purl.org/dc/terms/> " +
        "PREFIX category-el: <http://el.dbpedia.org/resource/Κατηγορία:> " +
        "PREFIX foaf: <http://xmlns.com/foaf/0.1/> " +
        
        "select distinct ?sport ?image ?dbpedia1 ?wiki1  " +
        "where { " +
        "?dbpedia1  dcterms:subject category-el:Αθλήματα; " +
        "rdfs:label ?sport. " +
        "?dbpedia1  ontology:thumbnail ?image.  " +
        "OPTIONAL {?dbpedia1 foaf:page ?wiki1.} " +  
        "} ORDER BY ASC(?sport) " ;

         query = QueryFactory.create(QueryString);
         qexec = QueryExecutionFactory.sparqlService("http://el.dbpedia.org/sparql", query);
         results = qexec.execSelect();
         try{
                 ResultSetFormatter.outputAsCSV(System.out,results);
          }catch (Exception e){  }
          qexec.close() ;
          System.out.println("@@@");
       
        // Ερώτημα 11: Ολυμπιακά Αθλήματα-Εικόνες  
        QueryString=    
        "PREFIX ontology: <http://dbpedia.org/ontology/> " +
        "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
        "PREFIX dcterms: <http://purl.org/dc/terms/> " +
        "PREFIX category-el: <http://el.dbpedia.org/resource/Κατηγορία:> " +
        "PREFIX foaf: <http://xmlns.com/foaf/0.1/> " +
        
        "select distinct ?olympicsport ?image ?dbpedia1 ?wiki1  " +
        "where { " +
        "?dbpedia1  dcterms:subject category-el:Ολυμπιακά_αθλήματα; " +
        "rdfs:label ?olympicsport. " +
        "?dbpedia1  ontology:thumbnail ?image.  " +
        "OPTIONAL {?dbpedia1 foaf:page ?wiki1.} " +  
        "} ORDER BY ASC(?olympicsport) " ;

         query = QueryFactory.create(QueryString);
         qexec = QueryExecutionFactory.sparqlService("http://el.dbpedia.org/sparql", query);
         results = qexec.execSelect();
         try{
                 ResultSetFormatter.outputAsCSV(System.out,results);
          }catch (Exception e){  }
          qexec.close() ;
          System.out.println("@@@");
       
        // Ερώτημα 12: Πλανήτες-Εικόνες   
        QueryString=    
        "PREFIX ontology: <http://dbpedia.org/ontology/> " +
        "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
        "PREFIX dcterms: <http://purl.org/dc/terms/> " +
        "PREFIX category-el: <http://el.dbpedia.org/resource/Κατηγορία:> " +
        "PREFIX foaf: <http://xmlns.com/foaf/0.1/> " +
        
        "select distinct ?planet ?image ?dbpedia1 ?wiki1  " +
        "where { " +
        "?dbpedia1  dcterms:subject category-el:Πλανήτες_του_Ηλιακού_Συστήματος; " +
        "rdfs:label ?planet. " +
        "?dbpedia1  ontology:thumbnail ?image.  " +
        "OPTIONAL {?dbpedia1 foaf:page ?wiki1.} " +  
        "} ORDER BY ASC(?planet) " ;

         query = QueryFactory.create(QueryString);
         qexec = QueryExecutionFactory.sparqlService("http://el.dbpedia.org/sparql", query);
         results = qexec.execSelect();
         try{
                 ResultSetFormatter.outputAsCSV(System.out,results);
          }catch (Exception e){  }
          qexec.close() ;
          System.out.println("@@@");
          
        // Ερώτημα 13: Πρόσωπα-Φωτογραφία
        QueryString=
        "PREFIX ontology: <http://dbpedia.org/ontology/> " +
        "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
        "PREFIX dbpedia-owl: <http://dbpedia.org/ontology/>" +
        "PREFIX foaf:  <http://xmlns.com/foaf/0.1/> " +

        "select distinct ?name ?image ?dbpedia1 ?wiki1 " +
        "where { " +
        "?dbpedia1 rdf:type ontology:Person; " +                                                    
        "rdfs:label ?name. " +
        "?dbpedia1 dbpedia-owl:thumbnail ?image " +
        "OPTIONAL {?dbpedia1 foaf:page ?wiki1.} " +
        "} ORDER BY ASC (?name) " ; 

        
         query = QueryFactory.create(QueryString);
         qexec = QueryExecutionFactory.sparqlService("http://el.dbpedia.org/sparql", query);
         results = qexec.execSelect();
         try{
                 ResultSetFormatter.outputAsCSV(System.out,results);
          }catch (Exception e){  }
          qexec.close() ;
         System.out.println("@@@");
              
          
 //Ερωτήματα χωρίς εικόνες
          
         // Ερώτημα 14: Χώρες-Πρωτεύουσες   
          QueryString=         
        "PREFIX ontology: <http://dbpedia.org/ontology/>" +
        "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"+
        "PREFIX foaf: <http://xmlns.com/foaf/0.1/>" +
    
        "select distinct ?country ?capital ?dbpedia1 ?wiki1 " +
        "where { " +
        "?dbpedia1  rdf:type ontology:Country; " +
        " rdfs:label ?country. " +
        "?dbpedia1 ontology:capital ?cap_uri. " +
        "?cap_uri rdfs:label ?capital. " +
        "OPTIONAL {?dbpedia1 foaf:page ?wiki1.}" +
        "} ORDER BY ASC(?country) " ;

         query = QueryFactory.create(QueryString);
         qexec = QueryExecutionFactory.sparqlService("http://el.dbpedia.org/sparql", query);
         results = qexec.execSelect();
         try{
                 ResultSetFormatter.outputAsCSV(System.out,results);
          }catch (Exception e){  }
          qexec.close() ;
          System.out.println("@@@");

         // Ερώτημα 15: Νομοί της Ελλάδας-Πρωτεύουσες 
        QueryString=       
        "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"+
        "PREFIX ontology: <http://dbpedia.org/ontology/>"+
        "PREFIX dbpedia: <http://el.dbpedia.org/resource/>"+
        "PREFIX dbpprop-el: <http://el.dbpedia.org/property/>"+
        "PREFIX dcterms: <http://purl.org/dc/terms/>"+
        "PREFIX category-el: <http://el.dbpedia.org/resource/Κατηγορία:>" +
        "PREFIX foaf: <http://xmlns.com/foaf/0.1/>" +

        "select distinct ?nomos ?capital ?dbpedia1 ?wiki1 " +
        "where { " +
        "?dbpedia1 rdf:type ontology:AdministrativeRegion; " +   
        "dcterms:subject category-el:Νομοί_της_Ελλάδας; "+
        "rdfs:label ?nomos." +
        "?dbpedia1 dbpprop-el:πρωτεύουσα ?capital."+
        "OPTIONAL {?dbpedia1 foaf:page ?wiki1.}" +
        "} ORDER BY ASC(?nomos) " ;
         
         query = QueryFactory.create(QueryString);
         qexec = QueryExecutionFactory.sparqlService("http://el.dbpedia.org/sparql", query);
         results = qexec.execSelect();
         try{
                 ResultSetFormatter.outputAsCSV(System.out,results);
          }catch (Exception e){  }
          qexec.close() ;
          System.out.println("@@@");
          
        // Ερώτημα 16: Πολιτείες της Αμερικής-Πρωτεύουσες 
        QueryString=
        "PREFIX ontology: <http://dbpedia.org/ontology/> " +
        "PREFIX dbpedia-owl: <http://dbpedia.org/ontology/> " +
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
        "PREFIX dcterms: <http://purl.org/dc/terms/>" +
        "PREFIX dbpprop-el: <http://el.dbpedia.org/property/> " +
        "PREFIX category-el: <http://el.dbpedia.org/resource/Κατηγορία:> " +
        "PREFIX foaf: <http://xmlns.com/foaf/0.1/> " +
        
        "select distinct ?state ?capital  ?dbpedia1 ?wiki1 " +
        "where {  " +
        "?dbpedia1 rdfs:label ?state; " +
        "dcterms:subject category-el:Πολιτείες_των_ΗΠΑ. " +
        "?dbpedia1 dbpprop-el:πρωτεύουσα ?cap_uri. " +
        "?cap_uri rdfs:label ?capital. " +
        "OPTIONAL {?dbpedia1 foaf:page ?wiki1.}  " +
        "} ORDER BY ASC(?state)  ";
       
         query = QueryFactory.create(QueryString);
         qexec = QueryExecutionFactory.sparqlService("http://el.dbpedia.org/sparql", query);
         results = qexec.execSelect();
         try{
                 ResultSetFormatter.outputAsCSV(System.out,results);
          }catch (Exception e){  }
          qexec.close() ;
          System.out.println("@@@");
                   
         // Ερώτημα 17: Κάστρα-Χώρες 
         QueryString=
        "PREFIX ontology: <http://dbpedia.org/ontology/> " +
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
        "PREFIX category-el: <http://el.dbpedia.org/resource/Κατηγορία:>" +
        "PREFIX dcterms: <http://purl.org/dc/terms/>" +
        "PREFIX dbpedia-owl: <http://dbpedia.org/ontology/> " +
        "PREFIX foaf: <http://xmlns.com/foaf/0.1/> " +
        
        "select distinct ?castle ?country ?dbpedia1 ?wiki1 " +
        "where { " +
        "?dbpedia1  dcterms:subject category-el:Κάστρα; " +
        "rdfs:label ?castle. " +
        "?dbpedia1 dbpedia-owl:country ?country_uri. " +
        "?country_uri rdfs:label ?country. " +
        "OPTIONAL {?dbpedia1 foaf:page ?wiki1.} " +  
        "} ORDER BY ASC(?castle) " ;

         query = QueryFactory.create(QueryString);
         qexec = QueryExecutionFactory.sparqlService("http://el.dbpedia.org/sparql", query);
         results = qexec.execSelect();
         try{
                 ResultSetFormatter.outputAsCSV(System.out,results);
          }catch (Exception e){  }
          qexec.close() ;
          System.out.println("@@@");
          
         // Ερώτημα 18: Νησιά-Πληθυσμός
        QueryString=   
        "PREFIX dbpedia: <http://el.dbpedia.org/resource/>" +
        "PREFIX ontology: <http://dbpedia.org/ontology/>" +
        "PREFIX dbpedia-owl: <http://dbpedia.org/ontology/>" +
        "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
        "PREFIX foaf:  <http://xmlns.com/foaf/0.1/> " +

        "select distinct ?island ?population ?dbpedia1 ?wiki1 " +
        "where { " +
        "?dbpedia1 rdf:type ontology:Island;  " +                                                   
        "rdfs:label ?island; " +				
        "dbpedia-owl:populationTotal ?population ." +
        "OPTIONAL {?dbpedia1 foaf:page ?wiki1.}  " +
        "FILTER (?population > 0) . " +
        "} ORDER BY ASC (?island) " ;

         query = QueryFactory.create(QueryString);
         qexec = QueryExecutionFactory.sparqlService("http://el.dbpedia.org/sparql", query);
         results = qexec.execSelect();
         try{
                 ResultSetFormatter.outputAsCSV(System.out,results);
          }catch (Exception e){  }
          qexec.close() ;
          System.out.println("@@@"); 
          
          // Ερώτημα 19: Χημικά Στοιχεία-Σύμβολα 
         QueryString=      
        "PREFIX dbpedia: <http://el.dbpedia.org/resource/>" +
        "PREFIX ontology: <http://dbpedia.org/ontology/>"+
        "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"+
        "PREFIX dbpprop-el: <http://el.dbpedia.org/property/>"+
        "PREFIX foaf: <http://xmlns.com/foaf/0.1/>" +

        "select distinct ?chemicalsubstance ?symbol ?dbpedia1 ?wiki1 " +
        "where { "+
        "?dbpedia1 rdfs:label ?chemicalsubstance; "+
        "rdf:type ontology:ChemicalSubstance. "+
        "?dbpedia1 dbpprop-el:σύμβολο ?symbol. "+
        "OPTIONAL {?dbpedia1 foaf:page ?wiki1.}" +
        "} ORDER BY ASC (?chemicalsubstance) ";
          
         query = QueryFactory.create(QueryString);
         qexec = QueryExecutionFactory.sparqlService("http://el.dbpedia.org/sparql", query);
         results = qexec.execSelect();
         try{
                 ResultSetFormatter.outputAsCSV(System.out,results);
          }catch (Exception e){  }
          qexec.close() ;
          System.out.println("@@@");
          
        // Ερώτημα 20: Διαστημικές Αποστολές-Ημερομηνίες Εκτόξευσης 
        QueryString=
        "PREFIX dbpedia: <http://el.dbpedia.org/resource/>" +
        "PREFIX ontology: <http://dbpedia.org/ontology/>"+
        "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"+
        "PREFIX dbpedia-owl: <http://dbpedia.org/ontology/>" +
        "PREFIX foaf: <http://xmlns.com/foaf/0.1/>" +

        "select distinct ?spacecraft ?launchdate ?dbpedia1 ?wiki1 " +
        "where { " +
        "?dbpedia1 rdfs:label ?spacecraft; " +
        " rdf:type ontology:SpaceMission. " +
        "?dbpedia1 dbpedia-owl:launchDate ?launchdate. " +
        "OPTIONAL {?dbpedia1 foaf:page ?wiki1.}" +
        "} ORDER BY ASC (?spacecraft) " ;

         query = QueryFactory.create(QueryString);
         qexec = QueryExecutionFactory.sparqlService("http://el.dbpedia.org/sparql", query);
         results = qexec.execSelect();
         try{
                 ResultSetFormatter.outputAsCSV(System.out,results);
          }catch (Exception e){  }
          qexec.close() ;
          System.out.println("@@@");
 
        // Ερώτημα 21: Πρόσωπα-Ημερομηνία Θανάτου
        QueryString=
        "PREFIX ontology: <http://dbpedia.org/ontology/> " +
        "PREFIX category: <http://el.dbpedia.org/resource/Κατηγορία:> " +
        "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
        "PREFIX foaf:  <http://xmlns.com/foaf/0.1/> " +

        "select distinct ?person ?deathDate ?dbpedia1 ?wiki1 " +
        "where { " +
        "?dbpedia1 rdfs:label ?person;  " +
        "  rdf:type ontology:Person. " +
        "?dbpedia1 ontology:deathDate ?deathDate. " +
        "OPTIONAL {?dbpedia1 foaf:page ?wiki1.} " +
        "} ORDER BY ASC (?person) " ;
          
         query = QueryFactory.create(QueryString);
         qexec = QueryExecutionFactory.sparqlService("http://el.dbpedia.org/sparql", query);
         results = qexec.execSelect();
         try{
                 ResultSetFormatter.outputAsCSV(System.out,results);
          }catch (Exception e){  }
          qexec.close() ;
          System.out.println("@@@"); 
     
// Με πολλαπλές τιμές    
    
        // Ερώτημα 22: Πρόσωπα-Τόπος Γέννησης
        QueryString=   
        "PREFIX ontology: <http://dbpedia.org/ontology/> " +
        "PREFIX category: <http://el.dbpedia.org/resource/Κατηγορία:> " +
        "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
        "PREFIX foaf:  <http://xmlns.com/foaf/0.1/> " +

        "select distinct ?person ?birthPlace ?dbpedia1 ?wiki1 " +
        "where { " +
        "?dbpedia1 rdfs:label ?person; " +
        "   rdf:type ontology:Person. " +
        "?dbpedia1 ontology:birthPlace ?place_link. " +
        "?place_link rdfs:label ?birthPlace. " +
        "OPTIONAL {?dbpedia1 foaf:page ?wiki1.} " +
        "} ORDER BY ASC (?person) " ;

         query = QueryFactory.create(QueryString);
         qexec = QueryExecutionFactory.sparqlService("http://el.dbpedia.org/sparql", query);
         results = qexec.execSelect();
         try{
                 ResultSetFormatter.outputAsCSV(System.out,results);
          }catch (Exception e){  }
          qexec.close() ;
          System.out.println("@@@"); 
      
        // Ερώτημα 23: Πολιτισμική Κληρονομιά-Χώρα
        QueryString=
        "PREFIX ontology: <http://dbpedia.org/ontology/> " +
        "PREFIX dbpedia-owl: <http://dbpedia.org/ontology/> " +
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
        "PREFIX dbpprop-el: <http://el.dbpedia.org/property/> " +
        "PREFIX prototype-el: <http://el.dbpedia.org/resource/Πρότυπο:> " +
        "PREFIX foaf: <http://xmlns.com/foaf/0.1/> " +

        "select distinct ?politismiki_klironomia ?country ?dbpedia1 ?wiki1  " +
        "where { " +
        "?dbpedia1  dbpprop-el:wikiPageUsesTemplate " +
        "prototype-el:Πληροφορίες_Παγκόσμια_Πολιτισμική_Κληρονομιά; " +
        "rdfs:label ?politismiki_klironomia. " +
        "?dbpedia1 dbpedia-owl:country ?country_uri. " +
        "?country_uri rdfs:label ?country. " +
        "OPTIONAL {?dbpedia1 foaf:page ?wiki1.}  " +
        "} ORDER BY ASC(?politismiki_klironomia) " ;
       
         query = QueryFactory.create(QueryString);
         qexec = QueryExecutionFactory.sparqlService("http://el.dbpedia.org/sparql", query);
         results = qexec.execSelect();
         try{
                 ResultSetFormatter.outputAsCSV(System.out,results);
          }catch (Exception e){  }
          qexec.close() ;
          System.out.println("@@@");
          
         // Ερώτημα 24: Πολιτικοί-Γραφεία
         QueryString=
        "PREFIX ontology: <http://dbpedia.org/ontology/> " +
        "PREFIX dbpedia-owl: <http://dbpedia.org/ontology/> " +
        "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
        "PREFIX foaf: <http://xmlns.com/foaf/0.1/> " +

        "select distinct ?politician ?office ?dbpedia1 ?wiki1  " +
        "where { " +
        "?dbpedia1  rdf:type ontology:Politician;  " +
        "rdfs:label ?politician. " +
        "?dbpedia1 dbpedia-owl:office ?office. "+
        "OPTIONAL {?dbpedia1 foaf:page ?wiki1.}  " +
        "} ORDER BY ASC(?politician) " ;
       
         query = QueryFactory.create(QueryString);
         qexec = QueryExecutionFactory.sparqlService("http://el.dbpedia.org/sparql", query);
         results = qexec.execSelect();
         try{
                 ResultSetFormatter.outputAsCSV(System.out,results);
          }catch (Exception e){  }
          qexec.close() ;
          System.out.println("@@@");
          
         // Ερώτημα 25: Χώρες-Γλώσσες
         QueryString=
        "PREFIX ontology: <http://dbpedia.org/ontology/> " +
        "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
        "PREFIX foaf: <http://xmlns.com/foaf/0.1/> " +

        "select distinct ?country ?language ?dbpedia1 ?wiki1  " +
        "where { " +
        "?dbpedia1  rdf:type ontology:Country;  " +
        "rdfs:label ?country. " +
        "?dbpedia1  ontology:language ?dbpedia2.  " +
        "?dbpedia2 rdfs:label ?language. " +
        "OPTIONAL {?dbpedia1 foaf:page ?wiki1.}  " +
        "} ORDER BY ASC(?country) " ;
       
         query = QueryFactory.create(QueryString);
         qexec = QueryExecutionFactory.sparqlService("http://el.dbpedia.org/sparql", query);
         results = qexec.execSelect();
         try{
                 ResultSetFormatter.outputAsCSV(System.out,results);
          }catch (Exception e){  }
          qexec.close() ;
          System.out.println("@@@");

          // Ερώτημα 26: Χώρες-Νομίσματα
         QueryString=
        "PREFIX ontology: <http://dbpedia.org/ontology/> " +
        "PREFIX dbpedia-owl: <http://dbpedia.org/ontology/> " +
        "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>  " +
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
        "PREFIX foaf: <http://xmlns.com/foaf/0.1/> " +
    
        "select distinct ?country ?currency ?dbpedia1 ?wiki1 " +
        "where {  " +
        "?dbpedia1  rdf:type ontology:Country; " +
        "rdfs:label ?country. " +
        "OPTIONAL {?dbpedia1 foaf:page ?wiki1.} " +
        "?dbpedia1  dbpedia-owl:currency ?dbpedia2.  " +
        "?dbpedia2 rdfs:label ?currency. " +
        "} ORDER BY ASC(?country) " ;

       
         query = QueryFactory.create(QueryString);
         qexec = QueryExecutionFactory.sparqlService("http://el.dbpedia.org/sparql", query);
         results = qexec.execSelect();
         try{
                 ResultSetFormatter.outputAsCSV(System.out,results);
          }catch (Exception e){  }
          qexec.close() ;
          System.out.println("@@@");
          
         // Ερώτημα 27: Νησιά-Χώρες
         QueryString=
        "PREFIX ontology: <http://dbpedia.org/ontology/> " +
        "PREFIX dbpedia-owl: <http://dbpedia.org/ontology/> " +
        "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
        "PREFIX foaf: <http://xmlns.com/foaf/0.1/> " +

        "select distinct ?island ?country ?dbpedia1 ?wiki1  " +
        "where {  " +
        "?dbpedia1  rdf:type ontology:Island;  " +
        "rdfs:label ?island. " +
        "OPTIONAL {?dbpedia1 foaf:page ?wiki1.}  " +
        "?dbpedia1 dbpedia-owl:country ?dbpedia2. " +
        "OPTIONAL {?dbpedia2 rdfs:label ?country.} " +
        "} ORDER BY ASC(?island) " ;
       
         query = QueryFactory.create(QueryString);
         qexec = QueryExecutionFactory.sparqlService("http://el.dbpedia.org/sparql", query);
         results = qexec.execSelect();
         try{
                 ResultSetFormatter.outputAsCSV(System.out,results);
          }catch (Exception e){  }
          qexec.close() ;
          System.out.println("@@@");
          
         // Ερώτημα 28: Νησιά-Τοποθεσία
         QueryString=
        "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
        "PREFIX foaf:  <http://xmlns.com/foaf/0.1/> " +
        "PREFIX dbpedia: <http://el.dbpedia.org/resource/> " +
        "PREFIX ontology: <http://dbpedia.org/ontology/> " +

        "select distinct ?island ?archipelago ?dbpedia1 ?wiki1 " +
        "where { " +
        "?dbpedia1 rdf:type ontology:Island; " +                                                    
        "   rdfs:label ?island. " +
        "OPTIONAL {?dbpedia1 foaf:page ?wiki1.} " +
        "?dbpedia1 ontology:archipelago ?archipelago_uri. " +
        "?archipelago_uri rdfs:label ?archipelago. " +
        "} ORDER BY ASC (?island) " ; 

       
         query = QueryFactory.create(QueryString);
         qexec = QueryExecutionFactory.sparqlService("http://el.dbpedia.org/sparql", query);
         results = qexec.execSelect();
         try{
                 ResultSetFormatter.outputAsCSV(System.out,results);
          }catch (Exception e){  }
          qexec.close() ;
          System.out.println("@@@");
          
         // Ερώτημα 29: Πρόσωπα-Περιγραφή
         QueryString=
         "PREFIX ontology: <http://dbpedia.org/ontology/> " +
        "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
        "PREFIX dbpprop-el: <http://el.dbpedia.org/property/> " +
        "PREFIX foaf:  <http://xmlns.com/foaf/0.1/> " +

        "select distinct ?name ?description ?dbpedia1 ?wiki1 " +
        "where { " +
        "?dbpedia1 rdf:type ontology:Person; " +                                                    
        "rdfs:label ?name. " +
        "?dbpedia1 dbpprop-el:μικρηΠεριγραφη ?description. " +
        "OPTIONAL {?dbpedia1 foaf:page ?wiki1.} " +
        "} ORDER BY ASC (?name) " ; 

       
         query = QueryFactory.create(QueryString);
         qexec = QueryExecutionFactory.sparqlService("http://el.dbpedia.org/sparql", query);
         results = qexec.execSelect();
         try{
                 ResultSetFormatter.outputAsCSV(System.out,results);
          }catch (Exception e){  }
          qexec.close() ;
          System.out.println("@@@");
          
        System.setOut(stdout);
        
    }

}
