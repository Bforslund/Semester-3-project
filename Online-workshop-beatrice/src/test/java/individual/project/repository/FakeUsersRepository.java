package individual.project.repository;

import individual.project.model.User;

import java.util.ArrayList;
import java.util.List;

public class FakeUsersRepository implements IUsersRepository {
    List<User> userList = new ArrayList<>();
    public FakeUsersRepository(){
        User u = new User("Beatrice", "Forslund", "Nijmegen", "1999-10-21", "Bea@gmail.com", "81dc9bdb52d04dc20036dbd8313ed055");
        User u2 = new User("Rafayel", "Teacher", "Eindhoven", "1989", "Rafayel@gmail.com", "81dc9bdb52d04dc20036dbd8313ed055");
        User u3 = new User("Rawan", "Dehn", "Breda", "1996-05-3", "Rawan@gmail.com", "81dc9bdb52d04dc20036dbd8313ed055");
        u.setId(1);
        u2.setId(2);
        u3.setId(3);
        userList.add(u);
        userList.add(u2);
        userList.add(u3);

    }

    @Override
    public List<User> getUsers() throws Exception {
        return userList;
    }

    @Override
    public User getUserById(int id) throws Exception {
        for (User u:userList) {
        if(u.getId() == id){
            return u;
                            }
        }
        return null;
    }

    @Override
    public void create(User user) throws Exception {

    }

    @Override
    public void update(User u) throws Exception {

    }

    @Override
    public void delete(int id) throws Exception {

    }
}
