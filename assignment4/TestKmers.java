//Sandeep (18MCA040)
import java.util.*;
import java.io.*;
import java.lang.*;
import com.opencsv.CSVWriter;
//to deal with csv there is no delegate library in java 
//a 3rd party apis are available for such requirements which OpenCSV

public class TestKmers{
	public static void main(String args[]) throws IOException{
		String dnaseq="";
		int k;
//INPUT		
		//reading input file dnaseq.dat
		FileReader fr=new FileReader("dnaseq.dat");
		//first line contain value of k
		k=fr.read()-48;
		//now reading all DNA seq in dnaseq string variable
		int i;
		while((i=fr.read())!= -1)
			dnaseq+=String.valueOf((char)i);
		//printing DNA seq and value of k
		System.out.println("The given DNA sequence is : \n"+dnaseq);
		System.out.println("Value of k to find k-mers:"+k);
		
//CALCULATION		
		//creating obj of CalKmers for creating all possible kmers
		CalKmers obj=new CalKmers(k);
		//to find all possible k-mers method findkmers
		//for value of k
		obj.findkmers("ATCG");
		//method to find occurences of all k-mers in DNA seq
		int occ[]=obj.findOccurences(dnaseq);

//PRINTING RESULTS
		//printing all kmers
		System.out.println("All possible k-mers with their occurences below it:");
		for(int j=0; j<Math.pow(4,k); j++){
			System.out.print(obj.kmers[j]+" ");
		}
		////printing their occurences
		System.out.println();
		for(int j=0; j<Math.pow(4,k); j++){
			System.out.print(occ[j]+" ");
		}
		String occur[]=new String[(int)Math.pow(4,k)];
		for(int j=0; j<Math.pow(4,k); j++){
			occur[j]=String.valueOf(occ[j]);
		}
//WRITING RESULT IN CSV FILE
		//writing this output in csv file Output.csv
		File file=new File("Output.csv");
		try{
			FileWriter outputfile=new FileWriter(file);
			CSVWriter writer=new CSVWriter(outputfile,',',CSVWriter.NO_QUOTE_CHARACTER,CSVWriter.DEFAULT_ESCAPE_CHARACTER,CSVWriter.DEFAULT_LINE_END);
			writer.writeNext(obj.kmers);
			writer.writeNext(occur);
			writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
class CalKmers{
	int k;
	String kmers[];
	CalKmers(int k){
		kmers=new String[(int)Math.pow(4,k)];
		for(int i=0; i<Math.pow(4,k); i++){
			kmers[i]="";
		}
		this.k=k;
	}
	
	//for creating kmers
	void findkmers(String seq){
		int m;
		for(int round=k; round>=1; round--){
			m=0;
			for(int l=1; l<=Math.pow(2,2*(k-round)); l++){
				for(int i=0; i<4; i++){
					for(int j=1; j<=Math.pow(2,(2*round-2)); j++){
						kmers[m]=kmers[m]+String.valueOf(seq.charAt(i));
						m++;
					}
				}
			}
		}
	}
	//to find occurences of k-mers in given DNA sequence
	int [] findOccurences(String dnaseq){
		int occurence[]=new int[(int)Math.pow(4,k)];
		for(int i=0; i<Math.pow(4,k); i++){
			int count=0;
			for(int j=0; j<=dnaseq.length()-k; j++){
				if(kmers[i].equals(dnaseq.substring(j,j+k))){
					count++;
				}
			}
			occurence[i]=count;
		}
		return occurence;
	}
	
}