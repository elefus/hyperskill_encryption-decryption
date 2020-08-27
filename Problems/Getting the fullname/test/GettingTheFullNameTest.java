import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class GettingTheFullNameTest {

    @Test
    public void fullName() {
        User user = new User();
        user.setFirstName("a");
        user.setLastName("b");

        assertThat(user.getFullName(), equalTo("a b"));
    }

    @Test
    public void onlyFirstName() {
        User user = new User();
        user.setFirstName("a");
        user.setLastName(null);

        assertThat(user.getFullName(), equalTo("a"));
    }

    @Test
    public void onlyLastName() {
        User user = new User();
        user.setFirstName(null);
        user.setLastName("b");

        assertThat(user.getFullName(), equalTo("b"));
    }

    @Test
    public void emptyFullName() {
        User user = new User();
        user.setFirstName(null);
        user.setLastName(null);

        assertThat(user.getFullName(), equalTo("Unknown"));
    }
}