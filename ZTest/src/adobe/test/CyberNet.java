package adobe.test;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class CyberNet {

    private static int res=1;
    private static int resInUse=0;
    static LinkedList<Character> waiting=new LinkedList<>();

    public static int getCustomer(int numComputers,String customers){
            res=numComputers;
            Set<Character> customer=new LinkedHashSet<>();

            for(char c:customers.toCharArray()){
                    if(customer.add(c)){
                            checkForFreeResource(c);
                    }
                    else
                            freeResource(c);

            }
            return waiting.size();
    }

    private static void freeResource(char c) {
            if(!waiting.contains(c))
                    resInUse--;
    }

    private static void checkForFreeResource(char c) {
            if(res==resInUse)
                    waiting.add(c);
            else
                    resInUse++;
    }

    public static void main(String[] args) {
            System.out.println(CyberNet.getCustomer(2,"ABCCDC"));
            int k=2;
            System.out.println(Math.round(5/(float)k));
    }
}

