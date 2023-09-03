import java.util.*;
public class playfair{
//KEYMAKE
    String keymake(String k){
        String modifiedkey = "";
    for(int i=0; i<k.length(); i++){
        boolean isDuplicate = false;
        for(int j=i+1; j<k.length(); j++){
            if(k.charAt(i) == k.charAt(j)){
                isDuplicate = true;
                break;
            }
        }
        if(!isDuplicate){
            modifiedkey += k.charAt(i);
        }
    }
    return modifiedkey;
    }
//MAKE KEY MATRIX
    String keymatrix(String m){
        String alphabet = "ABCDEFGHJKLMNOPQRSTUVWXYZ";
    String modifiedalphabet = "";
    for(int i=0; i<alphabet.length(); i++){
        boolean state = false;
        for(int j=0; j<m.length(); j++){
            if(m.charAt(j)==(alphabet.charAt(i))){
                state = true;
                break;
            }
        }
        if(!state){
            modifiedalphabet += alphabet.charAt(i);
        }
    }
    return modifiedalphabet;
    }
//5 BY 5 ARRAY CREATION
    char[][] arrayindex(String a1,String a2){
        String newstring = a1+a2;
        int position = 0;
        char[][] matrix = new char[5][5];
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                matrix[i][j]=newstring.charAt(position);
                position++;
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        return matrix;
    }
// ENCRIPTION PART
    String encription(String a,char[][] b){
        String encripted_message="";
        String modified_message = "";
        String newmodifiedmessage = "";

        for(int i=0;i<a.length();i++){
            if(i==a.length()-1){
                modified_message += a.charAt(i);
            }
            else if(a.charAt(i)==a.charAt(i+1)){
                modified_message += a.charAt(i) + "X" + a.charAt(i+1) + "X";
                i++;
            }
            else{
                modified_message += a.charAt(i);
            }
        }
        if((a.length()%2)==1){
            modified_message +='X';
        }
        for(int j=0;j<modified_message.length();j++){
            if(j%2==1){
                newmodifiedmessage+=modified_message.charAt(j)+" ";
            }else{
                newmodifiedmessage+=modified_message.charAt(j);
            }
//ENCRIPTING THE MESSAGE
        }
        int[] array1 = new int[modified_message.length()];
        int[] array2 = new int[modified_message.length()];
        for(int i = 0; i < modified_message.length(); i++){
            for(int j = 0; j < 5; j++){
                for(int z1 = 0; z1 < 5; z1++){
                    if(modified_message.charAt(i) == b[j][z1]){
                        array1[i] = j;
                        array2[i] = z1;
                    }
                }
            }
        }
        int[] newarray1 = new int[modified_message.length()];
        int[] newarray2 = new int[modified_message.length()];
        for(int i = 0; i < modified_message.length() - 1;){
            if(array1[i] == array1[i+1]){
                newarray1[i] = array1[i];
                newarray2[i] = (array2[i] + 1) % 5;
                newarray1[i+1] = array1[i+1];
                newarray2[i+1] = (array2[i+1] + 1) % 5;
                i += 2;
            } else if(array2[i] == array2[i+1]){
                newarray1[i] = (array1[i] + 1) % 5;
                newarray2[i] = array2[i];
                newarray1[i+1] = (array1[i+1] + 1) % 5;
                newarray2[i+1] = array2[i+1];
                i += 2;
            } else {
                newarray1[i] = array1[i+1];
                newarray2[i] = array2[i];
                newarray1[i+1] = array1[i];
                newarray2[i+1] = array2[i+1];
                i += 2;
            }
        }
        for(int i = 0; i < modified_message.length(); i++){
            encripted_message += b[newarray1[i]][newarray2[i]];
        }
        return encripted_message;
    }
// DECRIPTION
public String decryption(String encryptedMessage, char[][] matrix) {
    String decryptedMessage = "";
    String modifiedMessage = encryptedMessage.replaceAll(" ", "");

    int[] array1 = new int[modifiedMessage.length()];
    int[] array2 = new int[modifiedMessage.length()];
    for (int i = 0; i < modifiedMessage.length(); i++) {
        for (int j = 0; j < 5; j++) {
            for (int z1 = 0; z1 < 5; z1++) {
                if (modifiedMessage.charAt(i) == matrix[j][z1]) {
                    array1[i] = j;
                    array2[i] = z1;
                }
            }
        }
    }

    int[] newarray1 = new int[modifiedMessage.length()];
    int[] newarray2 = new int[modifiedMessage.length()];
    for (int i = 0; i < modifiedMessage.length() - 1;) {
        if (array1[i] == array1[i + 1]) {
            newarray1[i] = array1[i];
            newarray2[i] = (array2[i] - 1 + 5) % 5;
            newarray1[i + 1] = array1[i + 1];
            newarray2[i + 1] = (array2[i + 1] - 1 + 5) % 5;
            i += 2;
        } else if (array2[i] == array2[i + 1]) {
            newarray1[i] = (array1[i] - 1 + 5) % 5;
            newarray2[i] = array2[i];
            newarray1[i + 1] = (array1[i + 1] - 1 + 5) % 5;
            newarray2[i + 1] = array2[i + 1];
            i += 2;
        } else {
            newarray1[i] = array1[i + 1];
            newarray2[i] = array2[i];
            newarray1[i + 1] = array1[i];
            newarray2[i + 1] = array2[i + 1];
            i += 2;
        }
    }

    for (int i = 0; i < modifiedMessage.length(); i++) {
        decryptedMessage += matrix[newarray1[i]][newarray2[i]];
    }
    return decryptedMessage;
}
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("ENTER THE KEY : ");
        String key = scan.nextLine().toUpperCase();
        playfair pf = new playfair();
        String modified_key=pf.keymake(key);
        System.out.println("");
        String modified_message = pf.keymatrix(modified_key);
        char[][] array_index = pf.arrayindex(modified_key, modified_message);
        System.out.print("ENTER THE MESSAGE : ");
        String message = scan.nextLine().toUpperCase();
        String modifiedmessage = pf.encription(message,array_index);
        System.out.print("MODIFIED MESSAGE IS :"+modifiedmessage);
        System.out.println();
        String demodifiedmessage = pf.decryption(modifiedmessage,array_index);
        System.out.print("DECRIPTED MESSAGE IS :"+demodifiedmessage);
        scan.close();
    }
}