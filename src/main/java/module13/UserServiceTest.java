package module13;

import module13.models.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;

public class UserServiceTest {
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {

        System.out.println("\n+++++++++++++++ TASK 1 +++++++++++++++");
        System.out.println("\n+++++++++++++++ METHOD 1 (POST) +++++++++++++++");
        Optional<User> createdUser = UserService.createUser(getTestUser());
        createdUser.ifPresent(System.out::println);

        System.out.println("\n\n\n+++++++++++++++ METHOD 2 (PUT) +++++++++++++++");
        Optional<User> userByIdToUpdate = UserService.getUserById(9);
        if (userByIdToUpdate.isPresent()) {
            User userToUpdate = userByIdToUpdate.get();
            userToUpdate.setUsername("qwertyuiop");
            Optional<User> updatedUser = UserService.updateUser(userToUpdate);
            updatedUser.ifPresent(System.out::println);
        } else {
            System.out.println("User with this ID not found");
        }

        System.out.println("\n\n\n+++++++++++++++ METHOD 3 (DELETE) +++++++++++++++");
        System.out.println(UserService.deleteUser(2));

        System.out.println("\n\n\n+++++++++++++++ METHOD 4 (GET all Users) +++++++++++++++");
        System.out.println(UserService.getAllUsers());

        System.out.println("\n\n\n+++++++++++++++ METHOD 5 (GET User by id) +++++++++++++++");
        Optional<User> userById = UserService.getUserById(4);
        userById.ifPresentOrElse(System.out::println, () -> System.out.println("User with this ID not found"));

        System.out.println("\n\n\n+++++++++++++++ METHOD 6 (GET User by username) +++++++++++++++");
        System.out.println(UserService.getUserByUsername("Antonette"));

        System.out.println("\n\n\n+++++++++++++++ TASK 2 (Comments of user's last post)+++++++++++++++");
        System.out.println(UserService.getCommentsOfUsersLastPost(9));

        System.out.println("\n\n\n+++++++++++++++ TASK 3 (All user's uncompleted tasks)+++++++++++++++");
        System.out.println(UserService.getUncomletedTasks(6));
    }

    private static User getTestUser() {
        User user = new User();
        user.setName("Test");
        user.setUsername("Test");
        user.setEmail("Test");
        user.setPhone("test");
        user.setWebsite("Test");
        Address address = new Address();
        address.setStreet("Test");
        address.setCity("test");
        address.setSuite("test");
        address.setZipcode("test");
        Geo geo = new Geo();
        geo.setLat(-34.111);
        geo.setLng(34.034);
        address.setGeo(geo);
        user.setAddress(address);
        Company company = new Company();
        company.setBs("test");
        company.setName("test");
        company.setCatchPhrase("test");
        user.setCompany(company);
        return user;
    }
}
