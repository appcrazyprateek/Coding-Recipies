package blog.dp.lcs;


/**
 *
 * @author sameernilupul
 */
public class OptimisedLCS{
    public static void main(String[] args) {
        String s1 = "Human";
        String s2 = "Chimpanzee";
        //hman , 4
        
        String t1 = "ACCGGTCGAGTGCGCGGAAGCCGGCCGAA";
        String t2 = "GTCGTTCGGAATGCCGTTGCTCTGTAAA";
        //gtcgtcggaagccggccgaa , 20
        
        String t3 = "MZJAWXU";
        String t4 = "xmjyauz";
        //mjau , 4
        
        String t5 = "AAAAAk";
        String t6 = "AAAAAAk";
        //aaaaak , 6
        
        System.out.println(LCS(s1,s2));
        System.out.println(LCS(t1,t2));
        System.out.println(LCS(t3,t4));
        System.out.println(LCS(t5,t6));
        
        System.out.println(LCS_Length(s1,s2));
        System.out.println(LCS_Length(t1,t2));
        System.out.println(LCS_Length(t3,t4));
        System.out.println(LCS_Length(t5,t6));
    }
    
    public static String LCS(String A,String B){ // Build the full array return a LCS
        char[] a = A.toLowerCase().toCharArray(); // m
        char[] b = B.toLowerCase().toCharArray(); // n
        
        int m = A.length();
        int n = B.length();
        
        int[][] temp = new int[m+1][n+1];
        String lcs ="";
        
        for(int i =1;i<=m;i++){    // i ->>> // choose i,j don't know what is speed yet.
            for(int j=1;j<=n;j++){
                
               if(a[i-1] == b[j-1]){
                   temp[i][j] = temp[i-1][j-1]+1;
               }else{
                   temp[i][j] = Math.max(temp[i-1][j], temp[i][j-1]);
               } 
            }
        }
        /*Back tracking part goes here*/
        
        int i=m;
        int j=n;
        while(true){
           // System.out.println("i="+i+" j="+j);
            if(i ==0 || j==0){
                break;
            }
            
            if(a[i-1] == b[j-1]){
                lcs += Character.toString(a[i-1]);
                i--;
                j--;
            }else{
                if(temp[i][j-1]> temp[i-1][j]){
                    j--;
                }else{
                    i--;
                }
            }
            
        }
        
        //System.out.println("Length of LCS = "+ temp[m][n]);
        return new StringBuffer(lcs).reverse().toString();
    }
    
    
    
     public static int LCS_Length(String A,String B){ // Optimized version for memory 
         
         
        char[] a = A.toLowerCase().toCharArray(); // m
        char[] b = B.toLowerCase().toCharArray(); // n
        
        int m = A.length();
        int n = B.length();
        
        int[][] temp = new int[3][n+1];
        int I =0;
        
        for(int i =1;i<=m;i++){    // i ->>> // choose i,j don't know what is speed yet.
            for(int j=1;j<=n;j++){
                
               if(a[i-1] == b[j-1]){
                   temp[i%3][j] = temp[(i-1)%3][j-1]+1;
               }else{
                   temp[i%3][j] = Math.max(temp[(i-1)%3][j], temp[i%3][j-1]);
               } 
            }
            I=i;
        }
        return temp[I%3][n];
    }
    
}