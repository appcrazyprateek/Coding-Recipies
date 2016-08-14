package com.microsoft;

public class Buildingbridge {

	static int BuildingBridges(int[] array1, int[] array2) {

		int othpos[] = new int[array1.length];
		for (int i = 0; i < array2.length; i++) // find the occurence of oth[]
												// element in cr[]
		{
			int pos = 0;
			boolean flag = false;
			for (int j = 0; j < array1.length && flag == false; j++) {
				if (array2[i] == array1[j]) {
					othpos[i] = j;
					flag = true;
				} else
					pos++;
			}
		}
		// for(int i=0;i<cr.length;i++) System.out.println(othpos[i]+1);
		int pos[] = new int[array1.length];
		int brlength = 0;
		for (int i = 1; i < othpos.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (othpos[i] >= othpos[j] && pos[j] + 1 > pos[i]) {
					pos[i] = pos[j] + 1;
					brlength = pos[i] + 1;
					// System.out.println(pos[i]+" "+i+" "+o);
				}
			}
		}
		return brlength;
    }
	
	public static void main(String ar[]) {

		int cr[] = { 8, 1, 4, 3, 5, 2, 6, 7 };
		int oth[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		
	}

}


