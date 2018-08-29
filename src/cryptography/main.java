/*
 * MAIN CLASS OF THE PROGRAM
 * @author sergio
 */

/*
 * PACKAGES
 */
package cryptography;

/*
 * IMPORTS
 */
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class main {
    
    /**
     * MAIN PROGRAM 
     */
    public static void main(String [ ] args){
        
        /*
         * VARIABLES
         */
        String trash,code,key;
        int method,opt,pos;
        boolean menu = true,direction = false;
             
        try{
            Encryption crypt = new Encryption();
            crypt.createTableVinegerePro();
            Scanner scan = new Scanner(System.in); 
            System.out.print("--------------\n"
                    +"- Encryption -\n"
                    +"--------------\nHi!");
 
            do{
               
                System.out.println("\nMethod:\n1|Cesar\n2|Vinegère\n3|VinegèrePro\n0|Exit");
                method = scan.nextInt();
                if(method == 0) break;
                System.out.println("Ok\n1|Encrypt\n2|Decrypt");
                opt=scan.nextInt();
                System.out.println("Ok");
                
                switch(method){
                    case 1:
                        System.out.println("code:");
                        trash = scan.nextLine();
                        code = scan.nextLine();                     
                        System.out.println(code);
                        System.out.println("pos:");
                        pos = scan.nextInt();
                        System.out.println(pos);  
                        crypt.setText(code);
                        crypt.setType(0);
                        crypt.setKey(pos);
                        System.out.println("l?|0--r?|1");
                        pos = scan.nextInt();
                        if(pos==0) direction = true; else if(pos==1) direction=false;
                        crypt.setMode(direction);
                        if(opt==1)crypt.encryptingAveCesar();
                            else if(opt==2) crypt.decryptingAveCesar();
                        break;
                    case 2:
                        crypt.createTableVinegere();
                        System.out.println("code:");
                        trash = scan.nextLine();
                        code = scan.nextLine(); 
                        crypt.setText(code);
                        System.out.println("key:");
                        key = scan.nextLine();
                        crypt.setKeyEncryption(key);
                        if(opt==1)crypt.encryptingVinegere();
                            else if(opt==2) crypt.decryptingVinegere();
                        break;
                    case 3:
                        System.out.println("code:");
                        trash = scan.nextLine();
                        code = scan.nextLine(); 
                        crypt.setText(code);
                        System.out.println("key:");
                        key = scan.nextLine();
                        crypt.setKeyEncryption(key);
                        if(opt==1)crypt.encryptingVinegerePro();
                            else if(opt==2) crypt.decryptingVinegerePro();
                        break;
                    case 0:
                        menu = false;
                        System.out.println("Bye bye!!!");
                }
            }while(menu);

        }catch(InputMismatchException e){ System.out.println(e.getMessage()); }
         catch(NoSuchElementException | IllegalStateException e){System.out.println(e.getMessage());}
         catch(Exception e){System.out.println("An error has occurred during the execution");}
 
    }

}
