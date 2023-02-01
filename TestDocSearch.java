import static org.junit.Assert.*;
import org.junit.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;

public class TestDocSearch {
	@Test 
	public void testIndex() throws URISyntaxException, IOException {
    Handler h = new Handler("./written_2/");
    URI rootPath = new URI("http://localhost/");
    assertEquals("There are 224 total files to search.", h.handleRequest(rootPath));
	}
	@Test 
	public void testSearch() throws URISyntaxException, IOException {
    Handler h = new Handler("./written_2/");
    URI rootPath = new URI("http://localhost/search?q=sushi");
    String expect = "Found 3 paths:\n.\\written_2\\travel_guides\\berlitz1\\WhatToJapan.txt\n.\\written_2\\travel_guides\\berlitz1\\WhereToJapan.txt\n.\\written_2\\travel_guides\\berlitz2\\California-WhereToGo.txt";
    assertEquals(expect, h.handleRequest(rootPath));
	}
    @Test 
	public void test1Search() throws URISyntaxException, IOException {
    Handler h = new Handler("./written_2/");
    URI rootPath = new URI("http://localhost/search?q=portugal");
    // String expect = "Found 1 paths:\n./written_2/travel_guides/berlitz2/Portugal-WhatToDo.txt";
    String expect = "Found 1 paths:\n.\\written_2\\travel_guides\\berlitz2\\Portugal-WhatToDo.txt";
    assertEquals(expect, h.handleRequest(rootPath));
	}
    @Test 
	public void test0Search() throws URISyntaxException, IOException {
    Handler h = new Handler("./written_2/");
    URI rootPath = new URI("http://localhost/search?q=helloworld");
    String expect = "Found 0 paths:\n";
    assertEquals(expect, h.handleRequest(rootPath));
	}
}

