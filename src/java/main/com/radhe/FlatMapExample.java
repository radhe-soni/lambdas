package com.radhe;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.radhe.Node.NodeBuilder;

public class FlatMapExample {

	public static void main(String[] args) {
		Tree tree = Tree.builder().root(Node.of(0)).build();
		tree.root.data = 0;
		int[] arrInt = { 1, 2, 3, 4, 5 };
		Arrays.stream(arrInt).forEach(i -> tree.root.addChild(Node.of(i)));
		int[] arrInt2 = { 6, 7, 8 };
		tree.root.children.stream().filter(n -> n.data % 2 == 0)
				.forEach(n -> Arrays.stream(arrInt2).forEach(i -> n.addChild(Node.of(i))));
		System.out.println(tree);
		List<Integer> list = tree.root.children.stream()
				.flatMap(i -> Stream.concat(Stream.of(i), i.children.stream()))
				.map(i -> i.data).collect(Collectors.toList());
		System.out.println(list);

	}
}
