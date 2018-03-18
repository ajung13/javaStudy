package baekjoon;

import java.util.Scanner;

public class RGBTown{
	private static class Town{
		private int n;
		private house[] houses;
		
		public Town(){
			Scanner scn = new Scanner(System.in);
			n = scn.nextInt();
			houses = new house[n];
			for(int i = 0; i < n; i++)
				houses[i] = new house(scn.nextInt(), scn.nextInt(), scn.nextInt());
			scn.close();
		}
		
		public void draw(){
			int[] red = new int[n+1];
			int[] green = new int[n+1];
			int[] blue = new int[n+1];
			
			red[1] = houses[0].redPrice;
			green[1] = houses[0].greenPrice;
			blue[1] = houses[0].bluePrice;
			
			for(int i = 2; i <= n; i++){
				red[i] = Math.min(green[i-1], blue[i-1]) + houses[i-1].redPrice;
				green[i] = Math.min(red[i-1], blue[i-1]) + houses[i-1].greenPrice;
				blue[i] = Math.min(red[i-1], green[i-1]) + houses[i-1].bluePrice;
			}
			
			System.out.print(Math.min(red[n], Math.min(green[n], blue[n])));
		}
	}
	private static class house{
		int redPrice, greenPrice, bluePrice;
		public house(int red, int green, int blue){
			this.redPrice = red;
			this.greenPrice = green;
			this.bluePrice = blue;
		}
	}
	public static void mainRGB(String[] args){
		Town myTown = new Town();
		myTown.draw();
	}
}