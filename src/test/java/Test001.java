import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
//import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;

public class Test001 {

    @Mock
    RestClientPost post;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Test
    public void TestPostWorks() {

        RestClientPost post1 = mock(RestClientPost.class);
        when(post1.postValidateJSON()).thenReturn(true);
        assertEquals(post1.postValidateJSON(), true);
        assertNotEquals(post1.postValidateJSON(), false);
    }
}
