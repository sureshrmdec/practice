package com.practice.algo.and.ds.java8;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Java8 {

	public static void main(String[] args) {
		File[] hiddenFiles = new File(".").listFiles(File::isDirectory);

		Apple a = new Apple("red", 160);
		Apple b = new Apple("green", 160);
		Apple c = new Apple("grasccsdeen", 140);
		List<Apple> apples = new ArrayList<>();
		apples.add(a);
		apples.add(b);
		apples.add(c);

		System.out.println("---------Now Function (Method Body)--------------------------");
		filterApplesFun(apples, Apple.appleColorFun);
		filterApplesFun(apples, Apple.appleWeightFun);

		/*-----------------------------------------------------------
		-----------------------------------------------------------
		Above two functions appleColorFun and appleWeightFun are written using Function interface. They are functional interface imple-
		mentation and so having only method. Its best practice to use Predicate here which is also Function interface. 
		Advantage of using Predicate is we dont need to use Boolean in <>.So lets try below
		*
		*/
		System.out.println("---------Now Predicate (Method Body)--------------------------");
		filterApplesPre(apples, Apple.appleColorPre);
		filterApplesPre(apples, Apple.appleWeightPre);
		/*-----------------------------------------------------------
		-----------------------------------------------------------
		Above two functions appleColorPre and appleWeightPre are written using Predicate interface. They are functional interface imple-
		mentation and so having only method. You dont need to define Function or Predicate body, you can use anonymous functions or 
		Lambdas) as they say. Following are the example.
		NOTE: Both filterApplesPre and filterApplesFun works with same lambdas.
		*
		*/
		System.out.println("---------Now Predicate Lambdas (No body) --------------------------");
		filterApplesPre(apples, p -> ("green".equals(p.color)));
		filterApplesPre(apples, p -> (p.weight > 150));

		System.out.println("---------Now Function Lambdas (No body) --------------------------");
		filterApplesFun(apples, p -> ("green".equals(p.color)));
		filterApplesPre(apples, p -> (p.weight > 150));

		System.out.println("---------BiFunction (No Body) --------------------------");
		multiply((x, y) -> {return (x * y);});
		
		System.out.println("---------Consumer<T> Functional Interface (No Body)--------------------------");
		apples.forEach(e -> System.out.println(e));

		System.out.println("---------Consumer<T> Functional Interface (With Body)--------------------------");
		apples.forEach(Apple.appleConsumer);
		
		System.out.println("---------Function<T> Functional Interface (With Body) and Consumer<T> (No Body) --------------------------");
		apples.stream().map(Apple.appleFunction).forEach(e -> System.out.println(e));
		apples.stream().map(e->  {return e.color;}).forEach(cc -> {System.out.println(cc.toUpperCase());});
		apples.stream().map(e->  {return e.color;}).forEach(String::toUpperCase);
		
		/*
		Java 8 brings a specialized version of the functional interfaces we described earlier in order to avoid autoboxing operations when
		the inputs or outputs are primitives. For example, in the following code, using an IntPredicate avoids a boxing operation of the
		value 1000, whereas using a Predicate<Integer> would box the argument 1000 to an Integer object:
		*/
		
	}

	private static void multiply(BiFunction<Integer, Integer, Integer> appleFun) {
		System.out.println(appleFun.apply(2, 3));
	}

	private static void filterApplesFun(List<Apple> apples, Function<Apple, Boolean> appleFun) {
		for (Apple aa : apples) {
			if (appleFun.apply(aa)) {
				System.out.println(aa.color + " " + aa.weight);
			}
		}
	}

	private static void filterApplesPre(List<Apple> apples, Predicate<Apple> applePre) {
		for (Apple aa : apples) {
			if (applePre.test(aa)) {
				System.out.println(aa.color + " " + aa.weight);
			}
		}
	}

}

class Apple {
	public Apple(String color, Integer weight) {
		super();
		this.color = color;
		this.weight = weight;
	}

	String color;
	Integer weight;

	static Function<Apple, Boolean> appleColorFun = new Function<Apple, Boolean>() {

		@Override
		public Boolean apply(Apple arg0) {
			// TODO Auto-generated method stub
			return "green".equals(arg0.color);
		}
	};

	static Function<Apple, Boolean> appleWeightFun = new Function<Apple, Boolean>() {

		@Override
		public Boolean apply(Apple arg0) {
			// TODO Auto-generated method stub
			return arg0.weight > 150;
		}
	};

	static Predicate<Apple> appleColorPre = new Predicate<Apple>() {
		@Override
		public boolean test(Apple t) {
			// TODO Auto-generated method stub
			return "green".equals(t.color);
		}
	};
	static Predicate<Apple> appleWeightPre = new Predicate<Apple>() {
		@Override
		public boolean test(Apple t) {
			// TODO Auto-generated method stub
			return t.weight > 150;
		}
	};
	
	static Consumer<Apple> appleConsumer = new Consumer<Apple>() {
		@Override
		public void accept(Apple t) {
			// TODO Auto-generated method stub
			System.out.println(t.toString());
		}
	};
	
	static Function<Apple,Integer> appleFunction = new Function<Apple,Integer>() {
		@Override
		public Integer apply(Apple t) {
			// TODO Auto-generated method stub
			return t.weight;
		}
	};
	
	@Override
	public String toString() {
		return this.color +" "+this.weight;
	};

}