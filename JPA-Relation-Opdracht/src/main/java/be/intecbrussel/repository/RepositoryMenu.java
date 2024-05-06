package be.intecbrussel.repository;

import be.intecbrussel.model.Customer;
import be.intecbrussel.model.Menu;

import javax.persistence.EntityManager;
import java.util.Optional;

public class RepositoryMenu {
    public void createMenu(EntityManager entityManager, Menu menu) {
        entityManager.getTransaction().begin();
        entityManager.merge(menu);
        entityManager.getTransaction().commit();
}
public Optional<Menu> findMenu(EntityManager entityManager, int id) {
    Menu optionalMenu = entityManager.find(Menu.class, id);
    return Optional.ofNullable(optionalMenu);
}

public void updateMenu(EntityManager entityManager, Menu menu) {
    entityManager.getTransaction().begin();
    entityManager.merge(menu);
    entityManager.getTransaction().commit();
}

public void deleteMenu(EntityManager entityManager, Menu menu) {
    entityManager.getTransaction().begin();
    entityManager.remove(menu);
    System.out.println("deleted");
    entityManager.getTransaction().commit();
}
}
