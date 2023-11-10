package com.vw.pack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamExampleEnum {

	public static void main(String[] args) {
		List<Product> prodList = Arrays.asList(
				new Product("Laptop", 50000, Category.ELECTRONICS),
				new Product("Shirt", 500, Category.CLOTHING), 
				new Product("Book", 50, Category.BOOKS),
				new Product("Smartphone", 10000, Category.ELECTRONICS), 
				new Product("Dress", 800, Category.CLOTHING),
				new Product("Kuthis", 700, Category.CLOTHING), 
				new Product("JavaBook", 40, Category.BOOKS)

		);
		System.out.println(prodList);

		// GROUP products by category
		Map<Category, List<Product>> prodByCategory = prodList.stream()
				.collect(Collectors.groupingBy(Product::getCategory));
		System.out.println("prodByCategory " + prodByCategory);

		// Averge price of the product in each category
		Map<Category, Double> priceInEachCategory = prodList.stream()
				.collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));
		System.out.println("priceInEachCategory " + priceInEachCategory);

		Product mostExpensiveProduct = prodList.stream().max((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()))
				.orElse(null);
		System.out.println("mostExpensiveProduct " + mostExpensiveProduct);

		List<Product> prodUnder1000 = prodList.stream().filter(products -> products.getPrice() < 1000)
				.collect(Collectors.toList());
		System.out.println("prodUnder1000 " + prodUnder1000);

		List<Product> prodWithMinPriceInClothCategory = prodList.stream()
				.filter(products -> products.getCategory() == Category.CLOTHING && products.getPrice() < 800)
				.collect(Collectors.toList());
		System.out.println("prodWithMinPriceInClothCategory " + prodWithMinPriceInClothCategory);

		List<Category> uniqueCategories = prodList.stream().map(Product::getCategory).distinct()
				.collect(Collectors.toList());
		System.out.println("uniqueCategories " + uniqueCategories);

		// Sum of price of the product in each category
		Map<Category, Double> sumofPriceInEachCategory = prodList.stream()
				.collect(Collectors.groupingBy(Product::getCategory, 
						Collectors.summingDouble(Product::getPrice)));
		System.out.println("sumofPriceInEachCategory " + sumofPriceInEachCategory);
		
		//Sort in Ascending order
		List<Product>  prodSortedByPrice = prodList.stream()
				.sorted((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()))
				.collect(Collectors.toList());
		System.out.println("prodSortedByPrice " + prodSortedByPrice);
		
		//Sort in Descending order
		List<Product>  prodSortedByPricedesc = prodList.stream()
				.sorted((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()))
				.collect(Collectors.toList());
		System.out.println("prodSortedByPricedesc " + prodSortedByPricedesc);
		

		// Most Expensive product in each category
		Map<Category, Product> expensiveProdInEachCategory = prodList.stream()
				
				.collect(Collectors.groupingBy(Product::getCategory, 
				Collectors.collectingAndThen(
				Collectors.maxBy((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice())), pr -> pr.orElse(null))));
		System.out.println("expensiveProdInEachCategory " + expensiveProdInEachCategory);
	}

}
