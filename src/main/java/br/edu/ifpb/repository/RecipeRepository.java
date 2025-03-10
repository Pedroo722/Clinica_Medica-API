package br.edu.ifpb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.ifpb.model.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}