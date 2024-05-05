package be.intecbrussel.connection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvider {
    private static final String PERSISTENCE_UNIT_NAME = "JPA-Relation";
    private static EntityManagerFactory entityManagerFactory;
    public static EntityManagerFactory getEntityManagerFactory(){
        if (entityManagerFactory == null){
            entityManagerFactory =
                    Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return entityManagerFactory;
    }
    public static EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
    public static void shutdown(){
        if (entityManagerFactory != null){
            entityManagerFactory.close();
        }
    }
}
