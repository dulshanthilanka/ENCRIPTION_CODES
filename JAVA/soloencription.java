import java.util.Scanner;
public class soloencription {
    String alphabet =       "abcdefghijklmnopqrstuvwxyz";
    String sypheralphebet = "nklsduvtazwxbgjiykmhecrqpo";
    String encriptedmessage="";
    String decriptedmessage="";
    //ENCRIPTION PART
    public String encript(String a){
        for(int i=0;i<a.length();i++)
        {
           for(int j=0;j<26;j++){
            if(a.charAt(i)==alphabet.charAt(j)){
                encriptedmessage = encriptedmessage + sypheralphebet.charAt(j);
            }
           }
        }
        return encriptedmessage;
    }
    //DECRIPTION PART
    public String decript(String b){
        for(int i=0;i<b.length();i++)
        {
           for(int j=0;j<26;j++){
            if(b.charAt(i)==sypheralphebet.charAt(j)){
                decriptedmessage = decriptedmessage + alphabet.charAt(j);
            }
           }
        }
        return decriptedmessage;
    }
    public static void main(String[] args){
        String message,lowercasemessage,decriptedmesg;
         Scanner scn = new Scanner(System.in);
         soloencription solo = new soloencription();
         System.out.print("PLEASE ENTER THE MESSAGE TO ENCRIPT : ");
         message = scn.nextLine();
        lowercasemessage = message.toLowerCase();
        decriptedmesg = solo.encript(lowercasemessage);
        System.out.println(decriptedmesg);
        System.out.println(solo.decript(decriptedmesg));
        scn.close();
    }
}