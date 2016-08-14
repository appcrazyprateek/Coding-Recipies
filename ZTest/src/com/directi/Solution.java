package com.directi;

import java.util.PriorityQueue;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static class Pair implements Comparable<Pair> {
		int time;
		boolean isArrivalTime;

		public Pair(int time, boolean isArrivalTime) {
			super();
			this.time = time;
			this.isArrivalTime = isArrivalTime;
		}

		public int getTime() {
			return time;
		}

		public void setTime(int time) {
			this.time = time;
		}

		public boolean isArrivalTime() {
			return isArrivalTime;
		}

		public void setArrivalTime(boolean isArrivalTime) {
			this.isArrivalTime = isArrivalTime;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return new Integer(this.getTime()).compareTo(o.getTime());
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			PriorityQueue<Pair> times = new PriorityQueue<Pair>();
			for (int j = 0; j < n; j++) {
				times.add(new Pair(sc.nextInt(), true));
				times.add(new Pair(sc.nextInt(), false));
			}
			System.out.println(getMaxPeople(times));
		}
	}

	private static int getMaxPeople(PriorityQueue<Pair> times) {
		// TODO Auto-generated method stub
		int max = Integer.MIN_VALUE;
		int count = 0;
		while (!times.isEmpty()) {
			Pair p = times.poll();
			if (p.isArrivalTime())
				count++;
			else
				count--;
			if (count > max)
				max = count;
		}
		return max;
	}

}