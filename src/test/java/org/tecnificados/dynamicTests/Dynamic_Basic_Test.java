package org.tecnificados.dynamicTests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

/**
 * @author Juan Carlos Ballesteros (tecnificados.com)
 *
 */

public class Dynamic_Basic_Test {

	
	@TestFactory
	Stream<DynamicNode> dynamicTestsFromCollection() {
		return Stream.of(getData())
				.map(number -> DynamicContainer.dynamicContainer("True or False Test" + number, Stream.of(
						DynamicTest.dynamicTest("is  " + number + " true?", () -> assertTrue(Util.checkOne(number))),
						DynamicTest.dynamicTest("is  " + number + " false?", () -> assertFalse(Util.checkOne(number))))));
	}

	private Integer[] getData() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(0);
		list.add(1);
		Integer[] array = list.toArray(new Integer[0]);
		return array;
	}

	

}
