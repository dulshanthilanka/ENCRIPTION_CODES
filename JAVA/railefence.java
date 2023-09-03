import java.util.Scanner;
public class railefence {
    public String encript(String message, int rails) {
        char[][] matrix = new char[rails][message.length()];
        int row = 0;
        int col = 0;
        boolean down = false;
    
        for (int i = 0; i < message.length(); i++) {
            if (row == 0 || row == rails - 1) {
                down = !down;
            }
            matrix[row][col] = message.charAt(i);
            col++;
            if (down) {
                row++;
            } else {
                row--;
            }
        }

        for(int i=0;i<rails;i++){
            for(int j=0;j<message.length();j++){
                System.out.print(" "+matrix[i][j]);
            }
            System.out.println("");
        }
    
        String encryptedMessage = "";
        for (int i = 0; i < rails; i++) {
            for (int j = 0; j < message.length(); j++) {
                if (matrix[i][j] != '\u0000') {
                    encryptedMessage += matrix[i][j];
                }
            }
        }
        return encryptedMessage;
    }


    public String decrypt(String encryptedMessage, int rails) {
        char[][] matrix = new char[rails][encryptedMessage.length()];
        int row = 0;
        int col = 0;
        boolean down = false;

        for (int i = 0; i < rails; i++) {
            for (int j = 0; j < encryptedMessage.length(); j++) {
                matrix[i][j] = '\u0000';
            }
        }
        for (int i = 0; i < encryptedMessage.length(); i++) {
            if (row == 0 || row == rails - 1) {
                down = !down;
            }
            matrix[row][col] = '*';
            col++;
            if (down) {
                row++;
            } else {
                row--;
            }
        }

        int index = 0;
        for (int i = 0; i < rails; i++) {
            for (int j = 0; j < encryptedMessage.length(); j++) {
                if (matrix[i][j] == '*') {
                    matrix[i][j] = encryptedMessage.charAt(index);
                    index++;
                }
            }
        }
    
        StringBuilder decryptedMessage = new StringBuilder();
        row = 0;
        col = 0;
        down = false;
        for (int i = 0; i < encryptedMessage.length(); i++) {
            if (row == 0 || row == rails - 1) {
                down = !down;
            }
            decryptedMessage.append(matrix[row][col]);
            col++;
            if (down) {
                row++;
            } else {
                row--;
            }
        }
        return decryptedMessage.toString();
    }


    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("ENTER THE MESSAGE TO BE PRINTED : ");
        String message = scan.nextLine().toUpperCase();
        System.out.println("");
        System.out.print("PLEASE ENTER THE KEY : ");
        int key = scan.nextInt();
        scan.close();
        railefence rf = new railefence();
        String encripted_message = rf.encript(message, key);
        System.out.print("ENCRIPTED MESSAGE IS :"+encripted_message);
        System.out.println();
        String decripted_message = rf.decrypt(encripted_message, key);
        System.out.print("DECRIPTED MESSAGE IS :"+decripted_message);
    }
}
