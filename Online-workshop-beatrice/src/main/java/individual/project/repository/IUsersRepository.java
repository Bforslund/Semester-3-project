package individual.project.repository;

import individual.project.model.User;

import java.util.List;

public interface IUsersRepository {
    List<User> getUsers() throws Exception;

    User getUserById(int id) throws Exception;

    void create(User user) throws Exception;

    void update(User u) throws Exception;

    void delete(int id) throws Exception;
}
