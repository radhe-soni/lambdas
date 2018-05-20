package com.radhe;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Node {

	public int data;
	@Builder.Default
	public List<Node> children = new ArrayList<>(0);
	
	public Node addChild(Node node)
	{
		children.add(node);
		return this;
	}
	
	public static Node of(int data)
	{		
		return Node.builder().data(data).build();
	}
}
