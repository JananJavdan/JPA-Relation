package be.intecbrussel.service;

import be.intecbrussel.Main;
import be.intecbrussel.connection.EntityManagerProvider;
import be.intecbrussel.model.Customer;
import be.intecbrussel.model.Menu;
import be.intecbrussel.repository.RepositoryCustomer;
import be.intecbrussel.repository.RepositoryMenu;

import javax.persistence.EntityManager;
import java.util.Optional;

public class ServiceMenu {
    private RepositoryMenu repositoryMenu = new RepositoryMenu();

    public void createMenu(Menu menu) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        repositoryMenu.createMenu(entityManager, menu);
        entityManager.close();
    }

    public Optional<Menu> findUser(int id) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        Optional<Menu> menu = repositoryMenu.findMenu(entityManager, id);
        entityManager.close();
        return menu;
    }

    public void updateMenu(Menu menu) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        int menuId = menu.getId();
        Optional<Menu> optionalMenu = repositoryMenu.findMenu(entityManager, menuId);
        if (optionalMenu.isEmpty()) {
            entityManager.close();
            return;
        }
    }
    public void deleteMenu(int id)
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        Optional<Menu> menu = repositoryMenu.findMenu(entityManager,id);
        if(menu.isPresent()) {
            repositoryMenu.deleteMenu(entityManager,menu.get());
        }
        else {
            System.out.println("not found");
        }
        entityManager.close();
    }
}
