package br.com.crescer.aula04;

import java.util.List;

/**
 *
 * @author chris
 */
public interface CrudDao<Entity, ID> {
    
    Entity save(Entity e);

    void remove(Entity e);

    Entity loadById(ID id);

    List<Entity> findAll();
    
}

