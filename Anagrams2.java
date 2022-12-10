package test9122022;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Anagrams2 
{
   public static List<List<String>> getAnagramsList(List<String> list)
   {
	   List<List<String>> ret_l = new ArrayList<>();
	   if(list.size() <= 1)
	   {
		   ret_l.add(list);
		   return ret_l;
	   }
	   List<String> check = new ArrayList<>();
	   for(int i=0;i<list.size();i++)
	   {
		   List<String> l = new ArrayList<>();
		   String s = list.get(i);
		   char arr[] = s.toCharArray();
		   Arrays.sort(arr);
		   if(check.contains(String.valueOf(arr)))
		   {
			   continue;
		   }
		   else
		   {
			   check.add(String.valueOf(arr));
			   l.add(String.valueOf(arr));
			   for(int j=i+1;j<list.size();j++)
			   {
				   String str = list.get(j);
				   char a[] = str.toCharArray();
				   Arrays.sort(a);
				   if(String.valueOf(a).equals(String.valueOf(arr)))
				   {
					   l.add(list.get(j));
				   }
			   }
			   l.set(0,list.get(i));
			   ret_l.add(l);
		   }
	   }
	   return ret_l;
   }
   public static void main(String args[])
   {
	  Scanner sc = new Scanner(System.in);
	  System.out.println("Enter no of Strings");
	  int n = sc.nextInt();
	  System.out.println("Enter the strings");
	  List<String> list = new ArrayList<>();
	  while(n>0)
	  {
		list.add(sc.next());
		n--;
	  }
	  List<List<String>> anagrams = getAnagramsList(list);
	  System.out.println(anagrams);
	  sc.close();
   }
}
