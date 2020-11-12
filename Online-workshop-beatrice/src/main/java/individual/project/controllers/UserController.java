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
    public User getUserByEmail(String email) {
        List<User> users = showAllUsers();
        for (User u :users) {
            if(u.getEmail().equals(email)){
                return u;
            }
        }
        return null;
    }
    public void deleteUser(int id) {
        try {
            usersRepository.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean login(String email, String password){
        User u = getUserByEmail(email);
        if(u == null){
            return false;
        }
        if(u.getPassword().equals(password)){
            return true;
        }
        return false;
    }

    public boolean validateUser(String email, String password, String role){
        User u = getUserByEmail(email);
        if(u == null){
            return false;
        }
        if(u.getPassword().equals(password)){
            if(u.getRole().toString().equals(role)){
                return true;
            }
        }else{
            return false;
        }
        return false;
    }
}
