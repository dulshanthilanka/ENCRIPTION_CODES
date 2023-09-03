public class otp {
//encription
    public String encript(String a,String b){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String encriptedmessage="";
        int p,k,x;
        for(int i=0;i<a.length();i++){
                p = alphabet.indexOf(a.charAt(i));
                k = alphabet.indexOf(b.charAt(i));
                x = (p+k)%26;
            encriptedmessage = encriptedmessage + alphabet.charAt(x);
        }
        return encriptedmessage;
    }
//decription
public String decript(String c,String d){
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    String decriptedmessage="";
    int t,l,x;

    for(int i=0;i<c.length();i++){
        t = alphabet.indexOf(c.charAt(i));
        l = alphabet.indexOf(d.charAt(i));
        if((t-l)<0){
            x = ((t-l)+26)%26;
            decriptedmessage = decriptedmessage + alphabet.charAt(x);
        }else{
            x = (t-l)%26;
            decriptedmessage = decriptedmessage + alphabet.charAt(x);
        }
    }
    return decriptedmessage;
}
    public static void main(String[] args){
        otp o = new otp();
        String message = "thiwanka";
        String syphermsg = "lfrkyios";
        String encriptedmsg = o.encript(message, syphermsg);
        System.out.print(" : "+encriptedmsg);
        System.out.println("");
        System.out.print(" : "+o.decript(encriptedmsg, syphermsg));

    }
}
