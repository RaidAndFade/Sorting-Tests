package it.gocode.util;

import java.util.*;

public class Sort {

	public static void main(String[] args) {
		int numels = 1000000;
		int[] els = new int[numels];for(int i=0;i<numels;i++){els[i] = random(0,numels*10);}
		//int[] els={7,4,10,8,5,7,3};
		long started = System.nanoTime();
		ArrayList<Integer> newels = QuickSort(toList(els));
		System.out.println((System.nanoTime()-started)+"ns ~ Quick Sort");
		if(els.length<10000)System.out.println(newels);
		System.out.println();
		
		if(els.length<1000){
			started = System.nanoTime();
			newels = BubbleSort(toList(els));
			System.out.println((System.nanoTime()-started)+"ns ~ Bubble Sort");
			System.out.println(newels);
			System.out.println();
		}
		
		started = System.nanoTime();
		newels = MergeSort(toList(els));
		System.out.println((System.nanoTime()-started)+"ns ~ Merge Sort");
		if(els.length<10000)System.out.println(newels);
		System.out.println();
		
		started = System.nanoTime();
		newels = FastSort(toList(els));
		System.out.println((System.nanoTime()-started)+"ns ~ Fast Sort");
		if(els.length<10000)System.out.println(newels);
		System.out.println();
		
		started = System.nanoTime();
		Arrays.sort(els);
		System.out.println((System.nanoTime()-started)+"ns ~ System Sort");
		if(els.length<10000)System.out.println(toList(els));
		System.out.println();
	}
	public static ArrayList<Integer> QuickSort(List<Integer> els){
		ArrayList<Integer> newels = new ArrayList<Integer>();
		if(els.size()>1){
			int pivet = Math.random()>.5?els.get((int)(Math.random()*els.size())):els.get(0);
			List<Integer> less = new ArrayList<Integer>(),equal = new ArrayList<Integer>(),more = new ArrayList<Integer>();
			long started = System.nanoTime();
			for(int in=0;in<els.size();in++){
				int i=els.get(in);
				if(i<pivet){
					less.add(i);
				}else if(i==pivet){
					equal.add(i);
				}else{
					more.add(i);
				}
			}
			//System.out.print(" L:"+less);System.out.print(" E:"+equal);System.out.print(" P:"+pivet);System.out.print(" M:"+more);System.out.println(" T:"+(System.nanoTime()-started)+"ns");
			if(less.size()>1)
				newels.addAll(QuickSort(less));
			else
				newels.addAll(less);
			newels.addAll(equal);
			if(more.size()>1)
				newels.addAll(QuickSort(more));
			else
				newels.addAll(more);
		}else{
			return (ArrayList<Integer>) els;
		}
		return newels;
	}
	public static ArrayList<Integer> BubbleSort(List<Integer> els){
		int swaps = 0;
		ArrayList<Integer> newels = new ArrayList<Integer>();
		if(els.size()>1){
			for(int i=0;i<els.size()-1;i++){
				if(els.get(i+1)<els.get(i)){
					swaps++;
					int els2 = els.get(i+1);
					els.set(i+1, els.get(i));
					els.set(i, els2);
				}
			}
			if(swaps>1){
				return BubbleSort(els);
			}else{
				return (ArrayList<Integer>) els;
			}
		}else{
			return (ArrayList<Integer>) els;
		}
	}
	public static ArrayList<Integer> MergeSort(List<Integer> els){
		if(els.size()>1){
			ArrayList<Integer> els1 = new ArrayList<Integer>();
			ArrayList<Integer> els2 = new ArrayList<Integer>();
			int halfPoint = (int)(els.size()/2);
			int size = els.size();
			for(int i=0;i<size;i++){
				if(i<halfPoint){
					els1.add(els.get(0));els.remove(0);
				}else{
					els2.add(els.get(0));els.remove(0);
				}
			}
			if(els1.size()>1)
				els1 = MergeSort(els1);
			if(els2.size()>1)
				els2 = MergeSort(els2);
			size = els1.size()+els2.size();
			ArrayList<Integer> newels = new ArrayList<Integer>();
			for(int i=0;i<size;i++){
				if(els1.size()>0&&els2.size()>0){
					if(els1.get(0)<=els2.get(0)){
						newels.add(els1.get(0));els1.remove(0);
					}else{
						newels.add(els2.get(0));els2.remove(0);
					}
				}else{
					if(els1.size()>els2.size()){
						newels.add(els1.get(0));els1.remove(0);
					}else{
						newels.add(els2.get(0));els2.remove(0);
					}
				}
						
			}
			return newels;
		}else{
			return (ArrayList<Integer>) els;
		}
	}
	
	public static ArrayList<Integer> FastSort(ArrayList<Integer> els){
		if(els.size()>1){
			ArrayList<Integer> els1 = new ArrayList<Integer>();
			ArrayList<Integer> els2 = new ArrayList<Integer>();
			int halfPoint = (int)(els.size()/2);
			int size = els.size();
			for(int i=0;i<size;i++){
				if(i<halfPoint){
					els1.add(els.get(0));els.remove(0);
				}else{
					els2.add(els.get(0));els.remove(0);
				}
			}

			if(els1.size()>1)
				els1 = FastSort(els1);
			if(els2.size()>1)
				els2 = FastSort(els2);
			size = els1.size()+els2.size();
			ArrayList<Integer> newels = new ArrayList<Integer>();
			for(int i=0;i<size;i++){
				if(els1.size()>0&&els2.size()>0){
					if(els1.get(0)<=els2.get(0)){
						newels.add(els1.get(0));els1.remove(0);
					}else{
						newels.add(els2.get(0));els2.remove(0);
					}
				}else{
					if(els1.size()>els2.size()){
						newels.add(els1.get(0));els1.remove(0);
					}else{
						newels.add(els2.get(0));els2.remove(0);
					}
				}
						
			}
			return newels;
		}else{
			return (ArrayList<Integer>) els;
		}
	}
	
	public static ArrayList<Integer> toList(int[] ints){
		ArrayList<Integer> intList = new ArrayList<Integer>();
	    for (int index = 0; index < ints.length; index++)
	    {
	        intList.add(ints[index]);
	    }
	    return intList;
	}
	public static int random(int min, int max)
	{
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}
}
