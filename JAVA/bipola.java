import java.util.Scanner;
public class bipola {
    public String messagegenarator(String a,String b){
        String messagegenarate ="";
        int pos;
        char[] key = new char[a.length()];
        if(a.length()>b.length()){
               for(int i=0;i<a.length();i++){
                if(i>=b.length()){
                    pos = i % b.length();
                    key[i] = b.charAt(pos);
                    messagegenarate = messagegenarate + key[i];
                }else{
                    key[i]=b.charAt(i);
                    messagegenarate = messagegenarate + key[i];
                }
               }
        }else{
            for(int j=0;j<=a.length();j++){
            key[j]=b.charAt(j);
            messagegenarate = messagegenarate + key[j];
            }
        }
        return messagegenarate;
    }
// encription part
    public String encript(String c,String d){
        String encriptedmessage="";
        int p,k,z;
        for(int i=0;i<c.length();i++){
        p = c.charAt(i);
        k = d.charAt(i);
        z = (p+k)%26;
        z = z + 65;
        encriptedmessage = encriptedmessage + (char) (z);
        }
        return encriptedmessage;
    }
// decription part
    public String decript(String e,String f){
        String decriptedmessage="";
        int p,k,z;
        for(int i=0;i<e.length();i++){
			p = e.charAt(i);
			k = f.charAt(i);
			z = ((p-65-k+26)%26)+65;
			decriptedmessage = decriptedmessage + (char) (z);
		}
        return decriptedmessage;
    }
    public static void main(String[] args){
        String message,key;
        bipola bi = new bipola();
        Scanner scan = new Scanner(System.in);
        System.out.print("PLEASE ENTER THE MESSAGE THAT YOU WANT TO ENCRIPT : ");
        message = scan.nextLine();
        String message1 = message.toLowerCase();
        System.out.println("");
        System.out.print("PLEASE ENTER THE KEY STRING : ");
        key = scan.nextLine();
        String key1 = key.toLowerCase();
        String generatedkey = bi.messagegenarator(message1,key1);
        String encripteds = bi.encript(message1, generatedkey);
        System.out.println(encripteds);
        System.out.println(bi.decript(encripteds,generatedkey));
        scan.close();
    }
}