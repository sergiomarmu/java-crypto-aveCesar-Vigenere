/*
 * ENCRYPTION CLASS OF THE PROGRAM 
 * @author sergio
 */

/*
 * PACKAGE
 */
package cryptography;

/*
 * IMPORTS
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Encryption {
    
    /*
     * CLASS VARIABLES 
     */
    
    String text;
    int type;
    int key;
    String keyEncryption;
    boolean mode = true;
    
    /* 
     * VARIABLES 
     */
    
    char[] abc = {'a','b','c','d','e','f','g',
                  'h','i','j','k','l','m','n',
                  'o','p','q','r','s','t','u',
                  'v','w','x','y','z'};
    char[][] vngTableUp = new char[26][26];
    char[][] vngTableLeft =  new char[26][26];
    char[][] vngTableUpPro = new char[26][26];
    char[][] vngTableLeftPro =  new char[26][26];
    char[] codeChar,cLine,keyUser,keyCrypt,abcPro = new char[26];
    char c;
    int x,y,z,m,n;
    String strDeCrypt,str;
    Boolean typeChar;    
    Random rnd;
    
    /* 
     * CONSRUCTORS 
     */
    
    public Encryption(){
    }
    
    public Encryption(String text){
        this.text=text;
        this.type=0;
    }
    
    public Encryption(String text, String keyEncryption){
        this.text=text;
        this.keyEncryption=keyEncryption;
    }
    
    public Encryption(String text,int key){
        this.text=text;
        this.type=0;
        this.key=key;
    } 
    
    public Encryption(String text,int key, boolean mode){
        this.text=text;
        this.type=0;
        this.key=key;
        this.mode=false;
    }  
    
    public Encryption(String text, int type, int key) {
        this.text = text;
        this.type = type;
        this.key=key;
    }
    
    /* 
     * GETTERS AND SETTERS 
     */
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public boolean isMode() {
        return mode;
    }

    public void setMode(boolean mode) {
        this.mode = mode;
    }

    public String getKeyEncryption() {
        return keyEncryption;
    }

    public void setKeyEncryption(String keyEncryption) {
        this.keyEncryption = keyEncryption;
    }
    
    /*
     * METHODS 
     */
    
    // ***AVE CESAR***
    // MAIN METHOD
    public void mainCesar(){
        int n = getType();
        if(n ==0)encryptingAveCesar();
        else if (n ==1) decryptingAveCesar();
    }
    // ENCRYPT THE STRING
    public void encryptingAveCesar(){
        str = getText();
        strDeCrypt ="";
        int key = getKey();
        int type = getType();
        codeChar = str.toCharArray(); 
        
         if(!isMode()){     
            // RIGHT SIDE
            for( char m: codeChar){
                 x =0;
                 if(m == ' ') strDeCrypt+= " ";
                 for(char n:abc){
                   if(Character.toLowerCase(m) == Character.toLowerCase(n)){
                     typeChar = m == Character.toUpperCase(m);
                     if((x+key)<26) strDeCrypt+= typeChar ? Character.toUpperCase(abc[x+key]) : Character.toLowerCase(abc[x+key]);
                     else {
                         y = -26+(x+key);
                         strDeCrypt+=  typeChar ? Character.toUpperCase(abc[y]) : Character.toLowerCase(abc[y]);
                     }
                   }
                   x++;
                }                    
             } 
        } else if(isMode()){
            // LEFT SIDE
            for( char m: codeChar){
                 x =0;
                 if(m == ' ') strDeCrypt+= " ";
                 for(char n:abc){
                   if(Character.toLowerCase(m) == Character.toLowerCase(n)){
                      typeChar = m == Character.toUpperCase(m);
                     if((x-key)<26){
                         if((x-key)<0) strDeCrypt+= typeChar ? Character.toUpperCase(abc[26+(x-key)]) : Character.toLowerCase(abc[26+(x-key)]);
                         else  strDeCrypt+=  typeChar ? Character.toUpperCase(abc[x-key]) : Character.toLowerCase(abc[x-key]);
                     }
                   }
                   x++;
                }    
             }
        }
        
       System.out.println(strDeCrypt);
    }
    // DECRYPT THE STRING
    public void decryptingAveCesar(){
        str = getText();
        strDeCrypt ="";
        int key = getKey();
        int type = getType();
        codeChar = str.toCharArray(); 
        
         if(isMode()){     
            // RIGHT SIDE
            for( char m: codeChar){
                 x =0;
                 if(m == ' ') strDeCrypt+= " ";
                 for(char n:abc){
                   if(Character.toLowerCase(m) == Character.toLowerCase(n)){
                     typeChar = m == Character.toUpperCase(m);
                     if((x+key)<26) strDeCrypt+= typeChar ? Character.toUpperCase(abc[x+key]) : Character.toLowerCase(abc[x+key]);
                     else {
                         y = -26+(x+key);
                         strDeCrypt+=  typeChar ? Character.toUpperCase(abc[y]) : Character.toLowerCase(abc[y]);
                     }
                   }
                   x++;
                }                    
             } 
        } else if(!isMode()){
            // LEFT SIDE
            for( char m: codeChar){
                 x =0;
                 if(m == ' ') strDeCrypt+= " ";
                 for(char n:abc){
                   if(Character.toLowerCase(m) == Character.toLowerCase(n)){
                      typeChar = m == Character.toUpperCase(m);
                     if((x-key)<26){
                         if((x-key)<0) strDeCrypt+= typeChar ? Character.toUpperCase(abc[26+(x-key)]) : Character.toLowerCase(abc[26+(x-key)]);
                         else  strDeCrypt+=  typeChar ? Character.toUpperCase(abc[x-key]) : Character.toLowerCase(abc[x-key]);
                     }
                   }
                   x++;
                }    
             }
        }
        
        System.out.println(strDeCrypt);
    }
    
    // ***VINEGÈRE***
    public void mainVinegere(){
        
    }
    // ENCRYPT THE STRING
    public void encryptingVinegere(){
        createTableVinegere();
        strDeCrypt = "";
        str = getText();
        keyUser = getKeyEncryption().toCharArray();
        codeChar = str.toCharArray();
        keyCrypt = new char[codeChar.length];
        
        y=0;
        for(x=0;x<keyCrypt.length;x++){
            if(x == 6)y=0;
            keyCrypt[x]=keyUser[y]; 
            y++;
        }
    
        for(x=0;x<codeChar.length;x++){
            m=0;z=0;c=' ';
            for(y=0;y<26;y++){
                if(Character.toLowerCase(codeChar[x]) == Character.toLowerCase(abc[y])){
                    z=y;
                    break;
                }         
            } 
            cLine=vngTableUp[z];
            for(y=0;y<26;y++){
                if(Character.toLowerCase(keyCrypt[x]) == Character.toLowerCase(abc[y])){
                    m=y;
                    break;
                }         
            } 
            strDeCrypt+=vngTableUp[z][m];
            System.out.println(vngTableUp[z][m]);
        }
        
        System.out.println(strDeCrypt);
    }
    // DECRYPT THE STRING
    public void decryptingVinegere(){
        createTableVinegere();
        str = getText();
        strDeCrypt ="";
        keyUser = getKeyEncryption().toCharArray();
        codeChar = str.toCharArray();       
        char[] keyCrypt = new char[codeChar.length];
        
        y=0;
        for(x=0;x<keyCrypt.length;x++){
            if(x == 6)y=0;
            keyCrypt[x]=keyUser[y]; 
            y++;
        }
    
        for(x=0;x<keyCrypt.length;x++){
            m=0;z=0;c=' ';
            for(y=0;y<26;y++){
                if(Character.toLowerCase(keyCrypt[x]) == Character.toLowerCase(abc[y])){
                    z=y;
                    break;
                }         
            } 
            cLine=vngTableUp[z];
            for(n=0;n<codeChar.length;n++){
                for(y=0;y<26;y++){
                    if(Character.toLowerCase(codeChar[x]) == Character.toLowerCase(cLine[y])){
                        m=y;
                        break;
                    }         
                } 
            }
            strDeCrypt+=abc[m];
        }
        
        System.out.println(strDeCrypt);
        
    }
    // CREATE TABLE
    public void createTableVinegere(){
        int x,y,z;
        for(x=0;x<26;x++){
            for(y=0;y<26;y++){
                if((x+y) < 26){
                   vngTableUp[x][y] = abc[y+x];                 
                }else{
                    for(z=0;z<((x+y)-25);z++){
                       vngTableUp[x][y] = abc[z];
                    }
                   
                }
            }
        }
        vngTableLeft = vngTableUp;
    }
    
    // ***VINEGÈRE PRO***
    // ENCRYPT THE STRING
    public void encryptingVinegerePro(){
        strDeCrypt = "";
        str = getText();
        keyUser = getKeyEncryption().toCharArray();
        codeChar = str.toCharArray();
        keyCrypt = new char[codeChar.length];
        
        y=0;
        for(x=0;x<keyCrypt.length;x++){
            if(x == 6)y=0;
            keyCrypt[x]=keyUser[y]; 
            y++;
        }
    
        for(x=0;x<codeChar.length;x++){
            m=0;z=0;c=' ';
            for(y=0;y<26;y++){
                if(Character.toLowerCase(codeChar[x]) == Character.toLowerCase(abcPro[y])){
                    z=y;
                    break;
                }         
            } 
            cLine=vngTableUpPro[z];
            for(y=0;y<26;y++){
                if(Character.toLowerCase(keyCrypt[x]) == Character.toLowerCase(abcPro[y])){
                    m=y;
                    break;
                }         
            } 
            strDeCrypt+=vngTableUpPro[z][m];
            System.out.println(vngTableUpPro[z][m]);
        }
        
        System.out.println(strDeCrypt);
    }
    // DECRYPT THE STRING
    public void decryptingVinegerePro(){
          str = getText();
        strDeCrypt ="";
        keyUser = getKeyEncryption().toCharArray();
        codeChar = str.toCharArray();       
        char[] keyCrypt = new char[codeChar.length];
        
        y=0;
        for(x=0;x<keyCrypt.length;x++){
            if(x == 6)y=0;
            keyCrypt[x]=keyUser[y]; 
            y++;
        }
    
        for(x=0;x<keyCrypt.length;x++){
            m=0;z=0;c=' ';
            for(y=0;y<26;y++){
                if(Character.toLowerCase(keyCrypt[x]) == Character.toLowerCase(abcPro[y])){
                    z=y;
                    break;
                }         
            } 
            cLine=vngTableUpPro[z];
            for(n=0;n<codeChar.length;n++){
                for(y=0;y<26;y++){
                    if(Character.toLowerCase(codeChar[x]) == Character.toLowerCase(cLine[y])){
                        m=y;
                        break;
                    }         
                } 
            }
            strDeCrypt+=abcPro[m];
        }
        
        System.out.println(strDeCrypt);
        
    }
    // CREATE TABLE
    public void createTableVinegerePro(){
        int x,y,z;
        
        ArrayList<Character> sequence = new ArrayList<>();
        for (char c = 'A' ; c <= 'Z' ; c++) sequence.add(Character.toLowerCase(c));
        Collections.shuffle(sequence);
        x=0;
        for(char c:sequence){
            abcPro[x] = c;
            x++;
        }

        for(x=0;x<26;x++){
            for(y=0;y<26;y++){
                if((x+y) < 26){
                   vngTableUpPro[x][y] = abc[y+x];                 
                }else{
                    for(z=0;z<((x+y)-25);z++){
                       vngTableUpPro[x][y] = abc[z];
                    }
                   
                }
            }
        }
        vngTableLeftPro = vngTableUpPro;
        
        /*for(x=0;x<vngTableLeftPro.length;x++){
            for(y=0;y<vngTableLeftPro[x].length;y++){
                System.out.print(vngTableLeftPro[x][y]);
            }
            System.out.println("\n");
        }  */   
                    
    }
 
    /* 
     * TO STRING  
     */
    
    // CESAR
    public String toStringAveCesar() {
        return "AveCesar { " + "text = " + text + " type = " + type + " }";
    }
    // VINEGERE
    public String toVinegere(){
        return "Vinegere { " + "text = " + text + " type = " + type + " }";
    }
}
