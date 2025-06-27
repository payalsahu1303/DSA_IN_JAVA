class LCS {
 static int lcs(String s1, String s2) {
        // code here
        int m = s1.length(), n = s2.length();
        int[][] t = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            t[i][0] = 0;
        }
        for(int j=1;j<=n;j++){
            t[0][j] =0;
        }
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    t[i][j] = 1+ t[i-1][j-1];
                } else {
                    t[i][j] = Math.max(t[i][j-1],t[i-1][j]);
                }
            }
        }
        return t[m][n];
    }
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String s1 = sc.nextLine();
    String s2 = sc.nextLine();
    System.out.println(lcs(s1,s2));
  }
}