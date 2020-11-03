package individual.project.controllers;

import individual.project.model.User;
import individual.project.repository.HibernateUsersRepository;

import java.util.List;

public class UserController {
    HibernateUsersRepository usersRepository = new HibernateUsersRepository();

    public List<User> showAllUsers() {
      List<User> items;
        try {
            items = usersRepository.getUsers();
           return items;
        } catch (Exception e) {
            e.printStackTrace();
        }
      return null;
    }
   public boolean addUser(User u) {
        try {
            usersRepository.create(u);
            System.out.println("Created user: " + u);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean updateUser(User u) {
        try {
            usersRepository.update(u);
            System.out.println("Updated user: " + u);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public User getUserById(int id) {
        try {
           User u = usersRepository.getUserById(id);
            return u;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public void deleteUser(int id) {
        try {
            usersRepository.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
