package GetData;

public class Shuffle{
    public String AnagramString (String string1) {
    
    //System.out.println("Input String = " + string1);
    string1=shuffle(string1);
    //System.out.println("Shuffled String = " + string1);
    return string1;
    }
 
    static String shuffle(String string1){
    if (string1.length()<=1)
        return string1;
 
    int split=string1.length()/2;
 
    String temp1=shuffle(string1.substring(0,split));
    String temp2=shuffle(string1.substring(split));
 
    if (Math.random() > 0.5)
        return temp1 + temp2;
    else
        return temp2 + temp1;
    }
}
