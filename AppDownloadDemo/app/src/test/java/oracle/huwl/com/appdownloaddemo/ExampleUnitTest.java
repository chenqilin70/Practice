package oracle.huwl.com.appdownloaddemo;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        File f1=new File("D:/tempFile/");
        f1=new File(f1,"/kylinChen");
        System.out.print(f1.getAbsolutePath());
    }
}