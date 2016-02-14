
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;




@RunWith(Parameterized.class)

public class junit_test {

private String name;
private String age;

public junit_test(String name, String age) {
			
	this.name = name;
	this.age = age;
	}

@Test
public void test(){
	System.out.println("My name is: " + name + " and my age is: " + age);
}

@Parameters
public static Collection<Object[]> Jamesfamily(){
	Object[][] amins = new Object[3][2];
	amins[0][0] = "James";
	amins[0][1] = "37";
	amins[1][0] = "Annie";
	amins[1][1] = "42";
	amins[2][0] = "Jane";
	amins[2][1] = "6";
	
	return Arrays.asList(amins);	
	
}

}


