import java.util.Scanner;
import java.util.Arrays;
public class colomnr {
    public String encription(String pass_message,String passkey){
        int z1=0;
        String encriptedmessage = "";
        String sortedmessage="";
        int len = pass_message.length()/passkey.length();
        int len1 = pass_message.length()/passkey.length()+1;
        int a1 = pass_message.length()%passkey.length();

        char[] array = passkey.toCharArray();
        Arrays.sort(array);
        sortedmessage = new String(array);

        if(a1==0){
            char[][] matrix = new char[len][passkey.length()];
        for(int i=0;i<len;i++){
            for(int j=0;j<passkey.length();j++){
                matrix[i][j] = '-';
            }
        }
        for(int i=0;i<len;i++){
            for(int j=0;j<passkey.length();j++){
                if(z1<pass_message.length()){
                matrix[i][j] =pass_message.charAt(z1);
                z1=z1+1;
                }
            }
        }
        
        for(int z3=0;z3<passkey.length();z3++){
            int z2 = passkey.indexOf(sortedmessage.charAt(z3));
            for(int z4=0;z4<len;z4++){
                encriptedmessage+=matrix[z4][z2];
            }
        }
    }

    if(a1!=0){
        char[][] matrix = new char[len1][passkey.length()];
        for(int i=0;i<len1;i++){
            for(int j=0;j<passkey.length();j++){
                matrix[i][j] = '-';
            }
        }
        for(int i=0;i<len1;i++){
            for(int j=0;j<passkey.length();j++){
                if(z1<pass_message.length()){
                matrix[i][j] =pass_message.charAt(z1);
                z1=z1+1;
                }
            }
        }
        for(int z3=0;z3<passkey.length();z3++){
            int z2 = passkey.indexOf(sortedmessage.charAt(z3));
            for(int z4=0;z4<len1;z4++){
                encriptedmessage+=matrix[z4][z2];
            }
        }
    }
        return encriptedmessage;
    }
    
    public String decription(String encriptedmessage, String passkey) {
        int rows = encriptedmessage.length() / passkey.length();
        int cols = passkey.length();
        char[][] matrix = new char[rows][cols];
    
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = '-';
            }
        }
    
        String sortedPasskey = new String(passkey.toCharArray());
        char[] sortedPasskeyArray = sortedPasskey.toCharArray();
        Arrays.sort(sortedPasskeyArray);
        sortedPasskey = new String(sortedPasskeyArray);
    
        int messageIndex = 0;
        for (int z3 = 0; z3 < sortedPasskey.length(); z3++) {
            int z2 = passkey.indexOf(sortedPasskey.charAt(z3));
            for (int z4 = 0; z4 < rows; z4++) {
                matrix[z4][z2] = encriptedmessage.charAt(messageIndex);
                messageIndex++;
            }
        }
    
        String decryptedMessage = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] != '-') {
                    decryptedMessage += matrix[i][j];
                }
            }
        }
    
        return decryptedMessage;
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("ENTER THE MESSAGE TO ENCRIPT : ");
        String message = scan.nextLine();
        System.out.println("");
        System.out.print("ENTER THE KEY : ");
        String key = scan.nextLine();
        colomnr cr = new colomnr();
        String encripted_message=cr.encription(message, key);
        System.out.println("ENCRIPTED MESSAGE : "+encripted_message);
        String decrypted_message = cr.decription(encripted_message,key);
        System.out.println("Decrypted Message: " + decrypted_message);
        scan.close();
    }
}
