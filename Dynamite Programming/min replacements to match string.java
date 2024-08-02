public class Nightcrawler{
	static String x = "welcome";
	static String s = "seltos";
	static int[][] dp = new int[x.length()+1][s.length()+1];
	
	public static void main(String[] args){
		int isItOver = dynamite();
		System.out.println(isItOver);
		// displayMatrix();
	}
	
	public static int dynamite(){
		for(int i=0; i<=x.length(); i++){	
			for(int j=0; j<=s.length(); j++){
				if(i==0){
					dp[i][j]=j;
				}else if(j==0){
					dp[i][j]=i;
				}else if(x.charAt(i-1)==s.charAt(j-1)){
					// if char are same: fetch the prev index dp[i-1][j-1]
					dp[i][j]=dp[i-1][j-1];
				}else{
					// if char are not same: fetch min(min(top, left), topLeft) and incr +1
					dp[i][j] = 1+ Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
				}
			}
		}
		return dp[x.length()][s.length()];
	}

  // Just ignore it mate, will ya!
	// public static void displayMatrix(){
	// 	System.out.println();
	// 	System.out.print("    ");
	// 	for(int i=0; i<s.length(); i++){
	// 		System.out.print(s.charAt(i)+" ");
	// 	}
	// 	System.out.println();
	// 	for(int i=0; i<dp.length; i++){
	// 		if(i==0){
	// 			System.out.print("  ");
	// 		}else{System.out.print(x.charAt(i-1)+" ");}
	// 		for(int j=0; j<dp[0].length; j++){
	// 			System.out.print(dp[i][j]+" ");
	// 		}
	// 		System.out.println();
	// 	}
	// }

}
