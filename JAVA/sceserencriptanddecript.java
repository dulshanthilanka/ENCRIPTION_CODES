import java.util.Scanner;

public class sceserencriptanddecript{

    public String encript(String a,int b){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String encriptedmessage="";
        int pos;
        char encriptingmsg[] = new char[a.length()];
        char encriptedmsg[] = new char[a.length()];
        for(int i=0;i<a.length();i++){
            encriptingmsg[i]=a.charAt(i);
        }
        for(int j=0;j<a.length();j++){
           pos = (alphabet.indexOf(encriptingmsg[j])+b)%26;
           encriptedmsg[j] = alphabet.charAt(pos);
        }

        for(int z=0;z<a.length();z++){
            encriptedmessage = encriptedmessage + encriptedmsg[z];
        }

    return encriptedmessage;
    }

     public String decript(String c,int d){
        String alphabet1 = "abcdefghijklmnopqrstuvwxyz";
        String decriptedmessage="";
        int pos1;
        char decriptingmsg[] = new char[c.length()];
        char decriptedmsg[] = new char[c.length()];
        for(int l=0;l<c.length();l++){
            decriptingmsg[l]=c.charAt(l);
        }
        for(int m=0;m<c.length();m++){
           pos1 = (alphabet1.indexOf(decriptingmsg[m])-d+26)%26;
           decriptedmsg[m] = alphabet1.charAt(pos1);
        }

        for(int p=0;p<c.length();p++){
            decriptedmessage = decriptedmessage + decriptedmsg[p];
        }
        return decriptedmessage;
    }
    public static void main(String[] args){
      String message,messagetodecript;
      int key;
      Scanner scn = new Scanner(System.in);
      System.out.print("ENTER THE MESSAGE THAT YOU WANT TO ENCRIPT : ");
      message = scn.nextLine().toLowerCase();
      System.out.print("ENTER THE KEY VALUE : ");
      key = scn.nextInt();
      sceserencriptanddecript cript = new sceserencriptanddecript();
      System.out.println(cript.encript(message, key));
      messagetodecript = cript.encript(message, key);
      System.out.println(cript.decript(messagetodecript,key));
      scn.close();
    }
}