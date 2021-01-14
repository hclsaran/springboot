package com.saran;
import java.util.*;
import java.util.function.Predicate;
public class FilterOperations {
	public static void main(String[] args) {
     List<Apple>  list=Arrays.asList(new Apple(70,"red"),new Apple(110,"green"),new Apple(130,"blue"),new Apple(111,"blue"),new Apple(30,"red"));
     
     
     List<Apple> blueapples= filterApples(list,FilterOperations::isBlueApple);
     System.out.println(blueapples);
     List<Apple> greenapples= filterApples(list,FilterOperations::isGreenApple);
     System.out.println(greenapples);
     
     List<Apple>  heavyApples=filterApples(list,FilterOperations::isHeavyApple);
     System.out.println(heavyApples);
     
     List<Apple>  condnnotsatisfied=filterApples(list,(Apple a)-> a.getWeight() <30  || "yellow".equals(a.getColor()));
     System.out.println(condnnotsatisfied);
	}
	
	
	public static List<Apple>  filterGreenApples(List<Apple> inventory){
		List<Apple>  result=new ArrayList<>();
			for(Apple apple:inventory) {
				if("green".equals(apple.getColor())) {
					result.add(apple);
				}
			}
			return result;
	}
	
	public static  boolean isGreenApple(Apple apple) {
		return "green".equals(apple.getColor());
	}
	public static  boolean isBlueApple(Apple apple) {
		return "blue".equals(apple.getColor());
	}
	public static  boolean isRedApple(Apple apple) {
		return "red".equals(apple.getColor());
	}
	
	public static  boolean isHeavyApple(Apple apple) {
		return apple.getWeight() > 100;
	}
	public static List<Apple>  filterApples(List<Apple> inventory,Predicate<Apple> pre){
		List<Apple>  result=new ArrayList<>();
			for(Apple apple:inventory) {
				if(pre.test(apple)) {
					result.add(apple);
				}
			}
			return result;
	}

	public static class Apple {
		private int weight = 0;
		private String color = "";

		public Apple(int weight, String color) {
			super();
			this.weight = weight;
			this.color = color;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		@Override
		public String toString() {
			return "Apple [weight=" + weight + ", color=" + color + "]";
		}

	}
}
