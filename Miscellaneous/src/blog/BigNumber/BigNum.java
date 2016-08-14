package blog.BigNumber;

public class BigNum {

	// Sign if set to true means a POSITIVE number, if set to false means a NEGATIVE number.
	private boolean sign= true;
	// Stores the magnitude as string
	private String magnitude;
	// Stores chunks of magnitude in the array
	private long[] bigArray;
	// Stores the chunkSize by which to divide magnitude into chunks
	private static int chunkSize;

	// Calculate the chunkSize beforehand and use it in the constructor
	static{
		chunkSize=String.valueOf(Long.MAX_VALUE).length()-2;
	}


	//Constructor for storing the big number
	public BigNum(String s){

		// For assigning sign and magnitude to private attributes of the data structure
		if(s.charAt(0)=='-'){
			sign=!sign;
			this.magnitude=s.substring(1);
		}else
			this.magnitude=s;


		/* If length is a multiple of chunkSize, assign number of chunks = total length of bignum / chunksize
		*/
		if(this.magnitude.length()%chunkSize==0){
			bigArray= new long[this.magnitude.length()/chunkSize];
			int arrayCount=bigArray.length-1;
			for(int i=this.magnitude.length();i>=chunkSize;i-=chunkSize)
				bigArray[arrayCount--]=Long.parseLong(this.magnitude.substring(i-chunkSize,i));
		}


		/* If length is NOT a multiple of chunkSize, assign number of chunks = total length of bignum / chunksize  + 1
		   Should also check lower bounds and upper bounds in this case to avoid ArrayOutofIndex or StringOutOfIndex Exception
		*/
		else{
			bigArray= new long[(this.magnitude.length()/chunkSize)+1];
			int arrayCount=bigArray.length-1;
			for(int i=this.magnitude.length();i>=0;i-=chunkSize){

				if(i>=chunkSize)
					bigArray[arrayCount--]=Long.parseLong(this.magnitude.substring(i-chunkSize,i));

				// For the first leftover chunk of magnitude, if size is lesser than chunkSize, then take it as it is.
				else
					bigArray[arrayCount--]=Long.parseLong(this.magnitude.substring(0,i));

			}
		}

	}






	// To carry out addition irrespective of signs, a HELPER method
	private BigNum addition(BigNum b){
		BigNum result;
		BigNum smaller;

		// Setup
		if(this.magnitude.length()>=b.magnitude.length()){
			result = new BigNum(this.magnitude);
			smaller = new BigNum(b.magnitude);
			result.sign=this.sign;
			smaller.sign=b.sign;
		}else{
			result = new BigNum(b.magnitude);
			smaller = new BigNum(this.magnitude);
			result.sign=b.sign;
			smaller.sign=this.sign;
		}

		// Perform addition now
		long carry=0L; int j=smaller.bigArray.length-1;int i;
		for(i=result.bigArray.length-1;i>=0;i--){
			if(j>=0){
				result.bigArray[i]+=(smaller.bigArray[j]+carry);
				carry=0;
			}

			else
				break;

			j--;
			if(String.valueOf(result.bigArray[i]).length()>chunkSize){
				carry=Long.parseLong(String.valueOf(result.bigArray[i]).substring(0, String.valueOf(result.bigArray[i]).length()-chunkSize));
				//System.out.println("carry: "+carry);
				result.bigArray[i]%=(long)(Math.pow(10,chunkSize));
			}

		}
		if(carry!=0){
			System.out.println("i: "+i);
			result.bigArray[i]+=carry;
		}


		result.magnitude=result.toString().charAt(0)=='-'?result.toString().substring(1):result.toString();
		return result;
	}



	// To carry out subtraction irrespective of signs, a HELPER method
		private BigNum subtraction(BigNum b){
			BigNum result;
			BigNum smaller;

			//Setup
			if(this.magnitude.length()>=b.magnitude.length()){
				result = new BigNum(this.magnitude);
				smaller = new BigNum(b.magnitude);
				result.sign=this.sign;
				smaller.sign=b.sign;
			}else{
				result = new BigNum(b.magnitude);
				smaller = new BigNum(this.magnitude);
				result.sign=b.sign;
				smaller.sign=this.sign;
			}

			int j=smaller.bigArray.length-1;int i;
			for(i=result.bigArray.length-1;i>=0;i--){
				if(j>=0){
					result.bigArray[i]-=smaller.bigArray[j];
					//System.out.println(result.bigArray[i]);
					if(i==1 && j==1){
						result.bigArray[i-1]-=smaller.bigArray[j-1];
						break;
					}

					if(result.bigArray[i]<0){
						//System.out.println("negative");
						result.bigArray[i-1]--;
						result.bigArray[i]+=(long)(Math.pow(10, chunkSize));
					}

				}else
					break;
				j--;
			}

			while(result.bigArray[i]<0 && i>0){
				//System.out.println("decrementing ");
				result.bigArray[i-1]--;
				result.bigArray[i]+=(long)(Math.pow(10, chunkSize));
				i--;
			}
			//result.magnitude=result.toString().charAt(0)=='-'?result.toString().substring(1):result.toString();
			return result;

		}



	// To get the array index for leading zeroes in the given number, a HELPER method
	private int getFirstSigDigArrayIndex(){
		int i;
		for(i=0;i<this.bigArray.length;i++){
			if(this.bigArray[i]!=0)
				break;
		}
		return i;
	}


	// Overridden toString() method
	public String toString(){
		StringBuilder sb= new StringBuilder(this.sign ? "" : "-");	int i;
		int sigArrayIndex=this.getFirstSigDigArrayIndex();

		for(i=sigArrayIndex;i<this.bigArray.length;i++)	{

			if(i>sigArrayIndex && String.valueOf(this.bigArray[i]).length()<chunkSize){
				int lessZeroes=chunkSize-String.valueOf(this.bigArray[i]).length();
				while(lessZeroes>0){
					sb.append("0");
					lessZeroes--;
				}
			}
			sb.append(this.bigArray[i]);
		}
		return sb.toString();

	}


	// Addition method provided to user
	public BigNum add(BigNum b){
		if(this.sign!=b.sign)
			return this.subtraction(b);
		else
			return this.addition(b);
	}

	// Subtraction method provided to user
	public BigNum subtract(BigNum b){
		b.sign=!b.sign;
		return this.add(b);
	}



}
