package com.company;

import com.company.list.IteratorG;
import com.company.list.LinkedList;
import com.company.list.List;


public class Main {


	public static void main(String[] args) {

		List<Integer> lista1 = new LinkedList<>();
		List<String> lista2 = new LinkedList<>();
		List<Float> lista3 = new LinkedList<>();

		lista1.add(1);
		lista1.add(2);
		lista1.add(3);
		lista1.add(7);

		lista2.add("Hola");
		lista2.add("Object");
		lista2.add("Oriented");
		lista2.add("Programing");

		lista3.add(3.25F);
		lista3.add(2.90F);
		lista3.add(45.10F);
		lista3.add(90.29F);

		lista1.delete(3);

		System.out.println("---------------------");

		System.out.println("El tamaño es:" + lista1.getSize());

		IteratorG<Integer> it  = lista1.getIterator();

		while(it.hasNext()){
			int element = it.next();

			System.out.println("Dato: " + element);
		}


		System.out.println("---------------------");

		it = lista1.getIterator();

		while(it.hasNext()){
			int element = it.next();

			System.out.println("Dato: " + element);
		}

		System.out.println("---------------------");

		IteratorG<String> it2 = lista2.getIterator();
		System.out.println("El tamaño es: " + lista2.getSize()) ;
		while (it2.hasNext()){
			System.out.println("Dato:" + it2.next());
		}

		System.out.println("---------------------");

		it2 = lista2.getReverseIterator();

		while (it.hasNext()){
			String name = it2.next();

			System.out.println("Dato; " + name);
		}

		System.out.println("---------------------");

		IteratorG<Float> it3 = lista3.getIterator();
		System.out.println("El tamañ es: " + lista3.getSize());
		while (it3.hasNext()){
			System.out.println("Dato:" + it3.next());
		}

		System.out.println("---------------------");

		it3 = lista3.getIterator();
		while (it3.hasNext()){
			float date = it3.next();

			System.out.println("Dato" + date);
		}
	}
}
